package application.util;

public class ValidationUtil {


    // Validación de texto

    public static String validateNotEmpty(String value, String fieldName) {
        try {
            if (value == null || value.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "El campo '" + fieldName + "' no puede estar vacío."
                );
            }
            return value.trim();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
            throw e;
        }
    }


    // Validación de formato Email

    public static String validateEmail(String email) {
        try {
            if (email == null || !email.contains("@") || !email.contains(".")) {
                throw new IllegalArgumentException(
                        "El email '" + email + "' no tiene un formato válido."
                );
            }
            return email.trim();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
            throw e;
        }
    }


    // Validación de contraseña

    public static String validatePassword(String password) {
        try {
            if (password == null || password.trim().length() < 6) {
                throw new IllegalArgumentException(
                        "La contraseña debe tener al menos 6 caracteres."
                );
            }
            return password.trim();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
            throw e;
        }
    }
}