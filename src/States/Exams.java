package States;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import Display.GamePanel;

public class Exams {

	GamePanel game;
	
	public Exams(GamePanel game)
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
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.3f));
		if(game.exitBox)
			g.fillRect(25, 25, 90, 40);
		if(game.box[0])
			g.fillRect(380, 215, 160, 40);
		if(game.box[1])
			g.fillRect(360, 335, 210, 40);
		if(game.box[2])
			g.fillRect(400, 460, 120, 40);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
		g.drawRect(25, 25, 90, 40);
		g.drawString("Input Exam", 315, 50);
		g.setFont(game.font.deriveFont(18f));
		g.drawString("Back", 50, 50);
		g.drawRect(150, 150, 650, 290);
		g.drawString("Import Exam", 400, 240);
		g.drawRect(380, 215, 160,40 );
		g.drawString("Import AnswerKey", 380, 360);
		g.drawRect(360, 335, 210,40 );
		g.drawString("Save", 437, 485);
		g.drawRect(400, 460, 120,40 );
		g.setColor(Color.red);
		g.drawString("Make sure to save before quitting!", 270, 535);
	}
}
