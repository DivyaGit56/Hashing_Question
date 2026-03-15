import java.util.*;

public class IntersectionArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,3,4};
        int[] arr2 = {2,2,4,6};

          // Brute Force Approach
      
          // Time Complexity: O(n*m) where n and m are the lengths of arr1 and arr2 respectively
          // Space Complexity: O(k) where k is the number of unique elements in the intersection


        HashSet<Integer> result = new HashSet<>();

        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(arr1[i] == arr2[j]){
                    result.add(arr1[i]);
                }
            }
        }
            // Optimized Approach using HashSet
      
            // Time Complexity: O(n + m) where n and m are the lengths of arr1 and arr2 respectively
            // Space Complexity: O(k) where k is the number of unique elements in the intersection
      
            HashSet<Integer>set = new HashSet<>();
            HashSet<Integer>result = new HashSet<>();

            for(int num:arr1){
                set.add(num);
            }

            for(int num:arr2){
                if(set.contains(num)){
                    result.add(num);
                }
            }

        System.out.println(result);
    }
}
