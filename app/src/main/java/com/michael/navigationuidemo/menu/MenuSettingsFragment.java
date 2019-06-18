package com.michael.navigationuidemo.menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michael.navigationuidemo.R;


public class MenuSettingsFragment extends Fragment
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_menu_settings, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        menu.clear();//清除掉上一个Fragment中的menu
        super.onCreateOptionsMenu(menu, inflater);
    }
}
