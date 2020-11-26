package com.example.task2;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean table_flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav =findViewById(R.id.bottom_nav);
        bottomNav.setSelectedItemId( R.id.nav_home );
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new Home_fragment()).commit();




    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectFragment =null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_trigger:
                            selectFragment=new Report_fragment()
                            ;
                            break;
                        case R.id.nav_ticker:
                            selectFragment=new Ticker_fragment();
                            break;
                        case R.id.nav_home:
                            selectFragment=new Home_fragment();
                            break;
                        case R.id.nav_report:
                            selectFragment=new Report_fragment();
                            break;
                        case R.id.nav_calculator:
                            selectFragment=new Calculator_fragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectFragment).commit();
                    return true;
                }
            };
//    public void collapstable(View view){
//        TableLayout tableLayout=findViewById(R.id.table);
//        Button SwitchBtn=findViewById(R.id.switche);
//
//        tableLayout.setColumnCollapsed(1,table_flag);
//        tableLayout.setColumnCollapsed(2,table_flag);
//        tableLayout.setColumnCollapsed(3,table_flag);
//        tableLayout.setColumnCollapsed(4,table_flag);
//        tableLayout.setColumnCollapsed(5,table_flag);
//
//        if(table_flag){
//            table_flag=false;
//            SwitchBtn.setText("USD");
//        }
//        else{
//            table_flag=true;
//            SwitchBtn.setText("INR");
//        }
//    }


    }
