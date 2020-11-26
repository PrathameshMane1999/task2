package com.example.task2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Report_fragment extends Fragment {
    View view;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_report,container,false);

        viewPager=view.findViewById( R.id.ViewPager_common );
        tabLayout=view.findViewById( R.id.TabLayout_common);

       int position=tabLayout.getSelectedTabPosition();
        Log.d("TabPosition///",String.valueOf( position ) );
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager( viewPager );
    }

    private void setUpViewPager(ViewPager viewPager) {
        pagerAdapter adapter=new pagerAdapter( getChildFragmentManager() );
        adapter.addFragment( new NotificationFragment(),"Notification" );
        adapter.addFragment( new MyTriggerFragment(),"My Trigger" );
        adapter.addFragment( new RportFragment(),"Reports" );

        viewPager.setAdapter( adapter );
    }
}
