import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.Server;

public class DBTest {

  public static void main(String[] args)
  {
    Server hsqlServer = null;
    Connection connection = null;
    ResultSet rs = null;

    hsqlServer = new Server();
    hsqlServer.setLogWriter(null);
    hsqlServer.setSilent(true);
    hsqlServer.setDatabaseName(0, "TestDB");
    hsqlServer.setDatabasePath(0, "file:MYDB");

    hsqlServer.start();

    //making a Connection
    try {
      Class.forName("org.hsqldb.jdbcDriver");
      connection = DriverManager.getConnection("jdbc:hsqldb:TestDB", "sa", "123");
      connection.prepareStatement("drop table user if exists;").execute();
      connection.prepareStatement("create table user (userID INTERGER not null, userName VARCHAR(20) not null, imagePath VARCHAR(40));").execute();
      connection.prepareStatement("insert into user(userID, userName, imagePath)" + "values (1, 'jack', 'imagepath');").execute();
      rs = connection.prepareStatement("select userID, userName from user;").executeQuery();
      rs.next();
      System.out.println(String.format("ID: %1d, Name:%1s", rs.getInt(1), rs.getString(2)));
      connection.commit();
    }
    catch (SQLException e2)
    {
      e2.printStackTrace();
    }
    catch (ClassNotFoundException e2)
    {
      e2.printStackTrace();
    }


  }
}
