//https://www.geeksforgeeks.org/problems/value-equal-to-index-value1330/1

import java.util.ArrayList;
import java.util.List;

public class ValueEqualToIndex {
    static ArrayList<Integer> helper(int []arr){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i =0 ;i<arr.length;i++){
            if(arr[i]==i+1){
                result.add(i+1);
            }
        }
        return result;

    }
    static ArrayList<Integer> helperOptim(int []arr){
        ArrayList<Integer> ans = new ArrayList<>();
        binary(arr, 0, arr.length-1, ans);
        return ans;
    }
    static void binary(int []arr,int low,int high,ArrayList<Integer> result){
            if(low>high){
                return;
            }
            
                int mid = low+(high-low)/2;
                if(arr[mid]==mid+1){
                    result.add(mid+1);
                    binary(arr, 0, mid-1, result);
                    binary(arr, mid+1, high, result);
                }
                else if(arr[mid]>mid+1){
                     binary(arr, low, mid-1, result);
                }
                else{
                    binary(arr, mid+1,high, result);
                }

            }
    
    public static void main(String[] args) {
        int arr[] = {15, 2, 45, 4 , 7};   //Output: [2, 4]
        ArrayList<Integer> ans = new ArrayList<>();
        ans = helper(arr);
        System.out.println(ans);
        ArrayList<Integer> sol = new ArrayList<>();
        sol = helperOptim(arr);
        System.out.println(sol);
    }
}
