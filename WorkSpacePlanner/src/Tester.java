import SetRoom.Room;

public class Tester {
    public static void main(String[] args) {
        Room room = new Room();
        TextInput textInput = new TextInput(room);
        textInput.TextualIn();
    }
}
