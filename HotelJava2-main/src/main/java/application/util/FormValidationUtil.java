package application.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FormValidationUtil {

    private final static Scanner sc = new Scanner(System.in);

    public static int validateInt(String prompt){

        while(true){

            try{

                System.out.println(prompt);
                int value = sc.nextInt();
                sc.nextLine();
                return value;

            }catch (InputMismatchException e){
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                sc.nextLine();
            }
        }

    }


    public static double validateDouble(String prompt){

        while(true){

            try{

                System.out.println(prompt);
                double value = sc.nextDouble();
                sc.nextLine();
                return value;

            }catch (InputMismatchException e){
                System.out.println("Entrada no válida. Por favor, ingrese un número decimal.");
                sc.nextLine();
            }
        }

    }

    public static boolean validateBoolean(String prompt){

        while(true){

            try{

                System.out.println(prompt);
                boolean value = sc.nextBoolean();
                sc.nextLine();
                return value;

            }catch (InputMismatchException e){
                System.out.println("Entrada no válida. Por favor, ingrese un valor lógico.");
                sc.nextLine();
            }
        }

    }


    public static String validateString(String prompt) {

        while (true) {
            System.out.println(prompt);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Entrada no válida. Por favor, intentelo de nuevo.");
        }
    }

}
