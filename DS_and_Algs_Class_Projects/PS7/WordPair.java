
public class WordPair implements Comparable<WordPair> {
    private String word;
    private String sortedLetters;

    public WordPair(String wd) {
        word = wd;
        char[] ca = wd.toCharArray();
        //java.util.Arrays.sort(ca);
        insertionSort(ca);
        sortedLetters = new String(ca);
    }

    public String getWord() {
        return word;
    }

    public String getSorted() {
        return sortedLetters;
    }

    private static void insertionSort(char[] A) {
        for (int i = 1; i < A.length; i++)
            // Insert i'th record
            for (int j = i; (j > 0) && (A[j] < A[j - 1]); j--) {
                char tmp = A[j];
                A[j] = A[j-1];
                A[j-1] = tmp;
            }
    }

    public String getUnsorted() {
        return word;
    }

    public int compareTo(WordPair wp) {
        return sortedLetters.compareTo(wp.sortedLetters);
    }

    public String toString() {
        return word+" "+sortedLetters;
    }
}
