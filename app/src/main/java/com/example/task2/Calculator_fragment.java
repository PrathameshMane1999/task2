package com.example.task2;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calculator_fragment extends Fragment implements DatePickerDialog.OnDateSetListener{
    RadioButton rbExpo,rbImpo;
    AutoCompleteTextView etCurrencyF,etCurrencyT;
    EditText tradeDate,forwardDate;
    String[] currencyF={"USD","AUD","CAD","CHF","EUR","GBP","JPY"};
    String[] currencyT={"USD","INR"};
    ImageView backArrow;
    InputMethodManager inputMethodManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_calculator,container,false);

//        rbExpo=view.findViewById( R.id.RB_Export );
//        rbImpo=view.findViewById( R.id.RB_Import );
//        etCurrencyF=view.findViewById( R.id.Et_CurrencyFrom );
//        etCurrencyT=view.findViewById( R.id.Et_CurrencyTO );
//        tradeDate=view.findViewById( R.id.Et_TradeDate );
//        forwardDate=view.findViewById( R.id.Et_ForwardDate );
//        backArrow=view.findViewById( R.id.iv_FRCBackArrow );

        inputMethodManager= (InputMethodManager) getActivity().getSystemService( Context.INPUT_METHOD_SERVICE );


        SimpleDateFormat simpleDateFormat=new SimpleDateFormat( "dd/MM/yyyy" );
        tradeDate.setText( simpleDateFormat.format( new Date(  ) ) );


        rbExpo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbExpo.isChecked()==true){
                    rbExpo.setTextColor( Color.WHITE );
                    rbImpo.setTextColor( Color.rgb( 48,63,159 ) );
                }
            }
        } );
        rbImpo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbImpo.isChecked()==true){
                    rbImpo.setTextColor( Color.WHITE );
                    rbExpo.setTextColor( Color.rgb( 48,63,159 ) );
                }
            }
        } );
        etCurrencyF.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputMethodManager.hideSoftInputFromWindow( view.getWindowToken(),0 );
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter( getContext(),android.R.layout.simple_dropdown_item_1line,currencyF );
                etCurrencyF.setAdapter( arrayAdapter );
                etCurrencyF.showDropDown();
            }
        } );
        etCurrencyT.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputMethodManager.hideSoftInputFromWindow( view.getWindowToken(),0 );
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter( getContext(),android.R.layout.simple_dropdown_item_1line,currencyT );
                etCurrencyF.setAdapter( arrayAdapter );
                etCurrencyF.showDropDown();
            }
        } );


        tradeDate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShowDatePickerDailog();
            }
        } );
        forwardDate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDatePickerDailog();
            }
        } );

        backArrow.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction t=Calculator_fragment.this.getFragmentManager().beginTransaction();
                t.replace( R.id.fragment_container,new Home_fragment() ).commit();
            }
        } );

        return view;
    }
    private void ShowDatePickerDailog(){
        int year= Calendar.getInstance().get( Calendar.YEAR ),
                month=Calendar.getInstance().get( Calendar.MONTH ),
                day=Calendar.getInstance().get( Calendar.DAY_OF_MONTH );

        DatePickerDialog datePickerDialog=new DatePickerDialog( getActivity(),this,year,month,day );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view,int year,int month,int dayOfMonth) {
        Calendar dob=Calendar.getInstance();
        dob.set(Calendar.YEAR,year);
        dob.set( Calendar.MONTH,month );
        dob.set( Calendar.DAY_OF_MONTH,dayOfMonth );

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat( "dd/mm/yyyy" );
        String date=simpleDateFormat.format( dob.getTime() );




    }
}
