package backend.DDD.singleton;
public class demo1{

    private demo1(){}
    private static class holder{
        private final static demo1 INSTANCE = new demo1();
    }
    public static demo1 getIntance(){
        return holder.INSTANCE;
    }

    public void name() {
        System.out.println("call me ");
        
    }


}