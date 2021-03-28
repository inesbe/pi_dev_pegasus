package projet;



public class Mathematics{
	static double x;
	static double y;
	static double res;
	
	public static String calculation(String s)
	{
		String s1=new String();
		
		   if(s.contains("+")){
			   
			   String []parts=s.split("\\+");
				
				x=Double.parseDouble(parts[0]);
				y=Double.parseDouble(parts[1]);
				
				
				res=x+y;;
				
				s1=""+res;
				
	        }
		   
		  else if(s.contains("-")){
				String[] parts = s.split("\\-");
				
				x=Double.parseDouble(parts[0]);
				y=Double.parseDouble(parts[1]);
				
				
				res=x-y;;
				
				s1=""+res;
				
	        }
		   
		   else if(s.contains("*")){
				String[] parts = s.split("\\*");
				
				x=Double.parseDouble(parts[0]);
				y=Double.parseDouble(parts[1]);
				
				
				res=x*y;;
				
				s1=""+res;
				
	        }
		   
		   else if(s.contains("/")){
				String[] parts = s.split("\\/");
				
				x=Double.parseDouble(parts[0]);
				y=Double.parseDouble(parts[1]);
				
				
				res=x/y;;
				
				s1=""+res;
				
	        }
		   
		   else if(s.contains("^")){
			   String[] parts = s.split("\\^");
				
				Double a=(double) Integer.parseInt(parts[0]);
				Double b=(double) Integer.parseInt(parts[1]);
				
				
				Double pow=Math.pow(a,b);
				
					s1=""+pow;
					
	        }
		   
		   else if(s.contains("root")){
			   String[] parts = s.split(" ");
				
				Double a=(double) Integer.parseInt(parts[1]);
				
				
				Double root=Math.sqrt(a);
				
					s1=""+root;
					
	        }
		   
		   return s1;
	}
}
