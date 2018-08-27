package at.sadra.apps.season4java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class E20AndroidLayouts extends AppCompatActivity {

    TextView textView;
    EditText message;
    Button sendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e20_android_layouts_frame_layout);
        setTitle(getString(R.string.E20AndroidLayouts));
        init();
    }

    private void init() {
        textView = findViewById(R.id.textMessageView);
        message = findViewById(R.id.textMessage);
        sendMessage = findViewById(R.id.sendMessage);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageText = message.getText().toString();
                String lastMessage = textView.getText().toString();
                textView.setText(String.format("%s\n%s", lastMessage, messageText));
                message.setText("");
            }
        });
    }
}
