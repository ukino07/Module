package internship2;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by u_kino07 on 2018. 6. 12..
 */
public class TransportationCompany {
    private int timeDeliveryAvailable = Time.SIX_MONTH;
    private List<Ship> ships = new ArrayList<>();

    TransportationCompany(int numberShip) {
        ships = new ArrayList<>(numberShip);
    }

    private void spendTime(int time) {
        if (this.timeDeliveryAvailable - time <= 0) {
            return;
        }

        this.timeDeliveryAvailable -= time;
    }

    public List<Ship> getShips() {
        return this.ships;
    }

    public int getTotalNumberItemDelivered(int numberShip) {
        for (int i = 0; i < numberShip; i++) {
            this.ships.add(new Ship());
        }

        for (Ship ship : ships) {
            while(! ship.isFinish()) {
                ship.loadItems();
            }
        }

        int totalNumberItemDelivered = 0;

        for (Ship ship : ships) {
            totalNumberItemDelivered += ship.getHowManyDelivered();
        }

        return totalNumberItemDelivered;
    }

    public static void main(String[] args) {
        TransportationCompany company = new TransportationCompany(20);
        List<Ship> ships = company.getShips();

        if (CollectionUtils.isEmpty(ships)) {
            return;
        }

//        for (Ship ship : ships) {
//            ships.run();
//        }

    }
}
