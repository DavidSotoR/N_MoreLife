package morelife.example.user.n_morelife;

import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.widget.Toast;

public class EnviarMensaje extends AppCompatActivity {
    //Toast toast = new Toast();
    MainActivity mainActivity;

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void Enviar(String telefono, String mensaje){

        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(telefono,null,mensaje,null,null);
            //Toast.makeText(this.mainActivity,"Mensaje enviado",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            //Toast.makeText(this.mainActivity,"Mensaje no enviados",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

}

