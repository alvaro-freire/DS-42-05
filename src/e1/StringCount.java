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

        boolean isWord = false;
        int endOfSentence = text.length() - 1;
        char[] characters = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {

            // if the char is a letter, isWord = true.
            if (Character.isLetter(characters[i]) && i != endOfSentence) {
                isWord = true;

                // if char isn't a letter and there have been letters before,
                // counter goes up.
            } else if (!Character.isLetter(characters[i]) && isWord) {
                nWords++;
                isWord = false;

                // the end of the text counter goes up
            } else if (Character.isLetter(characters[i]) && i == endOfSentence) {
                nWords++;
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
        return 0;
    }
}