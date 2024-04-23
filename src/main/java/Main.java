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
//    System.out.println( base_codes );
    String base_code = input.nextLine();
    System.out.println("Convertir a: ");
//    System.out.println( base_codes );
    String target_code = input.nextLine();
    System.out.println("ingrese amount: ");
    double amount = input.nextDouble();

    PairConversionReq solicitar = new PairConversionReq();
    PairConversionDto respuesta = solicitar.convertPair(base_code, target_code, amount);

    double conver_result = respuesta.conversion_result();
    double input_amount = Math.floor(amount);

    String showConversion = String.format(
            "%.2f | %s | %s | %.2f ", input_amount, base_code, target_code, conver_result );
    System.out.println(showConversion);


  }
}
