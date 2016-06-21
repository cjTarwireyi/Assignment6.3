package com.example.cornelious.busbooking;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class PassengerActivity extends Activity {
    private EditText  idNumber;
    private EditText name;
    private EditText lastName;
    private EditText street;
    private EditText city;
    private EditText code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registercustomeractivity);

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
        DialogFragment dialogFragment;
        try {

            idNumber = (EditText) findViewById(R.id.txtID);
            int idValid = Integer.parseInt(idNumber.getText().toString());
            name = (EditText) findViewById(R.id.txtName);
            lastName = (EditText) findViewById(R.id.txtSurname);
            street = (EditText) findViewById(R.id.txtStreetName);
            city = (EditText) findViewById(R.id.txtCity);
            code = (EditText) findViewById(R.id.txtCode);
            int codeValid = Integer.parseInt(code.getText().toString());

            Intent intent = new Intent(getApplicationContext(), Previewpassenger.class);
            intent.putExtra("idNumber", idNumber.getText().toString());
            intent.putExtra("name", name.getText().toString());
            intent.putExtra("lastname", lastName.getText().toString());
            intent.putExtra("street", street.getText().toString());
            intent.putExtra("code", code.getText().toString());
            intent.putExtra("city", city.getText().toString());
            startActivity(intent);
        }
        catch(NumberFormatException nfe)
        {
            Toast.makeText(getBaseContext(),"Make sure ID number and code are in number format",Toast.LENGTH_LONG).show();

        }
    }
}
