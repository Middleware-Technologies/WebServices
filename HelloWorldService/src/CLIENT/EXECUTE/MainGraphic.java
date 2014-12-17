package CLIENT.EXECUTE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;

import CLIENT.HelloWorld;
import CLIENT.HelloWorldImpService;

public class MainGraphic 
{

	private JFrame frmClient;
	private JTextField txtServerName;
	private JTextField txtPort;
	private JLabel lblYourName;
	private JTextField txtYourName;
	private JButton btnInvoke;
	private JLabel lblNewLabel;
	private JTextArea txtResult;
	private JLabel lblPort;
	private JButton btnClose;
	private JButton btnReset;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try 
				{
					MainGraphic window = new MainGraphic();
					window.frmClient.setVisible(true);
				} 
				catch (Exception e) {}
			}
		});
	}

	public MainGraphic() 
	{
		initialize();
	}

	private void initialize() 
	{
		frmClient = new JFrame();
		frmClient.setTitle("Client");
		frmClient.setBounds(100, 100, 260, 329);
		frmClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClient.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Server Name");
		lblNewLabel.setBounds(10, 11, 119, 14);
		frmClient.getContentPane().add(lblNewLabel);
		
		txtResult = new JTextArea();
		txtResult.setBounds(10, 150, 224, 75);
		frmClient.getContentPane().add(txtResult);
		
		txtServerName = new JTextField();
		txtServerName.setBounds(86, 8, 148, 20);
		txtServerName.setText("Luca-Pc");
		frmClient.getContentPane().add(txtServerName);
		txtServerName.setColumns(10);
		
		lblPort = new JLabel("Port");
		lblPort.setBounds(10, 43, 119, 14);
		frmClient.getContentPane().add(lblPort);
		
		txtPort = new JTextField();
		txtPort.setColumns(10);
		txtPort.setBounds(86, 40, 148, 20);
		txtPort.setText("8085");
		frmClient.getContentPane().add(txtPort);
		
		lblYourName = new JLabel("Your Name");
		lblYourName.setBounds(10, 74, 119, 14);
		frmClient.getContentPane().add(lblYourName);
		
		txtYourName = new JTextField();
		txtYourName.setColumns(10);
		txtYourName.setBounds(86, 71, 148, 20);
		frmClient.getContentPane().add(txtYourName);
		
		btnInvoke = new JButton("Invoke Service");
		btnInvoke.setBounds(10, 99, 224, 40);
		frmClient.getContentPane().add(btnInvoke);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(10, 236, 83, 44);
		frmClient.getContentPane().add(btnClose);
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(151, 236, 83, 44);
		frmClient.getContentPane().add(btnReset);
		
		
		btnInvoke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try
				{
					String name=txtServerName.getText();
					String port=txtPort.getText();
					
					String webServiceUrl="http://"+name+":"+port+"/Server/Hello?wsdl";
					HelloWorldImpService.setUrl(webServiceUrl);
					
					HelloWorldImpService helloService=new HelloWorldImpService();
					HelloWorld hello=helloService.getHelloWorldImpPort();
									
					String input=txtYourName.getText();
					String res="RESULT FROM WEB SERVICE:\n"+hello.sayHello(input);
					
					txtResult.setText(res);
				}
				catch(Exception eX)
				{
					JOptionPane.showMessageDialog(null,"Errore: "+eX.getCause());
				}
			}
		});
		
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.exit(0);
			}
		});
		
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				txtResult.setText("");
			}
		});
	}
}