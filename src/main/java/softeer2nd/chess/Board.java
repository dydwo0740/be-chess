package softeer2nd.chess;

import softeer2nd.chess.pieces.Location;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.utils.StringUtils;

import java.util.*;

/**
 * 초기에는 char 이차원 배열을 통한 구현
 * 이를 대체하기 위해서, ArrayList 를 생각했지만 추후에 기물의 이동 수정에서 문제가 발생할 것 같다.
 * Map을 사용하여서 key로는 Location 이라는 객체를 받는다. 여기서 Location은 체스의 위치를 x, y 좌표로 나타내는 역할을 합니다.
 */

public class Board {
    private List<Piece> store = new ArrayList<>();

    private Map<Location, Piece> state = new HashMap<>();





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
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    public void initialize(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(i == 1){
                    state.put(new Location(i, j), Piece.createBlackPawn());
                }else if(i == 6){
                    state.put(new Location(i, j), Piece.createWhitePawn());
                }else {
                    state.put(new Location(i, j), Piece.createEmptyPawn());
                }
            }
        }
        

    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        initialize();

        for(int i=0;i<8;i++){
            String str = "";
            for(int j=0;j<8;j++){
                str += String.valueOf(state.get(new Location(i, j)));
            }
            sb.append(StringUtils.appendNewLine(str));
        }


        System.out.println(sb.toString());

    }

    public String findByPawnColor(final Piece findPiece){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                Piece piece = state.get(new Location(i, j));
                if(piece.getColor().equals(findPiece.getColor()) && piece.getRepresentation() == findPiece.getRepresentation()){
                    sb.append(piece.getRepresentation());
                }
            }
        }

        return StringUtils.appendNewLine(sb.toString());
    }

    public int pieceCount() {
        int count = 0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(state.get(new Location(i, j)).get)
            }
        }

    }
}
