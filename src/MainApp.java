import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {

    public static void main(String[] args) {

        int [] arr = {1,2,4,75,32,12};
        MainApp mainApp = new MainApp();


    }

    private int getInputData() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("I/O Error");
        } catch (NumberFormatException e) {
            System.out.println("You input not number");
        }
        return -1;
    }
}
