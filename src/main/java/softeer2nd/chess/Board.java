package softeer2nd.chess;

import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.PieceFactory;
import softeer2nd.chess.pieces.Rank;
import softeer2nd.chess.view.GameView;

import java.util.*;

import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.Piece.Type.*;
import static softeer2nd.chess.pieces.PieceFactory.*;


/**
 * 초기에는 char 이차원 배열을 통한 구현
 * 이를 대체하기 위해서, ArrayList 를 생각했지만 추후에 기물의 이동 수정에서 문제가 발생할 것 같다.
 * Map을 사용하여서 key로는 Location 이라는 객체를 받는다. 여기서 Location은 체스의 위치를 x, y 좌표로 나타내는 역할을 합니다.
 */

public class Board {
    public List<Rank> getState() {
        return state;
    }

    private GameChess gameChess;
    private GameView gameView;

    public GameChess getGameChess() {
        return gameChess;
    }

    public Board() {
        initialize();
        gameChess = new GameChess(this);
        gameView = new GameView(this);
    }

    public GameView getGameView() {
        return gameView;
    }

    private List<Rank> state = new ArrayList<>();

    public String getWhitePawnsResult() {
        return findByPiece(createWhitePawn());
    }

    public String getBlackPawnsResult() {
        return findByPiece(createBlackPawn());
    }

    public void initialize() {
        state.clear();
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
                    break;
                } else if (i == 7) {
                    rank.addPiece(createWhiteRook());
                    rank.addPiece(createWhiteKnight());
                    rank.addPiece(createWhiteBishop());
                    rank.addPiece(createWhiteQueen());
                    rank.addPiece(createWhiteKing());
                    rank.addPiece(createWhiteBishop());
                    rank.addPiece(createWhiteKnight());
                    rank.addPiece(createWhiteRook());
                    break;
                }
                else {
                    rank.addPiece(createBlank());
                }
            }
            state.add(rank);
        }


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
    public void initializeEmpty() {
        state.clear();
        for(int i=0;i<8;i++){
            Rank rank = new Rank();
            for(int j=0;j<8;j++){
                rank.addPiece(createBlank());
            }
            state.add(rank);
        }
    }

    public double caculcatePoint(Color color) {
        double sum = 0;
        for (Rank rank : state) {
            List<Piece> pieces = rank.getPieces();
            for (Piece piece : pieces) {
                if (piece.getColor() == color) {
                    sum += piece.getType().getDefaultPoint();
                }
            }
        }
        return sum - ((double)pawnCheck() * 0.5);
    }



    private int pawnCheck(){
        int[] pawnChecker = new int[8];
        int res = 0;
        for (Rank rank : state) {
            List<Piece> pieces = rank.getPieces();
            int index = 0;
            for (Piece piece : pieces) {
                if (piece.getType().equals(PAWN)) {
                    pawnChecker[index]++;
                }
                index++;
            }
        }

        for (int count : pawnChecker) {
            if(count >= 2){
                res += count;
            }
        }

        return res;
    }

}
