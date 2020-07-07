package States;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Display.GamePanel;

public class AddTeacher {

	private GamePanel game;
	private JLabel lbl = null;
	private BufferedImage img = null;
	private Image x = null;
	
	
	public AddTeacher(GamePanel game)
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
		g.drawString("ADD TEACHER", 350, 65);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
		g.setFont(game.font.deriveFont(15f));
		g.drawString("File Extensions accepted:", 730, 160);
		g.drawString(".png and .jpg", 770, 180);

		if(game.box[0] || game.selected == 0)
			g.fillRect(300, 180, 320, 30);	//Name
		if(game.box[1] || game.selected == 1)
			g.fillRect(310, 220, 50, 30);	//DD
		if(game.box[2] || game.selected == 2)
			g.fillRect(375, 220, 50, 30);	//MM
		if(game.box[3] || game.selected == 3)
			g.fillRect(440, 220, 100, 30);	//YYYY
		if(game.box[4] || game.selected == 4)
			g.fillRect(300, 300, 250, 30);	//salary
		if(game.box[8] || game.selected == 5)
			g.fillRect(300, 350, 250, 30);	//subject
		if(game.box[5] )
			g.fillRect(755, 430, 150, 50);	//Add
		if(game.box[6] )
			g.fillRect(765, 210, 130, 150);	//Photo
		if(game.box[7] )
			g.fillRect(770,370,120,40);	//Cancel
		if(game.exitBox)
			g.fillRect(25, 25, 90, 40);		//Back
		
		
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g.setFont(game.font.deriveFont(19f));
		g.drawString("Back", 50, 50);
		
		g.drawString("   Full Name   : ", 120, 200);
		g.drawString(" Date of birth :      /     /          (dd/mm/yyyy)", 120, 240);
		g.drawString("    Salary     : ", 120, 320);
		g.drawString("   Subject     : ", 120, 370);

		g.drawString("ADD", 815, 460);
		g.drawString("Remove", 800, 395);
		
		
		g.drawString("                  " + game.name, 120, 200);	//Name
		g.drawString("                  " + game.day, 115, 240);	//dd
		g.drawString("                  " + game.month, 185, 240);	//mm
		g.drawString("                  " + game.year, 250, 240);	//year
		g.drawString("                  " + game.salary, 120, 320);	//year
		g.drawString("                  " + game.subject, 120, 370);	//year

		g.drawString("Picture", 790, 280);
		
		g.drawRect(25, 25, 90, 40);		//back
		g.drawRect(100, 150, 600, 250);	//form
		g.drawRect(765, 210, 130, 150);	//photo
		g.drawRect(755, 430, 150, 50);	//add button
		
		if(game.clicked[6])
		{
        	game.clicked[6] = false;
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
			g.drawString("Teacher added Successfully!", 352, 177);
			g.drawString("Teacher Name: " + game.name, 270, 230);
			g.drawString("Teacher Id  : " + game.stuId, 270, 270);
			g.drawString("Salary      : " + game.salary + " yuan", 270, 310);
			
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
