import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String body = response.body();

        JsonParser parser = new JsonParser();
        List<Map<String, String>> filmes = parser.parse(body);

        for (Map<String,String> films : filmes) {
            System.out.printf("\u001b[1m Movie: %s", films.get("title"));
            System.out.println();
            System.out.printf("\u001b[1m Postêr: %s", films.get("image"));
            System.out.println();
            System.out.printf("\u001b[37m \u001b[45m Classificação: %s\u001b[m", films.get("imDbRating"));
            System.out.println();
            double classificação = Double.parseDouble(films.get("imDbRating"));
            int estrela = (int) classificação;

            for (int i = 1; i <= estrela; i++) {
                System.out.print("\u2B50");
            }

            System.out.println();

            
            System.out.println();
        }
    }
}
