class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
      
        // brute force
        //T.C = O(n^2)
        //S.C = O(1)
      
        for(int i = 0; i<n; i++){
            int count = 0;
            for(int j = 0; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    count++;
                }
            }
            if(count == 1)return i;
        }
        return-1;

        //HashMap Approach
          //T.C = O(n)
          //S.C = O(n)
      
        HashMap<Character,Integer>mp = new HashMap<>();
        for(int i = 0; i<n; i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
      for(int i = 0; i<n; i++){
        if(mp.get(s.charAt(i))==1) return i;
      }
return -1;

// Array frequency
//T.C = O(n)
//S.C = O(1)

int []freq = new int[26];
for(int i = 0; i<n; i++){
    freq[s.charAt(i)-'a']++;
}
for(int i = 0; i<n; i++){
if(freq[s.charAt(i)-'a'] == 1){
    return i;
}
}
return -1;
    }
}
