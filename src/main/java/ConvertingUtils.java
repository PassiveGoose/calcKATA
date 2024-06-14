import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class ConvertingUtils {

    private static final Map<Character, Integer> ROMAN_INT_MAP = new HashMap<>();
    private static final Map<Integer, String> INT_ROMAN_MAP = new HashMap<>();

    static {
        ROMAN_INT_MAP.put('I', 1);
        ROMAN_INT_MAP.put('V', 5);
        ROMAN_INT_MAP.put('X', 10);

        INT_ROMAN_MAP.put(1, "I");
        INT_ROMAN_MAP.put(5, "V");
        INT_ROMAN_MAP.put(10, "X");
        INT_ROMAN_MAP.put(50, "L");
        INT_ROMAN_MAP.put(100, "C");
    }

    public static int romanToInt(String s) throws Exception{
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int multiple = 1;
            if (s.charAt(i) == 'I') {
                if (i < s.length() - 1) {
                    if (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X') {
                        multiple = -1;
                    }
                }
            }
            try {
                ans += (multiple * ROMAN_INT_MAP.get(s.charAt(i)));
            } catch (NullPointerException e) {
                throw new Exception();
            }
        }

        return ans;
    }

    public static String intToRoman(int num) {
        Deque<String> res = new ArrayDeque<>();

        int base = 1;
        while (num != 0) {
            int digit = Math.floorMod(num, 10);
            if (digit == 4 || digit == 9) {
                res.offerLast(INT_ROMAN_MAP.get(base * (digit + 1)));
                res.offerLast(INT_ROMAN_MAP.get(base));
            } else {
                if (digit < 4) {
                    for (int i = 0; i < digit; i++) {
                        res.offerLast(INT_ROMAN_MAP.get(base));
                    }
                } else if (digit > 5) {
                    digit -= 5;
                    for (int i = 0; i < digit; i++) {
                        res.offerLast(INT_ROMAN_MAP.get(base));
                    }
                    res.offerLast(INT_ROMAN_MAP.get(5*base));
                } else {
                    res.offerLast(INT_ROMAN_MAP.get(digit*base));
                }
            }
            num = Math.floorDiv(num, 10);
            base *= 10;
        }

        StringBuilder answer = new StringBuilder();
        while (!res.isEmpty()) {
            answer.append(res.pollLast());
        }

        return answer.toString();
    }
}
