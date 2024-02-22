
import java.util.List;
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class SimpleDictionary{
  public static void main (String args[]){
        Map<Character, TreeSet<String>> myDictionary = new TreeMap<>();
		List<String> words = Arrays.asList("banana", "Summer",  "apple", "orange", "Avocado", "grape", "Sad");
		
		for (String word : words) {
            addToMap(myDictionary,word);
        }
		
		printMap(myDictionary);
		givenLetter(myDictionary,'s');		
  }
  
  public static void addToMap(Map<Character, TreeSet<String>> map,String word){
	   char firstChar = Character.toLowerCase(word.charAt(0));
       map.putIfAbsent(firstChar, new TreeSet<>());
       map.get(firstChar).add(word);	
  }
  
  
  public static void printMap(Map<Character, TreeSet<String>> map) {
	    System.out.println("Dictionary Content");
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
	
  public static void givenLetter(Map<Character, TreeSet<String>> map, Character letter ){
	    Character lowerCaseLetter = Character.toLowerCase(letter);
		System.out.println("\nThe words that start with the letter " + letter + " are ");
		if (map.containsKey(lowerCaseLetter)) {
             map.forEach((key, value) -> {
				if(key == lowerCaseLetter){
				  System.out.println(key + ": " + value);
				}
		    });
        } else {
            System.out.println("No such letter in the map");
        }		
  }
}