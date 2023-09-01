package org.mtmuniz;

public class encrypt {
    public static String encrypt(String originalText, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < originalText.length(); i++) {
            char letter = originalText.charAt(i);

            if (Character.isLetter(letter)) {
                int code = letter;

                if (code >= 65 && code <= 90) {
                    letter = (char) (((code - 65 + key) % 26) + 65);
                }
            }
            result.append(letter);
        }
        return result.toString();
    }

}
