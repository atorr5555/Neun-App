package para.neun.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {

    ArrayList<String> profiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Intent received = getIntent();

        profiles = received.getStringArrayListExtra("profiles");

        ListView listaPerfiles = findViewById(R.id.listView);

        ArrayAdapter adaptador =  new ArrayAdapter(this, android.R.layout.simple_list_item_1, profiles);

        listaPerfiles.setAdapter(adaptador);

        listaPerfiles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = parent.getItemAtPosition(position).toString();
                profiles.remove(name);
                IOFiles.overWriteFile(profiles);
                IOFiles.removeFile(name);
                Toast.makeText(getApplicationContext(), "Se ha eliminado el perfil " + name, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
