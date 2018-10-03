package morelife.example.user.n_morelife;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

public class Hilo extends AsyncTask<Void, Integer, Boolean> {
    private Context _context;

    public Hilo(Context context) {
        this._context=context;
    }


    @Override
    protected Boolean doInBackground(Void... voids) {
        Tiempo tiempo = new Tiempo();
        for (int i = 1;i<=10;i++){
            tiempo.UnSegundo();
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if (aBoolean){
            SharedPreferences preferences = _context.getSharedPreferences("contactos",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("cont","0");
            editor.apply();
        }
    }
}
