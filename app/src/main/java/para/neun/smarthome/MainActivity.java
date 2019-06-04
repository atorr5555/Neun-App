package para.neun.smarthome;

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
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Handler mHandler = new Handler();
    Home currentConfig;

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

        currentConfig = (readConfig() == null) ? new Home() : readConfig();
        updateConfig();

        final Switch switchFoco1 = findViewById(R.id.switchFoco1);
        switchFoco1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 1);
                saveConfig();
            }
        });

        final Switch switchFoco2 = findViewById(R.id.switchFoco2);
        switchFoco2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 2);
                saveConfig();
            }
        });

        final Switch switchFoco3 = findViewById(R.id.switchFoco3);
        switchFoco3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 3);
                saveConfig();
            }
        });

        final Switch switchFoco4 = findViewById(R.id.switchFoco4);
        switchFoco4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 4);
                saveConfig();
            }
        });

        final Switch switchFoco5 = findViewById(R.id.switchFoco5);
        switchFoco5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 5);
                saveConfig();
            }
        });

        final Switch switchFoco6 = findViewById(R.id.switchFoco6);
        switchFoco6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 6);
                saveConfig();
            }
        });

        final Switch switchFoco7 = findViewById(R.id.switchFoco7);
        switchFoco7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 7);
                saveConfig();
            }
        });

        final Switch switchFoco8 = findViewById(R.id.switchFoco8);
        switchFoco8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 8);
                saveConfig();
            }
        });

        final Switch  switchPuertaPrincipal = findViewById(R.id.switchPuertaPrincipal);
        switchPuertaPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchPuertaPrincipal.setChecked(true);

                mHandler.postDelayed(mSwitchRunnable, 5000);
            }
            private Runnable mSwitchRunnable = new Runnable() {
                @Override
                public void run() {
                    switchPuertaPrincipal.setChecked(false);
                }
            };
        });

        final Switch  switchPuertaPatio = findViewById(R.id.switchPuertaPatio);
        switchPuertaPatio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchPuertaPatio.setChecked(true);
                mHandler.postDelayed(mSwitchRunnableP, 5000);

            }
            private Runnable mSwitchRunnableP = new Runnable() {
                @Override
                public void run() {
                    switchPuertaPatio.setChecked(false);
                }
            };
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

        } else if (id == R.id.nav_change) {

        } else if (id == R.id.nav_delete) {

        } else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_settings) {

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Revisar esto hace el serialize
    public boolean saveConfig() {
        try {

            ObjectOutputStream writingFile = new ObjectOutputStream(new FileOutputStream("currentConfig.txt"));
            writingFile.writeObject(currentConfig);
            writingFile.close();
            return true;

        }catch(Exception e) {
            return false;
        }
    }


    //Revisar esto hace el deserialize
    public Home readConfig(){
        try {

            ObjectInputStream readingFile = new ObjectInputStream(new FileInputStream("currentConfig.txt"));
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
        Switch [] switches = {findViewById(R.id.switchFoco1), findViewById(R.id.switchFoco2), findViewById(R.id.switchFoco3), findViewById(R.id.switchFoco4),
                findViewById(R.id.switchFoco5), findViewById(R.id.switchFoco6), findViewById(R.id.switchFoco7), findViewById(R.id.switchFoco8)};
        for(int i = 0; i < focos.length; i++) {
            if (focos[i]) {
                switches[i].setChecked(true);
            }
            else {
                switches[i].setChecked(false);
            }
        }
    }
}
