
public class Triangle extends interfaceShape {
	String side1;
	String side2;
	String side3;
	String ID;
	String color;
	String kind;
	
	public Triangle(String line){
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
						setSide1(split[i]);
					}
					else if( i== 3){
						setSide2(split[i]);
					}
					else if( i == 4){
						setSide3(split[i]);
					}
					else if(i ==5){
						setColor(split[i]);
					}
				}
		}
		
		public void setSide1(String side1){
			this.side1 = side1;
		}
		public void setSide2(String side2){
			this.side2 = side2;
		}
		public void setSide3(String side3){
			this.side3 = side3;
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


