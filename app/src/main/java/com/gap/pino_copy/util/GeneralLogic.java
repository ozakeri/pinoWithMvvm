package com.gap.pino_copy.util;

public class GeneralLogic {

    public static Boolean nationalCodeValidate(String nationalCode) {

        Boolean result = false;
        char[] nationalCodeAR = nationalCode.toCharArray();
        if (nationalCode.length() == 10) {
            int n = 0, equalCount = 0;

            //---this loop check all number in this string is equal
            while (n < 9 && equalCount < 1) {
                if (nationalCodeAR[9] != nationalCodeAR[n]) {
                    equalCount += 1;
                }
                n += 1;
            }
            if (equalCount > 0) {
                Integer paramCheck = Integer.parseInt(new String(nationalCodeAR, 9, 1));
                Integer sumVal = 0;
                for (n = 0; n < 9; n++) {
                    sumVal += Integer.parseInt(new String(nationalCodeAR, n, 1)) * (10 - n);
                }

                Double a = (Math.ceil(sumVal / 11) * 11);
                Integer paramResult = sumVal - a.intValue();

                if (paramResult <= 1 && paramCheck == paramResult) {
                    result = true;
                }
                if (paramResult > 1 && paramCheck == 11 - paramResult) {
                    result = true;
                }
            }
        }

        return result;
    }
}
