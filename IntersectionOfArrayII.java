import java.util.*;
public class IntersectionArrayII {
    //Brute Force Approach

    // Time Complexity: O(n*m) where n and m are the lengths of the two input arrays.
    // Space Complexity: O(k) where k is the number of common elements in the result list.

    public static List<Integer>IntArrII(int[]arr1,int[]arr2){
         List<Integer>result = new ArrayList<>();
         for(int i = 0; i<arr1.length; i++){
            for(int j = 0; j<arr2.length;j++){
                if(arr1[i] == arr2[j]){
                    result.add(arr1[i]);
                    break;
                }
            }
        }
        return result;
    }

    //Using HashMap

    //Time Complexity: O(n + m) where n and m are the lengths of the two input arrays.
    //Space Complexity: O(k) where k is the number of unique elements in the first array.

   public static List<Integer>IntArrII(int[]arr1,int[]arr2){
    HashMap<Integer,Integer>mp = new HashMap<>();
    List<Integer>result = new ArrayList<>();

    for(int num:arr1){
        mp.put(num,mp.getOrDefault(num,0)+1);

    }

    for(int num:arr2){
        if(mp.containsKey(num)&&mp.get(num)>0){
            result.add(num);
            mp.put(num,mp.get(num)-1);
        }
    }
    return result;
}
