package src;

import util.ListaDuplamenteEncadeada.ListaDuplamenteEncadeada;

public class ValidadorDeHtml {
    private String htmlText;
    private ListaDuplamenteEncadeada<HtmlTag> tags;

    public ValidadorDeHtml() {
        tags = new ListaDuplamenteEncadeada<>();
    }
    
    
    
    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText;
    }
}
