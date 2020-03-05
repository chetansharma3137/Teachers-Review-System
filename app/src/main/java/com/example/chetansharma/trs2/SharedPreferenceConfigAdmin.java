package com.example.chetansharma.trs2;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceConfigAdmin {
    private SharedPreferences sharedpreference;
    private Context context;

    public SharedPreferenceConfigAdmin(Context context)
    {
        this.context=context;
        sharedpreference=context.getSharedPreferences(context.getResources().getString(R.string.login_preference),Context.MODE_PRIVATE );



    }

    public void writeLoginStatusAdmin(boolean status)
    {
        SharedPreferences.Editor editor= sharedpreference.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preference),status);
        editor.commit();
    }

    public boolean readLoginStatusAdmin()
    {
        boolean status = false;
        status=sharedpreference.getBoolean(context.getResources().getString(R.string.login_status_preference), false);
        return status;

    }
}
