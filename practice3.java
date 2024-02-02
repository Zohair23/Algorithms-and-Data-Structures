import java.util.Scanner;
public class practice3
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Start: ");
        int start = scan.nextInt();
        System.out.println("End: ");
        int end = scan.nextInt();
        int count = 0;
        for(int i = start; i <= end;i++)
        {
            if (checkPrime(i) == true)
            {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean checkPrime(int toCheck)
    {
        for(int i = 2; i < toCheck;i++)
        {
            if ((toCheck%i) == 0)
            {
                return false;
            }
        }
        return true;
    }
    
}
