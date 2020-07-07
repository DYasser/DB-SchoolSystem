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

public class StudentFees {

	private GamePanel game;
	private BufferedImage img;
	private Image image = null;
	
	public StudentFees(GamePanel game)
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
		g.drawString("Your Fees", 340, 60);
		g.drawRect(25, 25, 90, 40);
		g.setFont(game.font.deriveFont(18f));
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
		if(game.exitBox)
			g.fillRect(25, 25, 90, 40);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.drawString("Back", 50, 50);
		
		if(game.imgs)
		{
			try {
				img = ImageIO.read(new File("C:/Yasser/WuhanLogo.png"));
			} catch (IOException e) {}
			image = img.getScaledInstance(250, 150, Image.SCALE_SMOOTH);
		game.imgs = false;
		}
		g.drawImage(image, 700,	40, game);
		g.drawRect(150, 150, 650, 300);
		g.setColor(game.dark);
		g.fillRect(151, 151, 649, 299);
		g.setColor(Color.white);
		g.drawString("School Fee: " + game.schoolF + "      (" + game.major + " - " + game.level+ ")", 180, 200);
		g.drawString("Dorm Fee  : " + game.dormF, 180, 250);
		g.drawString("Other Fee : " + game.otherF + "   (Insurance + file deposit fees...)", 180, 300);
		g.drawString("           Total     : " + game.tot + " (Scholarship: " + (int)(game.scholarship*100) + "%)", 180, 370);
		g.drawString("Contact us:0086-27-6875 3912 (admission)  0086-27-6875 3419 (publicity)", 100, 525);
		g.drawString("Fax: 0086-27-8787 4669  Email: fao@whu.edu.cn ", 210, 545);
		
		g.setColor(Color.gray);
		g.setFont(game.font.deriveFont(16f));
		g.drawString("The payment should occur before the start of each semester", 185, 415);
		g.drawString("The student may be contacted before any punishment happens", 185, 435);
	}
}
