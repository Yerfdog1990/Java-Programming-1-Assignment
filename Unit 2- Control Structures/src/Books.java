public class Books {
  private String title;
  private String author;
  private int quantity;

  public Books(String title, String author, int quantity) {
    this.title = title;
    this.author = author;
    this.quantity = quantity;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getQuantity() {
    return quantity;
  }

  public String setTitle(String title) {
    return this.title = title;
  }

  public String setAuthor(String author) {
    return this.author = author;
  }

  public int setQuantity(int quantity) {
    return this.quantity = quantity;
  }
}
