package trabalho1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String regex = "(?<=<\\/?)([^ >/]+)";

        String html
            = "<html>\n"
            + "<body>"
            + "<h1>Título</h1>\n"
            + "<p sd=\"asdsad\">\n"
            + "<input type=\"submit\">\n"
            + "<footer>dasdasdsadas</footer>\n"
            + "</body>\n"
            + "</html>\n";

    Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    Matcher matcher = pattern.matcher(html);
       

    while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}
