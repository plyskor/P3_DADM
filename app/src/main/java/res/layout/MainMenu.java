package res.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.ComponentName;
import android.os.IBinder;
import android.content.Context;
import android.preference.PreferenceManager;
import com.example.jose.connect3.C3Preference;
import com.example.jose.connect3.R;
import com.example.jose.connect3.MusicService;
import android.media.MediaPlayer;

import java.io.IOException;

public class MainMenu extends AppCompatActivity {
    private static boolean mIsBound = false;
    private MusicService mServ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);
        if (!MainMenu.mIsBound) {
            doBindService();
            Intent music = new Intent();
            music.setClass(this, MusicService.class);
            startService(music);
        }

    }

    private ServiceConnection Scon = new ServiceConnection() {

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinder) binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService() {
        bindService(new Intent(this, MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        MainMenu.mIsBound = true;
    }

    void doUnbindService() {
        if (MainMenu.mIsBound) {
            unbindService(Scon);
            MainMenu.mIsBound = false;
        }
    }

    protected void onPause() {
        super.onPause();
        Boolean play = false;
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (sharedPreferences.contains(C3Preference.PLAY_MUSIC_KEY))
            play = sharedPreferences.getBoolean(C3Preference.PLAY_MUSIC_KEY,
                    C3Preference.PLAY_MUSIC_DEFAULT);


    }

    public void startLogin(View view) {
        Intent intent = new Intent("android.intent.action.C3.LOGIN");
        startActivity(intent);
    }

    public void startRatings(View view) {
        Intent intent = new Intent("android.intent.action.C3.RATINGS");
        startActivity(intent);
    }

    public void startTopTen(View view) {
        Intent intent = new Intent("android.intent.action.C3.TOPTEN");
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAbout:
                startActivity(new Intent(this, About.class));
                return true;

            case R.id.menuPreferences:
                startActivity(new Intent(this, C3Preference.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onResume() {
        super.onResume();
        Boolean play = false;
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (sharedPreferences.contains(C3Preference.PLAY_MUSIC_KEY))
            play = sharedPreferences.getBoolean(C3Preference.PLAY_MUSIC_KEY,
                    C3Preference.PLAY_MUSIC_DEFAULT);
        if (play == true) {

        }
        if (play == false) {


        }
    }

    protected void onDestroy() {
        super.onDestroy();
        doUnbindService();
        if (isFinishing()) {



                Intent music = new Intent();
                music.setClass(this, MusicService.class);
                mServ.stopService(music);


        }
    }
}