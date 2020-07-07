package States;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Display.GamePanel;

public class Grade {

	GamePanel game;
	public  String[] id = new String[8];
	public  String[] grade = new String[8];
	int count = 0;
	Image image = null;
	int x = 0;
	int maxP = 9;
	BufferedImage img = null;
	boolean imgs = true;
	boolean first = true;
	boolean breaking = false;
	
	public Grade(GamePanel game)
	{
		this.game = game;
		game.selected = 0;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g)
	{	
		g.setFont(game.font.deriveFont(30f));
		g.setColor(Color.white);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .1f));
		g.fillRect(280, 120, 400, 350);	//form

		if(game.box[0] || game.clicked[0])
			g.fillRect(290, 177, 380, 30);
		if(game.box[1] || game.clicked[1])
			g.fillRect(290, 211, 380, 30);
		if(game.box[2] || game.clicked[2])
			g.fillRect(290, 247, 380, 30);
		if(game.box[3] || game.clicked[3])
			g.fillRect(290, 280, 380, 30);
		if(game.box[4] || game.clicked[4])
			g.fillRect(290, 316, 380, 30);
		if(game.box[5] || game.clicked[5])
			g.fillRect(290, 349, 380, 30);
		if(game.box[6] || game.clicked[6])
			g.fillRect(290, 385, 380, 30);
		if(game.box[7] || game.clicked[7])
			g.fillRect(290, 420, 380, 30);
			
		if(game.box[8]) {
			g.fillRect(400, 500, 25, 25);//-
		}
		
		if(game.box[9]) {
			g.fillRect(510, 500, 25, 25);//+
		}
		if(game.exitBox)
		{
			g.fillRect(25, 25, 90, 40);		//Back
		}
		
		
		
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.drawString("Grading Students", 350, 50);
		g.setFont(game.font.deriveFont(20f));
		g.drawRect(280, 120, 400, 350);	//form
		g.drawString("Back", 48, 50);
		g.drawRect(25, 25, 90, 40);	//back
		g.drawLine(530,130,530,450);

		g.drawRect(400, 500, 25, 25);//-
		g.drawRect(510, 500, 25, 25);//+
		g.drawString("<", 407, 518);
		g.drawString(">", 517, 518);
		g.drawString(game.page+1 + "/" + (maxP+1), 450, 518);

		
		g.drawString("Student ID        Grade", 350, 150);
		
		try {
			
			// create a mysql database connection
			String myDriver = "com.mysql.cj.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/whusystem";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			
			int c = 0;
			String query = "SELECT * FROM courses WHERE teachid = \"" + game.stuId + "\"";
	      	Statement ps2 = conn.createStatement();
	      	ResultSet rs = ps2.executeQuery(query);
			while(rs.next())
	      	{
				c++;
	      	}
			if(c%8 == 0)
				maxP = c/8-1;
			else
			{
				maxP = c/8;
			}
			
			
			query = "SELECT * FROM courses WHERE teachid = \"" + game.stuId + "\"";
	      	//ps2 = conn.createStatement();
	      	rs = ps2.executeQuery(query);
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
	      	
	      	rs = ps2.executeQuery(query);
			if(x!= game.page || first)
			{
				x = game.page;			
		      	for(int i = 0; i < 8; i++)
		      	{	
		  			id[i] = "";
		  			if(rs.next()) {
		  				game.grad[i] = rs.getString("grade");
		  				System.out.println("grade: " + game.grad[i]);
		  			}
		  			else
		  				game.grad[i] = "";
		      	}
				breaking = false;
				first = false;
	      	}
	      	
	      	while(rs.next())
	      	{
	      		count++;
	      		if(count == 1+8*game.page) {
	      			id[0] = rs.getString("studid");
		    		query = "UPDATE courses SET grade = ? WHERE teachid = \"" + game.stuId + "\" AND studid = \"" + id[0] + "\"";
		          	PreparedStatement stmt = conn.prepareStatement(query);
		          	if(game.grad[0].compareTo("") != 0)
		          		stmt.setString(1, game.grad[0]);
		          	else
		          		stmt.setDouble(1, 0f);
		          	stmt.executeUpdate();
	      		}
	      		if(count == 2+8*game.page) {
	      			id[1] = rs.getString("studid");
		    		query = "UPDATE courses SET grade = ? WHERE teachid = \"" + game.stuId + "\" AND studid = \"" + id[0] + "\"";
		          	PreparedStatement stmt = conn.prepareStatement(query);
		          	if(game.grad[1].compareTo("") != 0)
		          		stmt.setString(1, game.grad[1]);
		          	else
		          		stmt.setDouble(1, 0f);
		          	stmt.executeUpdate();}
	      		if(count == 3+8*game.page) {
	      			id[2] = rs.getString("studid");
		    		query = "UPDATE courses SET grade = ? WHERE teachid = \"" + game.stuId + "\" AND studid = \"" + id[0] + "\"";
		          	PreparedStatement stmt = conn.prepareStatement(query);
		          	if(game.grad[2].compareTo("") != 0)
		          		stmt.setString(1, game.grad[2]);
		          	else
		          		stmt.setDouble(1, 0f);
		          	stmt.executeUpdate();
	      		}
	      		if(count == 4+8*game.page) {
	      			id[3] = rs.getString("studid");
		    		query = "UPDATE courses SET grade = ? WHERE teachid = \"" + game.stuId + "\" AND studid = \"" + id[0] + "\"";
		          	PreparedStatement stmt = conn.prepareStatement(query);
		          	if(game.grad[3].compareTo("") != 0)
		          		stmt.setString(1, game.grad[3]);
		          	else
		          		stmt.setDouble(1, 0f);
		          	stmt.executeUpdate();
	      		}
	      		if(count == 5+8*game.page) {
	      			id[4] = rs.getString("studid");
		    		query = "UPDATE courses SET grade = ? WHERE teachid = \"" + game.stuId + "\" AND studid = \"" + id[0] + "\"";
		          	PreparedStatement stmt = conn.prepareStatement(query);
		          	if(game.grad[4].compareTo("") != 0)
		          		stmt.setString(1, game.grad[4]);
		          	else
		          		stmt.setDouble(1, 0f);
		          	stmt.executeUpdate();
	      		}
	      		if(count == 6+8*game.page) {
	      			id[5] = rs.getString("studid");
		    		query = "UPDATE courses SET grade = ? WHERE teachid = \"" + game.stuId + "\" AND studid = \"" + id[0] + "\"";
		          	PreparedStatement stmt = conn.prepareStatement(query);
		          	if(game.grad[5].compareTo("") != 0)
		          		stmt.setString(1, game.grad[5]);
		          	else
		          		stmt.setDouble(1, 0f);
		          	stmt.executeUpdate();
	      		}
	      		if(count == 7+8*game.page) {
	      			id[6] = rs.getString("studid");
		    		query = "UPDATE courses SET grade = ? WHERE teachid = \"" + game.stuId + "\" AND studid = \"" + id[0] + "\"";
		          	PreparedStatement stmt = conn.prepareStatement(query);
		          	if(game.grad[6].compareTo("") != 0)
		          		stmt.setString(1, game.grad[6]);
		          	else
		          		stmt.setDouble(1, 0f);
		          	stmt.executeUpdate();
	      		}
	      		if(count == 8+8*game.page) {
	      			id[7] = rs.getString("studid");
		    		query = "UPDATE courses SET grade = ? WHERE teachid = \"" + game.stuId + "\" AND studid = \"" + id[0] + "\"";
		          	PreparedStatement stmt = conn.prepareStatement(query);
		          	if(game.grad[7].compareTo("") != 0)
		          		stmt.setString(1, game.grad[7]);
		          	else
		          		stmt.setDouble(1, 0f);
		          	stmt.executeUpdate();
		      		breaking = true;}
	      	}
	      	
		for(int i = 0; i <8; i+=1)
		{
			if(id[i].compareTo("") != 0)
				g.drawString(id[i] +"      "+ game.grad[i] + "%", 330, 200+i*35);
		}

      	conn.close();
		
	} catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
	}
}
