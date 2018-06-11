package internship1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by u_kino07 on 2018. 6. 6..
 */
public class ResultTeller {
    private static final int DESTINATION_COUNT = 4000;
    private static final String RESULT_KEY = "data";
    private static final String VEHICLE_UNIT = "대";
    private static final String ITEM_UNIT = "개";

    private Map<String, String> cases = new HashMap<>();
    private int vehicleCount = 0;

//    private List<Vehicle> vehicles = new ArrayList<>();
//    private Timer timer = new Timer(24 * 60 * Timer.MINUTE);
//    private DistributionCenter center = new DistributionCenter(DESTINATION_COUNT, timer, vehicles);
//
//    public List<Vehicle> getVehicles(int count) {
//        for (int i = 0; i < count; i++) {
//            vehicles.add(new Vehicle(20, 20 * Timer.MINUTE, 10 * Timer.MINUTE, 30 * Timer.MINUTE));
//        }
//        return vehicles;
//    }

//    public void addCase() {
//        vehicleCount++;
//        cases.put(vehicleCount + VEHICLE_UNIT, getDeliveryCount(vehicleCount) + ITEM_UNIT);
//    }
//
//    public int getDeliveryCount(int vehicleCount) {
//
//    }

    public Map<String, Map<String, String>> getResult() {
        Map<String, Map<String, String>> result = new HashMap<>();
        result.put(RESULT_KEY, this.cases);
        return result;
    }
}
