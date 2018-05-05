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
      connection.prepareStatement("drop table postHistory if exists;").execute();
      connection.prepareStatement("create table user (userID INTEGER not null, userName VARCHAR(20) not null, imagePath VARCHAR(40));").execute();
      connection.prepareStatement("create table postHistory (userID INTEGER not null, posts VARCHAR(40) not null, time VARCHAR(40));").execute();
      connection.prepareStatement("insert into user(userID, userName, imagePath)" + "values (1, 'jack', 'imagepath');").execute();
      connection.prepareStatement("insert into user(userID, userName, imagePath)" + "values (2, 'thuy', 'imagepath');").execute();
      connection.prepareStatement("insert into user(userID, userName, imagePath)" + "values (3, 'jeremy', 'imagepath');").execute();
      connection.prepareStatement("insert into postHistory(userID, posts, time)" + "values (1, 'This is the first posting', '3:30pm');").execute();
      connection.prepareStatement("insert into postHistory(userID, posts, time)" + "values (1, 'This is the second posting', '3:32pm');").execute();
      rs = connection.prepareStatement("select userID, userName, imagePath from user;").executeQuery();
      
      while(rs.next())
      {System.out.println(String.format("ID: %1d, Name:%1s, ImageURL:%1s", rs.getInt(1), rs.getString(2), rs.getString(3)));
      connection.commit();
      }
      rs = connection.prepareStatement("select userID, posts, time from postHistory;").executeQuery();
      while(rs.next())
      {System.out.println(String.format("ID: %1d, Posts:%1s, Time:%1s", rs.getInt(1), rs.getString(2), rs.getString(3)));
      connection.commit();
      }
      
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
