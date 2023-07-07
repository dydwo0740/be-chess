package softeer2nd.chess.pieces;

import softeer2nd.chess.exception.OutOfRangeException;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(String p) {
        y = p.charAt(0) - 'a';
        x = 8 - (int)(p.charAt(1) - '0');
        if (0 > x || x >= 8 || y < 0 || y >= 8) {
            throw new OutOfRangeException("기물이 체스판을 벗어나버렸습니다.");
        }
        this.x = x;
        this.y = y;
    }
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
