package States;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import Display.GamePanel;

public class Student {
	GamePanel game;
	
	public Student(GamePanel game)
	{
		this.game = game;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g)
	{

		g.setFont(game.font.deriveFont(18f));
		g.setColor(Color.white);
		g.drawString("Back", 50, 50);
		g.setFont(game.font.deriveFont(20f));
		g.drawString("LogIn", 500, 450);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
		
		if(game.box[0])
			g.fillRect(400, 217, 400, 50);	//userName
		if(game.box[1])
			g.fillRect(400, 317, 400, 50);	//Password
		if(game.box[2])
			g.fillRect(475, 425, 110, 40);	//LogIn
		if(game.exitBox)
			g.fillRect(25, 25, 90, 40);		//back
		
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.setFont(game.font.deriveFont(50f));
		g.drawString("Student LogIn", 330, 50);
		
		g.setFont(game.font.deriveFont(25f));
		g.drawString("UserName", 250, 250);
		g.drawString("Password", 250, 350);
		g.drawString(game.username, 420, 250);
		g.drawString(game.pswd, 420, 350);

		g.drawRect(400, 217, 400, 50);	//userName
		g.drawRect(400, 317, 400, 50);	//Password
		g.drawRect(475, 425, 110, 40);	//LogIn
		g.drawRect(25, 25, 90, 40);		//back
		

		if(game.wrong)
		{
			g.setFont(game.font.deriveFont(18f));
			g.setColor(Color.red);
			g.drawString("Username or Password incorrect.", 360, 490);
		}
	}
}
