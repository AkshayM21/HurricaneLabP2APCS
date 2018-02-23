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
    private int year;
    private String month;
    private int pressure;
    private int speed;
    private String name;

    /**
     * Initializes a Hurricane object with no information.
     */
    public Hurricane()
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
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.speed = speed;
        this.name = name;
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
        if (knots>=137)
            return 5;
        else if (knots>=113)
            return 4;
        else if (knots>=96)
            return 3;
        else if (knots>=83)
            return 2;
        else if (knots>=64)
            return 1;
        return 0;
    }

    /**
     * @return name of the hurricane
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return month of the hurricane
     */
    public String getMonth()
    {
        return month;
    }

    /**
     * @return pressure of the hurricane
     */
    public int getPressure()
    {
        return pressure;
    }

    /**
     * @return speed of the hurricane
     */
    public int getSpeed()
    {
        return speed;
    }

    /**
     * @return year of the hurricane
     */
    public int getYear()
    {
        return year;
    }

    /**
     * @return the category of the hurricane
     */
    public int getCategory()
    {
        return determineCategory(speed);
    }

    /**
     * prints the hurricane
     */
    public void print()
    {
        System.out.println(toString( ));
    }

    /**
     * @return String version of the hurricane
     */
    public String toString()
    {
        return String.format("%-4d %-5s %-15s %-5d %5d %5d ", 
               year, month, name, determineCategory(speed), speed, pressure);
    }

    /**
     * @return 1 if this hurricane's year is more recent than the one it is being compared to
     *          0 if they are equal
     *          -1 if this one's year is less
     * @param h the hurricane you want to compare the current hurricane to
     */
    public int compareYearTo(Hurricane h)
    {
        return ((Comparable)this.year).compareTo((Comparable)(h.year));
    }

    /**
     * @return 1 if this hurricane's name is later in the alphabet than the one it is being compared to
     *          0 if they are equal
     *          -1 if this one's name is earlier
     * @param h the hurricane you want to compare the current hurricane to
     */
    public int compareNameTo(Hurricane h)
    {
        return ((Comparable)this.name).compareTo((Comparable)(h.name));
    }

    /**
     * @return 1 if this hurricane's pressure is greater than the one it is being compared to
     *          0 if they are equal
     *          -1 if this one's pressure is less
     * @param h the hurricane you want to compare the current hurricane to
     */
    public int comparePressureTo(Hurricane h)
    {
        return ((Comparable)this.pressure).compareTo((Comparable)(h.pressure));
    }

    /**
     * @return 1 if this hurricane's speed is greater than the one it is being compared to
     *          0 if they are equal
     *          -1 if this one's speed is less
     * @param h the hurricane you want to compare the current hurricane to
     */
    public int compareSpeedTo(Hurricane h)
    {
        return ((Comparable)this.speed).compareTo((Comparable)(h.speed));
    }

    /**
     * @return 1 if this hurricane's category is greater than the one it is being compared to
     *          0 if they are equal
     *          -1 if this one's category is less
     * @param h the hurricane you want to compare the current hurricane to
     */
    public int compareCategoryTo(Hurricane h)
    {
        return ((Comparable)this.determineCategory(this.speed)).compareTo((Comparable)(h.determineCategory(h.speed)));
    }
}
