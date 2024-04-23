import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException, InterruptedException {

    Scanner input = new Scanner(System.in);

    String conversion_options = """
            1. Dolar
            2. Peso Argentino
            3. Peso Colombiano
            9. Peso Mexicano
            """;

    System.out.println("Convertir de: ");
    String base_code = input.nextLine();
//    System.out.println("Convertir a: ");
//    String target_code = input.nextLine();
//    System.out.println("ingrese amount: ");
//    double amount = input.nextDouble();

    APIServices apiServices = new APIServices();

//    PairConversion respuesta = apiServices.convertPair(base_code, target_code, amount);
//    double conver_result = respuesta.conversion_result();
//    String showConversion = String.format(
//            "%.1f %s => %.1f %s ", amount, base_code, conver_result, target_code  );
//    System.out.println(showConversion);

    ConversionRates rates = apiServices.conversionRates(base_code);

    System.out.println( rates );



  }
}
