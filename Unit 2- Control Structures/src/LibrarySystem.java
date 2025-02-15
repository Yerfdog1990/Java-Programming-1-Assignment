import java.util.HashMap;
import java.util.Scanner;

public interface LibrarySystem {
  public void addBook(Scanner userInput, HashMap<String, Books> library);

  public void borrowBook(Scanner userInput, HashMap<String, Books> library);

  public void returnBook(Scanner userInput, HashMap<String, Books> library);

  public void displayBooks(HashMap<String, Books> library);
}
