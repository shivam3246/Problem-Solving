// https://www.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1
public class SearchInSortedandRotated {
   static int searchInRange(int []nums,int target,int start,int end){
        int find = findPivot(nums);
        if(find==-1){
            return bina(nums,target,0,nums.length-1);
        }
        if(nums[find]==target){
            return find;
        }
        if(target>=nums[0])
        return bina(nums,target,0,find-1);
        return bina(nums,target,find+1,nums.length-1);
    }
    static int findPivot(int []nums){
        int start =0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(mid<end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(start<mid && nums[mid]<nums[mid-1]){
            return mid-1;
            }
            if(nums[mid]<=nums[start]){
                end = mid -1;
            }
            else{
                start = mid+1;
            }

        }
        return -1;
    }
    static int bina(int []nums,int target,int start,int end){
        while(start<=end){
            int mid = start +(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
      int  arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
      int key = 3; //8
      System.out.println(searchInRange(arr, key, 0, arr.length-1));
    }
}
