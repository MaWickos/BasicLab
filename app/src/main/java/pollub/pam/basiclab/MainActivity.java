package pollub.pam.basiclab;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getResources().getString(R.string.floatingButtonMessage), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Deklaracja stringa, pobranie ID elementu MenuItem
        int id = item.getItemId();
        String snackbarString;

        // Reakcje na kliknięcia przycisków w menu
        if(id == R.id.menuAbout)
            snackbarString = getResources().getString(R.string.snackbarAbout);
        else if(id == R.id.menuAuthor)
            snackbarString = getResources().getString(R.string.snackbarAuthor);
        else if (id == R.id.menuSettings)
            snackbarString = getResources().getString(R.string.snackbarSettings);
        else
            snackbarString = "(***) Wystąpił błąd odczytu lub dopasowania ID obiektu MenuItem!";

        // Wyświetlenie snacbara
        Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), snackbarString, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        return super.onOptionsItemSelected(item);
    }
}