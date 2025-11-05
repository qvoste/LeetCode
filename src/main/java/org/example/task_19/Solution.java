package org.example.task_19;

import java.util.*;

//2 часа с индусами дали плоды
class Solution {
    private static final class FreqValue {
        final int frequency;
        final int value;
        FreqValue(int freq, int val) { this.frequency = freq; this.value = val; }
        @Override public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof FreqValue)) return false;
            FreqValue other = (FreqValue) obj;
            return frequency == other.frequency && value == other.value;
        }
        @Override public int hashCode() { return Objects.hash(frequency, value); }
    }

    private static final Comparator<FreqValue> descendingOrder = (a, b) -> {
        if (a.frequency != b.frequency) return Integer.compare(b.frequency, a.frequency);
        return Integer.compare(b.value, a.value);
    };

    private Map<Integer, Integer> frequencyMap;
    private TreeSet<FreqValue> topElements;
    private TreeSet<FreqValue> bottomElements;
    private long sumOfTop;

    private void removeOldInstance(int val, int freq) {
        FreqValue key = new FreqValue(freq, val);
        if (topElements.remove(key)) {
            sumOfTop -= 1L * freq * val;
        } else {
            bottomElements.remove(key);
        }
    }

    private void addToTop(int val, int freq) {
        topElements.add(new FreqValue(freq, val));
        sumOfTop += 1L * freq * val;
    }

    private void addValue(int val, int topSize) {
        int oldFreq = frequencyMap.getOrDefault(val, 0);
        if (oldFreq > 0) removeOldInstance(val, oldFreq);

        int newFreq = oldFreq + 1;
        frequencyMap.put(val, newFreq);
        addToTop(val, newFreq);

        if (topElements.size() > topSize) {
            FreqValue worst = topElements.last();
            topElements.remove(worst);
            sumOfTop -= 1L * worst.frequency * worst.value;
            bottomElements.add(worst);
        }
    }

    private void removeValue(int val, int topSize) {
        Integer oldFreqObj = frequencyMap.get(val);
        if (oldFreqObj == null || oldFreqObj == 0) return;
        int oldFreq = oldFreqObj;

        removeOldInstance(val, oldFreq);

        int newFreq = oldFreq - 1;
        if (newFreq == 0) {
            frequencyMap.remove(val);
        } else {
            frequencyMap.put(val, newFreq);
            bottomElements.add(new FreqValue(newFreq, val));
        }

        if (topElements.size() < topSize && !bottomElements.isEmpty()) {
            FreqValue best = bottomElements.first();
            bottomElements.remove(best);
            topElements.add(best);
            sumOfTop += 1L * best.frequency * best.value;
        }
    }

    public long[] findXSum(int[] numbers, int windowSize, int topSize) {
        int length = numbers.length;
        long[] results = new long[length - windowSize + 1];

        frequencyMap = new HashMap<>(Math.max(16, length * 2));
        topElements = new TreeSet<>(descendingOrder);
        bottomElements = new TreeSet<>(descendingOrder);
        sumOfTop = 0;

        // первые элементы окна
        for (int idx = 0; idx < windowSize; ++idx) {
            addValue(numbers[idx], topSize);
        }
        results[0] = sumOfTop;

        // слайдим
        for (int idx = windowSize; idx < length; ++idx) {
            removeValue(numbers[idx - windowSize], topSize);
            addValue(numbers[idx], topSize);
            results[idx - windowSize + 1] = sumOfTop;
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 1, 2, 2, 3, 4, 2, 3};
        int k = 6;
        int x = 2;

        System.out.println(Arrays.toString(solution.findXSum(nums, k, x)));
    }
}