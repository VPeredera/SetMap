package com.akadatsky;

public class Main {

    public static void main(String[] args) {
        // Map<String, String> map = new HashMap<>(); - аналог
        MyMap myMap = new MyHashMap();
        myMap.put("1", "asdf");
        myMap.put("2", "qwert");
        myMap.put("3", "zxcv");
        System.out.println(myMap.put("1", "zrzz"));
        myMap.put("6", "juri");
        System.out.println(myMap.size());
        System.out.println(myMap.containsKey("3"));
        System.out.println(myMap.containsKey("10"));
        System.out.println(myMap.get("1"));
        System.out.println(myMap.get("6"));
        System.out.println(myMap.get("3"));
        System.out.println(myMap); // [1=zzz, 2=qwert, 3=zxcv, 6=juri]
        System.out.println(myMap.remove("3"));
        System.out.println(myMap.remove("6"));
        System.out.println(myMap);
        System.out.println("isEmpty: " + myMap.isEmpty());
        myMap.clear();
        System.out.println("isEmpty: " + myMap.isEmpty());

        System.out.println();

        MySet set = new MyHashSet();
        set.add("asdf");
        set.add("qwer");
        set.add("zxcv");
        set.add("asdf");
        System.out.println(set); // [zxcv, qwer, asdf]
        System.out.println("size: " + set.size());
        System.out.println("contains: " + set.contains("qwer"));
        System.out.println("isEmpty: " + set.isEmpty());
        set.clear();
        System.out.println("isEmpty: " + set.isEmpty());
        System.out.println(set.add("ghty"));
        System.out.println(set.remove("ghty"));
        System.out.println(set);

        System.out.println();

        MySet set2 = new MyHashSet2();
        set2.add("asdf");
        set2.add("qwer");
        set2.add("zxcv");
        set2.add("asdf");
        System.out.println(set2); // [zxcv, qwer, asdf]
        System.out.println("size: " + set2.size());
        System.out.println("contains: " + set2.contains("qwer"));
        System.out.println("isEmpty: " + set2.isEmpty());
        set2.clear();
        System.out.println("isEmpty: " + set2.isEmpty());
        System.out.println(set2.add("ghty"));
        System.out.println(set2.remove("ghty"));
        System.out.println(set2);
    }

}