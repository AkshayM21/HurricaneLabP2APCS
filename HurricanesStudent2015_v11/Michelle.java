import java.io.*;
import java.util.*;
/**
 * Write a description of class Michelle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Michelle
{
    private Hurricane [] hurricanes;
    
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
     * Sorts descending based upon pressures using a non-recursive merge sort.
     */
    public void sortPressures()
    {
        int currSize, leftStart;
        
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
        int left[n1], right[n2];
        for (int i=0; i<n1; i++)
            left[i]=hurricane[i];
        for (int i=0; i<n2; i++)
            left[i]=hurricane[mid+i]; 
        i=n1-1, j=n2-1; k=0;
        while (i>=0 && j>=0)
        {
            if (left[i]>right[i])
                hurricane[i]=left[i];
            else
                hurricane[i]=right[i];
            k++;
            i--;
            j--;
        }
        while (i>=0)
        {
            hurricane[k]=left[i];
            i--;
            k++;
        }
        while (j>=0)
        {
            hurricane[k]=right[j];
            j--;
            k++;
        }
    }

    /**
     * Sorts ascending based upon wind speeds using a recursive merge sort. 
     */
    public void sortWindSpeeds(int low, int high)
    {
        // write this code
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
        // write this code
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
        //Find []h length
        // write this code

        Hurricane[] h = new Hurricane[counter];
        // write the code
        return h;
    } 
}
