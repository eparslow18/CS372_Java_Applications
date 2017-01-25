import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JLabel;

/**
 * This class opens up a file and reads its contents into 2d arrays of sudoku puzzles 
 * It also sets the mask 2d arrays to decide which numbers to display and which not to
 * @author Elisha Parslow 
 *
 */
public class PuzzleGenerator {
public static ArrayList<String> puzzle = new ArrayList<String>(); 
public static ArrayList<String> puzzle2= new ArrayList<String>(); 

public static ArrayList<ArrayList> puzzlesList = new ArrayList<ArrayList>();
public static int countLines =0;


	public PuzzleGenerator(){
		
		String curdir = System.getProperty("user.dir") + "\\src";	
	    File cd = new File(curdir);
	  	   
	    File[] files = cd.listFiles();
	    for (File f: files) {
	        if (f.getName().equals("puzzle.txt")) {
	        	try (BufferedReader br = new BufferedReader(new FileReader(f.getAbsolutePath()))) {
	                String line = br.readLine();
	             
	                while (line != null){ 
	                    line = br.readLine();
	                    String l = line;
	                    readLines(l, f);
	                    countLines++;

	                }              
	            }
	            catch (Exception ex) { System.out.printf("Failed for %s\n", f.getName());}
	        }
	    }
	    for (File f: files) {
	        if (f.getName().equals("puzzle2.txt")) {
	        	try (BufferedReader br = new BufferedReader(new FileReader(f.getAbsolutePath()))) {
	                String line = br.readLine();
	             
	                while (line != null){ 
	                    line = br.readLine();
	                    String l = line;
	                    readLines(l, f);
	                    countLines++;

	                }              
	            }
	            catch (Exception ex) { System.out.printf("Failed for %s\n", f.getName());}
	        }
	    }
	}
	
	
	/**
	 * Read in the lines of the text files and add them to array 
	 * @param line
	 */
	public void readLines(String line, File file){
		String split[]= line.split("\\s+");
		//loop through line to assign contents of line to specifics
		for (int i = 0; i < split.length; i++){
			if(file.getName().equals("puzzle.txt")){
				puzzle.add(split[i]);
				}
				if(file.getName().equals("puzzle2.txt")){
					puzzle2.add(split[i]);
				}
				System.out.printf("Puzzle in slot %d is %s\n", i, puzzle2.get(i));
					
						
		}
	}
	
}
