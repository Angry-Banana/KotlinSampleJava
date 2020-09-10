package javaSample;

public class StringUtil {

    public static int lettersCount(String str) {
        int count = 0;
        for (Character character : str.toCharArray()) {
            if (Character.isLetter(character)) {
                count++;
            }
        }
        return count;
    }
}
