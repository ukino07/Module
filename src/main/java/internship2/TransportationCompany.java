package internship2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by u_kino07 on 2018. 6. 12..
 */
public class TransportationCompany {
    private int timeDeliveryAvailable = Time.SIX_MONTH;
    private List<Ship> ships = new ArrayList<>();
    private Ship occupyDockKey = null;

    TransportationCompany(int numberShip) {
        ships = new ArrayList<>(numberShip);

        for (int i = 0; i < numberShip; i++) {
            this.ships.add(new Ship());
        }
    }

    private void spendTime(int time) {
        if (this.timeDeliveryAvailable - time <= 0) {
            return;
        }

        this.timeDeliveryAvailable -= time;
    }

    public Ship getOccupyDockKey() {
        return occupyDockKey;
    }

    public void setOccupyDockKey(Ship occupyDockKey) {
        this.occupyDockKey = occupyDockKey;
    }

    public List<Ship> getShips() {
        return this.ships;
    }

    public int getTotalNumberItemDelivered(int numberShip) {
        List<Ship> activeShips = new ArrayList<>();
        for (int i = 0; i < numberShip; i++) {
            ships.get(i).run(this);
            activeShips.add(i, ships.get(i));
        }

        boolean isAllFinish = false;
        while(isAllFinish) {
            isAllFinish = activeShips.stream()
                    .filter(ship -> ! ship.isFinish())
                    .collect(Collectors.toList()).size() == 0;
        }

        int totalNumberItemDelivered = 0;

        for (Ship ship : activeShips) {
            totalNumberItemDelivered += ship.getHowManyDelivered();
        }

        return totalNumberItemDelivered;
    }
}
