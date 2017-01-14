import java.util.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.awt.FlowLayout;
import java.io.*;

public class Circle extends interfaceShape{
	String radius;
	String ID;
	String color;
	String kind;
	

	
	public Circle(String line){
		//split the string contents by line 
		String split[]= line.split("\\s+");
		//loop through line to assign contents of line to specifics
		for (int i = 0; i < split.length; i++){
			if( i == 0 ){
				setKind(split[i]);
				getKind();
			}
			else if (i == 1){
				setID(split[i]);
			}
			else if(i == 2){
				setRadius(split[i]);
			}
			else if(i ==3){
				setColor(split[i]);
			}
		}
	}
	
	public void setID(String ID){
		super.setID(ID);
	}
	
	public void setKind(String kind){
		super.setKind(kind);
	}
	
	public void setRadius(String radius){
		this.radius = radius;
	}
	
	public void setColor(String color){
		this.color = color;
	}
}
