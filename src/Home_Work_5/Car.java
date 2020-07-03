package Home_Work_5;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import static Home_Work_5.MainClass.*;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private volatile static  int  state = 0;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            START.countDown();
            START.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                BARRIER.await();   // Ожидание готовности и старт гонки
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                for (int i = 0; i < race.getStages().size(); i++) {
                    race.getStages().get(i).go(this);
                   if (state == 1){
                       System.out.println(this.name + " win");
                   }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                try {
                    state++;
                    FINISH.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


        }
    }
}

