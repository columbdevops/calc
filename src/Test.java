import java.security.MessageDigest;
    public class Test {
        public static void main(String[] args) throws Exception {
            String input_string = "Madam, I'm Adam!";
            String regex_pattern = "[^a-zA-Z0-9]";
            String withoutsymbol = input_string.replaceAll(regex_pattern, "");
        }
    }