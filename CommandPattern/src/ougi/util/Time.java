package ougi.util;

import java.util.concurrent.TimeUnit;

public class Time {


    private static final long startedTime = System.nanoTime();
    private static double lastFrameRate = 0;


    public static double getTime() {
        return (System.nanoTime() - Time.startedTime) * 1E-9;
    }

    public static double getDeltaTime() {
        double time = Time.getTime();
        double deltaTime = time - Time.lastFrameRate;
        Time.lastFrameRate = time;
        return deltaTime;
    }

    public static void sleep(long timeInMillis) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(timeInMillis);
    }

}
