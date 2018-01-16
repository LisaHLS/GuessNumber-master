import com.tw.practice.Game;
import com.tw.practice.NumberGenerator;
import com.tw.practice.NumberReader;
import com.tw.practice.Printer;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new NumberGenerator(), new Printer(), new NumberReader());
        game.start();
    }
}
