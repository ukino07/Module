package internship1;

/**
 * Created by u_kino07 on 2018. 6. 5..
 */
public class Timer {
    public static final int MINUTE = 1;
    private int minutes;

    public Timer(int limitMinutes) {
        this.minutes = limitMinutes;
    }

    public void spendMinutes(int minutes) throws Exception {
        if (this.minutes - minutes < 1) {
            throw new Exception("Time Over");
        }

        this.minutes -= minutes;
    }

    public int getRemainingMinutes() {
        return this.minutes;
    }
}
