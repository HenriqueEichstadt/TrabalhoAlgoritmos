package trabalho1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import src.HtmlTag;
import src.LeitorDeHtml;
import util.ListaEstatica.ListaEstatica;

public class Main {

    public static void main(String[] args) {

        //HtmlTag html = new HtmlTag("input", 'I')
    }
}

/*

LeitorDeHtml leitor = LeitorDeHtml.createInstance();

        leitor.setPath("D:\\Desktop\\htmlDocument.html");
        String html = leitor.getHtmlContent();

        //String regex = "(?<=<\\/?)([^ >/]+)";
        String regex = "<\\/?\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|'.*?'|[\\^'\">\\s]+))?)+\\s*|\\s*)\\/?>";
        String regex2 = "<\\/?\\w+((\\s+\\w+(\\s*=\\s*(?:\"(.|\\n)*?\"|'(.|\\n)*?'|[^'\">\\s]+))?)+\\s*|\\s*)\\/?>";
        
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(html);
        String mensagem = "";
        ListaEstatica<String> lista = new ListaEstatica<>();
        
        while (matcher.find()) {
            mensagem += "Full match: " + matcher.group(0) + "\n";
            lista.inserir(matcher.group(0));
        }
        JOptionPane.showMessageDialog(null, lista.toString());

*/
