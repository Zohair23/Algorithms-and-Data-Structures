import java.util.*;
import java.io.*;
public class Lab9{

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

class Solution{

 public int find(int size, HashTable mytable, String word){

 //fill this in so as to minimize collisions
 //takes in the HashTable object and the word to be found
 //the only thing you can do with the HashTable object is call "check"
 //this method should return the slot in the hashtable where the word is

 int myHashVal2 = 0;
   for(int j = 0;j<word.length();j++)
   {
      int code = word.charAt(j) - 96;
      myHashVal2 = (code * 27 + code) % size;
   }
   boolean found = false;
 while (found == false)
 {
   if (mytable.check(myHashVal2,word) == true)
   {
      return myHashVal2;
   }
   myHashVal2++;
 }
   return 0;
 }

 public String[] fill(int size, String[] array){

 //takes in the size of the hashtable, and the array of Strings to be placed in the hashtable
 //this should add all the words into the hashtable using some system
 //then it should return the hashtable array
 String[] hashtable = new String[size];
 for(int i=0;i<size;i++){
 hashtable[i]="";
 }

 for(int i = 0; i < array.length;i++)
 {
    int myHashVal = 0;
   for(int j = 0;j<array[i].length();j++)
   {
      int code = array[i].charAt(j) - 96;
      myHashVal = (code * 27 + code) % size;
   }
    
     while(hashtable[myHashVal] != "")
    {
      myHashVal++; //next slot
      myHashVal = myHashVal % size;// loop back if end of array
    }

    hashtable[myHashVal] = array[i];

 }

 return hashtable;

 }
}