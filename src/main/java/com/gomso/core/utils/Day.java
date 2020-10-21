package com.gomso.core.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Stores dates and perform date arithmetic.
 * 
 * This is another date class, but more convenient that <tt>java.util.Date</tt>
 * or <tt>java.util.Calendar</tt>
 * 
 * @version 1.20 5 Oct 1998
 * @author Cay Horstmann
 */

public class Day implements Cloneable, Serializable {
    private static final long serialVersionUID = -7138721553446434610L;

	public static int SUNDAY = 1;

    public static int MONDAY = 2;

    public static int TUESDAY = 3;

    public static int WEDNESDAY = 4;

    public static int THURSDAY = 5;

    public static int FRIDAY = 6;

    public static int SATURDAY = 7;

    /** @serial */
    private int day;

    /** @serial */
    private int month;

    /** @serial */
    private int year;
    
    private int hour;
    
    private int minute;
    
    private int second;
    
    private TimeZone timeZone;

    /**
     * Constructs today's date
     */
    public Day() {
        createDateFactorsByGivenMilliSecond(0, null);
    }
    
    /**
     * Constructs a specific date
     * 
     * @param yyyy
     *            year (full year, e.g., 1996, <i>not</i> starting from 1900)
     * @param m
     *            month
     * @param d
     *            day
     * @exception IllegalArgumentException
     *                if yyyy m d not a valid date
     */
    public Day(int yyyy, int m, int d, TimeZone zone) {
        if(zone != null) {
            this.timeZone = zone;
        } else {
            this.timeZone = TimeZone.getDefault();
        }
        this.year = yyyy;
        this.month = m;
        this.day = d;
        if (!isValid()) {
            throw new IllegalArgumentException
            ("Not valid Date(yyyyMMdd) : " + year + ", " + month + ", " + day);
        }
    }

    /**
     * Constructs a specific date & time
     *
     */
    public Day(int yyyy, int MM, int dd, int hh, int mm, int SS, TimeZone zone) {
        this(yyyy, MM, dd, zone);

        this.hour = hh;
        this.minute = mm;
        this.second = SS;
        
        if ( hh<0 || hh>24 || mm<0 || mm>59 || SS<0 || SS>60 ) {
            throw new IllegalArgumentException
            ("Not valid Date(yyyyMMdd) : " + year + ", " + month + ", " + day);
        }
    }
    
    public Day(TimeZone timeZone) {
        createDateFactorsByGivenMilliSecond(0, timeZone);
    }

    public Day(long milliSeconds) {
        createDateFactorsByGivenMilliSecond(milliSeconds, null);
    }

    public Day(long milliSeconds, TimeZone timeZone) {
        createDateFactorsByGivenMilliSecond(milliSeconds, timeZone);
    }

    public Day(String dateString, String givenFormat) throws ParseException {
    	DateFormat format = new SimpleDateFormat(givenFormat);
    	Date date = format.parse(dateString);
    	createDateFactorsByGivenMilliSecond(date.getTime(), null);
	}

	private void createDateFactorsByGivenMilliSecond(long milliSeconds, TimeZone timeZone) {
        if( timeZone == null ) {
            this.timeZone = TimeZone.getDefault();
        } else {
            this.timeZone = timeZone;
        }
        
        GregorianCalendar todaysDate = new GregorianCalendar(this.timeZone);
        
        if( milliSeconds != 0 ) {
            todaysDate.setTimeInMillis(milliSeconds);
        }
        
        this.year = todaysDate.get(Calendar.YEAR);
        this.month = todaysDate.get(Calendar.MONTH) + 1;
        this.day = todaysDate.get(Calendar.DAY_OF_MONTH);
        this.hour = todaysDate.get(Calendar.HOUR_OF_DAY);
        this.minute = todaysDate.get(Calendar.MINUTE);
        this.second = todaysDate.get(Calendar.SECOND);
    }


    /**
     * Advances this day by n days. For example. d.advance(30) adds thirdy days
     * to d
     * 
     * @param n
     *            the number of days by which to change this day (can be < 0)
     */

    public void advance(int n) {
        fromJulian(toJulian() + n);
    }

    /**
     * Gets the day of the month
     * 
     * @return the day of the month (1...31)
     */

    public int getDay() {
        return day;
    }

    /**
     * Gets the month
     * 
     * @return the month (1...12)
     */

    public int getMonth()

    {
        return month;
    }

    /**
     * Gets the year
     * 
     * @return the year (counting from 0, <i>not</i> from 1900)
     */

    public int getYear() {
        return year;
    }

    /**
     * Gets the weekday
     * 
     * @return the weekday ({@link Day#SUNDAY}, ..., {@link Day#SATURDAY})
     */

    public int weekday() {
        return (toJulian() + 1) % 7 + 1;
    }

    /**
     * The number of days between this and day parameter
     * 
     * @param b
     *            any date
     * @return the number of days between this and day parameter and b (> 0 if
     *         this day comes after b)
     */

    public int daysBetween(Day b) {
        return toJulian() - b.toJulian();
    }

    
    /**
     * Makes a bitwise copy of a Day object
     * 
     * @return a bitwise copy of a Day object
     */

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) { // this shouldn't happen,
                                                    // since we are Cloneable
            return null;
        }
    }

    /**
     * Compares this Day against another object
     * 
     * @param obj
     *            another object
     * @return true if the other object is identical to this Day object
     */

    public boolean equals(Object obj) {
        if (!getClass().equals(obj.getClass()))
            return false;
        Day b = (Day) obj;
        return day == b.day && month == b.month && year == b.year;
    }

    /**
     * Computes the number of days between two dates
     * 
     * @return true iff this is a valid date
     */

    protected boolean isValid() {
        Day t = new Day();
        t.fromJulian(this.toJulian());
        return t.day == day && t.month == month && t.year == year;
    }

    /**
     * @return The Julian day number that begins at noon of this day Positive
     *         year signifies A.D., negative year B.C. Remember that the year
     *         after 1 B.C. was 1 A.D.
     * 
     * A convenient reference point is that May 23, 1968 noon is Julian day
     * 2440000.
     * 
     * Julian day 0 is a Monday.
     * 
     * This algorithm is from Press et al., Numerical Recipes in C, 2nd ed.,
     * Cambridge University Press 1992
     */

    private int toJulian() {
        int jy = year;
        if (year < 0)
            jy++;
        int jm = month;
        if (month > 2)
            jm++;
        else {
            jy--;
            jm += 13;
        }
        int jul = (int) (Math.floor(365.25 * jy)
                + Math.floor(30.6001 * jm) + day + 1720995.0);

        int IGREG = 15 + 31 * (10 + 12 * 1582);
        // Gregorian Calendar adopted Oct. 15, 1582

        if (day + 31 * (month + 12 * year) >= IGREG)
        // change over to Gregorian calendar
        {
            int ja = (int) (0.01 * jy);
            jul += 2 - ja + (int) (0.25 * ja);
        }
        return jul;
    }

    /**
     * Converts a Julian day to a calendar date
     * 
     * This algorithm is from Press et al., Numerical Recipes in C, 2nd ed.,
     * Cambridge University Press 1992
     * 
     * @param j
     *            the Julian date
     */

    private void fromJulian(int j) {
        int ja = j;

        int JGREG = 2299161;
        /*
         * the Julian date of the adoption of the Gregorian calendar
         */

        if (j >= JGREG)
        /*
         * cross-over to Gregorian Calendar produces this correction
         */
        {
            int jalpha = (int) (((float) (j - 1867216) - 0.25) / 36524.25);
            ja += 1 + jalpha - (int) (0.25 * jalpha);
        }
        int jb = ja + 1524;
        int jc = (int) (6680.0 + ((float) (jb - 2439870) - 122.1) / 365.25);
        int jd = (int) (365 * jc + (0.25 * jc));
        int je = (int) ((jb - jd) / 30.6001);
        day = jb - jd - (int) (30.6001 * je);
        month = je - 1;
        if (month > 12)
            month -= 12;
        year = jc - 4715;
        if (month > 2)
            --year;
        if (year <= 0)
            --year;
    }

    
    public String getTimeZoneID() {
        return this.timeZone.getID();
    }
    

    /**
     * A string representation of the day
     * 
     * @return a string representation of the day
     */
    public String toString() {
        StringBuffer string = new StringBuffer();
        string.append("[DAY OBJECT - " + timeZone.getID() + "] ")
        .append( year + "." + month + "." + day)
        .append( ". " + hour + ";" + minute + ":" + second);
        return string.toString();
        
//        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
//        return sdFormat.format(new java.util.Date(logStart));
    }
    
    /**
     * added by jazzVM
     */
    public String toString(String givenFormat) {
    	Date date = new Date( this.getTimeInMillis() );
		DateFormat output = new SimpleDateFormat(givenFormat);
		return output.format(date);
    }

    /**
     * added by jazzVM
     */
    public Date toDate() {
    	Date date = new Date( this.getTimeInMillis() );
    	return date;
    }

    
    /**
     * 0 ... 24
     * @return
     */
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
    
    public int getSecond() {
        return second;
    }
	
	public static String toStringAsyyyyMMdd( long millis ) {
		Date date = new Date( millis );
		return toString(date, "yyyyMMdd");
	}
    
    public static String toStringAsyyyyMMddHHmm( long millis ) {    	
    	Date date = new Date( millis );		
		return toString(date, "yyyyMMddHHmm");
    }
    public static String toStringAsyyyyMMddHHmmss( long millis ) {    	
    	Date date = new Date( millis );		
		return toString(date, "yyyyMMddHHmmss");
    }

    public long getTimeInMillis() {
        GregorianCalendar cal = new GregorianCalendar(this.timeZone);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        return cal.getTimeInMillis();
    }
    
    
    public static Date getDateWithTyphoonFormatString(String timestamp) {
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
    	Date date = null;
		try {
			date = formatter.parse(timestamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
    }
    
    public static Date getDateWithFormatString(String timestamp, String format) {
    	
    	SimpleDateFormat formatter = new SimpleDateFormat(format);
    	Date date = null;
		try {
			date = formatter.parse(timestamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
    }
    
    public static Date getCurrentDateWithFormatString(String format) {
    	
    	SimpleDateFormat formatter = new SimpleDateFormat(format);
    	Date date = null;
		try {
			date = formatter.parse( Day.toStringAsyyyyMMddHHmmss( System.currentTimeMillis() ) );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
    }
    
    public static Date getCurrentDate() {
    	
    	Date date = Calendar.getInstance().getTime();
    	date.setTime( System.currentTimeMillis() );
    	
		return date;
    }
    
    public static String now(){
    	return toStringAsyyyyMMddHHmmss( System.currentTimeMillis() );
    }
    
    public static String getCurrentTimestamp() {
    	return toStringAsyyyyMMddHHmm( System.currentTimeMillis() );
    }
    
    public static String getCurrentDateString() {
    	return toStringAsyyyyMMddHHmm( System.currentTimeMillis() ).substring(0, 8);
    }
    
    public static String getCurrentDateString(String format) {
    	SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format( Calendar.getInstance().getTime() );
    }
    
    public static String getCurrentDateWithFormatString() {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		return formatter.format( Calendar.getInstance().getTime() );
    }
    
    public static String convertFormattedString(String timestamp, String format) {
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
    	SimpleDateFormat formatter2 = new SimpleDateFormat(format);
    	Date date = null;
		try {
			date = formatter.parse(timestamp);
		} catch (ParseException e) {
			//e.printStackTrace();
		}
		if( date != null ) {
			return formatter2.format( date );
		} else {
			return "";
		}
		
    }
    
    public static String convertFormattedString(String timestamp, String oldFormat, String format) {
    	
    	SimpleDateFormat formatter = new SimpleDateFormat(oldFormat);
    	SimpleDateFormat formatter2 = new SimpleDateFormat(format);
    	Date date = null;
		try {
			date = formatter.parse(timestamp);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatter2.format( date );
    }

    public static long getMillisWithAppcubeFormatString(String timestamp) {
    	return getDateWithTyphoonFormatString(timestamp).getTime();
	}

    
    
    /**
     * the last day in the month where this day object belongs to
     * @return new Day object
     */
    public Day getMaxDayObject() {
        
        for( int i=31; i >= 28; i-- ) {
            try {
                return new Day(this.getYear(), this.getMonth(), i, null);
            } catch(IllegalArgumentException e) {}
        }

        throw new 
            IllegalArgumentException("can't be reachable to this line. MyDay.getMaxDayObject()");
    }
    
    @SuppressWarnings("deprecation")
	public static String addSeconds(String dateTime, int seconds) {
		
    	Date date = getDateWithTyphoonFormatString(dateTime);
    	date.setSeconds(date.getSeconds() + seconds);
    	
    	return Day.toStringAsyyyyMMddHHmmss(date.getTime());
		
	}
    
    @SuppressWarnings("deprecation")
	public static String addMinutes(String dateTime, int min) {
		
    	Date date = getDateWithTyphoonFormatString(dateTime);
    	date.setMinutes(date.getMinutes() + min);
    	
    	return Day.toStringAsyyyyMMddHHmmss(date.getTime());
		
	}
    
    public static Date toDate(String timestamp) {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    	Date date = null;
    	try {
			date = sdf.parse(timestamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
    }
    
    
    public static Date toDate(String timestamp, String format) {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	Date date = null;
    	try {
			date = sdf.parse(timestamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
    }
    
    public static String toString(Date date) {		
		return toString(date, "yyyyMMddHHmmss");
    }    
    
    public static String toString(Date date, String format) {    	
		DateFormat output = new SimpleDateFormat(format);
		return output.format(date);
    }
    
    public static String withoutFormatDate(String str) {
    	str = str.replaceAll("[.]", "");
    	str = str.replaceAll("-", "");
    	
    	if( str.indexOf("00000000") > -1 ) {
    		return "";
    	}
    	
    	return str;
    }
    
    public static String withoutFormatTime(String str) {
    	
    	str = str.replaceAll(":", "");
    	if( str.indexOf("000000") > -1 ) {
    		return "";
    	}
    	
    	return str;
    }
    
    public static String getFormattedTimestamp(Date date) {
    	return Day.convertFormattedString( Day.toStringAsyyyyMMddHHmmss(date.getTime()), "yyyy.MM.dd HH:mm:ss");
    }
    
    public static String getFormattedDate(Date date) {
    	return Day.convertFormattedString( Day.toStringAsyyyyMMddHHmmss(date.getTime()), "yyyy.MM.dd");
    }
    
    public static String getFormattedTimestamp(String timestamp) {
    	if( StringUtils.isEmpty(timestamp) )return "";
    	String result = "";
    	try {
    		result = Day.convertFormattedString( timestamp, "yyyy.MM.dd HH:mm:ss");
    	} catch( Exception e ) {
    		result = "";
    	}
    	return result;
    }
    
    
    
    public static String convertFormatedServerTimestamp(Map<String, Object> data) {
    	String serverTimestamp = (String)data.get("server_timestamp");
    	return Day.convertFormattedString(serverTimestamp, "yyyy.MM.dd HH:mm:ss");
    }
    

    
    
    public static long difference(Date startDate, Date endDate, int field)  {
    	
    	
    	long milliseconds1 = startDate.getTime();
    	long milliseconds2 = endDate.getTime();
    	
    	long diff = milliseconds2 - milliseconds1;
    	long diffSeconds = diff / 1000;
    	long diffMinutes = diff / (60 * 1000);
    	long diffHours = diff / (60 * 60 * 1000);
    	long diffDays = diff / (24 * 60 * 60 * 1000);
    	
    	if( Calendar.HOUR == field ) {
    		return diffHours;
    	} else if(Calendar.MINUTE == field) {
    		return diffMinutes;
    	} else if( Calendar.SECOND == field ) {
    		return diffSeconds;
    	} else {
    		return diffDays;
    	}
    	
    }

}
