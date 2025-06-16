package ru.academits.gerasimenko.springbootphonebook.data;

import org.apache.commons.text.StringEscapeUtils;

public class TextUtilities {
    private TextUtilities() {
    }

    public static boolean isIncorrectField(String text) {
        return text == null || text.trim().isEmpty();
    }

    public static String getProcessedText(String text) {
        return text == null ? "" : StringEscapeUtils.escapeHtml4(text).trim();
    }
}