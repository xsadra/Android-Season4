package app;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Sadra on 18/08/11.
 */

public class App {

    public static class main {
        public static final String TAG = "SEASON 4";
        public static final String FONT_PATH = "fonts/";
        public static final String FONT_GOUDY_BOOK_LETTER = "GoudyBookletter1911.ttf";
    }

    public static void log(String message) {
        Log.e(main.TAG, message);
    }

    public static void toast(String message) {
        Toast.makeText(Application.getContext(), message, Toast.LENGTH_LONG).show();
    }

}
