import java.util.Random;

public class randomize {
    public static String randomizeCallNo() {
        Random rand = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char randomChar;
        int lastThreeChar = rand.nextInt(899) + 100;
        String out = "";
        for (int i = 0; i < 2; i++) {
            int index = rand.nextInt(alphabet.length());
            randomChar = alphabet.charAt(index);
            out = out + randomChar;
        }
        String threeChars = Integer.toString(lastThreeChar);
        out = out + threeChars;
        return out;
    }
}

