package para.neun.smarthome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Handler mHandler = new Handler();
    Home currentConfig;
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

        profiles = IOFiles.updateList(profiles);

            currentConfig = (IOFiles.readConfig() == null) ? new Home() : IOFiles.readConfig();
        updateConfig();

        Switch switchFoco1 = findViewById(R.id.switchFoco1);
        switchFoco1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 1);
                IOFiles.saveConfig(currentConfig);
            }
        });

        Switch switchFoco2 = findViewById(R.id.switchFoco2);
        switchFoco2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 2);
                IOFiles.saveConfig(currentConfig);
            }
        });

        Switch switchFoco3 = findViewById(R.id.switchFoco3);
        switchFoco3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 3);
                IOFiles.saveConfig(currentConfig);
            }
        });

        Switch switchFoco4 = findViewById(R.id.switchFoco4);
        switchFoco4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 4);
                IOFiles.saveConfig(currentConfig);
            }
        });

        Switch switchFoco5 = findViewById(R.id.switchFoco5);
        switchFoco5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 5);
                IOFiles.saveConfig(currentConfig);
            }
        });

        Switch switchFoco6 = findViewById(R.id.switchFoco6);
        switchFoco6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 6);
                IOFiles.saveConfig(currentConfig);
            }
        });

        Switch switchFoco7 = findViewById(R.id.switchFoco7);
        switchFoco7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 7);
                IOFiles.saveConfig(currentConfig);
            }
        });

        Switch switchFoco8 = findViewById(R.id.switchFoco8);
        switchFoco8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setFoco(isChecked, 8);
                IOFiles.saveConfig(currentConfig);
            }
        });

        Switch  switchPuertaPrincipal = findViewById(R.id.switchPuertaPrincipal);
        switchPuertaPrincipal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setPuertaPrincipal(isChecked);
                IOFiles.saveConfig(currentConfig);
            }
        });

        Switch  switchPuertaPatio = findViewById(R.id.switchPuertaPatio);
        switchPuertaPatio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setPuertaPatio(isChecked);
                IOFiles.saveConfig(currentConfig);
            }
        });

        Switch  switchPuertaCuarto = findViewById(R.id.switchPuertaCuarto);
        switchPuertaCuarto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentConfig.setPuertaCuarto(isChecked);
                IOFiles.saveConfig(currentConfig);
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

    //Actualiza valores una vez que se obtiene el deserialize
    public void updateConfig() {
        Boolean [] focos  = currentConfig.getFocos();
        final Switch [] switches = {findViewById(R.id.switchFoco1), findViewById(R.id.switchFoco2), findViewById(R.id.switchFoco3), findViewById(R.id.switchFoco4),
                findViewById(R.id.switchFoco5), findViewById(R.id.switchFoco6), findViewById(R.id.switchFoco7), findViewById(R.id.switchFoco8)};
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                currentConfig = (Home) data.getSerializableExtra("nuevaConfig");
                updateConfig();
                Toast.makeText(getApplicationContext(), "Cambió a perfil " + data.getStringExtra("name"), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
