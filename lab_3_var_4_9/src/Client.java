import java.util.ArrayList;

public class Client {
  String name;
  ArrayList<Order> orders = new ArrayList<>();
  boolean isBlacklisted;


  public Client(String name) {
    this.name = name;
    this.isBlacklisted = false;
  }

  public void AddToOrder(int id, Item item) {
    orders.get(id).AddToOrder(item);
  }

  public void PayOrder(int id) {
    orders.get(id).FixPayment();
  }

  public void MoveToBlacklist() {
    isBlacklisted = true;
  }

}
