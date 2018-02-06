/*
Given an array of words, create a map with the common prefix(first 3 characters) as key 
and value as the list of words that starts with that prefix. While printing, 
the prefix & words starting with that prefix should be listed in the alphabetical order of the prefix
*/
import java.util.*;
class Exercise{
	public static void main(String[] args) {
		//HashMap<String,TreeSet<String>> map=new HashMap<String,TreeSet<String>>();
		TreeMap<String,TreeSet<String>> map=new TreeMap<String,TreeSet<String>>();
		String[] wordlist={"cdel","cdejk","abcf","abcde","abcabc","cdefgh","doing"};
		System.out.println("Wordlist:\n"+Arrays.toString(wordlist));
		for (String s : wordlist) {
			String key=s.substring(0,3);
			if(map.get(key)!=null){
				map.get(key).add(s);
			}
			else{
				TreeSet<String> temp=new TreeSet<String>();
				temp.add(s);
				map.put(key,temp);
			}
		}
		System.out.println("Map:\n"+map);
	}
}