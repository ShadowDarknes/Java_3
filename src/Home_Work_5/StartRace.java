package Home_Work_5;

public  class StartRace implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (InterruptedException e) {
        }
    }
}
