package morelife.example.user.n_morelife;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.Objects;

public class Receiver_Pantalla extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        SharedPreferences preferences = context.getSharedPreferences("contactos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        String cont = preferences.getString("cont","");
        Hilo hilo = new Hilo(context);


        if (Objects.equals(intent.getAction(),Intent.ACTION_SCREEN_ON)){

            if (cont.equals("0")){
                hilo.execute();
                editor.putString("cont","1");
                editor.apply();
                Toast.makeText(context,cont,Toast.LENGTH_SHORT).show();
            }else if (cont.equals("1")){
                editor.putString("cont","2");
                editor.apply();
                Toast.makeText(context,cont,Toast.LENGTH_SHORT).show();
            }else if (cont.equals("2")){
                editor.putString("cont","3");
                editor.apply();
                Toast.makeText(context,cont,Toast.LENGTH_SHORT).show();
            }else if (cont.equals("3")){
                editor.putString("cont","0");
                String tel1 = preferences.getString("tel1","");
                String lon = preferences.getString("longitud","");
                String lan = preferences.getString("latitude","");
                try {
                    String mensaje = "Ayuda ubicacion http://maps.google.com/maps?f=q&q=("+lan+","+lon+") ";
                    EnviarMensaje enviarMensaje = new EnviarMensaje();
                    enviarMensaje.Enviar2(tel1,mensaje);
                }catch (Exception e){
                    Toast.makeText(context,"no funciona",Toast.LENGTH_SHORT).show();
                }

            }

        }

    }
}
