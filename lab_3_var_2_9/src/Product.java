public class Product {
  int id;
  String title;
  int UPC;
  String Manufacturer;
  int cost;
  int valid_until;
  int amount;


  public Product(int id, String title, int UPC, String Manufacturer, int cost, int valid_until, int amount) {
    this.id = id;
    this.title = title;
    this.UPC = UPC;
    this.Manufacturer = Manufacturer;
    this.cost = cost;
    this.valid_until = valid_until;
    this.amount = amount;
  }


  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public int getUPC() {
    return UPC;
  }

  public String getManufacturer() {
    return Manufacturer;
  }

  public int getCost() {
    return cost;
  }

  public int getValid_until() {
    return valid_until;
  }

  public int getAmount() {
    return amount;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setUPC(int uPC) {
    UPC = uPC;
  }

  public void setManufacturer(String manufacturer) {
    Manufacturer = manufacturer;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public void setValid_until(int valid_until) {
    this.valid_until = valid_until;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }


  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", title='" + getTitle() + "'" +
      ", UPC='" + getUPC() + "'" +
      ", Manufacturer='" + getManufacturer() + "'" +
      ", cost='" + getCost() + "'" +
      ", valid_until='" + getValid_until() + "'" +
      ", amount='" + getAmount() + "'" +
      "}";
  }
  
}
