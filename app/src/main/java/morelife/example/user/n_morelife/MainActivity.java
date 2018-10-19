package morelife.example.user.n_morelife;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //protected LocationManager locationManager;
    TextView longitud,direccion,latitud,enviado;
    String tel1,tel2,tel3,tel4,tel5;
    private IntentFilter filter;
    private Context context_gps;

//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        //longitud = (TextView) findViewById(R.id.longitud);
        //direccion = (TextView) findViewById(R.id.mensaje2);
        //latitud = (TextView) findViewById(R.id.latitud);
        //enviado = findViewById(R.id.todo);
        context_gps = this;
        Intent intent = new Intent(this,Filtro.class);
        startService(intent);
        SharedPreferences preferences_in = getSharedPreferences("contactos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor_in = preferences_in.edit();
        editor_in.putString("cont","0");
        editor_in.apply();

        init();


        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED&&ActivityCompat.checkSelfPermission
                (MainActivity.this,Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS},1000);
        }


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,},1000);

        }else {locationStart(); }

    }

    private void init() {
        filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
    }

    public void Onclick(View view) {
        switch (view.getId()){
            case R.id.btnEnviar:
                int permissionCheck_gps = ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck_gps != PackageManager.PERMISSION_GRANTED){
                    Log.i("Ubicacion","NO tiene permisos para Ubicacion");
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            1);
                    } else {
                        Log.i("Ubicacion","Se tiene permisos para Ubicacion");
                    }
                SharedPreferences preferences = getSharedPreferences("contactos", Context.MODE_PRIVATE);
                EnviarMensaje mensaje = new EnviarMensaje();

                String Long = preferences.getString("longitud","");//longitud.getText().toString();
                String lat = preferences.getString("latitude","");//latitud.getText().toString();
                //String dir = direccion.getText().toString();

                String mensaje_enviado="Necesito ayuda mi ubicacion http://maps.google.com/maps?f=q&q=("+lat+","+Long+") ";

                 tel1 = preferences.getString("tel1","");
                 tel2 = preferences.getString("tel2","");
                 tel3 = preferences.getString("tel3","");
                 tel4 = preferences.getString("tel4","");
                 tel5 = preferences.getString("tel5","");

               /* */
                //enviado.setText(mensaje_enviado);

                try{
                    int permissionCheck = ContextCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS);
                    if (permissionCheck!=PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(getApplicationContext(),"Nose tiene permiso para enviar SMS.",Toast.LENGTH_SHORT).show();
                        //Abre el panel para dar los permisos necesarios para el envio de los mensajes en caso no no tenerlos.
                        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},225);
                    }else {
                        Log.i("Mensaje","Se tiene permisos para enviar SMS");
                    }

                    Context context = this;
                    mensaje.Enviar(context, tel1,mensaje_enviado);
                    mensaje.Enviar(context, tel2,mensaje_enviado);
                    mensaje.Enviar(context, tel3,mensaje_enviado);
                    mensaje.Enviar(context, tel4,mensaje_enviado);
                    mensaje.Enviar(context, tel5,mensaje_enviado);
                    //Toast.makeText(getApplicationContext(),"Mensajes enviados",Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    //Toast.makeText(getApplicationContext(),"Error al enviar",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                break;

            case  R.id.btnAgregar:
                Intent intent = new Intent(MainActivity.this,AgregarUsuarios.class);
                startActivity(intent);
                break;

            case R.id.btnFalsaAlarma:
                SharedPreferences preferencesf = getSharedPreferences("contactos", Context.MODE_PRIVATE);
                EnviarMensaje mensajef = new EnviarMensaje();
                 tel1 = preferencesf.getString("tel1","");
                 tel2 = preferencesf.getString("tel2","");
                 tel3 = preferencesf.getString("tel3","");
                 tel4 = preferencesf.getString("tel4","");
                 tel5 = preferencesf.getString("tel5","");
                 try {
                     mensajef.Enviar2(tel1,"Falsa Alarma");
                     mensajef.Enviar2(tel2,"Falsa Alarma");
                     mensajef.Enviar2(tel3,"Falsa Alarma");
                     mensajef.Enviar2(tel4,"Falsa Alarma");
                     mensajef.Enviar2(tel5,"Falsa Alarma");
                     Toast.makeText(getApplicationContext(),"Mensajes Enviados",Toast.LENGTH_SHORT).show();

                 }catch (Exception e){
                  Toast.makeText(getApplicationContext(),"Error al enviar mensaje",Toast.LENGTH_SHORT).show();
                 }
                break;

            case R.id.btnInfo:
                Intent intent_info = new Intent(MainActivity.this,Informacion.class);
                startActivity(intent_info);
                break;

        }
    }
    //antes era private, si hay error ya sabes porque
    public void locationStart() {
        // <uses-feature android:name="android.hardware.location.gps" />
        Localizacion Local = new Localizacion();
        Local.setMainActivity(this);
        LocationManager mlocationmanager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        final Boolean gpsEnable = mlocationmanager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        mlocationmanager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (!gpsEnable){
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Log.i("GPS","NO Se tiene permisos para GPS");

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,},1000);
            return;

        }

        mlocationmanager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,Local);
        mlocationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,Local);
        //longitud.setText("Localizacion agregada");
        //direccion.setText("");
    }

/*    public void setLocation(Location location) {
        if (location.getLatitude()!= 0.0 && location.getLongitude()!=0.0){
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                if (!list.isEmpty()){
                    Address DirCalle = list.get(0);
                    //direccion.setText("Direccion: \n"+DirCalle.getAddressLine(0));
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }*/


    public class Localizacion implements LocationListener{
        MainActivity mainActivity;
        public MainActivity getMainActivity(){return mainActivity;}

        public void setMainActivity(MainActivity mainActivity) {this.mainActivity = mainActivity; }


        @Override
        public void onLocationChanged(Location location) {
            //Prueba de permiso

            location.getLatitude();
            location.getLongitude();

            String Text = ""+location.getLatitude();
            String Text2 = ""+location.getLongitude();
            //longitud.setText(Text2);
            //latitud.setText(Text);
            SharedPreferences preferences_l= getSharedPreferences("contactos",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor_l=preferences_l.edit();
            String la= ""+location.getLatitude();
            String lo= ""+location.getLongitude();
            editor_l.putString("latitude",la);
            editor_l.putString("longitud",lo);
            editor_l.apply();


            //this.mainActivity.setLocation(location);

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
            switch (i){
                case LocationProvider.AVAILABLE:
                    Log.d("debug","LocationProvider.AVAILABLE");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.d("debug","LocationProvider.OUT_OF_SERVICE");
                    break;
            }

        }

        @Override
        public void onProviderEnabled(String s) {
            //longitud.setText("Gps Localizando");
            //latitud.setText("Gps Localizando");

        }

        @Override
        public void onProviderDisabled(String s) {
            //longitud.setText("Gps desactivado");
            //latitud.setText("Gps desactivado");

        }
    }
}



