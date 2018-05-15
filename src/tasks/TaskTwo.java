package tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TaskTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		//hashmap with sorted word against all its anagrams
		 Map<String, List<String>> m = 
                 new HashMap<String, List<String>>();
		
		
		Scanner sc2 = null;
	    try {
	        sc2 = new Scanner(new File("/Users/user/Downloads/superawesome-codetest-fullstack/task2/data/example.txt"));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();  
	    }
	
	    while (sc2.hasNextLine()) {
	            Scanner s2 = new Scanner(sc2.nextLine());
	            
	        while (s2.hasNext()) {
            
	        	
	        	String word = s2.next();
	        	//sorting word and filling up list 
                String sortedword = sorting(word);
                List<String> l = m.get(sortedword);
                if (l == null)
                    m.put(sortedword, l=new ArrayList<String>());
                if(!l.contains(word)) {
                l.add(word);
                }
	        }
	                     
	        
	    }
	    
	    //printing anagrams from hashmap together
	    for (Map.Entry<String, List<String>> entry : m.entrySet()) {
	        System.out.println(entry.getValue());
	    }

	}

	 private static String sorting(String s) {
	        char[] a = s.toCharArray();
	        Arrays.sort(a);
	        return new String(a);
	    }

}
