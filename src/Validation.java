import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean ValidateEmail (String mail) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (mail == null)
            return false;
        return pat.matcher(mail).matches();
    }

    public static boolean ValidateNumber (String number) {

        // considering the library will be based in the Indian branches only, this block will validate Indian numbers.
        Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
        Matcher m = p.matcher(number);
        return (m.find() && m.group().equals(number));
    }
}
