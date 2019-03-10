package com.niu.random;


import java.util.HashMap;
import java.util.Scanner;

public class Code_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        scanner.nextLine();
        LRUCache lruCache = new LRUCache(capacity);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] strings = s.split(" ");
            if (strings.length == 1) {
                System.out.println(lruCache.get(Integer.parseInt(strings[0])));
                break;
            } else {
                lruCache.put(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
            }
        }

    }

}

class LRUCache {
    private int[] nodes;
    private int capacity;
    private int cur = 0;
    private HashMap<Integer,Integer> map=new HashMap<>();
    public LRUCache(int capacity) {
        if (capacity < 0) return;
        this.capacity = capacity;
        nodes = new int[capacity];
    }

    public int get(int key) {
        for(int i=0;i<capacity;i++){
            if(nodes[i]==key){
                if(map.containsKey(key))
                return map.get(key);
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        nodes[cur++ % capacity] = key;
        map.put(key,value);
    }

}
