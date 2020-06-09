package Tool;

public class Mask {

    public static String hideMessage(String text, int start, int length, char c) {

        if (text.isEmpty() || text == null) {
            return "";
        }
        if (start < 0) {
            start = 0;//如果起始位置輸入小於0,設為0
        }
        if (length < 1) {//如果要求遮蔽的長度<1,代表沒有要遮
            return text;
        }
        StringBuilder sb = new StringBuilder();
        char chars[] = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i >= start && i < (start + length)) {
                sb.append(c);
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static String hideMessage(String s, int start, int length, String replace) {
        String text = s;

        if (replace.isEmpty() || replace == null) {
            replace = "*";
        }

        if (s.isEmpty() || s == null) {
            return "";
        }
        if (start < 1) {
            start = 1;//如果起始位置輸入小於0,設為0
        }
        if (length < 1) {//如果要求遮蔽的長度<1,代表沒有要遮

            return text;
        }

        String s1 = s.substring(0, start - 1);
        String s2 = s.substring(start - 1, start - 1 + length);
        String s3 = s.substring(start - 1 + length);
        String tempString = "";
        for (int i = 0; i < s2.length(); i++) {
            tempString += replace;
        }
        s2 = tempString;
        text = s1 + s2 + s3;
        return text;
//        s=s.substring(start,s.length()-start);
//        text.replace
//        char c[]=s.toCharArray();
//
//        retrun text;

    }


}
