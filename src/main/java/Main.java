import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException, InterruptedException {

    APIServices apiServices = new APIServices();

    String conversion_codes = """
            ================================
            💱 ¿Qué conversion deseas realizar?
            1. USD --> COP
            2. COP --> USD
            3. BRL --> USD
            4. USD --> BRL
            5. COP --> BRL
            6. Salir
            ================================
            """;

    Scanner input = new Scanner(System.in);

    while (true) {

      System.out.println(conversion_codes + "");
      int selected = input.nextInt();

      // Se verifica si el usuario desea salir
      if (selected == 6) {
        System.out.println("Gracias. att: Adalberto");
        break; // Salir del bucle while
      }

      if ( selected == 1 ) {

        System.out.println("💰 Cantidad que desea convertir: ");
        double amount = input.nextDouble();

        PairConversion respuesta = apiServices.convertPair("USD", "COP", amount);
        apiServices.showConversion(respuesta, amount);

      } else if ( selected == 2 ) {

        System.out.println("💰 Cantidad que desea convertir: ");
        double amount = input.nextDouble();

        PairConversion respuesta = apiServices.convertPair("COP", "USD", amount);
        apiServices.showConversion(respuesta, amount);

      } else if ( selected ==  3) {

        System.out.println("💰 Cantidad que desea convertir: ");
        double amount = input.nextDouble();

        PairConversion respuesta = apiServices.convertPair("BRL", "USD", amount);
        apiServices.showConversion(respuesta, amount);

      } else if ( selected == 4 ) {

        System.out.println("💰 Cantidad que desea convertir: ");
        double amount = input.nextDouble();

        PairConversion respuesta = apiServices.convertPair("USD", "BRL", amount);
        apiServices.showConversion(respuesta, amount);

      } else if ( selected == 5 ) {

        System.out.println("💰 Cantidad que desea convertir: ");
        double amount = input.nextDouble();

        PairConversion respuesta = apiServices.convertPair("COP", "BRL", amount);
        apiServices.showConversion(respuesta, amount);

      } else {
        if (selected > 6) {
          System.out.println("🔴 Opción no soportada");
        }
      }


    }


//    ConversionRates rates = apiServices.conversionRates(base_code);
//    System.out.println( rates );


  }

}
