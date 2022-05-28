public abstract class Cupboard implements Furniture {

  int shelves;
  
  @Override
  public void Stash(String something) {
    System.out.println("Stashed " + something);
  }

}
