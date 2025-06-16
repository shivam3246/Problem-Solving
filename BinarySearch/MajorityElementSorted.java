//https://www.geeksforgeeks.org/dsa/check-for-majority-element-in-a-sorted-array/
public class MajorityElementSorted {
    static int binary(int []nums,int x){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==x){
                return mid;
            }
            else if(nums[mid]<x){
                low= mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    static boolean checkBinary(int []nums,int n,int x){
        int firstOcc = binary(nums, x);
        if(firstOcc+n/2<n&&nums[firstOcc+n/2]==x){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int []nums = {1, 2, 3, 4, 4, 4, 4}; 
        int x = 4; //OP true
        int n = nums.length;
        System.out.println(checkBinary(nums, n, x));

        
    }
}
