import java.io.*;

class FileIO {
    public String[] load(String file) {
        File aFile = new File(file);
        StringBuffer contents = new StringBuffer();
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(aFile));
            String line = null;
            while ((line = input.readLine()) != null) {
                contents.append(line);
                contents.append(System.getProperty("line.separator"));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Can't find the file -are you sure the file is in this location: " + file);
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Input output exception while processing file");
            ex.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ex) {
                System.out.println("Input output exception while processing file");
                ex.printStackTrace();
            }
        }
        String[] array = contents.toString().split("\n");
        for (String s : array) {
            s.trim();
        }
        return array;
    }

    public void save(String file, String[] array) throws FileNotFoundException, IOException {
        File aFile = new File(file);
        Writer output = null;
        try {
            output = new BufferedWriter(new FileWriter(aFile));
            for (int i = 0; i < array.length; i++) {
                output.write(array[i]);
                output.write(System.getProperty("line.separator"));
            }
        } finally {
            if (output != null)
                output.close();
        }
    }
}



public class Queue {
    private int maxSize;
    private String[] queArray;
    private int front;
    private int rear;
    private int nItems;
    
        
    public Queue() { // constructor

        maxSize = 100;
        queArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public boolean myinsert(String s) { // put item at rear of queue
        if(myisFull()) return false; //don’t remove if full
        if(rear == maxSize-1){ // deal with wraparound
            rear = -1;
        }
        rear++;
        queArray[rear] = s; // increment rear and insert
        nItems++; // one more item
        return true; //successfully inserted
    }

    public String myremove() { // take item from front of queue
        if(myisEmpty()) return null; //don’t remove if empty
        String temp = queArray[front];// get value and incr front
        front++;
        if(front == maxSize){ // deal with wraparound
            front = 0;
        }
        nItems--; // one less item
        return temp;
    }


    public String mypeekFront(){ // peek at front of queue
        return queArray[front];
    } 

    public boolean myisEmpty() { // true if queue is empty
        return (nItems==0);
    }   

    public boolean myisFull() { // true if queue is full
        return (nItems==maxSize);
    }

    public int mysize() { // number of items in queue
        return nItems;
    }





    public static void main(String[] args) {
        FileIO reader = new FileIO();
        String[] input = reader.load("queue2.txt"); // Reading the File as a String array
        String command = "";
        String string = "";
        Queue testQueue = new Queue();
        String myprint = "";

        for(int i = 0;i<input.length;i++)
        {
            System.out.println(input.length);
            if (input[i].equals("PEEK"))
            {
                command = input[i].substring(0,4);
            }else if (input[i].substring(0,6).equals("INSERT"))
            {
                command = input[i].substring(0,6);
                string = input[i].substring(7);
            }else
            {
                command = input[i].substring(0,6);
            }
            
            if (command.equals("REMOVE"))
            {
                testQueue.myremove();
                
            } else if (command.equals("INSERT"))
            {
                testQueue.myinsert(string);   
            } else if (command.equals("PEEK"))
            {
                myprint = testQueue.mypeekFront();
                System.out.println(myprint);
            }
        }
    }

} 






