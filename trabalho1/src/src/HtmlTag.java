package src;

public class HtmlTag {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(!nome.isEmpty())
            this.nome = nome;
        else
            throw new IllegalArgumentException("O nome da tag é inválido");
    }
}
