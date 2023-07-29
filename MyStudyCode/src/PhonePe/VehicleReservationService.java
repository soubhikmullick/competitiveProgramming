package PhonePe;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class VehicleReservationService {
    public Map<String, Branch> getBranchList() {
        return branchList;
    }

    private Map<String, Branch> branchList = new HashMap<>();

    public Branch getCheapestBranch(VehicleType vehicleType) {
        AtomicReference<Branch> brancha = new AtomicReference<>();
        AtomicReference<BigDecimal> smallest = new AtomicReference<>();
        branchList.forEach((branchName, branch) -> {
            if(smallest.get()==null) {
                smallest.set(branch.getVehiclePricingMap().get(vehicleType).getValue());
                brancha.set(branch);
            }
            if(smallest.get().compareTo(branch.getVehiclePricingMap().get(vehicleType).getValue()) > 0) {
                smallest.set(branch.getVehiclePricingMap().get(vehicleType).getValue());
                brancha.set(branch);
            }
        });
        return brancha.get();
    }

    public void addBranch(String branchName) {
        Branch branch = new Branch(branchName);
        branchList.put(branchName, branch);
    }

    public void allocatePrice(String branchName, VehicleType vehicleType, BigDecimal price) throws Exception {
        Branch branch = branchList.get(branchName);
        if(!branch.getVehicleMap().containsKey(vehicleType.name())) {
            throw new Exception("Vehicle Type Does Not Exist");
        }
        branch.getVehiclePricingMap().put(vehicleType, new PricingInfo(CurrencyUnit.RS, price));
    }

    public void addVehicle(Long vehicleId, VehicleType vehicleType, String branchName) {
        Branch branch = branchList.get(branchName);
        branch.getVehicleMap().put(vehicleType.name(), new Vehicle(vehicleId, vehicleType));
    }

    public String bookVehicle(VehicleType vehicleType, Timestamp startTime, Timestamp endTime) {
        AtomicReference<String> result= new AtomicReference<>("");
        Branch branch = getCheapestBranch(vehicleType);
        String branchName = branch.getBranchName();
        for (Map.Entry<String, Vehicle> e : branch.getVehicleMap().entrySet()) {
            Vehicle vehicle = e.getValue();
            if (vehicle.getVehicleType().equals(vehicleType)) {
                Optional<Map<Timestamp, Timestamp>> vehiclesEligible = vehicle.getBlockedTimes().stream().filter(timestampMap -> {
                    for (Map.Entry<Timestamp, Timestamp> entry : timestampMap.entrySet()) {
                        if ((startTime.before(entry.getKey()) && endTime.before(entry.getKey()))
                                || (startTime.after(entry.getValue()) && endTime.after(entry.getValue()))) {
                            return true;
                        }
                    }
                    return false;
                }).findFirst();
                if (vehiclesEligible.isPresent() || vehicle.getBlockedTimes().isEmpty()) {
                    Map<Timestamp, Timestamp> map = new HashMap<>();
                    map.put(startTime, endTime);
                    vehicle.getBlockedTimes().add(map);
                    result.set("Success on Branch"+branchName);
                }
            }
        }
        return result.get();
    }
}
