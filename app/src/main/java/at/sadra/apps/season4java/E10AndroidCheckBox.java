package at.sadra.apps.season4java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.Arrays;
import java.util.List;

import app.App;

public class E10AndroidCheckBox extends AppCompatActivity implements View.OnClickListener {

    CheckBox java, python, c, kotlin, php;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e10_android_check_box);
        setTitle(getString(R.string.E10AndroidCheckBox));

        init();
    }

    private void init() {
        java = findViewById(R.id.checkBoxJava);
        python = findViewById(R.id.checkBoxPython);
        c = findViewById(R.id.checkBoxC);
        kotlin = findViewById(R.id.checkBoxKotlin);
        php = findViewById(R.id.checkBoxPHP);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String result = getString(R.string.result);
        String langs = "";

        List<CheckBox> checkBoxes = Arrays.asList(java, python, c, kotlin, php);

        for (CheckBox item : checkBoxes) {
            if (item.isChecked()) {
                if (langs.length() > 1) {
                    langs += getString(R.string.spacer);
                }
                langs += item.getText().toString();
            }
        }
        result = (langs.length()>0)?result.replace("%s", langs):getString(R.string.noResponse);
        App.toast(result);
        App.log(result);
    }
}
