class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
         //---- Brute force----

        int n = nums.length;
        
        for(int i = 0; i<n; i++){
            int sum = 0;  // it reset for every subarray
            for(int j = i; j<n; j++){
                sum += nums[j];

            if (j - i + 1 >= 2) {
                if(k==0){
                    if(sum == 0)return true;

                }else{
                    if(sum%k == 0)return true;
                }
            }
            }
            
        }
        return false;

        //-------- prefix sum-------

        int n = nums.length;
        int [] prefix = new int[n+1];

        for(int i = 0; i<n; i++){
            prefix[i+1] = prefix[i] +nums[i];
        }

        for(int i = 0; i<n; i++){
            for(int j = i+2; j<=n; j++){
                int sum = prefix[j]-prefix[i];

                if(k == 0){
                    if(sum == 0) return true;;
                }else{
                    if(sum%k == 0)return true;
                }
            }
        }
        return false;

        //------HashMap+Prefix------

        HashMap<Integer,Integer>mp = new HashMap<>();
        int n= nums.length;
        mp.put(0,-1);
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += nums[i];

            int rem;

            if(k!=0){
                rem = sum%k;

                if(rem<0)
                    rem += k;
                    }else{
                    // when k = 0
                    rem = sum;
                     }
                    
            if(mp.containsKey(rem)){
                if((i-mp.get(rem))>1)return true;
            }else{
                mp.put(rem,i);
            }

            }
             return false;
        
        
    }
}
