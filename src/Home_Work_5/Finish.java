package Home_Work_5;

public class Finish implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (Exception e) {
        }
    }
}
