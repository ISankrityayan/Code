class Solution {
    public boolean search(int[] nums, int target) {
        int peak = pivotElement(nums);

        int firstTry = binarySearch(nums, target, 0, peak);
        if (firstTry != -1) {
            return true;
        }
        return binarySearch(nums, target, peak + 1, nums.length - 1) != -1;
    }

    int pivotElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        // Handle edge case for single element array
        if (nums.length == 1) {
            return 0;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            // if elements at mid, start, and end are equal, skip duplicates
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                // check if start is pivot
                if (start < end && nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;

                // check if end is pivot
                if (end > start && nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
