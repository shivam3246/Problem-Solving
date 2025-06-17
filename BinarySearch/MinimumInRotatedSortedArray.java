public class MinimumInRotatedSortedArray {
    static int mini(int []nums){
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while(l<r){
            int m = l+(r-l)/2;
            if(nums[m]>nums[r]){
                l = m+1;
            }
            else{
                r = m;
            }
        }
        return nums[l];
    }
    
    public static void main(String[] args) {
        int [] nums = {3,4,5,1,2}; //OP=1
        System.out.println(mini(nums));

    }
}
