package States;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import javax.imageio.ImageIO;

import Display.GamePanel;

public class AdminMainPage {

	private GamePanel game;
	private BufferedImage img;
	private Image x;
	private LocalTime time = LocalTime.now();
	public AdminMainPage(GamePanel game)
	{
		this.game = game;try {
		img = ImageIO.read(new File("C:/Yasser/wuhan.jpg"));
		} catch (IOException e) {e.printStackTrace();}
		x = img.getScaledInstance(1000, 400, Image.SCALE_SMOOTH);
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g)
	{
		g.drawImage(x, 0,146,game);
		g.setColor(Color.black);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .7f));
		if(game.box[0])
			g.fillRect(40, 100, 135, 150);
		else if(game.box[1])
			g.fillRect(210, 100, 135, 150);
		else if(game.box[2])	
			g.fillRect(380, 100, 135, 150);
		else if(game.box[3])
			g.fillRect(550, 100, 135, 150);
		else if(game.box[4])
			g.fillRect(725, 100, 215, 40);
		else if(game.exitBox)
			g.fillRect(790, 20, 120, 50);
				

		g.setColor(Color.white);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.setFont(game.font.deriveFont(50f));

		g.drawRect(790, 20, 120, 50);	//logOut
		if(time.getHour() >= 5 && time.getHour() < 12)
			g.drawString(" Good Morning ADMIN", 100, 50);
		else if(time.getHour() >= 12 && time.getHour() < 19)
			g.drawString("Good Afternoon ADMIN", 100, 50);
		else
			g.drawString("Good Evening ADMIN", 100, 50);
		
		g.setFont(game.font.deriveFont(19f));
		g.drawString("Log Out", 810, 50);
		g.drawRect(0, 100, game.getWidth(), 40);
		g.drawString("Add", 90, 127);
		if(game.box[0]) {
			g.drawString("Teacher", 68, 180);
			g.drawString("Student", 68, 230);
		}
		if(game.box[1]) {
			g.drawString("Teacher", 237, 180);
			g.drawString("Student", 237, 230);
		}
		if(game.box[2]) {
			g.drawString("Teacher", 410, 180);
			g.drawString("Student", 410, 230);
		}
		if(game.box[3]) {
			g.drawString("Teacher", 579, 180);
			g.drawString("Student", 579, 230);
		}
		
		g.drawString("Modify", 245, 127);
		g.drawString("Check", 420, 127);
		g.drawString("Remove", 587, 127);
		g.drawString("Class Schedules", 750, 127);

		
	}
}
