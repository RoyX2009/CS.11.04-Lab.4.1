public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int num) {
        String str = String.valueOf(num);
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    // 3. encryptThis
    public static String encryptThis(String str) {
        String encrypted = "";

        while (str.length() > 0) {
            int spaceIndex = str.indexOf(" ");
            String word;

            if (spaceIndex == -1) {
                word = str;
                str = "";
            } else {
                word = str.substring(0, spaceIndex);
                str = str.substring(spaceIndex + 1);
            }

            if (word.length() > 2) {
                char first = word.charAt(0);
                char second = word.charAt(1);
                char last = word.charAt(word.length() - 1);

                String rest = word.substring(2, word.length() - 1);

                encrypted += (int) first + "" + last + rest + second;
            } else if (word.length() > 1) {
                char first = word.charAt(0);
                char last = word.charAt(word.length() - 1);

                encrypted += (int) first + "" + last;
            } else {
                char first = word.charAt(0);

                encrypted += (int) first;
            }

            if (str.length() > 0) {
                encrypted += " ";
            }
        }

        return encrypted;
    }

    // 4. decipherThis
    public static String decipherThis(String str) {
        String deciphered = "";

        while (str.length() > 0) {
            int spaceIndex = str.indexOf(" ");
            String word;

            if (spaceIndex == -1) {
                word = str;
                str = "";
            } else {
                word = str.substring(0, spaceIndex);
                str = str.substring(spaceIndex + 1);
            }

            int codeIndex = 0;
            while (codeIndex < word.length() && Character.isDigit(word.charAt(codeIndex))) {
                codeIndex++;
            }

            int code = Integer.parseInt(word.substring(0, codeIndex));
            char first = (char) code;
            String rest = word.substring(codeIndex);

            if (rest.length() > 1) {
                char last = rest.charAt(rest.length() - 1);
                char second = rest.charAt(0);

                deciphered += first + "" + last + rest.substring(1, rest.length() - 1) + second;
            } else if (rest.length() == 1) {
                deciphered += first + "" + rest;
            } else {
                deciphered += first;
            }

            if (str.length() > 0) {
                deciphered += " ";
            }
        }
        return deciphered;
    }
}