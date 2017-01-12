import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.net.URL;

public class CityInterface extends JComponent implements MouseMotionListener, MouseListener{
	JFrame frame;
	int imageX, imageY;
	Image image, image2, image3, image4, image5;
	ButtonOverride btn;
	City city;
	JPanel pan = new JPanel();
	JLabel persInfo = new JLabel();
	
	/**Constructor that generates the JFrame by calling initialize private function
	 * @param City Object so the people of the city can be accessed and added to the interface 
	 */	
	public CityInterface(City city){
		//this.btn =btn;
		//, ButtonOverride btn
		this.city = city;
		initialize(city);			
		frame.setVisible(true);
	}
	
	/**constructor for images
	 * 
	 */	
	public CityInterface(Image i){
		image = i;
		addMouseMotionListener(this);
		addMouseListener(this);
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
	public void actionPerformed(ActionEvent e)
	{	}
		
	
	/**Paints the graphics of an image
	 * 
	 */	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(image2, 0, 0, this);
		g2.drawImage(image, imageX, imageY, this);
	}
	
	private void initialize(City city){
		frame = new JFrame();
		frame.setBounds(800, 800, 800, 800);
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
		
		
		p = new JPanel();
		Box q = Box.createVerticalBox();
		JPanel r = new JPanel();
		Box s = Box.createVerticalBox();
		JPanel t = new JPanel();
		Box u = Box.createHorizontalBox();
		p.setLayout(new FlowLayout());
		r.setLayout(new FlowLayout());
		t.setLayout(new FlowLayout());
		//adding kids, police, and teachers 
		//access names through city passed as parameter and using getArrayofPeople func
		for (int i = 0; i< city.getArrayofPeople().size(); i++){		
			if (city.getArrayofPeople().get(i) instanceof Kid){
				icon = new ImageIcon(image3);
				btn = new ButtonOverride(city.getArrayofPeople().get(i), icon);	    
				q.add(btn, "Kid");
				//casting the button to ButtonOverride 
				((ButtonOverride)btn).setPerson(city.getArrayofPeople().get(i));
			}
			else if(city.getArrayofPeople().get(i) instanceof Teacher){
				icon = new ImageIcon(image4);
				btn = new ButtonOverride(city.getArrayofPeople().get(i), icon);	    
				s.add(btn, "Teacher");
				//casting the button to ButtonOverride 
				((ButtonOverride)btn).setPerson(city.getArrayofPeople().get(i));
			}
			else if(city.getArrayofPeople().get(i) instanceof Police){
				icon = new ImageIcon(image5);
				btn = new ButtonOverride(city.getArrayofPeople().get(i), icon);	    
				u.add(btn, "Police");	
				//casting the button to ButtonOverride 
				((ButtonOverride)btn).setPerson(city.getArrayofPeople().get(i));
			}
			p.add(q);
			r.add(s);
			t.add(u);
			btn.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {		
					System.out.printf("Mouse clicked activated\n");
					for (int i = 0; i< city.getArrayofPeople().size(); i++){
					//	if (city.getArrayofPeople().get(i) == ((ButtonOverride)btn).getPerson())
						//{
							//System.out.printf("In the if statement %d times \n", i);
							String st = String.valueOf(city.getArrayofPeople().get(5).age);
							
							if (city.getArrayofPeople().get(5) instanceof Kid)
							{				
								String text = ("Name: "+ city.getArrayofPeople().get(5).name + "\n Age:" +st + "\n Fav Candy: " + city.getArrayofPeople().get(5).getFavCandy());
								persInfo.setText(text);
								pan.add(persInfo);
							}
							else if (city.getArrayofPeople().get(5) instanceof Teacher)
							{
								String text = ("Name: "+ city.getArrayofPeople().get(5).name + "\n Age:" +st + "\n Grade Level: " + city.getArrayofPeople().get(5).getGradeLevel());
								persInfo.setText(text);
								pan.add(persInfo);
							}
							else if(city.getArrayofPeople().get(5) instanceof Police)
							{								
								String text = ("Name: "+ city.getArrayofPeople().get(5).name + "\n Age:" +st + "\n Role: " + city.getArrayofPeople().get(5).getRole());
								persInfo.setText(text);
								pan.add(persInfo);
							}
							
							
						//}
					}		
					frame.getContentPane().add(pan, BorderLayout.CENTER);
					revalidate();
					}
			});
			
			
		}
		//adding panels of buttons to frame
		frame.getContentPane().add(p, BorderLayout.EAST);
		frame.getContentPane().add(r, BorderLayout.WEST);
		frame.getContentPane().add(t, BorderLayout.NORTH);

	}
	
	
	

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

			City city = new City();
			
			 Person[] personsArray = { new Kid("Joe"), new Kid("Moe"),new Kid("Loe"),new Kid("Poe"),new Kid("Toe"),
					new Police("Dan"), new Police("Lan"), new Police("Tan"), new Police("Man"), new Police("Stan"), 
					new Teacher("Lee"), new Teacher("Ree"), new Teacher("Bee"), new Teacher("Fee"), new Teacher("Dee") 
				};	 
			Building[] buildingsArray = { new CityHall("City Hall"), new School("K12 Learning"), new Building("Pharmacy"), new Building("Gas Station"),
					new Building("Post Office"), new Building("Store"), new Building("Gas Station")			
				};
			//adding array of people to city class
				city.setArrayOfPeople(personsArray);
				
				//generating interface 
				CityInterface m = new CityInterface(city);
				
				
				
				/////////////////////////////////////
				//////////////HW2 Questions//////////
				//output buildings 
				for (int i = 0; i <buildingsArray.length; i++){
				city.buildings.add(buildingsArray[i]);
				}
				//all buildings in city
				city.allBuildings();
				//output peoplew2
				for (int i = 0; i <personsArray.length; i++){
				city.persons.add(personsArray[i]);
				}
				//all persons in city
				city.allPersons();
				//kids in school
				city.kidsInSchool();
				//teachers in school 
				city.teachersInSchool();
				//officers in city hall
				city.officersInCityHall();
				/////////////////////////////////////
			
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}





