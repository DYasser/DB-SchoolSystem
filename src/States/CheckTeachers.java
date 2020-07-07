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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;

import Display.GamePanel;

public class CheckTeachers {

	GamePanel game;
	public  String[] id = new String[8];
	public  String[] name = new String[8];
	public  String[] salary = new String[8];
	public  String[] path = new String[8];
	public  String[] subj = new String[8];
	
	int count = 0;
	Image image = null;
	int x = 0;
	int maxP = 9;
	BufferedImage img = null;
	boolean imgs = true;
	boolean first = true;
	
	boolean breaking = false;
	public CheckTeachers(GamePanel game)
	{
		this.game = game;
		game.selected = 0;
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
			first = true;
			breaking = false;
		} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g)
	{	
		g.setFont(game.font.deriveFont(30f));
		g.setColor(Color.white);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .1f));
		g.fillRect(80, 120, 500, 400);	//form

		if(game.clicked[0]) {
			g.fillRect(85, 177, 490, 30);//1}
			game.selected = 0;
		}else if(game.clicked[1]) {
			g.fillRect(85, 218, 490, 30);//2
			game.selected = 1;
		}else if(game.clicked[2]) {
			g.fillRect(85, 258, 490, 30);//3
			game.selected = 2;
		}else if(game.clicked[3]) {
			g.fillRect(85, 299, 490, 30);//4
			game.selected = 3;
		}else if(game.clicked[4]) {
			g.fillRect(85, 339, 490, 30);//5
			game.selected = 4;
		}else if(game.clicked[5]) {
			g.fillRect(85, 379, 490, 30);//6
			game.selected = 5;
		}else if(game.clicked[6]) {
			g.fillRect(85, 420, 490, 30);//7
			game.selected = 6;
		}else if(game.clicked[7]) {
			g.fillRect(85, 460, 490, 30);//8
			game.selected = 7;
		}

		if(game.box[0])
			g.fillRect(85, 177, 490, 30);
		if(game.box[1])
			g.fillRect(85, 218, 490, 30);
		if(game.box[2])
			g.fillRect(85, 258, 490, 30);
		if(game.box[3])
			g.fillRect(85, 299, 490, 30);
		if(game.box[4])
			g.fillRect(85, 339, 490, 30);
		if(game.box[5])
			g.fillRect(85, 379, 490, 30);
		if(game.box[6])
			g.fillRect(85, 420, 490, 30);
		if(game.box[7])
			g.fillRect(85, 460, 490, 30);
			
		if(game.box[8]) {
			g.fillRect(710, 500, 25, 25);//-
		}
		
		if(game.box[9]) {
			g.fillRect(820, 500, 25, 25);//+
		}
		if(game.exitBox)
		{
			g.fillRect(25, 25, 90, 40);		//Back
		}
		
		
		
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.drawString("List of Teachers", 350, 50);
		g.setFont(game.font.deriveFont(20f));
		g.drawRect(80, 120, 500, 400);	//form
		g.drawString("Back", 48, 50);
		g.drawRect(25, 25, 90, 40);	//back
		g.drawLine(230,130,230,500);
		g.drawLine(455,130,455,500);

		g.drawRect(710, 500, 25, 25);//-
		g.drawRect(820, 500, 25, 25);//+
		g.drawString("<", 717, 518);
		g.drawString(">", 827, 518);
		g.drawString(game.page+1 + "/" + (maxP+1), 760, 518);

		g.drawString("TEACHER ID", 90, 150);
		g.drawString("NAME", 270, 150);
		g.drawString("SALARY", 485, 150);
		
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
    	    //System.out.println(rs.next() && !breaking);
	      	
	      	if(game.page < 0)
	      	{
	      		game.page = 0;
	      	}
	      	
	      	if(game.page > maxP)
	      	{
	      		game.page = maxP;
	      	}
	      	
			if(x!= game.page || first)
			{
				x = game.page;			
		      	for(int i = 0; i < 8; i++)
		      	{
		  			id[i] = "";
		  			path[i] = "";
		  			name[i] = "";
		  			salary[i]= "";
		  			subj[i]= "";
		      	}

				breaking = false;
				first = false;
	      	}
	      	
			
	      	while(rs.next() && !breaking)
	      	{
	      		//System.out.println("Game count: " + count + "\nGame Page: " + game.page);
	      		count++;
	      		if(count == 1+8*game.page) {
	      			id[0] = rs.getString("id");
	      			name[0] = rs.getString("name");
	      			salary[0] = rs.getString("salary");
	      			path[0] = rs.getString("path");
	      			subj[0] = rs.getString("subject");
	      		}
	      		if(count == 2+8*game.page) {
	      			id[1] = rs.getString("id");
	      			name[1] = rs.getString("name");
	      			salary[1] = rs.getString("salary");
	      			path[1] = rs.getString("path");
	      			subj[1] = rs.getString("subject");}
	      		if(count == 3+8*game.page) {
	      			id[2] = rs.getString("id");
	      			name[2] = rs.getString("name");
	      			salary[2] = rs.getString("salary");
	      			path[2] = rs.getString("path");
	      			subj[2] = rs.getString("subject");}
	      		if(count == 4+8*game.page) {
	      			id[3] = rs.getString("id");
	      			name[3] = rs.getString("name");
	      			salary[3] = rs.getString("salary");
	      			path[3] = rs.getString("path");
	      			subj[3] = rs.getString("subject");}
	      		if(count == 5+8*game.page) {
	      			id[4] = rs.getString("id");
	      			name[4] = rs.getString("name");
	      			salary[4] = rs.getString("salary");
	      			path[4] = rs.getString("path");
	      			subj[4] = rs.getString("subject");}
	      		if(count == 6+8*game.page) {
	      			id[5] = rs.getString("id");
	      			name[5] = rs.getString("name");
	      			salary[5] = rs.getString("salary");
	      			path[5] = rs.getString("path");
	      			subj[5] = rs.getString("subject");}
	      		if(count == 7+8*game.page) {
	      			id[6] = rs.getString("id");
	      			name[6] = rs.getString("name");
	      			salary[6] = rs.getString("salary");
	      			path[6] = rs.getString("path");
	      			subj[6] = rs.getString("subject");}
	      		if(count == 8+8*game.page) {
	      			id[7] = rs.getString("id");
	      			name[7] = rs.getString("name");
	      			salary[7] = rs.getString("salary");
	      			path[7] = rs.getString("path");
	      			subj[7] = rs.getString("subject");
		      		breaking = true;}
	      	}
			

    	  
		for(int i = 0; i <8; i+=1)
		{	String q = String.format("%-"+19+ "s", name[i]);
			g.drawString(id[i]+"     "+q+salary[i], 95, 200+i*40);
			
		}
		
		g.drawString("Photo", 755, 250);
		g.drawRect(720, 200, 130, 150);//photo

		try {
			g.drawString("Name: " + name[game.selected], 600, 420);
			g.drawString("Salary: " + salary[game.selected], 610, 485);
			g.drawString("Subject: " + subj[game.selected], 610, 450);
		}
		catch(Exception ex) 
		{
			g.drawString("Name: " , 600, 420);
			g.drawString("Salary: " , 610, 485);
			g.drawString("Subject: " , 610, 450);
			image = null;
		}
		
		if((game.clicked[0] || game.clicked[1] || game.clicked[2] || game.clicked[3] || game.clicked[4]
				|| game.clicked[5] || game.clicked[6] || game.clicked[7]) && game.imgs)
		{
			try {
				
				img = ImageIO.read(new File(path[game.selected]));
				
			} catch (IOException e){img = null;}
			
			if(img == null)
				image = null;
			else
				image = img.getScaledInstance(130, 150, Image.SCALE_SMOOTH);
				
			game.imgs = false;
		}

		g.drawImage(image, 720, 200, game);
			

      	conn.close();
		
	} catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
	}
}
