import java.util.HashMap;
import java.util.Scanner;

public class LibraryApp implements LibrarySystem {

  @Override
  public void addBook(Scanner userInput, HashMap<String, Books> library) {
    // Book details
    System.out.print("Enter the title of the book: ");
    String title = userInput.nextLine();
    System.out.print("\nEnter the author of the book: ");
    String author = userInput.nextLine();
    System.out.print("\nEnter number of books: ");
    int numToAdd = userInput.nextInt();

    // Logic to add books
    if (library.containsKey(title)) {
      Books existingBook = library.get(title);
      existingBook.setQuantity(existingBook.getQuantity() + numToAdd);
      System.out.println("Book quantity for " + title + " updated successfully!");
    } else {
      Books newBook = new Books(title, author, numToAdd);
      library.put(title, newBook);
      System.out.println("New book " + title + " added successfully!");
    }
  }

  @Override
  public void borrowBook(Scanner userInput, HashMap<String, Books> library) {
    // Book details
    System.out.print("Enter the title of the book: ");
    String title = userInput.nextLine();
    System.out.print("\nEnter the author of the book: ");
    System.out.print("\nEnter number of books: ");
    int numToBorrow = userInput.nextInt();

    // Logic to borrow books
    if (library.containsKey(title)) {
      Books existingBook = library.get(title);
      while (numToBorrow > existingBook.getQuantity() || numToBorrow <= 0) { // Ensure valid input
        System.out.println("Sorry. Insufficient books for " + title + " available to borrow!");
        System.out.println("Available books: " + existingBook.getQuantity() + " copies.");
        System.out.print(
            "Please try again by entering a valid number of books to borrow (or 0 to cancel): ");
        numToBorrow = userInput.nextInt();
        userInput.nextLine(); // Consume the newline left by nextInt

        if (numToBorrow == 0) {
          System.out.println("Borrowing operation cancelled.");
          return; // Exit method if the user cancels
        }
      }
      existingBook.setQuantity(existingBook.getQuantity() - numToBorrow);
      System.out.println("Book titled " + title + " borrowed successfully!");
    } else {
      System.out.println("Sorry. No book titled " + title + " available!");
    }
  }

  @Override
  public void returnBook(Scanner userInput, HashMap<String, Books> library) {
    // Book details
    System.out.print("Enter the title of the book: ");
    String title = userInput.nextLine();
    System.out.print("\nEnter the author of the book: ");
    System.out.print("\nEnter number of books: ");
    int numToReturn = userInput.nextInt();

    // Logic to return books
    if (library.containsKey(title)) {
      Books existingBook = library.get(title);
      existingBook.setQuantity(existingBook.getQuantity() + numToReturn);
      System.out.println("Book titled " + title + " returned successfully!");
    } else {
      System.out.println("Sorry. No book titled " + title + " available!");
    }
  }

  @Override
  public void displayBooks(HashMap<String, Books> library) {
    System.out.println("Title\tAuthor\tQuantity");
    for (String key : library.keySet()) {
      Books book = library.get(key);
      System.out.println(book.getTitle() + "\t" + book.getAuthor() + "\t" + book.getQuantity());
    }
  }
}
