package com.example.task2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class Ticker_fragment extends Fragment {
    String[] Currency={"USD/INR","EUR/USD","EUR/INR","GBP/USD","GBP/INR","AUD/USD","AUD/INR","USD/JPY","JPY/INR","USD/CHF","INR/CHF","USD/CAD","INR/CAD"};
    View view;
    Spinner spinner;
    ImageView backArrow;

    ViewPager viewPager;
    TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_ticker,container,false);
        spinner=view.findViewById( R.id.Spin_ticker );

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>( getActivity(),android.R.layout.simple_spinner_dropdown_item,Currency );
        spinner.setAdapter( arrayAdapter );

        viewPager=view.findViewById( R.id.ViewPager );
        tabLayout=view.findViewById( R.id.TabLayout_Ticker);
        backArrow=view.findViewById( R.id.iv_TickerBackArrow );

        backArrow.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction t=Ticker_fragment.this.getFragmentManager().beginTransaction();
                t.replace( R.id.fragment_container,new Home_fragment() ).commit();
            }
        } );

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
      adapter.addFragment( new OHLCFragment(),"OHLC" );
      adapter.addFragment( new ForwardFragment(),"Forward" );

      viewPager.setAdapter( adapter );
    }
}
