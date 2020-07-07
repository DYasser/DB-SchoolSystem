package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Display.GamePanel;
import Display.Window;

public class Main {

	public static Connection con;
	public static Window win;
	public static void main(String[] args)throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/whusystem","root","");
		win = new Window();
	}
}
