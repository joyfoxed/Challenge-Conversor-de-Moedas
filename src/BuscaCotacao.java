import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCotacao {

    public Moeda buscaCotacao(String moeda1, String moeda2){
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/71c698c69125931da84c7bab/pair/" + moeda1 + "/" + moeda2);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moeda.class);
        } catch (Exception e) {
            throw new RuntimeException("ERRO BuscaCotacao");
        }
    }
}
