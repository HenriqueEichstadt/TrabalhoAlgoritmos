package src;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeitorDeHtml {

    private Path path;
    private String htmlContent;

    public LeitorDeHtml() {
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        if (path != null) {
            this.path = path;
        } else {
            throw new IllegalArgumentException("Diretório inválido");
        }
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        if (!htmlContent.isEmpty()) {
            this.htmlContent = htmlContent;
        } else {
            throw new IllegalArgumentException("Conteúdo do html inválido");
        }
    }

    private String getHtmlString() {
        return "";
    }

    public String obterhtml() {
        try {
            if (Files.exists(this.path)) {
                FileReader fr;

                fr = new FileReader(this.path.toFile());

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
        return this.getHtmlString();
    }
    
    public boolean diretorioExiste(){
        return Files.exists(this.path);
    }
}
