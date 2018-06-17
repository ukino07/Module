package internship2;

/**
 * Created by u_kino07 on 2018. 6. 12..
 */
public class Ship {
    private static final int INIT_NUMBER_ITEM_LOADABLE = 500 * Count.ITEM;
    private static final int TIME_RETURN_TO_HOMEPORT = 3 * Time.HOUR;

    private int timeDeliveryAvailable = 200 * Time.HOUR;
    private int numberItemLoadable = INIT_NUMBER_ITEM_LOADABLE;
    private int round = 0;
    private boolean finish = false;
    private int howManyDelivered = 0;

    private int getTimeLoadItems(int numberItem) {
        return numberItem * (10 * Time.MINUTE) / (50 * Count.ITEM);
    }

    private void spendTime(int time, boolean checkReturnToHomePort) {
        if (checkReturnToHomePort && (this.timeDeliveryAvailable - time < TIME_RETURN_TO_HOMEPORT)) {
            returnToHomePort();
            this.finish = true;
            return;
        }

        if ((! checkReturnToHomePort) && (this.timeDeliveryAvailable - time <= 0)) {
            this.finish = true;
            return;
        }

        this.timeDeliveryAvailable -= time;
    }

    public boolean isFinish() {
        return this.finish;
    }

    public int getHowManyDelivered() {
        return this.howManyDelivered;
    }

    public void run(TransportationCompany company) {
        while(! this.finish) {
            makeReady();
            loadItems(company);
            moveToFirstDestination();
            deliver();
            while(! this.finish && this.numberItemLoadable > 0) {
                setTimeMoveToNextDestination();
                deliver();
            }
            returnToHomePort();
        }
    }

    // 정박 시설 차지
    private void occupyDock(TransportationCompany company) {
        company.setOccupyDockKey(this);
    }

    // 정비
    private void makeReady() {
        if (this.round < 1) {
            return;
        }
        spendTime(10 * Time.HOUR, false);
    }

    // 상품 실음
    private void loadItems(TransportationCompany company) {
        if (company.getOccupyDockKey() == null) {
            occupyDock(company);
        }

        while(! company.getOccupyDockKey().equals(this)) {
            wait(getTimeLoadItems(company.getOccupyDockKey().numberItemLoadable));
        }

        this.numberItemLoadable = INIT_NUMBER_ITEM_LOADABLE + 50 * Count.ITEM * this.round;
        spendTime(getTimeLoadItems(this.numberItemLoadable), false);
        company.setOccupyDockKey(null);
    }

    // 대기
    private void wait(int time) {
        spendTime(time, false);
    }

    // 배송
    private void deliver() {
        this.numberItemLoadable -= 10 * Count.ITEM;
        this.howManyDelivered += 10 * Count.ITEM;
    }

    // 첫 배송지 이동
    private void moveToFirstDestination() {
        spendTime(2 * Time.HOUR, true);
    }

    // 다음 배송지 이동
    private void setTimeMoveToNextDestination() {
        spendTime(Time.HOUR * (this.round + 1), true);
    }

    // 마지막 배송지에서 모항으로 돌아옴
    private void returnToHomePort() {
        spendTime(3 * Time.HOUR, false);

        if (this.numberItemLoadable < 1) {
            this.timeDeliveryAvailable += 30 * Time.HOUR;
            this.round++;
        }
    }

    @Override
    public String toString() {
        return "Ship{" +
                "timeDeliveryAvailable=" + timeDeliveryAvailable +
                ", numberItemLoadable=" + numberItemLoadable +
                ", round=" + round +
                ", finish=" + finish +
                ", howManyDelivered=" + howManyDelivered +
                '}';
    }
}
