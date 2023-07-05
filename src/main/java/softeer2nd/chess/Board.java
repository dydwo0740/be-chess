package softeer2nd.chess;

import softeer2nd.chess.exception.EmptyPieceException;
import softeer2nd.chess.exception.NotEmptyPieceException;
import softeer2nd.chess.pieces.Location;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Rank;

import java.util.*;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.utils.StringUtils.*;

/**
 * 초기에는 char 이차원 배열을 통한 구현
 * 이를 대체하기 위해서, ArrayList 를 생각했지만 추후에 기물의 이동 수정에서 문제가 발생할 것 같다.
 * Map을 사용하여서 key로는 Location 이라는 객체를 받는다. 여기서 Location은 체스의 위치를 x, y 좌표로 나타내는 역할을 합니다.
 */

public class Board {
    private List<Piece> store = new ArrayList<>();

    private Map<Location, Piece> state = new HashMap<>();

    private List<Rank> state = new ArrayList<>();


    public List<Piece> getStore() {
        return store;
    }

    public void addPawn(Piece piece) {
        this.store.add(piece);
    }

    public Piece findPawn(int index) {
        return this.store.get(index);
    }

    public String getWhitePawnsResult() {
        return findByPiece(createWhitePawn());
    }

    public String getBlackPawnsResult() {
        return findByPiece(createBlackPawn());
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    state.put(new Location(i, j), createBlackPawn());
                } else if (i == 6) {
                    state.put(new Location(i, j), createWhitePawn());
                } else if (i == 0) {
                    state.put(new Location(i, 0), createBlackRook());
                    state.put(new Location(i, 7), createBlackRook());
                    state.put(new Location(i, 1), createBlackKnight());
                    state.put(new Location(i, 6), createBlackKnight());
                    state.put(new Location(i, 2), createBlackBishop());
                    state.put(new Location(i, 5), createBlackBishop());
                    state.put(new Location(i, 3), createBlackQueen());
                    state.put(new Location(i, 4), createBlackKing());
                } else if (i == 7) {
                    state.put(new Location(i, 0), createWhiteRook());
                    state.put(new Location(i, 7), createWhiteRook());
                    state.put(new Location(i, 1), createWhiteKnight());
                    state.put(new Location(i, 6), createWhiteKnight());
                    state.put(new Location(i, 2), createWhiteBishop());
                    state.put(new Location(i, 5), createWhiteBishop());
                    state.put(new Location(i, 3), createWhiteQueen());
                    state.put(new Location(i, 4), createWhiteKing());
                }
                else {
                    state.put(new Location(i, j), createBlank());
                }
            }
        }


    }

    public void print() {
        System.out.println(showBoard());
    }

    public String findByPiece(final Piece findPiece) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = state.get(new Location(i, j));
                if (piece.equals(findPiece)) {
                    sb.append(piece.getRepresentation());
                }
            }
        }
        return sb.toString();
    }

    public int findByColorAndType(final Color color, final Type type) {
        int count = 0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                Piece findPiece = state.get(new Location(i, j));
                if (findPiece.getColor() == color && findPiece.getType() == type) {
                    count++;
                }
            }
        }
        return count;
    }

    public int pieceCount() {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!state.get(new Location(i, j)).equals(createBlank())) {
                    count++;
                }
            }
        }

        return count;

    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            String str = "";
            for (int j = 0; j < 8; j++) {
                str += String.valueOf(state.get(new Location(i, j)).getRepresentation());
            }
            sb.append(appendNewLine(str));
        }

        return sb.toString();
    }

    public Piece findByLocation(String str){
        Location loc = changeToLocation(str);
        return state.get(loc);
    }

    private Location changeToLocation(String str){
        int col = str.charAt(0) - 'a';
        int row = 8 - (int)(str.charAt(1) - '0');
        return new Location(row, col);
    }

    public void initializeEmpty() {
        state.clear();

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                state.put(new Location(i, j), Piece.createBlank());
            }
        }
    }

    public void move(String position, Piece piece) {
        Location loc = changeToLocation(position);
        state.put(loc, piece);
    }
    public void set(String from, String to) throws RuntimeException{
        Piece start = findByLocation(from);
        Piece end = findByLocation(to);
        fromTo(start, end);

        move(to, start);
        move(from, Piece.createBlank());

    }

    private void fromTo(Piece start, Piece end){
        if (start.equals(Piece.createBlank())) {
            throw new EmptyPieceException("해당 칸에는 기물이 존재하지 않습니다.");
        }

        if (!end.equals(Piece.createBlank())) {
            throw new NotEmptyPieceException("이동할 칸에는 기물이 존재합니다");
        }
    }
}
