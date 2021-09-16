package e1;

public class StringCount {
    /**
     * Counts the number of words in a given String .
     * Words are groups of characters separated by one or more spaces .
     *
     * @param text String with the words
     * @return Number of words in the String or zero if it is null
     */
    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int nWords = 0;
        char[] chars = text.toCharArray();

        boolean isWord = false;

        for (int i = 0; i < text.length(); i++) {

            // if a word is detected, isWord turns true,
            // and it counts one word.
            if (Character.isLetter(chars[i]) && !isWord) {
                isWord = true;
                nWords++;

                // if a word ends, isWord turns false.
            } else if (!Character.isLetter(chars[i]) && isWord) {
                isWord = false;
            }
        }

        return nWords;
    }

    /**
     * Counts the number of times the given character appears in the String .
     * Accented characters are considered different characters .
     *
     * @param text String with the characters
     * @param c    the character to be found
     * @return Number of times the character appears in the String or zero if null
     */
    public static int countChar(String text, char c) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int nTimes = 0;
        char[] chars = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {

            // if one character is found,
            // it counts one.
            if (chars[i] == c) {
                nTimes++;
            }
        }

        return nTimes;
    }

    /**
     * Counts the number of times the given character appears in the String .
     * The case is ignored so an ’a’ is equal to an ’A ’.
     * Accented characters are considered different characters .
     *
     * @param text String with the characters
     * @param c    the character to be found
     * @return Number of times the character appears in the String or zero if null
     */
    public static int countCharIgnoringCase(String text, char c) { /* ... */ }

    /**
     * Checks if a password is safe according to the following rules :
     * - Has at least 8 characters
     * - Has an uppercase character
     * - Has a lowercase character
     * - Has a digit
     * - Has a special character among these : ’?’, ’@ ’, ’#’, ’$ ’, ’.’ and ’,’
     *
     * @param password The password , we assume it is not null .
     * @return true if the password is safe , false otherwise
     */
    public static boolean isPasswordSafe(String password) { /* ... */ }

}