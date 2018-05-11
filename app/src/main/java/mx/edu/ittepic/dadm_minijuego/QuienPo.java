package mx.edu.ittepic.dadm_minijuego;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class QuienPo extends AppCompatActivity {
    private MediaPlayer reproductor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        reproductor=MediaPlayer.create(this,R.raw.fondopoke);
        reproductor.setLooping(true);
        reproductor.start();
        setContentView(new Lienzo1(this));

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(reproductor.isPlaying()){
            reproductor.stop();
            reproductor.release();
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        reproductor.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        reproductor.pause();
    }
}
