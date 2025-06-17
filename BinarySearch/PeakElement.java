//https://leetcode.com/problems/find-peak-element/
public class PeakElement {
    static int peak(int []nums){
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(nums[mid]>nums[mid+1]){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return end;
    }
    public static void main(String[] args) {
        int [] nums = {1,2,3,1}; //op=>2
        System.out.println(peak(nums));
    }
}
