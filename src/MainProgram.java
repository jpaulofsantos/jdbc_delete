import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainProgram {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM department "
                    + "WHERE "
                    + "Id = ?");


            preparedStatement.setInt(1, 19);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Affected rows: " + rowsAffected);


        }catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());

        }
    }
}
