package para.neun.smarthome;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Handler mHandler = new Handler();
    public Home currentConfig;
    public Home oldConfig = new Home();
    ArrayList<String> profiles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        try {
             String result = new DBConnectionRead().execute("").get();
        }catch (Exception e) {
        }

        profiles = IOFiles.updateList(profiles);

        currentConfig = (IOFiles.readConfig() == null) ? new Home() : IOFiles.readConfig();
        updateConfigNODB();

        Switch switchFoco1 = findViewById(R.id.switchFoco1);
        switchFoco1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 1);
                IOFiles.saveConfig(currentConfig);
                String myState = isChecked ? "TRUE" : "FALSE";
                try {
                    mHandler.removeCallbacks(mToastRunnable);
                    String s = new DBConnectionWrite().execute("led_1", myState).get();
                    mHandler.postDelayed(mToastRunnable, 1000 * 15);
                }catch (Exception e) {

                }
            }
        });

        Switch switchFoco2 = findViewById(R.id.switchFoco2);
        switchFoco2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 2);
                IOFiles.saveConfig(currentConfig);
                String myState = isChecked ? "TRUE" : "FALSE";
                try {
                    mHandler.removeCallbacks(mToastRunnable);
                    String s = new DBConnectionWrite().execute("led_2", myState).get();
                    mHandler.postDelayed(mToastRunnable, 1000 * 15);
                }catch (Exception e) {

                }
            }
        });

        Switch switchFoco3 = findViewById(R.id.switchFoco3);
        switchFoco3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 3);
                IOFiles.saveConfig(currentConfig);
                String myState = isChecked ? "TRUE" : "FALSE";
                try {
                    mHandler.removeCallbacks(mToastRunnable);
                    String s = new DBConnectionWrite().execute("led_3", myState).get();
                    mHandler.postDelayed(mToastRunnable, 1000 * 15);
                }catch (Exception e) {

                }
            }
        });

        Switch switchFoco4 = findViewById(R.id.switchFoco4);
        switchFoco4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 4);
                IOFiles.saveConfig(currentConfig);
                String myState = isChecked ? "TRUE" : "FALSE";
                try {
                    mHandler.removeCallbacks(mToastRunnable);
                    String s = new DBConnectionWrite().execute("led_4", myState).get();
                    mHandler.postDelayed(mToastRunnable, 1000 * 15);
                }catch (Exception e) {

                }
            }
        });

        Switch switchFoco5 = findViewById(R.id.switchFoco5);
        switchFoco5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 5);
                IOFiles.saveConfig(currentConfig);
                String myState = isChecked ? "TRUE" : "FALSE";
                try {
                    mHandler.removeCallbacks(mToastRunnable);
                    String s = new DBConnectionWrite().execute("led_5", myState).get();
                    mHandler.postDelayed(mToastRunnable, 1000 * 15);
                }catch (Exception e) {

                }
            }
        });

        Switch switchFoco6 = findViewById(R.id.switchFoco6);
        switchFoco6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 6);
                IOFiles.saveConfig(currentConfig);
                String myState = isChecked ? "TRUE" : "FALSE";
                try {
                    mHandler.removeCallbacks(mToastRunnable);
                    String s = new DBConnectionWrite().execute("led_6", myState).get();
                    mHandler.postDelayed(mToastRunnable, 1000 * 15);
                }catch (Exception e) {

                }
            }
        });

        Switch switchFoco7 = findViewById(R.id.switchFoco7);
        switchFoco7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 7);
                IOFiles.saveConfig(currentConfig);
                String myState = isChecked ? "TRUE" : "FALSE";
                try {
                    mHandler.removeCallbacks(mToastRunnable);
                    String s = new DBConnectionWrite().execute("led_7", myState).get();
                    mHandler.postDelayed(mToastRunnable, 1000 * 15);
                }catch (Exception e) {

                }
            }
        });

        Switch switchFoco8 = findViewById(R.id.switchFoco8);
        switchFoco8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 8);
                IOFiles.saveConfig(currentConfig);
                String myState = isChecked ? "TRUE" : "FALSE";
                try {
                    mHandler.removeCallbacks(mToastRunnable);
                    String s = new DBConnectionWrite().execute("led_8", myState).get();
                    mHandler.postDelayed(mToastRunnable, 1000 * 15);
                }catch (Exception e) {

                }
            }
        });

        Switch switchFoco9 = findViewById(R.id.switchFoco9);
        switchFoco9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 9);
                IOFiles.saveConfig(currentConfig);
                String myState = isChecked ? "TRUE" : "FALSE";
                try {
                    mHandler.removeCallbacks(mToastRunnable);
                    String s = new DBConnectionWrite().execute("led_9", myState).get();
                    mHandler.postDelayed(mToastRunnable, 1000 * 15);
                }catch (Exception e) {

                }
            }
        });

        Switch switchFoco10 = findViewById(R.id.switchFoco10);
        switchFoco10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 10);
                IOFiles.saveConfig(currentConfig);
                String myState = isChecked ? "TRUE" : "FALSE";
                try {
                    mHandler.removeCallbacks(mToastRunnable);
                    String s = new DBConnectionWrite().execute("led_10", myState).get();
                    mHandler.postDelayed(mToastRunnable, 1000 * 15);
                }catch (Exception e) {

                }
            }
        });

        Switch  switchPuertaPrincipal = findViewById(R.id.switchPuertaPrincipal);
        switchPuertaPrincipal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setPuertaPrincipal(isChecked);
                IOFiles.saveConfig(currentConfig);
                String myState = isChecked ? "TRUE" : "FALSE";
                try {
                    mHandler.removeCallbacks(mToastRunnable);
                    String s = new DBConnectionWrite().execute("p_principal", myState).get();
                    mHandler.postDelayed(mToastRunnable, 1000 * 15);
                }catch (Exception e) {

                }
            }
        });

        Switch  switchPuertaPatio = findViewById(R.id.switchPuertaPatio);
        switchPuertaPatio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setPuertaPatio(isChecked);
                IOFiles.saveConfig(currentConfig);
                String myState = isChecked ? "TRUE" : "FALSE";
                try {
                    mHandler.removeCallbacks(mToastRunnable);
                    String s = new DBConnectionWrite().execute("p_patio", myState).get();
                    mHandler.postDelayed(mToastRunnable, 1000 * 15);
                }catch (Exception e) {

                }
            }
        });

        Switch  switchGarage = findViewById(R.id.switchGarage);
        switchGarage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setGarage(isChecked);
                IOFiles.saveConfig(currentConfig);
                String myState = isChecked ? "TRUE" : "FALSE";
                try {
                    mHandler.removeCallbacks(mToastRunnable);
                    String s = new DBConnectionWrite().execute("p_garage", myState).get();
                    mHandler.postDelayed(mToastRunnable, 1000 * 15);
                }catch (Exception e) {

                }
            }
        });

        Switch switchVentana = findViewById(R.id.switchVentana);
        switchVentana.setClickable(false);

        TextView temperatura = findViewById(R.id.textViewTemperaturaSala);
        temperatura.setText(Float.toString(currentConfig.getTemperaturaSala()));

        TextView humedad = findViewById(R.id.textViewHumedadSala);
        humedad.setText(Float.toString(currentConfig.getHumedadSala()));

        TextView temperaturaCuarto = findViewById(R.id.textViewTemperaturaCuarto);
        temperaturaCuarto.setText(Float.toString(currentConfig.getTemperaturaCuarto()));

        TextView humedadCuarto = findViewById(R.id.textViewHumedadCuarto);
        humedadCuarto.setText(Float.toString(currentConfig.getHumedadCuarto()));

        startRepeating();

    }

    public void startRepeating () {
        mHandler.postDelayed(mToastRunnable, 1000 * 15);
    }

    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {
            new DBConnectionRead().execute("");
            currentConfig = IOFiles.readConfig();
            updateConfigNODB();
            mHandler.postDelayed(this, 1000 * 15);
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            profiles = IOFiles.updateList(profiles);
            Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
            settingsIntent.putStringArrayListExtra("profiles", profiles);
            startActivity(settingsIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_add) {
            Intent addIntent = new Intent(MainActivity.this, AddActivity.class);
            startActivity(addIntent);

        } else if (id == R.id.nav_change) {
            profiles = IOFiles.updateList(profiles);
            Intent changeIntent = new Intent(MainActivity.this, ChangeActivity.class);
            changeIntent.putStringArrayListExtra("profiles", profiles);
            startActivityForResult(changeIntent, 1);

        } else if (id == R.id.nav_delete) {
            profiles = IOFiles.updateList(profiles);
            Intent deleteIntent = new Intent(MainActivity.this, DeleteActivity.class);
            deleteIntent.putStringArrayListExtra("profiles", profiles);
            startActivity(deleteIntent);

        } else if (id == R.id.nav_help) {
            Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(helpIntent);

        } else if (id == R.id.nav_settings) {
            profiles = IOFiles.updateList(profiles);
            Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
            settingsIntent.putStringArrayListExtra("profiles", profiles);
            startActivity(settingsIntent);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void updateConfigNODB() {
        Boolean [] focos  = currentConfig.getFocos();
        final Switch [] switches = {findViewById(R.id.switchFoco1), findViewById(R.id.switchFoco2), findViewById(R.id.switchFoco3), findViewById(R.id.switchFoco4),
                findViewById(R.id.switchFoco5), findViewById(R.id.switchFoco6), findViewById(R.id.switchFoco7), findViewById(R.id.switchFoco8), findViewById(R.id.switchFoco9),
                findViewById(R.id.switchFoco10)};
        for(int i = 0; i < focos.length; i++) {
            switches[i].setChecked(focos[i]);
        }
        Switch  switchPuertaPrincipal = findViewById(R.id.switchPuertaPrincipal);
        switchPuertaPrincipal.setChecked(currentConfig.getPuertaPrincipal());

        Switch  switchPuertaPatio = findViewById(R.id.switchPuertaPatio);
        switchPuertaPatio.setChecked(currentConfig.getPuertaPatio());

        Switch  switchGarage = findViewById(R.id.switchGarage);
        switchGarage.setChecked(currentConfig.getGarage());

        TextView temperatura = findViewById(R.id.textViewTemperaturaSala);
        temperatura.setText(Float.toString(currentConfig.getTemperaturaSala()));

        TextView humedad = findViewById(R.id.textViewHumedadSala);
        humedad.setText(Float.toString(currentConfig.getHumedadSala()));

        TextView temperaturaCuarto = findViewById(R.id.textViewTemperaturaCuarto);
        temperaturaCuarto.setText(Float.toString(currentConfig.getTemperaturaCuarto()));

        TextView humedadCuarto = findViewById(R.id.textViewHumedadCuarto);
        humedadCuarto.setText(Float.toString(currentConfig.getHumedadCuarto()));

        Switch switchVentana = findViewById(R.id.switchVentana);
        switchVentana.setChecked(currentConfig.getVentana());

        reviewAlarms();
    }

    //Actualiza valores una vez que se obtiene el deserialize
    public void updateConfig() {
        Boolean [] focos  = currentConfig.getFocos();
        final Switch [] switches = {findViewById(R.id.switchFoco1), findViewById(R.id.switchFoco2), findViewById(R.id.switchFoco3), findViewById(R.id.switchFoco4),
                findViewById(R.id.switchFoco5), findViewById(R.id.switchFoco6), findViewById(R.id.switchFoco7), findViewById(R.id.switchFoco8), findViewById(R.id.switchFoco9),
                findViewById(R.id.switchFoco10)};
        String [] estados = {"", "", "", "", "", "", "", "", "", "", "", "", ""};
        for(int i = 0; i < focos.length; i++) {
            switches[i].setChecked(focos[i]);
            estados[i] = (focos[i]) ? "TRUE" : "FALSE";
        }
        estados[10] = (currentConfig.getPuertaPrincipal()) ? "TRUE" :  "FALSE";
        estados[11] = (currentConfig.getPuertaPatio()) ? "TRUE" :  "FALSE";
        estados[12] = (currentConfig.getGarage()) ? "TRUE" :  "FALSE";
        try {
            new DBConnectionWrite().execute("update neun_states set state = (case when device_name = 'led_1' then " + estados[0] + " " +
                    "when device_name = 'led_2' then " + estados[1] + " " +
                    "when device_name = 'led_3' then " + estados[2] + " " +
                    "when device_name = 'led_4' then " + estados[3] + " " +
                    "when device_name = 'led_5' then " + estados[4] + " " +
                    "when device_name = 'led_6' then " + estados[5] + " " +
                    "when device_name = 'led_7' then " + estados[6] + " " +
                    "when device_name = 'led_8' then " + estados[7] + " " +
                    "when device_name = 'led_9' then " + estados[8] + " " +
                    "when device_name = 'led_10' then " + estados[9] + " " +
                    "when device_name = 'p_principal' then " + estados[10] + " " +
                    "when device_name = 'p_patio' then " + estados[11] + " " +
                    "when device_name = 'p_garage' then " + estados[12] + " " +"end)" +
                    "where device_name in ('led_1', 'led_2', 'led_3', 'led_4', 'led_5', 'led_6', 'led_7', 'led_8', 'led_9', 'led_10', 'p_principal', 'p_patio', 'garage');");
        } catch (Exception e) {

        }

        Switch  switchPuertaPrincipal = findViewById(R.id.switchPuertaPrincipal);
        switchPuertaPrincipal.setChecked(currentConfig.getPuertaPrincipal());

        Switch  switchPuertaPatio = findViewById(R.id.switchPuertaPatio);
        switchPuertaPatio.setChecked(currentConfig.getPuertaPatio());

        Switch  switchGarage = findViewById(R.id.switchGarage);
        switchGarage.setChecked(currentConfig.getGarage());

        TextView temperatura = findViewById(R.id.textViewTemperaturaSala);
        temperatura.setText(Float.toString(currentConfig.getTemperaturaSala()));

        TextView humedad = findViewById(R.id.textViewHumedadSala);
        humedad.setText(Float.toString(currentConfig.getHumedadSala()));

        TextView temperaturaCuarto = findViewById(R.id.textViewTemperaturaCuarto);
        temperaturaCuarto.setText(Float.toString(currentConfig.getTemperaturaCuarto()));

        TextView humedadCuarto = findViewById(R.id.textViewHumedadCuarto);
        humedadCuarto.setText(Float.toString(currentConfig.getHumedadCuarto()));

        Switch switchVentana = findViewById(R.id.switchVentana);
        switchVentana.setChecked(currentConfig.getVentana());

        reviewAlarms();

    }

    public void reviewAlarms() {
        if (currentConfig.getGas() && currentConfig.getFuego()) {
            NotificationHelper notificationHelper = new NotificationHelper(getApplicationContext());
            NotificationCompat.Builder nb = notificationHelper.getChannelNotification("Alerta de fuego y  gas");
            notificationHelper.getManager().notify(1, nb.build());
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+911));
            startActivity(callIntent);
        }

        if (currentConfig.getGas() && !currentConfig.getFuego()) {
            NotificationHelper notificationHelper = new NotificationHelper(getApplicationContext());
            NotificationCompat.Builder nb = notificationHelper.getChannelNotification("Alerta de gas");
            notificationHelper.getManager().notify(1, nb.build());
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+911));
            startActivity(callIntent);
        }

        if (!currentConfig.getGas() && currentConfig.getFuego()) {
            NotificationHelper notificationHelper = new NotificationHelper(getApplicationContext());
            NotificationCompat.Builder nb = notificationHelper.getChannelNotification("Alerta de fuego");
            notificationHelper.getManager().notify(1, nb.build());
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+911));
            startActivity(callIntent);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                oldConfig = currentConfig;
                currentConfig = (Home) data.getSerializableExtra("nuevaConfig");
                currentConfig.setTemperaturaSala(oldConfig.getTemperaturaSala());
                currentConfig.setHumedadSala(oldConfig.getHumedadSala());
                currentConfig.setTemperaturaCuarto(oldConfig.getTemperaturaCuarto());
                currentConfig.setHumedadCuarto(oldConfig.getHumedadCuarto());
                updateConfig();
                Toast.makeText(getApplicationContext(), "Cambió a perfil " + data.getStringExtra("name"), Toast.LENGTH_SHORT).show();
            }
        }
    }


}
