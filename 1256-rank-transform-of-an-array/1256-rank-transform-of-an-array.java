import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Create a copy of the original array
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        
        // Sort the copied array
        Arrays.sort(copyArr);
        
        // Create a map to store the rank of each number
        Map<Integer, Integer> map = new HashMap<>();
        
        // Assign ranks to each number in the sorted array
        for (int num : copyArr) {
            if (!map.containsKey(num)) {
                map.put(num, map.size() + 1);
            }
        }
        
        // Replace elements in the original array with their ranks
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        
        return arr;
    }
}
