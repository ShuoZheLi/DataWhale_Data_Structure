public class Waiter {
    private final int id = counter++;
    private static  int counter = 1;

    public String toString(){
        if(id>9)
            return "第 "+id+" 号窗口";
        else
            return "第 0"+id+" 号窗口";
    }
}