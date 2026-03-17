import java.util.*;
public class ValidAnagram {
    //Using BruteForce

    //Time Complexity: O(n log n) where n is the length of the input strings
    //Space Complexity: O(1) if we ignore the space used by the sorting algorithm, otherwise O(n) due to the space used by the sorting algorithm.
    
    public static boolean validAnagram( String str1,String str2){
        if(str1.length() != str2.length())return false;
        char[]a= str1.toCharArray();
        char[]b= str1.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);
        return(Arrays.equals(a,b));
            

    }
    
        //Using HashMap

    //Time Complexity: O(n + m) where n and m are the lengths of the two input strings.
    //Space Complexity: O(k) where k is the number of unique characters in the first

    public static boolean validAnagram( String str1,String str2){
        HashMap<Character,Integer>mp = new HashMap<>();

        for(char ch: str1.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        for(char ch:str2.toCharArray()){
            if(!mp.containsKey(ch))return false;
            mp.put(ch,mp.get(ch)-1);
        }
        for(int val : mp.values()){
            if(val != 0) return false;
        }

      return true;
    }

    // ArrayFrequency(Best Approach)
  
    //Time Complexity: O(n) where n is the length of the input strings.
    //Space Complexity: O(1) since the count array has a fixed size of

    public static boolean validAnagram( String str1,String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if(str1.length() != str2.length())return false;
        
        int[]count = new int[26];

        for(int i = 0; i<str1.length(); i++){
            count[str1.charAt(i)-'a']++;
            count[str2.charAt(i)-'a']--;

        }
        for(int num:count){
            if(num!=0)return false;
        }
        return true;
    }
    

    public static void main(String[] args) {
        String str1 = "Divya";
        String str2 = "avyDi";

        System.out.println(validAnagram(str1,str2));
    }
}
