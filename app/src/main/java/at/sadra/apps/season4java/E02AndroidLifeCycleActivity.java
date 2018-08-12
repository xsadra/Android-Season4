package at.sadra.apps.season4java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.*;

public class E02AndroidLifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e02_android_life_cycle);

        setTitle(getResources().getString(R.string.E02AndroidLifeCycleActivity));

        App.log("on Create");
        App.toast("on Create");
    }

    @Override
    protected void onStart() {
        super.onStart();

        App.log("on Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.toast("on Resume");
        App.log("on Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        App.log("on Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        App.log("on Stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        App.log("on Restart");
    }

    @Override
    protected void onDestroy() {
        App.log("On Destroy");

        super.onDestroy();
    }

}
