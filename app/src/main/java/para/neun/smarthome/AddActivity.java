package para.neun.smarthome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class AddActivity extends AppCompatActivity {

    Home newConfig =  new Home();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextName = findViewById(R.id.EditTextName);
                String name = editTextName.getText().toString();
                name = name.replaceAll(" ","");
                name = name.replaceAll("/", "");
                if ((name.equals("")) || (name ==null)) {
                    Toast.makeText(getApplicationContext(), "Ingrese un nombre válido", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(saveConfig(name)) {
                    IOFiles.writeName(name);
                    finish();
                }
            }
        });

        Switch switchFoco1 = findViewById(R.id.switchFoco1);
        switchFoco1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newConfig.setFoco(isChecked, 1);
            }
        });

        Switch switchFoco2 = findViewById(R.id.switchFoco2);
        switchFoco2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newConfig.setFoco(isChecked, 2);
            }
        });

        Switch switchFoco3 = findViewById(R.id.switchFoco3);
        switchFoco3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newConfig.setFoco(isChecked, 3);
            }
        });

        Switch switchFoco4 = findViewById(R.id.switchFoco4);
        switchFoco4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newConfig.setFoco(isChecked, 4);
            }
        });

        Switch switchFoco5 = findViewById(R.id.switchFoco5);
        switchFoco5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newConfig.setFoco(isChecked, 5);
            }
        });

        Switch switchFoco6 = findViewById(R.id.switchFoco6);
        switchFoco6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newConfig.setFoco(isChecked, 6);
            }
        });

        Switch switchFoco7 = findViewById(R.id.switchFoco7);
        switchFoco7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newConfig.setFoco(isChecked, 7);
            }
        });

        Switch switchFoco8 = findViewById(R.id.switchFoco8);
        switchFoco8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newConfig.setFoco(isChecked, 8);
            }
        });

        Switch switchFoco9 = findViewById(R.id.switchFoco9);
        switchFoco9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newConfig.setFoco(isChecked, 9);
            }
        });

        Switch switchFoco10 = findViewById(R.id.switchFoco10);
        switchFoco10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newConfig.setFoco(isChecked, 10);
            }
        });

        Switch  switchPuertaPrincipal = findViewById(R.id.switchPuertaPrincipal);
        switchPuertaPrincipal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newConfig.setPuertaPrincipal(isChecked);
            }
        });

        Switch  switchPuertaPatio = findViewById(R.id.switchPuertaPatio);
        switchPuertaPatio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newConfig.setPuertaPatio(isChecked);
            }
        });

        Switch  switchPuertaCuarto = findViewById(R.id.switchGarage);
        switchPuertaCuarto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newConfig.setGarage(isChecked);
            }
        });
    }

    public boolean saveConfig(String name) {
        try {
            File filename = new File("data/data/para.neun.smarthome/" + name +".txt");
            if(!filename.exists()){
                filename.createNewFile();
            } else {
                Toast.makeText(getApplicationContext(), "Ya existe un perfil con el mismo nombre", Toast.LENGTH_SHORT).show();
                return false;
            }
            FileOutputStream out = new FileOutputStream(filename);
            ObjectOutputStream writingFile = new ObjectOutputStream(out);
            writingFile.writeObject(newConfig);
            writingFile.close();
            Toast.makeText(getApplicationContext(), "Se guardó el perfil", Toast.LENGTH_SHORT).show();
            return true;

        }catch(Exception e) {
            return false;
        }
    }
}
