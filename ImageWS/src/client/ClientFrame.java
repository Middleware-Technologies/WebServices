package client;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	private JButton btnUpload;
	
	private JLabel lblServerName;
	private JLabel lblServerPort;
	private JLabel lblImageName;
	
	private JTextField txtServerName;
	private JTextField txtServerPort;
	private JTextField txtImageName;

	public ClientFrame() 
	{
		this.renderForm();					
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
				try
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
					byte[]buf=portService.downloadImage(txtImageName.getText());
					InputStream in = new ByteArrayInputStream(buf);
					Image image = ImageIO.read(in);	
					
					ImageDownloadedFrame frame=new ImageDownloadedFrame();
					frame.setImage(image);
					frame.setVisible(true);
				} 
				catch (IOException ex) 
				{
					JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
				}		
			}
		});

		btnUpload.addMouseListener(new MouseAdapter() {
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
				
				// Code for upload 
				try 
				{
					JFileChooser chooser= new JFileChooser();

					int choice = chooser.showOpenDialog(null);

					if (choice != JFileChooser.APPROVE_OPTION) 
					{
						JOptionPane.showMessageDialog(null,"Select A File");
						return;
					}
					File chosenFile = chooser.getSelectedFile();		
					Path path = Paths.get(chosenFile.getPath());
					byte[] data = Files.readAllBytes(path);
					
					String message=portService.uploadImage(data, chosenFile.getName());
					JOptionPane.showMessageDialog(null,message);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
	}
	
	private void renderForm()
	{
		setResizable(false);
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblServerName = new JLabel("Server Name");
		lblServerName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblServerName.setBounds(10, 21, 89, 14);
		contentPane.add(lblServerName);
		
		lblServerPort = new JLabel("Server Port");
		lblServerPort.setFont(new Font("Calibri", Font.BOLD, 14));
		lblServerPort.setBounds(10, 57, 89, 14);
		contentPane.add(lblServerPort);
		
		lblImageName = new JLabel("Image Name");
		lblImageName.setFont(new Font("Calibri", Font.BOLD, 14));
		lblImageName.setBounds(10, 93, 89, 14);
		contentPane.add(lblImageName);
		
		txtServerName = new JTextField();
		txtServerName.setBounds(98, 16, 178, 23);
		txtServerName.setText("Luca-Pc");
		contentPane.add(txtServerName);
		txtServerName.setColumns(10);
		
		txtServerPort = new JTextField();
		txtServerPort.setColumns(10);
		txtServerPort.setBounds(98, 52, 178, 23);
		txtServerPort.setText("9999");
		contentPane.add(txtServerPort);
		
		txtImageName = new JTextField();
		txtImageName.setColumns(10);
		txtImageName.setBounds(98, 88, 178, 23);
		contentPane.add(txtImageName);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(10, 219, 266, 38);
		contentPane.add(btnClose);
		
		btnDraw = new JButton("Draw");
		btnDraw.setBounds(10, 119, 266, 38);
		contentPane.add(btnDraw);
		
		btnUpload = new JButton("Upload Image");
		btnUpload.setBounds(10, 169, 266, 38);
		contentPane.add(btnUpload);
	}
}