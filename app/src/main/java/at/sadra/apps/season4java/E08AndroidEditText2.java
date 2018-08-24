package at.sadra.apps.season4java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import app.App;

public class E08AndroidEditText2 extends AppCompatActivity implements View.OnClickListener,TextWatcher {


    EditText username, password;
    TextView forgetPassword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e08_2_android_edit_text);
        setTitle(R.string.E08AndroidEditText);

        initViews();
        setListeners();
    }

    public void initViews() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        forgetPassword = findViewById(R.id.forgetPassword);

        login = findViewById(R.id.login);


    }


    private void setListeners() {
        login.setOnClickListener(this);
        forgetPassword.setOnClickListener(this);
        username.addTextChangedListener(this);
        password.addTextChangedListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == login) {
            goLogin();
        }else if (view == forgetPassword){
            goForgetPassword();
        }
    }

    private void goForgetPassword() {
        App.toast(getString(R.string.forgetPasswordText));
    }

    private void goLogin() {
        String uName = username.getText().toString().trim();
        String pwd = password.getText().toString();

        if (uName.length() < 3) {
            App.toast(getString(R.string.shortUserNameError));
            return;
        }

        if (pwd.length() < 6) {
            App.toast(getString(R.string.shortPasswordError));
            return;
        }

        App.toast(getString(R.string.welcomeLogin).replace("%s", uName));


    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        App.log("onTextChanged");
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
