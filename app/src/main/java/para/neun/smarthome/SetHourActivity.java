package para.neun.smarthome;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

public class SetHourActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    ArrayList<String> profiles;
    String profileName;
    int hour;
    int minute;

    TextView textViewHora;
    TextView perfilSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_hour);

        textViewHora = findViewById(R.id.textViewHora);
        perfilSeleccionado = findViewById(R.id.textViewSelectedProfile);

        Intent received = getIntent();

        profiles = received.getStringArrayListExtra("profiles");

        ListView listaPerfiles = findViewById(R.id.listView);

        ArrayAdapter adaptador =  new ArrayAdapter(this, android.R.layout.simple_list_item_1, profiles);

        listaPerfiles.setAdapter(adaptador);

        listaPerfiles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                profileName = parent.getItemAtPosition(position).toString();
                perfilSeleccionado.setText(profileName);
            }
        });

        Button button = findViewById(R.id.buttonSeleccionarHora);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        Button buttonGuardar = findViewById(R.id.buttonGuardar);
        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((profileName != null)) {
                    IOFiles.writeHour(profileName, hour, minute);
                    Toast.makeText(getApplicationContext(), "Se ha guardado la configuración", Toast.LENGTH_SHORT).show();
                    Intent resultIntent = new Intent();
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Seleccione un perfil", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        hour = hourOfDay;
        this.minute = minute;
        textViewHora.setText(hour + ":" + this.minute);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        startAlarm(c);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }

}
