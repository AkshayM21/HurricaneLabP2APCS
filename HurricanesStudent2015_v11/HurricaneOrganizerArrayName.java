import java.io.*;
import java.util.*;

/**
 * Models hurricane information, works with Hurricane class
 * and the user to manipulate an array of hurricane data. 
 *
 * @author Susan King 
 * @version December 28, 2015
 */
public class HurricaneOrganizerArrayName
{
    private Hurricane [] hurricanes;

    /**
     * Comment this constructor even though you did not write it.
     * 
     * @throws IOException  if file with the hurricane information cannot be found
     */
    public HurricaneOrganizerArrayName(String filename)throws IOException
    {
        readFile(filename);   
    }

    /**
     * Comment this method even though you did not write it.
     * 
     * @throws IOException  if file with the hurricane information cannot be found
     */
    private static int determineFileLength(String filename) throws IOException
    {
        Scanner inFile = new Scanner(new File(filename));
        int counter = 0;

        while(inFile.hasNextLine())
        {
            counter++;
            inFile.nextLine();
        }
        inFile.close();
        return counter;
    }

    /**
     * Comment this method even though you did not write it.
     */
    public void readFile(String filename) throws IOException
    {
        hurricanes = new Hurricane [determineFileLength(filename)];
        int hurYear, hurPressure, hurSpeed;
        String hurName, hurMonth;
        Scanner inFile = new Scanner(new File(filename));

        for(int i = 0; i < hurricanes.length; i++)
        {
            hurYear = inFile.nextInt();
            hurMonth = inFile.next();
            hurPressure = inFile.nextInt();
            hurSpeed = inFile.nextInt();
            String tempName = inFile.nextLine();
            hurName = "";
            for(int k = 0; k < tempName.length(); k++)
            {
                char c = tempName.charAt(k);
                if(('a' <= c && c <= 'z') || ('A' <= c && c <='Z'))
                    hurName += c;
            }
            Hurricane h = new Hurricane(hurYear, hurMonth, hurPressure, hurSpeed, hurName);
            hurricanes [i] = h;
        }
        inFile.close();
    }

    /**
     * Finds the maximum wind speed of the hurricanes
     * @return the maximium wind speed
     */
    public int findMaxWindSpeed()
    {
        // replace the following line
        int max = hurricanes[0].getSpeed();
        for(int i=1; i<hurricanes.length; i++){
            if(hurricanes[i].getSpeed()>max) max = hurricanes[i].getSpeed();
        }
        return max;
    }

    /**
     * Finds the maximum pressure of the hurricanes
     * @return the maximum pressure
     */
    public int findMaxPressure( )
    {
        // replace the following line
        int max = hurricanes[0].getPressure();
        for(int i=1; i<hurricanes.length; i++){
            if(hurricanes[i].getPressure()>max){
                max = hurricanes[i].getPressure();
            }
        }
        return max;
    }

    /**
     * Finds the minimum wind speed of the hurricanes
     * @return the minimum wind speed
     */
    public int findMinWindSpeed( )
    {
        int min = hurricanes[0].getSpeed();
        for(int i=1; i<hurricanes.length; i++){
            if(hurricanes[i].getSpeed()<min) min = hurricanes[i].getSpeed();
        }
        return min;
    }

    /**
     * Finds the minimum pressure of the hurricanes
     * @return the minimum pressure
     */
    public int findMinPressure( )
    {
        int min = hurricanes[0].getPressure();
        for(int i=1; i<hurricanes.length; i++){
            if(hurricanes[i].getPressure()<min){
                min = hurricanes[i].getPressure();
            }
        }
        return min;
    }

    /**
     * Finds the average wind speed of the hurricanes
     * @return the average wind speed
     */
    public double calculateAverageWindSpeed( )
    {
        double sum = hurricanes[0].getSpeed();
        for(int i=1; i<hurricanes.length; i++){
            sum+=hurricanes[i].getSpeed();
        }
        return sum/hurricanes.length;
    }

    /**
     * Finds the average pressure of the hurricanes
     * @return the average pressure
     */
    public double calculateAveragePressure( )
    {
        double sum = hurricanes[0].getPressure();
        for(int i=1; i<hurricanes.length; i++){
            sum+=hurricanes[i].getPressure();
        }
        return sum/hurricanes.length;
    }

    /**
     * Finds the average category of the hurricanes
     * @return the average category
     */
    public double calculateAverageCategory( )
    {
        double sum = hurricanes[0].determineCategory(hurricanes[0].getSpeed());
        for(int i=1; i<hurricanes.length; i++){
            sum+=hurricanes[i].determineCategory(hurricanes[i].getSpeed());
        }
        return sum/hurricanes.length;
    }

    /**
     * Sorts ascending based upon the hurricanes' years,
     * The algorithm is selection sort.
     */
    public void sortYears()
    {
        int minIndex;
        for(int i=0; i<hurricanes.length; i++){
            minIndex = i+1;
            for(int j=i+1; j<hurricanes.length; j++){
                if(hurricanes[j].getYear()<hurricanes[minIndex].getYear()){
                    minIndex = j;
                }
            }
            int temp = hurricanes[i];
            hurricanes[i] = hurricanes[minIndex];
            hurricanes[minIndex] = temp;
        }
    }

    /**
     * Lexicographically sorts hurricanes based on the hurricanes' name, 
     * using insertion sort.
     */
    public void sortNames()
    {
        // write this code
        Hurricane key;
        for(int i=1; i<hurricanes.length; i++){
            key = hurricanes[i];
            int j = i-1;
            while(j>=0 && key.compareNameTo(hurricanes[j])==-1){
                hurricanes[j+1] = hurricanes[j];
            }
            hurricane[j+1] = key;
        }
    }

    /**
     * Sorts descending based upon the hurricanes' categories,
     * using selection sort.
     */
    public void sortCategories()
    {
        int maxIndex;
        for(int i=0; i<hurricanes.length; i++){
            maxIndex = i+1;
            for(int j=i+1; j<hurricanes.length; j++){
                if(hurricanes[j].determineCategory(hurricanes[j].getSpeed())
                        > hurricanes[maxIndex].determineCategory(hurricanes[maxIndex].getSpeed(){
                    maxIndex = j;
                }
            }
            int temp = hurricanes[i];
            hurricanes[i] = hurricanes[maxIndex];
            hurricanes[maxIndex] = temp;
        }
    }  
    

    /**
     * Binary search for a hurricane name.
     * 
     * @param  name   hurricane name being search
     * @return a Hurricane array of all objects in hurricanes with specified name. 
     *         Returns null if there are no matches
     */
    public Hurricane[ ] searchHurricaneName(String name)
    {
        sortNames();
        return searchHurricaneNameHelper(name, 0, hurricanes.length - 1);
    }

    /**
     * Recursive binary search for a hurricane name.  This is the helper
     * for searchHurricaneName.
     * 
     * @precondition  the array must be presorted by the hurricane names
     * 
     * @param   name  hurricane name to search for
     * @param   low   the smallest index that needs to be checked
     * @param   high  the highest index that needs to be checked
     * @return  a Hurricane array of all Hurricane objects with a specified name. 
     *          Returns null if there are no matches
     */
    private Hurricane[ ] searchHurricaneNameHelper(String name, int low , int high)
    {
        // Test for the base case when a match is not found
        if(low>high) return null;

        int mid = (low+high)/2;

        if(hurricanes[mid].getName().equals(name)) {
            ArrayList<Hurricane> al = new ArrayList<Hurricane>();
            al.add(hurricanes[mid]);
            int i = mid-1;
            int j = mid+1;
            while(i>=0&&hurricanes[i].getName().equals(name)){
                al.add(hurricanes[i]);
            }
            while(j<hurricanes.length && hurricanes[j].getName().equals(name)){
                al.add(hurricanes[j]);
            }
            return al.toArray(new Hurricane[al.size()]);
        }

        
        // Determine if the potential match is in the 
        // "first half" of the considered items in the array

        
        
        // The potential match must be in the
        // "second half" of the considered items in the array

        
    }

    /**
     * Supports Binary Search method to get the full range of matches.
     * 
     * @precondition  the array must be presorted by the hurricane names
     * 
     * @param   name hurricane name being search for
     * @param   index  the index where a match was found
     * @return  a Hurricane array with objects from hurricanes with specified name. 
     *          Returns null if there are no matches
     */
    private Hurricane[ ] retrieveMatchedNames (String name, int index)
    {
        // Find the start where the matches start:

        
        // Find the end of the matches:

        
        // Copy the objects whose names match:

        return null;  // correct this line
    }

    /**
     * Comment this method even though you did not write it.
     */
    public void printHeader()
    {
        System.out.println("\n\n");
        System.out.printf("%-4s %-5s %-15s %-5s %-5s %-5s \n", 
            "Year", "Mon.", "Name", "Cat.", "Knots", "Pressure");
    }

    /**
     * Comment this method even though you did not write it.
     */
    public void printHurricanes()
    {
        printHurricanes(hurricanes);
    }

    /**
     * Add comments here even though you did not write the method.
     */
    public void printHurricanes(Hurricane [] hurs)
    {
        if(hurs.length == 0)
        {
            System.out.println("\nVoid of hurricane data.");
            return;
        }
        printHeader();
        for(Hurricane h: hurs)
        {
            System.out.println(h);
        }
    }

    /**
     * Add comments here even though you did not write the method.
     */
    public void printMenu()
    {
        System.out.println("\n\nEnter option: ");
        System.out.println("\t 1 - Print all hurricane data \n" +
            "\t 2 - Print maximum and minimum data \n" +
            "\t 3 - Print averages \n" +
            "\t 4 - Sort hurricanes by year \n" +
            "\t 5 - Sort hurricanes by name \n" +
            "\t 6 - Sort hurricanes by category, descending \n" +
            "\t 7 - Sort hurricanes by pressure, descending \n" +
            "\t 8 - Sort hurricanes by speed \n" + 
            "\t 9 - Search for hurricanes for a given year \n" +
            "\t10 - Search for a given hurricane by name \n" +
            "\t11 - Quit \n");
    }

    /**
     * Add comments here even though you did not write the method.
     */
    public void printMaxAndMin( )
    {
        System.out.println("Maximum wind speed is " + 
            findMaxWindSpeed( ) +
            " knots and minimum wind speed is " + 
            findMinWindSpeed( ) + " knots.");
        System.out.println("Maximum pressure is " + 
            findMaxPressure( ) +
            " and minimum pressure is " + 
            findMinPressure( ) + ".");
    }

    /**
     * Add comments here even though you did not write the method.
     */
    public void printAverages( )
    {
        System.out.printf("Average wind speed is %5.2f knots. \n" , 
            calculateAverageWindSpeed( ));
        System.out.printf("Average pressure is %5.2f. \n" , 
            calculateAveragePressure( ));
        System.out.printf("Average category is %5.2f. \n" , 
            calculateAverageCategory( ));
    }

    /**
     * Add comments here even though you did not write the method.
     */
    public boolean interactWithUser( )
    {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        printMenu();
        int choice = in.nextInt();
        // clear the input buffer
        in.nextLine();

        if(choice == 1)
        {
            printHurricanes( ); 
        }
        else if (choice == 2)
        {
            printMaxAndMin( );
        }
        else if (choice == 3)
        {
            printAverages( );
        }
        else if(choice == 4)
        {
            sortYears();
            printHurricanes( );
        }
        else if(choice == 5)
        {
            sortNames();
            printHurricanes( );
        }
        else if(choice == 6)
        {
            sortCategories();
            printHurricanes( );
        }
        else if(choice == 7)
        {
            sortPressures();
            printHurricanes( );
        }
        else if(choice == 8)
        {
            sortWindSpeeds(0, hurricanes.length - 1);
            printHurricanes( );
        }
        else if(choice == 9)
        {
            System.out.print("\n\tWhich year do you want to search for?\n\t");
            int year = in.nextInt();
            printHurricanes(searchYear(year));
        }
        else if(choice == 10)
        {
            System.out.print("\n\tWhich name do you want to search for?\n\t");
            String name = in.next();
            printHurricanes(searchHurricaneName(name));
        }
        else if (choice == 11)
        {
            done = true;
        }  
        return done;
    }

    /**
     * Comment the method even though you did not write it.
     * 
     * @param args  user's information from the command line
     * 
     * @throws IOException  if file with the hurricane information cannot be found
     */
    public static void main (String [] args) throws IOException
    {
        HurricaneOrganizerArrayName cane = new HurricaneOrganizerArrayName("hurricanedata.txt");
        boolean areWeDoneYet = false;
        while ( ! areWeDoneYet)
        {
            areWeDoneYet = cane.interactWithUser( );    
        }
    }
}
