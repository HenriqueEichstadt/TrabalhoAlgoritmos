package src;

import util.Pilhas.PilhaLista;


public class ValidadorDeHtml {
    
    private ExtratorDeTags extratorDeTags;
    private PilhaLista<HtmlTag> pilhaDeTags;
    
    public ValidadorDeHtml() {
        extratorDeTags = new ExtratorDeTags();
        pilhaDeTags = new PilhaLista<>();
    }
    
    public ValidacaoResponse executar(){
        inicializar();
        return validar();
    }
    
    private void inicializar(){
        extratorDeTags.extrair();
    }
    
    private ValidacaoResponse validar(){
        ValidacaoResponse validacao = new ValidacaoResponse();
        
        if(extratorDeTags.countTags() < 1){
            return new ValidacaoResponse("O documento html está vazio", false);
        }
        
        for(int i = 0; i < extratorDeTags.countTags(); i++){
            HtmlTag tag = extratorDeTags.buscarNoIndice(i);
            if(tag.isTagSingleton()){
                validacao.addOcorrencia(tag.getNome());
            }
            if(tag.getTipo() == 'I' && !tag.isTagSingleton()){
                pilhaDeTags.push(tag);
                validacao.addOcorrencia(tag.getNome());
            }
            else if(tag.getTipo() == 'F' && !tag.isTagSingleton()){
                HtmlTag tagInicio = pilhaDeTags.peek();
                boolean ehPar = this.ehParDeTags(tagInicio, tag);
                boolean ehtagFinalInesperada = this.possuiTagFinalInesperada(tagInicio, tag);
                if(ehPar){
                    pilhaDeTags.pop();
                }
                else if(ehtagFinalInesperada){
                    String str = "Foi encontrada uma tag final inesperada, "
                             + "aguardava-se a tag " + tagInicio.getNome() + ", mas foi encontrada a tag " + tag.getNome(); 
                    return new ValidacaoResponse(str, false);
                    
                }
                else{
                    String str = "Arquivo mal formatado!\nA tag " + tag.getNome() + " não possui tag de fim";
                    return new ValidacaoResponse(str, false);
                }
            }
        }
        if(!pilhaDeTags.estaVazia()){
            return new ValidacaoResponse(this.getTagsFinaisFaltando(), false);
        }
        validacao.setMensagem("O arquivo está bem formatado");
        validacao.setArquivoBemFormatado(true);
        return validacao;
    }
    
    private boolean ehParDeTags(HtmlTag inicio, HtmlTag fim){
        boolean result = inicio.getTipo() == 'I' && fim.getTipo() == 'F';
        result = result && inicio.getNome().equals(fim.getNome());
        result = result && !inicio.isTagSingleton() && !fim.isTagSingleton();
        return result;
    }
    
    private boolean possuiTagFinalInesperada(HtmlTag inicio, HtmlTag fim){
        boolean result = inicio.getTipo() == 'I' && fim.getTipo() == 'F';
        result = result && !inicio.getNome().equals(fim.getNome());
        result = result && !inicio.isTagSingleton() && !fim.isTagSingleton();
        return result;
    }
    
    private String getTagsFinaisFaltando(){
        String mensagem = "Arquivo mal formatado!\n";
        
        if(!pilhaDeTags.estaVazia()){
            while(!pilhaDeTags.estaVazia()){
                HtmlTag tagSobrando = pilhaDeTags.pop();
                mensagem += "- A tag " + tagSobrando.getNome() + " não possui tag de fim.\n";
            }
        }
        return mensagem;
    }
}