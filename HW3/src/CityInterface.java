import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.net.URL;

public class CityInterface extends JComponent implements MouseMotionListener{
	JFrame frame;
	int imageX, imageY;
	Image image, image2, image3, image4, image5;
	
	/**no arg constructor
	 * 
	 */	
	public CityInterface(){
		initialize();			
		frame.setVisible(true);
	}
	
	/**constructor for images
	 * 
	 */	
	public CityInterface(Image i){
		image = i;
		addMouseMotionListener(this);
	}
	
	/**
	 * 
	 */	
	public void mouseDragged(MouseEvent e){
		imageX = e.getX();
		imageY =e.getY();
	}
	
	/**
	 * 
	 */	
	public void mouseMoved(MouseEvent e){}
	
	
	/**
	 * 
	 * @param e
	 */
	public void MouseClicked(MouseEvent e, ButtonOverride btn)
	{
		//Person persons = new Person();
		City city = new City();
		for (int i = 0; i< city.getArrayofPeople().size(); i++){
			//if (city.getArrayofPeople().get(i) instanceof Kid){
			//Kid k = ((Kid)city.getArrayofPeople().get(i));
			if (city.getArrayofPeople().get(i) == btn.getPerson())
			{
				
			
			}
		}		
	}
	
	/**
	 * 
	 */	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(image2, 0, 0, this);
		g2.drawImage(image, imageX, imageY, this);
	}
	
	private void initialize(){
		frame = new JFrame();
		frame.setBounds(500,500, 550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String cityHall = "/resources/city hall.png";
		String school = "/resources/school.png";
		String kid = "/resources/kid.png";
		String teacher = "/resources/teacher.png";
		String police = "/resources/police.png";
		

		Image image = Toolkit.getDefaultToolkit().getImage(CityInterface.class.getResource(cityHall));
		image = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		Image image2 = Toolkit.getDefaultToolkit().getImage(CityInterface.class.getResource(school));
		image2 = image2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		Image image3 = Toolkit.getDefaultToolkit().getImage(CityInterface.class.getResource(kid));
		image3 = image3.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		Image image4 = Toolkit.getDefaultToolkit().getImage(CityInterface.class.getResource(teacher));
		image4 = image4.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		Image image5 = Toolkit.getDefaultToolkit().getImage(CityInterface.class.getResource(police));
		image5 = image5.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		
		//creating city hall and school 
		frame.setLayout( new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		ImageIcon icon = new ImageIcon(image);
		JButton btn = new JButton("Town Hall",icon);
		p.add(btn, "Town Hall");
		icon = new ImageIcon(image2);
		btn = new JButton("School",icon);
		p.add(btn, "School");
		frame.add(p, BorderLayout.SOUTH);
		
		
		//adding kids, police, and teachers //FIX
		City city = new City();
		for (int i = 0; i< city.getArrayofPeople().size(); i++){		
			
		p = new JPanel();
		p.setLayout(new FlowLayout());
		icon = new ImageIcon(image3);
	    btn = new ButtonOverride(city.getArrayofPeople().get(i), icon);
	    
		p.add(btn, "Kid");
		frame.add(p, BorderLayout.EAST);
		
		}
		
		p = new JPanel();
		icon = new ImageIcon(image4);
	    btn = new JButton(icon);
		p.add(btn, "Teacher");
		frame.add(p, BorderLayout.NORTH);
		
		p = new JPanel();
		icon = new ImageIcon(image5);
	    btn = new JButton(icon);
		p.add(btn, "Police");
		frame.add(p, BorderLayout.WEST);
	}
	
	
	
	
	static int imageWidth = 100, imageHeight = 100;
	//defining the grid bag layout
	private void addgb(Component c, int x, int y){
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			CityInterface m = new CityInterface();
		
			
	}
}


/**
 *  
 */



