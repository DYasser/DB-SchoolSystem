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

public class Courses {

	GamePanel game;

  	String mon1 = "",mon2= "",mon3= "",mon4= "",mon5= "",mon6= "",mon7= "",mon8= "",mon9= "";
  	String tue1 = "",tue2= "",tue3= "",tue4= "",tue5= "",tue6= "",tue7= "",tue8= "",tue9= "";
  	String wed1 = "",wed2= "",wed3= "",wed4= "",wed5= "",wed6= "",wed7= "",wed8= "",wed9= "";
  	String thu1 = "",thu2= "",thu3= "",thu4= "",thu5= "",thu6= "",thu7= "",thu8= "",thu9= "";
  	String fri1 = "",fri2= "",fri3= "",fri4= "",fri5= "",fri6= "",fri7= "",fri8= "",fri9= "";
	
	public Courses(GamePanel game)
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
		
		if(game.exitBox)
			g.fillRect(25, 25, 90, 40);

		g.setColor(Color.green);

		if(game.box[0])
		{
			g.fillRect(150, 190, 135, 40);
		}
		if(game.box[1])
		{
			g.fillRect(150,230,135,40);
		}
		if(game.box[2])
		{
			g.fillRect(150,270,135,40);
		}
		if(game.box[3])
		{
			g.fillRect(150,310,135,40);
		}
		if(game.box[4])
		{
			g.fillRect(150,350,135,40);
		}
		if(game.box[5])
		{
			g.fillRect(150,390,135,40);
		}
		if(game.box[6])
		{
			g.fillRect(150,430,135,40);
		}
		if(game.box[7])
		{
			g.fillRect(150,470,135,40);
		}
		if(game.box[8])
		{
			g.fillRect(150,510,135,40);
		}
		if(game.box[9])
		{
			g.fillRect(285,190,135,40);
		}if(game.box[10])
		{
			g.fillRect(285,230,135,40);
		}
		if(game.box[11])
		{
			g.fillRect(285,270,135,40);
		}
		if(game.box[12])
		{
			g.fillRect(285,310,135,40);
		}
		if(game.box[13])
		{
			g.fillRect(285,350,135,40);
		}
		if(game.box[14])
		{
			g.fillRect(285,390,135,40);
		}
		if(game.box[15])
		{
			g.fillRect(285,430,135,40);
		}
		if(game.box[16])
		{
			g.fillRect(285,470,135,40);
		}
		if(game.box[17])
		{
			g.fillRect(285,510,135,40);
		}
		if(game.box[18])
		{
			g.fillRect(420,190,135,40);
		}
		if(game.box[19])
		{
			g.fillRect(420,230,135,40);
		}if(game.box[20])
		{
			g.fillRect(420,270,135,40);
		}
		if(game.box[21])
		{
			g.fillRect(420,310,135,40);
		}
		if(game.box[22])
		{
			g.fillRect(420,350,135,40);
		}
		if(game.box[23])
		{
			g.fillRect(420,390,135,40);
		}
		if(game.box[24])
		{
			g.fillRect(420,430,135,40);
		}
		if(game.box[25])
		{
			g.fillRect(420,470,135,40);
		}
		if(game.box[26])
		{
			g.fillRect(420,510,135,40);
		}
		if(game.box[27])
		{
			g.fillRect(555,190,135,40);
		}
		if(game.box[28])
		{
			g.fillRect(555,230,135,40);
		}
		if(game.box[29])
		{
			g.fillRect(555,270,135,40);
		}if(game.box[30])
		{
			g.fillRect(555,310,135,40);
		}
		if(game.box[31])
		{
			g.fillRect(555,350,135,40);
		}
		if(game.box[32])
		{
			g.fillRect(555,390,135,40);
		}
		if(game.box[33])
		{
			g.fillRect(555,430,135,40);
		}
		if(game.box[34])
		{
			g.fillRect(555,470,135,40);
		}
		if(game.box[35])
		{
			g.fillRect(555,510,135,40);
		}
		if(game.box[36])
		{
			g.fillRect(690,190,135,40);
		}
		if(game.box[37])
		{
			g.fillRect(690,230,135,40);
		}
		if(game.box[38])
		{
			g.fillRect(690,270,135,40);
		}
		if(game.box[39])
		{
			g.fillRect(690,310,135,40);
		}if(game.box[40])
		{
			g.fillRect(690,350,135,40);
		}
		if(game.box[41])
		{
			g.fillRect(690,390,135,40);
		}
		if(game.box[42])
		{
			g.fillRect(690,430,135,40);
		}
		if(game.box[43])
		{
			g.fillRect(690,470,135,40);
		}
		if(game.box[44])
		{
			g.fillRect(690,510,135,40);
		}

		g.setColor(Color.white);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.drawRect(50, 150, 775, 400);
		g.drawLine(50, 150, 150, 190);
		g.drawString("Courses", 350, 50);
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
      		System.out.println("SELECT * FROM schedule WHERE level =  \"" + game.level + "\" AND major = \""+game.major + "\" AND class = \""+game.classOf+"\"");
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
	      		System.out.println("MOnday 111: " + my_rs.getString("1mon"));
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
	
		g.setFont(game.font.deriveFont(22f));
		g.drawString("Class: " + game.classOf + "    , Level: " + game.level + "    , Major: " + game.major, 70, 120);
		
		if(game.choice[4])
		{
			try {
			// create a mysql database connection
	      	String myDriver = "com.mysql.cj.jdbc.Driver";
	      	String myUrl = "jdbc:mysql://localhost:3306/whusystem";
	      	
			Class.forName(myDriver);
			
	      	Connection conn = DriverManager.getConnection(myUrl, "root", "");

			String change = "";
			switch(game.selected)
      	  	{
      	  	case 1:
      	  		change = "1mon";
      	  		break;

      	  	case 2:
      	  		change = "2mon";
      	  		break;

      	  	case 3:
      	  		change = "3mon";
      	  		break;

      	  	case 4:
      	  		change = "4mon";
      	  		break;

      	  	case 5:
      	  		change = "5mon";
      	  		break;

      	  	case 6:
      	  		change = "6mon";
      	  		break;

      	  	case 7:
      	  		change = "7mon";
      	  		break;

      	  	case 8:
      	  		change = "8mon";
      	  		break;

      	  	case 9:
      	  		change = "9mon";
      	  		break;

      	  	case 10:
      	  		change = "1tue";
      	  		break;

      	  	case 11:
      	  		change = "2tue";
      	  		break;

      	  	case 12:
      	  		change = "3tue";
      	  		break;

      	  	case 13:
      	  		change = "4tue";
      	  		break;

      	  	case 14:
      	  		change = "5tue";
      	  		break;

      	  	case 15:
      	  		change = "6tue";
      	  		break;

      	  	case 16:
      	  		change = "7tue";
      	  		break;

      	  	case 17:
      	  		change = "8tue";
      	  		break;

      	  	case 18:
      	  		change = "9tue";

      	  		break;

      	  	case 19:
      	  	change = "1wed";
      	  		break;

      	  	case 20:
      	  	change = "2wed";
      	  		break;

      	  	case 21:
      	  	change = "3wed";
      	  		break;

      	  	case 22:
      	  	change = "4wed";
      	  		break;

      	  	case 23:
      	  	change = "5wed";
      	  		break;

      	  	case 24:
      	  	change = "6wed";
      	  		break;

      	  	case 25:
      	  	change = "7wed";
      	  		break;

      	  	case 26:
      	  	change = "8wed";
      	  		break;

      	  	case 27:
      	  	change = "9wed";

      	  		break;

      	  	case 28:
      	  	change = "1thu";
      	  		break;

      	  	case 29:
      	  	change = "2thu";
      	  		break;

      	  	case 30:
      	  	change = "3thu";
      	  		break;

      	  	case 31:
      	  	change = "4thu";
      	  		break;
      	  		
      	  	case 32:
      	  	change = "5thu";
      	  		break;

      	  	case 33:
      	  	change = "6thu";
      	  		break;

      	  	case 34:
      	  	change = "7thu";
      	  		break;

      	  	case 35:
      	  	change = "8thu";
      	  		break;

      	  	case 36:
      	  	change = "9thu";

      	  		break;

      	  	case 37:
      	  	change = "1fri";
      	  		break;

      	  	case 38:
      	  	change = "2fri";
      	  		break;

      	  	case 39:
      	  	change = "3fri";
      	  		break;

      	  	case 40:
      	  	change = "4fri";
      	  		break;

      	  	case 41:
      	  	change = "5fri";
      	  		break;

      	  	case 42:
      	  	change = "6fri";
      	  		break;

      	  	case 43:
      	  	change = "7fri";
      	  		break;

      	  	case 44:
      	  	change = "8fri";
      	  		break;

      	  	case 45:
      	  	change = "9fri";
      	  		break;
      	  	}
			String query = "SELECT * FROM schedule WHERE level =  \"" + game.level + "\" AND major = \""+game.major + "\" AND class = \""+game.classOf+"\"";
	      	Statement ps2 = conn.createStatement();
			PreparedStatement preparedStmt = conn.prepareStatement(query);
		    ResultSet rs = ps2.executeQuery(query);
		    while(rs.next())
		    {
		    	System.out.println(change);
			    String subj = rs.getString(change);
		    	if(subj.compareTo("") != 0)
		    	{
		    		String teachid = "";
		    		int n = 0;
		    		query = "SELECT * FROM teacher where subject = \"" + subj + "\"";
		    		rs = ps2.executeQuery(query);
		    		
		    		while(rs.next())
				    {
		    			n++;
				    }
		    		
		    		int rand = (int)(Math.random()*10)%n+1;
		    		int subjct[] = new int[45];

					System.out.println("N: " + n);
		    		n = 0;
		    		rs = ps2.executeQuery(query);
		    		
		    		while(rs.next())
				    {	n++;
		    			if(n == rand)
				    	{
		    				teachid = rs.getString("id");
				    	}
				    }
		    		
		    		query = "SELECT * FROM schedule WHERE level =  \"" + game.level + "\" AND major = \""+game.major + "\" AND class = \""+game.classOf+"\"";
			      	ps2 = conn.createStatement();
					preparedStmt = conn.prepareStatement(query);
				    rs = ps2.executeQuery(query);

		    		n = 0;
				    while(rs.next())
				    {
				    	if(rs.getString("1mon").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 0;
				    	}
				    	 if(rs.getString("2mon").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 1;
				    	} if(rs.getString("3mon").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 2;
				    	} if(rs.getString("4mon").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 3;
				    	} if(rs.getString("5mon").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 4;
				    	} if(rs.getString("6mon").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 5;
				    	} if(rs.getString("7mon").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 6;
				    	} if(rs.getString("8mon").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 7;
				    	} if(rs.getString("9mon").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 8;
				    	} if(rs.getString("1tue").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 9;
				    	}
				    	 if(rs.getString("2tue").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 10;
				    	} if(rs.getString("3tue").compareTo(subj) == 0)
				    	{
				    		System.out.println(n);
				    		subjct[n++] = 11;
				    	} if(rs.getString("4tue").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 12;
				    	} if(rs.getString("5tue").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 13;
				    	} if(rs.getString("6tue").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 14;
				    	} if(rs.getString("7tue").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 15;
				    	} if(rs.getString("8tue").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 16;
				    	} if(rs.getString("9tue").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 17;
				    	} if(rs.getString("1wed").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 18;
				    	}
				    	 if(rs.getString("2wed").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 19;
				    	} if(rs.getString("3wed").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 20;
				    	} if(rs.getString("4wed").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 21;
				    	} if(rs.getString("5wed").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 22;
				    	} if(rs.getString("6wed").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 23;
				    	} if(rs.getString("7wed").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 24;
				    	} if(rs.getString("8wed").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 25;
				    	} if(rs.getString("9wed").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 26;
				    	} if(rs.getString("1thu").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 27;
				    	}
				    	 if(rs.getString("2thu").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 28;
				    	} if(rs.getString("3thu").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 29;
				    	} if(rs.getString("4thu").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 30;
				    	} if(rs.getString("5thu").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 31;
				    	} if(rs.getString("6thu").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 32;
				    	} if(rs.getString("7thu").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 33;
				    	} if(rs.getString("8thu").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 34;
				    	} if(rs.getString("9thu").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 35;
				    	} if(rs.getString("1fri").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 36;
				    	}
				    	 if(rs.getString("2fri").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 37;
				    	} if(rs.getString("3fri").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 38;
				    	} if(rs.getString("4fri").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 39;
				    	} if(rs.getString("5fri").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 40;
				    	} if(rs.getString("6fri").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 41;
				    	} if(rs.getString("7fri").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 42;
				    	} if(rs.getString("8fri").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 43;
				    	} if(rs.getString("9fri").compareTo(subj) == 0)
				    	{
				    		subjct[n++] = 44;
				    	}
				    }
		    		
		    		query = "SELECT * FROM courses WHERE name = \"" + subj + "\" AND studid = \"" + game.stuId + "\"";
		    		preparedStmt = conn.prepareStatement(query);
		    		rs =  ps2.executeQuery(query);
			    	preparedStmt.execute();
			    	if(rs.next())
			    	{
			    		for(int i = 0; i<n; i++)
			    		{
			    			game.box[subjct[i]] = false;
			    		}
		    			if(game.stuId.compareTo(rs.getString("studid")) == 0)
		    				{
		    				query = "DELETE FROM courses WHERE name = \"" + subj + "\" AND studid = \"" + game.stuId + "\"";
		    				preparedStmt = conn.prepareStatement(query);
					    	preparedStmt.execute();
		    				}
			    	}		
			    	else
		    		{
			    		for(int i = 0; i<n; i++)
			    		{
			    			game.box[subjct[i]] = true;
			    		}
				    	query = "INSERT INTO courses (name, teachid, studid, grade, remark)"
				    			+ "VALUES(?,?,?,"+0f+",'')";
				    	preparedStmt = conn.prepareStatement(query);
				    	preparedStmt.setString(1, subj);
				    	preparedStmt.setString(2, teachid);
				    	preparedStmt.setString(3, game.stuId);
				    	preparedStmt.execute();
	    			}
		    	}
		    	else{}
		    }
			game.choice[4] = false;
			conn.close();
			}catch(Exception e){e.printStackTrace();}			
		}
		
		if(game.choice[6])
		{
		try {
	      	String myDriver = "com.mysql.cj.jdbc.Driver";
	      	String myUrl = "jdbc:mysql://localhost:3306/whusystem";
	      	
			Class.forName(myDriver);
			
	      	Connection conn = DriverManager.getConnection(myUrl, "root", "");
			String query = "SELECT * FROM courses WHERE studid =  \"" + game.stuId + "\"";
	      	Statement ps2 = conn.createStatement();
			PreparedStatement preparedStmt = conn.prepareStatement(query);
		    ResultSet rs = ps2.executeQuery(query);
		    while(rs.next())
		    {
		    	String query1 = "SELECT * FROM schedule WHERE major =  \"" + game.major + "\" AND level = \"" + game.level + "\" AND class = \"" + game.classOf + "\"";

		    	Statement ps3 = conn.createStatement();
		    	PreparedStatement preparedStmt2 = conn.prepareStatement(query1);
		    	ResultSet rs2 = ps3.executeQuery(query1);
		    	String change = "";
		    	if(rs2.next())
			    for(int i=1; i<46; i++) {
			    	switch(i)
		      	  	{
		      	  	case 1:
		      	  		change = "1mon";
		      	  		break;
	
		      	  	case 2:
		      	  		change = "2mon";
		      	  		break;
	
		      	  	case 3:
		      	  		change = "3mon";
		      	  		break;
	
		      	  	case 4:
		      	  		change = "4mon";
		      	  		break;
	
		      	  	case 5:
		      	  		change = "5mon";
		      	  		break;
	
		      	  	case 6:
		      	  		change = "6mon";
		      	  		break;
	
		      	  	case 7:
		      	  		change = "7mon";
		      	  		break;
	
		      	  	case 8:
		      	  		change = "8mon";
		      	  		break;
	
		      	  	case 9:
		      	  		change = "9mon";
		      	  		break;
	
		      	  	case 10:
		      	  		change = "1tue";
		      	  		break;
	
		      	  	case 11:
		      	  		change = "2tue";
		      	  		break;
	
		      	  	case 12:
		      	  		change = "3tue";
		      	  		break;
	
		      	  	case 13:
		      	  		change = "4tue";
		      	  		break;
	
		      	  	case 14:
		      	  		change = "5tue";
		      	  		break;
	
		      	  	case 15:
		      	  		change = "6tue";
		      	  		break;
	
		      	  	case 16:
		      	  		change = "7tue";
		      	  		break;
	
		      	  	case 17:
		      	  		change = "8tue";
		      	  		break;
	
		      	  	case 18:
		      	  		change = "9tue";
	
		      	  		break;
	
		      	  	case 19:
		      	  	change = "1wed";
		      	  		break;
	
		      	  	case 20:
		      	  	change = "2wed";
		      	  		break;
	
		      	  	case 21:
		      	  	change = "3wed";
		      	  		break;
	
		      	  	case 22:
		      	  	change = "4wed";
		      	  		break;
	
		      	  	case 23:
		      	  	change = "5wed";
		      	  		break;
	
		      	  	case 24:
		      	  	change = "6wed";
		      	  		break;
	
		      	  	case 25:
		      	  	change = "7wed";
		      	  		break;
	
		      	  	case 26:
		      	  	change = "8wed";
		      	  		break;
	
		      	  	case 27:
		      	  	change = "9wed";
	
		      	  		break;
	
		      	  	case 28:
		      	  	change = "1thu";
		      	  		break;
	
		      	  	case 29:
		      	  	change = "2thu";
		      	  		break;
	
		      	  	case 30:
		      	  	change = "3thu";
		      	  		break;
	
		      	  	case 31:
		      	  	change = "4thu";
		      	  		break;
		      	  		
		      	  	case 32:
		      	  	change = "5thu";
		      	  		break;
	
		      	  	case 33:
		      	  	change = "6thu";
		      	  		break;
	
		      	  	case 34:
		      	  	change = "7thu";
		      	  		break;
	
		      	  	case 35:
		      	  	change = "8thu";
		      	  		break;
	
		      	  	case 36:
		      	  	change = "9thu";
	
		      	  		break;
	
		      	  	case 37:
		      	  	change = "1fri";
		      	  		break;
	
		      	  	case 38:
		      	  	change = "2fri";
		      	  		break;
	
		      	  	case 39:
		      	  	change = "3fri";
		      	  		break;
	
		      	  	case 40:
		      	  	change = "4fri";
		      	  		break;
	
		      	  	case 41:
		      	  	change = "5fri";
		      	  		break;
	
		      	  	case 42:
		      	  	change = "6fri";
		      	  		break;
	
		      	  	case 43:
		      	  	change = "7fri";
		      	  		break;
	
		      	  	case 44:
		      	  	change = "8fri";
		      	  		break;
	
		      	  	case 45:
		      	  	change = "9fri";
		      	  		break;
		      	  	}
			    	if(rs2.getString(change).compareTo(rs.getString("name")) == 0 )
			    	{
			    		game.box[i-1] = true;
			    	}
			    	
		    	}
		    }
		}catch(Exception exc) {exc.printStackTrace();}
		game.choice[6] = false;
		}
		for(int y = 150; y <=540; y+=40)
			g.drawRect(50, y, 775, 40);
		for(int i = 0; i < 5; i++)
			g.drawLine(150+135*i, 150, 150+135*i, 550);
		g.setFont(game.font.deriveFont(50f));
		
	}
}
