package PhonePe;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VRS {
    public static void main(String[] args){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date parsedDate = dateFormat.parse("2022-10-10 12:00:00.000");
            Timestamp timestamp = new Timestamp(parsedDate.getTime());

            VehicleReservationService ve = new VehicleReservationService();
            ve.addBranch("Branch1");
            ve.addBranch("Branch2");
            ve.addBranch("Branch3");

            ve.addVehicle(1L, VehicleType.HATCHBACK, "Branch1");
            ve.addVehicle(2L,VehicleType.SEDAN, "Branch1");
            ve.addVehicle(3L,VehicleType.SUV, "Branch1");
            ve.addVehicle(4L, VehicleType.HATCHBACK, "Branch2");
            ve.addVehicle(5L, VehicleType.SUV, "Branch2");
            ve.addVehicle(6L, VehicleType.SEDAN, "Branch2");
            ve.addVehicle(9L, VehicleType.HATCHBACK, "Branch3");
            ve.addVehicle(7L, VehicleType.SEDAN, "Branch3");
            ve.addVehicle(8L, VehicleType.SUV, "Branch3");

            ve.allocatePrice("Branch1", VehicleType.HATCHBACK, new BigDecimal("10"));
            ve.allocatePrice("Branch1", VehicleType.SEDAN, new BigDecimal("20"));
            ve.allocatePrice("Branch1", VehicleType.SUV, new BigDecimal("30"));

            ve.allocatePrice("Branch2", VehicleType.HATCHBACK, new BigDecimal("15"));
            ve.allocatePrice("Branch2", VehicleType.SEDAN, new BigDecimal("25"));
            ve.allocatePrice("Branch2", VehicleType.SUV, new BigDecimal("35"));

            ve.allocatePrice("Branch3", VehicleType.HATCHBACK, new BigDecimal("20"));
            ve.allocatePrice("Branch3", VehicleType.SEDAN, new BigDecimal("40"));
            ve.allocatePrice("Branch3", VehicleType.SUV, new BigDecimal("60"));

            String ans = ve.bookVehicle(VehicleType.HATCHBACK, new Timestamp(dateFormat.parse("2022-10-10 12:00:00.000").getTime()), new Timestamp(dateFormat.parse("2022-10-11 12:00:00.000").getTime()));
            System.out.println(ans);
        } catch(Exception e) { //this generic but you can control another types of exception
            // look the origin of excption
            System.out.println(e.getMessage());
        }
    }
}
