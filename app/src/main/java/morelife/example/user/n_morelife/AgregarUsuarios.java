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
    EditText telefono1,telefono2,telefono3,telefono4,telefono5;
    TextView error_tel1;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private ValidarNumeros validarNumeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_agregar_usuarios);

        telefono1 = findViewById(R.id.campoTel1);
        telefono2 = findViewById(R.id.campoTel2);
        telefono3 = findViewById(R.id.campoTel3);
        telefono4 = findViewById(R.id.campoTel4);
        telefono5 = findViewById(R.id.campoTel5);

        error_tel1 = findViewById(R.id.txtError_alerta);

        SharedPreferences crear_prefrences = getSharedPreferences("contactos",Context.MODE_PRIVATE);
        telefono1.setText(crear_prefrences.getString("tel1",""));
        telefono2.setText(crear_prefrences.getString("tel2",""));
        telefono3.setText(crear_prefrences.getString("tel3",""));
        telefono4.setText(crear_prefrences.getString("tel4",""));
        telefono5.setText(crear_prefrences.getString("tel5",""));

        preferences = getSharedPreferences("contactos",Context.MODE_PRIVATE);
        editor = preferences.edit();
        validarNumeros = new ValidarNumeros();

    }

    public void Onclick_Agregar(View view) {

        switch (view.getId()){
            case R.id.btnGuardar:
                break;

            case R.id.btnEliminar:
                SharedPreferences preferences_el = getSharedPreferences("contactos",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor_el = preferences_el.edit();
                editor_el.putString("tel1","");
                editor_el.putString("tel2","");
                editor_el.putString("tel3","");
                editor_el.putString("tel4","");
                editor_el.putString("tel5","");
                editor_el.apply();
                Toast.makeText(getApplicationContext(),"Contactos Guardados",Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnMostrar:
                SharedPreferences preferences_Mos = getSharedPreferences("contactos",Context.MODE_PRIVATE);
                String tel1 = preferences_Mos.getString("tel1","");
                String tel2 = preferences_Mos.getString("tel2","");
                String tel3 = preferences_Mos.getString("tel3","");
                String tel4 = preferences_Mos.getString("tel4","");
                String tel5 = preferences_Mos.getString("tel5","");

                telefono1.setText(tel1);
                telefono2.setText(tel2);
                telefono3.setText(tel3);
                telefono4.setText(tel4);
                telefono5.setText(tel5);
                break;

            case R.id.btnSaveC1:
                String tf1 = telefono1.getText().toString();
                if (validarNumeros.esNumero(tf1) && tf1.length()==10){
                    error_tel1.setVisibility(View.GONE);
                    editor.putString("tel1",telefono1.getText().toString());
                    editor.apply();
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
