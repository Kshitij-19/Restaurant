package com.example.res_t2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.res_t2.ui.Restaurant.RestaurantFragment;
import com.example.res_t2.ui.Rooms.RoomsFragment;
import com.example.res_t2.ui.authentication.Login;
import com.example.res_t2.ui.bookingStatus.BookingStatusFragment;
import com.example.res_t2.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavView;
    private NavController navController;
    private DrawerLayout mnavdrawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private FrameLayout frameLayout;

    String userId;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_layout);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        if(fAuth.getCurrentUser() == null)
        {
            startActivity(new Intent(getApplicationContext(), Login.class));
        }
        userId = fAuth.getCurrentUser().getUid();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mnavdrawer=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_drawer);
        frameLayout=findViewById(R.id.framelayout);
      toggle=new ActionBarDrawerToggle(this,mnavdrawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        bottomNavView = findViewById(R.id.bottom_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mnavdrawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState==null)
        {
            Fragment selected_fragment=null;
            selected_fragment=new HomeFragment();

            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selected_fragment).commit();
            navigationView.setCheckedItem(R.id.navigation_home);

        }
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selected_fragment=null;
                switch(item.getItemId())
                {
                    case R.id.navigation_home :
                        selected_fragment=new HomeFragment();
                        break;
                    case R.id.navigation_restaurant :
                        selected_fragment=new RestaurantFragment();

                        break;
                    case R.id.navigation_rooms :
                        selected_fragment=new RoomsFragment();
                        break;
                    case R.id.navigation_bookingStatus :
                        selected_fragment=new BookingStatusFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selected_fragment).commit();
                return true;
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.nav_profile:
                Toast.makeText(this,"Profile",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_contactUs:
                Toast.makeText(this,"Contact Us",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_about:
                Toast.makeText(this,"About",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_RateUs:
                Toast.makeText(this,"Rate us",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_logout:
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
                    Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();

                break;

        }
        mnavdrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}