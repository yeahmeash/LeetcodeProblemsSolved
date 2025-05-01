

import java.util.*;

public class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        
        int left = 0;
        int right = Math.min(tasks.length, workers.length);
        int answer = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canComplete(tasks, workers, pills, strength, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private boolean canComplete(int[] tasks, int[] workers, int pills, int strength, int k) {
        if (k == 0) return true;
        if (k > workers.length) return false;
        
        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int i = workers.length - k; i < workers.length; i++) {
            workerMap.put(workers[i], workerMap.getOrDefault(workers[i], 0) + 1);
        }
        
        int pillsUsed = 0;
        
        for (int i = k - 1; i >= 0; i--) {
            int task = tasks[i];
            
            // Try to find a worker without pill
            Integer worker = workerMap.ceilingKey(task);
            if (worker != null) {
                updateMap(workerMap, worker);
            } else {
                // Try to find a worker with pill
                if (pillsUsed >= pills) return false;
                worker = workerMap.ceilingKey(task - strength);
                if (worker != null) {
                    updateMap(workerMap, worker);
                    pillsUsed++;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private void updateMap(TreeMap<Integer, Integer> map, int key) {
        int count = map.get(key);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }
}