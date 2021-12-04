package FinalProject.src.main.java.utils;

public class BenchMark {
    public static long StartTime() {
        long startTime = System.nanoTime();
        return startTime;
    }
    public static long EndTime() {
        long endTime = System.nanoTime();
        return endTime;
    }
    public static double toMillisecs(long ticks) {

        double ms = (double) ticks;
        ms/=1000000;

        return ms;

    }

}
