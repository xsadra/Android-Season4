package at.sadra.apps.season4java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

public class E19AndroidContactBadge extends AppCompatActivity {

    QuickContactBadge quickContactBadgeEmail;
    QuickContactBadge quickContactBadgePhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e19_android_contact_badge);
        setTitle(getString(R.string.E19AndroidContactBadge));
        init();
    }

    private void init() {
        quickContactBadgeEmail = findViewById(R.id.contactBadgeEmail);
        quickContactBadgePhone= findViewById(R.id.contactBadgePhone);

        quickContactBadgeEmail.assignContactFromEmail("Sadra.babai@gmail.com",true);
        quickContactBadgePhone.assignContactFromPhone("09176663359",true);

    }
}
