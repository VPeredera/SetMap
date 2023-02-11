package com.akadatsky;

import java.util.Arrays;

public class MyHashSet2 implements MySet {
    private static class Entry {
        private final String string;
        private int hashCode;
        Entry(String string, int hashCode) {
            this.string = string;
            this.hashCode = hashCode;
        }
    }

    private int size = 0;
    private Entry[] set = new Entry[16];

    @Override
    public boolean add(String e) {
        if (e != null && !contains(e)) {
            if (size >= set.length) {
                int newSize = set.length * 3 / 2 + 1;
                Entry[] newSet = new Entry[newSize];
                System.arraycopy(set, 0, newSet, 0, size);
                set = newSet;
            }
            set[size] = new Entry(e, e.hashCode());
            size++;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        set = new Entry[16];
        size = 0;
    }

    @Override
    public boolean contains(String o) {
        if (o != null) {
            for (Entry e : set) {
                if (e != null && e.string.equals(o))
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
            Entry[] newSet = new Entry[set.length];
            for (int i = 0; i < size; i++) {
                if (set[i].string.equals(o)) {
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
        for (int i = 0; i < size; i++) {
            result[i] = set[i].string;
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
