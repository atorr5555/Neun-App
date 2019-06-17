package para.neun.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ChangeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        Intent received = getIntent();

        ArrayList<String> profiles = received.getStringArrayListExtra("profiles");

        ListView listaPerfiles = findViewById(R.id.listView);

        ArrayAdapter adaptador =  new ArrayAdapter(this, android.R.layout.simple_list_item_1, profiles);

        listaPerfiles.setAdapter(adaptador);

        listaPerfiles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = parent.getItemAtPosition(position).toString();
                Home newConfig = IOFiles.readConfig(name);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("nuevaConfig", newConfig);
                resultIntent.putExtra("name", name);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
