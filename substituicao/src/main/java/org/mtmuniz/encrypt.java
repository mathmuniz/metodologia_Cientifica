package org.mtmuniz;

import java.util.regex.Pattern;

public class encrypt {

    public static void encrypt(String originalText, String keyOne, String keyTwo, StringBuilder text) {
        Pattern regexPattern = Pattern.compile("\\W|_");

        for (int i = 0; i < originalText.length(); i++) {
            char caractere = originalText.charAt(i);

            if (keyOne.indexOf(caractere) != -1) {
                int index = keyOne.indexOf(caractere);
                text.append(keyTwo.charAt(index));
            } else if (caractere == '-') {
                text.append('-');
            } else if (caractere == ' ') {
                text.append(' ');
            } else if (regexPattern.matcher(Character.toString(caractere)).matches()) {
                text.append(caractere);
            } else if (keyTwo.indexOf(caractere) != -1) {
                int index = keyTwo.indexOf(caractere);
                text.append(keyOne.charAt(index));
            }
        }
    }
}
