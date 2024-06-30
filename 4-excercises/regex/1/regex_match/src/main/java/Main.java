import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {

        String str = "giulio.bla@icloud.com";
        String regex = "^[\\w\\-]+(\\.)?[\\w\\-]+?@[\\w.\\-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.find());

        String url = "https://www.miodominio12-ciao.com";
        String regex1 = "^[a-z]{4,5}:(/){2}(www\\.)?[a-z0-9\\-]+\\.[a-z]{2,6}(/[a-z0-9\\-]+)*$";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(url);
        System.out.println(matcher1.find());

    }

}
