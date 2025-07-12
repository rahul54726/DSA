package com.CollectionFrameWorks.Heap;
import java.util.*;
public class PriorityQueues {
//    public static void main(String[] args) {
//        PriorityQueue<Integer> queue=new PriorityQueue<>();
//        queue.add(2);
//        queue.add(1);
//        queue.add(3);
//        queue.add(5);
//        queue.add(4);
//        int[] arr={3,2,3,1,2,4,5,5,6};
//        heapSort(arr);
//        System.out.println(findKthLargest(arr,4));
//    }
    private static void heapSort(int[] arr){
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int num:arr){
            queue.add(num);
        }
        int i=0;
        while (!queue.isEmpty()){
            arr[i++]=(queue.remove());
        }
        System.out.println(Arrays.toString(arr));
    }
    public static int findKthLargest(int[] nums, int k) {
        heapSort(nums);
        int length=nums.length;
        return nums[length-k];
    }
    public static int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Integer> maxHeap =new PriorityQueue<>((a, b) -> b -a);
        for(int freq : map.values()){
            maxHeap.add(freq);
        }
        System.out.println(maxHeap);
        int time = 0;
        Queue<int[]> cooldownqueue = new LinkedList<>();
        while (!maxHeap.isEmpty() || !cooldownqueue.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
            int currentFreq=maxHeap.poll()-1;
            if (currentFreq > 0){
                cooldownqueue.add(new int[]{currentFreq,time+n});
            }
            }
            if (!cooldownqueue.isEmpty() && cooldownqueue.peek()[1] <= time){
                maxHeap.add(cooldownqueue.poll()[0]);
            }
        }

        return time;
    }

    public static void main(String[] args) {
//        char[] tasks=new char[]{'A','A','A','B','C','B'};
//        leastInterval(tasks,2);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        queue.add(8);
        queue.add(1);
        System.out.println(queue);

    }
}
