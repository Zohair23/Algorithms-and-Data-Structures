import java.util.*;
import java.io.*;
public class test2{

 public static void main (String[] args){
 File file = new File("HashTable.txt");

 int inputSize = 90000;
 String[] input = new String[inputSize];
 try {
 Scanner scan = new Scanner(file);

 for(int i = 0; i < inputSize; i++) {
 input[i] = scan.nextLine();
 }
 scan.close();
 } catch (Exception e) {
 System.err.println(e);
 }
 int size=99991;
 Solution mysolution = new Solution();
 String[] hashtable=mysolution.fill(size, input);
 HashTable mytable = new HashTable(hashtable);
 Solution mysolution2 = new Solution(); //prevents cheating by using memory
 for(int i=0;i<inputSize;i++){
 int rand = (int)(Math.random()*inputSize);
 String temp = input[i];
 input[i]=input[rand];
 input[rand]=temp;
 }
 int total=0;
 for(int i=0;i<inputSize;i++){
 int slot = mysolution2.find(size, mytable, input[i]);
 if(!hashtable[slot].equals(input[i])){
 System.out.println("error!");
 }
 }
 long status=mytable.gettotal();
 System.out.println("Collisions: " + status);
 }

}


class HashTable{

 private String[] hashTable;
 private long total=0;
 public HashTable(String[] input){
 hashTable = input;
 }
 public boolean check(int slot, String check){
 if(hashTable[slot].equals(check)){
 return true;
 }else{
 total++;
 return false;
 }
 }

 public long gettotal(){
 return total;
 }
}



class Solution {

    public int find(int size, HashTable mytable, String word) {
        // Hash the word and return the slot in the hashtable
        int hash = hashFunction(word, size);
        int initialSlot = hash;
        int slot = initialSlot;
        int i = 1; // Counter for probing attempts

        // Quadratic probing to handle collisions
        while (!mytable.check(slot, word)) {
            // Update the slot using quadratic probing
            slot = (initialSlot + i * i) % size;
            i++;
        }

        return slot;
    }

    public String[] fill(int size, String[] array) {
        String[] hashtable = new String[size];
        for (int i = 0; i < size; i++) {
            hashtable[i] = "";
        }

        // Add words into the hashtable using the hashing strategy
        for (String word : array) {
            int hash = hashFunction(word, size);
            int initialSlot = hash;
            int slot = initialSlot;
            int i = 1; // Counter for probing attempts

            // Quadratic probing to handle collisions
            while (!hashtable[slot].equals("")) {
                // Update the slot using quadratic probing
                slot = (initialSlot + i * i) % size;
                i++;
            }

            // Place the word in the hashtable
            hashtable[slot] = word;
        }

        return hashtable;
    }

    private int hashFunction(String word, int size) {
        // Improved hash function: Jenkins one-at-a-time hash
        int hash = 0;
        for (char c : word.toCharArray()) {
            hash += c;
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return Math.abs(hash) % size;
    }
}



