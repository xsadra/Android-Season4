package at.sadra.apps.season4java;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import app.App;

public class E24AndroidVideoView extends AppCompatActivity implements View.OnClickListener {

    VideoView videoView;
    ImageView readApp, readSD, readWeb;

    LinearLayout urlParent, controlParent;
    EditText url;
    ImageView go, fullscreen;

    private static final int READ_EXTERNAL_STORAGE_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e24_android_video_view);
        setTitle(getString(R.string.E24AndroidVideoView));

        init();
        setListener();


    }


    private void setListener() {
        readApp.setOnClickListener(this);
        readSD.setOnClickListener(this);
        readWeb.setOnClickListener(this);

        go.setOnClickListener(this);

        fullscreen.setOnClickListener(this);
    }

    private void init() {
        videoView = findViewById(R.id.videoView);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);

        readApp = findViewById(R.id.readApp);
        readSD = findViewById(R.id.readSD);
        readWeb = findViewById(R.id.readWeb);

        urlParent = findViewById(R.id.urlParent);
        url = findViewById(R.id.url);
        go = findViewById(R.id.go);
        controlParent = findViewById(R.id.controlParent);

        fullscreen = findViewById(R.id.fullscreen);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.readApp: {
                playFromApp();
                break;
            }
            case R.id.readSD: {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (!checkPermission()) {
                        requestPermission();
                        playFromSdCard();
                        break;
                    }
                }

                //playFromSdCard();
                break;
            }
            case R.id.readWeb: {
                if (urlParent.getVisibility() == View.GONE) {
                    urlParent.setVisibility(View.VISIBLE);
                    urlParent.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
                } else {
                    Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
                    urlParent.startAnimation(animation);

                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            urlParent.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }
                break;
            }
            case R.id.go: {
                String url = this.url.getText().toString();
                playFromAUrl(url);
                break;
            }
            case R.id.fullscreen: {
                if (controlParent.getVisibility() == View.GONE) {
                    controlParent.setVisibility(View.VISIBLE);
                    controlParent.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
                } else {
                    Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
                    controlParent.startAnimation(animation);

                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            controlParent.setVisibility(View.GONE);

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }
                break;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            App.toast(getString(R.string.grantAccess));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case READ_EXTERNAL_STORAGE_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    App.log(((Integer) grantResults[0]).toString());
                    playFromSdCard();
                } else {
                    App.toast(getString(R.string.permissionDenied));
                }
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private Boolean checkPermission() {
        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
//        if (permission == PackageManager.PERMISSION_GRANTED){
//            return true;
//        }
//        return false;

        return (permission == PackageManager.PERMISSION_GRANTED);
    }


    private void playFromApp() {
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI(uri);
        videoView.start();
    }

    private void playFromSdCard() {

        try {
            String videoPath = Environment.getExternalStorageDirectory().getPath() + "/Download/video.mp4";
            App.log(videoPath);
            videoView.setVideoPath(videoPath);
            videoView.start();
        } catch (Exception ex) {
            App.log(ex.getMessage());
        }

    }

    private void playFromAUrl(String url) {
//        String videoUrl = "https://sample-videos.com/video/mp4/480/big_buck_bunny_480p_1mb.mp4";
        Uri uri = Uri.parse(url);
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
