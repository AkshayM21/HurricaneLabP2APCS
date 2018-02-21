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
     * Comment this method.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Comment this method.
     */
    public String getMonth()
    {
        return month;
    }

    /**
     * Comment this method.
     */
    public int getPressure()
    {
        return pressure;
    }

    /**
     * Comment this method.
     */
    public int getSpeed()
    {
        return speed;
    }

    /**
     * Comment this method.
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Comment this method.
     */
    public int getCategory()
    {
        return determineCategory(speed);
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
        return String.format("%-4d %-5s %-15s %-5d %5d %5d ", 
               year, month, name, determineCategory(speed), speed, pressure);
    }

    /**
     * Comment this method.
     */
    public int compareYearTo(Hurricane h)
    {
        return ((Comparable)this.year).compareTo((Comparable)(h.year));
    }

    /**
     * Comment this method.
     */
    public int compareNameTo(Hurricane h)
    {
        return ((Comparable)this.name).compareTo((Comparable)(h.name));
    }

    /**
     * Comment this method.
     */
    public int comparePressureTo(Hurricane h)
    {
        return ((Comparable)this.pressure).compareTo((Comparable)(h.pressure));
    }

    /**
     * Comment this method.
     */
    public int compareSpeedTo(Hurricane h)
    {
        return ((Comparable)this.speed).compareTo((Comparable)(h.speed));
    }

    /**
     * Comment this method.
     */
    public int compareCategoryTo(Hurricane h)
    {
        return ((Comparable)this.determineCategory(this.speed)).compareTo((Comparable)(h.determineCategory(h.speed)));
    }
}
