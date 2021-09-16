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
}