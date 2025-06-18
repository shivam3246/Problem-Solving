import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsequence {
     static int maxLength(String s) {
        List<Character> seen = new ArrayList<>();
        int count = 0;

        for (char ch : s.toCharArray()) {
            // Binary search to find number of characters less than current
            int idx = lowerBound(seen, ch);

            if (idx > 0) {
                count++;
            }

            // Insert character at right position to keep list sorted
            seen.add(idx, ch);
        }

        return count;
    }

    // Lower bound: first index where element >= target
    static int lowerBound(List<Character> list, char target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        String s = "abcdapzfqh";
        System.out.println(maxLength(s)); // Output: 6
    }
}
