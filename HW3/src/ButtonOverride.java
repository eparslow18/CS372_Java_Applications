import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonOverride extends JButton {

		private Person pers;
	public ButtonOverride(Person person, ImageIcon icon){
		super(person.name, icon);
		pers = person;
		
	}
	
	public void getPerson(){
		
	}
	
	public void updateButton(){
		
	}
	
}
