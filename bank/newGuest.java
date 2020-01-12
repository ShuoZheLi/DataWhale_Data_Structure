
public class newGuest {

	private ScheduleCenter scheduleCenter;

    
    public newGuest(ScheduleCenter scheduleCenter){
        this.scheduleCenter = scheduleCenter;
    }
    
    public void run() {
        while (!Thread.interrupted()){
            scheduleCenter.consume();
        }
    }

}
