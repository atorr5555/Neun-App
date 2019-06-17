package para.neun.smarthome;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnectionWrite extends AsyncTask<String, String, String> {
    Connection conn = null;

    @Override
    protected String doInBackground(String... strings) {
        String query = "";
        if (strings[0].matches("led_[0-9]")) {
            query = selectQuery(strings[0], strings[1]);
        }
        else {
            query = selectQuery(strings[0], null);
        }
        try {
            String url = "jdbc:mysql://85.10.205.173:3306/neunpara?autoReconnect=true&useSSL=false";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,"rpib123","neunpara");
            System.out.println ("Database connection established");
            PreparedStatement ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close ();
                    System.out.println("Database connection done");
                }
                catch (Exception e) {

                }
            }
        }
        return null;
    }

    public String selectQuery (String deviceName, String state) {
        String query = "";
        if (deviceName.matches("led_[0-9]")) {
            query = "update neun_states set state = " + state + " where device_name = '" + deviceName + "';";
        }
        else {
            query = deviceName;
        }
        return query;
    }
}
