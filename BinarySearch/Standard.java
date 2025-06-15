public class Standard {
    
    public static int binarys(int []arr,int left,int right,int key){
        while(left<right){
            int mid = left+(right-left)/2;
            if(arr[mid]==key){
               return mid;
            }
            else if(arr[mid]<arr[right]){
                 left = mid+1;
            }
            else{
                right = mid-1;
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6};
        int key = 3;
        System.out.println(binarys(arr, 0, arr.length-1, key));
    }
}
