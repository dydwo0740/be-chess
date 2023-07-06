package softeer2nd.chess.pieces;

import softeer2nd.chess.exception.OutOfRangeException;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        if (0 > x || x >= 8 || y < 0 || y >= 8) {
            throw new OutOfRangeException("기물이 체스판을 벗어나버렸습니다.");
        }
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

    public static Position changeToPosition(String str){
        int col = str.charAt(0) - 'a';
        int row = 8 - (int)(str.charAt(1) - '0');
        return new Position(row, col);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
