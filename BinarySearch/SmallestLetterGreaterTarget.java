public class SmallestLetterGreaterTarget {

    static char nextGreatest(char[] letters,char target){
        int low = 0;
        int high = letters.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(letters[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return letters[low%letters.length];
    }
    public static void main(String[] args) {
       char[] letters = {'c','f','j'}; //c
       char target = 'a';
       System.out.println(nextGreatest(letters, target));
    }
}
