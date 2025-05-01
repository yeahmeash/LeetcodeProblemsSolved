class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, candidate = -1;

    // Finding majority candidate
    for (int index = 0; index < nums.length; index++) {
      if (count == 0) {
        candidate = nums[index];
        count = 1;
      }
      else {
        if (nums[index] == candidate)
          count++;
        else
          count--;
      }
    }

    // Checking if majority candidate occurs more than
    // n/2 times
    count = 0;
    for (int index = 0; index < nums.length; index++) {
      if (nums[index] == candidate)
        count++;
    }
    if (count > (nums.length / 2))
      return candidate;
    return -1;

    // The last for loop and the if statement step can
    // be skip if a majority element is confirmed to
    // be present in an array just return candidate
    // in that case
  }
}  