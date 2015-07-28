package net.ocheyedan;

/**
 * User: blangel
 * Date: 7/28/15
 * Time: 11:20 AM
 */
public class EmojiPrinter {

    public static void main(String[] args) {
        for (Emoji emoji : Emoji.values()) {
            System.out.printf("%s - %s%n", emoji.name(), emoji);
        }
    }

}
