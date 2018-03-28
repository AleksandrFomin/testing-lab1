import Task3.*;

public class Main {
    public static void main(String[] args) {
        Remark remark = new Remark();
        remark.setMessage("remark");
        You you = new You();
        FordPrefect fordPrefect = new FordPrefect(remark);
        if(you.getState().equals(fordPrefect.getState())){
            System.out.println("Feelings are almost identical");
        }else{
            System.out.println("Feelings are not identical");
        }
    }
}
