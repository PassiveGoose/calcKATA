package utils;

public class ValidationUtils {

    public static void validateNumberOfInputs(String[] data)  throws Exception {
        if (data.length != 3) throw new Exception();
    }

    public static boolean validateValues(String[] data) throws Exception{
        try {
            int first = Integer.parseInt(data[0]);
            int second = Integer.parseInt(data[2]);
            if (first >= 1 && first <= 10 && second >= 1 && second <= 10) {
                return false;
            } else {
                throw new Exception();
            }
        } catch (NumberFormatException e) {
            int first = ConvertingUtils.romanToInt(data[0]);
            int second = ConvertingUtils.romanToInt(data[2]);
            if (first >= 1 && first <= 10 && second >= 1 && second <= 10) {
                return true;
            } else {
                throw new Exception();
            }
        }
    }
}
