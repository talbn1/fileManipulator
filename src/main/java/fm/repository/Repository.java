package fm.repository;

import java.sql.*;

/**
 * @author talbn on 9/3/2020
 **/

public class Repository  {

    public static void insertRecord(String operation, String input_file1, String file2) {

        String query = "INSERT INTO file_manipulator.actions (action, input_file_name, " +
                "output_file_name) VALUES ("+"\""+operation+"\",\""+input_file1+"\",\""+file2+"\""+
                ")"  ;
        String connectionUrl = "jdbc:mysql://localhost:3306/file_manipulator?serverTimezone=UTC";

        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "root", "tal123");
            PreparedStatement ps = conn.prepareStatement(query);
            int rs = ps.executeUpdate(query);
            if(rs == 1){
                System.out.println("Row inserted successfully");
            }
        }catch (SQLException sqlException){
            System.out.println("SQL Query Failed");
            sqlException.printStackTrace();
        }
    }
}
