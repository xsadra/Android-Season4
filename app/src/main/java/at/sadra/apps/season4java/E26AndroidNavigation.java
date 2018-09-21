package at.sadra.apps.season4java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.time.Instant;

import app.App;

public class E26AndroidNavigation extends AppCompatActivity implements View.OnClickListener{

    Spinner navigation;
    Button navigate, submit;
    EditText data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e26_android_navigation);
        setTitle(getString(R.string.E26AndroidNavigation));
        init();

        navigate.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    private void init() {
        navigation = findViewById(R.id.navigation);
        navigate = findViewById(R.id.navigate);
        submit = findViewById(R.id.submit);
        data = findViewById(R.id.data);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.navigate){
            switch (navigation.getSelectedItemPosition()){
                case 0:{
                    App.toast(getString(R.string.selectRequire));
                    break;
                }
                case 1:{
                    Intent intent = new Intent(this,E25AndroidSpinner.class);
                    startActivity(intent);
                    break;
                }
                case 2:{
                    Intent intent = new Intent(this,E24AndroidVideoView.class);
                    startActivity(intent);
                    break;}
                case 3:{
                    Intent intent = new Intent(this,E23AndroidWebView.class);
                    startActivity(intent);
                    break;}
                case 4:{
                    Intent intent = new Intent(this,E22AndroidScrollView.class);
                    startActivity(intent);
                    break;}
            }
        }else if (view.getId() == R.id.submit){
            Intent intent = new Intent(this,E26AndroidNavigationTarget.class);
            String dataValue = data.getText().toString();
            intent.putExtra(App.main.ACTIVITY_KEY, dataValue);
            startActivity(intent);
        }

    }
}
