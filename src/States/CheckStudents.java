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
import javax.swing.JFileChooser;

import Display.GamePanel;

public class CheckStudents {

	GamePanel game;
	public  String[] id = new String[8];
	public  String[] name = new String[8];
	public  String[] major = new String[8];
	public  String[] level = new String[8];
	public  String[] schoolF = new String[8];
	public  String[] dormF = new String[8];
	public  String[] otherF = new String[8];
	public  String[] fee = new String[8];
	public  String[] path = new String[8];
	public  float[] scholarship = new float[8];
	int count = 0;
	Image image = null;
	int x = 0;
	int maxP = 9;
	String tempid = "", tempfee = "";
	float tempscholarship = 0f;
	BufferedImage img = null;
	boolean imgs = true;
	boolean first = true;
	
	boolean breaking = false;
	public CheckStudents(GamePanel game)
	{
		this.game = game;
		int c = 0;
		String myDriver = "com.mysql.cj.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/whusystem";
		try {
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			
			String query = "SELECT * FROM student";
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
		g.drawString("List of Students", 350, 50);
		g.setFont(game.font.deriveFont(20f));
		g.drawRect(80, 120, 500, 400);	//form
		g.drawString("Back", 48, 50);
		g.drawRect(25, 25, 90, 40);	//back
		g.drawLine(275,130,275,500);
		g.drawLine(410,130,410,500);

		g.drawRect(710, 500, 25, 25);//-
		g.drawRect(820, 500, 25, 25);//+
		g.drawString("<", 717, 518);
		g.drawString(">", 827, 518);
		g.drawString(game.page+1 + "/" + (maxP+1), 760, 518);
		
		g.drawString("Student ID", 115, 150);
		
		try {
			
			// create a mysql database connection
			String myDriver = "com.mysql.cj.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/whusystem";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			
			String query = "SELECT * FROM student";
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
		  			id[i] = "                                                                          ";
		  			fee[i] = "";
		  			scholarship[i] = 0f;
		  			path[i] = "";
		  			name[i] = "";
		  			major[i] = "";
		  			level[i] = "";
		  			dormF[i] = "";
		  			otherF[i] = "";
		  			schoolF[i] = "";
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
	      			fee[0] = rs.getString("tot");
	      			scholarship[0] = rs.getFloat("scholarship");
	      			name[0] = rs.getString("name");
	      			major[0] = rs.getString("major");
	      			level[0] = rs.getString("level");
	      			schoolF[0] = rs.getString("schoolFee");
	      			dormF[0] = rs.getString("dormFee");
	      			otherF[0] = rs.getString("otherFee");
	      			path[0] = rs.getString("path");
	      			
	      		}
	      		if(count == 2+8*game.page) {
	      			id[1] = rs.getString("id");
	      			fee[1] = rs.getString("tot");
	      			scholarship[1] = rs.getFloat("scholarship");
	      			name[1] = rs.getString("name");
	      			major[1] = rs.getString("major");
	      			level[1] = rs.getString("level");
	      			schoolF[1] = rs.getString("schoolFee");
	      			dormF[1] = rs.getString("dormFee");
	      			otherF[1] = rs.getString("otherFee");
	      			path[1] = rs.getString("path");}
	      		if(count == 3+8*game.page) {
	      			id[2] = rs.getString("id");
	      			fee[2] = rs.getString("tot");
	      			scholarship[2] = rs.getFloat("scholarship");
	      			name[2] = rs.getString("name");
	      			major[2] = rs.getString("major");
	      			level[2] = rs.getString("level");
	      			schoolF[2] = rs.getString("schoolFee");
	      			dormF[2] = rs.getString("dormFee");
	      			otherF[2] = rs.getString("otherFee");
	      			path[2] = rs.getString("path");}
	      		if(count == 4+8*game.page) {
	      			id[3] = rs.getString("id");
	      			fee[3] = rs.getString("tot");
	      			scholarship[3] = rs.getFloat("scholarship");
	      			name[3] = rs.getString("name");
	      			major[3] = rs.getString("major");
	      			level[3] = rs.getString("level");
	      			schoolF[3] = rs.getString("schoolFee");
	      			dormF[3] = rs.getString("dormFee");
	      			otherF[3] = rs.getString("otherFee");
	      			path[3] = rs.getString("path");}
	      		if(count == 5+8*game.page) {
	      			id[4] = rs.getString("id");
	      			fee[4] = rs.getString("tot");
	      			scholarship[4] = rs.getFloat("scholarship");
	      			name[4] = rs.getString("name");
	      			major[4] = rs.getString("major");
	      			level[4] = rs.getString("level");
	      			schoolF[4] = rs.getString("schoolFee");
	      			dormF[4] = rs.getString("dormFee");
	      			otherF[4] = rs.getString("otherFee");
	      			path[4] = rs.getString("path");}
	      		if(count == 6+8*game.page) {
	      			id[5] = rs.getString("id");
	      			fee[5] = rs.getString("tot");
	      			scholarship[5] = rs.getFloat("scholarship");
	      			name[5] = rs.getString("name");
	      			major[5] = rs.getString("major");
	      			level[5] = rs.getString("level");
	      			schoolF[5] = rs.getString("schoolFee");
	      			dormF[5] = rs.getString("dormFee");
	      			otherF[5] = rs.getString("otherFee");
	      			path[5] = rs.getString("path");}
	      		if(count == 7+8*game.page) {
	      			id[6] = rs.getString("id");
	      			fee[6] = rs.getString("tot");
	      			scholarship[6] = rs.getFloat("scholarship");
	      			name[6] = rs.getString("name");
	      			major[6] = rs.getString("major");
	      			level[6] = rs.getString("level");
	      			schoolF[6] = rs.getString("schoolFee");
	      			dormF[6] = rs.getString("dormFee");
	      			otherF[6] = rs.getString("otherFee");
	      			path[6] = rs.getString("path");}
	      		if(count == 8+8*game.page) {
	      			id[7] = rs.getString("id");
	      			fee[7] = rs.getString("tot");
	      			scholarship[7] = rs.getFloat("scholarship");
	      			name[7] = rs.getString("name");
	      			major[7] = rs.getString("major");
	      			level[7] = rs.getString("level");
	      			schoolF[7] = rs.getString("schoolFee");
	      			dormF[7] = rs.getString("dormFee");
	      			otherF[7] = rs.getString("otherFee");
	      			path[7] = rs.getString("path");
		      		breaking = true;}
	      		//System.out.println("Id : " + rs.getString("tot"));
	      	}
	      	//int maxP = count/8;
	      	//System.out.println(count);
			

    	  
		for(int i = 0; i <8; i+=1)
		{
			g.drawString(id[i]+"     "+fee[i]+"      "+scholarship[i]*100 + "%", 95, 200+i*40);
			
		}
		g.drawString("Total fee", 290, 150);
		g.drawString("Scholarship", 430, 150);
		g.drawString("Photo", 755, 165);

		
		g.drawRect(720, 90, 130, 150);//photo
		try {
		g.drawString("Major: " + major[game.selected], 610, 300);
		g.drawString("("+level[game.selected] + ")", 670, 330);
		g.drawString("Name: " + name[game.selected], 592, 270);
		g.drawString("School fee: " + schoolF[game.selected], 610, 380);
		g.drawString("Dorm   fee: " + dormF[game.selected], 610, 410);
		g.drawString("Other fees: " + otherF[game.selected], 610, 440);
		g.drawString("Total fee : " + fee[game.selected], 610, 470);
		}
		catch(Exception ex) {
			g.drawString("Major: " , 610, 300);
			g.drawString("()", 670, 330);
			g.drawString("Name: ", 592, 270);
			g.drawString("School fee: ", 610, 380);
			g.drawString("Dorm   fee: ", 610, 410);
			g.drawString("Other fees: ", 610, 440);
			g.drawString("Total fee : ", 610, 470);
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

		g.drawImage(image, 720, 90, game);
			
		g.setColor(Color.red);
		g.setFont(game.font.deriveFont(16f));
		g.drawString("Fees after applying scholarship.", 630, 490);

      	conn.close();
		
	} catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
	}
}
