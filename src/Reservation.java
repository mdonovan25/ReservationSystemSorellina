import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {

    private String name;
    private int nPeople;
    private long timePlaced;
    private long timeFor;
    private String date;
    private boolean waitlisted;
    private String timeForString;
    private String timePlacedString;


    public Reservation(){
        nPeople = (int) (Math.random()*10+1);
        timePlaced = new Date().getTime() + (int)(Math.random()*1000000);
        timeFor = new Date().getTime() + (int)(Math.random()*10000000);
        timeStuff();


 //       System.out.println(timeFor);
    }

    public void timeStuff(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd k:mm");

 //       DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd k:mm");




        long now = new Date().getTime();
        System.out.println(now);
        String timeString = dateFormat.format(now);
        System.out.println(timeString);

        long future = new Date().getTime() + (int)(Math.random()*100000000);
        String futureString = dateFormat.format(future);
        System.out.println(futureString);
        System.out.println(future > now);

        String min = "15:00:00";
        String max = "23:00:00";
        timeForString = dateFormat.format(timeFor);
       timePlacedString = dateFormat.format(timePlaced);

//        try {
//            DateFormat dateFormat = new SimpleDateFormat ("HH:mm:ss");
//
//            Date date = new Date();
//
//            String hour1 = min;
//            String hour2 = max;
//            String newHour = dateFormat.format(date);
//
//            Date minHour, maxHour, nowHour;
//            minHour = dateFormat.parse(hora1);
//            maxHour = dateFormat.parse(hora2);
//            nowHour = dateFormat.parse(newHour );
//
//            if ((minHour.compareTo(nowHour) <= 0) && (maxHour.compareTo(nowHour) >= 0)){
//                return true;
//            } else {
//                return false;
//            }
//        } catch (ParseException parseException){
//            parseException.printStackTrace();
//            return false;
//        }

  //      try{
  //          DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
   //         Date minHour = timeFormat.parse(min);
  //          System.out.println("min time: "+minHour);
   //         Date maxHour = timeFormat.parse(max);
   //         future = new Date().getTime()+(int)(Math.random()*100000000);
    //        String future
    //    }

        System.out.println("\n\n\n\n\n\n\n");
    }

    public int getNPeople(){
        return nPeople;
    }
    public long getTimePlaced() {
        return timePlaced;
    }
    public String getTimePlacedString(){return timePlacedString;}
    public long getTimeFor(){
        return timeFor;
    }
    public String getTimeForString() {return timeForString;}

    public void printInfo(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd k:mm");

        timeForString = dateFormat.format(timeFor);
        timePlacedString = dateFormat.format(timePlaced);


        System.out.println("Reservation for " + nPeople +
                " for " + timeForString +
                " made at " + timePlacedString);
    }

    public String getInfo(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd k:mm");

        timeForString = dateFormat.format(timeFor);
        timePlacedString = dateFormat.format(timePlaced);


        return ("Reservation for " + nPeople +
                " for " + timeForString +
                " made at " + timePlacedString);
    }





}


