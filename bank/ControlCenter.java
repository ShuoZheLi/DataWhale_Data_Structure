import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ControlCenter {

	public static void main(String[] args) {
		ScheduleCenter scheduleCenter = new ScheduleCenter();
        ExecutorService exec = Executors.newFixedThreadPool(20);
        Producer producer = new Producer(scheduleCenter);
        newGuest consumer = new newGuest(scheduleCenter);

        exec.execute(producer);

        for (int i=0;i<10;i++){
            exec.execute((Runnable) consumer);
        }
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        exec.shutdown();

	}

}
