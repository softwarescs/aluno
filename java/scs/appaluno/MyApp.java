package scs.appaluno;

import android.app.Application;
import android.content.Context;

/**
 * Created by joaoc_000 on 22/05/2018.
 */

public class MyApp extends Application
{
    private static Context contexto;

    @Override
    public void onCreate() {
        contexto = getApplicationContext();
        super.onCreate();
    }

    public static Context getContexto() {
        return contexto;
    }
}
