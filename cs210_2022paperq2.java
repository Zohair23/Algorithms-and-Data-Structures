import java.util.Scanner;
import java.util.*;

public class cs210_2022paperq2
{
    public static void main(String[] args)
    {
        long[] myArray = new long[1000];
        for(int i = 0; i < 1000;i++)
        {
            if (i == 0)
            {
                myArray[i] = 1;
            } else if(i == 1)
            {
                myArray[i] = 2;
            } else
            {
                myArray[i] = myArray[i-1] + myArray[i-2];
            }
        }
        System.out.println(myArray[999]);
    }
}