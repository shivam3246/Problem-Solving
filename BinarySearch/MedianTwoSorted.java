//https://www.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-same-size/1
import java.util.Arrays;

public class MedianTwoSorted {
    static double helper(int []a,int []b){
        int n = a.length+b.length;
        int []helper = new int[n];
        for(int i = 0;i<a.length;i++){
            helper[i] = a[i];
        }
        for(int i = 0;i<b.length;i++){
            helper[a.length+i] = b[i];
        }
        Arrays.sort(helper);
        return (double)(helper[n/2-1]+helper[n/2])/2.0;
    }
    static double helperOpt(int []a,int []b){
        int n = a.length;
        int low = 0;
        int high = n;
        while(low<=high){
            int i = low+(high-low)/2;
            int j = n-i;
            int aLeft = (i==0)?Integer.MIN_VALUE:a[i-1];
            int aRight = (i==n)?Integer.MAX_VALUE:a[i];
            int bLeft = (j==0)?Integer.MIN_VALUE:b[j-1];
            int bRight =(j==n)?Integer.MAX_VALUE:b[j];
            if(aLeft<=bRight&&bLeft<=aRight){
                return (Math.max(aLeft,bLeft)+Math.min(aRight,bRight))/2.0;
            }
            else if(aLeft>bRight){
                high = i-1;
            }
            else{
                low = i+1;
            }

        
        }
        return -1;
    }
    public static void main(String[] args) {
        int []a = {-5, 3, 6, 12, 15};
        int []b = {-12, -10, -6, -3, 4};  //OP = 0
        System.out.println(helper(a, b));
        System.out.println(helperOpt(a, b));

    }
}
