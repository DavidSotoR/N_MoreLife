package morelife.example.user.n_morelife;

import android.util.Log;

public class ValidarNumeros {

    public boolean esNumero(String cadena){
        boolean resultado;

        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

}
