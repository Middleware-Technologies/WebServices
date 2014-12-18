package server.deploy;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.xml.ws.Endpoint;

import server.impl.ImageWSImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PublisherGraphics extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtServerName;
	private JTextField txtPort;
	private JTextField txtFolder;
	private JButton btnClose;
	private JButton btnPublish;

	/**
	 * Launch the application.
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args)
	{
		PublisherGraphics frame = new PublisherGraphics();
		frame.setVisible(true);
	}


	public PublisherGraphics() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtServerName = new JTextField();
		txtServerName.setBounds(148, 11, 129, 27);
		try 
		{
			txtServerName.setText(InetAddress.getLocalHost().getHostName());
		} 
		catch (UnknownHostException e1) {		}
		
		contentPane.add(txtServerName);
		txtServerName.setColumns(10);
		txtServerName.setEditable(false);
		
		txtPort = new JTextField();
		txtPort.setColumns(10);
		txtPort.setBounds(148, 49, 129, 27);
		contentPane.add(txtPort);
		txtPort.setText("9999");
		
		txtFolder = new JTextField();
		txtFolder.setColumns(10);
		txtFolder.setBounds(148, 87, 129, 27);
		contentPane.add(txtFolder);
		txtFolder.setText("C:/Users/Luca/Desktop/");
		
		JLabel lblServerName = new JLabel("Server Name");
		lblServerName.setFont(new Font("Calibri", Font.BOLD, 13));
		lblServerName.setBounds(10, 17, 78, 14);
		contentPane.add(lblServerName);
		
		JLabel lblServerPort = new JLabel("Server Port");
		lblServerPort.setFont(new Font("Calibri", Font.BOLD, 13));
		lblServerPort.setBounds(10, 55, 78, 14);
		contentPane.add(lblServerPort);
		
		JLabel lblImageDirectory = new JLabel("Image Directory");
		lblImageDirectory.setFont(new Font("Calibri", Font.BOLD, 13));
		lblImageDirectory.setBounds(10, 93, 99, 14);
		contentPane.add(lblImageDirectory);
		
		btnPublish = new JButton("Publish");
		btnPublish.setBounds(10, 130, 267, 38);
		contentPane.add(btnPublish);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(10, 179, 267, 38);
		contentPane.add(btnClose);
		
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
				String position=txtFolder.getText();
				ImageWSImpl.Setting(position);
				
				String host=txtServerName.getText();
				int port= Integer.parseInt(txtPort.getText());
				
				Endpoint.publish("http://"+host+":"+port+"/ImageWS", new ImageWSImpl());
				JOptionPane.showMessageDialog(null,"ImageWS has been deployed");
			}
		});
	}
}