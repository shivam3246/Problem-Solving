//https://www.geeksforgeeks.org/problems/ceil-in-a-sorted-array/1
public class CeilArray {
    static int ceil(int []arr,int x){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==x){
                return mid;
            }
            else if(arr[mid]<x){
                   low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 3;//op==2
        System.out.println(ceil(arr, x));
        


    }
}
