import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonOverride extends JButton{
	
	private interfaceShape shape;
	
	public ButtonOverride(interfaceShape shape){
		super();
		this.shape = shape;
	}
	
	
	public interfaceShape getInterfaceShape(){
		return shape;
	}
	
}
