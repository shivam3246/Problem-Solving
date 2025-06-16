//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

import java.util.Arrays;

public class FirstAndLastPos {
    static int firstPos(int []arr,int target){
        int first = -1;
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid =  low+(high-low)/2;
            if(arr[mid]==target){
                first = mid;
                high= mid-1;
                
                
            }
            else if(arr[low]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return first;
    }
    static int secondOcc(int []arr,int target){
        int low = 0;
        int second = -1;
        int high = arr.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid]==target){
                second = mid;
                low = mid+1;
            }
            else if(arr[mid]>target){
                high = mid-1; 
            }
            else{
                low = mid+1;
            }
        }
        return second;
    }
    public static void main(String[] args) {
        int []arr= {5,7,7,8,8,10};
        int target = 8; //OP=> [3,4]
        int []ans = new int[2];
        ans[0] = firstPos(arr, target);
        ans[1] = secondOcc(arr, target);
        System.out.println(Arrays.toString(ans));
    }
    
}
