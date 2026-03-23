import java.util.*;
public class TopKFreqElement {
  
    //Brute force
    //Time complexity O(n^2) where n is the number of elements in the array
    //Space complexity O(n) for the hashmap and the result list

    public static int [] TopKElement(int [] arr,int k){
        int n = arr.length;
    
        HashMap<Integer, Integer>mp = new HashMap<>();

        for(int num: arr){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
    List<Integer>res = new ArrayList<>(mp.keySet()); //example: [1,3,6,2,4]
    Collections.sort(res,(a,b)->mp.get(b)-mp.get(a));  //example: 1->3, 3->2, 6->1, 2->2, 4->1,then the sorted order will be [6,4,2,3,1]

    int []result = new int[k];
    for(int i = 0; i<k; i++){
     result[i] = res.get(i);
    }

    return result;
        
    }

    //HashMap + MaxHeap
    //Time complexity O(nlogn) where n is the number of elements in the array
    //Space complexity O(n) for the hashmap and the result list

     public static int [] TopKElement(int [] arr,int k){
          int n = arr.length;
        HashMap<Integer, Integer>mp = new HashMap<>();

        for(int num:arr){
            mp.put(num,mp.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->mp.get(b)-mp.get(a));

        pq.addAll(mp.keySet());

        int []res = new int[k];
        for(int i = 0; i<k; i++){
            res[i] = pq.poll();
        }
          return res;
    }

    //hashMap + minHeap
    //Time complexity O(nlogk) where n is the number of elements in the array and k is the number of top frequent elements
    //Space complexity O(n) for the hashmap and O(k) for the minHeap and the result list
  
     public static int [] TopKElement(int [] arr,int k){
          int n = arr.length;
        HashMap<Integer, Integer>mp = new HashMap<>();

        for(int num:arr){
            mp.put(num,mp.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->mp.get(a)-mp.get(b));

        for(int key: mp.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int []res = new int[k];
        for(int i = k-1; i>=0; i--){
            res[i] = pq.poll();
        }
          return res;
    }
    
    //BucketSort(Most Optimal)

    //T.C = O(n) where n is the number of elements in the array
    //S.C = O(n) for the hashmap and the bucket array and the result list
   


public static int[] TopKElement(int[] arr, int k) {

    HashMap<Integer,Integer> map = new HashMap<>();

    for(int num : arr){
        map.put(num, map.getOrDefault(num,0)+1);
    }

    List<Integer>[] bucket = new List[arr.length+1];

    for(int key : map.keySet()){

        int freq = map.get(key);

        if(bucket[freq]==null){
            bucket[freq] = new ArrayList<>();
        }

        bucket[freq].add(key);
    }

    int[] res = new int[k];
    int index = 0;

    for(int i=bucket.length-1;i>=0 && index<k;i--){

        if(bucket[i]!=null){

            for(int num : bucket[i]){

                res[index++] = num;

                if(index==k) break;
            }
        }
    }

    return res;
}

    public static void main(String[] args) {
        int [] arr = {1,3,6,1,3,2,1,4,2};
        System.out.println(Arrays.toString(TopKElement(arr,2)));
    }
}
