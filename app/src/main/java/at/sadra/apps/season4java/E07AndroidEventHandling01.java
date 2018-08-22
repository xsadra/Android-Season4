package at.sadra.apps.season4java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import app.App;

public class E07AndroidEventHandling01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e07_01_android_eevent_handling);

        setTitle(getString(R.string.E07AndroidEventHandling));

    }

    public void clickManager(View view) {

//        if (view.getId() == R.id.firstButton) {
//            App.toast("First button Clicked!");
//        }
//        if (view.getId() == R.id.secondButton) {
//            App.toast("Second button Clicked!");
//        }
//        if (view.getId() == R.id.fab) {
//            App.toast("Add New Item!");
//        }
        switch (view.getId()){
            case R.id.firstButton:
                App.toast("--First Button Clicked--");
                App.toast("Start new Activity!");
                startActivity(new Intent(this, E06AndroidButtonActivity.class));
                break;
            case R.id.secondButton  :
                App.toast("--Second Button Clicked Finish :D --");
                finish();
                break;
            case R.id.fab:
                App.toast("--Fab Button Clicked--");
                break;
            default:
                App.toast("--No Button Clicked--");
        }

    }


}
