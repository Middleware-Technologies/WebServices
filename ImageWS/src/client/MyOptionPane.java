package client;

import javax.swing.JOptionPane;

public class MyOptionPane extends JOptionPane 
{

	private static final long serialVersionUID = 1L;
	
	public MyOptionPane(String message)
	{
		this.setMessage(message);
	}
	
	public void Show()
	{
		this.setVisible(true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setVisible(false);
	}

}
