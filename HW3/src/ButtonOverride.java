import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class inherting from JButton to override JButton functions 
 * @author eparslow18
 *
 */
public class ButtonOverride extends JButton {

		private Person pers;
		private String string;
		private Building build;
		
	/**	
	 * Constructor to create a new button that adds a Person object to the buttons identifiers 
	 * @param person
	 * @param icon
	 */
	public ButtonOverride(Person person, ImageIcon icon){
		super(person.name, icon);
		pers = person;
		
	}
	
	/**
	 * Constructor to create a new button that adds a Building object to the buttons identifiers 
	 * @param building
	 * @param icon
	 */
	public ButtonOverride(Building building, ImageIcon icon){
		super(building.name, icon);
		build = building;
		
	}
	
	/**
	 * Constructor to create a new button that displays an image alongside a string 
	 * @param string
	 * @param icon
	 */
	public ButtonOverride(String string, ImageIcon icon){
		super(string, icon);
		this.string = string;		
	}
	
	/**
	 * Return Person object associated with button
	 * @return
	 */
	public Person getPerson(){
		return pers;
	}
	
	/**
	 * Set Person object associated with button
	 * @param p
	 */
	public void setPerson(Person p){
		this.pers = p;
	}
	
	/**
	 * Return Building object associated with button
	 * @return
	 */
	public Building getBuilding(){
		return build;
	}
	
	/**
	 * Set Building object associated with button
	 * @param b
	 */
	public void setBuilding(Building b){
		this.build = b;
	}
	
}
