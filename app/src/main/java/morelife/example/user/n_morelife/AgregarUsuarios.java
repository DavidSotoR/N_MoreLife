package morelife.example.user.n_morelife;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AgregarUsuarios extends AppCompatActivity {
    EditText telefono1,telefono2,telefono3,telefono4,telefono5,campoNombre;
    TextView error_tel1;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private ValidarNumeros validarNumeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_agregar_usuarios);

        telefono1 = findViewById(R.id.campoTel1);
        telefono2 = findViewById(R.id.campoTel2);
        telefono3 = findViewById(R.id.campoTel3);
        telefono4 = findViewById(R.id.campoTel4);
        telefono5 = findViewById(R.id.campoTel5);

        campoNombre = findViewById(R.id.campoNombre);

        error_tel1 = findViewById(R.id.txtError_alerta);

        SharedPreferences crear_prefrences = getSharedPreferences("contactos",Context.MODE_PRIVATE);
        telefono1.setText(crear_prefrences.getString("tel1",""));
        telefono2.setText(crear_prefrences.getString("tel2",""));
        telefono3.setText(crear_prefrences.getString("tel3",""));
        telefono4.setText(crear_prefrences.getString("tel4",""));
        telefono5.setText(crear_prefrences.getString("tel5",""));
        campoNombre.setText(crear_prefrences.getString("NombreUsuario",""));

        preferences = getSharedPreferences("contactos",Context.MODE_PRIVATE);
        editor = preferences.edit();
        validarNumeros = new ValidarNumeros();

    }

    public void Onclick_Agregar(View view) {

        switch (view.getId()){
            case R.id.btnMensajePrueba:
                EnviarMensaje enviarMensaje_prueba = new EnviarMensaje();
                String contacto1 = preferences.getString("tel1","");
                String contacto2 = preferences.getString("tel2","");
                String contacto3 = preferences.getString("tel3","");
                String contacto4 = preferences.getString("tel4","");
                String contacto5 = preferences.getString("tel5","");

                enviarMensaje_prueba.Enviar2(contacto1,"Mensaje de prueba de la App Morelife.");
                enviarMensaje_prueba.Enviar2(contacto2,"Mensaje de prueba de la App Morelife.");
                enviarMensaje_prueba.Enviar2(contacto3,"Mensaje de prueba de la App Morelife.");
                enviarMensaje_prueba.Enviar2(contacto4,"Mensaje de prueba de la App Morelife.");
                enviarMensaje_prueba.Enviar2(contacto5,"Mensaje de prueba de la App Morelife.");

                Toast.makeText(this,"Mensajes de Prueba Enviados",Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnGuardarNombre:
                String NombreUsuario = campoNombre.getText().toString();
                if (NombreUsuario.length()<15){
                    editor.putString("NombreUsuario",NombreUsuario);
                    editor.apply();
                    Log.i("Usuario",""+NombreUsuario);
                    Toast.makeText(this,"Nombre Guardado",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"*ERROR Nombre debe ser menor a 15 caracteres",Toast.LENGTH_SHORT).show();
                }

                break;


            case R.id.btnSaveC1:
                String tf1 = telefono1.getText().toString();
                if (validarNumeros.esNumero(tf1) && tf1.length()==10){
                    error_tel1.setVisibility(View.GONE);
                    editor.putString("tel1",telefono1.getText().toString());
                    editor.apply();
                    Toast.makeText(this,"Contacto 1 Guardado",Toast.LENGTH_SHORT).show();
                }else {
                    error_tel1.setText(R.string.error_contacto);
                    error_tel1.setVisibility(View.VISIBLE);
                    Log.i("Error","contacto1 error");
                }
                break;
            case R.id.btnEraseC1:
                editor.putString("tel1","");
                editor.apply();
                telefono1.setText("");

                break;

            case R.id.btnSaveC2:
                String tf2 = telefono2.getText().toString();
                if (validarNumeros.esNumero(tf2) && tf2.length()==10){
                    editor.putString("tel2",telefono2.getText().toString());
                    error_tel1.setVisibility(View.GONE);
                    editor.apply();
                    Toast.makeText(this,"Contacto 2 Guardado",Toast.LENGTH_SHORT).show();
                }else {
                    error_tel1.setText(R.string.error_contacto);
                    error_tel1.setVisibility(View.VISIBLE);
                    Log.i("Error","contacto2 error");
                }
                break;
            case R.id.btnEraseC2:
                editor.putString("tel2","");
                editor.apply();
                telefono2.setText("");
                break;

            case R.id.btnSaveC3:
                String tf3 = telefono3.getText().toString();
                if (validarNumeros.esNumero(tf3) && tf3.length()==10){
                    editor.putString("tel3",telefono3.getText().toString());
                    error_tel1.setVisibility(View.GONE);
                    editor.apply();
                    Toast.makeText(this,"Contacto 3 Guardado",Toast.LENGTH_SHORT).show();
                }else {
                    error_tel1.setText(R.string.error_contacto);
                    error_tel1.setVisibility(View.VISIBLE);
                    Log.i("Error","contacto3 error");
                }
                break;
            case R.id.btnEraseC3:
                editor.putString("tel3","");
                editor.apply();
                telefono3.setText("");
                break;

            case R.id.btnSaveC4:
                String tf4 = telefono4.getText().toString();
                if (validarNumeros.esNumero(tf4) && tf4.length()==10){
                    editor.putString("tel4",telefono4.getText().toString());
                    error_tel1.setVisibility(View.GONE);
                    editor.apply();
                    Toast.makeText(this,"Contacto 4 Guardado",Toast.LENGTH_SHORT).show();
                }else {
                    error_tel1.setText(R.string.error_contacto);
                    error_tel1.setVisibility(View.VISIBLE);
                    Log.i("Error","contacto4 error");
                }
                break;
            case R.id.btnEraseC4:
                editor.putString("tel4","");
                editor.apply();
                telefono4.setText("");
                break;

            case R.id.btnSaveC5:
                String tf5 = telefono5.getText().toString();
                if (validarNumeros.esNumero(tf5) && tf5.length()==10){
                    editor.putString("tel5",telefono5.getText().toString());
                    error_tel1.setVisibility(View.GONE);
                    editor.apply();
                    Toast.makeText(this,"Contacto 5 Guardado",Toast.LENGTH_SHORT).show();
                }else {
                    error_tel1.setText(R.string.error_contacto);
                    error_tel1.setVisibility(View.VISIBLE);
                    Log.i("Error","contacto5 error");
                }
                break;
            case R.id.btnEraseC5:
                editor.putString("tel5","");
                editor.apply();
                telefono5.setText("");
                break;



        }
    }
}
