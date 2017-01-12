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
	 * makes them pretty:)
	 */	
	public CityInterface(Image i){
		image = i;
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	/**
	 * function determines the new location of a button when dragged by the mouse. used in initialize()
	 */	
	public void mouseDragged(MouseEvent e){
		imageX = e.getX();
		imageY =e.getY();
		 int X=e.getX()+btn.getX();
         int Y=e.getY()+btn.getY();
         btn.setBounds(X,Y,150,40);
	}
	
	/**
	 * determines action taken when the mouse is moved in the screen
	 */	
	public void mouseMoved(MouseEvent e){}
	
	
	
	/**
	 * actions made after an action is taken by user 
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
		frame.setBounds(400, 400, 550, 550);
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
		
		
		//frame.setLayout( new FlowLayout());
		JPanel b = new JPanel();
		b.setLayout(new FlowLayout());
		ImageIcon icon = new ImageIcon(image);
		//Box a = Box.createVerticalBox();
		//creating city hall and school 
		for (int i = 0; i< city.getArrayofBuildings().size(); i++){
			if (city.getArrayofBuildings().get(i) instanceof CityHall){
				icon = new ImageIcon(image);
				btn = new ButtonOverride(city.getArrayofBuildings().get(i), icon);	    
				b.add(btn, "City Hall");
				//casting the button to ButtonOverride 
				((ButtonOverride)btn).setBuilding(city.getArrayofBuildings().get(i));
			}
			else if (city.getArrayofBuildings().get(i) instanceof School){
				icon = new ImageIcon(image2);
				btn = new ButtonOverride(city.getArrayofBuildings().get(i), icon);	    
				b.add(btn, "School");
				//casting the button to ButtonOverride 
				((ButtonOverride)btn).setBuilding(city.getArrayofBuildings().get(i));
			}		
		//	b.add(a);
		}
		

		JPanel p = new JPanel();
		//Box q = Box.createVerticalBox();
		JPanel r = new JPanel();
		//Box s = Box.createVerticalBox();
		JPanel t = new JPanel();
		//Box u = Box.createHorizontalBox();
		p.setLayout(new FlowLayout());
		r.setLayout(new FlowLayout());
		t.setLayout(new FlowLayout());
		//adding kids, police, and teachers 
		//access names through city passed as parameter and using getArrayofPeople func
		for (int i = 0; i< city.getArrayofPeople().size(); i++){		
			if (city.getArrayofPeople().get(i) instanceof Kid){
				icon = new ImageIcon(image3);
				btn = new ButtonOverride(city.getArrayofPeople().get(i), icon);	    
				p.add(btn, "Kid");
				//casting the button to ButtonOverride 
				((ButtonOverride)btn).setPerson(city.getArrayofPeople().get(i));
			}
			else if(city.getArrayofPeople().get(i) instanceof Teacher){
				icon = new ImageIcon(image4);
				btn = new ButtonOverride(city.getArrayofPeople().get(i), icon);	    
				p.add(btn, "Teacher");
				//casting the button to ButtonOverride 
				((ButtonOverride)btn).setPerson(city.getArrayofPeople().get(i));
			}
			else if(city.getArrayofPeople().get(i) instanceof Police){
				icon = new ImageIcon(image5);
				btn = new ButtonOverride(city.getArrayofPeople().get(i), icon);	    
				p.add(btn, "Police");	
				//casting the button to ButtonOverride 
				((ButtonOverride)btn).setPerson(city.getArrayofPeople().get(i));
			}
			/*p.add(q);
			r.add(s);
			t.add(u);*/
			btn.addActionListener(new ActionListener(){
				@Override
				/**
				 * on Click, display the information pertaining to the person or building button 
				 */
				public void actionPerformed(ActionEvent e) {	
					ButtonOverride b = (ButtonOverride)e.getSource();
					System.out.printf("Mouse clicked activated\n");
						//if the button is of a type, display the info of that specific type of person
							if (b.getPerson() instanceof Kid)
							{			
								String st = String.valueOf(b.getPerson().getAge());
								String text = ("Name: "+ b.getPerson().getName() + "\n Age:" +st + "\n Fav Candy: " + b.getPerson().getFavCandy());
								persInfo.setText(text);
								pan.add(persInfo);
							}
							else if (b.getPerson() instanceof Teacher)
							{
								String st = String.valueOf(b.getPerson().getAge());
								String text = ("Name: "+ b.getPerson().getName()+ "\n Age:" +st + "\n Grade Level: " + b.getPerson().getGradeLevel());
								persInfo.setText(text);
								pan.add(persInfo);
							}
							else if(b.getPerson() instanceof Police)
							{			
								String st = String.valueOf(b.getPerson().age);
								String text = ("Name: "+ b.getPerson().getName() + "\n Age:" +st + "\n Role: " + b.getPerson().getRole());
								persInfo.setText(text);
								pan.add(persInfo);
							}
							if(b.getBuilding() instanceof CityHall)
							{			
								//String st = String.valueOf(b.getBuilding().getOccupants());
								String text = ("Building Name: "+ b.getBuilding().getName());
								persInfo.setText(text);
								pan.add(persInfo);
							}
									
					frame.getContentPane().add(pan, BorderLayout.NORTH);
					repaint();
					revalidate();
					
					}
			});
			
			btn.addMouseMotionListener(new MouseAdapter()
					{
				/**
				 * this function allows a button to be dragged on the screen. It sets the bounds to a pre determined size
				 */
				public void mouseDragged(MouseEvent e){
					ButtonOverride b = (ButtonOverride)e.getSource();
					//imageX = e.getX();
					//imageY =e.getY();
					//rewrites location of button while being dragged
					 int X=e.getX()+ b.getX();
			         int Y=e.getY()+ b.getY();
			         b.setBounds(X,Y,150,70);
				};
					});
			repaint();
			revalidate();
			
		
		}
		//adding panels of buttons to frame
		frame.getContentPane().add(b, BorderLayout.SOUTH);
		frame.getContentPane().add(p, BorderLayout.CENTER);
		//frame.getContentPane().add(r, BorderLayout.WEST);
		//frame.getContentPane().add(t, BorderLayout.NORTH);

	}
	
	
	

	/**
	 * Main function that creates a city of buildings and people. When constructor is called for the city, the window simulation will display
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
				//adding array of buildings to city class
				city.setArrayOfBuildings(buildingsArray);
				
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
	/**
	 * Function to override mouseClicked event
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		}

	/**
	 * Function to override mouseEntered event
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Function to override mouseExited event
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Function to override mousePressed event
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Function to override mouseReleased event
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}





