package com.michael.navigationuidemo.bottomnavigationbar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.michael.navigationuidemo.R;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class BottomNavigationBarActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_bar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener()
        {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments)
            {
                Toast.makeText(BottomNavigationBarActivity.this, "onDestinationChanged() called", Toast.LENGTH_SHORT).show();
            }
        });

        //设置底部菜单
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}
