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

public class TemperatureConverter extends AppCompatActivity {
    private RadioGroup mFromGroup;
    private RadioGroup mToGroup;
    private Button mConvertButton;
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


    private static String conversion = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        mFromGroup = (RadioGroup) findViewById(R.id.from_group);
        mToGroup = (RadioGroup) findViewById(R.id.to_group);
        mInputText = (EditText) findViewById(R.id.input);
        mResult = (TextView) findViewById(R.id.result);
        mEquation = (TextView) findViewById(R.id.equation);
        mFrom1 = (RadioButton) findViewById(R.id.from_temp_1);
        mFrom2 = (RadioButton) findViewById(R.id.from_temp_2);
        mFrom3 = (RadioButton) findViewById(R.id.from_temp_3);
        mFrom4 = (RadioButton) findViewById(R.id.from_temp_4);
        mTo1 = (RadioButton) findViewById(R.id.to_temp_1);
        mTo2 = (RadioButton) findViewById(R.id.to_temp_2);
        mTo3 = (RadioButton) findViewById(R.id.to_temp_3);
        mTo4 = (RadioButton) findViewById(R.id.to_temp_4);

        final int fromcase1 = mFrom1.getId();
        final int fromcase2 = mFrom1.getId();
        final int fromcase3 = mFrom1.getId();
        final int fromcase4 = mFrom1.getId();
        final int tocase1 = mTo1.getId();
        final int tocase2 = mTo1.getId();
        final int tocase3 = mTo1.getId();
        final int tocase4 = mTo1.getId();

        mResult.setText(conversion);

        mConvertButton = (Button) findViewById(R.id.convert_button);
        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedFromId = mFromGroup.getCheckedRadioButtonId();
                int selectedToId = mToGroup.getCheckedRadioButtonId();
                double input = Integer.parseInt(mInputText.getText().toString());
                double result;
                //some way to check if mInputText is null
                //PROBLEM HERE
                if (mInputText.getText().toString() != "") {

                    switch (selectedFromId) {
                        //PROBLEM HERE
                        //I need to compare the ids to their spot in the radio button group.
                        case 1: {
                            //celsius
                            switch (selectedToId) {
                                case 1: {
                                    result = input;
                                    conversion = input + R.string.temp_symb_1 + " = " + result + R.string.temp_symb_1;
                                    mResult.setText(conversion);
                                    mEquation.setText(R.string.equation_celsius_1);
                                }
                                break;
                                case 2: {
                                    result = (input - 32) * (5 / 9);
                                    conversion = input + R.string.temp_symb_1 + " = " + result + R.string.temp_symb_2;
                                    mResult.setText(conversion);
                                    mEquation.setText(R.string.equation_celsius_2);
                                }
                                break;
                                case 3: {
                                    result = input - 273.15;
                                    conversion = input + R.string.temp_symb_1 + " = " + result + R.string.temp_symb_3;
                                    mResult.setText(conversion);
                                    mEquation.setText(R.string.equation_celsius_3);
                                }
                                break;
                                case 4: {
                                    result = (input - 491.67) * (5 / 9);
                                    conversion = input + R.string.temp_symb_1 + " = " + result + R.string.temp_symb_4;
                                    mResult.setText(conversion);
                                    mEquation.setText(R.string.equation_celsius_4);
                                }
                                break;
                                default:
                                    mResult.setText("Error: Select Converters.");
                            }
                        }
                        break;
                        case 2: {
                            //Fahrenheit
                            switch (selectedToId) {
                                case 1: {
                                    result = input * (9 / 5) + 32;
                                    conversion = input + R.string.temp_symb_2 + " = " + result + R.string.temp_symb_1;
                                    mResult.setText(conversion);
                                    mEquation.setText(R.string.equation_fahrenheit_1);
                                }
                                break;
                                case 2: {
                                    result = input;
                                    conversion = input + R.string.temp_symb_2 + " = " + result + R.string.temp_symb_2;
                                    mResult.setText(conversion);
                                    mEquation.setText(R.string.equation_fahrenheit_2);
                                }
                                break;
                                case 3: {
                                    result = input * (9 / 5) - 459.67;
                                    conversion = input + R.string.temp_symb_2 + " = " + result + R.string.temp_symb_3;
                                    mResult.setText(conversion);
                                    mEquation.setText(R.string.equation_fahrenheit_3);
                                }
                                break;
                                case 4: {
                                    result = input - 459.67;
                                    conversion = input + R.string.temp_symb_2 + " = " + result + R.string.temp_symb_4;
                                    mResult.setText(conversion);
                                    mEquation.setText(R.string.equation_fahrenheit_4);
                                }
                                break;
                                default:
                                    mResult.setText("Error: Select Converters.");
                            }
                        }
                        break;
                        case 3: {
                            //Kelvin
                            switch (selectedToId) {
                                case 1: {
                                    result = input + 273.15;
                                    conversion = input + R.string.temp_symb_3 + " = " + result + R.string.temp_symb_1;
                                    mResult.setText(conversion);
                                    mEquation.setText(R.string.equation_kelvin_1);
                                }
                                break;
                                case 2: {
                                    result = (input + 459.67) * (5 / 9);
                                    conversion = input + R.string.temp_symb_3 + " = " + result + R.string.temp_symb_2;
                                    mResult.setText(conversion);
                                    mEquation.setText(R.string.equation_kelvin_2);
                                }
                                break;
                                case 3: {
                                    result = input;
                                    conversion = input + R.string.temp_symb_3 + " = " + result + R.string.temp_symb_3;
                                    mResult.setText(conversion);
                                    mEquation.setText(R.string.equation_kelvin_3);
                                }
                                break;
                                case 4: {
                                    result = input * (5 / 9);
                                    conversion = input + R.string.temp_symb_3 + " = " + result + R.string.temp_symb_4;
                                    mResult.setText(conversion);
                                    mEquation.setText(R.string.equation_kelvin_4);
                                }
                                break;
                                default:
                                    mResult.setText("Error: Select Converters.");
                            }
                        }
                        break;
                        case 4: {
                            //Rankin
                            switch (selectedToId) {
                                case 1: {
                                    result = (input + 273.15) * (9 / 5);
                                    conversion = input + R.string.temp_symb_4 + " = " + result + R.string.temp_symb_1;
                                    mResult.setText(conversion);
                                    mEquation.setText(R.string.equation_Rankin_1);
                                }
                                break;
                                case 2: {
                                    result = input + 459.67;
                                    mResult.setText(input + R.string.temp_symb_4 + " = " + result + R.string.temp_symb_2);
                                    mEquation.setText(R.string.equation_Rankin_2);
                                }
                                break;
                                case 3: {
                                    result = input * (5 / 9);
                                    mResult.setText(input + R.string.temp_symb_4 + " = " + result + R.string.temp_symb_3);
                                    mEquation.setText(R.string.equation_Rankin_3);
                                }
                                break;
                                case 4: {
                                    result = input;
                                    mResult.setText(input + R.string.temp_symb_4 + " = " + result + R.string.temp_symb_4);
                                    mEquation.setText(R.string.equation_Rankin_4);
                                }
                                break;
                                default:
                                    mResult.setText("Error: Select Converters.");
                            }
                        }
                        break;
                        default:
                            mResult.setText("Error: Select Converters.");
                    }
                }else {
                    mResult.setText("Error: Input number.");
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