
public class Square extends interfaceShape {
	String side;
	String ID;
	String color;
	String kind;
	
	public Square(){
	}
	
	public Square(String line){
	//split the string contents by line 
			String split[]= line.split("\\s+");
			//loop through line to assign contents of line to specifics
			for (int i = 0; i < split.length; i++){
				//System.out.printf("%s\n", split[i]);
				if( i == 0 ){
					setKind(split[i]);
					getKind();
				}
				else if (i == 1){
					setID(split[i]);
				}
				else if(i == 2){
					setSide(split[i]);
				}
				else if(i ==3){
					setColor(split[i]);
				}
			}
	}
	
	public void setSide(String side){
		this.side = side;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public void setKind(String kind){
		super.setKind(kind);
	}
	
	public void setID(String ID){
		super.setID(ID);
	}
}
