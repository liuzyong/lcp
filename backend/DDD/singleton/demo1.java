package backend.DDD.singleton;
public class Demo1{

    private Demo1(){}
    private static class holder{
        private final static Demo1 INSTANCE = new Demo1();
    }
    public static Demo1 getIntance(){
        return holder.INSTANCE;
    }

    public void name() {
        System.out.println("call me ");
        
    }


}