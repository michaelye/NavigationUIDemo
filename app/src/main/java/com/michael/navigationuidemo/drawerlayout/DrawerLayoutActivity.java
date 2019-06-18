package com.michael.navigationuidemo.drawerlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.michael.navigationuidemo.R;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class DrawerLayoutActivity extends AppCompatActivity
{
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //绑定当前的ActionBar，除此之外NavigationUI还能绑定Toolbar和CollapsingToolbarLayout
        //绑定后，系统会默认处理ActionBar左上角区域，为你添加返回按钮，将所切换到的Fragment在导航图里的name属性中的内容显示到Title
        //.setDrawerLayout(drawerLayout)后才会出现菜单按钮
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(drawerLayout).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        //设置左侧菜单
        NavigationView navigationView = findViewById(R.id.navigation_view);
        NavigationUI.setupWithNavController(navigationView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener()
        {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments)
            {
                Toast.makeText(DrawerLayoutActivity.this, "onDestinationChanged() called", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 左上角的菜单被点击时调用到
     */
    @Override
    public boolean onSupportNavigateUp()
    {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        Toast.makeText(DrawerLayoutActivity.this, "onSupportNavigateUp() called", Toast.LENGTH_SHORT).show();
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}
