package Display;

import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Window extends JFrame{

	private BufferStrategy bs;
	private GamePanel gp;
	private int width = 980, height = 560;
    
	public Window()
	{
		setTitle("WhuSystem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void addNotify()
	{
		super.addNotify();
		createBufferStrategy(3);
		bs = getBufferStrategy();
		gp = new GamePanel(bs, width, height);
		add(gp);
		setContentPane(gp);
	}
}
