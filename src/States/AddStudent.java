package States;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Display.GamePanel;

public class AddStudent {
	GamePanel game;
	JLabel lbl = null;
	BufferedImage img = null;
	Image x = null;
	public AddStudent(GamePanel game)
	{
		this.game = game;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(Color.white);
		g.setFont(game.font.deriveFont(50f));
		g.drawString("ADD STUDENT", 350, 65);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
		g.setFont(game.font.deriveFont(15f));
		g.drawString("File Extensions accepted:", 730, 160);
		g.drawString(".png and .jpg", 770, 180);
		if(!game.choice[0] && !game.choice[1])
		{
		if(game.box[0] || game.selected == 0)
			g.fillRect(300, 180, 320, 30);	//Name
		if(game.box[1] || game.selected == 1)
			g.fillRect(310, 220, 50, 30);	//DD
		if(game.box[2] || game.selected == 2)
			g.fillRect(375, 220, 50, 30);	//MM
		if(game.box[3] || game.selected == 3)
			g.fillRect(440, 220, 100, 30);	//YYYY
		if(game.box[4] || game.selected == 4)
			g.fillRect(300, 260, 320, 30);	//Class of
		if(game.box[5] || game.selected == 5)
			g.fillRect(300, 300, 320, 30);	//Major
		if(game.box[6] || game.selected == 6)
			g.fillRect(300, 340, 320, 30);	//SchoolF
		if(game.box[7] || game.selected == 7)
			g.fillRect(300, 380, 320, 30);	//DormF
		if(game.box[8] || game.selected == 8)
			g.fillRect(300, 420, 320, 30);	//AddF
		if(game.box[9] || game.selected == 9) 
			g.fillRect(303, 473, 5, 5);	//25
		if(game.box[10] || game.selected == 10) 
			g.fillRect(373, 473, 5, 5);	//50
		if(game.box[11] || game.selected == 11) 
			g.fillRect(445, 473, 5, 5);	//75
		if(game.box[12] || game.selected == 12) 
			g.fillRect(513, 473, 5, 5);	//100
		if(game.box[13] )
			g.fillRect(755, 430, 150, 50);	//Add
		if(game.box[14] )
			g.fillRect(765, 210, 130, 150);	//Photo
		if(game.box[15] )
			g.fillRect(770,370,120,40);	//Cancel
		if(game.exitBox)
			g.fillRect(25, 25, 90, 40);		//Back
		}
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.setFont(game.font.deriveFont(19f));
		g.drawString("Back", 50, 50);
		
		g.drawString("   Full Name   : ", 120, 200);
		g.drawString(" Date of birth :      /     /          (dd/mm/yyyy)", 120, 240);
		g.drawString("   Class of    :", 120, 280);
		g.drawString("     Major     : ", 120, 320);
		g.drawString("  School fee   :", 120, 360);
		g.drawString("   Dorm fee    :", 120, 400);
		g.drawString("Additional fees:", 120, 440);
		
		g.drawString("  Scholarship?", 120, 480);
		g.drawString("25%", 320, 480);
		g.drawString("50%", 390, 480);
		g.drawString("75%", 460, 480);
		g.drawString("100%", 530, 480);

		g.drawString("ADD", 815, 460);
		g.drawString("Remove", 800, 395);
		
		
		
		switch(game.major)
		{
		case "Chinese Language":
			switch(game.level)
			{
			case "Bachelor":
				game.schoolF = "9000";
				game.dormF = "10000";
				game.otherF = "1500";
				break;
			case "Master":
				game.schoolF = "9000";
				game.dormF = "10000";
				game.otherF = "1500";
				break;
			case "PHD":
				game.schoolF = "9000";
				game.dormF = "10000";
				game.otherF = "1500";
				break;
			}
			break;
		case "Software Engineering":
			switch(game.level)
			{
			case "Bachelor":
				game.schoolF = "23000";
				game.dormF = "8000";
				game.otherF = "2000";
				break;
			case "Master":
				game.schoolF = "33000";
				game.dormF = "8000";
				game.otherF = "0";
				break;
			case "PHD":
				game.schoolF = "38000";
				game.dormF = "10000";
				game.otherF = "0";
				break;
			}
			break;
		case "Economy":
			switch(game.level)
			{
			case "Bachelor":
				game.schoolF = "19000";
				game.dormF = "10000";
				game.otherF = "2000";
				break;
			case "Master":
				game.schoolF = "28000";
				game.dormF = "10000";
				game.otherF = "0";
				break;
			case "PHD":
				game.schoolF = "35000";
				game.dormF = "15000";
				game.otherF = "0";
				break;
			}
			break;
		}
		
		g.drawString("                  " + game.name, 120, 200);	//Name
		g.drawString("                  " + game.day, 115, 240);	//dd
		g.drawString("                  " + game.month, 185, 240);	//mm
		g.drawString("                  " + game.year, 250, 240);	//year
		g.drawString("                  " + game.classOf, 120, 280);	//classof
		g.drawString("                  " + game.major, 120, 320);	//major
		g.drawString("                  " + game.schoolF, 120, 360);	//schoolF
		g.drawString("                  " + game.dormF, 120, 400);	//dormF
		g.drawString("                  " + game.otherF, 120, 440);	//AdditionalF
		if(game.clicked[0]) {
			g.fillRect(303, 473, 5, 5);	//25
			game.scholarship = 0.25f;
			}
		else if(game.clicked[1]) {
			g.fillRect(373, 473, 5, 5);	//50
			game.scholarship = 0.5f;
			}
		else if(game.clicked[2]) {
			g.fillRect(445, 473, 5, 5);	//75
			game.scholarship = 0.75f;
			}
		else if(game.clicked[3]) {
			g.fillRect(513, 473, 5, 5);	//100
			game.scholarship = 1f;
			}
		else
			game.scholarship = 0f;
		
		g.drawString("Picture", 790, 280);
		
		g.drawRect(25, 25, 90, 40);		//back
		g.drawRect(100, 150, 600, 350);	//form
		g.drawRect(765, 210, 130, 150);	//photo
		g.drawRect(755, 430, 150, 50);	//add button
		g.drawRect(300, 470, 10, 10);	//25
		g.drawRect(370, 470, 10, 10);	//50
		g.drawRect(442, 470, 10, 10);	//75
		g.drawRect(510, 470, 10, 10);	//100
		
		if(game.clicked[14])
		{
        	game.clicked[14] = false;
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
						img = ImageIO.read(new File(game.path));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x = img.getScaledInstance(130, 150, Image.SCALE_SMOOTH);
			        }
		        else {
		        	game.path = "";
		        	JOptionPane.showMessageDialog(game, "File type not supported!");
		        }
		        System.out.println("path: " + game.path);
		    }
		}
		g.drawRect(770,370,120,40);
		if(game.clicked[4])
		{
			game.clicked[4] = false;
			x= null;
		}
		
		g.drawImage(x, 765, 210, game);
		
		if(game.choice[0] || game.choice[1])
		{
			g.setColor(Color.black);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .7f));
			g.fillRect(0,0,game.getWidth(),game.getHeight());

			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
			g.fillRect(250, 220, 250, 270);	//choices
			g.setColor(Color.white);
			if(game.choice[0]) {
				g.drawString("Chinese", 335, 275);
				g.drawString("Software Eng", 310, 367);
				g.drawString("Economy", 335, 446);
			}
			else {
				g.drawString("Bachelor", 332, 275);
				g.drawString("Master", 340, 367);
				g.drawString("PHD", 355, 446);
			}
			g.drawRect(250, 220, 250, 270);	//choices
			g.drawRect(300, 250, 150, 40);	//Soft Eng
			g.drawRect(300, 340, 150, 40);	//Chinese Language
			g.drawRect(300, 420, 150, 40);	//Business
			
			g.setColor(Color.white);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
			if(game.box[0]) 
				g.fillRect(300, 250, 150, 40);	//Soft Eng
			if(game.box[1])
				g.fillRect(300, 340, 150, 40);	//Chinese Language
			if(game.box[2])
				g.fillRect(300, 420, 150, 40);	//Business
			
		}
		
		if(game.added)
		{
			g.setColor(Color.black);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .7f));
			g.fillRect(0,0,game.getWidth(),game.getHeight());

			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
			g.fillRect(250, 150, 500, 250);
			g.setColor(Color.white);
			g.drawRect(250, 150, 500, 250);
			g.setFont(game.font.deriveFont(20f));
			g.drawString("Student added Successfully!", 352, 177);
			g.drawString("Student Name: " + game.name, 270, 230);
			g.drawString("Student Id  : " + game.stuId, 270, 270);
			g.drawString("Total fee   : " + game.tot + " yuan", 270, 310);
			

			g.drawRect(380, 340, 152, 40);
			g.drawString("Add again?", 400, 365);
			
			g.drawRect(550, 340, 120, 40);
			g.drawString("Back", 583, 365);
			

			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
			if(game.box[0])
				g.fillRect(380, 340, 152, 40);
			if(game.box[1])
				g.fillRect(550, 340, 120, 40);
			
		}
	}
}
