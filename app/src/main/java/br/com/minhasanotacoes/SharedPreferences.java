package br.com.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

class TaskPreferences {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String NAME_DATA = "task.peference";
    private final String NAME_KEY = "name.key";


    public TaskPreferences(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(NAME_DATA, 0);
        editor = preferences.edit();

    }

    public void saveTask(String task) {
        editor.putString(NAME_KEY, task);
        editor.commit();
    }

    public String recoverTask() {
        return preferences.getString(NAME_KEY, "");
    }
}
