package com.michael.navigationuidemo.menu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.michael.navigationuidemo.R;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MenuActivity extends AppCompatActivity
{

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //绑定当前的ActionBar，除此之外NavigationUI还能绑定Toolbar和CollapsingToolbarLayout
        //绑定后，系统会默认处理ActionBar左上角区域，为你添加返回按钮，将所切换到的Fragment在导航图里的name属性中的内容显示到Title

        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener()
        {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments)
            {
                Toast.makeText(MenuActivity.this, "onDestinationChanged() called", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 加载菜单
     * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    /**
     * ActionBar中的按钮被点击时，根据菜单中的Id，自动跳转到相应的页面
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }

    /**
     * 左上角的返回按钮被点击时调用到
     */
    @Override
    public boolean onSupportNavigateUp()
    {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        Toast.makeText(MenuActivity.this, "onSupportNavigateUp() called", Toast.LENGTH_SHORT).show();
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}
