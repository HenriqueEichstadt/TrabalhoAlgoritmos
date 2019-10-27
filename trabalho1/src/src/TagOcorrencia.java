package src;

public class TagOcorrencia {
    private String nome;
    private int numeroOcorrencias;

    public TagOcorrencia(String nome) {
        this.setNome(nome);
        this.setNumeroOcorrencias(1);
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        if(!nome.isEmpty())
            this.nome = nome;
        else
            throw new IllegalArgumentException("Nome inválido");
    }

    public int getNumeroOcorrencias() {
        return numeroOcorrencias;
    }

    private void setNumeroOcorrencias(int numeroOcorrencias) {
        if(numeroOcorrencias > 0)
            this.numeroOcorrencias = numeroOcorrencias;
        else
            throw new IllegalArgumentException("Numero de ocorrências inválido");
    }
    
    public void incrementarOcorrencias(){
        this.numeroOcorrencias++;
    }
}
