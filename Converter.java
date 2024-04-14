package Calculator;

public class Converter {
    public static String convertResultToRomes(int resultInt) {
        String s = "";
        if (resultInt < 0){
            s="-";
            resultInt *= -1;
        }
        while (resultInt >= 100) {
            s += "C";
            resultInt -= 100;
        }
        while (resultInt >= 50) {
            s += "L";
            resultInt -= 50;
        }
        while (resultInt >= 10) {
            s += "X";
            resultInt -= 10;
        }
        while (resultInt >= 9) {
            s += "IX";
            resultInt -= 9;
        }
        while (resultInt >= 5) {
            s += "V";
            resultInt -= 5;
        }
        while (resultInt >= 4) {
            s += "IV";
            resultInt -= 4;
        }
        while (resultInt >= 1) {
            s += "I";
            resultInt -= 1;
        }
        return s;
    }
    public static int convertToInt(String romesValue){
        char[] valueChar = romesValue.toCharArray();
        int[] valuesInt = new int[valueChar.length];
        for (int i = 0; i < valueChar.length; i++) {
            switch (valueChar[i]) {
                case 'I':
                    valuesInt[i] = 1;
                    break;
                case 'V':
                    valuesInt[i] = 5;
                    break;
                case 'X':
                    valuesInt[i] = 10;
                    break;

                default:
                    System.out.println("Содержится неверный символ. Проверьте правильность ввода римских цифр:" + "\n" +
                            "I = 1" + "\n" +
                            "V = 5" + "\n" +
                            "X = 10");
                    break;
            }
        }
        int result = valuesInt[0];
        for (int i = 0; i < valuesInt.length && valuesInt.length > i + 1; i++) {
            if (valuesInt[i] >= valuesInt[i+1]) {
                result += valuesInt[i+1];
            } else if (valuesInt[i] < valuesInt[i+1]) {
                result = result + valuesInt[i+1] - 2;
            }
        }
        return result;
    }

}