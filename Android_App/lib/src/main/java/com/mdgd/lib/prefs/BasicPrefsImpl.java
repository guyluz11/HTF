package com.mdgd.lib.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

import androidx.annotation.NonNull;

/**
 * Created by Max
 * on 08/07/2018.
 */
public abstract class BasicPrefsImpl {

    protected final Context ctx;

    public BasicPrefsImpl(Context ctx) {
        this.ctx = ctx;
    }

    public abstract String getDefaultPrefsFileName();

    @NonNull
    protected SharedPreferences getPrefs() {
        return getPrefs(getDefaultPrefsFileName());
    }

    @NonNull
    protected SharedPreferences getPrefs(String fileName){
        return ctx.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    @NonNull
    protected SharedPreferences.Editor getEditor(){
        return getEditor(getDefaultPrefsFileName());
    }

    @NonNull
    protected SharedPreferences.Editor getEditor(String fileName){
        return getPrefs(fileName).edit();
    }



    public String get(@NonNull String fileName, @NonNull String key, @NonNull String defaultVal) {
        return getPrefs(fileName).getString(key, defaultVal);
    }

    public String get(@NonNull String key, @NonNull String defaultVal){
        return getPrefs(getDefaultPrefsFileName()).getString(key, defaultVal);
    }

    public void put(@NonNull String fileName, @NonNull String key, @NonNull String value) {
        getEditor(fileName).putString(key, value).apply();
    }

    public void put(@NonNull String key, @NonNull String value){
        getEditor(getDefaultPrefsFileName()).putString(key, value).apply();
    }



    public int get(@NonNull String fileName, @NonNull String key, int defaultVal) {
        return getPrefs(fileName).getInt(key, defaultVal);
    }

    public int get(@NonNull String key, int defaultVal){
        return getPrefs(getDefaultPrefsFileName()).getInt(key, defaultVal);
    }

    public void put(@NonNull String fileName, @NonNull String key, int value) {
        getEditor(fileName).putInt(key, value).apply();
    }

    public void put(@NonNull String key, int value){
        getEditor(getDefaultPrefsFileName()).putInt(key, value).apply();
    }



    public boolean get(@NonNull String fileName, @NonNull String key, boolean defaultVal) {
        return getPrefs(fileName).getBoolean(key, defaultVal);
    }

    public boolean get(@NonNull String key, boolean defaultVal){
        return getPrefs(getDefaultPrefsFileName()).getBoolean(key, defaultVal);
    }

    public void put(@NonNull String fileName, @NonNull String key, boolean value) {
        getEditor(fileName).putBoolean(key, value).apply();
    }

    public void put(@NonNull String key, boolean value){
        getEditor(getDefaultPrefsFileName()).putBoolean(key, value).apply();
    }



    public long get(@NonNull String fileName, @NonNull String key, long defaultVal) {
        return getPrefs(fileName).getLong(key, defaultVal);
    }

    public long get(@NonNull String key, long defaultVal){
        return getPrefs(getDefaultPrefsFileName()).getLong(key, defaultVal);
    }

    public void put(@NonNull String fileName, @NonNull String key, long value) {
        getEditor(fileName).putLong(key, value).apply();
    }

    public void put(@NonNull String key, long value){
        getEditor(getDefaultPrefsFileName()).putLong(key, value).apply();
    }



    public float get(@NonNull String fileName, @NonNull String key, float defaultVal) {
        return getPrefs(fileName).getFloat(key, defaultVal);
    }

    public float get(@NonNull String key, float defaultVal){
        return getPrefs(getDefaultPrefsFileName()).getFloat(key, defaultVal);
    }

    public void put(@NonNull String fileName, @NonNull String key, float value) {
        getEditor(fileName).putFloat(key, value).apply();
    }

    public void put(@NonNull String key, float value){
        getEditor(getDefaultPrefsFileName()).putFloat(key, value).apply();
    }



    public Set<String> get(@NonNull String fileName, @NonNull String key, @NonNull Set<String> defaultVal) {
        return getPrefs(fileName).getStringSet(key, defaultVal);
    }

    public Set<String> get(@NonNull String key, @NonNull Set<String> defaultVal){
        return getPrefs(getDefaultPrefsFileName()).getStringSet(key, defaultVal);
    }

    public void put(@NonNull String fileName, @NonNull String key, @NonNull Set<String> value) {
        getEditor(fileName).putStringSet(key, value).apply();
    }

    public void put(@NonNull String key, @NonNull Set<String> value){
        getEditor(getDefaultPrefsFileName()).putStringSet(key, value).apply();
    }



    public Map<String, ?> get(@NonNull String fileName) {
        return getPrefs(fileName).getAll();
    }

    public Map<String, ?> get(){
        return getPrefs(getDefaultPrefsFileName()).getAll();
    }
}
