package com.drondon.lecture8;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.action_settings:
                //Навигация в настройки
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SettingsActivity.class));
                break;

            case R.id.action_about_us:
                //Навигация в описание продукта
                Toast.makeText(this, "About us", Toast.LENGTH_SHORT).show();
                showAboutUsDialog();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showAboutUsDialog() {

        //Сщздаем билдер
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("About us");
        builder.setMessage("Мы супер Android разработчики!!!");
        // builder.setCancelable(false);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Спасибо Вам!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Не очень", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Сам ничего не можешь!!!!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //Создаем диалог
        AlertDialog alertDialog = builder.create();

        // Показываем диалог
        alertDialog.show();

    }
}
