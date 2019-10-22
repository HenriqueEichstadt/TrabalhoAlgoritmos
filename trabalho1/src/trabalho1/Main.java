package trabalho1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String pattern1 = "<(\\\"[^\\\"]*\\\"|'[^']*'|[^'\\\">])*>";
        String pattern2 = "<((?=!\\-\\-)!\\-\\-[\\s\\S]*\\-\\-|((?=\\?)\\?[\\s\\S]*\\?|((?=\\/)\\/[^.\\-\\d][^\\/\\]'\"[!#$%&()*+,;<=>?@^`{|}~ ]*|[^.\\-\\d][^\\/\\]'\"[!#$%&()*+,;<=>?@^`{|}~ ]*(?:\\s[^.\\-\\d][^\\/\\]'\"[!#$%&()*+,;<=>?@^`{|}~ ]*(?:=(?:\"[^\"]*\"|'[^']*'|[^'\"<\\s]*))?)*)\\s?\\/?))>";
        
        String html = "<html><head>sdasd</head>\\<body><h1>Titulo</h1></body><footer>adasd</footer></html>";

        String[] vetor = html.split(pattern2);
        System.out.println("0: " + vetor[0]);
    }
}
