package HashMap;

import java.util.*;

public class SalesSorter {

    public static List<String> sortSales(Map<String, Integer> sales) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(sales.entrySet());
        Collections.sort(entries, (a, b) -> b.getValue() - a.getValue());
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            names.add(entry.getKey());
        }
        return names;
    }

    public static void main(String[] args) {
        Map<String, Integer> sales = new HashMap<>();
        sales.put("Mathew", 50);
        sales.put("Lisa", 76);
        sales.put("courtney", 45);
        sales.put("David", 49);
        sales.put("Paul", 49);

        List<String> sortedNames = sortSales(sales);
        System.out.println(sortedNames);
    }
}
