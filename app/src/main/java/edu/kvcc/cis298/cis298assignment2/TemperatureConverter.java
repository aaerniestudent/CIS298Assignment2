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
    int equation = 0;
    int mType = 0;
    String mEndResult = "";

    protected void showError(int messageResId){
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        mInputText = (EditText) findViewById(R.id.input);
        mResult = (TextView) findViewById(R.id.result);
        mEquation = (TextView) findViewById(R.id.equation);
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
                            int selectedFrom = mFromGroup.getCheckedRadioButtonId();
                            int selectedTo = mToGroup.getCheckedRadioButtonId();
                            double mInput = Double.parseDouble(mInputText.getText().toString());
                            switch (selectedFrom) {
                                case (R.id.from_temp_1): {
                                    //celsius
                                    switch (selectedTo) {
                                        case (R.id.to_temp_1): {
                                            equation = R.string.equation_celsius_1;
                                            mType = 1;
                                        }
                                        break;
                                        case (R.id.to_temp_2): {
                                            equation = R.string.equation_celsius_2;
                                            mType = 2;
                                        }
                                        break;
                                        case (R.id.to_temp_3): {
                                            equation = R.string.equation_celsius_3;

                                            mType = 3;
                                        }
                                        break;
                                        case (R.id.to_temp_4): {
                                            equation = R.string.equation_celsius_4;

                                            mType = 4;
                                        }
                                        break;
                                        default:
                                    }
                                }
                                break;
                                case (R.id.from_temp_2): {
                                    //Fahrenheit
                                    switch (R.id.to_temp_1) {
                                        case 1: {
                                            equation = R.string.equation_fahrenheit_1;
                                            mType = 5;
                                        }
                                        break;
                                        case (R.id.to_temp_2): {
                                            equation = R.string.equation_fahrenheit_2;
                                            mType = 6;
                                        }
                                        break;
                                        case (R.id.to_temp_3): {
                                            equation = R.string.equation_fahrenheit_3;
                                            mType = 7;
                                        }
                                        break;
                                        case (R.id.to_temp_4): {
                                            equation = R.string.equation_fahrenheit_4;
                                            mType = 8;
                                        }
                                        break;
                                        default:
                                    }
                                }
                                break;
                                case (R.id.from_temp_3): {
                                    //Kelvin
                                    switch (selectedTo) {
                                        case (R.id.to_temp_1): {
                                            equation = R.string.equation_kelvin_1;
                                            mType = 9;
                                        }
                                        break;
                                        case (R.id.to_temp_2): {
                                            equation = R.string.equation_kelvin_2;
                                            mType = 10;
                                        }
                                        break;
                                        case (R.id.to_temp_3): {
                                            equation = R.string.equation_kelvin_3;
                                            mType = 11;
                                        }
                                        break;
                                        case (R.id.to_temp_4): {
                                            equation = R.string.equation_kelvin_4;
                                            mType = 12;
                                        }
                                        break;
                                        default:
                                    }
                                }
                                break;
                                case (R.id.from_temp_4): {
                                    //Rankin
                                    switch (R.id.to_temp_1) {
                                        case (R.id.to_temp_1): {
                                            equation = R.string.equation_Rankin_1;
                                            mType = 13;
                                        }
                                        break;
                                        case (R.id.to_temp_2): {
                                            equation = R.string.equation_Rankin_2;
                                            mType = 14;
                                        }
                                        break;
                                        case (R.id.to_temp_3): {
                                            equation = R.string.equation_Rankin_3;
                                            mType = 15;
                                        }
                                        break;
                                        case (R.id.to_temp_4): {
                                            equation = R.string.equation_Rankin_4;
                                            mType = 16;
                                        }
                                        break;
                                        default:
                                            break;
                                    }
                                }
                                break;
                                default:
                            }
                            double mResult = convert.Calculation(mType, mInput);
                            mResult = mResult * 100;
                            mResult = Math.round(mResult);
                            mResult = mResult / 100;
                            mInput = mInput * 100;
                            mInput = Math.round(mInput);
                            mInput = mInput / 100;
                            Log.i("tag","4");
                            switch (equation) {
                                //celsius
                                case 1: {
                                    mEndResult = Double.toString(mInput) + " °C = " + Double.toString(mResult) + " °C";
                                }
                                break;
                                case 2: {
                                    mEndResult = Double.toString(mInput) + " °C = " + Double.toString(mResult) + " °F";
                                }
                                break;
                                case 3: {
                                    mEndResult = Double.toString(mInput) + " °C = " + Double.toString(mResult) + " K";
                                }
                                break;
                                case 4: {
                                    mEndResult = Double.toString(mInput) + " °C = " + Double.toString(mResult) + " °R";
                                }
                                break;
                                //Fahrenheit
                                case 5: {
                                    mEndResult = Double.toString(mInput) + " °F = " + Double.toString(mResult) + " °C";
                                }
                                break;
                                case 6: {
                                    mEndResult = Double.toString(mInput) + " °F = " + Double.toString(mResult) + " °F";
                                }
                                break;
                                case 7: {
                                    mEndResult = Double.toString(mInput) + " °F = " + Double.toString(mResult) + " K";
                                }
                                break;
                                case 8: {
                                    mEndResult = Double.toString(mInput) + " °F = " + Double.toString(mResult) + " °R";
                                }
                                break;
                                //Kelvin
                                case 9: {
                                    mEndResult = Double.toString(mInput) + " K = " + Double.toString(mResult) + " °C";
                                }
                                break;
                                case 10: {
                                    mEndResult = Double.toString(mInput) + " K = " + Double.toString(mResult) + " °F";
                                }
                                break;
                                case 11: {
                                    mEndResult = Double.toString(mInput) + " K = " + Double.toString(mResult) + " K";
                                }
                                break;
                                case 12: {
                                    mEndResult = Double.toString(mInput) + " K = " + Double.toString(mResult) + " °R";
                                }
                                break;
                                //Rankin
                                case 13: {
                                    mEndResult = Double.toString(mInput) + " °R = " + Double.toString(mResult) + " °C";

                                }
                                break;
                                case 14: {
                                    mEndResult = Double.toString(mInput) + " °R = " + Double.toString(mResult) + " °F";

                                }
                                break;
                                case 15: {
                                    mEndResult = Double.toString(mInput) + " °R = " + Double.toString(mResult) + " K";

                                }
                                break;
                                case 16: {
                                    mEndResult = Double.toString(mInput) + " °R = " + Double.toString(mResult) + " °R";

                                }
                                break;
                                default:
                                    break;
                            }
                            mResult.setText(mEndResult);
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