/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

/**
 *
 * @author shado
 */
public class Translate {

		public static String translate(String s)
	{
                String s1=new String();
		   if(s.contains("translate")){
			
                       return "Choose the language you want to translate to ";
			
                       
				
	        }else if(( s.contains("arab") ||s.contains("arabic") || s.contains("fr") )&& Intelligence_artificielController.change_language==0 )
                { 
                      Intelligence_artificielController.transalte_status=1;
                   return "what do you want to translate";
                }
                else if(s.contains("change language"))
                {
                    Intelligence_artificielController.change_language=1;
                    
                return  "please choose a language";
                    
                }
                
                
                   
                 
          return s1;      
                   
        }
}
