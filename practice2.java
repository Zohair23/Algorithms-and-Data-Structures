import java.util.Scanner;
public class practice2{
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        int length = 0;
        long userInput = 0;
        do{
            System.out.println("Enter credit card number: ");
            userInput = scan.nextLong();
            String userInputstr = "" + userInput;
            length = userInputstr.length();
            if (length>= 4 && length<=30)
            {
                valid = true;
            }
        }
        while(!valid);
        long myArray[] = new long[length];
        for(int i = 0; i < length;i++)
        {
            myArray[i] = userInput%10;
            userInput = (userInput - (userInput%10))/10;
        }
        long total1 = oddsum(myArray);
        long total2 = evensum(myArray);
        
        if (((total1 + total2) % 10) == 0)
        {
            System.out.println("Valid");
        }else
        {
            System.out.println("Not Valid");
        }

    }

    public static long oddsum(long [] myArray)
    {
        long totalodd = 0;
        for(int i = 0; i < myArray.length;i=i+2)
        {
            totalodd = totalodd + myArray[i];
        }
        return totalodd;
    }

    public static long evensum(long [] myArray)
    {
        long totaleven = 0;
        long multi = 0;
        for(int i = 1; i < myArray.length;i=i+2)
        {
            multi = myArray[i]*2;
            if (multi > 9)
            {
                multi = multi - 9;
            }
            totaleven = totaleven + multi;
        }
        return totaleven;
    }
}