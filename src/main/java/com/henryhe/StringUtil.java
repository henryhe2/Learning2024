package com.henryhe;

public class StringUtil {

    public String removeDup(String str, boolean advancedReqFlag) throws RuntimeException {
        checkStrIsLowerCase(str);
        while (true) {
            String str2 = removeDupDetail(str, advancedReqFlag);
            if (str2.equals(str)) {
                break;
            } else {
                System.out.println(str2);
                str = str2;
            }
        }
        return str;
    }

    public String removeDupDetail(String str, boolean advancedReqFlag) {
        for (int i = 0; i < str.length(); ++i) {
            int dup = 1;
            int j = i + 1;
            for (; j < str.length(); ++j) {
                if (str.charAt(i) != str.charAt(j)) {
                    break;
                } else {
                    dup++;
                }
            }
            if (dup >= 3) {
                String replaceStr = "";
                if (advancedReqFlag && str.charAt(i) >= 98) {
                    char l = (char) (str.charAt(i) - 1);
                    replaceStr = String.valueOf(l);
                }
                return (i == 0 ? "" : str.substring(0, i)) + replaceStr + str.substring(j);
            }
        }
        return str;
    }

    public void checkStrIsLowerCase(String str) {
        for (int i = 0; i < str.length(); ++i) {
            if (!Character.isLowerCase(str.charAt(i))) {
                throw new RuntimeException("unsupported string");
            }
        }
    }

}
