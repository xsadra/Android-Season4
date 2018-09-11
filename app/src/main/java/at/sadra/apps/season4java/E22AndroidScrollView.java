
package at.sadra.apps.season4java;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class E22AndroidScrollView extends AppCompatActivity implements View.OnClickListener{

    ScrollView scrollView;
    FloatingActionButton gotoTop;
    TextView textTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e22_android_scroll_view);
        setTitle(getString(R.string.E22AndroidScrollView));

        scrollView = findViewById(R.id.mainScrollView);
        gotoTop = findViewById(R.id.goToTop);
        textTitle = findViewById(R.id.textTitle );

        gotoTop.setOnClickListener(this);
        textTitle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == gotoTop){
//            scrollView.smoothScrollTo(0,0);
            scrollView.fullScroll(ScrollView.FOCUS_UP);
        }else if(view == textTitle){
            scrollView.smoothScrollTo(0, gotoTop.getBottom());
        }
    }
}
