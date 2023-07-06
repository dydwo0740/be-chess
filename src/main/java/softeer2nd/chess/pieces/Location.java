package softeer2nd.chess.pieces;

import softeer2nd.chess.exception.OutOfRangeException;

import java.util.Objects;

public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
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

    public static Location changeToLocation(String str){
        int col = str.charAt(0) - 'a';
        int row = 8 - (int)(str.charAt(1) - '0');
        return new Location(row, col);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x && y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
