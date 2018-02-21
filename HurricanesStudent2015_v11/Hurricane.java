import java.io.*;

/**
 * Models hurricane information, including categories.  
 * Works with HurricaneOrganizer, provides object and comparison skeletons.
 * 
 * @author Susan King
 * @version January 10, 2010
 */
public class Hurricane
{
    //Instance variables

    /**
     * Initializes a Hurricane object with no information.
     */
    public Hurricane( )
    {

    }

    /**
     * Initializes a Hurricane object with historical information.
     * 
     * @param year      year the hurricane took place
     * @param month     month in String format
     * @param pressure  hurricane's pressure
     * @param speed     hurricane's speed in knots
     * @param name      hurricane's name
     */
    public Hurricane(int year, String month, 
    int pressure, int speed, String name)
    {

    }

    /**
     * Based upon Saffir/Simpson Hurricane Scale, figures out
     * the category using wind speed in knots.
     * 
     * @param knots     wind speed in knots
     * @return Saffir/Simpson Hurricane Scale category
     */
    public int determineCategory(int knots)
    {
        // replace the following line with code
        // that determines the category from speed
        return 0;
    }

    //Getters

    /**
     * Comment this method.
     */
    public String getName()
    {
        // replace the following line
        return "";
    }

    /**
     * Comment this method.
     */
    public String getMonth()
    {
        // replace the following line
        return "";
    }

    /**
     * Comment this method.
     */
    public int getPressure()
    {
        // replace the following line
        return 0;
    }

    /**
     * Comment this method.
     */
    public int getSpeed()
    {
        // replace the following line
        return 0;
    }

    /**
     * Comment this method.
     */
    public int getYear()
    {
        // replace the following line
        return 0;
    }

    /**
     * Comment this method.
     */
    public int getCategory()
    {
        // replace the following line
        return 0;
    }

    /**
     * Comment this method even though you did not write it.
     */
    public void print()
    {
        System.out.println(toString( ));
    }

    /**
     * Alter code a bit then comment this method even though you did not write it.
     */
    public String toString()
    {
        return "";
        //return String.format("%-4d %-5s %-15s %-5d %5d %5d ", 
        //       year, month, name, category, speed, pressure);
    }

    /**
     * Comment this method.
     */
    public int compareYearTo(Hurricane h)
    {
        // replace the following line
        return 0;
    }

    /**
     * Comment this method.
     */
    public int compareNameTo(Hurricane h)
    {
        // replace the following line
        return 0;
    }

    /**
     * Comment this method.
     */
    public int comparePressureTo(Hurricane h)
    {
        // replace the following line
        return 0;
    }

    /**
     * Comment this method.
     */
    public int compareSpeedTo(Hurricane h)
    {
        // replace the following line
        return 0;
    }

    /**
     * Comment this method.
     */
    public int compareCategoryTo(Hurricane h)
    {
        // replace the following line
        return 0;
    }
}
