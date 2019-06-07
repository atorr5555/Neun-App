package para.neun.smarthome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Handler mHandler = new Handler();
    Home currentConfig;
    public List<String> profiles = new ArrayList<>();

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

        updateList();

        currentConfig = (readConfig() == null) ? new Home() : readConfig();
        updateConfig();

        Switch switchFoco1 = findViewById(R.id.switchFoco1);
        switchFoco1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 1);
                saveConfig();
            }
        });

        Switch switchFoco2 = findViewById(R.id.switchFoco2);
        switchFoco2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 2);
                saveConfig();
            }
        });

        Switch switchFoco3 = findViewById(R.id.switchFoco3);
        switchFoco3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 3);
                saveConfig();
            }
        });

        Switch switchFoco4 = findViewById(R.id.switchFoco4);
        switchFoco4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 4);
                saveConfig();
            }
        });

        Switch switchFoco5 = findViewById(R.id.switchFoco6);
        switchFoco5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 5);
                saveConfig();
            }
        });

        Switch switchFoco6 = findViewById(R.id.switchFoco6);
        switchFoco6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 6);
                saveConfig();
            }
        });

        Switch switchFoco7 = findViewById(R.id.switchFoco7);
        switchFoco7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 7);
                saveConfig();
            }
        });

        Switch switchFoco8 = findViewById(R.id.switchFoco8);
        switchFoco8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 8);
                saveConfig();
            }
        });

        Switch  switchPuertaPrincipal = findViewById(R.id.switchPuertaPrincipal);
        switchPuertaPrincipal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setPuertaPrincipal(isChecked);
                saveConfig();
            }
        });

        Switch  switchPuertaPatio = findViewById(R.id.switchPuertaPatio);
        switchPuertaPatio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setPuertaPatio(isChecked);
                saveConfig();
            }
        });

        Switch  switchPuertaCuarto = findViewById(R.id.switchPuertaCuarto);
        switchPuertaCuarto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setPuertaCuarto(isChecked);
                saveConfig();
            }
        });

    }

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
            updateList();

        } else if (id == R.id.nav_change) {

        } else if (id == R.id.nav_delete) {

        } else if (id == R.id.nav_help) {
            Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(helpIntent);

        } else if (id == R.id.nav_settings) {

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    public boolean saveConfig() {
        try {
            File filename = new File("data/data/para.neun.smarthome/test.txt");
            if(!filename.exists()){
                filename.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(filename);
            ObjectOutputStream writingFile = new ObjectOutputStream(out);
            writingFile.writeObject(currentConfig);
            writingFile.close();
            return true;

        }catch(Exception e) {
            return false;
        }
    }


    public Home readConfig(){
        try {

            ObjectInputStream readingFile = new ObjectInputStream(new FileInputStream("data/data/para.neun.smarthome/test.txt"));
            Home recoveredConfig = (Home) readingFile.readObject();
            readingFile.close();
            return recoveredConfig;

        }catch(Exception e) {
            return null;
        }
    }

    //Actualiza valores una vez que se obtiene el deserialize
    public void updateConfig() {
        Boolean [] focos  = currentConfig.getFocos();
        final Switch [] switches = {findViewById(R.id.switchFoco1), findViewById(R.id.switchFoco2), findViewById(R.id.switchFoco3), findViewById(R.id.switchFoco4),
                findViewById(R.id.switchFoco6), findViewById(R.id.switchFoco6), findViewById(R.id.switchFoco7), findViewById(R.id.switchFoco8)};
        for(int i = 0; i < focos.length; i++) {
                switches[i].setChecked(focos[i]);
        }
        Switch  switchPuertaPrincipal = findViewById(R.id.switchPuertaPrincipal);
        switchPuertaPrincipal.setChecked(currentConfig.getPuertaPrincipal());

        Switch  switchPuertaPatio = findViewById(R.id.switchPuertaPatio);
        switchPuertaPatio.setChecked(currentConfig.getPuertaPatio());

        Switch  switchPuertaCuarto = findViewById(R.id.switchPuertaCuarto);
        switchPuertaCuarto.setChecked(currentConfig.getPuertaCuarto());
    }



    public void updateList() {
        String names;

        try {
            File filename = new File("data/data/para.neun.smarthome/list.txt");
            if(!filename.exists()){
                filename.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(filename));
            names = br.readLine();


        }catch(Exception e) {
            names = "";
        }
        if (names != null) {
            String [] namesArray = names.split("/");
            for (String aux : namesArray) {
                if ((!aux.equals("")) && (!busquedaLineal(profiles, aux))){
                    profiles.add(aux);
                }
            }
        }
    }

    public boolean busquedaLineal (List<String> lista, String key) {
        for(String aux : lista) {
            if (key.equals(aux)) {
                return true;
            }
        }
        return false;
    }
}
