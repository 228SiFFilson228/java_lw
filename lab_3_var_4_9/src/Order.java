import java.util.ArrayList;

public class Order {
  ArrayList<Item> items;
  OrderStatus status;


  public Order(ArrayList<Item> items) {
    this.items = new ArrayList<>(items);
    this.status = OrderStatus.CREATED;
  }

  public void AddToOrder(Item item) {
    if (status == OrderStatus.CREATED) {
      items.add(item);
    }
  }

  public void FixPayment() {
    this.status = OrderStatus.PAYED;
  }

  public void FixFinish() {
    if (status == OrderStatus.PAYED) {
      this.status = OrderStatus.CLOSED;
    }
  }
  
}
