package edu.kvcc.cis298.cis298assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TemperatureConverter extends AppCompatActivity {
    private Button mConvertButton;

    private RadioGroup mFromGroup;
    private RadioGroup mToGroup;
    private EditText mInputText;
    private TextView mResult;
    private TextView mEquation;
    private RadioButton mFrom1;
    private RadioButton mFrom2;
    private RadioButton mFrom3;
    private RadioButton mFrom4;
    private RadioButton mTo1;
    private RadioButton mTo2;
    private RadioButton mTo3;
    private RadioButton mTo4;

    int errorToast = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        mInputText = (EditText) findViewById(R.id.input);
        mFromGroup = (RadioGroup) findViewById(R.id.from_group);
        mToGroup = (RadioGroup) findViewById(R.id.to_group);
        mFrom1 = (RadioButton) findViewById(R.id.from_temp_1);
        mFrom2 = (RadioButton) findViewById(R.id.from_temp_2);
        mFrom3 = (RadioButton) findViewById(R.id.from_temp_3);
        mFrom4 = (RadioButton) findViewById(R.id.from_temp_4);
        mTo1 = (RadioButton) findViewById(R.id.to_temp_1);
        mTo2 = (RadioButton) findViewById(R.id.to_temp_2);
        mTo3 = (RadioButton) findViewById(R.id.to_temp_3);
        mTo4 = (RadioButton) findViewById(R.id.to_temp_4);


        mConvertButton = (Button) findViewById(R.id.convert_button);
        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    int selectedFrom = mFromGroup.getCheckedRadioButtonId();
                    int selectedTo = mToGroup.getCheckedRadioButtonId();
                    double input = Double.parseDouble(mInputText.getText().toString());
                    new Convert(selectedFrom, selectedTo, input);
                    mResult.setText(conversion);
                    mEquation.setText(equation);
                } catch (NumberFormatException e) {
                    errorToast = R.string.error_input_toast;
                }

                if (errorToast != 0) {
                    Toast.makeText(this, errorToast, Toast.LENGTH_SHORT).show();
                    errorToast = 0;
                }
            }
        });
    }

    private static final String TAG = "Temperature Counter";

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //log that onSaveInstanceState was called
        Log.i(TAG, "onSaveInstanceState");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temperature_converter, menu);
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
}