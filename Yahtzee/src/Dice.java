import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;

/**
 * Class to create Dice object
 * Displays frame and creates button to stop dice roll
 * Displays count of dice on button click 
 */
public class Dice {
 public static boolean stopDice = false;
 public static int counter = 0;
 Rand[] cs = new Rand[5];
 
/**
 * Constructor to generate frame and call Rand function to start threads
 *
 */
	public Dice(){	
	JFrame frame = new JFrame();
    frame.setSize(800, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    
    for (int i=0; i<5; i++) {
        JLabel l = new JLabel();
        cs[i] = new Rand(l);
        frame.add(l);
    }
    
    //create start stop button
    JButton btn = new JButton("Stop Dice");
    frame.add(btn);
    //add on click action listener to stop the dice rolling 
    btn.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			if (stopDice ==false){
				for (int i = 0; i < 5; i++)
				{
				counter += cs[i].count;
				}
				
				stopDice = true;				
				}
			if (stopDice == true){
					String extraCredit = ("BONUS Dice Count: " + counter);
					btn.setText(extraCredit);

		    	}
			}	
		});
    
    
    //display jframe
    frame.setVisible(true);

    Thread[] ts = new Thread[5];
    for (int i=0; i<5; i++) {
        ts[i] = new Thread(cs[i]);
        ts[i].start();
       
        try {
            Thread.sleep(10);

        }
        catch (InterruptedException ex) {;}
    }
    
    
	}
	
	/**
	 * Main creating dice object
	 * @param args
	 */
	public static void main(String[] args ){
		Dice dice = new Dice();
	}
	

}

