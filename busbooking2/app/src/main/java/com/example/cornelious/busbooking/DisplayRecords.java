package com.example.cornelious.busbooking;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.passenger.Passenger;
import com.example.cornelious.busbooking.repositories.passenger.PassengerRepositoryImpl;

import java.util.ArrayList;
import java.util.Set;


public class DisplayRecords extends Activity {
    private PassengerRepositoryImpl objRepo;

    private ArrayList<String>passangerArray;
    private ArrayAdapter arrayAdapter;
    GridView passengerGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_records);
        //DBAdapter dbAdapter= new DBAdapter(this);
       // adap

        objRepo= new PassengerRepositoryImpl(App.getContext());
        passangerArray = new ArrayList<>();
        Cursor cursor = objRepo.getAll();

        if (cursor.moveToNext())
        {
            do{
                String id=cursor.getString(1);
                String name=cursor.getString(2);
                String lastName=cursor.getString(3);
                String street=cursor.getString(4);
                String city=cursor.getString(5);
                String code=cursor.getString(6);

                passangerArray.add(id);
                passangerArray.add(name);
                passangerArray.add(lastName);
                passangerArray.add(street);
                passangerArray.add(city);
                passangerArray.add(code);
            }while (cursor.moveToNext());
            arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,passangerArray);

            passengerGridView=(GridView)findViewById(R.id.gridView);
            passengerGridView.setAdapter(arrayAdapter);




        }



    }


    public void goBackHome(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
