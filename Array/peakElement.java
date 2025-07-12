public class peakElement {
public static int peakindex(int[] arr){
    int start=0;
    int end=arr.length-1;
    while(start<end){
        int mid = start+(end-start)/2;
        if(start<mid && arr[mid]>arr[mid+1]){
            return mid;
        }
        else if(mid<end && arr[mid-1]>arr[mid]){
            return  mid-1;
        }
        if(arr[mid]<=arr[start]){
            end=mid-1;
        }
        else{
            start=mid+1;
        }
    }
    return end+1;

}
public static void main(String[] args) {
    int[] arr={5,6,7,8,9,1,2,3};
    System.out.println(peakindex(arr));
}
public int singleNonDuplicate(int[] nums) {
    if(nums.length==1) return nums[0]; 
    if(nums[0]!=nums[1]) return nums[0];
    if(nums[nums.length-1]!=nums[nums.length-2]) return nums[nums.length-1];
     
    int start=1;
      int end=nums.length-2;
      while(start<end){
        int mid=start+(end-start)/2;
        if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]) return nums[mid];
        if((mid%2 == 1 && nums[mid]==nums[mid-1])|| (mid%2==0 &&nums[mid]==nums[mid+1])){
            start=mid+1;
        }
        else{
            end=mid-1;
        }
      }  
      return -1;
}
}