public class Waiter {
    private final int id = counter++;
    private static  int counter = 1;

    public String toString(){
        if(id>9)
            return "�� "+id+" �Ŵ���";
        else
            return "�� 0"+id+" �Ŵ���";
    }
}