import java.util.*;
import methods.ResMeth;
public class Calcstr {
    public static void main(String[] args) {
        while(true) {
            // Считаем строку из консоли
            Scanner scanner = new Scanner(System.in);
            String stringInput = scanner.nextLine();
            ResMeth resMeth = new ResMeth();
            System.out.println("\"" + resMeth.resultMeth(stringInput) + "\"");
        }
    }
}




