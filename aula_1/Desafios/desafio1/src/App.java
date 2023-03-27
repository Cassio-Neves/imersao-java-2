import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Consumindo a API  
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        //System.out.println(body);

        // Pegando os dados interessantes
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeSeriesPopulares = parser.parse(body);

        // Exibir os dados
        for (Map<String,String> seriesPopulares : listaDeSeriesPopulares) {
            
            System.out.printf("TV Series: %s", seriesPopulares.get("fullTitle"));
            System.out.println();
            System.out.printf("Rating: %s" , seriesPopulares.get("imDbRating"));
            System.out.println();
            System.out.printf("Poster: %s", seriesPopulares.get("image"));
            System.out.println();
            System.out.println();
        }

    }
}
