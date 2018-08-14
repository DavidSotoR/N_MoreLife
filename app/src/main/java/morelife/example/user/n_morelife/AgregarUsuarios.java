package morelife.example.user.n_morelife;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarUsuarios extends AppCompatActivity {
    EditText telefono1,telefono2,telefono3,telefono4,telefono5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_usuarios);

        telefono1 = findViewById(R.id.campoTel1);
        telefono2 = findViewById(R.id.campoTel2);
        telefono3 = findViewById(R.id.campoTel3);
        telefono4 = findViewById(R.id.campoTel4);
        telefono5 = findViewById(R.id.campoTel5);

        SharedPreferences crear_prefrences = getSharedPreferences("contactos",Context.MODE_PRIVATE);
        telefono1.setText(crear_prefrences.getString("tel1",""));
        telefono2.setText(crear_prefrences.getString("tel2",""));
        telefono3.setText(crear_prefrences.getString("tel3",""));
        telefono4.setText(crear_prefrences.getString("tel4",""));
        telefono5.setText(crear_prefrences.getString("tel5",""));

    }

    public void Onclick_Agregar(View view) {

        switch (view.getId()){
            case R.id.btnGuardar:
                SharedPreferences preferences = getSharedPreferences("contactos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("tel1",telefono1.getText().toString());
                editor.putString("tel2",telefono2.getText().toString());
                editor.putString("tel3",telefono3.getText().toString());
                editor.putString("tel4",telefono4.getText().toString());
                editor.putString("tel5",telefono5.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(),"Contactos Guardados",Toast.LENGTH_SHORT).show();
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

        }
    }
}
