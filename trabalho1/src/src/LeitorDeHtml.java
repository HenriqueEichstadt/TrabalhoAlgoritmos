package src;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeitorDeHtml {

    private static LeitorDeHtml leitorDeHtml;
    private Path path;
    private String htmlContent;
    private FileSystem fileSystem;

    private LeitorDeHtml() {
        fileSystem = FileSystems.getDefault();
    }

    public static LeitorDeHtml createInstance(){
        if(leitorDeHtml == null)
            leitorDeHtml = new LeitorDeHtml();     
        return leitorDeHtml;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(String path) {
        if (path != null) {
            this.path = fileSystem.getPath(path);
        } else {
            throw new IllegalArgumentException("Diretório inválido");
        }
    }

    public String getHtmlContent() {
        obterHtml();
        return this.htmlContent;
    }

    private void setHtmlContent(String htmlContent) {
        if (!htmlContent.isEmpty()) {
            this.htmlContent = htmlContent;
        } else {
            throw new IllegalArgumentException("Conteúdo do html inválido");
        }
    }

    private void obterHtml(){
        try {
            if (diretorioExiste()) {
                FileReader fr = new FileReader(this.path.toFile());
                BufferedReader br = new BufferedReader(fr);
                String content = "";
                while (br.ready()) {
                    content += br.readLine() + "\n";
                }
                this.setHtmlContent(content);
            }
        } catch (FileNotFoundException ex) {
            //TODO tratar a exceção 
        } catch (IOException exc){
            //TODO tratar a exceção
        }
    }
    
    public boolean diretorioExiste(){
        return Files.exists(this.path);
    }
}
