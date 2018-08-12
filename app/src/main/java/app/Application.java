package app;

import android.content.Context;

/**
 * Created by Sadra on 18/08/12.
 */

public class Application extends android.app.Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
