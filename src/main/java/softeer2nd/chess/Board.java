package softeer2nd.chess;

import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.piecetype.Piece;
import softeer2nd.chess.pieces.Rank;
import softeer2nd.chess.pieces.piecetype.enumutils.Type;
import softeer2nd.chess.view.GameView;

import java.util.*;

import static softeer2nd.chess.pieces.piecetype.Piece.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;


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
        return findByPiece(createWhite(PAWN));
    }

    public String getBlackPawnsResult() {
        return findByPiece(createBlack(PAWN));
    }

    public void initialize() {
        state.clear();
        for (int i = 0; i < 8; i++) {
            Rank rank = new Rank();
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    rank.addPiece(createBlack(PAWN));
                } else if (i == 6) {
                    rank.addPiece(createWhite(PAWN));
                } else if (i == 0) {
                    rank.addPiece(createBlack(ROOK));
                    rank.addPiece(createBlack(KNIGHT));
                    rank.addPiece(createBlack(BISHOP));
                    rank.addPiece(createBlack(QUEEN));
                    rank.addPiece(createBlack(KING));
                    rank.addPiece(createBlack(BISHOP));
                    rank.addPiece(createBlack(KNIGHT));
                    rank.addPiece(createBlack(ROOK));
                    break;
                } else if (i == 7) {
                    rank.addPiece(createWhite(ROOK));
                    rank.addPiece(createWhite(KNIGHT));
                    rank.addPiece(createWhite(BISHOP));
                    rank.addPiece(createWhite(QUEEN));
                    rank.addPiece(createWhite(KING));
                    rank.addPiece(createWhite(BISHOP));
                    rank.addPiece(createWhite(KNIGHT));
                    rank.addPiece(createWhite(ROOK));
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
}
