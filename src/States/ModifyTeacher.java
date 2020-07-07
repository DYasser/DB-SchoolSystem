package States;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Display.GamePanel;

public class ModifyTeacher {
	GamePanel game;
	
	private  String[] id = new String[8];
	private  String[] name = new String[8];
	private  String[] salary = new String[8];
	private  String[] path = new String[8];
	private  String[] day = new String[8];
	private  String[] month = new String[8];
	private  String[] year = new String[8];
	private  String[] subj = new String[8];
	private Image[] image = new Image[8];
	private BufferedImage[] img = new BufferedImage[8];
	private int x = -1;
	private int maxP = 9;
	private boolean breaking = false;
	
	public ModifyTeacher(GamePanel game) {
		this.game = game;
		
		int c = 0;
		String myDriver = "com.mysql.cj.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/whusystem";
		try {
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			
			String query = "SELECT * FROM teacher";
	      	Statement ps2 = conn.createStatement();
	      	ResultSet rs = ps2.executeQuery(query);
			while(rs.next())
	      	{c++;}
			if(c%8 == 0)
				maxP = c/8-1;
			else
			{
				maxP = c/8;
			}
		} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(Color.white);
		g.setFont(game.font.deriveFont(55f));
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.drawString("Modify a Teacher", 250, 60);

		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .1f));
		g.fillRect(150, 90, 750, 400);	//form

		if(game.selected<0 || game.selected >7)
		{
			if(game.box[0]) 
				g.fillRect(170, 150, 720, 37);//0
			if(game.box[1])
				g.fillRect(170, 190, 720, 37);//1
			if(game.box[2])
				g.fillRect(170, 230, 720, 37);//2
			if(game.box[3])
				g.fillRect(170, 270, 720, 37);//3
			if(game.box[4])
				g.fillRect(170, 310, 720, 37);//4
			if(game.box[5])
				g.fillRect(170, 350, 720, 37);//5
			if(game.box[6])
				g.fillRect(170, 390, 720, 37);//6
			if(game.box[7])
				g.fillRect(170, 430, 720, 37);//7
			if(game.box[8]) 
				g.fillRect(425, 510, 35, 35);//-
			if(game.box[9])
				g.fillRect(550, 510, 35, 35);//+
			if(game.exitBox)
			g.fillRect(25, 25, 90, 40);		//Back
		}
		
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.setFont(game.font.deriveFont(20f));
		g.drawRect(150, 90, 750, 400);	//form
		g.drawString("Back", 48, 50);
		g.drawRect(25, 25, 90, 40);	//back
		g.drawRect(425, 510, 35, 35);	//--
		g.drawRect(550, 510, 35, 35);	//++
		g.drawString("<", 437, 533);	//--
		g.drawString(">", 562, 533);	//++
		
		if(game.page > maxP)
		{
			game.page = maxP;
		}

		g.drawString(game.page+1 + "/" + (maxP+1), 490, 535 );
		
		g.drawString("Full Name", 360, 130);
		g.drawString("Teacher ID", 610, 130);
		g.drawString("Salary", 800, 130);

		g.drawLine(575, 140, 575, 470);
		g.drawLine(770, 140, 770, 470);
		
		
		try {
			
			// create a mysql database connection
			String myDriver = "com.mysql.cj.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/whusystem";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			
			String query = "SELECT * FROM teacher";
	      	Statement ps2 = conn.createStatement();
	      	ResultSet rs = ps2.executeQuery(query);
	      	int count = 0;
	      	
	      	if(game.page < 0)
	      	{
	      		game.page = 0;
	      	}
	      	
	      	if(game.page > maxP)
	      	{
	      		game.page = maxP;
	      	}
	      	
			if(x!= game.page)
			{
				x = game.page;			
		      	for(int i = 0; i < 8; i++)
		      	{
		  			id[i] = "";
		  			salary[i] = "";
		  			path[i] = "";
		  			name[i] = "";
		  			subj[i] = "";
		  			image[i] = null;
		      	}

		      	game.imgs = true;
		      	breaking = false;
	      	}
	      	
	      	while(rs.next() && !breaking)
	      	{
	      		count++;
	      		if(count == 1+8*game.page) {
	      			id[0] = rs.getString("id");
	      			name[0] = rs.getString("name");
	      			day[0] = rs.getString("day");
	      			month[0] = rs.getString("month");
	      			year[0] = rs.getString("year");
	      			salary[0] = rs.getString("salary");
	      			path[0] = rs.getString("path");
	      			subj[0] = rs.getString("subject");
	      		}
	      		if(count == 2+8*game.page) {
	      			id[1] = rs.getString("id");
	      			salary[1] = rs.getString("salary");
	      			name[1] = rs.getString("name");
	      			path[1] = rs.getString("path");
	      			day[1] = rs.getString("day");
	      			month[1] = rs.getString("month");
	      			subj[1] = rs.getString("subject");
	      			year[1] = rs.getString("year");}
	      		if(count == 3+8*game.page) {
	      			id[2] = rs.getString("id");
	      			salary[2] = rs.getString("salary");
	      			name[2] = rs.getString("name");
	      			path[2] = rs.getString("path");
	      			day[2] = rs.getString("day");
	      			month[2] = rs.getString("month");
	      			subj[2] = rs.getString("subject");
	      			year[2] = rs.getString("year");}
	      		if(count == 4+8*game.page) {
	      			id[3] = rs.getString("id");
	      			salary[3] = rs.getString("salary");
	      			name[3] = rs.getString("name");
	      			path[3] = rs.getString("path");
	      			day[3] = rs.getString("day");
	      			month[3] = rs.getString("month");
	      			subj[3] = rs.getString("subject");
	      			year[3] = rs.getString("year");}
	      		if(count == 5+8*game.page) {
	      			id[4] = rs.getString("id");
	      			salary[4] = rs.getString("salary");
	      			name[4] = rs.getString("name");
	      			path[4] = rs.getString("path");
	      			day[4] = rs.getString("day");
	      			month[4] = rs.getString("month");
	      			subj[4] = rs.getString("subject");
	      			year[4] = rs.getString("year");}
	      		if(count == 6+8*game.page) {
	      			id[5] = rs.getString("id");
	      			salary[5] = rs.getString("salary");
	      			name[5] = rs.getString("name");
	      			path[5] = rs.getString("path");
	      			day[5] = rs.getString("day");
	      			month[5] = rs.getString("month");
	      			subj[5] = rs.getString("subject");
	      			year[5] = rs.getString("year");}
	      		if(count == 7+8*game.page) {
	      			id[6] = rs.getString("id");
	      			salary[6] = rs.getString("salary");
	      			name[6] = rs.getString("name");
	      			path[6] = rs.getString("path");
	      			day[6] = rs.getString("day");
	      			month[6] = rs.getString("month");
	      			subj[6] = rs.getString("subject");
	      			year[6] = rs.getString("year");}
	      		if(count == 8+8*game.page) {
	      			id[7] = rs.getString("id");
	      			salary[7] = rs.getString("salary");
	      			name[7] = rs.getString("name");
	      			path[7] = rs.getString("path");
	      			day[7] = rs.getString("day");
	      			month[7] = rs.getString("month");
	      			subj[7] = rs.getString("subject");
	      			year[7] = rs.getString("year");
		      		breaking = true;}
	      	}
			
			for(int i = 0; i <8; i+=1)
			{
				if(id[i] == null)
				{
					id[i] = "";
					salary[i] = "";
					name[i] = "";
					subj[i] = "";
					image[i] = null;
				}
				String q = String.format("%-"+26+ "s", name[i]);
				g.drawString( q + "     "+ id[i]+"     "+salary[i]+"      ", 250, 175+i*40);
				g.drawRect(170, 150 + i*40, 35, 35);	//photo
				
				g.setColor(new Color(33, 30, 39));
				g.fillRect(171, 151+ i*40, 34, 34);
				g.setColor(Color.white);
				if(image[i] != null) {
					g.drawImage(image[i], 170, 150+ i*40, game);
				}
			}
			
			if(game.selected>-1 && game.selected <8)
			{
				if(id[game.selected].compareTo("") != 0)
				{
					g.setColor(Color.black);
					g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f));
					g.fillRect(0, 0, game.getWidth(), game.getHeight());
					g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
					g.fillRect(200, 50, 550, 500);
					g.setColor(Color.white);

					g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .4f));
					g.fillRect(200, 50, 550, 500);
					if(game.box[0])
						g.fillRect(385, 300, 350, 30);	//name
					if(game.box[1])
						g.fillRect(395, 340, 30, 30);	//day
					if(game.box[2])
						g.fillRect(430, 340, 30, 30);	//month
					if(game.box[3])
						g.fillRect(470, 340, 60, 30);	//year
					if(game.box[4])
						g.fillRect(385, 380, 320, 30);	//salary
					if(game.box[5])
						g.fillRect(385, 420, 320, 30);	//salary

					g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
					g.drawRect(200, 50, 550, 500);
					g.drawRect(362, 510, 100, 32);	//modify
					g.drawRect(495, 510, 100, 32);	//cancel
					g.drawRect(420, 80, 130, 150);	//photo
					g.drawString("Photo", 450, 150);
					
					if(game.clicked[0])
					{
						game.path =  "";
						JFileChooser jfc = new JFileChooser();
					    jfc.showDialog(null,"Please Select the File");
					    jfc.setVisible(true);
					    File filename = jfc.getSelectedFile();
					    if(filename != null)
					    {
					        game.path = filename.getAbsolutePath();
					        String ext = game.path.substring(game.path.length()-3,game.path.length());
					        System.out.println(ext);
					        if(ext.compareTo("png") == 0 ||ext.compareTo("jpg") == 0)
						        {
								try {
									img[game.selected] = ImageIO.read(new File(game.path));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								image[game.selected] = img[game.selected].getScaledInstance(130, 150, Image.SCALE_SMOOTH);
						        }
					        else {
					        	game.path = path[game.selected];
					        	JOptionPane.showMessageDialog(game, "File type not supported!");
					        }
					    }
				    }
					
					if(!game.wrong) {
						game.day = day[game.selected];
						game.month = month[game.selected];
						game.year = year[game.selected] ;
						game.path = path[game.selected] ;
						game.name = name[game.selected];
						game.salary = salary[game.selected];
						game.subject = subj[game.selected];
						game.wrong = !game.wrong;
						}
					
					path[game.selected] = game.path;
					
					if(image[game.selected] != null)
						image[game.selected] = img[game.selected].getScaledInstance(130, 150, Image.SCALE_SMOOTH);
					g.drawImage(image[game.selected] , 420, 80, game);
					g.drawString("     Name    :" + game.name, 220, 320);
					g.drawString("Date of Birth: " + game.day+ "/" + game.month+ "/" + game.year, 220, 360);
					g.drawString("    Salary   :" + game.salary, 220, 400);
					g.drawString("   Subject   :" + game.subject, 220, 440);
					g.drawString("Modify", 375, 532);
					g.drawString("Cancel", 510, 532);
					
					game.clicked[0] = false;
				}
				
				else
				{
					game.selected = -1;
				}
			}
			
			if(game.choice[0])
			{
				query = "UPDATE teacher SET name = ?, day = ?, month = ?, year = ?, salary = ?, path = ? , subject = ? WHERE teacher.id = " + id[game.selected];
				PreparedStatement preparedStmt = conn.prepareStatement(query);
			    preparedStmt.setString(1, game.name);
			    preparedStmt.setString(2, game.day);
			    preparedStmt.setString(3, game.month);
			    preparedStmt.setString(4, game.year);
			    preparedStmt.setString(5, game.salary);
			    preparedStmt.setString(6, game.path);
			    preparedStmt.setString(7, game.subject);
			    preparedStmt.execute();
				game.choice[0] = false;
				game.selected = -1;
				breaking = false;
				game.wrong = false;
				game.imgs = true;
			}
			if(game.choice[1])
			{
				game.wrong = false;
				game.choice[1] = false;
				game.selected = -1;
				game.imgs = true;
			}
			
			if(game.imgs) {
				for(int i = 0; i<8;i++) {
					try {
						if(path[i]!= null)
							img[i] = ImageIO.read(new File(path[i]));
						else
							img[i] = null;
					} catch (IOException e){img[i] = null;}
					
					if(img[i] == null)
						image[i] = null;
					else
						image[i] = img[i].getScaledInstance(35, 35, Image.SCALE_SMOOTH);
						
					game.imgs = false;
				}
	      	}
			conn.close();
			
		} catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
	}
}
