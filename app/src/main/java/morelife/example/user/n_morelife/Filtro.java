package morelife.example.user.n_morelife;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class Filtro extends Service {
   private Filtro filtro;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        EstatusPantalla();
    }

    private void EstatusPantalla() {
        Receiver_Pantalla receiver_pantalla = new Receiver_Pantalla();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(receiver_pantalla,filter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        SinEstatusPantalla();
    }

    private void SinEstatusPantalla() {
        Receiver_Pantalla receiver_pantalla = new Receiver_Pantalla();
        try {
            if (filtro!=null){
                unregisterReceiver(receiver_pantalla);
            }
        }catch (IllegalArgumentException ignore){

        }
    }
}
