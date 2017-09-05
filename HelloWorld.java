package javalearning;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
	public static void main(String[] args)
	{
		{
			Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
			System.out.println(f1 == f2);
			System.out.println(f3 == f4);			
		}
		
		{
	        String s1 = "Programming";
	        String s2 = new String("Programming");
	        String s3 = "Program";
	        String s4 = "ming";
	        String s5 = "Program" + "ming";
	        String s6 = s3 + s4;
	        System.out.println(s1 == s2);
	        System.out.println(s1 == s5);
	        System.out.println(s1 == s6);
	        System.out.println(s1 == s6.intern());
	        System.out.println(s2 == s2.intern());
		}
        
        {
        	StringBuffer s= new StringBuffer("good");
            StringBuffer s2=s;
    		s2.append(" afternoon.");
    		System.out.println(s);
    		test(s2);
    		System.out.println(s);	
        }
        
        /*
        List<String> list = new ArrayList<String>();  
        int i=0;  
        while(true){  
            list.add(String.valueOf(i++).intern());  
        } 
        */
	}
	
	public static void test(StringBuffer s)
	{
		s.append(" OK.");
	}
}
