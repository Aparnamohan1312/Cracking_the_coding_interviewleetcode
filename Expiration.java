import java.util.*;

public class Expiration {
    private final Map<String, Integer> map;
    private final Map<String, Long> timestamps;
    private final long expTime;

    public Expiration(long expTime) {
        this.map = new HashMap<>();
        this.timestamps = new HashMap<>();
        this.expTime = expTime;
    }

    public void put(String key, Integer value) {
        map.put(key, value);
        timestamps.put(key, System.currentTimeMillis());
        removeExpiredEntries();
    }

    public Integer get(String key) {
        return map.get(key);
    }

    public void removeExpiredEntries() {
        long currentTime = System.currentTimeMillis();
        for (String key : new ArrayList<>(timestamps.keySet())) {
            long timestamp = timestamps.get(key);
            if (currentTime - timestamp > expTime) {
                timestamps.remove(key);
                map.remove(key);
            }
        }
    }

    public double getAverage() {
        if (map.isEmpty()) {
            return 0.0;
        }
        int sum = map.values().stream().mapToInt(Integer::intValue).sum();
        return (double) sum / map.size();
    }

    public static void main(String[] args) {
        Expiration obj = new Expiration(10000);
        obj.put("key1", 10);
        obj.put("key2", 20);
        obj.put("key3", 30);
        System.out.println("Before: " + obj.getAverage());
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("After: " + obj.getAverage());
    }
}
