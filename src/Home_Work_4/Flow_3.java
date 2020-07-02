package Home_Work_4;

public class Flow_3 {
    private final Object mon = new Object();
    private boolean aTurn = true, bTurn = true;
    private volatile int currentLetter = 1;

    public static void main(String[] args) {
        Flow_3 w = new Flow_3();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    w.printA();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    w.printB();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    w.printC();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();

    }

    public void printA() {
        synchronized (mon) {
            try {

                if (currentLetter != 1) {
                    mon.wait();
                }
                if (currentLetter == 1){
                System.out.print("A");
                currentLetter = 2;
                mon.notify();}

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {

                if (currentLetter != 2 ) {
                    mon.wait();
                }
                if (currentLetter == 2){
                System.out.print("B");
                currentLetter = 3;
                mon.notify();}

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (mon) {
            try {

                if (currentLetter != 3 ) {
                    mon.wait();
                }
                if (currentLetter == 3){
                System.out.print("C");
                currentLetter = 1;
                mon.notify();}

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
