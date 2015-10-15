package edu.kvcc.cis298.cis298assignment2;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Anthony on 10/11/2015.
*/
public class Convert{


    public double Calculation(int equationType, double input){
        double result = 0;
            switch (equationType) {
                    //celsius
                        case 1: {
                            result = input;
                        }
                        break;
                        case 2: {

                            Log.i("tag",Double.toString(input));
                            result = ((5.0 / 9.0) * input + 32.0);
                        }
                        break;
                        case 3: {
                            result = input + 273.15;
                        }
                        break;
                        case 4: {
                            result = (5.0 / 9.0 * input + 491.67);
                        }
                        break;
                    //Fahrenheit
                        case 5: {
                            result = ((9.0 / 5.0) * input - 32.0);
                        }
                        break;
                        case 6: {
                            result = input;
                        }
                        break;
                        case 7: {
                            result = (9.0 / 5.0 * input + 459.67);
                        }
                        break;
                        case 8: {
                            result = (input + 459.67);
                        }
                        break;
                    //Kelvin
                        case 9: {
                            result = (input - 273.15);
                        }
                        break;
                        case 10: {
                            result = (5.0 / 9.0 * input - 459.67);
                        }
                        break;
                        case 11: {
                            result = input;
                        }
                        break;
                        case 12: {
                            result = (5.0 / 9.0 * input);
                        }
                        break;
                    //Rankin
                        case 13: {
                            result = ((9.0 / 5.0) * input - 273.15);
                        }
                        break;
                        case 14: {
                            result = (input - 459.67);
                        }
                        break;
                        case 15: {
                            result = ((9.0 / 5.0) * input);
                        }
                        break;
                        case 16: {
                            result = input;
                        }
                        break;
                        default:
                            break;
                    }
        return result;
    }
}