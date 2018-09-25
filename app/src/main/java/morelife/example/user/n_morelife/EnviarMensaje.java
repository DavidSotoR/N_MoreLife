package morelife.example.user.n_morelife;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.widget.Toast;

public class EnviarMensaje extends AppCompatActivity {


    public void Enviar(Context context, String telefono, String mensaje){

        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(telefono,null,mensaje,null,null);
            Toast.makeText(context,"Mensaje enviado",Toast.LENGTH_SHORT).show();
            
        }
        catch (Exception e){
            Toast.makeText(context,"Mensaje no enviados",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    public void Enviar2(String telefono, String mensaje){

        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(telefono,null,mensaje,null,null);
            //Toast.makeText(context,"Mensaje enviado",Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){
            //Toast.makeText(context,"Mensaje no enviados",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

}

