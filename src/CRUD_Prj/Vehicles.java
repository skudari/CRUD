package CRUD_Prj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Vehicles {

    public String get_vehicles(){
        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement pa = null;
        ResultSet rs = null;
        String results = "";

        try{
            String query = "select * from Vehicle";
            pa = connection.prepareStatement(query);
            System.out.println(pa);
            rs = pa.executeQuery();
            while (rs.next()){
                results = results + "Id: " + rs.getString("Id")
                        +" Year: " + rs.getString("Year")
                        +" Make: " + rs.getString("Make")
                        +" Model: " + rs.getString("Model") + "\n";
                System.out.println(results);

            }
        }catch(Exception e){
            System.out.println(e);
        }
        return results;
    }

    public String get_vehicles(int id){
        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement pa = null;
        ResultSet rs = null;
        String queryResult = "";
        try{
            String query = "select * from Vehicle where Id =" + String.valueOf(id);
            pa = connection.prepareStatement(query);
            System.out.println(pa);
            rs = pa.executeQuery();
            while (rs.next()){
                queryResult = queryResult + "Id: " + rs.getString("Id")
                        +" Year: " + rs.getString("Year")
                        +" Make: " + rs.getString("Make")
                        +" Model: " + rs.getString("Model") + "\n";
                System.out.println(queryResult);

            }
        }catch(Exception e){
            System.out.println(e);
        }
        return queryResult;
    }

    public void create_vehicle(int id, int year, String make, String model){
        if(make.length() == 0 || make == null || model.length() == 0 || model == null)
            return;
        if(year < 1950 || year > 2050)
            return;
        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();

        PreparedStatement pa = null;
        try {
            String query="insert into Vehicle(Id,Year,Make,Model) values (?,?,?,?)";
            pa = connection.prepareStatement(query);
            pa.setString(1, String.valueOf(id));
            pa.setString(2, String.valueOf(year));
            pa.setString(3, make);
            pa.setString(4, model);
            System.out.println(pa);
            pa.executeUpdate();

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void update_vehicles(int id, int new_id, int year, String make, String model){
        DB_Connection obj_DB_Connection=new DB_Connection();
        Connection connection=obj_DB_Connection.get_connection();
        PreparedStatement ps=null;
        try {
            String query="update Vehicle set Id=?, Year=?, Make=? , Model = ? where Id=" + String.valueOf(id);
            ps=connection.prepareStatement(query);
            ps.setString(1, String.valueOf(new_id));
            ps.setString(2, String.valueOf(year));
            ps.setString(3, make);
            ps.setString(4, model);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void delete_vehicles(int id){
        DB_Connection obj_DB_Connection=new DB_Connection();
        Connection connection=obj_DB_Connection.get_connection();
        PreparedStatement pa=null;
        try {
            String query="delete from Vehicle where Id=?";
            pa=connection.prepareStatement(query);
            pa.setString(1, String.valueOf(id));
            System.out.println(pa);
            pa.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
