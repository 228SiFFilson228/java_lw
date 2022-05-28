import java.util.ArrayList;

public class Park {

  ArrayList<Attraction> attractions = new ArrayList<>();


  public void AddAtraction(String title, int openTime, int closeTime, int cost) {
    attractions.add(new Attraction(title, openTime, closeTime, cost));
  }

  
  public class Attraction {
    String title;
    int openTime;
    int closeTime;
    int cost;

    public Attraction(String title, int openTime, int closeTime, int cost) {
      this.title = title;
      this.openTime = openTime;
      this.closeTime = closeTime;
      this.cost = cost;
    }

    public String getTitle() {
      return title;
    }

    public int getOpenTime() {
      return openTime;
    }

    public int getCloseTime() {
      return closeTime;
    }

    public int getCost() {
      return cost;
    }

  }

}
