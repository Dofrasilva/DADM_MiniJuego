package mx.edu.ittepic.dadm_minijuego;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ImageFormat;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by fraaa on 28/10/2017.
 */

public class Lienzo1 extends View {
    int cont=0;
    Poque [] f;
    Monedas[]m;

    Bitmap im,pika,pokebolas,mone;
    int zx;
    int perdio=0;
    public Lienzo1(Context context) {
        super(context);
        im= BitmapFactory.decodeResource(getResources(),R.drawable.fondo);
        pika= BitmapFactory.decodeResource(getResources(),R.drawable.pikachuu);
        pokebolas= BitmapFactory.decodeResource(getResources(),R.drawable.pokeb);
        mone= BitmapFactory.decodeResource(getResources(),R.drawable.moneda);
        f = new Poque [7];

        for(int i =0;i<f.length;i++){
            f [i] =new Poque(this);
        }

        m= new Monedas[4];
        for(int z=0;z<m.length;z++){
            m[z]=new Monedas(this);
        }



    }
    public void onDraw (Canvas c) {

        for(int z =0;z<m.length;z++){
            if (m[z].ymo+60>=560) {
                //cont++;
                if ((m[z].xmo>=zx && zx+180<=m[z].xmo)||(m[z].xmo+50>=zx && m[z].xmo+50<=zx+180)  ) {//(m[z].xmo+60)

                    cont=cont+1;
                    for (int h=0;h<m.length;h++){

                        m[h].ymo=(float)(Math.random()*20);
                        m[h].xmo=(float)(Math.random()*1300);

                    }

                }
            }
        }
        for(int i =0;i<f.length;i++){
            if (f[i].y+50>=560){
                if (f[i].x+65>=zx && f[i].x+65<=zx+180) {
                    perdio++;
                    for (int h=0;h<f.length;h++){
                        f[h].separo=true;
                        if( f[h].separo=true){
                            for (int l=0;l<m.length;l++){
                                m[l].separo1=true;


                            }
                        }
                    }
                    if(perdio==1){
                        AlertDialog.Builder alerta=new AlertDialog.Builder(getContext());
                        alerta.setTitle("Fuiste atrapado").
                                setMessage("Monedas: "+cont).
                                setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        Intent frida =new Intent(getContext(),MainActivity.class);
                                        clearAnimation();

                                        getContext().startActivity(frida);
                                        dialogInterface.dismiss();
                                    }
                                });
                        alerta.show();
                    }
                }
            }
        }


        Paint p = new Paint();
        im = Bitmap.createScaledBitmap(im, getWidth(), getHeight(), false);
        c.drawBitmap(im,0,0,p);
        pokebolas = Bitmap.createScaledBitmap(pokebolas, 60, 60, false);
        mone = Bitmap.createScaledBitmap(mone, 50, 50, false);
        for(int i =0;i<f.length;i++){
            c.drawBitmap(pokebolas,f[i].x,f[i].y,p);
        }

        for(int z =0;z<m.length;z++){
            c.drawBitmap(mone,m[z].xmo,m[z].ymo,p);
        }


        pika = Bitmap.createScaledBitmap(pika, 100, 100, false);
        c.drawBitmap(pika,zx,550,p);





    }
    public boolean onTouchEvent(MotionEvent event){

        int eventaction = event.getActionMasked();

            int X = (int) event.getX();
            switch (eventaction) {

                case MotionEvent.ACTION_MOVE:
                     zx=X;

                    if (zx>=1720){
                       zx=1710;
                    }
                    if(zx<=-10){
                        zx=0;
                    }
                    break;

            }


        return true;
    }

}




