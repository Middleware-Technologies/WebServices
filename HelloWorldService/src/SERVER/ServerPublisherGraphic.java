package SERVER;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.xml.ws.Endpoint;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServerPublisherGraphic extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JTextField txtPort;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerPublisherGraphic frame = new ServerPublisherGraphic();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerPublisherGraphic() 
	{		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 206);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Message to clients");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 69, 121, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("Server Name");
		label.setFont(new Font("Calibri", Font.BOLD, 14));
		label.setBounds(10, 11, 85, 14);
		contentPane.add(label);
		
		JButton btnPublish = new JButton("Publish Service");

		btnPublish.setBounds(10, 94, 287, 29);
		contentPane.add(btnPublish);
		
		JTextField txtServerName = new JTextField();
		txtServerName.setBounds(141, 8, 156, 20);
		contentPane.add(txtServerName);
		txtServerName.setColumns(10);
		try 
		{
			txtServerName.setText(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e1) 
		{
			JOptionPane.showMessageDialog(null,"HostName Errore");
		}
		
		JTextField txtMessage = new JTextField();
		txtMessage.setColumns(10);
		txtMessage.setBounds(141, 66, 156, 20);
		
		contentPane.add(txtMessage);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(10, 134, 287, 29);
		contentPane.add(btnClose);
		
		JLabel label_1 = new JLabel("Port");
		label_1.setFont(new Font("Calibri", Font.BOLD, 14));
		label_1.setBounds(10, 40, 85, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Port");
		label_2.setFont(new Font("Calibri", Font.BOLD, 14));
		label_2.setBounds(10, 40, 85, 14);
		contentPane.add(label_2);
		
		txtPort = new JTextField();
		txtPort.setText("8085");
		txtPort.setColumns(10);
		txtPort.setBounds(141, 39, 156, 20);
		contentPane.add(txtPort);
		
		
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.exit(0);
			}
		});
		
		btnPublish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try
				{
					String host=txtServerName.getText();
					String port = txtPort.getText();
					String url = "http://"+host+":"+port+"/Server/Hello";
					
					Endpoint.publish(url, new HelloWorldImp(""+txtMessage.getText().toString()));
					JOptionPane.showMessageDialog(null,"Web Services Created");
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Errore: "+ex.getCause());
				}
			}
		});
	}
}
