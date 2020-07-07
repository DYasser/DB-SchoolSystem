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

import Display.GamePanel;

public class RemoveTeacher {


	GamePanel game;
	
	private  String[] id = new String[8];
	private  String[] name = new String[8];
	private  String[] salary = new String[8];
	private  String[] path = new String[8];
	private Image[] image = new Image[8];
	private BufferedImage[] img = new BufferedImage[8];
	private int x = -1;
	private int maxP = 9;
	private boolean breaking = false;
	
	public RemoveTeacher(GamePanel game) {
		this.game = game;
		
		
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(Color.white);
		g.setFont(game.font.deriveFont(55f));
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.drawString("Remove a Teacher", 250, 60);

		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .1f));
		g.fillRect(150, 90, 750, 400);	//form

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
		 if(game.box[8]) {
			g.fillRect(425, 510, 35, 35);//-
		}
		if(game.box[9]) {
			g.fillRect(550, 510, 35, 35);//+
		}
		if(game.exitBox)
		{
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
    	    //System.out.println(rs.next() && !breaking);
	      	
	      	if(game.page < 0)
	      	{
	      		game.page = 0;
	      	}
	      	
	      	if(game.page > maxP)
	      	{
	      		game.page = maxP;
	      	}
	      	
			if(x!= game.page || game.choice[7])
			{
				int c = 0;
				String myDriver1 = "com.mysql.cj.jdbc.Driver";
				String myUrl1 = "jdbc:mysql://localhost:3306/whusystem";
				try {
					Class.forName(myDriver1);
					Connection conn1 = DriverManager.getConnection(myUrl1, "root", "");
					
					String query1 = "SELECT * FROM teacher";
			      	Statement ps21 = conn1.createStatement();
			      	ResultSet rs1 = ps21.executeQuery(query1);
					while(rs1.next())
			      	{c++;}
					if(c%8 == 0)
						maxP = c/8-1;
					else
					{
						maxP = c/8;
					}
					game.selected = -1;
					game.choice[7] = false;
				} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
				x = game.page;			
		      	for(int i = 0; i < 8; i++)
		      	{
		  			id[i] = "";
		  			salary[i] = "";
		  			path[i] = "";
		  			name[i] = "";
		  			image[i] = null;
		      	}

		      	game.imgs = true;
		      	System.out.println("yh");
		      	game.choice[7] = false;
		      	breaking = false;
		      	count = 0;
	      	}
	      	
	      	while(rs.next() && !breaking)
	      	{
	      		//System.out.println("Game count: " + count + "\nGame Page: " + game.page);
	      		count++;
	      		if(count == 1+8*game.page) {
	      			id[0] = rs.getString("id");
	      			salary[0] = rs.getString("salary");
	      			name[0] = rs.getString("name");
	      			path[0] = rs.getString("path");
	      		}
	      		if(count == 2+8*game.page) {
	      			id[1] = rs.getString("id");
	      			salary[1] = rs.getString("salary");
	      			name[1] = rs.getString("name");
	      			path[1] = rs.getString("path");}
	      		if(count == 3+8*game.page) {
	      			id[2] = rs.getString("id");
	      			salary[2] = rs.getString("salary");
	      			name[2] = rs.getString("name");
	      			path[2] = rs.getString("path");}
	      		if(count == 4+8*game.page) {
	      			id[3] = rs.getString("id");
	      			salary[3] = rs.getString("salary");
	      			name[3] = rs.getString("name");
	      			path[3] = rs.getString("path");}
	      		if(count == 5+8*game.page) {
	      			id[4] = rs.getString("id");
	      			salary[4] = rs.getString("salary");
	      			name[4] = rs.getString("name");
	      			path[4] = rs.getString("path");}
	      		if(count == 6+8*game.page) {
	      			id[5] = rs.getString("id");
	      			salary[5] = rs.getString("salary");
	      			name[5] = rs.getString("name");
	      			path[5] = rs.getString("path");}
	      		if(count == 7+8*game.page) {
	      			id[6] = rs.getString("id");
	      			salary[6] = rs.getString("salary");
	      			name[6] = rs.getString("name");
	      			path[6] = rs.getString("path");}
	      		if(count == 8+8*game.page) {
	      			id[7] = rs.getString("id");
	      			salary[7] = rs.getString("salary");
	      			name[7] = rs.getString("name");
	      			path[7] = rs.getString("path");
		      		breaking = true;}
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
			
	    	  
			for(int i = 0; i <8; i+=1)
			{
				if(id[i] == null)
				{
					id[i] = "";
					salary[i] = "";
					name[i] = "";
					image[i] = null;
				}
				String q = String.format("%-"+26+ "s", name[i]);
				g.drawString( q + "      "+ id[i]+"      "+salary[i]+"      ", 250, 175+i*40);
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
				//System.out.println("name: " + name[game.selected]);
				g.setColor(Color.black);
				g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f));
				g.fillRect(0, 0, game.getWidth(), game.getHeight());
				g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
				g.fillRect(300, 200, 300, 140);
				g.setColor(Color.white);
				g.drawRect(300, 200, 300, 140);
				g.drawRect(362, 280, 60, 32);
				g.drawRect(479, 280, 60, 32);
				g.drawString("Are you sure?", 370, 230);
				g.drawString("Yes", 375, 300);
				g.drawString("No", 500, 300);
			}
			
			if(game.choice[0])
			{
				int c = 0;
				query = "delete from teacher where id = ?";
				PreparedStatement preparedStmt = conn.prepareStatement(query);
			    preparedStmt.setString(1, id[game.selected]);
			    preparedStmt.execute();
				System.out.println("Deleted");
				game.choice[7] = true;
				game.choice[0] = false;
				 myDriver = "com.mysql.cj.jdbc.Driver";
				 myUrl = "jdbc:mysql://localhost:3306/whusystem";
				try {
					Class.forName(myDriver);
					 conn = DriverManager.getConnection(myUrl, "root", "");
					
					 query = "SELECT * FROM teacher";
			      	 ps2 = conn.createStatement();
			      	 rs = ps2.executeQuery(query);
					while(rs.next())
			      	{c++;}
					if(c%8 == 0)
						maxP = c/8-1;
					else
					{
						maxP = c/8;
					}
				} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
				game.selected = -1;
				breaking = false;
			}
			if(game.choice[1])
			{
				System.out.println("No");
				game.choice[1] = false;
				game.selected = -1;
			}
			
	      	conn.close();
			
		} catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}

	}
}
