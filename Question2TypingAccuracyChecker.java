public class Question2TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int totalCompared = Math.min(original.length(), typed.length());
        int matchedCharacters = 0;
        int firstMismatch = -1;

        for (int i = 0; i < totalCompared; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        if (original.length() != typed.length() && firstMismatch == -1) {
            firstMismatch = totalCompared;
        }

        double accuracy = original.length() == 0
                ? 100.0
                : matchedCharacters * 100.0 / original.length();

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                matchedCharacters, original.length(), accuracy);

        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } else if (firstMismatch < original.length() && firstMismatch < typed.length()) {
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')%n",
                    firstMismatch + 1,
                    original.charAt(firstMismatch),
                    typed.charAt(firstMismatch));
        } else if (firstMismatch < original.length()) {
            System.out.printf(" | First Mismatch at position %d (original has '%c', typed text ended)%n",
                    firstMismatch + 1,
                    original.charAt(firstMismatch));
        } else {
            System.out.printf(" | First Mismatch at position %d (typed text has an extra character)%n",
                    firstMismatch + 1);
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
    }
}
