class Solution {
    public String solution(String polynomial) {
        String answer = "";

        int xValue = 0;
        int nValue = 0;

        String[] str = polynomial.split(" ");
        for (String s : str) {
            if (s.equals("+")) continue;
            if (s.contains("x")) {
                s = s.replace("x", "");

                if (s.isEmpty()) {
                    xValue += 1;
                } else {
                    xValue += Integer.parseInt(s);
                }
            }
            else {
                nValue += Integer.parseInt(s);
            }
        }

        String xStr;
        String nStr;

        if(xValue == 0) {
            xStr = "";
        } else if(xValue == 1) {
            xStr = "x";
        } else {
            xStr = String.valueOf(xValue) + "x";
        }

        nStr = nValue == 0 ? "" : String.valueOf(nValue);

        if (xStr.isEmpty()) {
            answer = nStr;
        } else if(nStr.isEmpty()) {
            answer = xStr;
        } else {
            answer = xStr + " + " + nStr;
        }
        return answer;
    }
}