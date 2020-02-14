package CRUD_Prj;

import java.sql.DriverManager;
import java.sql.Connection;

public class DB_Connection {

    public static void main(String[] args){
        DB_Connection obj_DB_Connection = new DB_Connection();
        System.out.println(obj_DB_Connection.get_connection());
    }

    public Connection get_connection(){
        Connection connect = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/CRUD", "root", "Shawnand2@");

        }catch (Exception e){
            System.out.println(e);
        }

        return connect;
    }
}
