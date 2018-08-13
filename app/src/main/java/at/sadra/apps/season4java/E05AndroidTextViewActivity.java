package at.sadra.apps.season4java;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import app.App;

public class E05AndroidTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e05_android_text_view);

        setTitle(R.string.E05AndroidTextViewActivity);

        TextView textBody = (TextView) findViewById(R.id.textBody);

//        Typeface typeface = Typeface.MONOSPACE;

        Typeface typeface = Typeface.createFromAsset(getAssets(), App.main.FONT_PATH + App.main.FONT_GOUDY_BOOK_LETTER);
        textBody.setTypeface(typeface);
    }
}
