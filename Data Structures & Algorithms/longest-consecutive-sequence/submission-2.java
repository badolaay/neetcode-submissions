class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 1)
            return 0;

        Set<Integer> numSet =
            Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));

        int maxSequence = 1;
        // for num in numSet
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int localMaxSequence = 1;
                while (numSet.contains(num + 1)) {
                    localMaxSequence++;
                    num++;
                }
                if (localMaxSequence > maxSequence) {
                    maxSequence = localMaxSequence;
                }
            }
        }
        return maxSequence;
    }
}
