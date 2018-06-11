package algoritm.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by u_kino07 on 2018. 6. 3..
 */
public class Atoi {
    public int atoi(final String string) {
        char[] chars = string.toCharArray();
        List<Character> target = new ArrayList<>();
        boolean isNegative = false;

        for (int i = 0; i < chars.length; i++) {
            char each = chars[i];

            if (! Character.isDigit(each) && ! Character.isWhitespace(each) &&  ! (each == '-') && ! (each == '+')) {
                if (target.size() > 0) {
                    return convertCharactersToInt(isNegative, target);
                }
                return 0;
            }

            if (! Character.isWhitespace(each)) {
                if (each == '-') {
                    if (target.size() > 0) {
                        return convertCharactersToInt(isNegative, target);
                    }
                    isNegative = true;
                    continue;
                }
                if (each == '+') {
                    if (target.size() > 0) {
                        return convertCharactersToInt(isNegative, target);
                    }
                    isNegative = false;
                    continue;
                }
                target.add(each);
            } else {
                if (target.size() > 0) {
                    return convertCharactersToInt(isNegative, target);
                }
            }
        }

        return convertCharactersToInt(isNegative, target);
    }

    public int convertCharactersToInt(boolean isNegative, List<Character> chars) {
        long result = 0;
        long digit = 1;
        for (int i = chars.size() - 1; i >= 0; i--) {
            result += (chars.get(i) - '0') * digit;

            if (isNegative == false && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (isNegative && result * -1 < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            digit *= 10;
        }

        if (isNegative) {
            return -1 * (int)result;
        }

        return (int)result;
    }
}
