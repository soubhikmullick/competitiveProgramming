package others;
import java.util.*;

class Vehicle {

    private String vehicleId;
    private VehicleType vehicleType;
    private String branchName;

    public Vehicle(String vehicleId, VehicleType vehicleType, String branchName) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.branchName = branchName;
    }

    public Vehicle (String vehicleId, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return this.vehicleId;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public String getBranchName() {
        return this.branchName;
    }

}

class VehicleHandler {
    private Map<String, Vehicle> vehicleHandlerMap;
    //availability concept TBD
    private List<List<String>> availabilityList;
    private static VehicleHandler vehicleHandler;

    static VehicleHandler getVehicleHandler() {
        if (vehicleHandler == null) {
            vehicleHandler = new VehicleHandler();
            vehicleHandler.vehicleHandlerMap = new HashMap<>();
            vehicleHandler.availabilityList = new ArrayList<>();

            for (int i = 0; i < 24; i++) {
                vehicleHandler.availabilityList.add(new ArrayList<>());
            }
        }
        return vehicleHandler;
    }

    public void addVehicle(String vehicleId, VehicleType vehicleType, String branchName) {
        Vehicle vehicle = new Vehicle(vehicleId, vehicleType, branchName);
        vehicleHandlerMap.put(vehicleId, vehicle);
        for (Integer i = 0; i < 24; i++) {
            this.availabilityList.get(i).add(vehicleId);
        }
        BranchHandler.getBranchHandler().addVehicle(vehicleId, vehicleType, branchName);
    }

    public Vehicle getVehicle(int vehicleId) {
        return this.vehicleHandlerMap.get(vehicleId);
    }

    //get availabiltty
    public List<Vehicle> getAvailability(Integer startTime, Integer endTime) {
        List<Vehicle> freeVehicles = new ArrayList<>();
        for (Map.Entry<String, Vehicle> entry : vehicleHandlerMap.entrySet()) {
            Boolean vehicleEligible = true;
            String vehicleId = entry.getKey();
            Vehicle vehicle = entry.getValue();
            for (Integer i = startTime; i < endTime; i++) {
                if (!this.availabilityList.get(i).contains(vehicleId)) {
                    vehicleEligible = false;
                    break;
                }
            }

            if (vehicleEligible) {
                freeVehicles.add(vehicle);
            }
        }

        return freeVehicles;
    }

    //block availability
    public void blockVehicle(String vehicleID, Integer startTime, Integer endTime) {
        for (Integer i = startTime; i < endTime; i++) {
            this.availabilityList.get(i).remove(vehicleID);
        }
    }
}

enum VehicleType {
    SEDAN, HATCHBACK, SUV
}

class VehicleTypePrice {
    Map<VehicleType, Long> vehicleTypePriceMap;

    VehicleTypePrice() {
        vehicleTypePriceMap = new HashMap<>();
    }

    public Long getVehiclePrice(VehicleType vehicleType) {
        return vehicleTypePriceMap.get(vehicleType);
    }

    public void setVehicleTypePrice(VehicleType vehicleType, long price) {
        vehicleTypePriceMap.put(vehicleType, price);
    }

}

class Branch {
    private String branchName;
    Map<String, VehicleType> vehicleHandlerap;
    Map<VehicleType, PricingInfo> pricingMap;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.vehicleHandlerap = new HashMap<>();
        this.pricingMap = new HashMap<>();
    }

    public String getBranchName() {
        return this.branchName;
    }

    public void addVehicle(String vehicleId, VehicleType vehicleType) {
        vehicleHandlerap.put(vehicleId, vehicleType);
    }

    public void allocatePrice(VehicleType vehicleType, double price) {
        PricingInfo pricingInfo = new PricingInfo(CurrencyUnit.RS, price);
        pricingMap.put(vehicleType, pricingInfo);
    }

    public PricingInfo getPricingInfoForType(VehicleType vehicleType) {
        return pricingMap.get(vehicleType);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchName='" + branchName + '\'' +
                ", vehicleHandlerap=" + vehicleHandlerap +
                ", pricingMap=" + pricingMap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(branchName, branch.branchName) && Objects.equals(vehicleHandlerap, branch.vehicleHandlerap) && Objects.equals(pricingMap, branch.pricingMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchName, vehicleHandlerap, pricingMap);
    }
}

class PricingInfo {

    private CurrencyUnit currencyUnit;
    private double value;

    public PricingInfo(CurrencyUnit currencyUnit, double value) {
        this.currencyUnit = currencyUnit;
        this.value = value;
    }

    public CurrencyUnit getCurrencyUnit() {
        return currencyUnit;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PricingInfo{" +
                "currencyUnit=" + currencyUnit +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PricingInfo that = (PricingInfo) o;
        return Double.compare(that.value, value) == 0 && currencyUnit == that.currencyUnit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyUnit, value);
    }
}

enum CurrencyUnit {
    RS
}


class BranchHandler {
    Map<String, Branch> branchHandlerap;
    private static BranchHandler branchHandler;
    public static BranchHandler getBranchHandler() {
        if (branchHandler == null) {
            branchHandler = new BranchHandler();
            branchHandler.branchHandlerap = new HashMap<>();
        }

        return branchHandler;
    }

    //Add branch
    public void addBranch(String branchName) {
        Branch newBranch = new Branch(branchName);
        branchHandlerap.put(branchName, newBranch);
    }

    //Allocate Price
    public void allocatePrice(String branchName, VehicleType vehicleType, double price) {
        Branch existingBranch = branchHandlerap.get(branchName);
        existingBranch.allocatePrice(vehicleType, price);
    }

    //AddVehicle
    public void addVehicle(String vehicleId, VehicleType vehicleType, String branchName) {
        Branch existingBranch = branchHandlerap.get(branchName);
        existingBranch.addVehicle(vehicleId, vehicleType);
    }

    public Map<String, Branch> getbranchHandlerMap() {
        return branchHandlerap;
    }
}

class Reservation {
    private int reservationId;
    private String vehicleId;
    private Integer startTime;
    private Integer endTime;

    Reservation(String vehicleId, Integer startTime, Integer endTime) {
        this.vehicleId = vehicleId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getVehicleId() {
        return this.vehicleId;
    }

    public Integer getStartTime() {
        return this.startTime;
    }

    public Integer getEndTime() {
        return this.endTime;
    }

    public int getReservationId() {
        return this.reservationId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", vehicleId='" + vehicleId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return reservationId == that.reservationId && Objects.equals(vehicleId, that.vehicleId) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, vehicleId, startTime, endTime);
    }
}

class ReservationHandler {

    //Book a Vehicle
    public static Reservation bookVehicle(VehicleType vehicleType, Integer startTime, Integer endTime)
            throws InvalidVehicleTypeException, BookingException {
        VehicleHandler vehicleHandler = VehicleHandler.getVehicleHandler();
        List<Vehicle> vehicles = vehicleHandler.getAvailability(startTime, endTime);

        // filter vehicles
        List<Vehicle> filteredVehicles = getFilteredVehicles(vehicles, vehicleType);

        // select a vehicle based on filter
        if(filteredVehicles.size() == 0)
            throw new BookingException("No vehicle of type "+ vehicleType + " availaible!!");

        Vehicle selectedVehicle = filteredVehicles.get(0);

        // update Inventory and block time slot for this vehicle
        vehicleHandler.blockVehicle(selectedVehicle.getVehicleId(), startTime, endTime);

        // create a new booking
        Reservation reservation = new Reservation(selectedVehicle.getVehicleId(), startTime, endTime);

        return reservation;
    }

    private static List<Vehicle> getFilteredVehicles(List<Vehicle> vehicles, VehicleType vehicleType) throws InvalidVehicleTypeException {
        List<Vehicle> selectedVehicles = new ArrayList<Vehicle>();
        double minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            if(vehicle.getVehicleType() != vehicleType)
                continue;

            Branch branch = BranchHandler.getBranchHandler().getbranchHandlerMap().get(vehicle.getBranchName());
            PricingInfo pricingInfo = branch.getPricingInfoForType(vehicle.getVehicleType());
            if(pricingInfo != null) {
                double price = pricingInfo.getValue();
                if (minPrice > price) {
                    selectedVehicles.clear();
                    minPrice = price;
                    selectedVehicles.add(vehicle);
                } else if (minPrice == price) {
                    selectedVehicles.add(vehicle);
                }
            } else {
                throw new InvalidVehicleTypeException("Invalid Vehicle Type");
            }
        }
        return selectedVehicles;
    }
}

class InvalidVehicleTypeException extends Exception {
    public InvalidVehicleTypeException(String message) {
        super(message);
    }
}

class BookingException extends Exception {
    public BookingException(String message) {
        super(message);
    }
}


// Main class should be named 'Solution'
public class Solution {

    private static void test1() throws BookingException, InvalidVehicleTypeException {
        System.out.println("Testcase-I");
        VehicleHandler vehicleHandler = VehicleHandler.getVehicleHandler();
        BranchHandler branchHandler = BranchHandler.getBranchHandler();

        // adding 3 branches
        branchHandler.addBranch("Branch1");
        branchHandler.addBranch("Branch2");
        branchHandler.addBranch("Branch3");

        branchHandler.allocatePrice("Branch1", VehicleType.HATCHBACK, 10);
        branchHandler.allocatePrice("Branch1", VehicleType.SEDAN, 20);
        branchHandler.allocatePrice("Branch1", VehicleType.SUV, 30);

        branchHandler.allocatePrice("Branch2", VehicleType.HATCHBACK, 15);
        branchHandler.allocatePrice("Branch2", VehicleType.SEDAN, 25);
        branchHandler.allocatePrice("Branch2", VehicleType.SUV, 35);


        branchHandler.allocatePrice("Branch3", VehicleType.HATCHBACK, 20);
        branchHandler.allocatePrice("Branch3", VehicleType.SEDAN, 30);
        branchHandler.allocatePrice("Branch3", VehicleType.SUV, 40);

        // adding 6 cars, 2 in each branches
        vehicleHandler.addVehicle("V1", VehicleType.HATCHBACK, "Branch1");
        vehicleHandler.addVehicle("V2",VehicleType.SEDAN, "Branch1");
        vehicleHandler.addVehicle("V3", VehicleType.SUV, "Branch2");
        vehicleHandler.addVehicle("V4", VehicleType.HATCHBACK, "Branch2");
        vehicleHandler.addVehicle("V5", VehicleType.SEDAN, "Branch3");
        vehicleHandler.addVehicle("V6", VehicleType.SUV, "Branch3");

        System.out.println(branchHandler.getbranchHandlerMap());

        System.out.println(ReservationHandler.bookVehicle(VehicleType.HATCHBACK, 1, 2));
    }

    public static void main(String[] args) {
        try {
            test1();
        } catch (BookingException e) {
            throw new RuntimeException(e);
        } catch (InvalidVehicleTypeException e) {
            throw new RuntimeException(e);
        }
    }
}