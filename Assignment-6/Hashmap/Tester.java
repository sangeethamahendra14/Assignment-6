package HashMap2;

import java.util.*;

public class Tester {

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("Kelly", "10");
        map1.put("Michel", "20");
        map1.put("Ryan", "30");
        Map<String, String> map2 = new HashMap<>();
        map2.put("jim", "15");
        map2.put("Andy", "45");
        Map<String, String> mergedMap = mergeMaps(map1, map2);
        System.out.println(mergedMap);
    }

    public static Map<String, String> mergeMaps(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String> mergedMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (map2.containsKey(key) && !map2.get(key).equals(value)) {
                key = "new" + key;
                value += " " + map2.get(key);
            }
            mergedMap.put(key, value);
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!map1.containsKey(key)) {
                mergedMap.put(key, value);
            }
        }
        return mergedMap;
    }
}
