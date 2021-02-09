package project.skat.kodetest;

import java.text.DecimalFormat;

public class NumberToStringLiteral {
    private static final String[] tensNames = {
            "",
            " TEN ",
            " TWENTY ",
            " THIRTY ",
            " FORTY ",
            " FIFTY ",
            " SIXTY ",
            " SEVENTY ",
            " EIGHTY ",
            " NINETY "
    };
    private static final String[] numNames = {
            "",
            " ONE ",
            " TWO ",
            " THREE ",
            " FOUR ",
            " FIVE ",
            " SIX ",
            " SEVEN ",
            " EIGHT ",
            " NINE ",
            " TEN ",
            " ELEVEN ",
            " TWELVE ",
            " THIRTEEN ",
            " FOURTEEN ",
            " FIFTEEN ",
            " SIXTEEN ",
            " SEVENTEEN ",
            " EIGHTEEN ",
            " NINETY "
    };

    private NumberToStringLiteral() {}


    private static String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20){
            soFar = numNames[number % 100];
            number /= 100;
        }
        else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) {
            return soFar;
        }
        if (!(soFar.equals(""))){
            return numNames[number] + " HUNDRED AND " + soFar;
        }
        return numNames[number] + " HUNDRED " + soFar;
    }

    public static String convert(double number) {
        // 0 to 999999.99
        if (number > 999999.99 || number < 0){
            throw new IndexOutOfBoundsException("The number " + number + " is out of bounds!");
        }

        // pad with "0"
        String mask = "000000.00";
        DecimalFormat df = new DecimalFormat(mask);
        String snumber = df.format(number);

        // seperating whole numbers and decimals
        int wholeNumbers = Integer.parseInt(snumber.substring(0, 6));
        int decimals = Integer.parseInt(snumber.substring(7, 9));

        if (decimals == 0) {
            return convertWholeNumbers(wholeNumbers) + "DOLLARS AND ZERO CENTS";
        } else {
            if (wholeNumbers == 1 && decimals == 1) {
                return convertWholeNumbers(wholeNumbers) + "DOLLAR AND " + convertDecimals(decimals) + "CENT";
            } else if (wholeNumbers == 1) {
                return convertWholeNumbers(wholeNumbers) + "DOLLAR AND " + convertDecimals(decimals) + "CENTS";
            } else if (decimals == 1){
                return convertWholeNumbers(wholeNumbers) + "DOLLARS AND " + convertDecimals(decimals) + "CENT";
            } else {
                return convertWholeNumbers(wholeNumbers) + "DOLLARS AND " + convertDecimals(decimals) + "CENTS";
            }
        }
    }

    private static String convertDecimals(int decimals) {
        String decimalsliteral = convertLessThanOneThousand(decimals);
        return removeExtraSpaces(decimalsliteral);
    }

    public static String convertWholeNumbers(int number) {
        if (number == 0) { return "ZERO "; }

        // pad with "0"
        String mask = "000000";
        DecimalFormat df = new DecimalFormat(mask);
        String snumber = df.format(number);

        // XXXnnn
        int hundredThousands = Integer.parseInt(snumber.substring(0,3));
        // nnnXXX
        int thousands = Integer.parseInt(snumber.substring(3,6));

        String result = "";

        String tradHundredThousands;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1 :
                tradHundredThousands = "ONE THOUSAND ";
                break;
            default :
                tradHundredThousands = convertLessThanOneThousand(hundredThousands)
                        + " THOUSAND ";
        }
        result =  result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);

        if (!(result.equals("")) && !(tradThousand.equals(""))){
            result =  result+"AND"+tradThousand;
        }else {
            result =  result+tradThousand;
        }

        return removeExtraSpaces(result);
    }

    private static String removeExtraSpaces(String number){
        // remove extra spaces!
        return number.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }
}

