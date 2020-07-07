package Handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Display.GamePanel;
import Display.GamePanel.STATES;

public class KeyHandler  implements KeyListener {
	
	GamePanel game;
	public KeyHandler(GamePanel game)
	{
		this.game = game;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == 10)
		{
			game.selected += 1;
			if(game.state == GamePanel.STATES.ADDSTUDENT)
			{
				if(game.selected > 4)
				{
					game.selected = 0;
				}
			}
			
			if(game.state == GamePanel.STATES.ADDTEACHER)
			{
				if(game.selected > 5)
				{
					game.selected = 0;
				}
			}
		}
		
		if(e.getKeyCode() == 27)		//Escape = exit
		{
			System.exit(0);
		}
		
		switch(game.state)
		{
		case ADMIN:{
			switch(game.selected)
			{
			case 1:
				if((Character.isAlphabetic(e.getKeyChar()) || Character.isDigit(e.getKeyChar())) && game.username.length() < 25)
					game.username += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.username.length() > 0)
					game.username = game.username.substring(0,game.username.length()-1);
				break;
			case 2:
				System.out.print(e.getKeyCode());
				if(e.getKeyCode() != 8 && e.getKeyCode() != 32 && e.getKeyCode() != 10 && game.password.length() < 25) {
					game.password += e.getKeyChar();
					game.pswd += "*";
				}
				if(e.getKeyCode() == 8 && game.password.length() > 0) {
					game.password = game.password.substring(0,game.password.length()-1);
					game.pswd = game.pswd.substring(0,game.pswd.length()-1);
				}
				break;
			}
			break;
		}
		
		case STUDENT:{
			switch(game.selected)
			{
			case 1:
				if(Character.isDigit(e.getKeyChar()) && game.username.length() < 25)
					game.username += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.username.length() > 0)
					game.username = game.username.substring(0,game.username.length()-1);
				break;
			case 2:
				System.out.print(e.getKeyCode());
				if(Character.isDigit(e.getKeyChar()) && game.password.length() < 25) {
					game.password += e.getKeyChar();
					game.pswd += "*";
				}
				if(e.getKeyCode() == 8 && game.password.length() > 0) {
					game.password = game.password.substring(0,game.password.length()-1);
					game.pswd = game.pswd.substring(0,game.pswd.length()-1);
				}
				break;
			}
			break;
		}
		case TEACHER:{
			switch(game.selected)
			{
			case 1:
				if(Character.isDigit(e.getKeyChar()) && game.username.length() < 25)
					game.username += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.username.length() > 0)
					game.username = game.username.substring(0,game.username.length()-1);
				break;
			case 2:
				System.out.print(e.getKeyCode());
				if(Character.isDigit(e.getKeyChar()) && game.password.length() < 25) {
					game.password += e.getKeyChar();
					game.pswd += "*";
				}
				if(e.getKeyCode() == 8 && game.password.length() > 0) {
					game.password = game.password.substring(0,game.password.length()-1);
					game.pswd = game.pswd.substring(0,game.pswd.length()-1);
				}
				break;
			}
			break;
		}
			
		case ADDSTUDENT:{
			switch(game.selected)
			{
			case 0:
				if((Character.isAlphabetic(e.getKeyChar()) || e.getKeyCode() == 32) && game.name.length() < 26)
					game.name += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.name.length() > 0)
					game.name = game.name.substring(0,game.name.length()-1);
				break;
			case 1:
				if(Character.isDigit(e.getKeyChar()) && game.day.length()<2)
					game.day += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.day.length() > 0)
					game.day = game.day.substring(0,game.day.length()-1);
				break;
			case 2:
				if(Character.isDigit(e.getKeyChar()) && game.month.length()<2)
					game.month += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.month.length() > 0)
					game.month = game.month.substring(0,game.month.length()-1);
				break;
			case 3:
				if(Character.isDigit(e.getKeyChar()) && game.year.length()<4)
					game.year += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.year.length() > 0)
					game.year = game.year.substring(0,game.year.length()-1);
				break;
			case 4:
				if(Character.isDigit(e.getKeyChar()) && game.classOf.length()<4)
					game.classOf += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.classOf.length() > 0)
					game.classOf = game.classOf.substring(0,game.classOf.length()-1);
				break;
			case 5:
				game.choice[0] = true;
				break;
			}
			break;
		}
			
		case ADDTEACHER:{
			switch(game.selected)
			{
			case 0:
				if((Character.isAlphabetic(e.getKeyChar()) || e.getKeyCode() == 32) && game.name.length() < 26)
					game.name += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.name.length() > 0)
					game.name = game.name.substring(0,game.name.length()-1);
				break;
			case 1:
				if(Character.isDigit(e.getKeyChar()) && game.day.length()<2)
					game.day += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.day.length() > 0)
					game.day = game.day.substring(0,game.day.length()-1);
				break;
			case 2:
				if(Character.isDigit(e.getKeyChar()) && game.month.length()<2)
					game.month += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.month.length() > 0)
					game.month = game.month.substring(0,game.month.length()-1);
				break;
			case 3:
				if(Character.isDigit(e.getKeyChar()) && game.year.length()<4)
					game.year += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.year.length() > 0)
					game.year = game.year.substring(0,game.year.length()-1);
				break;
			case 4:
				if(Character.isDigit(e.getKeyChar()) && game.salary.length()<10)
					game.salary += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.salary.length() > 0)
					game.salary = game.salary.substring(0,game.salary.length()-1);
				break;
			case 5:
				if((Character.isAlphabetic(e.getKeyChar()) || e.getKeyCode() == 32) && game.subject.length() < 21)
					game.subject += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.subject.length() > 0)
					game.subject = game.subject.substring(0,game.subject.length()-1);
				break;
			}
			break;
		}

		case MODIFYSTUDENT:{
			if(game.choice[3]) {
				if((Character.isAlphabetic(e.getKeyChar()) || e.getKeyCode() == 32) && game.name.length() < 26)
					game.name += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.name.length() > 0)
					game.name = game.name.substring(0,game.name.length()-1);
			}
			
			if(game.choice[10]) {
				if(Character.isDigit(e.getKeyChar()) && game.day.length()<2)
					game.day += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.day.length() > 0)
					game.day = game.day.substring(0,game.day.length()-1);
			}
			if(game.choice[11]) {
				if(Character.isDigit(e.getKeyChar()) && game.month.length()<2)
					game.month += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.month.length() > 0)
					game.month = game.month.substring(0,game.month.length()-1);
			}
			if(game.choice[12]) {
				if(Character.isDigit(e.getKeyChar()) && game.year.length()<4)
					game.year += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.year.length() > 0)
					game.year = game.year.substring(0,game.year.length()-1);
			}
			break;
		}
			
		case CHECKCOURSES:
				if((Character.isAlphabetic(e.getKeyChar()) || e.getKeyCode() == 32) && game.remark[game.selected].length() < 26)
					game.remark[game.selected] += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.remark[game.selected].length() > 0)
					game.remark[game.selected] = game.remark[game.selected].substring(0,game.remark[game.selected].length()-1);

				System.out.println("remark: " + game.selected + " - " + game.remark[game.selected]);
			break;
			
		case GRADE:{
			if(Character.isDigit(e.getKeyChar()) && game.grad[game.selected].length() < 4)
				game.grad[game.selected] += e.getKeyChar();
			if(e.getKeyCode() == 8 && game.grad[game.selected].length() > 0)
				game.grad[game.selected] = game.grad[game.selected].substring(0,game.grad[game.selected].length()-1);

			if(game.grad[game.selected].compareTo("") == 0)
				game.grad[game.selected] = "0";
			try {
				if(new Integer(game.grad[game.selected])> 100)
					game.grad[game.selected] = "100";
			}catch(Exception ed){}
		break;
		}
		
		case MODIFYTEACHER:{
			if(game.choice[3]) {
				if((Character.isAlphabetic(e.getKeyChar()) || e.getKeyCode() == 32) && game.name.length() < 26)
					game.name += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.name.length() > 0)
					game.name = game.name.substring(0,game.name.length()-1);
			}
			
			if(game.choice[10]) {
				if(Character.isDigit(e.getKeyChar()) && game.day.length()<2)
					game.day += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.day.length() > 0)
					game.day = game.day.substring(0,game.day.length()-1);
			}
			if(game.choice[11]) {
				if(Character.isDigit(e.getKeyChar()) && game.month.length()<2)
					game.month += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.month.length() > 0)
					game.month = game.month.substring(0,game.month.length()-1);
			}
			if(game.choice[12]) {
				if(Character.isDigit(e.getKeyChar()) && game.year.length()<4)
					game.year += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.year.length() > 0)
					game.year = game.year.substring(0,game.year.length()-1);
			}

			if(game.choice[13]) {
				if(Character.isDigit(e.getKeyChar()) && game.salary.length()<15)
					game.salary += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.salary.length() > 0)
					game.salary = game.salary.substring(0,game.salary.length()-1);
			}

			if(game.choice[14]) {
				if((Character.isAlphabetic(e.getKeyChar()) || e.getKeyCode() == 32) && game.subject.length() < 21)
					game.subject += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.subject.length() > 0)
					game.subject = game.subject.substring(0,game.subject.length()-1);
			}
			break;
		}
		
		case SCHEDULE:{
			if(game.choice[0])
				{
				if(Character.isDigit(e.getKeyChar()) && game.classOf.length()<4)
					game.classOf += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.classOf.length() > 0)
					game.classOf = game.classOf.substring(0,game.classOf.length()-1);
				}
			if(game.choice[3])
				{
				if((Character.isAlphabetic(e.getKeyChar()) || e.getKeyCode() == 32) && game.level.length() < 8)
					game.level += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.level.length() > 0)
					game.level = game.level.substring(0,game.level.length()-1);
				}
			if(game.choice[2])
				{
				if((Character.isAlphabetic(e.getKeyChar()) || e.getKeyCode() == 32) && game.major.length() < 20)
					game.major += e.getKeyChar();
				if(e.getKeyCode() == 8 && game.major.length() > 0)
					game.major = game.major.substring(0,game.major.length()-1);
				}
			break;
		}
		}
		
		}

	@Override
	public void keyReleased(KeyEvent e) {}

}
