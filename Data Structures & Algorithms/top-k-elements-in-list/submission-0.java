class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> intToFrequency = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            intToFrequency.put(nums[i], intToFrequency.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue(
            k, (a, b) -> { return Integer.compare(intToFrequency.get(b), intToFrequency.get(a)); });

        maxHeap.addAll(intToFrequency.keySet());

        int[] out = new int[k];
        for (int i = 0; i < k; i++) {
            out[i] = maxHeap.poll();
        }
        return out;
    }
}
