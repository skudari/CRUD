package CRUD_Prj;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class Testing {
    @Test
    public void testIt() throws Exception {
        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        if(connection.getAutoCommit())
            connection.setAutoCommit(false);

        Vehicles testVehicle = new Vehicles();

        try {
            testVehicle.create_vehicle(1, 2003, "Mitsubushi", "Galant");
            testVehicle.create_vehicle(2, 2009, "Ford", "F150");
            testVehicle.create_vehicle(9, 2019, "Fiat", "500");

            assertEquals("Id: 1 Year: 2003 Make: Mitsubushi Model: Galant\n" +
                    "Id: 2 Year: 2009 Make: Ford Model: F150\n" +
                    "Id: 9 Year: 2019 Make: Fiat Model: 500\n", testVehicle.get_vehicles());
            assertEquals("Id: 1 Year: 2003 Make: Mitsubushi Model: Galant\n", testVehicle.get_vehicles(1));
            assertEquals("Id: 2 Year: 2009 Make: Ford Model: F150\n", testVehicle.get_vehicles(2));

            //int id, int new_id, int year, String make, String model
            testVehicle.update_vehicles(1, 7, 2018, "Toyota", "Yaris");
            testVehicle.update_vehicles(2, 2, 2004, "Honda", "Civic");

            assertEquals("Id: 7 Year: 2018 Make: Toyota Model: Yaris\n", testVehicle.get_vehicles(7));
            assertEquals("Id: 2 Year: 2004 Make: Honda Model: Civic\n", testVehicle.get_vehicles(2));


            testVehicle.delete_vehicles(7);
            testVehicle.delete_vehicles(2);
            testVehicle.delete_vehicles(9);

            assertEquals("",testVehicle.get_vehicles(7));
            assertEquals("",testVehicle.get_vehicles(2));
            assertEquals("",testVehicle.get_vehicles(9));


        } finally {
                connection.rollback();
                connection.close();
        }
    }
}