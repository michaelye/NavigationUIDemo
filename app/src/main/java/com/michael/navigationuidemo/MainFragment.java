package com.michael.navigationuidemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;

public class MainFragment extends Fragment
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        view.findViewById(R.id.btnMenuInActionBar).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_menuActivity));
        view.findViewById(R.id.btnDrawerLayout).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_drawerLayoutActivity));
        view.findViewById(R.id.btnBottomNavigationBar).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_bottomNavigationBarActivity));
        return view;
    }
}
