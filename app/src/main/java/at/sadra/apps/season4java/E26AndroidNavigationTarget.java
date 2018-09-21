package at.sadra.apps.season4java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import app.App;

public class E26AndroidNavigationTarget extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e26_android_navigation_target);
        setTitle(getString(R.string.E26AndroidNavigationTarget));

        result = findViewById(R.id.result);

        handleInput();
    }

    private void handleInput() {
        //firstOption();
        Intent intent= getIntent();

        if (!intent.hasExtra(App.main.ACTIVITY_KEY)) {
            App.toast(getString(R.string.noContent));
            return;
        }

        String dataValue = intent.getStringExtra(App.main.ACTIVITY_KEY);

        String res = "";

        switch (dataValue) {
            case "1":
                res = getString(R.string.morning);
                break;
            case "2":
                res = getString(R.string.afternoon);
                break;
            case "3":
                res = getString(R.string.night);
                break;
            default:
                res = getString(R.string.intentData).replace("%s", dataValue);
                break;
        }

        result.setText(res);
    }

    private void firstOption() {
        Intent intent= getIntent();

        if (intent.hasExtra(App.main.ACTIVITY_KEY)) {
            String dataValue = intent.getStringExtra(App.main.ACTIVITY_KEY);
            String resultData = getString(R.string.intentData).replace("%s", dataValue);
            result.setText(resultData);
        }else {
            App.toast(getString(R.string.noContent));
        }
    }
}
