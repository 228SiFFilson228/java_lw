import java.util.Objects;

public class Photo {
  String title;


  public Photo(String title) {
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Photo)) {
            return false;
        }
        Photo photo = (Photo) o;
        return Objects.equals(title, photo.title);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(title);
  }


  @Override
  public String toString() {
    return "{" +
      " title='" + getTitle() + "'" +
      "}";
  }


}
