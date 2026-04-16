import javax.swing.*;
import java.awt.*;
import si211.*;

public class Board extends JPanel {

    public Board(int seed) {
        setLayout(new GridLayout(6, 6));

        int[][] ids = P3Tools.getRandomKindIdAssignments(seed, 18, 6);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                Tile tile = new Tile(i, j, ids[i][j]);
                add(tile);
            }
        }
    }
}