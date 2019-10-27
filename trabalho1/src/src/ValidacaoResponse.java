package src;

import util.ListaEncadeada.ListaEncadeada;
import util.ListaEstatica.ListaEstatica;


public class ValidacaoResponse {
    private String mensagem;
    private ListaEstatica<TagOcorrencia> ocorrencias;
    private boolean arquivoBemFormatado;

    public ValidacaoResponse(String mensagem, boolean arquivoBemFormatado) {
        this.setMensagem(mensagem);
        this.ocorrencias = new ListaEstatica<TagOcorrencia>();
        this.setArquivoBemFormatado(arquivoBemFormatado);
    }

     public ValidacaoResponse() {
        this.ocorrencias = new ListaEstatica<TagOcorrencia>();
     }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        if(!mensagem.isEmpty())
            this.mensagem = mensagem;
        else
            throw new IllegalArgumentException("Mensagem inválida");
    }

    public boolean isArquivoBemFormatado() {
        return arquivoBemFormatado;
    }

    public void setArquivoBemFormatado(boolean arquivoBemFormatado) {
        this.arquivoBemFormatado = arquivoBemFormatado;
    }

    public ListaEstatica<TagOcorrencia> getOcorrencias() {
        return ocorrencias;
    }
    
    public void addOcorrencia(String nome){      
        for(int i = 0; i < ocorrencias.getTamanho(); i++){
            TagOcorrencia tag = ocorrencias.obterElemento(i);
            if(nome.equals(tag.getNome())){
                tag.incrementarOcorrencias();
                return;
            }
        }
        TagOcorrencia novaTag = new TagOcorrencia(nome);
        ocorrencias.inserir(novaTag);
    }
}
