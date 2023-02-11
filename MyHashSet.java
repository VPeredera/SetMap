package com.akadatsky;

import java.util.Arrays;

public class MyHashSet implements MySet {

    private String[] set = new String[16];
    private int size = 0;

    @Override
    public boolean add(String e) {
        if (e != null && !contains(e)) {
            if (size >= set.length) {
                int newSize = set.length * 3 / 2 + 1;
                String[] newSet = new String[newSize];
                System.arraycopy(set, 0, newSet, 0, size);
                set = newSet;
            }
            set[size] = e;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        set = new String[16];
        size = 0;
    }

    @Override
    public boolean contains(String o) {
        if (o != null) {
            for (String e : set) {
                if (e != null && e.equals(o))
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(String o) {
        if (o != null && contains(o)) {
            String[] newSet = new String[set.length];
            for (int i = 0; i < size; i++) {
                if (set[i].equals(o)) {
                    System.arraycopy(set, 0, newSet, 0, i);
                    System.arraycopy(set, i + 1, newSet, i, size - i);
                    set = newSet;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String[] toArray() {
        String[] result = new String[size()];
        System.arraycopy(set, 0, result, 0, size);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
