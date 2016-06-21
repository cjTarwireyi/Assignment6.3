package com.example.cornelious.busbooking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.passenger.Passenger;
import com.example.cornelious.busbooking.domain.passenger.PassengerAddress;
import com.example.cornelious.busbooking.repositories.passenger.PassengerRepositoryImpl;
import com.example.cornelious.busbooking.services.impl.PassengerIntentService;


public class Previewpassenger extends Activity{
    private TextView idNumber;
    private  TextView name;
    private  TextView lastName;
    private  TextView street;
    private  TextView city;
    private  TextView code;
    private PassengerRepositoryImpl objRepo;
    private PassengerIntentService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previewpassenger);

        idNumber=(TextView)findViewById(R.id.txtID);
        name=(TextView)findViewById(R.id.txtName);
        lastName=(TextView)findViewById(R.id.txtLastName);
        street=(TextView)findViewById(R.id.txtStreet);
        city=(TextView)findViewById(R.id.txtCity);
        code=(TextView)findViewById(R.id.txtCode);

        Intent intent=getIntent();
        Bundle bundle= intent.getExtras();
        if(bundle!=null)
        {

            idNumber.setText((String)bundle.get("idNumber"));
            name.setText((String)bundle.get("name"));
            lastName.setText((String)bundle.get("lastName"));
            street.setText((String)bundle.get("street"));
            city.setText((String)bundle.get("city"));
            code.setText((String)bundle.get("code"));


        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_previewpassenger, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addPassenger(View view) {
        service=new PassengerIntentService();
        objRepo= new PassengerRepositoryImpl(App.getContext());
        PassengerAddress address=new PassengerAddress.AddressBuilder()
                .street(street.getText().toString())
                .city(city.getText().toString())
                .code(code.getText().toString())
                .build();
        Passenger passenger= new Passenger.PassengerBuilder()
                .name(name.getText().toString())
                .lastName(lastName.getText().toString())
                .id(idNumber.getText().toString())
                .address(address)
                .build();
        service.addPassenger(this,passenger);
        Intent intent = new Intent(this,DisplayRecords.class);
        startActivity(intent);
    }
}
