package para.neun.smarthome;


import android.os.AsyncTask;

import java.sql.*;

public class DBConnectionRead extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... strings) {
        Boolean [] focos = {false, false, false, false, false, false, false, false};
        Connection conn = null;
        Home newConfig = new Home();

        try {
            String url = "jdbc:mysql://85.10.205.173:3306/neunpara?autoReconnect=true&useSSL=false";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,"rpib123","neunpara");
            System.out.println ("Database connection established");
            PreparedStatement ps = conn.prepareStatement("select * from neun_states");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String deviceName = rs.getString("device_name");
                if (deviceName.matches("led_[0-9]")) {
                    int indice = Integer.parseInt(deviceName.replace("led_", ""));
                    Boolean state = rs.getBoolean("state");
                    newConfig.setFoco(state, indice);
                }

                if (deviceName.equals("magn_sw_1")) {
                    newConfig.setVentana(rs.getBoolean("state"));
                }

                if (deviceName.equals("gas_leak_sens")) {
                    newConfig.setGas(rs.getBoolean("state"));
                }

                if (deviceName.equals("flame_sens")) {
                    newConfig.setFuego(rs.getBoolean("state"));
                }
            }
            ps = conn.prepareStatement("select * from env_data");
            rs = ps.executeQuery();
            while (rs.next()) {
                int sensor = rs.getInt("sensor");
                if (sensor == 1) {
                    newConfig.setTemperaturaCuarto(rs.getFloat("tem"));
                    newConfig.setHumedadCuarto(rs.getFloat("hum"));
                }
                if (sensor == 2) {
                    newConfig.setTemperaturaSala(rs.getFloat("tem"));
                    newConfig.setHumedadSala(rs.getFloat("hum"));
                }
            }
            IOFiles.saveConfig(newConfig);
        }
        catch (Exception e) {
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

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
