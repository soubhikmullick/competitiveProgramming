package PhonePe;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Vehicle {
    private Long vehicleId;
    private VehicleType vehicleType;
    private List<Map<Timestamp, Timestamp>> blockedTimes;

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle(Long vehicleId, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.blockedTimes = new ArrayList<>();
    }

    public List<Map<Timestamp, Timestamp>> getBlockedTimes() {
        return blockedTimes;
    }

    public void setBlockedTimes(List<Map<Timestamp, Timestamp>> blockedTimes) {
        this.blockedTimes = blockedTimes;
    }
}
