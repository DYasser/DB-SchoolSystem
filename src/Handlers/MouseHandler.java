package Handlers;

import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import App.Main;
import Display.GamePanel;

public class MouseHandler implements MouseListener{

	private GamePanel game;
	private int x, y;
	private LocalDate date = LocalDate.now();
	private boolean unvalidD = false, unvalidC = false, fillB = false;
	
	public MouseHandler(GamePanel game) throws ClassNotFoundException, SQLException
	{
		this.game = game;
	}
	
	public void update()	//Responsible of all Hover activities
	{
		x = MouseInfo.getPointerInfo().getLocation().x - Main.win.getX()-7;		//X coordinate
		y = MouseInfo.getPointerInfo().getLocation().y - Main.win.getY()-31;	//Y coordinate
		
		switch(game.state)
		{
		case HELP:{
			if(isIn(25,25,90,40))
				game.exitBox = true;
			else
				game.exitBox= false;
			break;}
		
		case MAINMENU:{	//Hover effect
			if(isIn(100, 250, 200, 150)) {
				game.box[0] = true;
			}
			else if(isIn(400, 250, 200, 150)) {
				game.box[1] = true;
			}
			else if(isIn(700, 250, 200, 150)) {
				game.box[2] = true;
			}
			else if(isIn(25, 25, 90, 40))
				game.exitBox = true;
			else{
				for(int x = 0; x < 4; x++)
					game.box[x] = false;
				game.exitBox = false;
			}
			break;}
		case ADMIN:{ //Hover effect
			if(isIn(400, 217, 400, 50))
				game.box[0] = true;
			else if(isIn(400, 317, 400, 50))
				game.box[1] = true;
			else if(isIn(475, 425, 100, 40))
				game.box[2] = true;
			else if(isIn(25, 25, 90, 40))
				game.exitBox = true;
			else{
				for(int x = 0; x < 3; x++)
					game.box[x] = false;
				game.exitBox = false;
			}
			break;}

		case ADMAINPAGE:{ //Hover effect
			if(isIn(40, 100, 135, 40) || (isIn(40, 100, 135, 150) && game.clicked[0]))
				game.box[0] = true;
			else if(isIn(210, 100, 135, 40) || (isIn(210, 100, 135, 150) && game.clicked[1]))
				game.box[1] = true;
			else if(isIn(380, 100, 135, 40) || (isIn(380, 100, 135, 150) && game.clicked[2]))
				game.box[2] = true;
			else if(isIn(550, 100, 135, 40) || (isIn(550, 100, 135, 150) && game.clicked[3]))
				game.box[3] = true;
			else if(isIn(725, 100, 215, 40))
				game.box[4] = true;
			else if(isIn(790, 20, 120, 50))
				game.exitBox = true;
			else{
				for(int x = 0; x < 5; x++)
				{
					game.box[x] = false;
					game.clicked[x] = false;
				}
				game.exitBox = false;
			}
			break;}

		case CHECKTEACHERS:{ //Hover effect
			if(isIn(85, 177, 490, 30))
				game.box[0]= true;
			else if(isIn(85, 218, 490, 30))
				game.box[1]= true;
			else if(isIn(85, 258, 490, 30))
				game.box[2]= true;
			else if(isIn(85, 299, 490, 30))
				game.box[3]= true;
			else if(isIn(85, 339, 490, 30))
				game.box[4]= true;
			else if(isIn(85, 379, 490, 30))
				game.box[5]= true;
			else if(isIn(85, 420, 490, 30))
				game.box[6]= true;
			else if(isIn(85, 460, 490, 30))
				game.box[7]= true;
			else if(isIn(710, 500, 25, 25)) 
				game.box[8]= true;
			else if(isIn(820, 500, 25, 25)) 
				game.box[9]= true;
			else if(isIn(25, 25, 90, 40)) 
				game.exitBox= true;
			else
			{
				for(int i = 0; i <10; i++)
					game.box[i] = false;
			}
			break;
		}

		case ADDSTUDENT:{ //Hover effect
			if(!game.choice[0] && !game.added)
				if(isIn(300, 180, 320, 30) )
					game.box[0] = true;
				else if(isIn(310, 220, 50, 30) )
					game.box[1] = true;
				else if(isIn(375, 220, 50, 30) )
					game.box[2] = true;
				else if(isIn(440, 220, 100, 30) )
					game.box[3] = true;
				else if(isIn(300, 260, 320, 30) )
					game.box[4] = true;
				else if(isIn(300, 300, 320, 30) )
					game.box[5] = true;
				else if(isIn(300, 340, 320, 30) )
					game.box[6] = true;
				else if(isIn(300, 380, 320, 30) )
					game.box[7] = true;
				else if(isIn(300, 420, 320, 30) )
					game.box[8] = true;
				else if(isIn(303, 473, 5, 5) )
					game.box[9] = true;
				else if(isIn(373, 473, 5, 5) )
					game.box[10] = true;
				else if(isIn(445, 473, 5, 5) )
					game.box[11] = true;
				else if(isIn(513, 473, 5, 5) )
					game.box[12] = true;
				else if(isIn(25, 25, 90, 40))
					game.exitBox = true;
				else if(isIn(755, 430, 150, 50))
					game.box[13] = true;
				else if(isIn(765, 210, 130, 150))
					game.box[14] = true;
				else if(isIn(770,370,120,40))
					game.box[15] = true;
				else{
					for(int x = 0; x < 16; x++)
					{
						game.box[x] = false;
					}
					game.exitBox = false;
				}
			if(game.choice[0] || game.choice[1])
			{
				if(isIn(300, 250, 150, 40) )
					game.box[0] = true;
				else if(isIn(300, 340, 150, 40) )
					game.box[1] = true;
				else if(isIn(300, 420, 150, 40) )
					game.box[2] = true;
				else{
					for(int x = 0; x < 3; x++)
						game.box[x] = false;
					}
			}
			
			if(game.added)
			{
				if(isIn(380, 340, 152, 40))
				{
					game.box[0] = true;
				}
				else if(isIn(550, 340, 120, 40))
				{
					game.box[1] = true;
				}
				else
				{
					game.box[0] = false;
					game.box[1] = false;
				}
			}
			break;
		}

		case REMOVESTUDENT:{ //Hover effect
			if(game.selected<0 || game.selected >7)
				if(isIn(170, 150, 720, 37))
				{
					game.box[0] = true;
				}
				else if(isIn(170, 190, 720, 37))
				{
					game.box[1] = true;
				}
				else if(isIn(170, 230, 720, 37))
				{
					game.box[2] = true;
				}
				else if(isIn(170, 270, 720, 37))
				{
					game.box[3] = true;
				}
				else if(isIn(170, 310, 720, 37))
				{
					game.box[4] = true;
				}
				else if(isIn(170, 350, 720, 37))
				{
					game.box[5] = true;
				}
				else if(isIn(170, 390, 720, 37))
				{
					game.box[6] = true;
				}
				else if(isIn(170, 430, 720, 37))
				{
					game.box[7] = true;
				}
				else if(isIn(425, 510, 35, 35))
				{
					game.box[8] = true;
				}
				else if(isIn(550, 510, 35, 35))
				{
					game.box[9] = true;
				}
				else if(isIn(25, 25, 90, 40)) 
					game.exitBox= true;
				else
				{
					for(int i = 0; i <10; i++)
						game.box[i] = false;
				}
			break;
		}
		
		case REMOVETEACHER:{ //Hover effect
			if(game.selected<0 || game.selected >7)
				if(isIn(170, 150, 720, 37))
				{
					game.box[0] = true;
				}
				else if(isIn(170, 190, 720, 37))
				{
					game.box[1] = true;
				}
				else if(isIn(170, 230, 720, 37))
				{
					game.box[2] = true;
				}
				else if(isIn(170, 270, 720, 37))
				{
					game.box[3] = true;
				}
				else if(isIn(170, 310, 720, 37))
				{
					game.box[4] = true;
				}
				else if(isIn(170, 350, 720, 37))
				{
					game.box[5] = true;
				}
				else if(isIn(170, 390, 720, 37))
				{
					game.box[6] = true;
				}
				else if(isIn(170, 430, 720, 37))
				{
					game.box[7] = true;
				}
				else if(isIn(425, 510, 35, 35))
				{
					game.box[8] = true;
				}
				else if(isIn(550, 510, 35, 35))
				{
					game.box[9] = true;
				}
				else if(isIn(25, 25, 90, 40)) 
					game.exitBox= true;
				else
				{
					for(int i = 0; i <10; i++)
						game.box[i] = false;
				}
			break;
		}
		case MODIFYSTUDENT:{ //Hover effect
			if(game.selected>-1 && game.selected <7) {
				if(game.choice[4])
				{
					if(isIn(300, 250, 150, 40))
						game.box[0] = true;	//name
					else if(isIn(300, 340, 150, 40))
						game.box[1] = true;//day
					else if(isIn(300, 420, 150, 40))
						game.box[2] = true;	//month
					else
					{
						for(int i = 0; i <3; i++)
							game.box[i] = false;
					}
				}
				else
				{
					if(isIn(385, 300, 350, 30))
						game.box[0] = true;	//name
					else if(isIn(395, 340, 30, 30))
						game.box[1] = true;//day
					else if(isIn(430, 340, 30, 30))
						game.box[2] = true;	//month
					else if(isIn(470, 340, 60, 30))
						game.box[3] = true;	//year
					else if(isIn(385, 380, 320, 30))
						game.box[4] = true;	//major
					else if(isIn(385, 420, 243, 30))
						game.box[6] = true;	//scholarship
					else
					{
						for(int i = 0; i <7; i++)
							game.box[i] = false;
					}}
				}
				
			else
			{
				if(isIn(170, 150, 720, 37))
					game.box[0] = true;	//
				else if(isIn(170, 190, 720, 37))
					game.box[1] = true;//
				else if(isIn(170, 230, 720, 37))
					game.box[2] = true;	//
				else if(isIn(170, 270, 720, 37))
					game.box[3] = true;	//
				else if(isIn(170, 310, 720, 37))
					game.box[4] = true;	//
				else if(isIn(170, 350, 720, 37))
					game.box[5] = true;	//
				else if(isIn(170, 390, 720, 37))
					game.box[6] = true;	//
				else if(isIn(170, 430, 720, 37))
					game.box[7] = true;	//
				else if(isIn(425, 510, 35, 35)) {
					game.box[8] = true;	//-
				}
				else if(isIn(550, 510, 35, 35)) {
					game.box[9] = true;	//+
				}
				else
				{
					for(int i = 0; i <10; i++)
						game.box[i] = false;
				}
			}
			break;
		}
		
		case MODIFYTEACHER:{ //Hover effect
			if(game.selected>-1 && game.selected <7) {
					if(isIn(385, 300, 350, 30))
						game.box[0] = true;	//name
					else if(isIn(395, 340, 30, 30))
						game.box[1] = true;//day
					else if(isIn(430, 340, 30, 30))
						game.box[2] = true;	//month
					else if(isIn(470, 340, 60, 30))
						game.box[3] = true;	//year
					else if(isIn(385, 380, 320, 30))
						game.box[4] = true;	//salary
					else if(isIn(385, 420, 320, 30))
						game.box[5] = true;	//subject
					
					else
					{
						for(int i = 0; i <6; i++)
							game.box[i] = false;
					}
				}
				
				
			else
			{
				if(isIn(170, 150, 720, 37))
					game.box[0] = true;	//
				else if(isIn(170, 190, 720, 37))
					game.box[1] = true;//
				else if(isIn(170, 230, 720, 37))
					game.box[2] = true;	//
				else if(isIn(170, 270, 720, 37))
					game.box[3] = true;	//
				else if(isIn(170, 310, 720, 37))
					game.box[4] = true;	//
				else if(isIn(170, 350, 720, 37))
					game.box[5] = true;	//
				else if(isIn(170, 390, 720, 37))
					game.box[6] = true;	//
				else if(isIn(170, 430, 720, 37))
					game.box[7] = true;	//
				else if(isIn(425, 510, 35, 35)) {
					game.box[8] = true;	//-
				}
				else if(isIn(550, 510, 35, 35)) {
					game.box[9] = true;	//+
				}
				else if(isIn(25, 25, 90, 40)) 
					game.exitBox = true;
				else
				{
					game.exitBox = false;
					for(int i = 0; i <10; i++)
						game.box[i] = false;
				}
			}
			break;
		}
		
		case ADDTEACHER:{ //Hover effect
			if(!game.choice[0] && !game.added)
				if(isIn(300, 180, 320, 30) )
					game.box[0] = true;
				else if(isIn(310, 220, 50, 30) )
					game.box[1] = true;
				else if(isIn(375, 220, 50, 30) )
					game.box[2] = true;
				else if(isIn(440, 220, 100, 30) )
					game.box[3] = true;
				else if(isIn(300, 300, 250, 30) )
					game.box[4] = true;
				else if(isIn(25, 25, 90, 40))
					game.exitBox = true;
				else if(isIn(755, 430, 150, 50))
					game.box[5] = true;
				else if(isIn(765, 210, 130, 150))
					game.box[6] = true;
				else if(isIn(770,370,120,40))
					game.box[7] = true;
				else if(isIn(300, 350, 250, 30))
					game.box[8] = true;
				else{
					for(int x = 0; x < 9; x++)
					{
						game.box[x] = false;
					}
					game.exitBox = false;
				}
			break;
		}
		
		case SCHEDULE:{ //Hover effect
			if(isIn(160, 92, 55, 40))
			{
				System.out.println("Class");
				game.box[0] = true;
			}
			else if(isIn(330, 92, 100, 40))
			{
				System.out.println("Level");
				game.box[1] = true;
			}
			else if(isIn(550, 92, 240, 40))
			{
				System.out.println("Major");
				game.box[2] = true;
			}
			else if(isIn(850, 92, 100, 40))
			{
				System.out.println("Search");
				game.box[3] = true;
			}
			else if(isIn(25, 25, 90, 40))
			{
				System.out.println("Back");
				game.exitBox = true;
			}
			else {
				for(int x = 0; x < 4; x++)
				{
					game.box[x] = false;
				}
				game.exitBox = false;
			}
			break;
		}

//----------------------------------------------------------STUDENT----------------------------------------------------------------------
		
		case STUDENT:{ //Hover effect
			if(isIn(400, 217, 400, 50))
				game.box[0] = true;
			else if(isIn(400, 317, 400, 50))
				game.box[1] = true;
			else if(isIn(475, 425, 100, 40))
				game.box[2] = true;
			else if(isIn(790, 20, 120, 50))
				game.exitBox = true;
			else{
				for(int x = 0; x < 3; x++)
					game.box[x] = false;
				game.exitBox = false;
			}
			break;	
		}
		
		case STUDENTMENU:{ //Hover effect
			if(isIn(100, 250, 200, 150))
				game.box[0] = true;
			else if(isIn(400, 250, 200, 150))
				game.box[1] = true;
			else if(isIn(700, 250, 200, 150))
				game.box[2] = true;
			else if(isIn(790, 20, 120, 50))
				game.exitBox = true;
			else{
				for(int x = 0; x < 3; x++)
					game.box[x] = false;
				game.exitBox = false;
			}
			break;	
		}

		case COURSES:{ //Hover effect
			if(isIn(25, 25, 90, 40))
			{
				game.exitBox = true;
			}
			else
				game.exitBox = false;
			break;
		}
		
		case FEES: //Hover effect
			if(isIn(25, 25, 90, 40))
			{
				game.exitBox = true;
			}
			else
				game.exitBox = false;
			break;
		
//----------------------------------------------------------TEACHER----------------------------------------------------------------------
			
		case TEACHER:{ //Hover effect
			if(isIn(400, 217, 400, 50))
				game.box[0] = true;
			else if(isIn(400, 317, 400, 50))
				game.box[1] = true;
			else if(isIn(475, 425, 100, 40))
				game.box[2] = true;
			else if(isIn(25, 25, 90, 40))
				game.exitBox = true;
			else{
				for(int x = 0; x < 3; x++)
					game.box[x] = false;
				game.exitBox = false;
			}
			break;	
		}

		case TEACHERMENU:{ //Hover effect
			if(isIn(100, 250, 200, 150))
				game.box[0] = true;
			else if(isIn(400, 250, 200, 150))
				game.box[1] = true;
			else if(isIn(700, 250, 200, 150))
				game.box[2] = true;
			else if(isIn(790, 20, 120, 50))
				game.exitBox = true;
			else{
				for(int x = 0; x < 3; x++)
					game.box[x] = false;
				game.exitBox = false;
			}
			break;	
		}
		
		case CHECKSTUDENTS:{ //Hover effect
			if(isIn(85, 177, 490, 30))
				game.box[0]= true;
			else if(isIn(85, 218, 490, 30))
				game.box[1]= true;
			else if(isIn(85, 258, 490, 30))
				game.box[2]= true;
			else if(isIn(85, 299, 490, 30))
				game.box[3]= true;
			else if(isIn(85, 339, 490, 30))
				game.box[4]= true;
			else if(isIn(85, 379, 490, 30))
				game.box[5]= true;
			else if(isIn(85, 420, 490, 30))
				game.box[6]= true;
			else if(isIn(85, 460, 490, 30))
				game.box[7]= true;
			else if(isIn(710, 500, 25, 25)) 
				game.box[8]= true;
			else if(isIn(820, 500, 25, 25)) 
				game.box[9]= true;
			else if(isIn(25, 25, 90, 40)) 
				game.exitBox= true;
			else
			{
				for(int i = 0; i <10; i++)
					game.box[i] = false;
			}
			break;
		}

		case CHECKCOURSES:{ //Hover effect
			if(isIn(85, 177, 770, 30))
				game.box[0]= true;
			else if(isIn(85, 211, 770, 30))
				game.box[1]= true;
			else if(isIn(85, 247, 770, 30))
				game.box[2]= true;
			else if(isIn(85, 280, 770, 30))
				game.box[3]= true;
			else if(isIn(85, 316, 770, 30))
				game.box[4]= true;
			else if(isIn(85, 349, 770, 30))
				game.box[5]= true;
			else if(isIn(85, 385, 770, 30))
				game.box[6]= true;
			else if(isIn(85, 420, 770, 30))
				game.box[7]= true;
			else if(isIn(400, 500, 25, 25)) 
				game.box[8]= true;
			else if(isIn(510, 500, 25, 25)) 
				game.box[9]= true;
			else if(isIn(25, 25, 90, 40)) 
				game.exitBox= true;
			else
			{
				for(int i = 0; i <10; i++)
					game.box[i] = false;
			}
			break;
		}
		
		case GRADE:{ //Hover effect
			if(isIn(290, 177, 380, 30))
				game.box[0]= true;
			else if(isIn(290, 211, 380, 30))
				game.box[1]= true;
			else if(isIn(290, 247, 380, 30))
				game.box[2]= true;
			else if(isIn(290, 280, 380, 30))
				game.box[3]= true;
			else if(isIn(290, 316, 380, 30))
				game.box[4]= true;
			else if(isIn(290, 349, 380, 30))
				game.box[5]= true;
			else if(isIn(290, 385, 380, 30))
				game.box[6]= true;
			else if(isIn(290, 420, 380, 30))
				game.box[7]= true;
			else if(isIn(400, 500, 25, 25)) 
				game.box[8]= true;
			else if(isIn(510, 500, 25, 25)) 
				game.box[9]= true;
			else if(isIn(25, 25, 90, 40)) 
				game.exitBox= true;
			else
			{
				for(int i = 0; i <10; i++)
					game.box[i] = false;
			}
			break;
		}
		
		case INPUTEXAM:{ //Hover effect
			if(isIn(380, 215, 160,40))
			{
				
				game.box[0] = true;
			}
			else if(isIn(360, 335, 210,40))
			{
				game.box[1] = true;
			}
			else if(isIn(400, 460, 120,40))
			{
				game.box[2] = true;
			}
			else if(isIn(25, 25, 90, 40))
			{
				game.exitBox = true;
			}
			else
			{
				for(int i = 0; i<3; i++)
				{
					game.box[i] = false;
				}
				game.exitBox = false;
			}break;
		}
		}
	}//------------------------------------------------------END HOVER-----------------------------------------------
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println(x + " - " + y);
		switch(game.state)
		{
		case HELP:{
			if(isIn(25,25,90,40))
				game.state = GamePanel.STATES.MAINMENU;
			break;}
		case MAINMENU:{
			if(isIn(889, 10, 40, 40))
			{
				game.clicked[0] = true;
				game.selected++;
				game.selected%=3;
				switch(game.selected)
				{
				case 0:
					game.color = game.dark;
					break;
				case 1:
					game.color = game.light;
					break;
				case 2:
					game.color = game.light2;
					break;
				}
			}
			if(isIn(100, 250, 200, 150)) {
				game.state = GamePanel.STATES.ADMIN;
				game.username = "";
				game.password = "";
				game.pswd = "";
				game.wrong = false;
			}
			else if(isIn(400, 250, 200, 150)) {
				game.state = GamePanel.STATES.TEACHER;
				game.username = "";
				game.password = "";
				game.pswd = "";
				game.wrong = false;
			}
			else if(isIn(700, 250, 200, 150)) {
				game.state = GamePanel.STATES.STUDENT;
				game.username = "";
				game.password = "";
				game.pswd = "";
				game.wrong = false;
			}
			else if(isIn(935, 12, 27, 35))
				game.state = GamePanel.STATES.HELP;
			else if(isIn(25, 25, 90, 40))
				System.exit(0);
			break;}
		
		case ADMIN:{
			if(isIn(400, 217, 400, 50))	//username
				game.selected = 1;
			else if(isIn(400, 317, 400, 50))	//password
				game.selected = 2;
			else if(isIn(475, 425, 100, 40))	//logIn
			{
				Statement stmt;
				try {
					stmt = Main.con.createStatement();
					String query = "SELECT * FROM admin;";
					ResultSet rs = stmt.executeQuery(query);
					
					while(rs.next())	//init admin
					{
						String name = rs.getString("username");
						String pswd = rs.getString("password");
						if(name.compareTo(game.username) == 0 && pswd.compareTo(game.password) == 0)
						{
							game.state = GamePanel.STATES.ADMAINPAGE;
						}
						else
							game.wrong = true;
					}} catch (SQLException e1) {e1.printStackTrace();}	
			}
			
			else if(isIn(25, 25, 90, 40))	//Back
				game.state = GamePanel.STATES.MAINMENU;
			break;
		}

		case ADMAINPAGE:{
			if(isIn(40, 100, 135, 40)) {
				game.box[0] = true;
				game.clicked[0] = true;
			}
			else if(isIn(210, 100, 135, 40)){
				game.box[1] = true;
				game.clicked[1] = true;
			}
			else if(isIn(380, 100, 135, 40)){
				game.box[2] = true;
				game.clicked[2] = true;
			}
			else if(isIn(550, 100, 135, 40)){
				game.box[3] = true;
				game.clicked[3] = true;
			}
			else if(isIn(725, 100, 215, 40)){
				game.box[4] = true;
				game.clicked[4] = true;
			}
			
			if(isIn(40, 140, 135, 55) && game.clicked[0]) {
				game.state = GamePanel.STATES.ADDTEACHER;
			 	game.selected = -1;
				game.added = false;
				clearT();
			}
			
			else if(isIn(40, 195, 135, 55) && game.clicked[0]) {
				game.state = GamePanel.STATES.ADDSTUDENT;
				game.choice[0] = false;
				game.choice[1] = false;
				game.added = false;
			 	game.clicked[4] = true;
			 	game.selected = -1;
				clearStu();
			}
			
			if(isIn(380, 140, 135, 55) && game.clicked[2]) {
				game.state = GamePanel.STATES.CHECKTEACHERS;
				game.page = 0;
				for(int i = 0; i < 7; i++)
					game.clicked[i] = false;
			}
			else if(isIn(380, 195, 135, 55) && game.clicked[2]) {
				game.state = GamePanel.STATES.CHECKSTUDENTS;
				game.page = 0;
				for(int i = 0; i < 7; i++)
					game.clicked[i] = false;	
			}
			
			if(isIn(550, 140, 135, 55) && game.clicked[3]) {
				game.page = 0;
				game.imgs = false;
				game.selected = -1;
				game.state = GamePanel.STATES.REMOVETEACHER;}
			
			else if(isIn(550, 195, 135, 55) && game.clicked[3]) {
				game.page = 0;
				game.imgs = false;
				game.selected = -1;
				game.state = GamePanel.STATES.REMOVESTUDENT;}

			if(isIn(210, 140, 135, 55) && game.clicked[1]) {
				game.page = 0;
				game.imgs = false;
				game.wrong = false;
				game.selected = -1;
				game.state = GamePanel.STATES.MODIFYTEACHER;
			}
			
			else if(isIn(210, 195, 135, 55) && game.clicked[1]) {
				game.page = 0;
				game.imgs = false;
				game.selected = -1;
				game.wrong = false;
				game.state = GamePanel.STATES.MODIFYSTUDENT;
			}
			
			if(isIn(725, 100, 215, 40))
			{
				game.state = GamePanel.STATES.SCHEDULE;
				game.classOf = "";
				game.major = "";
				game.level = "";
			}
			if(isIn(790, 20, 120, 50))
				game.state = GamePanel.STATES.MAINMENU;
				
			break;
		}
		
		case ADDSTUDENT:
			addStudent();
			break;
		case ADDTEACHER:
			addTeacher();
			break;
			
		case CHECKSTUDENTS:{
			for(int i = 0; i <8; i++)
				game.clicked[i] = false;
			if(isIn(85, 177, 490, 30)) {
				game.clicked[0]= true;
				game.imgs = true;
				game.selected = 0;
			}
			else if(isIn(85, 218, 490, 30)) {
				game.clicked[1]= true;
				game.imgs = true;
				game.selected = 1;
			}
			else if(isIn(85, 258, 490, 30)) {
				game.clicked[2]= true;
				game.imgs = true;
				game.selected = 2;
			}
			else if(isIn(85, 299, 490, 30)) {
				game.clicked[3]= true;
				game.imgs = true;
				game.selected = 3;
			}
			else if(isIn(85, 339, 490, 30)) {
				game.clicked[4]= true;
				game.imgs = true;
				game.selected = 4;
			}
			else if(isIn(85, 379, 490, 30)) {
				game.clicked[5]= true;
				game.imgs = true;
				game.selected = 5;
			}
			else if(isIn(85, 420, 490, 30)) {
				game.clicked[6]= true;
				game.imgs = true;
				game.selected = 6;
			}
			else if(isIn(85, 460, 490, 30)) {
				game.clicked[7]= true;
				game.imgs = true;
				game.selected = 7;
			}else
			{
				for(int i = 0; i <8;i++)
					game.clicked[i] = false;
				game.imgs = false;
				game.selected = -1;
			}
			
			if(isIn(710, 500, 25, 25)) {
				game.page--;
			}
			if(isIn(820, 500, 25, 25)) {
				game.page++;
			}
			if(isIn(25, 25, 90, 40)) 
				game.state= GamePanel.STATES.ADMAINPAGE;
			break;
		}

		case CHECKTEACHERS:{
			for(int i = 0; i <8; i++)
				game.clicked[i] = false;
			if(isIn(85, 177, 490, 30)) {
				game.clicked[0]= true;
				game.imgs = true;
				game.selected = 0;
			}
			else if(isIn(85, 218, 490, 30)) {
				game.clicked[1]= true;
				game.imgs = true;
				game.selected = 1;
			}
			else if(isIn(85, 258, 490, 30)) {
				game.clicked[2]= true;
				game.imgs = true;
				game.selected = 2;
			}
			else if(isIn(85, 299, 490, 30)) {
				game.clicked[3]= true;
				game.imgs = true;
				game.selected = 3;
			}
			else if(isIn(85, 339, 490, 30)) {
				game.clicked[4]= true;
				game.imgs = true;
				game.selected = 4;
			}
			else if(isIn(85, 379, 490, 30)) {
				game.clicked[5]= true;
				game.imgs = true;
				game.selected = 5;
			}
			else if(isIn(85, 420, 490, 30)) {
				game.clicked[6]= true;
				game.imgs = true;
				game.selected = 6;
			}
			else if(isIn(85, 460, 490, 30)) {
				game.clicked[7]= true;
				game.imgs = true;
				game.selected = 7;
			}
			else
			{
				System.out.println("out");
				for(int i = 0; i <8;i++)
					game.clicked[i] = false;
				game.imgs = false;
				game.selected = -1;
			}
			
			if(isIn(710, 500, 25, 25)) {
				game.page--;
			}
			if(isIn(820, 500, 25, 25)) {
				game.page++;
			}
			if(isIn(25, 25, 90, 40)) 
				game.state= GamePanel.STATES.ADMAINPAGE;
			}
		break;

		case REMOVESTUDENT:{

			if(game.selected<0 || game.selected >7) {
				if(isIn(425, 510, 35, 35)) {
					game.page--;
					game.imgs = true;
				}
				else if(isIn(550, 510, 35, 35)) {
					game.page++;
					game.imgs = true;
				}
				else if(isIn(170, 150, 720, 37))
				{
					game.selected = 0;
				}
				else if(isIn(170, 190, 720, 37))
				{
					game.selected = 1;
				}
				else if(isIn(170, 230, 720, 37))
				{
					game.selected = 2;
				}
				else if(isIn(170, 270, 720, 37))
				{
					game.selected = 3;
				}
				else if(isIn(170, 310, 720, 37))
				{
					game.selected = 4;
				}
				else if(isIn(170, 350, 720, 37))
				{
					game.selected = 5;
				}
				else if(isIn(170, 390, 720, 37))
				{
					game.selected = 6;
				}
				else if(isIn(170, 430, 720, 37))
				{
					game.selected = 7;
				}
				else if(isIn(25, 25, 90, 40)) 
					game.state= GamePanel.STATES.ADMAINPAGE;
				}
			else
			{
				if(isIn(362, 280, 60, 32))
				{
					game.choice[0] = true;
				}
				else if(isIn(479, 280, 60, 32))
				{
					game.choice[1] = true;
				}
			}
			break;
		}

		case REMOVETEACHER:{
			if(game.selected<0 || game.selected >7) {
				if(isIn(425, 510, 35, 35)) {
					game.page--;
					game.imgs = true;
				}
				else if(isIn(550, 510, 35, 35)) {
					game.page++;
					game.imgs = true;
				}
				else if(isIn(170, 150, 720, 37))
				{
					game.selected = 0;
				}
				else if(isIn(170, 190, 720, 37))
				{
					game.selected = 1;
				}
				else if(isIn(170, 230, 720, 37))
				{
					game.selected = 2;
				}
				else if(isIn(170, 270, 720, 37))
				{
					game.selected = 3;
				}
				else if(isIn(170, 310, 720, 37))
				{
					game.selected = 4;
				}
				else if(isIn(170, 350, 720, 37))
				{
					game.selected = 5;
				}
				else if(isIn(170, 390, 720, 37))
				{
					game.selected = 6;
				}
				else if(isIn(170, 430, 720, 37))
				{
					game.selected = 7;
				}
				else if(isIn(25, 25, 90, 40)) 
					game.state= GamePanel.STATES.ADMAINPAGE;
				}
			else
			{
				if(isIn(362, 280, 60, 32))
				{
					game.choice[0] = true;
				}
				else if(isIn(479, 280, 60, 32))
				{
					game.choice[1] = true;
				}
			}
			break;
		}
			
		case MODIFYSTUDENT:{
			if(game.selected<0 || game.selected >7) {
				if(isIn(425, 510, 35, 35)) {
					game.page--;
					game.imgs = true;
					
				}
				else if(isIn(550, 510, 35, 35)) {
					game.page++;
					game.imgs = true;
				}
				else if(isIn(170, 150, 720, 37))
				{
					game.selected = 0;
				}
				else if(isIn(170, 190, 720, 37))
				{
					game.selected = 1;
				}
				else if(isIn(170, 230, 720, 37))
				{
					game.selected = 2;
				}
				else if(isIn(170, 270, 720, 37))
				{
					game.selected = 3;
				}
				else if(isIn(170, 310, 720, 37))
				{
					game.selected = 4;
				}
				else if(isIn(170, 350, 720, 37))
				{
					game.selected = 5;
				}
				else if(isIn(170, 390, 720, 37))
				{
					game.selected = 6;
				}
				else if(isIn(170, 430, 720, 37))
				{
					game.selected = 7;
				}
				else if(isIn(25, 25, 90, 40)) 
					game.state= GamePanel.STATES.ADMAINPAGE;
				}
				else
				{

					if(game.choice[4])
					{
						if(game.added)
							{
							
							if(isIn(300, 250, 150, 40))
							{
								game.choice[4] = false;
								game.level = "Bachelor";
							}
							else if(isIn(300, 340, 150, 40))
							{	
								game.choice[4] = false;
								game.level = "Master";
							}
							else if(isIn(300, 420, 150, 40))
							{
								game.choice[4] = false;
								game.level = "PHD";
							}}
					}
					else if(game.choice[5])
						{
							if(isIn(550, 150, 150, 40))
							{
								game.scholarship = 0f;
								game.choice[5] = false;
							}
							
							if(isIn(550, 210, 150, 40))
							{
								game.scholarship = 0.25f;
								game.choice[5] = false;
							}
		
							if(isIn(550, 270, 150, 40))
							{
								game.scholarship = 0.50f;
								game.choice[5] = false;
							}

							if(isIn(550, 330, 150, 40))
							{
								game.scholarship = 0.75f;
								game.choice[5] = false;
							}
							
							if(isIn(550, 390, 150, 40))
							{
								game.scholarship = 1f;
								game.choice[5] = false;
							}
						}
					else
					{
						if(isIn(385, 420, 243, 30))
						{
							System.out.println("Scholarship");
							game.choice[4] = false;
							game.choice[5] = true;
						}
						
						if(isIn(395, 340, 30, 30))
						{
							System.out.println("day");
							game.choice[10] = true;
							game.choice[3] = false;
							game.choice[11] = false;
							game.choice[12] = false;
						}
						
						if(isIn(430, 340, 30, 30))
						{
							System.out.println("month");
							game.choice[11] = true;
							game.choice[3] = false;
							game.choice[10] = false;
							game.choice[12] = false;
						}
						
						if(isIn(470, 340, 60, 30))
						{
							System.out.println("year");
							game.choice[12] = true;
							game.choice[3] = false;
							game.choice[11] = false;
							game.choice[10] = false;
						}
						
						if(isIn(420, 80, 130, 150))
						{
							System.out.println("Photo");
							game.clicked[0] = true;
							game.choice[3] = false;
						}
	
						if(isIn(385, 300, 350, 30))
						{
							System.out.println("Name");
							game.choice[3] = true;
							game.choice[12] = false;
							game.choice[11] = false;
							game.choice[10] = false;
						}
						
						if(isIn(385, 380, 320, 30))
						{
							System.out.println("Major/level");
							game.choice[3] = false;
							game.added = false;
							game.choice[4] = true;
						}
						
						if(isIn(362, 510, 100, 32))
						{
							System.out.println("Save");
							int day = 0, month = 0,year = 0, classe = 0;
							
							try{
							 day = new Integer(game.day);
							 month = new Integer(game.month);
							 year = new Integer(game.year);
							 classe = new Integer(game.classOf);
							}
							catch(Exception excp) {};
							if(day < 1 || (day > 31 && month % 3 == 1) || (day > 31 && month == 8) //valid date
									|| (day > 29 && month == 2) || (day > 28 && month == 2 && year%4 != 0)
									|| (day > 30 && month == 4) || (day > 30 && month == 6) || (day > 30 && month == 9)
									|| (day > 30 && month == 11)|| year <date.getYear()-45 || year > date.getYear()-17
									|| month <1 || month >12)
							{
								unvalidD = true;
							}
							else
								unvalidD = false;
							
							if(game.day.compareTo("") == 0 || game.month.compareTo("") == 0 || game.year.compareTo("") == 0		//all filled
									|| game.name.compareTo("") == 0 || game.major.compareTo("") == 0 || game.level.compareTo("") == 0)
							{
								fillB = true;
								
							}
							else
								fillB = false;
							
							if(unvalidD || fillB)
							{
								if(fillB)
								{
									JOptionPane.showMessageDialog(game, "You should fill all the blanks before moving on!");
								}
								else if(unvalidD)
								{
									JOptionPane.showMessageDialog(game, "Unvalid year of birth!");
								}
							}
							else
								game.choice[0] = true;
						}
						
						else if(isIn(495, 510, 100, 32))
						{
							System.out.println("Cancel");
							game.choice[1] = true;
						}
					}
				}
			break;
		}
		
		case MODIFYTEACHER:{
			if(game.selected<0 || game.selected >7) {
				if(isIn(425, 510, 35, 35)) {
					game.page--;
					game.imgs = true;
					
				}
				else if(isIn(550, 510, 35, 35)) {
					game.page++;
					game.imgs = true;
				}
				else if(isIn(170, 150, 720, 37))
				{
					game.selected = 0;
				}
				else if(isIn(170, 190, 720, 37))
				{
					game.selected = 1;
				}
				else if(isIn(170, 230, 720, 37))
				{
					game.selected = 2;
				}
				else if(isIn(170, 270, 720, 37))
				{
					game.selected = 3;
				}
				else if(isIn(170, 310, 720, 37))
				{
					game.selected = 4;
				}
				else if(isIn(170, 350, 720, 37))
				{
					game.selected = 5;
				}
				else if(isIn(170, 390, 720, 37))
				{
					game.selected = 6;
				}
				else if(isIn(170, 430, 720, 37))
				{
					game.selected = 7;
				}
				else if(isIn(25, 25, 90, 40)) 
					game.state= GamePanel.STATES.ADMAINPAGE;
				}
				else
				{
					if(isIn(395, 340, 30, 30))
					{
						System.out.println("day");
						game.choice[10] = true;
						game.choice[3] = false;
						game.choice[11] = false;
						game.choice[12] = false;
						game.choice[13] = false;
						game.choice[14] = false;
					}
					
					if(isIn(430, 340, 30, 30))
					{
						System.out.println("month");
						game.choice[11] = true;
						game.choice[3] = false;
						game.choice[10] = false;
						game.choice[12] = false;
						game.choice[13] = false;
						game.choice[14] = false;
					}
					
					if(isIn(470, 340, 60, 30))
					{
						System.out.println("year");
						game.choice[12] = true;
						game.choice[3] = false;
						game.choice[11] = false;
						game.choice[10] = false;
						game.choice[13] = false;
						game.choice[14] = false;
					}
					
					if(isIn(420, 80, 130, 150))
					{
						System.out.println("Photo");
						game.clicked[0] = true;
						game.choice[3] = false;
					}
	
					if(isIn(385, 300, 350, 30))
					{
						System.out.println("Name");
						game.choice[3] = true;
						game.choice[12] = false;
						game.choice[11] = false;
						game.choice[10] = false;
						game.choice[13] = false;
						game.choice[14] = false;
					}

					if(isIn(385, 380, 320, 30))
					{
						System.out.println("salary");
						game.choice[13] = true;
						game.choice[12] = false;
						game.choice[11] = false;
						game.choice[10] = false;
						game.choice[3] = false;
						game.choice[14] = false;
					}
					

					if(isIn(385, 420, 320, 30))
					{
						System.out.println("subject");
						game.choice[13] = false;
						game.choice[12] = false;
						game.choice[11] = false;
						game.choice[10] = false;
						game.choice[3] = false;
						game.choice[14] = true;
					}
					
					if(isIn(362, 510, 100, 32))
					{
						System.out.println("Save");
						int day = 0, month = 0,year = 0;
						
						try{
						 day = new Integer(game.day);
						 month = new Integer(game.month);
						 year = new Integer(game.year);
						}
						catch(Exception excp) {};
						if(day < 1 || (day > 31 && month % 3 == 1) || (day > 31 && month == 8) //valid date
								|| (day > 29 && month == 2) || (day > 28 && month == 2 && year%4 != 0)
								|| (day > 30 && month == 4) || (day > 30 && month == 6) || (day > 30 && month == 9)
								|| (day > 30 && month == 11)|| year <date.getYear()-45 || year > date.getYear()-17
								|| month <1 || month >12)
						{
							unvalidD = true;
						}
						else
							unvalidD = false;
						
						if(game.day.compareTo("") == 0 || game.month.compareTo("") == 0 || game.year.compareTo("") == 0		//all filled
								|| game.name.compareTo("") == 0 || game.salary.compareTo("") == 0 || game.subject.compareTo("") == 0)
						{
							fillB = true;
							
						}
						else
							fillB = false;
						
						if(unvalidD || fillB)
						{
							if(fillB)
							{
								JOptionPane.showMessageDialog(game, "You should fill all the blanks before moving on!");
							}
							else if(unvalidD)
							{
								JOptionPane.showMessageDialog(game, "Unvalid year of birth!");
							}
						}
						else
							game.choice[0] = true;
					}
					
					else if(isIn(495, 510, 100, 32))
					{
						System.out.println("Cancel");
						game.choice[1] = true;
					}
				}
			break;
		}
		
		case SCHEDULE:{
			if(!game.choice[4]){
				
			if(isIn(150,190,675,360))
				game.choice[4] = true;
			if(isIn(150,190,135,40))
			{
				System.out.println("1-monday");
				game.selected = 1;
			}
			if(isIn(150,230,135,40))
			{
				System.out.println("2-monday");
				game.selected = 2;
			}
			if(isIn(150,270,135,40))
			{
				System.out.println("3-monday");
				game.selected = 3;
			}
			if(isIn(150,310,135,40))
			{
				System.out.println("4-monday");
				game.selected = 4;
			}
			if(isIn(150,350,135,40))
			{
				System.out.println("5-monday");
				game.selected = 5;
			}
			if(isIn(150,390,135,40))
			{
				System.out.println("6-monday");
				game.selected = 6;
			}
			if(isIn(150,430,135,40))
			{
				System.out.println("7-monday");
				game.selected = 7;
			}
			if(isIn(150,470,135,40))
			{
				System.out.println("8-monday");
				game.selected = 8;
			}
			if(isIn(150,510,135,40))
			{
				System.out.println("9-monday");
				game.selected = 9;
			}
			
			if(isIn(285,190,135,40))
			{
				System.out.println("1-tuesday");
				game.selected = 10;
			}
			if(isIn(285,230,135,40))
			{
				System.out.println("2-tuesday");
				game.selected = 11;
			}
			if(isIn(285,270,135,40))
			{
				System.out.println("3-tuesday");
				game.selected = 12;
			}
			if(isIn(285,310,135,40))
			{
				System.out.println("4-tuesday");
				game.selected = 13;
			}
			if(isIn(285,350,135,40))
			{
				System.out.println("5-tuesday");
				game.selected = 14;
			}
			if(isIn(285,390,135,40))
			{
				System.out.println("6-tuesday");
				game.selected = 15;
			}
			if(isIn(285,430,135,40))
			{
				System.out.println("7-tuesday");
				game.selected = 16;
			}
			if(isIn(285,470,135,40))
			{
				System.out.println("8-tuesday");
				game.selected = 17;
			}
			if(isIn(285,510,135,40))
			{
				System.out.println("9-tuesday");
				game.selected = 18;
			}
			
			if(isIn(420,190,135,40))
			{
				System.out.println("1-wednesday");
				game.selected = 19;
			}
			if(isIn(420,230,135,40))
			{
				System.out.println("2-wednesday");
				game.selected = 20;
			}
			if(isIn(420,270,135,40))
			{
				System.out.println("3-wednesday");
				game.selected = 21;
			}
			if(isIn(420,310,135,40))
			{
				System.out.println("4-wednesday");
				game.selected = 22;
			}
			if(isIn(420,350,135,40))
			{
				System.out.println("5-wednesday");
				game.selected = 23;
			}
			if(isIn(420,390,135,40))
			{
				System.out.println("6-wednesday");
				game.selected = 24;
			}
			if(isIn(420,430,135,40))
			{
				System.out.println("7-wednesday");
				game.selected = 25;
			}
			if(isIn(420,470,135,40))
			{
				System.out.println("8-wednesday");
				game.selected = 26;
			}
			if(isIn(420,510,135,40))
			{
				System.out.println("9-wednesday");
				game.selected = 27;
			}
			
			if(isIn(555,190,135,40))
			{
				System.out.println("1-thursday");
				game.selected = 28;
			}
			if(isIn(555,230,135,40))
			{
				System.out.println("2-thursday");
				game.selected = 29;
			}
			if(isIn(555,270,135,40))
			{
				System.out.println("3-thursday");
				game.selected = 30;
			}
			if(isIn(555,310,135,40))
			{
				System.out.println("4-thursday");
				game.selected = 31;
			}
			if(isIn(555,350,135,40))
			{
				System.out.println("5-thursday");
				game.selected = 32;
			}
			if(isIn(555,390,135,40))
			{
				System.out.println("6-thursday");
				game.selected = 33;
			}
			if(isIn(555,430,135,40))
			{
				System.out.println("7-thursday");
				game.selected = 34;
			}
			if(isIn(555,470,135,40))
			{
				System.out.println("8-thursday");
				game.selected = 35;
			}
			if(isIn(555,510,135,40))
			{
				System.out.println("9-thursday");
				game.selected = 36;
			}
			
			if(isIn(690,190,135,40))
			{
				System.out.println("1-friday");
				game.selected = 37;
			}
			if(isIn(690,230,135,40))
			{
				System.out.println("2-friday");
				game.selected = 38;
			}
			if(isIn(690,270,135,40))
			{
				System.out.println("3-friday");
				game.selected = 39;
			}
			if(isIn(690,310,135,40))
			{
				System.out.println("4-friday");
				game.selected = 40;
			}
			if(isIn(690,350,135,40))
			{
				System.out.println("5-friday");
				game.selected = 41;
			}
			if(isIn(690,390,135,40))
			{
				System.out.println("6-friday");
				game.selected = 42;
			}
			if(isIn(690,430,135,40))
			{
				System.out.println("7-friday");
				game.selected = 43;
			}
			if(isIn(690,470,135,40))
			{
				System.out.println("8-friday");
				game.selected = 44;
				
			}
			if(isIn(690,510,135,40))
			{
				System.out.println("9-friday");
				game.selected = 45;
			}
			
			if(isIn(160, 92, 55, 40))
			{
				System.out.println("Class");
				game.choice[0] = true;
				game.choice[2] = false;
				game.choice[3] = false;
			}
			else if(isIn(330, 92, 100, 40))
			{
				System.out.println("Level");
				game.choice[3] = true;
				game.choice[0] = false;
				game.choice[2] = false;
			}
			else if(isIn(550, 92, 240, 40))
			{
				System.out.println("Major");
				game.choice[2] = true;
				game.choice[0] = false;
				game.choice[3] = false;
			}
			else if(isIn(850, 92, 100, 40))
			{
				System.out.println("Search");
				game.choice[1] = true;
			}
			else if(isIn(25, 25, 90, 40))
			{
				game.state = GamePanel.STATES.ADMAINPAGE;
			}
		}
			break;
		}
		
//-------------------------------------------------------STUDENT--------------------------------------------------
		
		case STUDENT:{
			if(isIn(400, 217, 400, 50))	//username
				game.selected = 1;
			else if(isIn(400, 317, 400, 50)) //password
				game.selected = 2;
			else if(isIn(475, 425, 100, 40)) //logIn
			{
				Statement stmt;
				try {
					stmt = Main.con.createStatement();
					String query = "SELECT * FROM student;";
					ResultSet rs = stmt.executeQuery(query);
					
					while(rs.next())	//init student
					{				
						String id = rs.getString("id");
						String pswd = rs.getString("day") + rs.getString("month") + rs.getString("year");
						if(id.compareTo(game.username) == 0 && pswd.compareTo(game.password) == 0)
						{
							game.stuId = id;
							game.classOf = id.substring(0,4);
							game.name = rs.getString("name");
							game.major = rs.getString("major");
							game.scholarship = rs.getFloat("scholarship");
							game.level = rs.getString("level");
							game.schoolF = rs.getString("schoolFee");
							game.dormF = rs.getString("dormFee");
							game.otherF = rs.getString("otherFee");
							game.tot = rs.getString("tot");
							game.path = rs.getString("path");
							game.state = GamePanel.STATES.STUDENTMENU;
						}
						else
							game.wrong = true;
					}} catch (SQLException e1) {e1.printStackTrace();}	
			}
			
			else if(isIn(25, 25, 90, 40))	//Back
				game.state = GamePanel.STATES.MAINMENU;
			break;
		}
		
		case STUDENTMENU:{
			if(isIn(100, 250, 200, 150)) {
				game.state = GamePanel.STATES.COURSES;
				game.choice[1] = true;
				game.choice[4] = false;
				game.box[0] = false;
				game.choice[6] = true;
			}
			else if(isIn(400, 250, 200, 150)) {
				game.state = GamePanel.STATES.FEES;
				game.imgs = true;
			}
			else if(isIn(700, 250, 200, 150)) {
				game.state = GamePanel.STATES.EXAMS;
				game.choice[0] = false;
				game.selected = -1;
				game.page = -1;
				game.answer = "";
			}
			else if(isIn(790, 20, 120, 50))
				game.state = GamePanel.STATES.MAINMENU;
			break;
		}
		case EXAMS:{
			if(isIn(25,25,90,40)) {
				game.state = GamePanel.STATES.STUDENTMENU;
			}
			if(isIn(205, 160, 570, 30))
				game.selected = 0;
			if(isIn(205, 200, 570, 30))
				game.selected = 1;
			if(isIn(205, 240, 570, 30))
				game.selected = 2;
			if(isIn(205, 280, 570, 30))
				game.selected = 3;
			if(isIn(205, 320, 570, 30))
				game.selected = 4;
			if(isIn(205, 360, 570, 30))
				game.selected = 5;
			if(isIn(205, 400, 570, 30))
				game.selected = 6;
			if(isIn(205, 440, 570, 30))
				game.selected = 7;
			if(isIn(420,500,30,30))
				game.page--;
			if(isIn(540,500,30,30))
				game.page++;
			
			if(game.choice[0])
			{
				if(isIn(game.getWidth()-130, game.getHeight()-70, 100, 40))
				{
					double score = 0;
					double max = 0;
					for(int i =0; i<game.answer.length();i++)
					{
						max++;
						if(game.answer.substring(i, i+1).compareTo(game.answers.substring(i, i+1)) == 0)
						{
							score++;
						}
					}
					game.grade = Math.round((score/max)*100);
					if(game.grade == 0)
					{
						game.grade = 1;
					}
					game.choice[2] = true;
					game.choice[0] = false;
					game.selected = -1;
					game.answer = "";
					JOptionPane.showMessageDialog(game, "Answers submitted successfully! Let's hope for the best!");
				}
				
				try {
					if(isIn(330, 160, 30, 30) || isIn(330, 200, 30, 30) || isIn(330, 240, 30, 30) || isIn(330, 280, 30, 30) ||
							isIn(330, 320, 30, 30) || isIn(330, 360, 30, 30) || isIn(330, 400, 30, 30) || isIn(330, 440, 30, 30))
					{
				    	String first = game.answer.substring(0,game.selected+8*game.page);
				    	String second = game.answer.substring(game.selected+1+8*game.page,game.answer.length());
				    	game.answer = first + "A" + second;
				    	System.out.println(game.answer);
					}
					
					if(isIn(440, 160, 30, 30) || isIn(440, 200, 30, 30) || isIn(440, 240, 30, 30) || isIn(440, 280, 30, 30) ||
							isIn(440, 320, 30, 30) || isIn(440, 360, 30, 30) || isIn(440, 400, 30, 30) || isIn(440, 440, 30, 30))
					{
				    	String first = game.answer.substring(0,game.selected+8*game.page);
				    	String second = game.answer.substring(game.selected+1+8*game.page,game.answer.length());
				    	game.answer = first + "B" + second;
				    	System.out.println(game.answer);
					}
	
					if(isIn(550, 160, 30, 30) || isIn(550, 200, 30, 30) || isIn(550, 240, 30, 30) || isIn(550, 280, 30, 30) ||
							isIn(550, 320, 30, 30) || isIn(550, 360, 30, 30) || isIn(550, 400, 30, 30) || isIn(550, 440, 30, 30))
					{
				    	String first = game.answer.substring(0,game.selected+8*game.page);
				    	String second = game.answer.substring(game.selected+1+8*game.page,game.answer.length());
				    	game.answer = first + "C" + second;
				    	System.out.println(game.answer);
					}
	
					if(isIn(660, 160, 30, 30) || isIn(660, 200, 30, 30) || isIn(660, 240, 30, 30) || isIn(660, 280, 30, 30) ||
							isIn(660, 320, 30, 30) || isIn(660, 360, 30, 30) || isIn(660, 400, 30, 30) || isIn(660, 440, 30, 30))
					{
				    	String first = game.answer.substring(0,game.selected+8*game.page);
				    	String second = game.answer.substring(game.selected+1+8*game.page,game.answer.length());
				    	game.answer = first + "D" + second;
				    	System.out.println(game.answer);
					}
				}catch(Exception exp) {}
			}
			
			break;
		}
		
//-------------------------------------------------TEACHER-----------------------------------------------------------
		
		case TEACHER:{
			if(isIn(400, 217, 400, 50))	//username
				game.selected = 1;
			else if(isIn(400, 317, 400, 50))	//password
				game.selected = 2;
			else if(isIn(475, 425, 100, 40))	//logIn
			{
				Statement stmt;
				try {
					stmt = Main.con.createStatement();
					String query = "SELECT * FROM teacher;";
					ResultSet rs = stmt.executeQuery(query);
					
					while(rs.next())	//init teacher
					{
						String id = rs.getString("id");
						String pswd = rs.getString("day") + rs.getString("month") + rs.getString("year");
						if(id.compareTo(game.username) == 0 && pswd.compareTo(game.password) == 0)
						{
							game.stuId = id;
							game.name = rs.getString("name");
							game.subject = rs.getString("subject");
							game.salary = rs.getString("salary");
							game.path = rs.getString("path");
							game.state = GamePanel.STATES.TEACHERMENU;
						}
						else
							game.wrong = true;
					}} catch (SQLException e1) {e1.printStackTrace();}	
			}
			
			else if(isIn(25, 25, 90, 40))	//Back
				game.state = GamePanel.STATES.MAINMENU;
			break;
		}
		
		case TEACHERMENU:{
			if(isIn(100, 250, 200, 150))
				game.state = GamePanel.STATES.CHECKCOURSES;
			else if(isIn(400, 250, 200, 150))
				game.state = GamePanel.STATES.GRADE;
			else if(isIn(700, 250, 200, 150))
				game.state = GamePanel.STATES.INPUTEXAM;
			else if(isIn(790, 20, 120, 50))
				game.state = GamePanel.STATES.MAINMENU;
			break;
		}
		
		case COURSES:{
			if(isIn(150,190,675,360))
				game.choice[4] = true;
			if(isIn(150,190,135,40))
			{
				System.out.println("1-monday");
				game.selected = 1;
			}
			if(isIn(150,230,135,40))
			{
				System.out.println("2-monday");
				game.selected = 2;
			}
			if(isIn(150,270,135,40))
			{
				System.out.println("3-monday");
				game.selected = 3;
			}
			if(isIn(150,310,135,40))
			{
				System.out.println("4-monday");
				game.selected = 4;
			}
			if(isIn(150,350,135,40))
			{
				System.out.println("5-monday");
				game.selected = 5;
			}
			if(isIn(150,390,135,40))
			{
				System.out.println("6-monday");
				game.selected = 6;
			}
			if(isIn(150,430,135,40))
			{
				System.out.println("7-monday");
				game.selected = 7;
			}
			if(isIn(150,470,135,40))
			{
				System.out.println("8-monday");
				game.selected = 8;
			}
			if(isIn(150,510,135,40))
			{
				System.out.println("9-monday");
				game.selected = 9;
			}
			
			if(isIn(285,190,135,40))
			{
				System.out.println("1-tuesday");
				game.selected = 10;
			}
			if(isIn(285,230,135,40))
			{
				System.out.println("2-tuesday");
				game.selected = 11;
			}
			if(isIn(285,270,135,40))
			{
				System.out.println("3-tuesday");
				game.selected = 12;
			}
			if(isIn(285,310,135,40))
			{
				System.out.println("4-tuesday");
				game.selected = 13;
			}
			if(isIn(285,350,135,40))
			{
				System.out.println("5-tuesday");
				game.selected = 14;
			}
			if(isIn(285,390,135,40))
			{
				System.out.println("6-tuesday");
				game.selected = 15;
			}
			if(isIn(285,430,135,40))
			{
				System.out.println("7-tuesday");
				game.selected = 16;
			}
			if(isIn(285,470,135,40))
			{
				System.out.println("8-tuesday");
				game.selected = 17;
			}
			if(isIn(285,510,135,40))
			{
				System.out.println("9-tuesday");
				game.selected = 18;
			}
			
			if(isIn(420,190,135,40))
			{
				System.out.println("1-wednesday");
				game.selected = 19;
			}
			if(isIn(420,230,135,40))
			{
				System.out.println("2-wednesday");
				game.selected = 20;
			}
			if(isIn(420,270,135,40))
			{
				System.out.println("3-wednesday");
				game.selected = 21;
			}
			if(isIn(420,310,135,40))
			{
				System.out.println("4-wednesday");
				game.selected = 22;
			}
			if(isIn(420,350,135,40))
			{
				System.out.println("5-wednesday");
				game.selected = 23;
			}
			if(isIn(420,390,135,40))
			{
				System.out.println("6-wednesday");
				game.selected = 24;
			}
			if(isIn(420,430,135,40))
			{
				System.out.println("7-wednesday");
				game.selected = 25;
			}
			if(isIn(420,470,135,40))
			{
				System.out.println("8-wednesday");
				game.selected = 26;
			}
			if(isIn(420,510,135,40))
			{
				System.out.println("9-wednesday");
				game.selected = 27;
			}
			
			if(isIn(555,190,135,40))
			{
				System.out.println("1-thursday");
				game.selected = 28;
			}
			if(isIn(555,230,135,40))
			{
				System.out.println("2-thursday");
				game.selected = 29;
			}
			if(isIn(555,270,135,40))
			{
				System.out.println("3-thursday");
				game.selected = 30;
			}
			if(isIn(555,310,135,40))
			{
				System.out.println("4-thursday");
				game.selected = 31;
			}
			if(isIn(555,350,135,40))
			{
				System.out.println("5-thursday");
				game.selected = 32;
			}
			if(isIn(555,390,135,40))
			{
				System.out.println("6-thursday");
				game.selected = 33;
			}
			if(isIn(555,430,135,40))
			{
				System.out.println("7-thursday");
				game.selected = 34;
			}
			if(isIn(555,470,135,40))
			{
				System.out.println("8-thursday");
				game.selected = 35;
			}
			if(isIn(555,510,135,40))
			{
				System.out.println("9-thursday");
				game.selected = 36;
			}
			
			if(isIn(690,190,135,40))
			{
				System.out.println("1-friday");
				game.selected = 37;
			}
			if(isIn(690,230,135,40))
			{
				System.out.println("2-friday");
				game.selected = 38;
			}
			if(isIn(690,270,135,40))
			{
				System.out.println("3-friday");
				game.selected = 39;
			}
			if(isIn(690,310,135,40))
			{
				System.out.println("4-friday");
				game.selected = 40;
			}
			if(isIn(690,350,135,40))
			{
				System.out.println("5-friday");
				game.selected = 41;
			}
			if(isIn(690,390,135,40))
			{
				System.out.println("6-friday");
				game.selected = 42;
			}
			if(isIn(690,430,135,40))
			{
				System.out.println("7-friday");
				game.selected = 43;
			}
			if(isIn(690,470,135,40))
			{
				System.out.println("8-friday");
				game.selected = 44;
				
			}
			if(isIn(690,510,135,40))
			{
				System.out.println("9-friday");
				game.selected = 45;
			}
			if(isIn(25, 25, 90, 40))
			{
				game.state = GamePanel.STATES.STUDENTMENU;
			}
			break;
		}

		case CHECKCOURSES:{
			for(int i = 0; i <8; i++)
				game.clicked[i] = false;
			
			if(isIn(430, 177, 440, 30))
			{
				game.selected = 0;
			}
			else if(isIn(430, 211, 440, 30))
			{
				game.selected = 1;
			}
			else if(isIn(430, 247, 440, 30))
			{
				game.selected = 2;
			}
			else if(isIn(430, 280, 440, 30))
			{
				game.selected = 3;
			}
			else if(isIn(430, 316, 440, 30))
			{
				game.selected = 4;
			}
			else if(isIn(430, 349, 440, 30))
			{
				game.selected = 5;
			}
			else if(isIn(430, 385, 440, 30))
			{
				game.selected = 6;
			}
			else if(isIn(430, 420, 440, 30))
			{
				game.selected = 7;
			}
			if(isIn(85, 177, 770, 30)) {
				game.clicked[0]= true;
			}
			else if(isIn(85, 211, 770, 30)) {
				game.clicked[1]= true;
			}
			else if(isIn(85, 247, 770, 30)) {
				game.clicked[2]= true;
			}
			else if(isIn(85, 280, 770, 30)) {
				game.clicked[3]= true;
			}
			else if(isIn(85, 316, 770, 30)) {
				game.clicked[4]= true;
			}
			else if(isIn(85, 349, 770, 30)) {
				game.clicked[5]= true;
			}
			else if(isIn(85, 385, 770, 30)) {
				game.clicked[6]= true;
			}
			else if(isIn(85, 420, 770, 30)) {
				game.clicked[7]= true;
			}
			if(isIn(400, 500, 25, 25)) {
				game.page--;
			}
			if(isIn(510, 500, 25, 25)) {
				game.page++;
			}
			if(isIn(25, 25, 90, 40)) 
				game.state= GamePanel.STATES.TEACHERMENU;
			break;
		}
		
		case GRADE:{
			for(int i = 0; i <8; i++)
				game.clicked[i] = false;
			if(isIn(290, 177, 380, 30)) {
				game.selected = 0;
				game.clicked[0]= true;
			}
			else if(isIn(290, 211, 380, 30)) {
				game.selected = 1;
				game.clicked[1]= true;
			}
			else if(isIn(290, 247, 380, 30)) {
				game.selected = 2;
				game.clicked[2]= true;
			}
			else if(isIn(290, 280, 380, 30)) {
				game.selected = 3;
				game.clicked[3]= true;
			}
			else if(isIn(290, 316, 380, 30)) {
				game.selected = 4;
				game.clicked[4]= true;
			}
			else if(isIn(290, 349, 380, 30)) {
				game.selected = 5;
				game.clicked[5]= true;
			}
			else if(isIn(290, 385, 380, 30)) {
				game.selected = 6;
				game.clicked[6]= true;
			}
			else if(isIn(290, 420, 380, 30)) {
				game.selected = 7;
				game.clicked[7]= true;
			}
			if(isIn(400, 500, 25, 25)) {
				game.page--;
			}
			if(isIn(510, 500, 25, 25)) {
				game.page++;
			}
			if(isIn(25, 25, 90, 40)) 
				game.state= GamePanel.STATES.TEACHERMENU;
			break;	
		}
		
		case INPUTEXAM:{
			if(isIn(380, 215, 160,40))
			{
				JFileChooser jfc = new JFileChooser();
			    jfc.showDialog(null,"Please Select the File");
			    jfc.setVisible(true);
			    File filename = jfc.getSelectedFile();
			    if(filename != null)
			    {
			        game.path = filename.getAbsolutePath();
			        System.out.println(game.path);
	        		JOptionPane.showMessageDialog(game, "Successfully imported!");
				}
			    else 
			    {
		        	game.path = "";
		        	JOptionPane.showMessageDialog(game, "Please choose a file!");
		        }
			}
			
			if(isIn(360, 335, 210,40))
			{
				JFileChooser jfc = new JFileChooser();
			    jfc.showDialog(null,"Please Select the File");
			    jfc.setVisible(true);
			    File filename = jfc.getSelectedFile();
			    if(filename != null)
			    {
			        game.path2 = filename.getAbsolutePath();
			        String ext = game.path2.substring(game.path2.length()-3,game.path2.length());
			        if(ext.compareTo("txt") == 0)
				        {
			        		JOptionPane.showMessageDialog(game, "Successfully imported!");
				        }
			        else {
			        	game.path2 = "";
			        	JOptionPane.showMessageDialog(game, "File type not supported! Please use a .txt file.");
			        }
			    }
			}
			if(isIn(400, 460, 120,40))
			{
				if(game.path.compareTo("") != 0 && game.path2.compareTo("") != 0)
				{
					try
			    	{
			      	  // create a mysql database connection
			      	  String myDriver = "com.mysql.cj.jdbc.Driver";
			      	  String myUrl = "jdbc:mysql://localhost:3306/whusystem";
			      	  Class.forName(myDriver);
			      	  Connection conn = DriverManager.getConnection(myUrl, "root", "");
			      	  Connection conn2 = DriverManager.getConnection(myUrl, "root", "");
			      	  Statement stmt = conn.createStatement();
			      	  String query = "SELECT * from exam where teachid = \"" + game.stuId + "\" AND subject = \"" +game.subject+ "\"";
			      	  ResultSet rs = stmt.executeQuery(query);
			      	  PreparedStatement preparedStmt = null;
			      	  if(rs.next())
			      	  {

			      		  query = "UPDATE exam SET answerp = ?, examp = ? WHERE teachid = \"" + game.stuId + "\" AND subject = \"" +game.subject+ "\"";
			      	  
				      	  // create the mysql insert preparedstatement
				      	  preparedStmt = conn2.prepareStatement(query);
				          preparedStmt.setString(1, game.path2);
				          preparedStmt.setString(2, game.path);
				          JOptionPane.showMessageDialog(game, "Saved Successfully!");
			      	  }else
			      	  {
			      		  query = "INSERT INTO exam (teachid, subject, answerp, examp)"
			      	    		+ "VALUES (?, ?, ?, ?)";
			      	  
				      	  // create the mysql insert preparedstatement
				      	  preparedStmt = conn2.prepareStatement(query);
				      	  preparedStmt.setString (1, game.stuId);
				          preparedStmt.setString (2, game.subject);
				          preparedStmt.setString   (3, game.path2);
				          preparedStmt.setString(4, game.path);
				          JOptionPane.showMessageDialog(game, "Saved Successfully!");
			      	  }
			          preparedStmt.execute();
			      	  // the mysql insert statement
			      	  
			    	}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				else
				{
		        	JOptionPane.showMessageDialog(game, "Please import files!");
				}
			}
			if(isIn(25, 25, 90, 40))
			{
				game.state = GamePanel.STATES.TEACHERMENU;
			}
		}
		break;
		}
	}
		
	@Override
	public void mouseReleased(MouseEvent e) {
		switch(game.state)
		{
		case ADDSTUDENT:{
			if(game.choice[1])
			{
				if(isIn(300, 250, 150, 40))
				{
					game.level = "Bachelor";
					game.choice[1] = false;
					game.choice[0] = true;
				}
				else if(isIn(300, 340, 150, 40))
				{
					game.level = "Master";
					game.choice[1] = false;
					game.choice[0] = true;
				}
				else if(isIn(300, 420, 150, 40))
				{
					game.level = "PHD";
					game.choice[1] = false;
					game.choice[0] = true;
				}	
			}
			break;
		}

		case MODIFYSTUDENT:{
			if(!game.added)
				{if(isIn(300, 250, 150, 40))
				{
					game.major = "Chinese Language";
					game.added = true;
				}
				else if(isIn(300, 340, 150, 40))
				{	
					System.out.println("Yh bish" + game.added);
					game.major = "Software Engineering";
					game.added = true;
				}
				else if(isIn(300, 420, 150, 40))
				{
					game.major = "Economy";
					game.added = true;
				}}
			break;
		}
		case SCHEDULE:{
			if(game.choice[4]) {
				
				if(isIn(280, 220, 440, 40))
				{
					System.out.println("1");
					game.clicked[0] = true;
				    game.choice[4] = false;
				    try {
				      	String myDriver = "com.mysql.cj.jdbc.Driver";
				      	String myUrl = "jdbc:mysql://localhost:3306/whusystem";
						Class.forName(myDriver);
				      	Connection conn = DriverManager.getConnection(myUrl, "root", "");
						String query = "SELECT * FROM teacher WHERE subid = 1";
				      	Statement ps2 = conn.createStatement();
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						ResultSet rs = ps2.executeQuery(query);
					    
					    String a = "";
					    
					    int count2 = 0;
					    while(rs.next()) {
					    	if(count2 == game.page*4) {
					    		a = rs.getString("subject");
					    	}
					    	count2++;
					    }
						preparedStmt.execute();
						conn.close();
							
					    game.subject = a;
				    } catch (ClassNotFoundException | SQLException exp) {exp.printStackTrace();}

					schedule();
			    
				}
				else if(isIn(280, 270, 440, 40))
				{
					System.out.println("2");
					game.clicked[1] = true;
				    game.choice[4] = false;
				    try {
				      	String myDriver = "com.mysql.cj.jdbc.Driver";
				      	String myUrl = "jdbc:mysql://localhost:3306/whusystem";
						Class.forName(myDriver);
				      	Connection conn = DriverManager.getConnection(myUrl, "root", "");
						String query = "SELECT * FROM teacher WHERE subid = 1";
				      	Statement ps2 = conn.createStatement();
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						ResultSet rs = ps2.executeQuery(query);
					    
					    String b = "";
					    
					    int count2 = 0;
					    while(rs.next()) {
					    	if(count2 == game.page*4+1){
					    		b = rs.getString("subject");
					    	}
					    	
					    	count2++;
					    }
						preparedStmt.execute();
						conn.close();
							
					    game.subject = b;
				    } catch (ClassNotFoundException | SQLException exp) {exp.printStackTrace();}

					schedule();
				}
				else if(isIn(280, 320, 440, 40))
				{
					System.out.println("3");
					game.clicked[2] = true;
				    game.choice[4] = false;
				    try {
				      	String myDriver = "com.mysql.cj.jdbc.Driver";
				      	String myUrl = "jdbc:mysql://localhost:3306/whusystem";
						Class.forName(myDriver);
				      	Connection conn = DriverManager.getConnection(myUrl, "root", "");
						String query = "SELECT * FROM teacher WHERE subid = 1";
				      	Statement ps2 = conn.createStatement();
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						ResultSet rs = ps2.executeQuery(query);
					    
					    String c = "";
					    
					    int count2 = 0;
					    while(rs.next()) {
				    		if(count2 == game.page*4+2){
					    		c = rs.getString("subject");
					    		}
				    		count2++;}
						preparedStmt.execute();
						conn.close();
					    game.subject = c;
					    System.out.println("subject: "  + game.subject);
				    } catch (ClassNotFoundException | SQLException exp) {exp.printStackTrace();}

					schedule();
				}
				else if(isIn(280, 370, 440, 40))
				{
					System.out.println("4");
					game.clicked[3] = true;
				    game.choice[4] = false;
				    try {
				      	String myDriver = "com.mysql.cj.jdbc.Driver";
				      	String myUrl = "jdbc:mysql://localhost:3306/whusystem";
						Class.forName(myDriver);
				      	Connection conn = DriverManager.getConnection(myUrl, "root", "");
						String query = "SELECT * FROM teacher WHERE subid = 1";
				      	Statement ps2 = conn.createStatement();
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						ResultSet rs = ps2.executeQuery(query);
					    
					    String d = "";
					    
					    int count2 = 0;
					    while(rs.next()) {
				    		if(count2 == game.page*4+3){
				    			d = rs.getString("subject");
				    		}
					    	count2++;
					    }
					    game.subject = d;
						preparedStmt.execute();
						conn.close();
						
				    } catch (ClassNotFoundException | SQLException exp) {exp.printStackTrace();}

					schedule();
				}
				else if(isIn(420, 420, 40, 40))
				{
					System.out.println("<");
					if(game.page-1>=0)
						game.page--;
				}
				else if(isIn(540, 420, 40, 40))
				{
					System.out.println(">");
					game.page++;
			}}
			break;
		}
		case FEES:{
			if(isIn(25, 25, 90, 40))
			{
				game.state = GamePanel.STATES.STUDENTMENU;
			}
			break;
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
	public void clearStu()
	{
		for(int i = 0; i < 5; i++)
		{
			game.clicked[i] = false;
		}
		game.name = game.day = game.year = game.month = game.major = game.classOf = game.otherF = game.schoolF = game.dormF 
				= game.path = "";
		game.scholarship = 0f;
	}
	
	public void clearT()
	{
		for(int i = 0; i < 5; i++)
		{
			game.clicked[i] = false;
		}
		game.clicked[4] = true;
		game.name = game.day = game.year = game.month = game.subject = game.salary = game.path = "";
	}
	
	private void schedule()
	{
		try {// create a mysql database connection
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
	      	
	      	String query = "SELECT * FROM teacher WHERE subid = 1";
	      	Statement ps2 = conn.createStatement();
			PreparedStatement preparedStmt = conn.prepareStatement(query);
		    ResultSet rs = ps2.executeQuery(query);
		    while(rs.next())
		    	System.out.println(rs.getString("subject"));
		    preparedStmt.execute();
		    if(game.level.compareTo("") == 0 || game.major.compareTo("") == 0 || game.classOf.compareTo("") == 0)
		    {	JOptionPane.showMessageDialog(game, "Fill all boxes!");
		    	game.selected = -1;}
		    else {
		    	query = "UPDATE schedule SET "+ change +" = ? WHERE level =  \"" + game.level + "\" AND major = \""+game.major + "\" AND class = \""+game.classOf+"\"";
			    preparedStmt = conn.prepareStatement(query);
			    preparedStmt.setString(1, game.subject);
	
			    preparedStmt.execute();
			    conn.close();
		    }
		}
		catch(Exception e){
		    System.out.println("nope");}
		game.choice[1] = true;
	}

	public void addStudent()
	{
		if(!game.choice[0] && !game.added)
			if(isIn(765, 210, 130, 150)) {
				game.clicked[14] = true;
			}
			if(isIn(300, 180, 250, 30)) {
				game.box[0] = true;
				game.selected = 0;
			}
			else if(isIn(310, 220, 50, 30)){
				game.box[1] = true;
				game.selected = 1;
			}
			else if(isIn(375, 220, 50, 30)){
				game.box[2] = true;
				game.selected = 2;
			}
			else if(isIn(440, 220, 100, 30)){
				game.box[3] = true;
				game.selected = 3;
			}
			else if(isIn(300, 260, 250, 30)){
				game.box[4] = true;
				game.selected = 4;
			}
			else if(isIn(300, 300, 250, 30)){
				game.choice[1] = true;
				System.out.println("true");
			}
			else if(isIn(770,370,120,40)){
				game.clicked[4] = true;
			}
			else if(isIn(300, 470, 10, 10)){
				game.box[9] = !game.box[9];
				game.clicked[0] = !game.clicked[0];
				game.clicked[1] = false;
				game.clicked[2] = false;
				game.clicked[3] = false;
			}
			else if(isIn(370, 470, 10, 10)){
				game.box[10] = !game.box[10];
				game.clicked[1] = !game.clicked[1];
				game.clicked[0] = false;
				game.clicked[2] = false;
				game.clicked[3] = false;
			}
			else if(isIn(442, 470, 10, 10)){
				game.box[11] = true;
				game.clicked[2] = !game.clicked[2];
				game.clicked[1] = false;
				game.clicked[0] = false;
				game.clicked[3] = false;
			}
			else if(isIn(510, 470, 10, 10)){
				game.box[12] = !game.box[12];
				game.clicked[3] = !game.clicked[3];
				game.clicked[1] = false;
				game.clicked[2] = false;
				game.clicked[0] = false;
			}
			else if(isIn(25, 25, 90, 40))
				game.state = GamePanel.STATES.ADMAINPAGE;
			else if(isIn(755, 430, 150, 50))
			{
				int day = 0, month = 0,year = 0, classe = 0;
				
				try{
				 day = new Integer(game.day);
				 month = new Integer(game.month);
				 year = new Integer(game.year);
				 classe = new Integer(game.classOf);
				}
				catch(Exception excp) {};
				if(day < 1 || (day > 31 && month % 3 == 1) || (day > 31 && month == 8) //valid date
						|| (day > 29 && month == 2) || (day > 28 && month == 2 && year%4 != 0)
						|| (day > 30 && month == 4) || (day > 30 && month == 6) || (day > 30 && month == 9)
						|| (day > 30 && month == 11)|| year <date.getYear()-45 || year > date.getYear()-17
						|| month <1 || month >12)
				{
					unvalidD = true;
				}
				else
					unvalidD = false;
				
				
				if(classe > date.getYear() || classe < date.getYear() -20)	//valid class
				{
					unvalidC = true;
				}
				else
					unvalidC = false;
				
				if(game.day.compareTo("") == 0 || game.month.compareTo("") == 0 || game.year.compareTo("") == 0		//all filled
						|| game.name.compareTo("") == 0 || game.major.compareTo("") == 0 || game.classOf.compareTo("") == 0 
						|| game.level.compareTo("") == 0)
				{
					fillB = true;
					
				}
				else
					fillB = false;
				
				if(unvalidD || unvalidC || fillB)
				{
					if(fillB)
					{
						JOptionPane.showMessageDialog(game, "You should fill all the blanks before moving on!");
					}
					else if(unvalidD)
					{
						JOptionPane.showMessageDialog(game, "Unvalid year of birth!");
					}
					else if(unvalidC)
					{
						JOptionPane.showMessageDialog(game, "Non existent Class year!");
					}
				}
				else {
					try
			    	{
			      	  // create a mysql database connection
			      	  String myDriver = "com.mysql.cj.jdbc.Driver";
			      	  String myUrl = "jdbc:mysql://localhost:3306/whusystem";
			      	  Class.forName(myDriver);
			      	  Connection conn = DriverManager.getConnection(myUrl, "root", "");

			      	  // the mysql insert statement
			      	  String query = "INSERT INTO student (name, day, month, year,level, major, schoolFee, dormFee, otherFee,tot, scholarship, path, id)"
			      	    		+ "VALUES (?, ?, ?, ?,? ,?, ?, ?, ?, ?, ?, ?, ?)";
			      	  
			      	  // create the mysql insert preparedstatement
			      	  PreparedStatement preparedStmt = conn.prepareStatement(query);
			      	  preparedStmt.setString (1, game.name);
			            preparedStmt.setString (2, game.day);
			            preparedStmt.setString   (3, game.month);
			            preparedStmt.setString(4, game.year);
			            preparedStmt.setString    (5, game.level);
			            preparedStmt.setString    (6, game.major);
			            preparedStmt.setString (7, game.schoolF);
			            preparedStmt.setString (8, game.dormF);
			            preparedStmt.setString   (9, game.otherF);
			            preparedStmt.setFloat(11, game.scholarship);
			            preparedStmt.setString    (12, game.path);

			      	  query = "SELECT * FROM student WHERE level =  \"" + game.level + "\" AND major = \""+game.major + "\"";
			      	  Statement ps2 = conn.createStatement();
			      	  ResultSet my_rs = ps2.executeQuery(query);
			      	  int count = 1;
			      	  while (my_rs.next()) {
			      		  count++;
			      		  //id = my_rs.getString("basicID");
			      		  System.out.println("Id: " + " - count : " + count);
			      	  }
			      	  String idtemp = Integer.toString(count);
			      	  
			      	  String id = Integer.toString(count);
			      	  int y = 9999-count;
			      	  if(y>=9990)
			      	  {
			      		  id = "000"+id;
			      	  }
			      	  else if(y>=9900)
			      	  {
			      		  id = "00" + id;
			      	  }
			      	  else if(y>=9000)
			      	  {
			      		  id = "0" + id;
			      	  }
			      	  else
			      	  {
			      	  }

			      	  String last = "";
			      	  switch(game.major)
			      	  {
			      	  case "Software Engineering":
			      		  last = "666";
			      		  break;
			      	  case "Chinese Language":
			      		  last = "333";
			      		  break;
			      	  case "Economy":
			      		  last = "999";
			      		  break;  
			      	  }
			      	  
			      	  String second = "";
			      	  switch(game.level)
			      	  {
			      	  case "Bachelor":
			      		  second = "32";
			      		  break;
			      	  case "Master":
			      		  second = "65";
			      		  break;
			      	  case "PHD":
			      		  second = "98";
			      		  break;  
			      	  }
			      	  
			      	  y = new Integer(game.dormF);
			      	  y+= new Integer(game.schoolF);
			      	  y+= new Integer(game.otherF);
			      	  
			      	  y = (int) (y - y*game.scholarship);
			      	  game.tot = Integer.toString(y);

			          preparedStmt.setString   (10, game.tot);
			      	  game.stuId = game.classOf + second + last +id;
			          preparedStmt.setString    (13, game.stuId);
			      	  // execute the preparedstatement
			      	  preparedStmt.execute();
			      	  
			      	  query = "INSERT INTO schedule (class, major, level,1mon,2mon,3mon,4mon,5mon,6mon,7mon,8mon,9mon,1tue,2tue,3tue,4tue,5tue,6tue,7tue,8tue,9tue,1wed,2wed,3wed,4wed,5wed,6wed,7wed,8wed,9wed,1thu,2thu,3thu,4thu,5thu,6thu,7thu,8thu,9thu,1fri,2fri,3fri,4fri,5fri,6fri,7fri,8fri,9fri)" 
			      			  + "VALUES(?,?,?,'','','','','','','','','',  '','','','','','','','','',  '','','','','','','','','',    '','','','','','','','',''    ,'','','','','','','','','')";

			      	  preparedStmt = conn.prepareStatement(query);
			          preparedStmt.setString(1, game.classOf);
			          preparedStmt.setString(2, game.major);
			          preparedStmt.setString(3, game.level);
			      	  preparedStmt.execute();
			      	  
			      	  conn.close();
			      	  game.added = true;
			      	  
			      	}
			      	catch (Exception exp)
			      	{
			      	  System.err.println("Got an exception!");
			      	  System.err.println(exp.getMessage());
			      	}
				}
				
			}
			
			if(game.choice[0])
			{
				if(isIn(300, 250, 150, 40))
				{
					game.major = "Chinese Language";
					game.choice[0] = false;
				}
				else if(isIn(300, 340, 150, 40))
				{
					game.major = "Software Engineering";
					game.choice[0] = false;
				}
				else if(isIn(300, 420, 150, 40))
				{
					game.major = "Economy";
					game.choice[0] = false;
				}	
			}
			
			if(game.added)
			{
				if(isIn(380, 340, 152, 40))
				{
					clearStu();
					game.clicked[4] = true;
					game.added = false;
				}
				
				if(isIn(550, 340, 120, 40))
				{
					clearStu();
					game.added = false;
					game.state = GamePanel.STATES.ADMAINPAGE;
				}
			}
	}
	
	public void addTeacher()
	{
		if(!game.choice[0] && !game.added)
			if(isIn(765, 210, 130, 150)) {
				game.clicked[6] = true;
			}
			if(isIn(300, 180, 250, 30)) {
				game.box[0] = true;
				game.selected = 0;
			}
			else if(isIn(310, 220, 50, 30)){
				game.box[1] = true;
				game.selected = 1;
			}
			else if(isIn(375, 220, 50, 30)){
				game.box[2] = true;
				game.selected = 2;
			}
			else if(isIn(440, 220, 100, 30)){
				game.box[3] = true;
				game.selected = 3;
			}
			else if(isIn(300, 300, 250, 30)){
				game.selected = 4;
				game.box[4] = true;
			}
			else if(isIn(300, 350, 250, 30)){
				game.selected = 5;
				game.box[8] = true;
			}
			else if(isIn(770,370,120,40)){
				game.clicked[4] = true;
			}
			else if(isIn(25, 25, 90, 40))
				game.state = GamePanel.STATES.ADMAINPAGE;
			else if(isIn(755, 430, 150, 50))
			{
				int day = 0, month = 0,year = 0;
				
				try{
				 day = new Integer(game.day);
				 month = new Integer(game.month);
				 year = new Integer(game.year);
				}
				catch(Exception excp) {};
				if(day < 1 || (day > 31 && month % 3 == 1) || (day > 31 && month == 8) //valid date
						|| (day > 29 && month == 2) || (day > 28 && month == 2 && year%4 != 0)
						|| (day > 30 && month == 4) || (day > 30 && month == 6) || (day > 30 && month == 9)
						|| (day > 30 && month == 11)|| year <date.getYear()-70 || year > date.getYear()-22
						|| month <1 || month >12)
				{
					unvalidD = true;
				}
				else
					unvalidD = false;
				
				
				if(game.day.compareTo("") == 0 || game.month.compareTo("") == 0 || game.year.compareTo("") == 0		//all filled
						|| game.name.compareTo("") == 0 || game.salary.compareTo("") == 0 || game.subject.compareTo("") == 0)
				{
					fillB = true;
					
				}
				else
					fillB = false;
				
				if(unvalidD || fillB)
				{
					if(fillB)
					{
						JOptionPane.showMessageDialog(game, "You should fill all the blanks before moving on!");
					}
					else if(unvalidD)
					{
						JOptionPane.showMessageDialog(game, "Unvalid year of birth!");
					}
				}
				else {
					try
			    	{
			      	  // create a mysql database connection
			      	  String myDriver = "com.mysql.cj.jdbc.Driver";
			      	  String myUrl = "jdbc:mysql://localhost:3306/whusystem";
			      	  Class.forName(myDriver);
			      	  Connection conn = DriverManager.getConnection(myUrl, "root", "");

			      	  // the mysql insert statement
			      	  String query = "INSERT INTO teacher (id, name, day, month, year,salary, path, subject, subid)"
			      	    		+ "VALUES (?, ?, ?, ?,? ,?, ?, ?, ?)";
			      	  
			      	  // create the mysql insert preparedstatement
			      	  PreparedStatement preparedStmt = conn.prepareStatement(query);
			      	  preparedStmt.setString (2, game.name);
			          preparedStmt.setString (3, game.day);
			          preparedStmt.setString   (4, game.month);
			          preparedStmt.setString(5, game.year);
			          preparedStmt.setString    (6, game.salary);
			          preparedStmt.setString    (7, game.path);
			          preparedStmt.setString    (8, game.subject);

			      	  query = "SELECT * FROM teacher";
			      	  Statement ps2 = conn.createStatement();
			      	  ResultSet my_rs = ps2.executeQuery(query);
			      	  int count = 1;
			      	  int subcount = 1;
			      	  String id = null;
			      	  while (my_rs.next()) {
			      		  if(game.subject.compareTo(my_rs.getString("subject")) == 0)
			      			  subcount++;
			      		  id = my_rs.getString("idBasic");
			      	  }
			      	  int x = new Integer(id);
			      	  id = Integer.toString(x+1);
			      	  int y = 9999-x;
			      	  if(y>=9990)
			      	  {
			      		  id = "000"+id;
			      	  }
			      	  else if(y>=9900)
			      	  {
			      		  id = "00" + id;
			      	  }
			      	  else if(y>=9000)
			      	  {
			      		  id = "0" + id;
			      	  }
			      	  game.stuId = date.getYear() + id;
			          preparedStmt.setInt    (9, subcount);
			          preparedStmt.setString    (1, game.stuId);
			      	  // execute the preparedstatement
			      	  preparedStmt.execute();
			      	  
			      	  conn.close();
			      	  
			      	  game.added = true;
			      	  
			      	}
			      	catch (Exception exp)
			      	{
			      	  System.err.println("Got an exception!");
			      	  System.err.println(exp.getMessage());
			      	}
				}
				
			}
			
			if(game.added)
			{
				if(isIn(380, 340, 152, 40))
				{
					clearT();
					game.clicked[4] = true;
					game.added = false;
				}
				
				if(isIn(550, 340, 120, 40))
				{
					clearT();
					game.added = false;
					game.state = GamePanel.STATES.ADMAINPAGE;
				}
			}
	}
	

	public boolean isIn(int x2, int y2, int w, int h)
	{
		if( x >= x2 && y >= y2 && x <= x2+w && y <= y2 + h )
			return true;
		return false;
	}

}
