package edu.kvcc.cis298.cis298assignment2;

import android.app.Activity;
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
    private Convert convert;

    int messageResId = 0;

    protected void showError(int messageResId){
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

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
                    if (mInputText.getText().toString().trim().length() == 0) {
                        messageResId = R.string.error_input_toast;
                    } else {
                        if ((mFromGroup.getCheckedRadioButtonId() == -1) | (mToGroup.getCheckedRadioButtonId() == -1)) {
                            messageResId = R.string.error_button_toast;
                        } else {
                            Log.i("tag","0");
                            int selectedFrom = mFromGroup.getCheckedRadioButtonId();
                            int selectedTo = mToGroup.getCheckedRadioButtonId();
                            double input = Double.parseDouble(mInputText.getText().toString());
                            Log.i("tag","1");
                            int equation = convert.equation(selectedFrom, selectedTo);
                            Log.i("tag","2");
                            double result = convert.Calculation(selectedFrom, selectedTo, input);
                            Log.i("tag","3");
                            result = result * 100;
                            result = Math.round(result);
                            result = result / 100;
                            input = input * 100;
                            input = Math.round(input);
                            input = input / 100;
                            Log.i("tag","4");
                            String mEndResult = convert.Result(selectedFrom, selectedTo, input, result);
                            Log.i("tag","5");
                            mResult.setText(mEndResult);
                            Log.i("tag", "6");
                            mEquation.setText(equation);
                        }
                    }
                } catch (NumberFormatException e) {
                    messageResId = R.string.other_error_toast;
                }
                if (messageResId != 0) {
                    showError(messageResId);
                    messageResId = 0;
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