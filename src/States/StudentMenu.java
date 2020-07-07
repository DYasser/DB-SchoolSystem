package States;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.time.LocalTime;

import Display.GamePanel;

public class StudentMenu {

	private GamePanel game;
	private LocalTime time = LocalTime.now();
	private String name;
	
	public StudentMenu(GamePanel game)
	{
		this.game = game;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(Color.white);
		g.setFont(game.font.deriveFont(38f));

		name = game.name;
		if(time.getHour() >= 5 && time.getHour() < 12)
			try{
				name = name.substring(0,16)+"..";
				g.drawString(" Good Morning, " + name, 20, 50);
			}catch(Exception ex){
				g.drawString(" Good Morning, " + name, 20, 50);}
		else if(time.getHour() >= 12 && time.getHour() < 19){
			try{
				name = name.substring(0,16)+"..";
				g.drawString("Good Afternoon, " + name, 20, 50);
			}catch(Exception ex){
				g.drawString("Good Afternoon, " + name, 20, 50);}
		}
		else
		{
			try{
				name = name.substring(0,16)+"..";
				g.drawString("Good Evening, " + name, 20, 50);
			}catch(Exception ex){
				g.drawString("Good Evening, " + name, 20, 50);}
		}
		
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
		if(game.box[0]) 
			g.fillRect(100, 250, 200, 150);
		if(game.box[1])
			g.fillRect(400, 250, 200, 150);
		if(game.box[2])
			g.fillRect(700, 250, 200, 150);
		if(game.exitBox)
			g.fillRect(790, 20, 120, 50);
		g.setFont(game.font.deriveFont(19f));
		g.drawString("Please choose an action, go ahead.", 300, 145);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.drawString("Log Out", 810, 50);
		g.drawRect(790, 20, 120, 50);//logOut
		g.drawRect(100, 250, 200, 150);	//Course
		g.drawRect(400, 250, 200, 150);	//Fee
		g.drawRect(700, 250, 200, 150);	//Exams
		g.setFont(game.font.deriveFont(25f));
		g.drawString("COURSE", 158, 330);
		g.drawString("FEES", 470, 330);
		g.drawString("EXAMS", 760, 330);
		
	}
	
}
