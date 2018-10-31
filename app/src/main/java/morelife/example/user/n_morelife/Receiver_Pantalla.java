package morelife.example.user.n_morelife;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

public class Receiver_Pantalla extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        SharedPreferences preferences = context.getSharedPreferences("contactos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        String cont = preferences.getString("cont", "");
        Hilo hilo = new Hilo(context);
        MainActivity mainActivity = new MainActivity();

        if (Objects.equals(intent.getAction(), Intent.ACTION_SCREEN_ON)) {
            if (cont.equals("0")) {
                hilo.execute();
                //mainActivity.locationStart();
                editor.putString("cont", "1");
                editor.apply();
                Toast.makeText(context, cont, Toast.LENGTH_SHORT).show();
                int permissionCheck_gps = ContextCompat.checkSelfPermission(context,
                        Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck_gps != PackageManager.PERMISSION_GRANTED) {
                    Log.i("Ubicacion", "NO tiene permisos para Ubicacion");
                    /*ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            1);*/
                    ActivityCompat.requestPermissions(
                            (Activity) context, new String[] { android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION }, 1222);
                } else {
                    Log.i("Ubicacion", "Se tiene permisos para Ubicacion");
                    locationStart2(context);
                }


            } else if (cont.equals("1")) {
                editor.putString("cont", "2");
                editor.apply();
                Toast.makeText(context, cont, Toast.LENGTH_SHORT).show();
            } else if (cont.equals("2")) {
                editor.putString("cont", "3");
                editor.apply();
                Toast.makeText(context, cont, Toast.LENGTH_SHORT).show();
            } else if (cont.equals("3")) {
                editor.putString("cont", "0");
                String tel1 = preferences.getString("tel1", "");
                String tel2 = preferences.getString("tel2", "");
                String tel3 = preferences.getString("tel3", "");
                String tel4 = preferences.getString("tel4", "");
                String tel5 = preferences.getString("tel5", "");

                String lon = preferences.getString("longitud", "");
                String lan = preferences.getString("latitude", "");
                try {

                    int permissionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.SEND_SMS);
                    if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(context, "Nose tiene permiso para enviar SMS.", Toast.LENGTH_SHORT).show();
                        //Abre el panel para dar los permisos necesarios para el envio de los mensajes en caso no no tenerlos.
                        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.SEND_SMS}, 225);
                    } else {
                        Log.i("Mensaje", "Se tiene permisos para enviar SMS");
                    }
                    String nombre = preferences.getString("NombreUsuario","");

                    String mensaje = nombre+" necesita ayuda ubicacion http://maps.google.com/maps?f=q&q=(" + lan + "," + lon + ")";
                    EnviarMensaje enviarMensaje = new EnviarMensaje();
                    enviarMensaje.Enviar2(tel1, mensaje);
                    enviarMensaje.Enviar2(tel2, mensaje);
                    enviarMensaje.Enviar2(tel3, mensaje);
                    enviarMensaje.Enviar2(tel4, mensaje);
                    enviarMensaje.Enviar2(tel5, mensaje);

                    Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(1000);

                } catch (Exception e) {
                    Toast.makeText(context, "#Error", Toast.LENGTH_SHORT).show();
                }

            }

        }

    }

    private void locationStart2(Context context) {
        Localizacion_Receiver localizacion_receiver = new Localizacion_Receiver(context);
        LocationManager mlocationmanager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);


        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mlocationmanager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0, (LocationListener) localizacion_receiver);
        mlocationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER,10000,0, (LocationListener) localizacion_receiver);
    }

    private class Localizacion_Receiver implements LocationListener {
        Context context_re;
        public Localizacion_Receiver(Context context) {
            this.context_re = context;
        }

        @Override
        public void onLocationChanged(Location location) {
            location.getLatitude();
            location.getLongitude();

            SharedPreferences preferences_2= this.context_re.getSharedPreferences("contactos",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor_2=preferences_2.edit();
            String la= ""+location.getLatitude();
            String lo= ""+location.getLongitude();
            Log.i("Long",lo);
            Log.i("Lat",la);
            editor_2.putString("latitude",la);
            editor_2.putString("longitud",lo);
            editor_2.apply();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}
