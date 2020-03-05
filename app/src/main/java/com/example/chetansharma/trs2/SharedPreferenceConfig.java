package com.example.chetansharma.trs2;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.chetansharma.trs2.R;

public class SharedPreferenceConfig {
    private SharedPreferences sharedpreference;
    private Context context;

    public SharedPreferenceConfig(Context context)
    {
        this.context=context;
        sharedpreference=context.getSharedPreferences(context.getResources().getString(R.string.login_preference),Context.MODE_PRIVATE );



    }

    public void writeLoginStatus(boolean status)
    {
        SharedPreferences.Editor editor= sharedpreference.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preference),status);
        editor.commit();
    }

    public boolean readLoginStatus()
    {
        boolean status = false;
        status=sharedpreference.getBoolean(context.getResources().getString(R.string.login_status_preference), false);
        return status;

    }
}
