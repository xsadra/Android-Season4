package at.sadra.apps.season4java;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import app.App;

public class E27AndroidListView extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ListView activityList;
    ImageView logoKotlin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e27_android_list_view);
        setTitle(getString(R.string.E27AndroidListView));
        init();

        activityList.setOnItemClickListener(this);
        logoKotlin.setOnClickListener(this);
    }

    private void init() {
        activityList = findViewById(R.id.activityList);
        logoKotlin = findViewById(R.id.logoKotlin);

    }

    @Override
    public void onClick(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.channelUrl)));
        startActivity(browserIntent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        App.toast(activityList.getItemAtPosition(i).toString());

        String selectedName = getPackageName() + "." + activityList.getItemAtPosition(i).toString();

        try {
            Class<?> className = Class.forName(selectedName);

            Intent intent = new Intent(this, className);
            startActivity(intent);
        } catch (Exception ex) {
            App.toast(ex.getMessage());
        }
    }

}
