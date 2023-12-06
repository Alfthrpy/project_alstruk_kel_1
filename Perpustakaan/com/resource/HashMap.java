package com.resource;

import java.util.Map;

public class HashMap<Key, Value> {

    private static final int DEFAULT_CAPACITY = 16;
    private Node<Key, Value>[] table;
    private int size;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int initialCapacity) {
        this.table = new Node[initialCapacity];
        this.size = 0;
    }

    public void put(Key key, Value value) {
        int hash = hash(key);
        int index = getIndex(hash);

        if (table[index] == null) {
            table[index] = new Node<>(hash, key, value, null);
            size++;
        } else {
            // Handle collision by chaining
            Node<Key, Value> currentNode = table[index];
            while (currentNode.next != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value; // Update existing key
                    return;
                }
                currentNode = currentNode.next;
            }
            currentNode.next = new Node<>(hash, key, value, null);
            size++;
        }


    }

    public Value get(Key key) {
        int hash = hash(key);
        int index = getIndex(hash);

        Node<Key, Value> currentNode = table[index];
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return null; // Key not found
    }

    public int size() {
        return size;
    }

    private int hash(Key key) {
        return key == null ? 0 : key.hashCode();
    }

    private int getIndex(int hash) {
        return (hash & 0x7FFFFFFF) % table.length; // Modulo to stay within array bounds
    }


    public void display() {
        String reset = "\u001B[0m";
        String cyan = "\u001B[36m";
        String yellow = "\u001B[33m";

        System.out.println("\u001B[34m╔════════════════════════════════╗\u001B[0m");
        System.out.println("\u001B[34m║   \u001B[35mDENDA BERDASARKAN KATEGORI   \u001B[34m║\u001B[0m");
        System.out.println("\u001B[34m╚════════════════════════════════╝\u001B[0m");
        for (Node<Key, Value> node : table) {
            while (node != null) {
                Key kategori = node.key;
                Value denda = node.value;

                String formattedOutput = String.format("        %s%-3s%s :    %sRp.%-3d%s\n", cyan, kategori, reset, yellow, denda, reset);

                System.out.println(formattedOutput);

                node = node.next;
            }
        }
    }

    private static class Node<Key, Value> {
        private final int hash;
        private final Key key;
        private Value value;
        private Node<Key, Value> next;

        public Node(int hash, Key key, Value value, Node<Key, Value> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
