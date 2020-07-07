package States;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Display.GamePanel;

public class StudentExam {

	private GamePanel game;
	private String subjct[] = new String[8] ;
	private int maxP = 0, x = -1;
	private int questions = 0;
	
	public StudentExam(GamePanel game)
	{
		this.game = game;
	}
	
	public void update() {
		
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(Color.white);
		g.setFont(game.font.deriveFont(50f));
		g.drawString("Exams", 400, 50);
		g.drawRect(25, 25, 90, 40);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
		g.fillRect(205, 160, 570, 30);
		g.fillRect(205, 200, 570, 30);
		g.fillRect(205, 240, 570, 30);
		g.fillRect(205, 280, 570, 30);
		g.fillRect(205, 320, 570, 30);
		g.fillRect(205, 360, 570, 30);
		g.fillRect(205, 400, 570, 30);
		g.fillRect(205, 440, 570, 30);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.setFont(game.font.deriveFont(18f));
		g.drawString("Back", 50,50); 
		g.drawRect(190,120,600,360);
		g.drawRect(420,500,30,30);
		g.drawRect(540,500,30,30);
		
		try {
			// create a mysql database connection
	      	String myDriver = "com.mysql.cj.jdbc.Driver";
	      	String myUrl = "jdbc:mysql://localhost:3306/whusystem";
	      	Connection conn = DriverManager.getConnection(myUrl, "root", "");
			Class.forName(myDriver);
			
			String query = "SELECT * FROM student";
	      	Statement ps2 = conn.createStatement();
	      	ResultSet rs = ps2.executeQuery(query);
	      	if(!game.choice[0])
	      	{
	      		int c = 0;
				while(rs.next())
		      	{c++;}
				if(c%8 == 0)
					maxP = c/8-1;
				else
				{
					maxP = c/8;
				}
			}
			
			if(game.page < 0)
	      	{
	      		game.page = 0;
	      	}
	      	
	      	if(game.page > maxP)
	      	{
	      		game.page = maxP;
	      	}
	      	
			g.drawString("<", 430, 523);
			g.drawString(">", 550, 523);
			
			if(game.choice[0])
			{
				for(int i = 0; i<8;i++)
			    {
			    	subjct[i] = "";
			    }
			}
	      	
			if(x!= game.page && !game.choice[0])
			{
				//x = game.page;	
				//System.out.println("game: " + game.stuId);
		      	query = "SELECT * FROM courses WHERE studid = \"" + game.stuId + "\"";
		      	ps2 = conn.createStatement();
				PreparedStatement preparedStmt = conn.prepareStatement(query);
			    rs = ps2.executeQuery(query);
			    for(int i = 0; i<8;i++)
			    {
			    	subjct[i] = "";
			    }
			    
			    int count = 0;
		      	while(rs.next())
		      	{
		      		count++;
		      		if(count == 1+game.page*8)
		      			subjct[0] = rs.getString("name");
		      		if(count == 2+game.page*8)
		      			subjct[1] = rs.getString("name");
		      		if(count == 3+game.page*8)
		      			subjct[2] = rs.getString("name");
		      		if(count == 4+game.page*8)
		      			subjct[3] = rs.getString("name");
		      		if(count == 5+game.page*8)
		      			subjct[4] = rs.getString("name");
		      		if(count == 6+game.page*8)
		      			subjct[5] = rs.getString("name");
		      		if(count == 7+game.page*8)
		      			subjct[6] = rs.getString("name");
		      		if(count == 8+game.page*8)
		      			subjct[7] = rs.getString("name");
		      	}
	
		    }
		
		for(int i = 0; i<8;i++)
		{
			//System.out.println(i+" - " +subjct[i]);
			g.drawString(subjct[i], 230, 180+i*40);
		}
		
		if(game.selected >=0 && game.selected <8 && subjct[game.selected].compareTo("") != 0 && !game.choice[0])
		{
			game.subject = subjct[game.selected];
			query = "SELECT * FROM courses WHERE studid = \"" + game.stuId + "\" AND name = \"" + subjct[game.selected] + "\"";
	      	ps2 = conn.createStatement();
			PreparedStatement preparedStmt = conn.prepareStatement(query);
		    rs = ps2.executeQuery(query);
		    rs.next();
		    String grade = rs.getString("grade");
		    String teachid = rs.getString("teachid");
		    query = "SELECT * FROM exam WHERE teachid = \"" + teachid + "\" AND subject = \"" + subjct[game.selected] + "\"";
	      	ps2 = conn.createStatement();
			preparedStmt = conn.prepareStatement(query);
		    rs = ps2.executeQuery(query);
		    System.out.println("teachid: " + teachid+" | subject: " + subjct[game.selected] + " Grade: " + grade);
		    if(rs.next() && (grade.compareTo("0.0") == 0))
			    {
			    	System.out.println(rs.getString("answerp"));
			    	File file = new File(rs.getString("examp"));
					Desktop desktop = Desktop.getDesktop();  
					desktop.open(file);
				   	game.choice[0] = true;
				   	game.answers = new String(Files.readAllBytes(Paths.get(rs.getString("answerp"))));
				   	questions = game.answers.length();
				   	for(int i = 0; i<questions; i++)
				   	{
				   		game.answer += "E";
				   	}
				   	game.page = 0;
					if(questions%8 == 0)
						maxP = questions/8-1;
					else
					{
						maxP = questions/8;
					}
			    }
		    else if(grade.compareTo("0.0") != 0)
		    {
			    query = "SELECT * FROM courses WHERE teachid = \"" + teachid + "\" AND name = \"" + subjct[game.selected] + "\"";
		      	ps2 = conn.createStatement();
				preparedStmt = conn.prepareStatement(query);
			    rs = ps2.executeQuery(query);
				if(rs.next())
					JOptionPane.showMessageDialog(game, "You already passed this exam! You scored: " + rs.getString("grade"));
		    }
		    else
		    {
		    	JOptionPane.showMessageDialog(game, "No exams yet for this subject!");
		    }
		    game.selected = -1;
		}
			g.drawString(game.page+1+"/"+(maxP+1), 480, 523);
		
			if(game.choice[0])
			{
				g.drawRect(game.getWidth()-130, game.getHeight()-70, 100, 40);
				g.drawString("Send", game.getWidth()-100, game.getHeight()-45);
				for(int i =0; i < 8; i++)
				{
					if(questions >= (i+1) +game.page*8) {
						g.drawString((i+1) + "-        A         B         C         D", 230, 180+i*40);
						g.drawRect(330, 160+i*40, 30, 30);
						g.drawRect(440, 160+i*40, 30, 30);
						g.drawRect(550, 160+i*40, 30, 30);
						g.drawRect(660, 160+i*40, 30, 30);
					}
				}
				try {
				if(game.answer.substring(0+8*game.page,1+8*game.page).compareTo("E") != 0)
					g.drawString(game.answer.substring(0+8*game.page,1+8*game.page), 850, 180);
				if(game.answer.substring(1+8*game.page,2+8*game.page).compareTo("E") != 0)
					g.drawString(game.answer.substring(1+8*game.page,2+8*game.page), 850, 220);
				if(game.answer.substring(2+8*game.page,3+8*game.page).compareTo("E") != 0)
					g.drawString(game.answer.substring(2+8*game.page,3+8*game.page), 850, 260);
				if(game.answer.substring(3+8*game.page,4+8*game.page).compareTo("E") != 0)
					g.drawString(game.answer.substring(3+8*game.page,4+8*game.page), 850, 300);
				if(game.answer.substring(4+8*game.page,5+8*game.page).compareTo("E") != 0)
					g.drawString(game.answer.substring(4+8*game.page,5+8*game.page), 850, 340);
				if(game.answer.substring(5+8*game.page,6+8*game.page).compareTo("E") != 0)
					g.drawString(game.answer.substring(5+8*game.page,6+8*game.page), 850, 380);
				if(game.answer.substring(6+8*game.page,7+8*game.page).compareTo("E") != 0)
					g.drawString(game.answer.substring(6+8*game.page,7+8*game.page), 850, 420);
				if(game.answer.substring(7+8*game.page,8+8*game.page).compareTo("E") != 0)
					g.drawString(game.answer.substring(7+8*game.page,8+8*game.page), 850, 460);
				}catch(Exception ex) {}
			}
			
			if(!game.choice[0]) 
				g.drawString("Subject Selected", 400, 145);
		
		if(game.choice[2])
		{
			game.choice[2] = false;
			System.out.println("ID: " + game.stuId + " name: " + game.subject );
			query = "UPDATE courses SET grade = ? WHERE studid = \"" + game.stuId + "\" AND name = \"" + game.subject + "\"";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setDouble(1, game.grade);
			preparedStmt.executeUpdate();
			System.out.println("Okay");
			
		}
      	conn.close();
	}
	catch(Exception e){e.printStackTrace();}
	}
}
