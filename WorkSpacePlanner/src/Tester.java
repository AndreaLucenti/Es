import GUI.GUIFX;
import SetRoom.Room;

public class Tester {
    public static void main(String[] args) {
        javafx.application.Application.launch(GUIFX.class);
        Room room = new Room();
        TextInput textInput = new TextInput(room);
        textInput.TextualIn();

    }
}
