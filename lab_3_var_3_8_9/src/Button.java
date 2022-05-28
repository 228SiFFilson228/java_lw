import java.util.Objects;

public class Button {
  String sound = "do";


  public Button(String sound) {
    this.sound = sound;
  }

  
  public void Press() {
    System.out.println(sound);
  }


  public String getSound() {
    return this.sound;
  }


  @Override
  public String toString() {
    return "{" +
      " sound='" + getSound() + "'" +
      "}";
  }
  

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Button)) {
            return false;
        }
        Button button = (Button) o;
        return Objects.equals(sound, button.sound);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(sound);
  }

}
