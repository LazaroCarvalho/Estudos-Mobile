package senai.sp.br.drawerlayout2;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity
        extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout,
                toolbar,
                R.string.open_drawer,
                R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

            navigationView = findViewById(R.id.navigationview);
            navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_entrada: {
                Toast.makeText(this, "Entrada", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.menu_enviados: {
                Toast.makeText(this, "Enviados", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.menu_favoritos: {
                Toast.makeText(this, "Favoritos", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.menu_lixeira: {
                Toast.makeText(this, "Lixeira", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.menu_spam: {
                Toast.makeText(this, "Spam", Toast.LENGTH_SHORT).show();
            }
            break;
        }

        return false;
    }
}
