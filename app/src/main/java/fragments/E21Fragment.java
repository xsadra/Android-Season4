package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import app.App;
import at.sadra.apps.season4java.R;

public class E21Fragment extends Fragment implements View.OnClickListener{

    EditText username, password;
    Button login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.e21_fargment,container,false);

        username = rootView.findViewById(R.id.username);
        password = rootView.findViewById(R.id.password);
        login = rootView.findViewById(R.id.login);

login.setOnClickListener(this);
        return rootView;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        App.toast(username.getText().toString() + getString(R.string.timeSpacer) + password.getText().toString());
    }
}
