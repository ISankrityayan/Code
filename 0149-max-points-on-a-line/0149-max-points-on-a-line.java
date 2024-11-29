import java.util.HashMap;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) {
            return 1;
        }
        
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                
                double dy = points[j][1] - points[i][1];
                double dx = points[j][0] - points[i][0];
                
                double theta = Math.atan2(dy, dx);  // Calculate the angle
                map.put(theta, map.getOrDefault(theta, 0) + 1);
            }
            
            // Iterate through the map to find the maximum points on a line
            for (int count : map.values()) {
                res = Math.max(res, count + 1);  // Adding 1 to count the base point
            }
        }
        
        return res;
    }
}
