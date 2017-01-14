import java.util.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class interfaceShape {
	String shapeID;
	String shapeKind;
	JFrame frame;
	interfaceShape shape;
	public ArrayList<interfaceShape> shapesList = new ArrayList<interfaceShape>();
	private static Map<String, interfaceShape> shapeMap = new HashMap<String, interfaceShape>();
	
	public interfaceShape(String line){}
	
	public interfaceShape(){
		//intilize();
	}

	
	public void createWindowFeatures(){
		frame = new JFrame();
		frame.setBounds(500, 500, 550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		
		JPanel b = new JPanel();
		//b.setLayout(new FlowLayout());
		ButtonOverride left = new ButtonOverride(shapesList.get(0));
		for (int i = 0; i < shapesList.size(); i++){
		if(shapesList.get(i) instanceof Square){	
			String text = (shapesList.get(i).getKind() + " ID" +shapesList.get(i).getID() + " \n");
			left.setText(text);
			b.add(left);
			left = new ButtonOverride(shapesList.get(i));
			}
		else if (shapesList.get(i) instanceof Circle){	
			String text = ( shapesList.get(i).getKind() + " ID" +shapesList.get(i).getID() + " \n");
			left.setText(text);
			b.add(left);
			left = new ButtonOverride(shapesList.get(i));
			}
		else if (shapesList.get(i) instanceof Triangle){	
			String text = (shapesList.get(i).getKind() + " ID" +shapesList.get(i).getID() + " \n");
			left.setText(text);
			b.add(left);
			left = new ButtonOverride(shapesList.get(i));
			}

		
		}
		b.add(left);
		frame.add(b, BorderLayout.CENTER);
		
		///////////////
		//TO FINISH I NEED TO ALLOW ON CLICK DISPLAY THE INFO AND ASSOCIATED SHAPE IMAGE
		//LAST PART OF THE EXAM FOR ME TO COMPLETE 
		//BELOW IS THE STARTING CODE TO IMPLEMENT THE BUTTON LISTENING BUT I WAS OUT OF TIME TO FINISH 
		//
		//
		//left.addActionListener(new ActionListener(){
		//	@Override
		//	public void actionPerformed(ActionEvent e) {
		//		JButton b = (ButtonOverride)e.getSource();
			//	if (b.get){
			//		
			//	}
				
				//}
		//	});

	}
	
	/**sets id and shape to one string 
	 * @return kind of shape and ID of shape 
	 */
	public String toString(String s){
		return s;
	}
	
	public void setKind(String kind){
		this.shapeKind = kind;
	}
	
	/**
	 * Return kind of shape 
	 * @param id accesses the shape being called 
	 * @return the kind of shape 
	 */
	public String getKind(){
		return shapeKind;	
	}
	
	/**
	 * Return details of that shape 
	 * @param s
	 * @return kind, id, properties, area, perimeter
	 */
	public String getDetailString(String s){
		//shapeMap.get(s).getID();
		//shapeMap.get(s).getKind();
		for (int i = 0; i < shapesList.size(); i++){
		if (shapesList.get(i) instanceof Square){
			System.out.printf("Square\n");
			}
		}
		return s;
	}

	
	/**
	 * 
	 * @param id
	 */
	public void setID(String id){
		shapeID = id;
	}
	
	/**
	 * Return id of a shape object 
	 * @return ID if shape 
	 */
	public String getID(){
		return shapeID;
	}
	
	/**
	 * Add a new shape object 
	 * @param l
	 */
	public void addNewShape(String l){
		if(l.toLowerCase().contains("circle")){
			Circle c = new Circle(l);
			shapeMap.put(c.getID(), c);
			shapesList.add(c);
			
		}
		else if (l.toLowerCase().contains("square")){
			Square s = new Square(l);
			shapeMap.put(s.getID(), s);	
			shapesList.add(s);
		}
		else if(l.toLowerCase().contains("triangle")){
			Triangle t = new Triangle(l);
			shapeMap.put(t.getID(), t);
			shapesList.add(t);
		}
	}
	
	///////////////////////////////////////Main///////////////////////////////////	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		String curdir = System.getProperty("user.dir") + "\\src";
		
        File cd = new File(curdir);
        interfaceShape shape = new interfaceShape(); 
       
        File[] files = cd.listFiles();
        for (File f: files) {
            if (f.getName().endsWith(".txt")) {
            	try (BufferedReader br = new BufferedReader(new FileReader(f.getAbsolutePath()))) {
                    String line = br.readLine();
                 
                    while (line != null){ 
                        line = br.readLine();
                        String l = line;
                        //adding a new shape by line of text                        
                        shape.addNewShape(l);
                    }              
                }
                catch (Exception ex) { System.out.printf("Failed for %s\n", f.getName());}
            }
           
        }
        shape.createWindowFeatures();
	}
}


