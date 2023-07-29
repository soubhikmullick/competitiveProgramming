package PhonePe;

import java.util.HashMap;
import java.util.Map;

public class Branch {
    private String branchName;
    private Map<String, Vehicle> vehicleMap;
    private Map<VehicleType, PricingInfo> vehiclePricingMap;

    public Branch() {

    }

    public Map<String, Vehicle> getVehicleMap() {
        return vehicleMap;
    }

    public void setVehicleMap(Map<String, Vehicle> vehicleMap) {
        this.vehicleMap = vehicleMap;
    }

    public Map<VehicleType, PricingInfo> getVehiclePricingMap() {
        return vehiclePricingMap;
    }

    public void setVehiclePricingMap(Map<VehicleType, PricingInfo> vehiclePricingMap) {
        this.vehiclePricingMap = vehiclePricingMap;
    }
    public Branch(String branchName) {
        this.branchName = branchName;
        this.vehicleMap = new HashMap<>();
        this.vehiclePricingMap = new HashMap<>();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }


}
