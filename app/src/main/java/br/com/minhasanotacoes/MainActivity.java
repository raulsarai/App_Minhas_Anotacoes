package br.com.minhasanotacoes;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private TaskPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        preferences  = new TaskPreferences(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fabDone);
        EditText editText = findViewById(R.id.editTextTask);

        fab.setOnClickListener(view -> {
            if (editText.getText().toString().equals("")){
                Snackbar.make(view, "Digite sua anotação",
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();
            }else{
                preferences.saveTask(editText.getText().toString());

                Snackbar.make(view, "Salvo com sucesso!",
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();
            }
        });

        String task = preferences.recoverTask();
        if(!task.equals("")){
            editText.setText((task));
        }
    }
}