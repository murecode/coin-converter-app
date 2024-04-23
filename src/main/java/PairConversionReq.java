import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson;

class PairConversionReq {
    String apikey = "1af1a90762ad12c51751ec9a";
    String url_service = "https://v6.exchangerate-api.com/v6/";

  // Solicitud a la API
    PairConversionDto convertPair(String base_code, String target_code, double amount) throws IOException, InterruptedException {

      String url_req = url_service + apikey + "/pair/" + base_code + "/" + target_code + "/" + amount;

      HttpResponse<String> response = null;

      try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_req))
                .build();
        response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

//        System.out.println(response.body());

      } catch (IOException e) {
        System.out.println("Ups! algo salio mal" + e);
      }

      // Conversion de JSON a Objeto Java
      Gson gson = new Gson();
      PairConversionDto conversion = gson.fromJson(response.body(), PairConversionDto.class);

      return conversion;
    }

}
