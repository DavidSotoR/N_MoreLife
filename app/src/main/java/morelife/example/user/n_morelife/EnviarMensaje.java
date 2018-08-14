package morelife.example.user.n_morelife;

import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.widget.Toast;

public class EnviarMensaje extends AppCompatActivity {

    public void Enviar(String telefono,String mensaje){

        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(telefono,null,mensaje,null,null);
            //Toast.makeText(this,"Mensaje enviado",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            //Toast.makeText(this,"Mensaje no enviados",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
