package mx.edu.ittepic.dadm_minijuego;

import android.graphics.Color;
import android.os.CountDownTimer;

/**
 * Created by fraaa on 28/10/2017.
 */

public class Poque {
    float x,y;
    Boolean separo=false;
    CountDownTimer t;
    int color, arriba=0;
    boolean movimiento=true;

    public Poque(Lienzo1 v){
        x=(float) (Math.random()*1200);
        y=(float)(Math.random()*30);
        final Lienzo1 li=v;
        t = new CountDownTimer(10,1) {
            @Override
            public void onTick(long l) {

                //x+=5;
                if (movimiento==true){
                    y+=10;
                }

                if (y>=750){
                    y=(float)(Math.random()*20);
                    x=(float)(Math.random()*1300);
                }

                li.invalidate();
            }

            @Override
            public void onFinish() {parar();}

        };
        parar();
        color= Color.RED;
    }
    public void parar(){
        if(separo){
            t.cancel();
        }else {
            t.start();
        }
    }
}

