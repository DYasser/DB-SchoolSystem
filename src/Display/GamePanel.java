package Display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JPanel;

import Handlers.KeyHandler;
import Handlers.MouseHandler;
import States.AddStudent;
import States.AddTeacher;
import States.Admin;
import States.AdminMainPage;
import States.CheckCourses;
import States.CheckStudents;
import States.CheckTeachers;
import States.Courses;
import States.Exams;
import States.Grade;
import States.Help;
import States.MainMenu;
import States.ModifyStudent;
import States.ModifyTeacher;
import States.RemoveStudent;
import States.RemoveTeacher;
import States.Schedule;
import States.Student;
import States.StudentExam;
import States.StudentFees;
import States.StudentMenu;
import States.Teacher;
import States.TeacherMenu;

public class GamePanel extends JPanel implements Runnable{

	//Static variables
	public boolean[] box = new boolean[50];
	public boolean[] clicked = new boolean[20];
	public boolean[] choice = new boolean[20];
	public String[] remark = new String[8];
	public String[] grad = new String[8];
	public boolean exitBox = false, wrong = false, added = false;;
	public int selected = 1;
	public String username = "", password = "", pswd = "", path2 = "";
	public String name = "", major = "", path = "", level = "", stuId = "", tot = "", answer = "", answers = "";
	public String schoolF= "", dormF = "", otherF = "", classOf = "", day = "", month = "", year = "";
	
	public String salary = "", subject = "", subid = "";
	public float scholarship = 0f;
	public int page = 0;
	public boolean imgs = false;
	public double grade = 0;
	
	private Connection con;
	public Color dark = new Color(33, 30, 39);
	public Color light2 = new Color(130, 172, 214);
	public Color light = new Color(74, 135, 196);
	public Color color = dark;
	
	//All game states AKA screens
	public static enum STATES
	{
		MAINMENU,
		ADMIN,
		ADMAINPAGE,
		ADDTEACHER,
		ADDSTUDENT,
		CHECKSTUDENTS,
		CHECKTEACHERS,
		MODIFYTEACHER,
		MODIFYSTUDENT,
		REMOVETEACHER,
		REMOVESTUDENT,
		SCHEDULE,
		TEACHER,
		TEACHERMENU,
		CHECKCOURSES,
		GRADE,
		INPUTEXAM,
		STUDENT,
		STUDENTMENU,
		COURSES,
		FEES,
		EXAMS,
		HELP;
	}
	
	//Essentials
	MouseHandler mouse;
	KeyHandler key;
	
	//Screens
	MainMenu main;
	Admin admin;
	AdminMainPage admainpage;
	AddTeacher addT;
	AddStudent addS;
	CheckStudents checkS;
	RemoveStudent remS;
	ModifyStudent modS;
	CheckTeachers checkT;
	RemoveTeacher remT;
	ModifyTeacher modT;
	Schedule sch;
	Student stu;
	StudentMenu stuM;
	Courses courses;
	StudentFees fee;
	Teacher tea;
	TeacherMenu teaM;
	CheckCourses checkC;
	Exams exams;
	StudentExam exam;
	Grade grades;
	Help help;
	
	//Graph variables + thread
	public STATES state = STATES.MAINMENU;
	
	public Font font = new Font("Monospaced", Font.BOLD, 30);
	public static int width, height;
	public BufferStrategy bs;
	public BufferedImage img;
	public Thread thread;
	public Graphics2D g;

    //GameLoop variables
    public static int oldFrameCount;
    public static int oldTickCount;
    private boolean running = false;
	
	public GamePanel(BufferStrategy bs, int width, int height) { 	//Create the Window
        GamePanel.width = width;
        GamePanel.height = height;
        this.bs = bs;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify() {	//Start the thread
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }

    public void init() throws ClassNotFoundException, SQLException{	//Initialize everything 
        running = true;
        
		mouse = new MouseHandler(this);
        addMouseListener(mouse);
        key = new KeyHandler(this);
        addKeyListener(key);
        
        main = new MainMenu(this);
        admin = new Admin(this);
        admainpage = new AdminMainPage(this);
        addT = new AddTeacher(this);
        addS = new AddStudent(this);
        checkS = new CheckStudents(this);
        remS = new RemoveStudent(this);
        modS = new ModifyStudent(this);
        checkT = new CheckTeachers(this);
        remT = new RemoveTeacher(this);
        modT = new ModifyTeacher(this);
        sch = new Schedule(this);
        stu = new Student(this);
        stuM = new StudentMenu(this);
        courses = new Courses(this);
        fee = new StudentFees(this);
        tea = new Teacher(this);
        teaM = new TeacherMenu(this);
        checkC = new CheckCourses(this);
        exams = new Exams(this);
        exam = new StudentExam(this);
        grades = new Grade(this);
        help = new Help(this);
        
        initGraphics();
    }

	@Override
	public void run() {
		try {
			init();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        final double GAME_HERTZ = 64.0;
        final double TBU = 1000000000 / GAME_HERTZ; // Time Before Update

        final int MUBR = 3; // Must Update before render

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS = 1000;
        final double TTBR = 1000000000 / TARGET_FPS; // Total time before render

        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1000000000);
        oldFrameCount = 0;
        oldTickCount = 0;

        while (running) {

            double now = System.nanoTime();
            int updateCount = 0;
            while (((now - lastUpdateTime) > TBU) && (updateCount < MUBR)) {
                update();
                lastUpdateTime += TBU;
                updateCount++;
            	}

            if ((now - lastUpdateTime) > TBU) {
                lastUpdateTime = now - TBU;
            	}
            
            render();
            lastRenderTime = now;
            frameCount++;

            int thisSecond = (int) (lastUpdateTime / 1000000000);
            if (thisSecond > lastSecondTime) {
                if (frameCount != oldFrameCount) {
                    //System.out.println("SECOND " + thisSecond + " " + frameCount);
                    oldFrameCount = frameCount;
                	}

                frameCount = 0;
                lastSecondTime = thisSecond;
            	}

            while (now - lastRenderTime < TTBR && now - lastUpdateTime < TBU) {
                Thread.yield();

                try {
                    Thread.sleep(1);
                	} catch (Exception e) {
                    System.out.println("ERROR: yielding thread");
                	}

                now = System.nanoTime();
            	}	
        	}
	}
	
	public void update()
	{
		//System.out.println(selected);
		mouse.update();
		switch(state) 
		{
		case MAINMENU:
			main.update();
			break;
		case ADMIN:
			admin.update();
			break;
		case ADMAINPAGE:
			admainpage.update();
			break;
		case ADDTEACHER:
			addT.update();
			break;
		case ADDSTUDENT:
			addS.update();
			break;
		case CHECKSTUDENTS:
			checkS.update();
			break;
		case CHECKTEACHERS:
			checkT.update();
			break;
		case REMOVESTUDENT:
			remS.update();
			break;
		case REMOVETEACHER:
			remT.update();
			break;
		case MODIFYSTUDENT:
			modS.update();
			break;
		case MODIFYTEACHER:
			modT.update();
			break;
		case SCHEDULE:
			sch.update();
			break;
		case STUDENT:
			stu.update();
			break;
		case STUDENTMENU:
			stuM.update();
			break;
		case COURSES:
			courses.update();
			break;
		case FEES:
			fee.update();
			break;
		case TEACHER:
			tea.update();
			break;
		case TEACHERMENU:
			teaM.update();
			break;
		case CHECKCOURSES:
			checkC.update();
			break;
		case INPUTEXAM:
			exams.update();
			break;
		case EXAMS:
			exam.update();
			break;
		case GRADE:
			grades.update();
			break;
		case HELP:
			help.update();
			break;
		}
	}
	
	
	public void render()
	{
		if (g != null) {
            //g.setColor(new Color(33, 30, 39));
            g.setColor(color);
            g.fillRect(0, 0, width, height);
            }

		switch(state)
		{
		case MAINMENU:
			main.render(g);
			break;
		case ADMIN:
			admin.render(g);
			break;
		case ADMAINPAGE:
			admainpage.render(g);
			break;
		case ADDTEACHER:
			addT.render(g);
			break;
		case ADDSTUDENT:
			addS.render(g);
			break;
		case CHECKSTUDENTS:
			checkS.render(g);
			break;
		case CHECKTEACHERS:
			checkT.render(g);
			break;
		case REMOVESTUDENT:
			remS.render(g);
			break;
		case REMOVETEACHER:
			remT.render(g);
			break;
		case MODIFYSTUDENT:
			modS.render(g);
			break;
		case MODIFYTEACHER:
			modT.render(g);
			break;
		case SCHEDULE:
			sch.render(g);
			break;
		case STUDENT:
			stu.render(g);
			break;
		case STUDENTMENU:
			stuM.render(g);
			break;
		case COURSES:
			courses.render(g);
			break;
		case FEES:
			fee.render(g);
			break;
		case TEACHER:
			tea.render(g);
			break;
		case TEACHERMENU:
			teaM.render(g);
			break;
		case CHECKCOURSES:
			checkC.render(g);
			break;
		case INPUTEXAM:
			exams.render(g);
			break;
		case EXAMS:
			exam.render(g);
			break;
		case GRADE:
			grades.render(g);
			break;
		case HELP:
			help.render(g);
			break;
		}
		
    	do {
            Graphics g2 = (Graphics2D) bs.getDrawGraphics();
            g2.drawImage(img, 3, 26, width + 10, height + 10, null);
            g2.dispose();
            bs.show();
        	} while(bs.contentsLost());
	}
	
    public void initGraphics() {	//Graphics
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) img.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
}
