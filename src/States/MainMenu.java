package States;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Display.GamePanel;

public class MainMenu {

	private GamePanel game;
	private BufferedImage img;
	private Image x = null;
	private String sun = "C:/Yasser/sun.png", moon = "C:/Yasser/moon.png";
	public MainMenu(GamePanel game)
	{
		this.game = game;
		try {
			img = ImageIO.read(new File(sun));
		} catch (IOException e) {e.printStackTrace();}
		x = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		game.selected = 1;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g)
	{
		g.setFont(game.font.deriveFont(18f));
		g.setColor(Color.white);
		g.drawString("Exit", 50, 50);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
		g.drawString("Please Select what type of connection are eligible with", 200, 150);
		if(game.box[0]) 
			g.fillRect(100, 250, 200, 150);
		if(game.box[1])
			g.fillRect(400, 250, 200, 150);
		if(game.box[2])
			g.fillRect(700, 250, 200, 150);
		if(game.box[3])
			g.fillRect(425, 450, 150, 90);
		if(game.exitBox)
			g.fillRect(25, 25, 90, 40);
		
		
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.setFont(game.font.deriveFont(50f));
		g.drawString("MainMenu", 370, 50);

		if(game.clicked[0]) {
			if(game.selected == 2)
			{
				try {
					img = ImageIO.read(new File(moon));
					} catch (IOException e) {e.printStackTrace();}
				x = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			}
			else
			{
				try {
					img = ImageIO.read(new File(sun));
					} catch (IOException e) {e.printStackTrace();}
				x = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			}
			game.clicked[0] = false;
		}
		g.setFont(game.font.deriveFont(25f));
		g.drawString("ADMIN", 165, 330);
		g.drawString("TEACHER", 450, 330);
		g.drawString("STUDENT", 750, 330);

		g.setFont(game.font.deriveFont(40f));
		g.drawString("?", 937, 41);
		g.drawImage(x,890,10,game);
		g.drawRect(100, 250, 200, 150);	//admin
		g.drawRect(400, 250, 200, 150);	//teacher
		g.drawRect(700, 250, 200, 150);	//student
		g.drawRect(25, 25, 90, 40);		//exit
	}
}
