//ANDY CULLEN

//THE TEMPERATURECONVERTER CLASS MAINLY HANDLES THE 'CONVERT' BUTTON'S ONCLICK METHOD.
//THIS CLASS ASSIGNS USER INPUT TO VARIABLES, THEN CALLS THE CONVERTERCALCULATOR TO
//PERFORM THE APPROPRIATE CONVERSION CALCULATION. FROM THERE, THE RETURNED VALUES
//WILL BE FORMATTED AND PRINTED TO THE APPROPRIATE TEXT VIEWS.
//THIS CLASS ALSO HANDLES EXCEPTIONS.

package edu.kvcc.cis298.cis298assignment2;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    //CLASS VARIABLES:
    private EditText mUserInputEditText;

    private RadioGroup mFromChoiceRadioGroup;

    private RadioButton mUserFromChoice1;
    private RadioButton mUserFromChoice2;
    private RadioButton mUserFromChoice3;
    private RadioButton mUserFromChoice4;

    private RadioGroup mToChoiceRadioGroup;

    private RadioButton mUserToChoice1;
    private RadioButton mUserToChoice2;
    private RadioButton mUserToChoice3;
    private RadioButton mUserToChoice4;

    private Button mConvertButton;

    private TextView mConversionText;
    private TextView mFormulaText;

    private double mInputDouble;        //THE DOUBLE VARIABLE THAT HOLDS THE USER'S INPUT
    private int mFromChoice;            //THE RADIO BUTTON FROM THE 'FROM' GROUP THAT IS CHOSEN
    private int mToChoice;              //THE RADIO BUTTON FROM THE 'TO' GROUP THAT IS CHOSEN

    private String mFromChoiceSymbol;   //STRING VARIABLE THAT HOLDS THE SYMBOL OF THE 'FROM' TEMPERATURE SCALE THAT IS CHOSEN
    private String mToChoiceSymbol;     ///STRING VARIABLE THAT HOLDS THE SYMBOL OF THE 'TO' TEMPERATURE SCALE THAT IS CHOSEN

    //THIS METHOD IS CALLED WHEN THE APP IS STARTED
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        //ASSOCIATE XML-DEFINED VIEWS WITH CLASS VARIABLES
        mUserInputEditText = (EditText) findViewById(R.id.user_input);

        mFromChoiceRadioGroup = (RadioGroup) findViewById(R.id.from_radio_group);
        mUserFromChoice1 = (RadioButton) findViewById(R.id.from_celsius);
        mUserFromChoice2 = (RadioButton) findViewById(R.id.from_fahrenheit);
        mUserFromChoice3 = (RadioButton) findViewById(R.id.from_kelvin);
        mUserFromChoice4 = (RadioButton) findViewById(R.id.from_rankine);

        mToChoiceRadioGroup = (RadioGroup) findViewById(R.id.to_radio_group);
        mUserToChoice1 = (RadioButton) findViewById(R.id.to_celsius);
        mUserToChoice2 = (RadioButton) findViewById(R.id.to_fahrenheit);
        mUserToChoice3 = (RadioButton) findViewById(R.id.to_kelvin);
        mUserToChoice4 = (RadioButton) findViewById(R.id.to_rankine);

        mConversionText = (TextView) findViewById(R.id.conversion_text);
        mFormulaText = (TextView) findViewById(R.id.formula_text);

        mConvertButton = (Button) findViewById(R.id.convert_button);
        mConvertButton.setOnClickListener(new View.OnClickListener() {

            //THIS METHOD IS CALLED WHEN THE CONVERT BUTTON IS CLICKED
            @Override
            public void onClick(View view) {

                try {
                    //Take user input (string) and parse it to a Double
                    mInputDouble = Double.parseDouble(mUserInputEditText.getText().toString());

                    //DETERMINE THE ID OF THE 'FROM' CHOICE BY CHECKING THE RADIO BUTTON ID
                    //ASSIGN THE APPROPRIATE SYMBOL
                    switch (mFromChoiceRadioGroup.getCheckedRadioButtonId()) {
                        case R.id.from_celsius:
                            mFromChoice = 0;
                            mFromChoiceSymbol = "°C";
                            break;
                        case R.id.from_fahrenheit:
                            mFromChoice = 1;
                            mFromChoiceSymbol = "°F";
                            break;
                        case R.id.from_kelvin:
                            mFromChoice = 2;
                            mFromChoiceSymbol = "K";
                            break;
                        case R.id.from_rankine:
                            mFromChoice = 3;
                            mFromChoiceSymbol = "°R";
                            break;
                    }

                    //DETERMINE THE ID OF THE 'TO' CHOICE BY CHECKING THE RADIO BUTTON ID
                    //ASSIGN THE APPROPRIATE SYMBOL
                    switch (mToChoiceRadioGroup.getCheckedRadioButtonId()) {
                        case R.id.to_celsius:
                            mToChoice = 0;
                            mToChoiceSymbol = "°C";
                            break;
                        case R.id.to_fahrenheit:
                            mToChoice = 1;
                            mToChoiceSymbol = "°F";
                            break;
                        case R.id.to_kelvin:
                            mToChoice = 2;
                            mToChoiceSymbol = "K";
                            break;
                        case R.id.to_rankine:
                            mToChoice = 3;
                            mToChoiceSymbol = "°R";
                            break;
                    }

                    //CHECK IF EITHER OF THE RADIO BUTTON GROUPS REMAIN UNCHECKED
                    if ((mFromChoiceRadioGroup.getCheckedRadioButtonId()==-1) || (mToChoiceRadioGroup.getCheckedRadioButtonId()==-1)) {
                        //USE A TOAST TO INFORM THE USER TO MAKE THEIR SELECTIONS
                        Toast.makeText(TemperatureConverter.this, "Please select two temperature scales for conversion.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //Create a ConverterCalculator to do the conversion calculation. Pass in necessary values.
                        ConverterCalculator converterCalculator = new ConverterCalculator(mInputDouble, mFromChoice, mToChoice);

                        //Show the result of the converted equation
                        mConversionText.setText(mInputDouble + " " + mFromChoiceSymbol + " = " +
                                String.format("%.2f", converterCalculator.getCalculation()) + " " + mToChoiceSymbol);

                        //Show the formula that was used for the conversion
                        mFormulaText.setText(converterCalculator.getFormula());
                    }
                }
                //IF A NUMBERFORMATEXCEPTION IS THROWN...
                catch (NumberFormatException e) {
                    //...USE A TOAST TO INFORM THE USER THAT THEY NEED TO ENTER A NUMBER
                    Toast.makeText(TemperatureConverter.this, "Please enter a temperature value.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //~~~~~~~~~~~~~~~~BEGINNING OF UNEDITED GOOGLE-PROVIDED METHODS:~~~~~~~~~~~~~~~~~~~~~

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
