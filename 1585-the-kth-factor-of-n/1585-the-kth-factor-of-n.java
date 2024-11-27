class Solution {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>(); // To store larger factors
        
        // Step 1: Loop through numbers from 1 to √n
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) { // Check if i is a factor
                k--; // Decrease k when a factor is found
                if (k == 0) return i; // If k becomes 0, return the factor
                
                if (n / i != i) { // Add larger factor if it's not the same as i
                    list.add(n / i);
                }
            }
        }

        // Step 2: Check larger factors in reverse order
        for (int i = list.size() - 1; i >= 0; i--) {
            k--; // Decrease k when a factor is found
            if (k == 0) return list.get(i); // If k becomes 0, return the factor
        }

        // Step 3: If k is still greater than 0, return -1
        return -1;
    }
}
