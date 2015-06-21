package net.ocheyedan;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: blangel
 * Date: 6/21/15
 * Time: 1:17 PM
 */
public class EmojiCreator {

    private static final String DATE_REPLACE = "#DATE#";

    private static final String TIME_REPLACE = "#TIME#";

    private static final String EMOJI_REPLACE = "#EMOJI#";

    private static final String EMOJI_INDENT = "    ";

    private static final String TEMPLATE = "package net.ocheyedan;\n" +
            "\n" +
            "/**\n" +
            " * User: blangel\n" +
            " * Date: " + DATE_REPLACE + "\n" +
            " * Time: "+ TIME_REPLACE + "\n" +
            " */\n" +
            "public enum Emoji {\n" +
            "\n" +
            EMOJI_REPLACE + ";\n" +
            "\n" +
            "    private final String codePoint;\n" +
            "\n" +
            "    private Emoji(String codePoint) {\n" +
            "        this.codePoint = codePoint;\n" +
            "    }\n" +
            "\n" +
            "    public String getCodePoint() {\n" +
            "        return codePoint;\n" +
            "    }\n" +
            "\n" +
            "    @Override public String toString() {\n" +
            "        return codePoint;\n" +
            "    }\n" +
            "}\n";

    public String create(Map<String, String> emojiMapping) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        String date = dateFormat.format(now);
        String time = timeFormat.format(now);
        StringBuilder buffer = new StringBuilder();
        List<String> keys = new ArrayList<>(emojiMapping.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            buffer.append(EMOJI_INDENT);
            buffer.append(key);
            buffer.append("(");
            buffer.append(emojiMapping.get(key));
            buffer.append("),\n");
        }
        buffer.replace(buffer.length() - 2, buffer.length(), "");
        return TEMPLATE.replace(DATE_REPLACE, date).replace(TIME_REPLACE, time).replace(EMOJI_REPLACE, buffer.toString());
    }

}
