package client;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JTextField;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPBinding;

import support.ImageWS;
import support.ImageWSImplService;


public class ClientFrame extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton btnClose;
	private JButton btnDraw;
	
	private JLabel lblServerName;
	private JLabel lblServerPort;
	private JLabel lblImageName;
	
	private JTextField txtServerName;
	private JTextField txtServerPort;
	private JTextField txtImageName;

	public ClientFrame() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblServerName = new JLabel("Server Name");
		lblServerName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblServerName.setBounds(10, 11, 89, 14);
		contentPane.add(lblServerName);
		
		lblServerPort = new JLabel("Server Port");
		lblServerPort.setFont(new Font("Calibri", Font.BOLD, 14));
		lblServerPort.setBounds(10, 36, 89, 14);
		contentPane.add(lblServerPort);
		
		lblImageName = new JLabel("Image Name");
		lblImageName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblImageName.setBounds(10, 67, 89, 14);
		contentPane.add(lblImageName);
		
		txtServerName = new JTextField();
		txtServerName.setBounds(91, 7, 183, 23);
		txtServerName.setText("Luca-Pc");
		contentPane.add(txtServerName);
		txtServerName.setColumns(10);
		
		txtServerPort = new JTextField();
		txtServerPort.setColumns(10);
		txtServerPort.setBounds(91, 35, 183, 23);
		txtServerPort.setText("9999");
		contentPane.add(txtServerPort);
		
		txtImageName = new JTextField();
		txtImageName.setColumns(10);
		txtImageName.setBounds(91, 63, 183, 23);
		contentPane.add(txtImageName);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(147, 97, 127, 38);
		contentPane.add(btnClose);
		
		btnDraw = new JButton("Draw");
		btnDraw.setBounds(10, 97, 127, 38);
		contentPane.add(btnDraw);
					
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.exit(0);
			}
		});
		
		btnDraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//SETTING THE SERVER
				String host= txtServerName.getText();
				int port=Integer.parseInt(txtServerPort.getText());
				
				String url="http://"+host+":"+port+"/ImageWS?wsdl";
				ImageWSImplService.setting(url);
				
				//GETTING THE SERVICE
				ImageWSImplService service = new ImageWSImplService();
				ImageWS portService = service.getImageWSImplPort();
				
				//enable MTOM on the client side
				BindingProvider bProvider = (BindingProvider)portService;
				SOAPBinding sBinding = (SOAPBinding) bProvider.getBinding();
				sBinding.setMTOMEnabled(true);
				
				// Code for downloading 
				InputStream in = new ByteArrayInputStream(portService.downloadImage(txtImageName.getText()));
				
				try
				{
					Image image = ImageIO.read(in);	
					
					JFrame jframe = new JFrame();
					jframe.setSize(image.getWidth(null), image.getHeight(null));
					JLabel label = new JLabel(new ImageIcon(image));
					jframe.getContentPane().add(label);
					jframe.setVisible(true);
				} 
				catch (IOException ex) 
				{
					ex.printStackTrace();
				}		
			}
		});
	}
}