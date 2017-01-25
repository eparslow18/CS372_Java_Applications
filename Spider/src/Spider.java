import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to collect webpages starting at one webpage and collecting 100 
 * @author Elisha
 *
 */
public class Spider {
public static Map<String, Boolean> websites = new HashMap<String, Boolean>();
public static int i = 0;

	/**
	 * Access the next website link from the map and return it 
	 * @return string url 
	 */
	public static String nextWebsite(){
		for (Map.Entry<String, Boolean> e: websites.entrySet())
		{
			//set the entry to the map 
			if(e.getValue() == false){
				e.setValue(true);
				return e.getKey();
			}
		}
		return null;
	}

	
	
/**
 * Main 
 * @param args
 */
public static void main(String[] args){
	websites.put("http://www.whitworthoutdoors.com/", false);
	String website = nextWebsite();
	//while there are still websites to grab and the count is less than 100 keep outputting new links.
	while(website != null && i < 100){
		try{
			URL url = new URL(website);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			//read the line while not null if it matched the pattern store it and then output
			while((line = reader.readLine()) != null){
				Pattern pattern = Pattern.compile("<a\\s*?href=\"(http:.*?)\"");
				Matcher matcher = pattern.matcher(line);
				if(matcher.find()){
					websites.put(matcher.group(1), false);
					System.out.printf("url: %s\n", matcher.group(1));
				}
			}
		}
		catch(Exception e){
			System.out.printf("Error! %s", e.getMessage());
		}
		//go to a new website link 
		website = nextWebsite(); 
    	i++; 
	}
}
	
}
