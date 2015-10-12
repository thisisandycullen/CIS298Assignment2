package edu.kvcc.cis298.cis298assignment2;

/**
 * Created by Andy Cullen on 10/11/2015.
*/

//THIS METHOD TAKES IN THE USER'S INPUT VALUE AND THE CHOSEN TEMPERATURE SCALES, THEN USES THE
//APPROPRIATE FORMULA TO CALCULATE THE CONVERTED VALUE.

public class ConverterCalculator {

    //CLASS VARIABLES
    private double mInput;
    private int mFromChoice;
    private int mToChoice;

    private double mCalculation;
    private String mFormula;

    //CONSTRUCTOR METHOD
    public ConverterCalculator(double input, int fromChoice, int toChoice){
        mInput = input;
        mFromChoice = fromChoice;
        mToChoice = toChoice;

        getConversionType();
    }

    //ANALYZES THE FROM AND TO CHOICES TO DETERMINE THE METHOD OF CONVERSION
    public void getConversionType() {

        //FROM CELSIUS TO [0=CELSIUS, 1=FAHRENHEIT, 2=KELVIN, 3=RANKINE]
        if(mFromChoice == 0) {
            switch (mToChoice) {
                case 0:
                    mCalculation = mInput;
                    mFormula = "[°C] = [°C]";
                    break;
                case 1:
                    mCalculation = (mInput * 1.8) + 32;
                    mFormula = "([°C] x 9/5) + 32 = [°F]";
                    break;
                case 2:
                    mCalculation = mInput + 273.15;
                    mFormula = "[°C] + 273.15 = [K]";
                    break;
                case 3:
                    mCalculation = (mInput + 273.15) * 1.8;
                    mFormula = "([°C] + 273.15) x 9/5 = [°R]";
                    break;
            }
        }

        //FROM FAHRENHEIT TO [0=CELSIUS, 1=FAHRENHEIT, 2=KELVIN, 3=RANKINE]
        if(mFromChoice == 1) {
            switch (mToChoice) {
                case 0:
                    mCalculation = (mInput - 32) * 5/9;
                    mFormula = "([°F] - 32) x 5/9 = [°C]";
                    break;
                case 1:
                    mCalculation = mInput;
                    mFormula = "[°F] = [°F]";
                    break;
                case 2:
                    mCalculation = (mInput + 459.67) * 5/9;
                    mFormula ="([°F] + 459.67) x 5/9 = [K]";
                    break;
                case 3:
                    mCalculation = mInput + 459.67;
                    mFormula = "[°F] + 459.67 = [°R]";
                    break;
            }
        }

        //FROM KELVIN TO [0=CELSIUS, 1=FAHRENHEIT, 2=KELVIN, 3=RANKINE]
        if(mFromChoice == 2) {
            switch (mToChoice) {
                case 0:
                    mCalculation = mInput - 273.15;
                    mFormula = "[K] - 273.15 = [°C]";
                    break;
                case 1:
                    mCalculation = (mInput * 1.8) - 459.67;
                    mFormula = "([K] x 9/5) - 459.67 = [°F]";
                    break;
                case 2:
                    mCalculation = mInput;
                    mFormula = "[K] = [K]";
                    break;
                case 3:
                    mCalculation = mInput * 1.8;
                    mFormula = "[K] x 9/5 = [°R]";
                    break;
            }
        }

        //FROM RANKINE TO [0=CELSIUS, 1=FAHRENHEIT, 2=KELVIN, 3=RANKINE]
        if(mFromChoice == 3) {
            switch (mToChoice) {
                case 0:
                    mCalculation = (mInput - 491.67) * 5/9;
                    mFormula = "([°R] - 491.67) x 5/9 = [°C]";
                    break;
                case 1:
                    mCalculation = mInput - 459.67;
                    mFormula = "[°R] - 459.67 = [°F]";
                    break;
                case 2:
                    mCalculation = mInput * 5/9;
                    mFormula = "[°R] x 5/9 = [K]";
                    break;
                case 3:
                    mCalculation = mInput;
                    mFormula = "[°R] = [°R]";
                    break;
            }
        }
    }

    //THIS PUBLIC METHOD RETURNS THE CALCULATED VALUE OF THE CONVERSION
    public double getCalculation() {
        return (mCalculation);
    }

    //THIS PUBLIC METHOD RETURNS THE FORMULA OF THE CONVERSION
    public String getFormula() {
        return (mFormula);
    }
}
