import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    HashMap<String, Books> library = new HashMap<>();
    LibraryApp libraryApp = new LibraryApp();
    try (Scanner userInput = new Scanner(System.in)) {
      while (true) {
        // Library menu
        System.out.println("Welcome to the Library System!");
        System.out.println("1. Add books to the library");
        System.out.println("2. Borrow a book");
        System.out.println("3. Return a book");
        System.out.println("4. Display all books");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = userInput.nextInt();
        userInput.nextLine();

        // Use switch to implement user's choice
        switch (choice) {
          case 1:
            libraryApp.addBook(userInput, library);
            break;
          case 2:
            libraryApp.borrowBook(userInput, library);
            break;
          case 3:
            libraryApp.returnBook(userInput, library);
            break;
          case 4:
            libraryApp.displayBooks(library);
            break;
          case 5:
            System.out.println("Exiting the program...");
            return;
          default:
            System.out.println("Invalid choice. Please enter a valid choice.");
        }
      }
    }
  }
}
