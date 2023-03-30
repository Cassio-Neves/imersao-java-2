import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoIMDB implements ExtratorConteudo{
    
    public List<Conteudo> extraiConteudos(String json){

        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImage = atributos.get("image");

            var conteudo = new Conteudo(titulo, urlImage);

            conteudos.add(conteudo); 
         }

        return conteudos;

    }
    
}
