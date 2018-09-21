package at.sadra.apps.season4java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import app.App;

public class E25AndroidSpinner extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    Spinner languagesSpinner;
    Button submit;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e25_android_spinner);
        setTitle(getString(R.string.E25AndroidSpinner));

        init();
        setListener();
    }

    private void setListener() {
        submit.setOnClickListener(this);
        languagesSpinner.setOnItemSelectedListener(this);
    }

    private void init() {
        languagesSpinner = findViewById(R.id.languagesSpinner);
        submit = findViewById(R.id.submit);
        result = findViewById(R.id.result);
    }

    @Override
    public void onClick(View view) {
        App.toast(result.getText().toString());
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        showSelectedItemInResult();
    }

    private void showSelectedItemInResult() {
        String language = languagesSpinner.getSelectedItem().toString();
        String res = getString(R.string.resultLang).replace("%s", language);

        result.setText(res);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        App.toast(getString(R.string.selectRequire));
    }
}
