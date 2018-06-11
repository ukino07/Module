package internship1;

import java.util.List;

/**
 * Created by u_kino07 on 2018. 6. 5..
 */
public class DistributionCenter {
    private ItemLoader itemLoader = new ItemLoader();
    private ItemCounter itemCounter;
    private int limitMinutes;
    private List<Vehicle> vehicles;

    public DistributionCenter(int destinationCount, int limitMinute) {
        this.itemCounter = new ItemCounter(destinationCount);
        this.limitMinutes = limitMinutes;
    }

    public void setVehicles(int vehicleCount) {
        for (int i = 0; i < vehicleCount; i++) {
            vehicles.add(new Vehicle(20, 20 * Timer.MINUTE, 10 * Timer.MINUTE, 30 * Timer.MINUTE, itemCounter, new Timer(limitMinutes)));
        }
    }

//    public int getResult() throws Exception {
//        if (vehicles == null || vehicles.size() < 1) {
//            return 0;
//        }
//
//        for (int i = 0; i < vehicles.size(); i += 2) {
//            itemLoader.loadItem(vehicles.get(i).getItemCountPerCycle());
//            vehicles.get(i).setFinishLoadingItem(true);
//            vehicles.get(i).doOneCycle();
//            itemLoader.loadItem(vehicles.get(i + 1).getItemCountPerCycle());
//            vehicles.get(i + 1).setFinishLoadingItem(true);
//            vehicles.get(i + 1).doOneCycle();
//        }
//
//
//        for (Vehicle vehicle : vehicles) {
//            itemLoader.loadItem(vehicle.getItemCountPerCycle());
//            vehicle.work();
//        }
//
//    }

}
