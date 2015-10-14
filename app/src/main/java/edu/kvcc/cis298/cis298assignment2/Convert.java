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
public class Convert  extends AppCompatActivity {




    public double Calculation(int selectedFrom, int selectedTo, double input){

        double result = 0;

            switch (selectedFrom) {
                case (R.id.from_temp_1): {
                    //celsius
                    switch (selectedTo) {
                        case (R.id.to_temp_1): {
                            result = input;
                        }
                        break;
                        case (R.id.to_temp_2): {
                            result = (input - 32) * (5 / 9);
                        }
                        break;
                        case (R.id.to_temp_3): {
                            result = input - 273.15;
                        }
                        break;
                        case (R.id.to_temp_4): {
                            result = (input - 491.67) * (5 / 9);
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
                            result = input * (9 / 5) + 32;
                        }
                        break;
                        case (R.id.to_temp_2): {
                            result = input;
                        }
                        break;
                        case (R.id.to_temp_3): {
                            result = input * (9 / 5) - 459.67;
                        }
                        break;
                        case (R.id.to_temp_4): {
                            result = input - 459.67;
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
                            result = input + 273.15;
                        }
                        break;
                        case (R.id.to_temp_2): {
                            result = (input + 459.67) * (5 / 9);
                        }
                        break;
                        case (R.id.to_temp_3): {
                            result = input;
                        }
                        break;
                        case (R.id.to_temp_4): {
                            result = input * (5 / 9);
                        }
                        break;
                        default:
                    }
                }
                break;
                case (R.id.from_temp_4): {
                    //Rankin
                    switch (R.id.to_temp_1) {
                        case 1: {
                            result = (input + 273.15) * (9 / 5);
                        }
                        break;
                        case (R.id.to_temp_2): {
                            result = input + 459.67;
                        }
                        break;
                        case (R.id.to_temp_3): {
                            result = input * (9 / 5);
                        }
                        break;
                        case (R.id.to_temp_4): {
                            result = input;
                        }
                        break;
                        default:
                            break;
                    }
                }
                break;
                default:
        }
        return result;
    }
    public String Result(int selectedFrom, int selectedTo, double input, double result){

        String conversion = "";

        switch (selectedFrom) {
            case (R.id.from_temp_1): {
                //celsius
                switch (selectedTo) {
                    case (R.id.to_temp_1): {
                        conversion = input + R.string.temp_symb_1 + " = " + result + R.string.temp_symb_1;
                    }
                    break;
                    case (R.id.to_temp_2): {
                        conversion = input + R.string.temp_symb_1 + " = " + result + R.string.temp_symb_2;
                    }
                    break;
                    case (R.id.to_temp_3): {
                        conversion = input + R.string.temp_symb_1 + " = " + result + R.string.temp_symb_3;
                    }
                    break;
                    case (R.id.to_temp_4): {
                        conversion = input + R.string.temp_symb_1 + " = " + result + R.string.temp_symb_4;
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
                        conversion = input + R.string.temp_symb_2 + " = " + result + R.string.temp_symb_1;
                    }
                    break;
                    case (R.id.to_temp_2): {
                        conversion = input + R.string.temp_symb_2 + " = " + result + R.string.temp_symb_2;
                    }
                    break;
                    case (R.id.to_temp_3): {
                        conversion = input + R.string.temp_symb_2 + " = " + result + R.string.temp_symb_3;
                    }
                    break;
                    case (R.id.to_temp_4): {
                        conversion = input + R.string.temp_symb_2 + " = " + result + R.string.temp_symb_4;
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
                        conversion = input + R.string.temp_symb_3 + " = " + result + R.string.temp_symb_1;
                    }
                    break;
                    case (R.id.to_temp_2): {
                        conversion = input + R.string.temp_symb_3 + " = " + result + R.string.temp_symb_2;
                    }
                    break;
                    case (R.id.to_temp_3): {
                        conversion = input + R.string.temp_symb_3 + " = " + result + R.string.temp_symb_3;
                    }
                    break;
                    case (R.id.to_temp_4): {
                        conversion = input + R.string.temp_symb_3 + " = " + result + R.string.temp_symb_4;
                    }
                    break;
                    default:
                }
            }
            break;
            case (R.id.from_temp_4): {
                //Rankin
                switch (R.id.to_temp_1) {
                    case 1: {
                        conversion = input + R.string.temp_symb_4 + " = " + result + R.string.temp_symb_1;
                    }
                    break;
                    case (R.id.to_temp_2): {
                        conversion = input + R.string.temp_symb_4 + " = " + result + R.string.temp_symb_2;
                    }
                    break;
                    case (R.id.to_temp_3): {
                        conversion = input + R.string.temp_symb_4 + " = " + result + R.string.temp_symb_3;
                    }
                    break;
                    case (R.id.to_temp_4): {
                        conversion = input + R.string.temp_symb_4 + " = " + result + R.string.temp_symb_4;
                    }
                    break;
                    default:
                        break;
                }
            }
            break;
            default:
        }
        return conversion;
    }
    public int equation(int selectedFrom, int selectedTo){

        int equation = 0;
        switch (selectedFrom) {
            case (R.id.from_temp_1): {
                //celsius
                switch (selectedTo) {
                    case (R.id.to_temp_1): {
                        equation = R.string.equation_celsius_1;
                    }
                    break;
                    case (R.id.to_temp_2): {
                        equation = R.string.equation_celsius_2;
                    }
                    break;
                    case (R.id.to_temp_3): {
                        equation = R.string.equation_celsius_3;
                    }
                    break;
                    case (R.id.to_temp_4): {
                        equation = R.string.equation_celsius_4;
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
                    }
                    break;
                    case (R.id.to_temp_2): {
                        equation = R.string.equation_fahrenheit_2;
                    }
                    break;
                    case (R.id.to_temp_3): {
                        equation = R.string.equation_fahrenheit_3;
                    }
                    break;
                    case (R.id.to_temp_4): {
                        equation = R.string.equation_fahrenheit_4;
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
                    }
                    break;
                    case (R.id.to_temp_2): {
                        equation = R.string.equation_kelvin_2;
                    }
                    break;
                    case (R.id.to_temp_3): {
                        equation = R.string.equation_kelvin_3;
                    }
                    break;
                    case (R.id.to_temp_4): {
                        equation = R.string.equation_kelvin_4;
                    }
                    break;
                    default:
                }
            }
            break;
            case (R.id.from_temp_4): {
                //Rankin
                switch (R.id.to_temp_1) {
                    case 1: {
                        equation = R.string.equation_Rankin_1;
                    }
                    break;
                    case (R.id.to_temp_2): {
                        equation = R.string.equation_Rankin_2;
                    }
                    break;
                    case (R.id.to_temp_3): {
                        equation = R.string.equation_Rankin_3;
                    }
                    break;
                    case (R.id.to_temp_4): {
                        equation = R.string.equation_Rankin_4;
                    }
                    break;
                    default:
                        break;
                }
            }
            break;
            default:
        }
        return equation;
    }

}