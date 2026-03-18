import java.util.*;
public class GroupAnagram {
    //Brute force
  
    //Time complexity O(n^2 * klogk) where n is the number of strings and k is the length of the longest string
    //Space complexity O(n) for the visited array and the result list
    public static boolean validAnagram(String s1, String s2 ){

        if(s1.length() != s2.length())return false;

        char[]a = s1.toCharArray();
        char[]b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);

    }
    public static List<List<String>> groupAnagrams(String[] strs){
        boolean[]visited = new boolean[strs.length];
        List<List<String>>res = new ArrayList<>();
        for(int i = 0; i<strs.length; i++){
            if(visited[i])continue;

            List<String>group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            for(int j =i+1; j<strs.length; j++){

                if(!visited[j]&&validAnagram(strs[i],strs[j])){
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }
        
        res.add(group);
        }
        return res;
    }

    //Better one
  
    //Time complexity O(n * klogk) where n is the number of strings and k is the length of the longest string
    //Space complexity O(n) for the hashmap and the result list

     public static List<List<String>> groupAnagrams(String[] strs){
        HashMap<String,List<String>>mp = new HashMap<>();

        for(String s: strs){
            char[]a = s.toCharArray();
            Arrays.sort(a);
            String key = new String(a);
            mp.putIfAbsent(key,new ArrayList<>());
            mp.get(key).add(s);
        }
        return new ArrayList<>(mp.values());
    }
 
    //Best one
  
    //Time complexity O(n * k) where n is the number of strings and k is the length of the longest string
    //Space complexity O(n) for the hashmap and the result list
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){

            int[] count = new int[26];

            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        String[] strs = {"tea","eat","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));


    }
}
