package States;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Display.GamePanel;

public class Schedule {
	GamePanel game;
	String day = "";
	String time = "";
	int x = 0, y = 0;

  	String mon1 = "",mon2= "",mon3= "",mon4= "",mon5= "",mon6= "",mon7= "",mon8= "",mon9= "";
  	String tue1 = "",tue2= "",tue3= "",tue4= "",tue5= "",tue6= "",tue7= "",tue8= "",tue9= "";
  	String wed1 = "",wed2= "",wed3= "",wed4= "",wed5= "",wed6= "",wed7= "",wed8= "",wed9= "";
  	String thu1 = "",thu2= "",thu3= "",thu4= "",thu5= "",thu6= "",thu7= "",thu8= "",thu9= "";
  	String fri1 = "",fri2= "",fri3= "",fri4= "",fri5= "",fri6= "",fri7= "",fri8= "",fri9= "";
	
	public Schedule(GamePanel game)
	{
		this.game = game;
		game.choice[1] = true;
	}
	
	public void update()
	{
		
	}

	
	public void render(Graphics2D g)
	{
		g.setColor(Color.yellow);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
		g.fillRect(50, 150, 775, 400);
		g.setColor(Color.white);
		g.fillRect(50, 150, 775, 400);
		

		if(game.box[0])
			g.fillRect(160, 92, 55, 40);
		if(game.box[1])
			g.fillRect(330, 92, 100, 40);
		if(game.box[2])
			g.fillRect(550, 92, 240, 40);
		if(game.box[3])
			g.fillRect(850, 92, 100, 40);
		if(game.exitBox)
			g.fillRect(25, 25, 90, 40);
		
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.drawRect(50, 150, 775, 400);
		g.drawLine(50, 150, 150, 190);
		g.drawString("Schedules", 350, 50);
		g.setFont(game.font.deriveFont(14f));
		g.drawString("Class", 60, 180);
		g.drawString("Days", 115, 170);
		g.setFont(game.font.deriveFont(18f));
		g.drawRect(25, 25, 90, 40);
		g.drawString("Back", 50, 50);
		g.drawString("Monday", 175, 175);
		g.drawString("Tuesday", 310, 175);
		g.drawString("Wednesday", 445, 175);
		g.drawString("Thursday", 580, 175);
		g.drawString("Friday", 720, 175);
		g.setFont(game.font.deriveFont(15f));
		g.drawString("8:00-8:45", 55, 215);
		g.drawString("8:50-9:35", 55, 255);
		g.drawString("9:50-10:35", 52, 295);
		g.drawString("10:40-11:25", 52, 335);
		g.drawString("11:30-12:15", 52, 375);
		g.drawString("14:05-14:50", 52, 415);
		g.drawString("14:55-15:40", 52, 455);
		g.drawString("15:45-16:30", 52, 495);
		g.drawString("16:40-17:30", 52, 535);

		
		
		
		if(game.choice[1])
		{
			game.choice[1] = false;
			try {
			// create a mysql database connection
	      	String myDriver = "com.mysql.cj.jdbc.Driver";
	      	String myUrl = "jdbc:mysql://localhost:3306/whusystem";
	      	
			Class.forName(myDriver);
			
	      	Connection conn = DriverManager.getConnection(myUrl, "root", "");

	      	String query = "SELECT * FROM schedule WHERE level =  \"" + game.level + "\" AND major = \""+game.major + "\" AND class = \""+game.classOf+"\"";
	      	Statement ps2 = conn.createStatement();
	      	ResultSet my_rs = ps2.executeQuery(query);
      	  	
	      	while(my_rs.next()) {
      	  	mon1 = my_rs.getString("1mon");
      	  	mon2 = my_rs.getString("2mon");
      	  	mon3 = my_rs.getString("3mon");
      	  	mon4 = my_rs.getString("4mon");
      	  	mon5 = my_rs.getString("5mon");
      	  	mon6 = my_rs.getString("6mon");
      	  	mon7 = my_rs.getString("7mon");
      	  	mon8 = my_rs.getString("8mon");
      	  	mon9 = my_rs.getString("9mon");

      	  	tue1 = my_rs.getString("1tue");
      	  	tue2 = my_rs.getString("2tue");
      	  	tue3 = my_rs.getString("3tue");
      	  	tue4 = my_rs.getString("4tue");
      	  	tue5 = my_rs.getString("5tue");
      	  	tue6 = my_rs.getString("6tue");
      	  	tue7 = my_rs.getString("7tue");
      		tue8 = my_rs.getString("8tue");
      		tue9 = my_rs.getString("9tue");

      	  	wed1 = my_rs.getString("1wed");
      	  	wed2 = my_rs.getString("2wed");
      	  	wed3 = my_rs.getString("3wed");
      	  	wed4 = my_rs.getString("4wed");
  	  		wed5 = my_rs.getString("5wed");
  	  		wed6 = my_rs.getString("6wed");
  	  		wed7 = my_rs.getString("7wed");
  	  		wed8 = my_rs.getString("8wed");
  	  		wed9 = my_rs.getString("9wed");

      	  	thu1 = my_rs.getString("1thu");
      	  	thu2 = my_rs.getString("2thu");
      	  	thu3 = my_rs.getString("3thu");
      		thu4 = my_rs.getString("4thu");
      		thu5 = my_rs.getString("5thu");
      		thu6 = my_rs.getString("6thu");
      		thu7 = my_rs.getString("7thu");
      		thu8 = my_rs.getString("8thu");
      		thu9 = my_rs.getString("9thu");

      	  	fri1 = my_rs.getString("1fri");
      	  	fri2 = my_rs.getString("2fri");
	      	fri3 = my_rs.getString("3fri");
	      	fri4 = my_rs.getString("4fri");
	      	fri5 = my_rs.getString("5fri");
	      	fri6 = my_rs.getString("6fri");
	      	fri7 = my_rs.getString("7fri");
	      	fri8 = my_rs.getString("8fri");
	      	fri9 = my_rs.getString("9fri");
	      	}

      	  	
      	  	
      	  	game.choice[0] = false;
      	  	conn.close();
			} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
		}

		if(mon1.length()>9)
			g.drawString(mon1.substring(0,9) + "...", 175, 215);
		else
			g.drawString(mon1, 175, 215);

		if(mon2.length()>9)
			g.drawString(mon2.substring(0,9) + "...", 175, 255);
		else
		g.drawString(mon2, 175, 255);

		if(mon3.length()>9)
			g.drawString(mon3.substring(0,9) + "...", 175, 295);
		else
		g.drawString(mon3, 175, 295);

		if(mon4.length()>9)
			g.drawString(mon4.substring(0,9) + "...", 175, 335);
		else
		g.drawString(mon4, 175, 335);

		if(mon5.length()>9)
			g.drawString(mon5.substring(0,9) + "...", 175, 375);
		else
		g.drawString(mon5, 175, 375);

		if(mon6.length()>9)
			g.drawString(mon6.substring(0,9) + "...", 175, 415);
		else
		g.drawString(mon6, 175, 415);

		if(mon7.length()>9)
			g.drawString(mon7.substring(0,9) + "...", 175, 455);
		else
		g.drawString(mon7, 175, 455);

		if(mon8.length()>9)
			g.drawString(mon8.substring(0,9) + "...", 175, 495);
		else
		g.drawString(mon8, 175, 495);

		if(mon9.length()>9)
			g.drawString(mon9.substring(0,9) + "...", 175, 535);
		else
		g.drawString(mon9, 175, 535);



		if(tue1.length()>9)
			g.drawString(tue1.substring(0,9) + "...", 310, 215);
		else
		g.drawString(tue1, 310, 215);

		if(tue2.length()>9)
			g.drawString(tue2.substring(0,9) + "...", 310, 255);
		else
		g.drawString(tue2, 310, 255);

		if(tue3.length()>9)
			g.drawString(tue3.substring(0,9) + "...", 310, 295);
		else
		g.drawString(tue3, 310, 295);

		if(tue4.length()>9)
			g.drawString(tue4.substring(0,9) + "...", 310, 335);
		else
		g.drawString(tue4, 310, 335);

		if(tue5.length()>9)
			g.drawString(tue5.substring(0,9) + "...", 310, 375);
		else
		g.drawString(tue5, 310, 375);

		if(tue6.length()>9)
			g.drawString(tue6.substring(0,9) + "...", 310, 415);
		else
		g.drawString(tue6, 310, 415);

		if(tue7.length()>9)
			g.drawString(tue7.substring(0,9) + "...", 310, 455);
		else
		g.drawString(tue7, 310, 455);

		if(tue8.length()>9)
			g.drawString(tue8.substring(0,9) + "...", 310, 495);
		else
		g.drawString(tue8, 310, 495);

		if(tue9.length()>9)
			g.drawString(tue9.substring(0,9) + "...", 310, 535);
		else
		g.drawString(tue9, 310, 535);

		



		if(wed1.length()>9)
			g.drawString(wed1.substring(0,9) + "...", 445, 215);
		else		
		g.drawString(wed1, 445, 215);

		if(wed2.length()>9)
			g.drawString(wed2.substring(0,9) + "...", 445, 255);
		else
		g.drawString(wed2, 445, 255);

		if(wed3.length()>9)
			g.drawString(wed3.substring(0,9) + "...", 445, 295);
		else
		g.drawString(wed3, 445, 295);

		if(wed4.length()>9)
			g.drawString(wed4.substring(0,9) + "...", 445, 335);
		else
		g.drawString(wed4, 445, 335);

		if(wed5.length()>9)
			g.drawString(wed5.substring(0,9) + "...", 445, 375);
		else
		g.drawString(wed5, 445, 375);

		if(wed6.length()>9)
			g.drawString(wed6.substring(0,9) + "...", 445, 415);
		else
		g.drawString(wed6, 445, 415);

		if(wed7.length()>9)
			g.drawString(wed7.substring(0,9) + "...", 445, 455);
		else
		g.drawString(wed7, 445, 455);

		if(wed8.length()>9)
			g.drawString(wed8.substring(0,9) + "...", 445, 495);
		else
		g.drawString(wed8, 445, 495);

		if(wed9.length()>9)
			g.drawString(wed9.substring(0,9) + "...", 445, 535);
		else
		g.drawString(wed9, 445, 535);

		



		if(thu1.length()>9)
			g.drawString(thu1.substring(0,9) + "...", 580, 215);
		else		
		g.drawString(thu1, 580, 215);

		if(thu2.length()>9)
			g.drawString(thu2.substring(0,9) + "...", 580, 255);
		else
		g.drawString(thu2, 580, 255);

		if(thu3.length()>9)
			g.drawString(thu3.substring(0,9) + "...", 580, 295);
		else
		g.drawString(thu3, 580, 295);

		if(thu4.length()>9)
			g.drawString(thu4.substring(0,9) + "...", 580, 335);
		else
		g.drawString(thu4, 580, 335);

		if(thu5.length()>9)
			g.drawString(thu5.substring(0,9) + "...", 580, 375);
		else
		g.drawString(thu5, 580, 375);

		if(thu6.length()>9)
			g.drawString(thu6.substring(0,9) + "...", 580, 415);
		else
		g.drawString(thu6, 580, 415);
		
		if(thu7.length()>9)
			g.drawString(thu7.substring(0,9) + "...", 580, 455);
		else
		g.drawString(thu7, 580, 455);

		if(thu8.length()>9)
			g.drawString(thu8.substring(0,9) + "...", 580, 495);
		else
		g.drawString(thu8, 580, 495);

		if(thu9.length()>9)
			g.drawString(thu9.substring(0,9) + "...", 580, 535);
		else
		g.drawString(thu9, 580, 535);

		



		if(fri1.length()>9)
			g.drawString(fri1.substring(0,9) + "...", 720, 215);
		else
		g.drawString(fri1, 720, 215);

		if(fri2.length()>9)
			g.drawString(fri2.substring(0,9) + "...", 720, 255);
		else
		g.drawString(fri2, 720, 255);

		if(fri3.length()>9)
			g.drawString(fri3.substring(0,9) + "...", 720, 295);
		else
		g.drawString(fri3, 720, 295);

		if(fri4.length()>9)
			g.drawString(fri4.substring(0,9) + "...", 720, 335);
		else
		g.drawString(fri4, 720, 335);

		if(fri5.length()>9)
			g.drawString(fri5.substring(0,9) + "...", 720, 375);
		else
		g.drawString(fri5, 720, 375);

		if(fri6.length()>9)
			g.drawString(fri6.substring(0,9) + "...", 720, 415);
		else
		g.drawString(fri6, 720, 415);

		if(fri7.length()>9)
			g.drawString(fri7.substring(0,9) + "...", 720, 455);
		else
		g.drawString(fri7, 720, 455);
		
		if(fri8.length()>9)
			g.drawString(fri8.substring(0,9) + "...", 720, 495);
		else
		g.drawString(fri8, 720, 495);

		if(fri9.length()>9)
			g.drawString(fri9.substring(0,9) + "...", 720, 535);
		else
		g.drawString(fri9, 720, 535);
		

		g.drawRect(850, 92, 100, 40);//search
		g.drawRect(160, 92, 55, 40);//class
		g.drawRect(330, 92, 100, 40);//level
		g.drawRect(550, 92, 240, 40);//major

		
		g.setFont(game.font.deriveFont(22f));
		String classOf = String.format("%-"+4+ "s", game.classOf);
		String level = String.format("%-"+8+ "s", game.level);
		String major = String.format("%-"+20+ "s", game.major);
		g.drawString("Class: " + classOf + ", Level: " + level + ", Major: " + major + "    Search", 70, 120);
		
		for(int y = 150; y <=540; y+=40)
			g.drawRect(50, y, 775, 40);
		for(int i = 0; i < 5; i++)
			g.drawLine(150+135*i, 150, 150+135*i, 550);
		g.setFont(game.font.deriveFont(50f));
		

		
		if(game.choice[4])
		{
			g.setColor(Color.black);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
			g.fillRect(0, 0, game.getWidth(), game.getHeight());
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
			g.setFont(game.font.deriveFont(18f));
			g.fillRect(250, 200, 500, 300);
			g.setColor(Color.white);
			g.drawRect(250, 200, 500, 300);
			
			g.drawRect(280, 220, 440, 40);
			g.drawRect(280, 270, 440, 40);
			g.drawRect(280, 320, 440, 40);
			g.drawRect(280, 370, 440, 40);
			
			g.drawRect(420, 420, 40, 40);
			g.drawRect(540, 420, 40, 40);
			
			
	      	String myDriver = "com.mysql.cj.jdbc.Driver";
	      	String myUrl = "jdbc:mysql://localhost:3306/whusystem";
	      	int count = 0;
	      	
			try {
			Class.forName(myDriver);
	      	Connection conn = DriverManager.getConnection(myUrl, "root", "");
			String query = "SELECT * FROM teacher WHERE subid = 1";
	      	Statement ps2 = conn.createStatement();
			PreparedStatement preparedStmt = conn.prepareStatement(query);
		    ResultSet rs = ps2.executeQuery(query);
		    while(rs.next()) {
		    	count++;
		    }

			int page = count/4;
			if(count%4 == 0){}
			if(count%4 != 0)
				{page++;}
			
			if(game.page+1 > page)
			{
				game.page = page-1;
			}

			g.drawString( game.page+1+"/"+page, 485, 450);
			g.drawString("<", 436,445);
			g.drawString(">", 556,445);
		    rs = ps2.executeQuery(query);
		    
		    int count2 = 0;
		    while(rs.next()) {
		    	if(count2> game.page*4-1 && count2<(game.page*4)+4)
		    	{
		    		if(count2 == game.page*4) {
		    			g.drawString(rs.getString("subject"), 300, 250);
		    		}
		    		if(count2 == game.page*4+1){
		    			g.drawString(rs.getString("subject"), 300, 300);
		    		}
		    		if(count2 == game.page*4+2){
		    			g.drawString(rs.getString("subject"), 300, 350);
		    		}
		    		if(count2 == game.page*4+3){
		    			g.drawString(rs.getString("subject"), 300, 400);
		    		}
		    	}
		    	count2++;
		    }

      	  	
		    preparedStmt.execute();
		    conn.close();
			} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
			
		}
	}
}
