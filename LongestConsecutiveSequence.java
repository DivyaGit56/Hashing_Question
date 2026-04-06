class Solution {
  
     //------ brute force-------//

    static boolean contain(int [] nums,int target){
        for(int x:nums){
            if(x == target)return true;
        }
        return false;
    }
    public int longestConsecutive(int[] nums) {
        
        int longest = 0;
        for(int num: nums){
            int curr = num;
            int cnt = 1;

            while(contain(nums,curr+1)){
                curr++;
                cnt++;

            }
            longest = Math.max(longest,cnt);
        }
        return longest;

  //-----Sorting-----//

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;

        Arrays.sort(nums);

        int longest = 1;
        int cnt = 1;
        for(int i= 1; i<nums.length; i++){
            if(nums[i] == nums[i-1]+1){
                cnt++;
            }else if(nums[i] != nums[i-1]){
                cnt = 1;
            }
            longest = Math.max(longest,cnt);
        }
       return longest; 


    //-----HashSet----//

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            // check if it's the start of sequence
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
