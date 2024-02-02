import java.util.Scanner;

public class cs210lab7test
{
    public static void main(String [] args)
    {

        char []lettersArray = {'A','E','I','O','U','L','N','S','T','R','D','G','B','C','M','P','F','H','V','W','Y','K','J','X','Q','Z'};
        Scanner scan = new Scanner(System.in);
        //constraint
        int numOfStrings = 0;
        boolean valid = false;
        while (valid == false)
        {
            System.out.println("Enter number of strings: ");
            numOfStrings = scan.nextInt()+1;
            if (numOfStrings <= 100 && numOfStrings >=0)
            {
                valid = true;
            }
        }
        
        String stringArray[] = new String[numOfStrings];
        int pointsArray[] = new int[numOfStrings];

        for (int i = 0; i < numOfStrings;i++)
        {
            System.out.print("Enter String: " );
            String enterArray = scan.nextLine();
            stringArray[i] = enterArray;
            for(int j = 0; j < enterArray.length();j++)
            {
                int add = 0;
                char checkS = Character.toUpperCase(enterArray.charAt(j));
                for(int k = 0; k < lettersArray.length;k++)
                {
                    if (checkS == lettersArray[k])
                    {
                        if (k <= 9)
                        {
                            add = 1;
                        } else if (k > 9 && k <= 11)
                        {
                            add = 2;
                        } else if (k > 11 && k <= 15)
                        {
                            add = 3;
                        } else if (k > 15 && k <= 20)
                        {
                            add = 4;
                        } else if (k == 21)
                        {
                            add = 5;
                        } else if (k > 21 && k <= 23)
                        {
                            add = 8;
                        } else if (k > 23 && k <= 25)
                        {
                            add = 10;
                        }
                    }
                }
                pointsArray[i] = pointsArray[i] + add;
            }
            
        }
        scan.close();
        
        //insertion sort
        for (int outer = 1; outer < pointsArray.length; outer++) { 
            // outer is the next element to be sorted

        int temp = pointsArray[outer]; //back it up
        String temp2 = stringArray[outer];
        int inner = outer; // inner used to track shifts
        while (inner > 0 && pointsArray[inner - 1] >= temp) {
            pointsArray[inner] = pointsArray[inner - 1];// swap 
            stringArray[inner] = stringArray[inner - 1];
            inner--;
        } //shift them all right until one is smaller
            pointsArray[inner] = temp;
            stringArray[inner] = temp2;
        }

        //new array(remove non strings)
        int count = 0;
        for(int a = 0; a < pointsArray.length;a++)
        {
            if (pointsArray[a] != 0)
            {
                count++;
            }
        }
        String cutString[] = new String[count];
        int cutPoints[] = new int[count];
        
        int count2 = 0;
        for(int b = 0; b < pointsArray.length;b++)
        {
            if (pointsArray[b] != 0)
            {
                cutString[count2] = stringArray[b];
                cutPoints[count2] = pointsArray[b];
                count2++;
            }
        }


        //sort alphabetically if same points(bubble sort)
        for(int y = 0;y<cutString.length;y++)
        {   
            if ((y <= cutString.length-2) && (cutPoints[y] == cutPoints[y+1]))
            {
                int n = 2;
                String temp;
                int temp2;
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        
                        // to compare one string with other strings
                        if (cutString[i].compareTo(cutString[j]) > 0) {
                            // swapping
                            temp = cutString[i];
                            temp2 = cutPoints[i];
                            cutString[i] = cutString[j];
                            cutPoints[i] = cutPoints[j];
                            cutString[j] = temp;
                            cutPoints[j] = temp2;
                        }
                    }
                }
            }
        }

        //print with points
        for(int z = 0;z<cutString.length;z++)
        {
            System.out.println(cutString[z]+"("+cutPoints[z]+")");
        }

    }
}



    