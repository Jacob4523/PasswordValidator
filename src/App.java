import java.util.Scanner;

public class App {
   public static void main(String[] args) {
    System.out.println("Welcome to the Password Validator!");
    System.out.println("Type in a password that meets the following requirements:");
    System.out.println("- Password length is between 8 and 16 characters (inclusive).");
    System.out.println("- Password meets at least 3 of the 4 following requirements:");
    System.out.println("    - has at least 1 lower case letter, i.e., a-z");
    System.out.println("    - has at least 1 upper case letter, i.e., A-Z");
    System.out.println("    - has at least 1 number, i.e., 0-9");
    System.out.println("    - has at least 1 special symbol from the following: ~!@#$%^&*()_-+=");

    Scanner scanner = new Scanner(System.in);

    System.out.println("\nEnter a password:");
    String password = scanner.nextLine();

    if(isValidPassword(password)) {
        System.out.println("Your password is strong.");
    } else {
        System.out.println("Your password is weak, try meeting more of the requirements.");
    }

    scanner.close();
   }

   public static boolean isValidPassword(String password) {
        int requirementsMet = 0;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        if (password.length() >= 8) {
            if (password.length() <= 16) {
                for (char c : password.toCharArray()) {
                    if (Character.isUpperCase(c)) {
                        hasUpperCase = true;
                    } else if (Character.isLowerCase(c)) {
                        hasLowerCase = true;
                    } else if (Character.isDigit(c)) {
                        hasDigit = true;
                    } else if (isSpecialChar(c)) {
                        hasSpecialChar = true;
                    }
                }
            } else {
            }
        } else {
        }

        if (hasUpperCase) {
            requirementsMet++;
        }

        if (hasLowerCase) {
            requirementsMet++;
        }

        if (hasDigit) {
            requirementsMet++;
        }

        if (hasSpecialChar) {
            requirementsMet++;
        }

        return requirementsMet >= 3;
    }

    private static boolean isSpecialChar(char c) {
        String specialChars = "~!@#$%^&*()-_+=";
        return specialChars.contains(Character.toString(c));
    }
    
}
