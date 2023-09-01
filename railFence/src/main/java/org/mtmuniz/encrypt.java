package org.mtmuniz;

import java.util.ArrayList;
import java.util.List;

public class encrypt {
//    public static String returnSpaces(String originalText, List<Integer> positions) {
//        StringBuilder modifiedText = new StringBuilder(originalText);
//
//        for (int i = positions.size() - 1; i >= 0; i--) {
//            modifiedText.replace(positions.get(i), positions.get(i) + 1, " ");
//        }
//        return modifiedText.toString();
//    }
//
//    public static List<Integer> savePositions(String text) {
//        List<Integer> positions = new ArrayList<>();
//
//        for (int i = 0; i < text.length(); i++) {
//            if (text.charAt(i) == ' ') {
//                positions.add(i);
//            }
//        }
//
//        return positions;
//    }

    public static String encrypt(String text) {
        String textRemovedSpaces = text.replaceAll(" ", "");

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (int i = 0; i < textRemovedSpaces.length(); i++) {
            if (i % 2 == 0) {
                str1.append(textRemovedSpaces.charAt(i));
            } else {
                str2.append(textRemovedSpaces.charAt(i));
            }
        }

        return str1 + str2.toString();
    }

}
