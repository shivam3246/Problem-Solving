//https://www.geeksforgeeks.org/problems/length-unsorted-subarray3022/1

import java.util.Arrays;

public class SortUnsortedSub {
    //Sorting approach using two pointers
    static int[] helperS(int []arr){
        int n = arr.length;
        int p1 = 0;
        int p2 = 0;
        int []temp = Arrays.copyOf(arr,n);
        int []ans = new int[2];
        Arrays.sort(temp);
        for(int i = 0;i<n-1;i++){
            if(arr[i]!=temp[i]){
                p1=i;
                break;
            }
        }
            for(int i = n-1;i>=0;i--){
               if(arr[i]!=temp[i]){
                p2=i;
                break;
            }
            
        }
        ans[0] = p1;
        ans[1] = p2;

        return ans;

    }
    static int[] binary(int []arr){
        int n = arr.length;
        int low = 0;
        int high = arr.length-1;
        int left = 0;
        int right = n-1;
        while(left<n-1&&arr[left]<=arr[left+1]){
            left++;
        }
        if(arr[left]==n-1){
            return new int[]{-1,-1};
        }
        while(arr[right]>0&&arr[right]>=arr[right-1]){
            right--;
        }
        int min = arr[left];
        int max = arr[left];
        for(int i = left;i<=right;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        while(left>0  && arr[left-1]<min){
            left--;
        }
        while(right<n-1&&arr[right+1]<max){
            right++;
        }
        return new int[]{left,right};
    }

    public static void main(String[] args) {
       int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};  //Output: [3, 8]
       int []ans = helperS(arr);
       System.out.println(Arrays.toString(ans));
       int []result = binary(arr);
       System.out.println(Arrays.toString(result));
    }
    
}
