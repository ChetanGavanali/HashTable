package com.bridgelabz;

import java.util.ArrayList;

public class HashTable<K,V> {
        Node head;
        Node tail;
        private final int numOfBuckets;
        ArrayList<Node<K,V>> myBucketArray;

        public HashTable() {
            this.numOfBuckets = 20;
            this.myBucketArray = new ArrayList<>();
            for (int i = 0; i < numOfBuckets; i++)
                this.myBucketArray.add(null);
        }
        public void add(K key, V value) {
            int index = this.getBucketIndex(key);
            Node<K,V> myNode= this.myBucketArray.get(index);
            if(myNode == null) {
                myNode = new Node<>(key , value);
                this.myBucketArray.set(index, myNode);
            }
            myNode = (Node<K, V>) searchNode(key);
            if(myNode == null) {
                myNode = new Node<>(key , value);
                this.append(myNode);
            }
            else {
                myNode.setValue(value);
            }
        }
        public void append(Node myNode) {
            if(this.head == null)
                this.head = myNode;
            if(this.tail == null)
                this.tail = myNode;
            else {
                this.tail.setNext(myNode);
                this.tail = myNode;
            }
        }

        public Node<K, V> searchNode(K data) {
            Node currentNode = head;
            int position = 0;
            while (currentNode != null) {
                position++;
                if (currentNode.getKey().equals(data)) {
                    return currentNode;
                }
                currentNode = currentNode.getNext();
            }
            return currentNode;
        }

        public V get(K word) {
            int index = this.getBucketIndex(word);
            if(this.myBucketArray.get(index) == null)
                return null;
            Node<K, V> myMapNode = searchNode(word);
            return (myMapNode == null) ? null : myMapNode.getValue();
        }

        private int getBucketIndex(K word) {
            int hashCode = Math.abs(word.hashCode());
            System.out.println(hashCode);
            int index = hashCode % numOfBuckets;
            System.out.println(index);
            return index;
        }
        public void remove(K word) {
            Node currentNode = head;
            Node previousNode = null;
            while (currentNode != null && currentNode.getKey().equals(word)) {
                head = currentNode.getNext();
                return;
            }
            while (currentNode != null && !(currentNode.getKey().equals(word))) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            if (currentNode != null) {
                previousNode.next = currentNode.next;
            }
            if(currentNode == null)
                System.out.println("Word not found!");
        }
        @Override
        public String toString() {
            return "MyLinkedListNodes{" + head + "}";
        }
}
