package src;

import util.Pilhas.PilhaLista;


public class ValidadorDeHtml {
    
    private ExtratorDeTags extratorDeTags;
    private PilhaLista<HtmlTag> pilhaDeTags;
    
    public ValidadorDeHtml() {
        extratorDeTags = new ExtratorDeTags();
        pilhaDeTags = new PilhaLista<>();
    }
    
    public String executar(){
        inicializar();
        return validar();
    }
    
    private void inicializar(){
        extratorDeTags.extrair();
    }
    
    public String validar(){
        for(int i = 0; i < extratorDeTags.countTags(); i++){
            HtmlTag tag = extratorDeTags.buscarNoIndice(i);
            if(tag.getTipo() == 'I' && !tag.isTagSingleton()){
                pilhaDeTags.push(tag);
            }
            else if(tag.getTipo() == 'F' && !tag.isTagSingleton()){
                boolean ehPar = this.ehParDeTags(pilhaDeTags.peek(), tag);
                if(ehPar){
                    pilhaDeTags.pop();
                }
                else{
                    return "Arquivo mal formatado!\nA tag " + tag.getNome() + " não possui tag de fim";
                }
            }
        }
        return "O arquivo está bem formatado";
    }
    
    private boolean ehParDeTags(HtmlTag inicio, HtmlTag fim){
        boolean result = inicio.getTipo() == 'I' && fim.getTipo() == 'F';
        result = result && inicio.getNome().equals(fim.getNome());
        result = result && !inicio.isTagSingleton() && !fim.isTagSingleton();
        return result;
    }
}