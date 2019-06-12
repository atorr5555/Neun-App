package para.neun.smarthome;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity{

    ArrayList<String> profiles;
    ArrayList<String> horarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent received = getIntent();
        profiles = received.getStringArrayListExtra("profiles");

        horarios = IOFiles.updateHorarios(horarios);

        FloatingActionButton add = findViewById(R.id.fab);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setHourIntent = new Intent(SettingsActivity.this, SetHourActivity.class);
                setHourIntent.putStringArrayListExtra("profiles", profiles);
                startActivityForResult(setHourIntent, 1);
            }
        });

        ListView listaPerfiles = findViewById(R.id.listView);

        ArrayAdapter adaptador =  new ArrayAdapter(this, android.R.layout.simple_list_item_1, horarios);

        listaPerfiles.setAdapter(adaptador);

        listaPerfiles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK) {
                horarios = IOFiles.updateHorarios(horarios);
                ListView listaPerfiles = findViewById(R.id.listView);

                ArrayAdapter adaptador =  new ArrayAdapter(this, android.R.layout.simple_list_item_1, horarios);

                listaPerfiles.setAdapter(adaptador);
            }
        }
    }
}
