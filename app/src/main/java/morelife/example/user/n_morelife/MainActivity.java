package morelife.example.user.n_morelife;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //protected LocationManager locationManager;
    TextView longitud,direccion,latitud,enviado;

//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        longitud = (TextView) findViewById(R.id.longitud);
        direccion = (TextView) findViewById(R.id.mensaje2);
        latitud = (TextView) findViewById(R.id.latitud);
        enviado = findViewById(R.id.todo);


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

    public void Onclick(View view) {
        switch (view.getId()){
            case R.id.btnEnviar:

                SharedPreferences preferences = getSharedPreferences("contactos", Context.MODE_PRIVATE);
                EnviarMensaje mensaje = new EnviarMensaje();

                String Long = longitud.getText().toString();
                String lat = latitud.getText().toString();
                //String dir = direccion.getText().toString();

                String mensaje_enviado="Necesito ayuda Mi ubicacion http://maps.google.com/maps?f=q&q=("+lat+","+Long+") ";

                String tel1 = preferences.getString("tel1","");
                String tel2 = preferences.getString("tel2","");
                String tel3 = preferences.getString("tel3","");
                String tel4 = preferences.getString("tel4","");
                String tel5 = preferences.getString("tel5","");

               /* */

                enviado.setText(mensaje_enviado);

                try{

                    mensaje.Enviar(tel1,mensaje_enviado);
                    mensaje.Enviar(tel2,mensaje_enviado);
                    mensaje.Enviar(tel3,mensaje_enviado);
                    mensaje.Enviar(tel4,mensaje_enviado);
                    mensaje.Enviar(tel5,mensaje_enviado);
                    Toast.makeText(getApplicationContext(),"Mensajes enviados",Toast.LENGTH_SHORT).show();

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

    private void locationStart() {
        LocationManager mlocationmanager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Localizacion Local = new Localizacion();
        Local.setMainActivity(this);
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
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,},1000);
            return;

        }
        mlocationmanager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,Local);
        mlocationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,Local);
        longitud.setText("Localizacion agregada");
        direccion.setText("");
    }

    public void setLocation(Location location) {
        if (location.getLatitude()!= 0.0 && location.getLongitude()!=0.0){
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                if (!list.isEmpty()){
                    Address DirCalle = list.get(0);
                    direccion.setText("Direccion: \n"+DirCalle.getAddressLine(0));
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }




    public class Localizacion implements LocationListener{
        MainActivity mainActivity;
        public MainActivity getMainActivity(){return mainActivity;}

        public void setMainActivity(MainActivity mainActivity) {this.mainActivity = mainActivity; }

        @Override
        public void onLocationChanged(Location location) {
            location.getLatitude();
            location.getLongitude();

            String Text = ""+location.getLatitude();
            String Text2 = ""+location.getLongitude();
            longitud.setText(Text2);
            latitud.setText(Text);
            this.mainActivity.setLocation(location);

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
            longitud.setText("Gps Activado");

        }

        @Override
        public void onProviderDisabled(String s) {
            longitud.setText("Gps desactivado");

        }
    }
}



