package morelife.example.user.n_morelife;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED&&ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.SEND_SMS)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS,},1000);
        }


    }

    public void Onclick(View view) {
        switch (view.getId()){
            case R.id.btnEnviar:
                SharedPreferences preferences = getSharedPreferences("contactos", Context.MODE_PRIVATE);
                EnviarMensaje mensaje = new EnviarMensaje();
                String mensaje_enviado="Ayudmme perro que me matan D:";

                String tel1 = preferences.getString("tel1","");
                String tel2 = preferences.getString("tel2","");
                String tel3 = preferences.getString("tel3","");
                String tel4 = preferences.getString("tel4","");
                String tel5 = preferences.getString("tel5","");

                try{
                    mensaje.Enviar(tel1,mensaje_enviado);
                    mensaje.Enviar(tel2,mensaje_enviado);
                    mensaje.Enviar(tel3,mensaje_enviado);
                    mensaje.Enviar(tel4,mensaje_enviado);
                    mensaje.Enviar(tel5,mensaje_enviado);

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Error al enviar",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


                break;

            case  R.id.btnAgregar:
                Intent intent = new Intent(MainActivity.this,AgregarUsuarios.class);
                startActivity(intent);
                break;
        }
    }
}
