
public class Producer implements Runnable{
	private ScheduleCenter scheduleCenter;

    public Producer(ScheduleCenter scheduleCenter){
        this.scheduleCenter = scheduleCenter;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            scheduleCenter.produce();
        }

    }
}
