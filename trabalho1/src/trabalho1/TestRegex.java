package trabalho1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

    final static String regex = "(?<=<\\/?)([^ >/]+)";

    final static String string = 
            "<html>\n"
            + "<body>"
            + "<h1>Título</h1></body>\n"
            + "<p sd=\"asdsad\">\n"
            + "<input type=\"submit\">\n"
            + "<footer>dasdasdsadas</footer>\n"
            + "</body>\n"
            + "</html>\n";

    

    public static void main(String[] args) {

    Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    Matcher matcher = pattern.matcher(string);
        
        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}


/*
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
*/


