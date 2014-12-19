package client;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;


import javax.swing.JTextField;

public class ImageDownloadedFrame extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Image im;
	private JTextField txtPath;
	
	private JButton btnClose;
	private JButton btnSave;

	/**
	 * Create the frame.
	 */
	public ImageDownloadedFrame() 
	{
		setTitle("Image Downloaded");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPath = new JTextField();
		txtPath.setText("C:/Users/Luca/Desktop/NAME");
		txtPath.setBounds(109, 12, 224, 20);
		contentPane.add(txtPath);
		txtPath.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(10, 11, 89, 23);
		contentPane.add(btnSave);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(343, 11, 89, 23);
		contentPane.add(btnClose);
		
		btnSave.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try 
				{
					BufferedImage bImage = new BufferedImage(im.getWidth(null), im.getHeight(null), BufferedImage.TYPE_INT_RGB);
					Graphics2D graphics = bImage.createGraphics();
					graphics.drawImage(im, null, null);
					RenderedImage rImage = (RenderedImage)bImage;
					ImageIO.write(rImage, "jpg", new File(txtPath.getText()));
					JOptionPane.showMessageDialog(null, "Download Success");
				} 
				catch (Exception ex) 
				{
					JOptionPane.showMessageDialog(null, "Download error");
				}
			}
		});		

		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				setVisible(false);
			}
		});

	}
	public void setImage(Image im)
	{
		this.im=im;
		JLabel lblImage = new JLabel(new ImageIcon(im));

		lblImage.setBounds(50,50,this.im.getWidth(null), this.im.getHeight(null));
		lblImage.setSize(this.im.getWidth(null), this.im.getHeight(null));
		contentPane.add(lblImage);
		
		int marginRight=btnClose.getX()+btnClose.getWidth();
		int orizontal=0;
		if(marginRight<im.getWidth(null))
			orizontal=Math.abs(marginRight-im.getWidth(null)-50);
		this.setBounds(100, 100, this.getWidth()+orizontal, this.im.getHeight(null)+80);
	}
}