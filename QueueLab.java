import java.util.*;
import java.io.*;
public class QueueLab{

 public static void main (String[] args){
    File file = new File("queue2.txt");

    int inputSize = 1000;
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
    Queue myqueue = new Queue();
    for(int i=0; i<inputSize; i++){
    if(input[i].split("\t")[0].equals("INSERT")){
        myqueue.insert(input[i].split("\t")[1]);
    } else if(input[i].split("\t")[0].equals("REMOVE")){
        myqueue.remove();
    } else{
        String myprint = myqueue.peekFront();
        System.out.println(myprint);
    }
    }
 }




 public static class Queue{
 private int maxSize;
 private String[] queArray;
 private int[] pointsArray;
 private int front;
 private int rear;
 private int nItems;
 private char myChar;
 private int mytotal;

 public Queue() { // constructor
 maxSize = 100;
 queArray = new String[maxSize];
 front = 0;
 rear = -1;
 nItems = 0;
 myChar = 0;
 pointsArray = new int[maxSize];
 }

    public void insert(String move) { // insert item
        if(isFull() == false)
        {
        for (int x=0; x<move.length();x++)
        {
            myChar = Character.toLowerCase(move.charAt(x));
            if(myChar == 'a' || myChar == 'e' || myChar == 'i' || myChar == 'o' || myChar == 'u')
            {
                mytotal++;
            }
        }

        if(nItems==0){ // if no items,
            pointsArray[0] = mytotal;
            queArray[0] = move; // insert at 0
        }else{ // if some items,
            int j = nItems; // start at end
            while(j > 0 && pointsArray[j-1] > mytotal){ // while new item larger
                queArray[j] = queArray[j-1]; // shift upward
                pointsArray[j] = pointsArray[j-1];
                j--; // decrement j
        }
            queArray[j] = move; // insert it
            pointsArray[j] = mytotal;
        }

        int l = 0;
        int m = pointsArray.length - 1;
        int tmp;
        String tmp2;
        while (m > l) {
            tmp = pointsArray[m];
            tmp2 = queArray[m];
            pointsArray[m] = pointsArray[l];
            queArray[m] = queArray[l];
            pointsArray[l] = tmp;
            queArray[l] = tmp2;
            m--;
            l++;
        }

        for(int z = 0;z<pointsArray.length;z++)
        {   
            if ((z <= pointsArray.length-2) && (pointsArray[z] == pointsArray[z+1]))
            {
                int n = 2;
                String temp3;
                int temp4;
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        
                        // to compare one string with other strings
                        if(queArray[i] != null && queArray[j] != null)
                        if (queArray[i].compareTo(queArray[j]) < 0) {
                            // swapping
                            temp3 = queArray[i];
                            temp4 = pointsArray[i];
                            queArray[i] = queArray[j];
                            pointsArray[i] = pointsArray[j];
                            queArray[j] = temp3;
                            pointsArray[j] = temp4;
                        }
                    }
                }
            }
        }
        
        nItems++; // increase items

        mytotal = 0;
    }



    }
        
 public String remove() { // take item from front
 if(isEmpty()) return null; //don’t remove if empty
String temp = queArray[front];// get value, incr front
front++;
 if(front == maxSize) {// deal with wraparound
    front = 0;
 }nItems--; // one less item

 return temp;
 }
 public String peekFront(){ // peek at front of queue

 return queArray[front];
 }

 public boolean isEmpty() { // true if queue is empty

 return (nItems==0);
 }

 public boolean isFull() { // true if queue is full

 return (nItems==maxSize);
 }

 public int size() { // number of items in queue

 return nItems;
 }
 }
}