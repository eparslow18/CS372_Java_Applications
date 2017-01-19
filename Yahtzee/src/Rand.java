import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.Random;

/**
 * Rand is a class to display dice images at random for each thread
 * It implements runnable to allow each thread to randomly acess the images and display them
 * @author eparslow18
 *
 */
public class Rand implements Runnable {
    private JLabel _label;
	Image image, image2, image3, image4, image5, image6;
	ImageIcon icon1, icon2, icon3, icon4, icon5, icon6;
	int count;
	public static int[] counters = new int[5];
	
    /**Initilize URL images and set them to image icons of dice pictures 
     * Set the label to the current jlabel 
     * @param label
     */
    public Rand(JLabel label) {
    	try{
    	URL imgURL1 = new URL ("http://dobbelsteen.virtuworld.net/img/1c.gif");
    	Image image = Toolkit.getDefaultToolkit().getImage(imgURL1);
    	image = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    	URL imgURL2 = new URL ("http://dobbelsteen.virtuworld.net/img/2c.gif");
    	Image image2 = Toolkit.getDefaultToolkit().getImage(imgURL2);
    	image2 = image2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    	URL imgURL3 = new URL ("http://dobbelsteen.virtuworld.net/img/3c.gif");
    	Image image3 = Toolkit.getDefaultToolkit().getImage(imgURL3);
    	image3 = image3.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    	URL imgURL4 = new URL ("http://dobbelsteen.virtuworld.net/img/4c.gif");
    	Image image4 = Toolkit.getDefaultToolkit().getImage(imgURL4);
    	image4 = image4.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    	URL imgURL5 = new URL ("http://dobbelsteen.virtuworld.net/img/5c.gif");
    	Image image5 = Toolkit.getDefaultToolkit().getImage(imgURL5);
    	image5 = image5.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      	URL imgURL6 = new URL ("http://dobbelsteen.virtuworld.net/img/6c.gif");
    	Image image6 = Toolkit.getDefaultToolkit().getImage(imgURL6);
    	image6 = image6.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    	
    	 icon1 = new ImageIcon(image);
    	 icon2 = new ImageIcon(image2);
    	 icon3 = new ImageIcon(image3);
    	 icon4 = new ImageIcon(image4);
    	 icon5 = new ImageIcon(image5);
    	 icon6 = new ImageIcon(image6);
        _label = label;
    	}
    	catch (Exception ex){;}
    }

    /**
     * Have each thread iterate through an array of imageicons randomly while the stop dice button is false 
     * and hasn't been clicked 
     */
    public void run() {
    	//while bool from on click is false, display a random dice picture 
    	ImageIcon icons[] ={icon1, icon2, icon3, icon4, icon5, icon6};
    	Random random = new Random();
    	int i;
    
    	while(Dice.stopDice == false){
    		i = random.nextInt(6);
    		_label.setIcon(icons[i]);
    		count = i + 1;
            try {
            	
                Thread.sleep(100);
                
            }
            catch (InterruptedException ex) {;}
          
    	} 

       }
   }
 



