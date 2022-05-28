public class Bookshelf extends Cupboard {
  
  public Bookshelf(int shelves) {
    this.shelves = shelves;
  }

  @Override
  public int getAmount() {
    return shelves;
  }

}
