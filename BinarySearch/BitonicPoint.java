public class BitonicPoint {
    static int helper(int []arr){
        for(int i = arr.length-1;i>0;i--){
            if(arr[i]<arr[i-1]){
                return arr[i-1];
            }
        }
        return arr[arr.length-1];
    } 
    static int helperOptm(int[] arr, int low, int high) {
        int n = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
    
            // Edge cases: check bounds for mid - 1 and mid + 1
            if ((mid == 0 || arr[mid] > arr[mid - 1]) &&
                (mid == n - 1 || arr[mid] > arr[mid + 1])) {
                return arr[mid]; // Peak element
            } else if (mid < n - 1 && arr[mid] < arr[mid + 1]) {
                low = mid + 1;  // Move right
            } else {
                high = mid - 1; // Move left
            }
        }
        return -1; // Should not reach here if input is a valid bitonic array
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 7, 8, 3};  //op = 8 if sorted last element
        int arr2[] = {10, 20, 30, 40, 50};
        System.out.println(helper(arr2));
        System.out.println(helperOptm(arr, 0, arr.length-1));

    }
}
