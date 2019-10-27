package src;
import util.ListaEstatica.ListaEstatica;

public class HtmlTag {

    private String nome;
    private char tipo;
    private boolean tagSingleton;
    private final ListaEstatica<String> tagsSingletons;

    public HtmlTag(String nome, char tipo) {
        this.tagsSingletons = new ListaEstatica<String>();
        this.setNome(nome);
        this.setTipo(tipo);
        this.inserirTagsSingletons();
        this.setTagSingleton();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("O nome da tag é inválido");
        }
    }

    public char getTipo() {
        return tipo;
    }

    /**
     * 'I' - Tag de início 'F' - Tag de fim
     *
     * @param tipo
     */
    public void setTipo(char tipo) {
        if (tipo == 'I' || tipo == 'F') {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("Tipo inválido");
        }
    }

    public boolean isTagSingleton() {
        return tagSingleton;
    }

    private void setTagSingleton() {
        int valor = this.tagsSingletons.buscar(this.getNome());
        if(valor != -1)
            tagSingleton = true;
        else
            tagSingleton = false;
    }

    private void inserirTagsSingletons() {
        tagsSingletons.inserir("meta");
        tagsSingletons.inserir("base");
        tagsSingletons.inserir("br");
        tagsSingletons.inserir("col");
        tagsSingletons.inserir("command");
        tagsSingletons.inserir("embed");
        tagsSingletons.inserir("hr");
        tagsSingletons.inserir("img");
        tagsSingletons.inserir("input");
        tagsSingletons.inserir("link");
        tagsSingletons.inserir("param");
        tagsSingletons.inserir("source");
        tagsSingletons.inserir("!DOCTYPE");
    }
}
