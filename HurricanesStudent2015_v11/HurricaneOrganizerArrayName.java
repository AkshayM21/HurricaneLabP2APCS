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
     * Creates a new HurricaneOrganizerArrayName object and initializes relevant variables
     * @param filename the name of the file with hurricane data
     * @throws IOException  if file with the hurricane information cannot be found
     */
    public HurricaneOrganizerArrayName(String filename)throws IOException
    {
        readFile(filename);   
    }

    /**
     * Finds the length of the file (number of lines)
     * @param filename the name of the file
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
     * Reads the file and populates the hurricane array
     * @param filename the name of the file to pull the data
     * @throws IOException if the file with the hurricane information cannot be found
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
            Hurricane temp = hurricanes[i];
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
            hurricanes[j+1] = key;
        }
    }
    
    /**
     * Sorts ascending based upon wind speeds using a recursive merge sort. 
     */
    public void sortWindSpeeds(int low, int high)
    {
        if(low<high){
            sortWindSpeeds(low, (low+high)/2);
            sortWindSpeeds((low+high)/2 + 1, high);
            mergeWindSpeedsSortHelper(low, (low+high)/2, high);
        }
    }

    /**
     * Merges two consecutive parts of an array, using wind speed as a criteria
     * and a temporary array.  The merge results in an ascending sort between
     * the two given indices.
     * 
     * @precondition the two parts are sorted ascending based upon wind speed
     * 
     * @param low   the starting index of one part of the array.
     *              This index is included in the first half.
     * @param mid   the starting index of the second part of the array.
     *              This index is included in the second half.
     * @param high  the ending index of the second part of the array.  
     *              This index is included in the merge.
     */
    private void mergeWindSpeedsSortHelper(int low, int mid, int high)
    {
        Hurricane[] values1 = new Hurricane[mid-1-low];
        Hurricane[] values2 = new Hurricane[high-mid];
        for(int i=0; i<values1.length; i++){
            values1[i] = hurricanes[low+i];
        }
        for(int i=0; i<values2.length; i++){
            values2[i] = hurricanes[mid+i];
        }
        int j = 0,k = 0;
        int i;
        for(i=low; i<high; i++){
            if(j>=values1.length||k>=values2.length) break;
            if(values1[j].getSpeed()<values2[k].getSpeed()){
                hurricanes[i] = values2[k++];
            }else{
                hurricanes[i] = values1[j++];
            }
        }
        while(j<values1.length){
            hurricanes[i++] = values1[j++];
        }
        while(k<values2.length){
            hurricanes[i++] = values2[k++];
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
                        > hurricanes[maxIndex].determineCategory(hurricanes[maxIndex].getSpeed())){
                    maxIndex = j;
                }
            }
            Hurricane temp = hurricanes[i];
            hurricanes[i] = hurricanes[maxIndex];
            hurricanes[maxIndex] = temp;
        }
    }  
    

    /**
     * Sorts descending based upon pressures using a non-recursive merge sort.
     */
    public void sortPressures()
    {
        int currSize, leftStart;
        for (currSize=1; currSize<=hurricanes.length-1; currSize=2*currSize)
        {
            for (leftStart=0; leftStart<hurricanes.length-1; leftStart+=2*currSize)
            {
                int mid = leftStart + currSize -1;
                int right;
                if (leftStart+2*currSize-1 > hurricanes.length-1)
                    right = hurricanes.length-1;
                else
                    right = leftStart+2*currSize-1;
                sortPressuresHelper(leftStart, right);
            }
        }
    }

    /**
     * Sorts descending a portion of array based upon pressure, 
     * using selection sort.
     * 
     * @param   start   the first index to start the sort
     * @param   end     one past the last index to sort; hence, end position
     *                  is excluded in the sort
     */
    private void sortPressuresHelper (int start, int end)
    {
        int mid = (start+end)/2;
        int i, j, k;
        int n1 = mid-start;
        int n2 = end-mid;
        Hurricane[] left = new Hurricane[n1];
        Hurricane[] right = new Hurricane[n2];
        for (int p=0; p<n1; p++)
            left[p]=hurricanes[p];
        for (int p=0; p<n2; p++)
            left[p]=hurricanes[mid+p]; 
        i=n1-1;
        j=n2-1; 
        k=end-1;
        while (i>=0 && j>=0)
        {
            if (left[i].getPressure()>right[j].getPressure())
                hurricanes[k]=left[i];
            else
                hurricanes[k]=right[j];
            k--;
            i--;
            j--;
        }
        while (i>=0)
        {
            hurricanes[k]=left[i];
            i--;
            k++;
        }
        while (j>=0)
        {
            hurricanes[k]=right[j];
            j--;
            k++;
        }
    }

    /**
     * Sequential search for all the hurricanes in a given year.
     * 
     * @param   year
     * @return  an array of objects in Hurricane that occured in
     *          the parameter year
     */
    public Hurricane [] searchYear(int year)
    {
        int counter = 0;
        for (int i=0; i<hurricanes.length; i++)
        {
            if (hurricanes[i].getYear()==year)
                counter++;
        }
        Hurricane[] h = new Hurricane[counter];
        int index=0;
        for (int i=0; i<hurricanes.length; i++)
        {
            if (hurricanes[i].getYear()==year)
            {
                h[index]=hurricanes[i];
                index++;
            }
        }
        return h;
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
    private Hurricane[ ] searchHurricaneNameHelper(String name, int low, int high)
    {
        // Test for the base case when a match is not found
        if(low>high) return null;

        int mid = (low+high)/2;

        if(hurricanes[mid].getName().equals(name)) {
            return retrieveMatchedNames(name, mid);
        }

        
        // Determine if the potential match is in the 
        // "first half" of the considered items in the array

        if(hurricanes[mid].getName().compareTo(name)<0){
            return searchHurricaneNameHelper(name, low, mid-1);
        }else{
            return searchHurricaneNameHelper(name, mid+1, high);
        }
        
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

        ArrayList<Hurricane> al = new ArrayList<Hurricane>();
        al.add(hurricanes[index]);
        int i = index-1;
        int j = index+1;
        while(i>=0&&hurricanes[i].getName().equals(name)){
            al.add(hurricanes[i]);
        }
        while(j<hurricanes.length && hurricanes[j].getName().equals(name)){
            al.add(hurricanes[j]);
        }
        return al.toArray(new Hurricane[al.size()]);

    }

    /**
     * Prints the header for the table.
     */
    public void printHeader()
    {
        System.out.println("\n\n");
        System.out.printf("%-4s %-5s %-15s %-5s %-5s %-5s \n", 
            "Year", "Mon.", "Name", "Cat.", "Knots", "Pressure");
    }

    /**
     * Calls a helper method to print the Hurricanes.
     */
    public void printHurricanes()
    {
        printHurricanes(hurricanes);
    }

    /**
     * Prints the hurricane data.
     * @param hurs an array of hurricane objects
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
     * Prints the menu.
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
     * Prints the max and min statistics.
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
     * Prints the averages of the statistics.
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
     * Interact master method that controls user interaction with the program.
     * @return returns if it is finished
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
     * Runs the entire program.
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
