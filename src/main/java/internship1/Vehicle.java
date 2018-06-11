package internship1;

/**
 * Created by u_kino07 on 2018. 6. 5..
 */
public class Vehicle {
    private int itemCountPerCycle;
    private int minutesMoveToFirstDestination;
    private int minutesMoveToNextDestination;
    private int minutesReturnToDistributionCenter;
    private ItemCounter itemCounter;
    private Timer timer;
    private boolean finishLoadingItem;

    public Vehicle(int itemCountPerCycle, int minutesMoveToFirstDestination,
                   int minutesMoveToNextDestination, int minutesReturnToDistributionCenter,
                   ItemCounter itemCounter, Timer timer) {
        this.itemCountPerCycle = itemCountPerCycle;
        this.minutesMoveToFirstDestination = minutesMoveToFirstDestination;
        this.minutesMoveToNextDestination = minutesMoveToNextDestination;
        this.minutesReturnToDistributionCenter = minutesReturnToDistributionCenter;
        this.itemCounter = itemCounter;
        this.timer = timer;
    }

    public int getItemCountPerCycle() {
        return this.itemCountPerCycle;
    }

    public boolean isFinishLoadingItem() {
        return finishLoadingItem;
    }

    public void setFinishLoadingItem(boolean finishLoadingItem) {
        this.finishLoadingItem = finishLoadingItem;
    }

    private void moveToFirstDestination() throws Exception {
        if (this.timer.getRemainingMinutes() < minutesMoveToFirstDestination + this.minutesReturnToDistributionCenter) {
            this.timer.spendMinutes(minutesReturnToDistributionCenter);
            return;
        }

        this.timer.spendMinutes(minutesMoveToFirstDestination);
        deliveryItem();
    }

    private void moveToNextDestination() throws Exception {
        if (this.timer.getRemainingMinutes() < minutesMoveToNextDestination + this.minutesReturnToDistributionCenter) {
            this.timer.spendMinutes(minutesReturnToDistributionCenter);
            return;
        }

        this.timer.spendMinutes(minutesMoveToNextDestination);
        deliveryItem();
    }

    private void returnToDistributionCenter() throws Exception {
        this.timer.spendMinutes(minutesReturnToDistributionCenter);
        itemCountPerCycle += 5;
        minutesReturnToDistributionCenter--;
        this.finishLoadingItem = false;
    }

    public void doOneCycle() throws Exception {
        moveToFirstDestination();
        moveToNextDestination();
        returnToDistributionCenter();
    }

    private void deliveryItem() throws Exception {
        this.itemCounter.takeOut();
    }

    public void wait(int minutes) throws Exception {
        this.timer.spendMinutes(minutes);
    }
}
