package soccerLeague;

import java.util.Calendar;
import java.util.HashMap;

public class Month
{
  private int mon;
  private int yr;
  private int dy[][];
  private int schedule[][];
  private int numoweeks;
  private static HashMap months = new HashMap();

  private Month()
  {
	  
  }

  private Month(int month, int year)
  {
    dy = new int[6][7];
    numoweeks = 0;
    this.mon = month;
    this.yr = year;
    buildw();
  }

  public int getMonth()
  {
    return mon;
  }

  public static Month getMonth(int month, int year)
  {
    String key = String.valueOf((new StringBuffer(String.valueOf(month))).append("/").append(year));
    if (months.containsKey(key))
    {
      return (Month) months.get(key);
    }
    else
    {
      Month newMonth = new Month(month, year);
      months.put(key, newMonth);
      return newMonth;
    }
  }

  private void buildw()
  {
    Calendar c = Calendar.getInstance();
    c.setFirstDayOfWeek(1);
    c.set(yr, mon, 1);
    for (; c.get(2) == mon; c.add(5, 1))
    {
      int weekNumber = c.get(4) - 1;
      int dayOfWeek = calcDay(c.get(7));
      dy[weekNumber][dayOfWeek] = c.get(5);
      numoweeks = weekNumber;
    }
  }

  public int calcDay(int day)
  {
    if (day == 1)
      return 0;
    if (day == 2)
      return 1;
    if (day == 3)
      return 2;
    if (day == 4)
      return 3;
    if (day == 5)
      return 4;
    if (day == 6)
      return 5;
    return day != 7 ? 7 : 6;
  }

  public int[][] getDays()
  {
    return dy;
  }

  public int getnofweeks()
  {
    return numoweeks + 1;
  }

  public int getYear()
  {
    return yr;
  }

}