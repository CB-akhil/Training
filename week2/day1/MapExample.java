import java.util.*;  
class MapExample{
	public static void main(String[] args) {
		String[] array = {"length","of","the","word","list","of","with","that"};
		Map<Integer,List<String>> table= new HashMap<>();
		for(String temp:array){
			if(table.containsKey(temp.length())){
				List<String> l = table.get(temp.length());
				l.add(temp);
				table.put(temp.length(),l);
			}else{
				List<String> l = new ArrayList<>();
				l.add(temp);
				table.put(temp.length(),l);
			}
		}
		for (Map.Entry<Integer,List<String>> entry : table.entrySet()) {
		    System.out.print("Key = " + entry.getKey() + ", Value = " );
		    List<String> l =entry.getValue();
		    for(String a:l)
		    	System.out.print(a + " ");
		    System.out.println();
		}
	}
}