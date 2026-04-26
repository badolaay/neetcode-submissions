class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> intToFrequency = new HashMap();
        // map number with its frequency
        for (int i = 0; i < nums.length; i++) {
            intToFrequency.put(nums[i], intToFrequency.getOrDefault(nums[i], 0) + 1);
        }
        // map frequency with the list of numbers having same frequency
        Map<Integer, Set<Integer>> freqToIntList = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            freqToIntList.computeIfAbsent(intToFrequency.get(nums[i]), (key) -> new HashSet())
                .add(nums[i]);
        }

        int[] out = new int[k];
        int outIdx = 0;
        // frequency can't be greater than length of nums array
        for (int i = nums.length; i > 0 && outIdx < k; i--) {
            if (freqToIntList.get(i) != null) {
                for (Integer outNum : freqToIntList.get(i)) {
                    out[outIdx] = outNum;
                    outIdx++;
                }
            }
        }
        return out;
    }
}
