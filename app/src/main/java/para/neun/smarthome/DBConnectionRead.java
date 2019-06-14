package para.neun.smarthome;


import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.*;

public class DBConnectionRead extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... strings) {
        Boolean [] focos = {false, false, false, false, false, false, false, false};
        Connection conn = null;

        try {
            String url = "jdbc:mysql://85.10.205.173:3306/neunpara";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,"rpib123","neunpara");
            System.out.println ("Database connection established");
            PreparedStatement ps = conn.prepareStatement("select * from neun_states");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                if (id <= 8) {
                    Boolean state = rs.getBoolean("state");
                    focos[id-1] = state;
                }
                if (id == 9) {
                    Boolean state = rs.getBoolean("state");
                    IOFiles.writePuertaPrincipal(state);
                }
            }
            IOFiles.writeLeds(focos);
            ps = conn.prepareStatement("select * from env_data");
            rs = ps.executeQuery();
            while (rs.next()) {
                Float [] tyh = {0.0f, 0.0f, 0.0f, 0.0f};
                int id = rs.getInt("id");
                if (id == 1) {
                    tyh[0] = rs.getFloat("tem");
                    tyh[1] = rs.getFloat("hum");
                }
                if (id == 2) {
                    tyh[2] = rs.getFloat("tem");
                    tyh[3] = rs.getFloat("hum");
                }
                IOFiles.writeTYH(tyh);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close ();
                }
                catch (Exception e) {

                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        Home newConfig = new Home();
        newConfig.setFocos(IOFiles.readLeds());
        newConfig.setPuertaPrincipal(IOFiles.readPuertaPrincipal());
        Float [] tyh = IOFiles.readTYH();
        newConfig.setTemperaturaSala(tyh[0]);
        newConfig.setHumedadSala(tyh[1]);
        newConfig.setTemperaturaCuarto(tyh[2]);
        newConfig.setHumedadCuarto((tyh[3]));
        IOFiles.saveConfig(newConfig);
        super.onPostExecute(s);
    }
}
