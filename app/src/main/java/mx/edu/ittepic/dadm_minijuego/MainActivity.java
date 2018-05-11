package mx.edu.ittepic.dadm_minijuego;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView comenzar,salir,acerca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        comenzar=(ImageView)findViewById(R.id.comenzar);
        salir=(ImageView)findViewById(R.id.salir);
        acerca=(ImageView)findViewById(R.id.acerca);

        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent frida= new Intent(MainActivity.this,QuienPo.class);

                startActivity(frida);
            }
        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta= new AlertDialog.Builder(MainActivity.this);
                alerta.setTitle("Equipo <- Las Flowers ->").
                        setMessage("Alumnos: \n" +"Ulises Francisco Silva Guerra \n"+
                        "Jorge Daniel Rubio Rodriguez \n").
                        setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                alerta.show();
            }
        });
    }
}
