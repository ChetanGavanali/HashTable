package com.bridgelabz;

public class HashTableMain {

    public static void main(String[] args) {
        HashTable<String, Integer> hashImpl = new HashTable();
        String message = "Paranoids are not paranoid because they are paranoid but " +
                "because they keep putting themselves deliberately into paranoid avoidable situations";

        String[] messageArray = message.toLowerCase().split(" ");

        for(String word: messageArray) {
            Integer value =  hashImpl.get(word);
            if( value == null)
                value = 1;
            else
                value = value + 1;
            hashImpl.add(word , value);
            System.out.println("Value = "+value);
        }
        System.out.println(hashImpl);

        hashImpl.remove("avoidable");
        System.out.println(hashImpl);
    }
}
