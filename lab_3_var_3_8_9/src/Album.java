import java.util.ArrayList;
import java.util.Objects;

public class Album {
  ArrayList<Photo> photos;

  public Album(ArrayList<Photo> photos) {
    this.photos = new ArrayList<>(photos);
  }

  public void SetPhotoTitle(int index, String newTitle) {
    photos.get(index).setTitle(newTitle);
  }

  public void AddPhoto(Photo photo) {
    photos.add(photo);
  }

  public void GetCount() {
    System.out.println(photos.size());
  }


  @Override
  public String toString() {
    return "{" +
      " photos='" + photos + "'" +
      "}";
  }


  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Album)) {
            return false;
        }
        Album album = (Album) o;
        return Objects.equals(photos, album.photos);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(photos);
  }


}
