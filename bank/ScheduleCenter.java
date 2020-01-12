import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ScheduleCenter extends Thread{
    private final static int MAXCOUNT = 10;
    private ArrayBlockingQueue<Waiter> waiters;
    private ArrayBlockingQueue<newGuest> newGuests;


    public ScheduleCenter(){

        this.waiters = new ArrayBlockingQueue<Waiter>(MAXCOUNT);
        for (int i=0;i<MAXCOUNT;i++){
            waiters.add(new Waiter());
        }

        this.newGuests = new ArrayBlockingQueue<>(MAXCOUNT);

    }

    public void produce(){
        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        this.newGuests.add(new newGuest());
    }

    public void consume(){
        try{
            Waiter waiter =  this.waiters.take();

            newGuest newGuest  = this.newGuests.take();

            System.out.println(waiter+"开始为"+newGuest+"服务");
            System.out.println("ScheduleCenter 类的consume");

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}