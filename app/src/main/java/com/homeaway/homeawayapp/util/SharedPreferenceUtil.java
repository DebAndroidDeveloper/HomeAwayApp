package com.homeaway.homeawayapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class SharedPreferenceUtil {
    private static final String TAG = SharedPreferenceUtil.class.getCanonicalName();


    /**
     * Save a key-value pair to SharedPreferences
     *
     * @param context The current context
     * @param key     The key for the key-value pair
     * @param value   The value of the key-value pair (String)
     */
    public static void savePreference(Context context, String key, int value) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
        Log.d(TAG, "Saved preference: " + key + " as " + value);
    }

    public static void savePreference(Context context, String key, String value) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
        Log.d(TAG, "Saved preference: " + key + " as " + value);
    }

    public static void savePreference(Context context, String key, boolean value) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
        Log.d(TAG, "Saved preference: " + key + " as " + value);
    }

    public static int readPreference(Context context, String key, int defaultValue) {
        Log.d(TAG, "readPreference : key :" + key
                + " ; defaultValue : " + defaultValue);
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);

        Log.d(TAG, "readPreference : key :" + key + " ; value : "
                + sp.getInt(key, defaultValue));

        return sp.getInt(key, defaultValue);
    }

    public static String readPreference(Context context, String key, String defaultValue) {
        Log.d(TAG, "readPreference : key :" + key
                + " ; defaultValue : " + defaultValue);
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);

        Log.d(TAG, "readPreference : key :" + key + " ; value : "
                + sp.getString(key, defaultValue));

        return sp.getString(key, defaultValue);
    }

    public static boolean readPreference(Context context, String key, boolean defaultValue) {
        Log.d(TAG, "readPreference : key :" + key
                + " ; defaultValue : " + defaultValue);
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);

        Log.d(TAG, "readPreference : key :" + key + " ; value : "
                + sp.getBoolean(key, defaultValue));

        return sp.getBoolean(key, defaultValue);
    }

    public static void clearSearchPreferences(Context context, String key) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key).commit();
    }
}