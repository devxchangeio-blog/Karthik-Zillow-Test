package me.karthik.string2long;

import java.text.ParseException;

/**
 * TrinaryTree class
 * 
 * stringToLong(string)
 * 
 * Throws ParseException
 * 
 * @author karthy
 *
 */
public class StringUtil {
	
	public static void main(String args[]) throws ParseException{
		
		System.out.println(stringToLong("1234A567"));
	}
	
	
	/**
	 * 
	 * @param character
	 * @param position
	 * @return
	 * @throws ParseException
	 */
   private static int charToInt(Character character ,int position ) throws ParseException
   {

	   Character zeroChar = '0';
	   Character nineChar = '9';
	   
       if(character.hashCode() >= zeroChar.hashCode() && character <= nineChar.hashCode())
       return (character.hashCode() - zeroChar.hashCode());

       throw new ParseException("Illegal Character ' "+ character + " ' at position => "+position , position);

   }
	
	
	
   /**
    * 
    * @param str
    * @return
    * @throws ParseException
    */
   public static long stringToLong(String str) throws ParseException{

       boolean negative = false;

       if(str.length() > 0 && str.charAt(0) == '-')
       {
           negative = true;
           str = str.substring(1);
       }

       long longOutPut=0;
       int position=0;

       for(Character c : str.toCharArray())
       {
    	   longOutPut *= 10;
           int digit  = charToInt(c , position++);

           if(negative)
        	   longOutPut -= digit;
           else
        	   longOutPut += digit;

       }

       return longOutPut;

   }

}
