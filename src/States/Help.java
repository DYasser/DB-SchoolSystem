package States;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import Display.GamePanel;

public class Help {

	GamePanel game;
	public Help(GamePanel game)
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
		g.drawString("-HELP-", 400, 50);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
		if(game.exitBox)
			g.fillRect(25, 25, 90, 40);
		g.fillRect(150, 130, 700, 350);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.drawRect(150, 130, 700, 350);
		g.setFont(game.font.deriveFont(18f));
		g.drawRect(25, 25, 90, 40);
		g.drawString("Back", 50,50);
		g.setColor(Color.orange);
		g.drawString("       This is WuHan University's system of management", 165, 160);
		g.drawString("                  of students and teachers", 165, 190);
		g.setColor(Color.pink);
		g.drawString(" There are three login screens for 3 different kind of people", 165, 240);
		g.setColor(Color.cyan);
		g.drawString("     Admin", 165, 290);
		g.setColor(Color.white);
		g.drawString("          : Manages students and teachers, and decides", 165, 290);
		g.drawString("                   of the schedule imposed.", 165, 320);
		g.setColor(Color.cyan);
		g.drawString("        Teacher", 165, 370);
		g.setColor(Color.white);
		g.drawString("               : Examinates Students and grades them,", 165, 370);
		g.drawString("           with the ability to put remarks on them.", 165, 400);
		g.setColor(Color.cyan);
		g.drawString(" Student", 165, 450);
		g.setColor(Color.white);
		g.drawString("        : Takes exams, selects courses, and look through fees.", 165, 450);
		g.setColor(Color.gray);
		g.drawString("Created by Yasser Nabil on Java Eclipse.", 270, 520);
		
	}
}
