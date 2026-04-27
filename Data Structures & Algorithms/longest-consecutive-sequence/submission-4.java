class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;

        Set<Integer> numSet = new HashSet();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxSequence = 1;
        // for num in numSet
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int localMaxSequence = 1;
                int localNum = num;
                while (numSet.contains(localNum + 1)) {
                    localMaxSequence++;
                    localNum++;
                }
                if (localMaxSequence > maxSequence) {
                    maxSequence = localMaxSequence;
                }
            }
        }
        return maxSequence;
    }
}
