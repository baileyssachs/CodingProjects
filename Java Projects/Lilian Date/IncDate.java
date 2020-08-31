
/**
 * Write a description of class IncDate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IncDate extends Date
{
    public IncDate(int newMonth, int newDay, int newYear)
    {
        super(newMonth, newDay, newYear);

    }

    public void increment(){

        int M = 30;
        boolean leap = false;
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
        {
            leap = true;
        }

        if ((month > 7) && (month < 13) && (month % 2 == 0))
            M = 31;
        else if ((month < 8)&& (month > 0) && (month % 2 != 0))
            M = 31;
        else if ((month == 2) && (!(leap)))
            M = 28;
        else if ((month == 2) && (leap))
            M = 29;

        day++;
        if (day > M){
            month++;
            day = 1;
            if (month > 12){
                year++;
                month =1;
            }
        }
        

    }

    public void increment(int numDays){

      for(int i = 0; i < numDays; i++)
      {
          increment();
        }
    }
}