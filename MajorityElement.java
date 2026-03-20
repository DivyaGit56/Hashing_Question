import java.util.*;
public class majorityElement {
    //B.F

    //Time complexity O(n^2) where n is the length of the input array
    //Space complexity O(1) for the count variable and the index variable

    public static int majorityElement(int [] nums){
        int count = 0;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i<nums.length; i++){
            count = 0;
            for(int j = 0; j<nums.length; j++){
                if(nums[i] == nums[j])count++;
            }
            if(count > max){
                max = count;
                index = i;
            }
        }
        return index != -1 ? nums[index] : -1;
    }

    //HashMap

    //Time complexity O(n) where n is the length of the input array
    //Space complexity O(n) for the hashmap

    public static int majorityElement(int [] nums){
        int n = nums.length;
        HashMap<Integer,Integer>mp = new HashMap<>();
       
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);

            if(mp.get(num)>n/2){
                return num;
            }
        }
        return -1;
    }

    // Sorting Approach

    public static int majorityElement(int [] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];  // the majority element will always be at the middle index after sorting
    }

 // Boyer-Moore Voting Algorithm
    //Time complexity O(n) where n is the length of the input array
    //Space complexity O(1) for the count variable and the candidate variable

    public static int majorityElement(int [] nums){
        int count = 0;
        int candidate = 0;

        for(int num : nums){
            if(count == 0){
                candidate = num;
            }

            if(num == candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
            


    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    
}
