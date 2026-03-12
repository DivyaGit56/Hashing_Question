import java.util.*;
public class Twosum {
    public static int[] twoSum(int[]nums, int target){
        HashMap<Integer, Integer>mp = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i<n;i++){
            int complement= target-nums[i];

            if(mp.containsKey(complement)){
                return new int[]{mp.get(complement), i};
            }
            mp.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args){
         int[] nums = {2,4,7,8,11};         int target = 9;

        int[] result = twoSum(nums, target);

         System.out.println(result[0] + " " + result[1]);
     }
 }
