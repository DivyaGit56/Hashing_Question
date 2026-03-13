import java.util.*;
public class SingleNumber {

    public static int SN(int[] nums){

        // //using hashMap
        // TC = O(n) and SC = O(n)
        HashMap<Integer, Integer>mp = new HashMap<>();
        for(int num : nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        for(int key: mp.keySet()){
            if(mp.get(key) == 1){
                return key;
            }
        }
        return 0;

       // using sorting
       // TC = O(nlogn) and SC = O(1)
       Arrays.sort(nums);
       for(int i = 0;i<nums.length ; i+=2){
        if(i == nums.length-1|| nums[i] != nums[i+1]){
            return nums[i];
        }
       }
         return 0;
    }
    //  
    public static void main(String[] args){
        int[] nums = {2,4,7,8,11,2,4,7,8};
        int result = SN(nums);
        System.out.println(result);
    }
}
