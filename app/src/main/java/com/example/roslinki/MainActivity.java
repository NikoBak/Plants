package com.example.roslinki;

import android.content.Intent;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

// TODO : Decyzja, które wymagania wybieramy aby zdać, poniżej propozycja:
// TODO : 10. Wykrywanie typowych gestów (klasa GestureDetector) np. gest przeciągnięcia, przytrzymania
// TODO : 15. Zastosowanie intencji do uruchamiania zewnętrznych aplikacji (np. aparat, przeglądarka itp.) lub wywołanie ich jako aktywności w ramach własnej aplikacji
// TODO : 21. Zastosowaniu układu tabeli (TableLayout)
// TODO : Pierwsze jako przechodzenie pomiędzy aktywnościami
// TODO : Drugie toolbar zdjęcia
// TODO : Trzecie może lista roślinek ?
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//      ------------ BOTTOM NAVIGATION BAR ------------      //
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.bottom_home:
                    return true;
                case R.id.bottom_add:
                    startActivity(new Intent(getApplicationContext(), AddPlantActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;

                case R.id.bottom_list:
                    startActivity(new Intent(getApplicationContext(), ListPlantsActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });
//      ------------ BOTTOM NAVIGATION BAR ------------      //
//      ------------------- TOOLBAR -------------------      //
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }



    public boolean onCreateOptinonsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.new_plant){
            Toast.makeText(this, "Add new plant", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.costam){
            Toast.makeText(this, "Fajna Aplikacja", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}