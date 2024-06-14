import java.util.HashSet;
import java.util.Set;

class ValidationUtils {

    private static final Set<String> VALID_TO_USE = new HashSet<>();

    static {
        VALID_TO_USE.add("I");
        VALID_TO_USE.add("II");
        VALID_TO_USE.add("III");
        VALID_TO_USE.add("IV");
        VALID_TO_USE.add("V");
        VALID_TO_USE.add("VI");
        VALID_TO_USE.add("VII");
        VALID_TO_USE.add("VIII");
        VALID_TO_USE.add("IX");
        VALID_TO_USE.add("X");
    }

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
            if (VALID_TO_USE.contains(data[0]) && VALID_TO_USE.contains(data[2])) {
                return true;
            } else {
                throw new Exception();
            }
        }
    }
}
