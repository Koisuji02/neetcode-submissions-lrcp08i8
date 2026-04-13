class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 1. Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num: nums){
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }

        // 2. Keep top k elements with a min-heap by frequency
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer,Integer> entry: freq.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // 3. Extract results
        int[] res = new int[k];
        int i = k-1;
        while (!pq.isEmpty()){
            res[i--] = pq.poll().getKey();
        }

        return res;
    }
}
