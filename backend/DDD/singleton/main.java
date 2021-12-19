package backend.DDD.singleton;

public class main {
    
    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(
                ()->{
                    System.out.println();
                    Demo1.getIntance().name();
                    Demo2.INSTANCE.m();
                }
                )
            .start();
        }
        
    }
}
