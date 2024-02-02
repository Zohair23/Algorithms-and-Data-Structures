import java.util.Scanner;
public class practice1
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        while (option != 3)
        {
            System.out.println("1.Check if a number is a prime");
            System.out.println("2.List prime numbers in a range");
            System.out.println("3.To Exit");
            System.out.println("Choose an option 1, 2 or 3: ");
            option = scan.nextInt(); 
            if (option == 1)
            {
                System.out.println("Enter a number");
                int checkNum = scan.nextInt();
                if (prime(checkNum) == true)
                {
                    System.out.println(checkNum + " is a prime number.");
                } else
                {
                    System.out.println(checkNum + " is a NOT prime number.");
                }
            }else if (option == 2)
            {
                System.out.println("Enter the start of the range: ");
                int start = scan.nextInt();
                System.out.println("Enter the end of the range: ");
                int end = scan.nextInt();
                System.out.println("Prime numbers in the range [" + start + "," + end + "]: ");
                for(int i = start; i <= end;i++)
                {
                    if(prime(i) == true)
                    {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();

            }
        }
        
    }

    public static boolean prime(int primeCheck)
    {
        for(int i = 2; i < primeCheck;i++)
        {
            if ((primeCheck%i) == 0)
            {
                return false;
            }
        }
        return true;

    }
}
