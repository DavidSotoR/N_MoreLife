package morelife.example.user.n_morelife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Informacion extends AppCompatActivity {
    private TextView info_Tema1,info_Tema2,info_Tema3;
    private TextView txtcontacto1,txtcontacto2,txtcontacto3,txtcontacto4,txtcontacto5,txtcontacto6,txtcontacto7,txtcontacto8,
            txtcontacto9,txtcontacto10,txtcontacto11,txtcontacto12,txtcontacto13,txtcontacto14,txtcontacto15,txtcontacto16,
            txtcontacto17,txtcontacto18,txtcontacto19,txtcontacto20,txtcontacto21,txtcontacto22,txtcontacto23,txtcontacto24,
            txtcontacto25,txtcontacto26,txtcontacto27,txtcontacto28,txtcontacto29,txtcontacto30,txtcontacto31,txtcontacto32;

    boolean infotema1 = true;
    private ImageButton btn_minimizar,btn_maximizar,btn_minimizar2,btn_maximizar2,btn_minimizar3,btn_maximizar3;
    private Button btnNivelNacional;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        info_Tema1 = findViewById(R.id.txtTema1_contenido);
        info_Tema2 = findViewById(R.id.txtTema2_contenido);
        info_Tema3 = findViewById(R.id.txtTema3_contenido);

        txtcontacto1 = findViewById(R.id.txtDirectorio_contacto1);
        txtcontacto2 = findViewById(R.id.txtDirectorio_contacto2);
        txtcontacto3 = findViewById(R.id.txtDirectorio_contacto3);
        txtcontacto4 = findViewById(R.id.txtDirectorio_contacto4);
        txtcontacto5 = findViewById(R.id.txtDirectorio_contacto5);
        txtcontacto6 = findViewById(R.id.txtDirectorio_contacto6);
        txtcontacto7 = findViewById(R.id.txtDirectorio_contacto7);
        txtcontacto8 = findViewById(R.id.txtDirectorio_contacto8);
        txtcontacto9 = findViewById(R.id.txtDirectorio_contacto9);
        txtcontacto10 = findViewById(R.id.txtDirectorio_contacto10);
        txtcontacto11 = findViewById(R.id.txtDirectorio_contacto11);
        txtcontacto12 = findViewById(R.id.txtDirectorio_contacto12);
        txtcontacto13 = findViewById(R.id.txtDirectorio_contacto13);
        txtcontacto14 = findViewById(R.id.txtDirectorio_contacto14);
        txtcontacto15 = findViewById(R.id.txtDirectorio_contacto15);
        txtcontacto16 = findViewById(R.id.txtDirectorio_contacto16);
        txtcontacto17 = findViewById(R.id.txtDirectorio_contacto17);
        txtcontacto18 = findViewById(R.id.txtDirectorio_contacto18);
        txtcontacto19 = findViewById(R.id.txtDirectorio_contacto19);
        txtcontacto20 = findViewById(R.id.txtDirectorio_contacto20);
        txtcontacto21 = findViewById(R.id.txtDirectorio_contacto21);
        txtcontacto22 = findViewById(R.id.txtDirectorio_contacto22);
        txtcontacto23 = findViewById(R.id.txtDirectorio_contacto23);
        txtcontacto24 = findViewById(R.id.txtDirectorio_contacto24);
        txtcontacto25 = findViewById(R.id.txtDirectorio_contacto25);
        txtcontacto26 = findViewById(R.id.txtDirectorio_contacto26);
        txtcontacto27 = findViewById(R.id.txtDirectorio_contacto27);
        txtcontacto28 = findViewById(R.id.txtDirectorio_contacto28);
        txtcontacto29 = findViewById(R.id.txtDirectorio_contacto29);
        txtcontacto30 = findViewById(R.id.txtDirectorio_contacto30);
        txtcontacto31 = findViewById(R.id.txtDirectorio_contacto31);
        txtcontacto32 = findViewById(R.id.txtDirectorio_contacto32);


        btn_minimizar = findViewById(R.id.btnImage_min);
        btn_maximizar = findViewById(R.id.btnImage_max);
        btn_minimizar2 = findViewById(R.id.btnImage_min2);
        btn_maximizar2 = findViewById(R.id.btnImage_max2);
        btn_minimizar3 = findViewById(R.id.btnImage_min3);
        btn_maximizar3 = findViewById(R.id.btnImage_max3);

        btnNivelNacional = findViewById(R.id.btnNivelNacional);

    }

    public void OnClick(View view) {
        switch (view.getId()){
           /* case R.id.btnMostrar_InfoTema1:
                if (infotema1){
                    info_Tema1.setVisibility(View.VISIBLE);
                    infotema1=false;
                    btn_maximizar.setVisibility(View.GONE);
                }else{
                    info_Tema1.setVisibility(View.GONE);
                    infotema1=true;
                }
                break;*/

            case R.id.btnImage_max:
                    info_Tema1.setVisibility(View.VISIBLE);
                    btn_maximizar.setVisibility(View.GONE);
                    btn_minimizar.setVisibility(View.VISIBLE);
                break;

            case R.id.btnImage_min:
                info_Tema1.setVisibility(View.GONE);
                btn_minimizar.setVisibility(View.GONE);
                btn_maximizar.setVisibility(View.VISIBLE);
                break;

            case R.id.btnImage_max2:
                info_Tema2.setVisibility(View.VISIBLE);
                btn_maximizar2.setVisibility(View.GONE);
                btn_minimizar2.setVisibility(View.VISIBLE);
                break;

            case R.id.btnImage_min2:
                info_Tema2.setVisibility(View.GONE);
                btn_minimizar2.setVisibility(View.GONE);
                btn_maximizar2.setVisibility(View.VISIBLE);
                break;

            case R.id.btnImage_max3:
                info_Tema3.setVisibility(View.VISIBLE);
                btn_maximizar3.setVisibility(View.GONE);
                btn_minimizar3.setVisibility(View.VISIBLE);
                break;

            case R.id.btnImage_min3:
                info_Tema3.setVisibility(View.GONE);
                btn_minimizar3.setVisibility(View.GONE);
                btn_maximizar3.setVisibility(View.VISIBLE);
                break;

            case R.id.btnNivelNacional:
                if (txtcontacto1.getVisibility() == View.GONE){
                  txtcontacto1.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto1.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto2:
                if (txtcontacto2.getVisibility() == View.GONE){
                    txtcontacto2.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto2.setVisibility(View.GONE);
                }
                break;


            case R.id.btnContacto3:
                if (txtcontacto3.getVisibility() == View.GONE){
                    txtcontacto3.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto3.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto4:
                if (txtcontacto4.getVisibility() == View.GONE){
                    txtcontacto4.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto4.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto5:
                if (txtcontacto5.getVisibility() == View.GONE){
                    txtcontacto5.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto5.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto6:
                if (txtcontacto6.getVisibility() == View.GONE){
                    txtcontacto6.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto6.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto7:
                if (txtcontacto7.getVisibility() == View.GONE){
                    txtcontacto7.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto7.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto8:
                if (txtcontacto8.getVisibility() == View.GONE){
                    txtcontacto8.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto8.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto9:
                if (txtcontacto9.getVisibility() == View.GONE){
                    txtcontacto9.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto9.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto10:
                if (txtcontacto10.getVisibility() == View.GONE){
                    txtcontacto10.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto10.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto11:
                if (txtcontacto11.getVisibility() == View.GONE){
                    txtcontacto11.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto11.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto12:
                if (txtcontacto12.getVisibility() == View.GONE){
                    txtcontacto12.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto12.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto13:
                if (txtcontacto13.getVisibility() == View.GONE){
                    txtcontacto13.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto13.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto14:
                if (txtcontacto14.getVisibility() == View.GONE){
                    txtcontacto14.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto14.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto15:
                if (txtcontacto15.getVisibility() == View.GONE){
                    txtcontacto15.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto15.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto16:
                if (txtcontacto16.getVisibility() == View.GONE){
                    txtcontacto16.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto16.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto17:
                if (txtcontacto17.getVisibility() == View.GONE){
                    txtcontacto17.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto17.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto18:
                if (txtcontacto18.getVisibility() == View.GONE){
                    txtcontacto18.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto18.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto19:
                if (txtcontacto19.getVisibility() == View.GONE){
                    txtcontacto19.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto19.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto20:
                if (txtcontacto20.getVisibility() == View.GONE){
                    txtcontacto20.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto20.setVisibility(View.GONE);
                }
                break;


            case R.id.btnContacto21:
                if (txtcontacto21.getVisibility() == View.GONE){
                    txtcontacto21.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto21.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto22:
                if (txtcontacto22.getVisibility() == View.GONE){
                    txtcontacto22.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto22.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto23:
                if (txtcontacto23.getVisibility() == View.GONE){
                    txtcontacto23.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto23.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto24:
                if (txtcontacto24.getVisibility() == View.GONE){
                    txtcontacto24.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto24.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto25:
                if (txtcontacto25.getVisibility() == View.GONE){
                    txtcontacto25.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto25.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto26:
                if (txtcontacto26.getVisibility() == View.GONE){
                    txtcontacto26.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto26.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto27:
                if (txtcontacto27.getVisibility() == View.GONE){
                    txtcontacto27.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto27.setVisibility(View.GONE);
                }
                break;


            case R.id.btnContacto28:
                if (txtcontacto28.getVisibility() == View.GONE){
                    txtcontacto28.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto28.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto29:
                if (txtcontacto29.getVisibility() == View.GONE){
                    txtcontacto29.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto29.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto30:
                if (txtcontacto30.getVisibility() == View.GONE){
                    txtcontacto30.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto30.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto31:
                if (txtcontacto31.getVisibility() == View.GONE){
                    txtcontacto31.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto31.setVisibility(View.GONE);
                }
                break;

            case R.id.btnContacto32:
                if (txtcontacto32.getVisibility() == View.GONE){
                    txtcontacto32.setVisibility(View.VISIBLE);
                }else{
                    txtcontacto32.setVisibility(View.GONE);
                }
                break;

        }
    }
}
