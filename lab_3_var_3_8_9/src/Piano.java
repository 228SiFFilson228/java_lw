import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Piano {
  String model = "Yamaha";
  ArrayList<Button> buttons = new ArrayList<>();

  public Piano(Button[] buttons) {
    this.buttons = new ArrayList<>(Arrays.asList(buttons));
  }

  public Piano(String title, Button[] buttons) {
    this.buttons = new ArrayList<>(Arrays.asList(buttons));
    model = title;
  }

  public void PressButton(int index) {
    buttons.get(index).Press();
  }



  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public ArrayList<Button> getButtons() {
    return this.buttons;
  }

  public void setButtons(ArrayList<Button> buttons) {
    this.buttons = buttons;
  }



  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Piano)) {
            return false;
        }
        Piano piano = (Piano) o;
        return Objects.equals(model, piano.model) && Objects.equals(buttons, piano.buttons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(model, buttons);
  }


  @Override
  public String toString() {
    return "{" +
      " model='" + getModel() + "'" +
      ", buttons='" + getButtons() + "'" +
      "}";
  }

}
