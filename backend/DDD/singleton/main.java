package backend.DDD.singleton;

public class main {
    
    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(
                ()->{
                    System.out.println();
                    demo1.getIntance().name();
                    demo2.INSTANCE.m();
                }
                )
            .start();
        }
        
    }
}
