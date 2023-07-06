package softeer2nd.chess;

import softeer2nd.chess.exception.EmptyPieceException;
import softeer2nd.chess.exception.NotEmptyPieceException;
import softeer2nd.chess.pieces.Location;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Rank;

import java.util.*;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.Piece.createWhiteKing;
import static softeer2nd.utils.StringUtils.*;

/**
 * 초기에는 char 이차원 배열을 통한 구현
 * 이를 대체하기 위해서, ArrayList 를 생각했지만 추후에 기물의 이동 수정에서 문제가 발생할 것 같다.
 * Map을 사용하여서 key로는 Location 이라는 객체를 받는다. 여기서 Location은 체스의 위치를 x, y 좌표로 나타내는 역할을 합니다.
 */

public class Board {
    private List<Piece> store = new ArrayList<>();

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
            Rank rank = new Rank();
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    rank.addPiece(createBlackPawn());
                } else if (i == 6) {
                    rank.addPiece(createWhitePawn());
                } else if (i == 0) {
                    rank.addPiece(createBlackRook());
                    rank.addPiece(createBlackKnight());
                    rank.addPiece(createBlackBishop());
                    rank.addPiece(createBlackQueen());
                    rank.addPiece(createBlackKing());
                    rank.addPiece(createBlackBishop());
                    rank.addPiece(createBlackKnight());
                    rank.addPiece(createBlackRook());
                } else if (i == 7) {
                    rank.addPiece(createWhiteRook());
                    rank.addPiece(createWhiteKnight());
                    rank.addPiece(createWhiteBishop());
                    rank.addPiece(createWhiteQueen());
                    rank.addPiece(createWhiteKing());
                    rank.addPiece(createWhiteBishop());
                    rank.addPiece(createWhiteKnight());
                    rank.addPiece(createWhiteRook());
                }
                else {
                    rank.addPiece(createBlank());
                }
            }
            state.add(rank);
        }


    }

    public void print() {
        System.out.println(showBoard());
    }

    public String findByPiece(final Piece findPiece) {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : state) {
            List<Piece> pieces = rank.getPieces();
            for (Piece piece : pieces) {
                if (piece.equals(findPiece)) {
                    sb.append(String.valueOf(piece.getRepresentation()));
                }
            }
        }
        return sb.toString();
    }

    public int findByColorAndType(final Color color, final Type type) {
        int count = 0;
        for (Rank rank : state) {
            List<Piece> pieces = rank.getPieces();
            for (Piece piece : pieces) {
                if (piece.getColor().equals(color) && piece.getType().equals(type)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int pieceCount() {
        int count = 0;
        for (Rank rank : state) {
            List<Piece> pieces = rank.getPieces();
            for (Piece piece : pieces) {
                if (!piece.equals(createBlank())) {
                    count++;
                }
            }
        }

        return count;

    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : state) {
            String str = "";
            List<Piece> pieces = rank.getPieces();
            for (Piece piece : pieces) {
                str += String.valueOf(piece.getRepresentation());
            }
            sb.append(appendNewLine(str));
        }

        return sb.toString();
    }

    public Piece findByLocation(String str){
        Location loc = changeToLocation(str);
        return state.get(loc.getX()).getPiece(loc.getY());
    }

    private Location changeToLocation(String str){
        int col = str.charAt(0) - 'a';
        int row = 8 - (int)(str.charAt(1) - '0');
        return new Location(row, col);
    }

    public void initializeEmpty() {
        state.clear();
        for(int i=0;i<8;i++){
            Rank rank = new Rank();
            for(int j=0;j<8;j++){
                rank.addPiece(Piece.createBlank());
            }
            state.add(rank);
        }
    }

    public void move(String position, Piece piece) throws RuntimeException{
        isNotEmptyPiece(position);
        Piece toPiece = findByLocation(position);
        toPiece = piece;
    }

    public void set(String from, String to) throws RuntimeException{
        Piece start = findByLocation(from);
        Piece end = findByLocation(to);

        move(to, start);
        move(from, Piece.createBlank());

    }

    private void isEmptyPiece(String position){
        if(findByLocation(position).equals(createBlank())){
            throw new EmptyPieceException("해당 칸에는 기물이 존재하지 않습니다.");
        }
    }

    private void isNotEmptyPiece(String position) {
        if(!findByLocation(position).equals(createBlank())){
            throw new NotEmptyPieceException("이동시킬 칸에는 기물이 존재합니다.");
        }
    }

}
