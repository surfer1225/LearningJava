package main.java.Stripe;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        //testMinByKey();
        testFirstByKey();
        //testRecordComparator();
    }

    /**
     * # Step 1
     * Throughout this interview, we'll pretend we're building a new analytical
     * database. Don't worry about actually building a database though -- these will
     * all be toy problems.
     *
     * Here's how the database works: all records are represented as maps, with string
     * keys and integer values. The records are contained in an array, in no
     * particular order.
     *
     * To begin with, the database will support just one function: min_by_key. This
     * function scans the array of records and returns the record that has the minimum
     * value for a specified key. Records that do not contain the specified key are
     * considered to have value 0 for the key. Note that keys may map to negative values!
     *
     * Here's an example use case: each of your records contains data about a school
     * student. You can use min_by_key to answer questions such as "who is the youngest
     * student?" and "who is the student with the lowest grade-point average?"
     *
     * Implementation notes:
     * * You should handle an empty array of records in an idiomatic way in your
     *   language of choice.
     * * If several records share the same minimum value for the chosen key, you
     *   may return any of them.
     *
     * ### Java function signature:
     * ```
     * public static Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records);
     * ```
     *
     * ### Examples (in Python):
     * ```
     * assert min_by_key("a", [{"a": 1, "b": 2}, {"a": 2}]) == {"a": 1, "b": 2}
     * assert min_by_key("a", [{"a": 2}, {"a": 1, "b": 2}]) == {"a": 1, "b": 2}
     * assert min_by_key("b", [{"a": 1, "b": 2}, {"a": 2}]) == {"a": 2}
     * assert min_by_key("a", [{}]) == {}
     * assert min_by_key("b", [{"a": -1}, {"b": -1}]) == {"b": -1}
     * ```
     */
    public static Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records) {
        return firstByKey(key, "asc", records);
    }

    public static void testMinByKey() {
        List<Map<String, Integer>> example1 = Arrays.asList(
                Maps.of("a", 1, "b", 2),
                Maps.of("a", 2)
        );
        List<Map<String, Integer>> example2 = Arrays.asList(example1.get(1), example1.get(0));
        List<Map<String, Integer>> example3 = Arrays.asList(Maps.of());
        List<Map<String, Integer>> example4 = Arrays.asList(
                Maps.of("a", -1),
                Maps.of("b", -1)
        );

        System.out.println("minByKey");
        assertEqual(example1.get(0), minByKey("a", example1));
        assertEqual(example2.get(1), minByKey("a", example2));
        assertEqual(example1.get(1), minByKey("b", example1));
        assertEqual(example3.get(0), minByKey("a", example3));
        assertEqual(example4.get(1), minByKey("b", example4));
    }

    public static <T> void assertEqual(T expected, T actual) {
        if (expected == null && actual == null || actual != null && actual.equals(expected)) {
            System.out.println("PASSED");
        } else {
            throw new AssertionError("Expected:\n  " + expected + "\nActual:\n  " + actual + "\n");
        }
    }

    public static <T> void assertIn(T needle, List<T> haystack) {
        if (haystack.contains(needle)) {
            System.out.println("PASSED");
        } else {
            throw new AssertionError(needle + " was not found in " + haystack + "\n");
        }
    }


    /**
     * # Step 2
     * Our next step in database development is to add a new function. We'll call this
     * function first_by_key. It has much in common with min_by_key.  first_by_key
     * takes three arguments:
     *
     * 1. a string key
     * 2. a string sort direction (which must be either "asc" or "desc")
     * 3. an array of records, just as in min_by_key.
     *
     * If the sort direction is "asc", then we should return the minimum record,
     * otherwise we should return the maximum record. As before, records without a
     * value for the key should be treated as having value 0.
     *
     * Once you have a working solution, you should re-implement min_by_key in terms
     * of first_by_key .
     *
     * ### Java function signature:
     * ```
     * public static Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records);
     * ```
     *
     * ### Examples (in Python):
     * ```
     * assert first_by_key("a", "asc", [{"a": 1}]) == {"a": 1}
     *
     * assert first_by_key("a", "asc", [{"b": 1}, {"b": -2}, {"a": 10}]) in [{"b": 1}, {"b": -2}]
     * assert first_by_key("a", "desc", [{"b": 1}, {"b": -2}, {"a": 10}]) == {"a": 10}
     * assert first_by_key("b", "asc", [{"b": 1}, {"b": -2}, {"a": 10}]) == {"b": -2}
     * assert first_by_key("b", "desc", [{"b": 1}, {"b": -2}, {"a": 10}]) == {"b": 1}
     *
     * assert first_by_key("a", "desc", [{}, {"a": 10, "b": -10}, {}, {"a": 3, "c": 3}]) == {"a": 10, "b": -10}
     * ```
     */
    public static Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records) {
        if (records.isEmpty()) return new HashMap<>();
        RecordComparator cmp = new RecordComparator(key, direction);

        Map<String, Integer> result = records.get(0);
        for (Map<String, Integer> record : records) {
            if (cmp.compare(record, result) == -1) result = record;
        }
        return result;
    }

    public static void testFirstByKey() {
        List<Map<String, Integer>> example1 = Arrays.asList(Maps.of("a", 1));
        List<Map<String, Integer>> example2 = Arrays.asList(
                Maps.of("b", 1),
                Maps.of("b", -2),
                Maps.of("a", 10)
        );
        List<Map<String, Integer>> example3 = Arrays.asList(
                Maps.of(),
                Maps.of("a", 10, "b", -10),
                Maps.of(),
                Maps.of("a", 3, "c", 3)
        );
        List<Map<String, Integer>> example4 = Arrays.asList(new HashMap<>());

        System.out.println("firstByKey");
        assertEqual(example1.get(0), firstByKey("a", "asc", example1));
        // Either example2.get(0) or example2.get(1) are acceptable
        assertIn(firstByKey("a", "asc", example2), example2.subList(0, 2));
        assertEqual(example2.get(2), firstByKey("a", "desc", example2));
        assertEqual(example2.get(1), firstByKey("b", "asc", example2));
        assertEqual(example2.get(0), firstByKey("b", "desc", example2));
        assertEqual(example3.get(1), firstByKey("a", "desc", example3));

    }

    /**
     * # Step 3
     * As we build increasingly rich orderings for our records, we'll find it useful
     * to extract the comparison of records into a comparator. This is a function or
     * object (depending on your language) which determines if a record is
     * "less than", equal, or "greater than" another.
     *
     * In object-oriented languages, you should write a class whose constructor
     * accepts two parameters: a string key and a string direction. The class should
     * implement a method compare that takes as its parameters two records. This
     * method should return -1 if the first record comes before the second record
     * (according to key and direction), zero if neither record comes before the
     * other, or 1 if the first record comes after the second.
     *
     * In functional languages, you should write a function which accepts two
     * parameters: a string key and a string direction. The function should return
     * a function that takes as its parameters two records. This function should return
     * -1 if the first record comes before the second record (according to key and
     * direction), zero if neither record comes before the other, or 1 if the first
     * record comes after the second.
     *
     * You should then use your comparator in your implementation of first_by_key.
     *
     * ### Java skeleton class:
     * ```
     * class RecordComparator implements Comparator<Map<String, Integer>> {
     *   public RecordComparator(String key, String direction) {
     *   }
     *
     *   public int compare(Map<String, Integer> left, Map<String, Integer> right) {
     *     return 0;
     *   }
     * }
     * ```
     *
     * ### Examples (in Python):
     * ```
     * cmp = Comparator("a", "asc")
     * assert cmp.compare({"a": 1}, {"a": 2}) == -1
     * assert cmp.compare({"a": 2}, {"a": 1}) == 1
     * assert cmp.compare({"a": 1}, {"a": 1}) == 0
     * ```
     */
    static class RecordComparator implements Comparator<Map<String, Integer>> {

        private String key;
        private String direction;

        public RecordComparator(String key, String direction) {
            this.direction = direction;
            this.key = key;
        }

        @Override
        public int compare(Map<String, Integer> left, Map<String, Integer> right) {
            if (direction.equals("asc")) {
                return Integer.compare(getMapValue(left, key), getMapValue(right, key));
            }
            return Integer.compare(getMapValue(right, key), getMapValue(left, key));
        }

        private int getMapValue(Map<String, Integer> m, String key) {
            Integer val = m.get(key);
            return val == null ? 0 : val;
        }
    }

    public static void testRecordComparator() {
        RecordComparator cmp = new RecordComparator("a", "asc");
        Map<String, Integer> a1 = Maps.of("a", 1);
        Map<String, Integer> a2 = Maps.of("a", 2);
        System.out.println("RecordComparator");
        assertEqual(-1, cmp.compare(a1, a2));
        assertEqual(1, cmp.compare(a2, a1));
        assertEqual(0, cmp.compare(a1, a1));
    }
}

/*
 * Helpers to quickly create and populate new Maps.
 *
 * Inspired by ImmutableMap.of in guava.
 */
class Maps {
    public static <K, V> Map<K, V> of() {
        return new HashMap<K, V>();
    }

    public static <K, V> Map<K, V> of(K k1, V v1) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Map<K, V> map = new HashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return map;
    }

    public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1) {
        LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
        map.put(k1, v1);
        return map;
    }

    public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1, K k2, V v2) {
        LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1, K k2, V v2, K k3, V v3) {
        LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }
}

