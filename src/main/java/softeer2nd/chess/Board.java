package softeer2nd.chess;

import softeer2nd.chess.pieces.Rank;
import softeer2nd.chess.pieces.piecetype.Piece;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.piecetype.PieceFactory.*;

public class Board {

    public static final int BOARD_LENGTH = 8;

    public List<Rank> getState() {
        return state;
    }

    public Board() {
        initialize();
    }

    private List<Rank> state = new ArrayList<>();


    public void initialize() {
        state.clear();
        for (int i = 0; i < BOARD_LENGTH; i++) {
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
                } else {
                    rank.addPiece(createBlank());
                }
            }
            state.add(rank);
        }
    }

    public void initializeEmpty() {
        state.clear();
        for (int i = 0; i < BOARD_LENGTH; i++) {
            Rank rank = new Rank();
            for (int j = 0; j < BOARD_LENGTH; j++) {
                rank.addPiece(createBlank());
            }
            state.add(rank);
        }
    }

    public void changePiece(int idx1, int idx2, Piece piece) {
        state.get(idx1).setPiece(idx2, piece);
    }
    public Piece findByPosition(int x, int y) {
        return state.get(x).getPiece(y);
    }
    public static boolean isInBoardRange(int row, int col){
        if (row >= BOARD_LENGTH || row < 0 || col >= BOARD_LENGTH || col < 0) {
            return false;
        }
        return true;
    }

}
