package src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.ListaEstatica.ListaEstatica;

public class ExtratorDeTags {

    private String html;
    private final String REGEX_HTML_TAG = "<\\/?\\w+((\\s+\\w+(\\s*=\\s*(?:\"(.|\\n)*?\"|'(.|\\n)*?'|[^'\">\\s]+))?)+\\s*|\\s*)\\/?>";
    private ListaEstatica<HtmlTag> listaEstatica;
    private LeitorDeHtml leitorDeHtml;

    public String getHtml() {
        return html;
    }

    public ExtratorDeTags() {
        listaEstatica = new ListaEstatica<>();
        leitorDeHtml = LeitorDeHtml.createInstance();
    }

    public void setHtml(String html) {
        if (!html.isEmpty())
            this.html = html;
        else
            throw new IllegalArgumentException("html inválido");
    }

    public void extrair() {
        this.setHtml(leitorDeHtml.getHtmlContent());
        try {
            Pattern pattern = Pattern.compile(REGEX_HTML_TAG,
                    Pattern.MULTILINE
                    | Pattern.CASE_INSENSITIVE
                    | Pattern.UNICODE_CASE);

            Matcher matcher = pattern.matcher(html);
            while (matcher.find()) {
                String tag = matcher.group(0);
                if (ehTagFim(tag)) {
                    tag = manterApenasNome(tag);
                    HtmlTag novaTag = new HtmlTag(tag, 'F');
                    this.listaEstatica.inserir(novaTag);
                } else {
                    tag = manterApenasNome(tag);
                    HtmlTag novaTag = new HtmlTag(tag, 'I');
                    this.listaEstatica.inserir(novaTag);
                }
            }
        } catch (Exception ex) {
            // Tratar a exceção
        }
    }

    public HtmlTag buscarNoIndice(int indice) {
        return this.listaEstatica.obterElemento(indice);
    }

    public int countTags() {
        return this.listaEstatica.getTamanho();
    }

    private boolean ehTagFim(String tag) {
        return tag.contains("</");
    }

    private String removerAtributos(String tag) {
        int indiceDoEspacoEmBranco = tag.indexOf(" ");
        if (indiceDoEspacoEmBranco != -1) {
            String temp = "";
            for (int i = 0; i < indiceDoEspacoEmBranco; i++) {
                temp += tag.charAt(i);
            }
            return temp;
        }
        return tag;
    }

    private String manterApenasNome(String tag) {
        String temp = tag.replace("<", "");
        temp = temp.replace(">", "");
        temp = temp.replace("/", "");
        temp = removerAtributos(temp);
        return temp;
    }
}
