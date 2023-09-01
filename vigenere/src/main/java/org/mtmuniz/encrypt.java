package org.mtmuniz;

public class encrypt {
    public static String encrypt(String text, String key) {
        StringBuilder encryptedText = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                encryptedText.append(' ');
                continue;
            }

            int textCharCode = (int) text.charAt(i);
            int keyCharCode = (int) key.charAt(keyIndex);
            int encryptedCharCode = (textCharCode + keyCharCode) % 26 + 65;

            if (encryptedCharCode < 65 || encryptedCharCode > 90) {
                encryptedText.append(text.charAt(i));
            } else {
                encryptedText.append((char) encryptedCharCode);
            }

            keyIndex = (keyIndex + 1) % key.length();
        }

        return encryptedText.toString();
    }

}
