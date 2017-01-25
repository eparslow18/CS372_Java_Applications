import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Sudoku {
	public static JFrame frame; 
	public static JPanel panel = new JPanel();
	public static JLabel box = new JLabel();
	public static ArrayList<JLabel> boxArray = new ArrayList<JLabel>();
	public static JLabel previousBox = null;
	static Border blackline = BorderFactory.createLineBorder(Color.black);
	static Border greyline = BorderFactory.createLineBorder(Color.gray);
	static Border outline = BorderFactory.createLineBorder(Color.BLUE, 3);//create border from mouse click to select specific square 
	public static JLabel l;
	public static int puzzlesCount = 0;
	static String currentValue;//to access current jlabel 
	public static Boolean disableButtons = false;
	
		private static boolean[] masks = { //array to set first puzzle integers to visible 
	true, false, true, false, true, true, false, true, true,
	false, true, true, false, true, false, true, true, false,
	      true, true, false, true, true, false, true, false, true,
	      false, false, true, false, true, false, true, false, true,
	      false, false, true, false, true, false, true, false, true,
	      true, true, false, false, true, true, false, false, true,
	      false, false, true, false, false, true, true, true, false,
	      false, false, false, false, false, false, false, true, true,
	      true, true, false, true, true, false, false, true, true};

	/**
	* Constructor to start game 
	*/
	public Sudoku(){
		generateBoard();
		PuzzleGenerator newPuzzle = new PuzzleGenerator();
		intilizeBoard();
		
	}
	
	/**
	* Generate Sudoku board
	*/
	public static void generateBoard(){
		frame = new JFrame("Sudoku");
		   frame.setSize(500,500);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   //generate grid of 3 x 3 panels
		   frame.getContentPane().setLayout(new GridLayout(4, 4));
		   
		   for( int i = 0; i <9 ; i ++){
			   //generate 9 panels of 9x9 spots 
			   panel = new JPanel();
			  panel.setLayout(new GridLayout(3, 3));
			  for (int j = 0; j < 9; j++){
				 box = new JLabel();
				 box.setBorder(greyline);
				 box.setAlignmentX(Component.CENTER_ALIGNMENT);
				 
				 box.setFont(box.getFont().deriveFont(22f));
				 box.setBackground(Color.WHITE);
				 box.setForeground(Color.BLACK);
				   box.setOpaque(true);
				 boxArray.add(box); //add the box to the array to use in initialize function

				 //add a mouse listener instead and listen to mouse clicks*/
				 box.addMouseListener(new MouseAdapter() {
		               @Override
		               public void mouseClicked(MouseEvent e) {
		                            
		              
		                if(previousBox != null)
		                previousBox.setBorder(greyline);//change the background of the last selected box back to white
		                l = (JLabel)e.getSource();
		                 
		                //create a current jlabel to access value to display color later on 
		                JLabel current = (JLabel)e.getSource();
		                currentValue = current.getText();
		                 
		                previousBox = l;//set the previous box to the current box to change back later 
		                if(l.getForeground() != Color.BLACK)
		                   l.setBorder(outline);              
		               
		               }
		
		           });
		  panel.add(box);
	  }
	   //create boarders around 3x3 panels and add panels to the frame 
	  panel.setBorder(blackline);
	  frame.add(panel);
   }
   
   //generate 9 buttons with 1-9 on them 
  panel = new JPanel();
  panel.setLayout(new FlowLayout());
  JButton btn = new JButton(); 
  for (int k = 1; k< 10; k++){
 String s = String.valueOf(k);
 btn = new JButton(s);
 panel.add(btn);
 
	btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            //Execute when button is pressed
	        JButton b = (JButton)e.getSource();
	       
	        //if the game has not been won, keep the buttons enabled 
		       if(disableButtons == false){
			       if(l.getForeground()!= Color.BLACK){ //if there isn't a preset visible jlabel text 
			       l.setText(b.getText());//set text in selected box to selected button                 
				       if(l.getText()!= null){
				       //set text color to let player know if value is correct
					       if(l.getText().equals(currentValue)){//if it matches, set text to blue
					        l.setForeground(Color.BLUE);
					        gameWon(); //check if game has been won after setting a new number
					        }
					        else {//else set text to red for incorrect value
					        l.setForeground(Color.RED);
					        	}
			       }
		       }
		       }
	       //if the game has been won, disable the buttons to change the jlabels
	       else if (disableButtons == true){
	        b.setEnabled(false);
	       }
	        }
	    }); 
   
  }
 
  frame.add(panel);
  
  JButton newGame = new JButton(" New Game ");
	 newGame.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  intilizeBoard();
		      }
		 });
  
  //create an instructions button that on click will open a new window with instructions on them 
  JButton instructions = new JButton("Instructions");
  instructions.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
     JFrame instructionsFrame = new JFrame("Sudoku Instructions");
     JLabel instructionsLabel = new JLabel("<html>Rule 1: Each of the 9 Grids must have all 9 numbers (1 to 9)<br/> Rule 2: Each of the 9 vertical columns must have all 9 numbers (1 to 9)<br/> Rule 3: Each of the 9 horizontal rows must have all 9 numbers (1 to 9)</html>");
      instructionsFrame.setSize(500,100);
      instructionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      instructionsFrame.setLayout(new FlowLayout());
      instructionsFrame.add(instructionsLabel);
         instructionsFrame.setVisible(true);
     }
        });
  panel = new JPanel();
  panel.add(newGame);
  panel.add(instructions);
  frame.add(panel);
   
   frame.setVisible(true);
}

/**
* Set contents of board using the puzzle and mask arrays 
*/
public static void intilizeBoard(){
	for(int i = 0; i < boxArray.size(); i ++){
		boxArray.get(i).setText(PuzzleGenerator.puzzle2.get(i)); 
		if(masks[i] == false){
			boxArray.get(i).setForeground(Color.WHITE);//set to white since the player moves are based on Foreground color 
		}
	}
	puzzlesCount++;//increment to grab a different puzzle
	
}

/**
 * Letting player know when they have won the game
 * Create a new JFrame to display that they have won
 * add to count for every box in the box array where the foreground is set to black or blue 
 */
public static void gameWon(){
	int count = 0;
	for (int i = 0; i < boxArray.size(); i++){
		if (boxArray.get(i).getForeground()== Color.BLACK || boxArray.get(i).getForeground()== Color.BLUE){
			count++;
			if (count == 81){
				JFrame youWon = new JFrame("Winner!");
				JLabel winner = new JLabel("<html>Congrats, you've won!<br/> Select 'New Game' to play again.</html>");
				youWon.setSize(500,100);
				    youWon.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    youWon.setLayout(new FlowLayout());
				youWon.add(winner);
				youWon.setVisible(true);
				disableButtons = true;
				System.out.printf("Count is 81 and the game is won");
			}
		 
		}
	}
}

	/**
	* main to start the game
	* @param args
	*/
	public static void main(String[] args) {
	//start game
		Sudoku sudoku = new Sudoku();
	}

}