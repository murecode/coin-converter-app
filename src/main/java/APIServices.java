import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

class APIServices {

    String apikey = "1af1a90762ad12c51751ec9a";
    String url_service = "https://v6.exchangerate-api.com/v6/";


    // Solicitar rangos de conversion
    ConversionRates conversionRates(String base_code) {

      String url_req = url_service + apikey + "/latest/" + base_code;

      HttpResponse<String> response = null;

      try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_req))
                .build();
        response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // System.out.println(response.body()); OK

      } catch (IOException | InterruptedException e) {
        System.out.println("Ups! algo salio mal" + e);
      }

      // Conversion de JSON a Objeto Java
      Gson gson = new Gson();
      ConversionRates rates = gson.fromJson(response.body(), ConversionRates.class);

      return rates;

    }


    // Solicitud conversion de pares
    PairConversion convertPair(String base_code, String target_code, double amount) throws IOException, InterruptedException {

      String url_req = url_service + apikey + "/pair/" + base_code + "/" + target_code + "/" + amount;

      HttpResponse<String> response = null;

      try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_req))
                .build();
        response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // System.out.println(response.body()); OK

      } catch (IOException | InterruptedException e) {
        System.out.println("Ups! algo salio mal" + e);
      }

      // Conversion de JSON a Objeto Java
      Gson gson = new Gson();
      PairConversion conversion = gson.fromJson(response.body(), PairConversion.class);

      return conversion;
    }



}
