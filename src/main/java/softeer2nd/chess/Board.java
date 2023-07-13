package softeer2nd.chess;

import softeer2nd.chess.pieces.Rank;
import softeer2nd.chess.pieces.piecetype.*;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.piecetype.Bishop.*;
import static softeer2nd.chess.pieces.piecetype.Blank.*;
import static softeer2nd.chess.pieces.piecetype.King.*;
import static softeer2nd.chess.pieces.piecetype.Knight.*;
import static softeer2nd.chess.pieces.piecetype.Pawn.*;
import static softeer2nd.chess.pieces.piecetype.Queen.*;
import static softeer2nd.chess.pieces.piecetype.Rook.*;

public class Board {

    public static final int BOARD_LENGTH = 8;
    public static final int BLACK_PAWNS_AREA = 0;
    public static final int BLACK_OFFICERS_AREA = 1;
    public static final int WHITE_PAWNS_AREA = 7;
    public static final int WHITE_OFFICERS_AREA = 6;

    public List<Rank> getState() {
        return state;
    }

    public Board() {
        initialize();
    }

    private List<Rank> state = new ArrayList<>();


    public void initialize() {
        initializeEmpty();
        state.set(BLACK_PAWNS_AREA, getBlackPawns());
        state.set(BLACK_OFFICERS_AREA, getBlackOfficers());
        state.set(WHITE_PAWNS_AREA, getWhitePawns());
        state.set(WHITE_OFFICERS_AREA, getWhiteOfficers());
    }

    private Rank getBlankRank() {
        Rank rank = new Rank();
        for (int level = 0; level < BOARD_LENGTH; level++) {
            rank.addPiece(createBlank());
        }
        return rank;
    }

    private Rank getBlackOfficers() {
        Rank rank = new Rank();
        rank.addPiece(createBlackRook());
        rank.addPiece(createBlackKnight());
        rank.addPiece(createBlackBishop());
        rank.addPiece(createBlackQueen());
        rank.addPiece(createBlackKing());
        rank.addPiece(createBlackBishop());
        rank.addPiece(createBlackKnight());
        rank.addPiece(createBlackRook());
        return rank;
    }

    private Rank getWhiteOfficers() {
        Rank rank = new Rank();
        rank.addPiece(createWhiteRook());
        rank.addPiece(createWhiteKnight());
        rank.addPiece(createWhiteBishop());
        rank.addPiece(createWhiteQueen());
        rank.addPiece(createWhiteKing());
        rank.addPiece(createWhiteBishop());
        rank.addPiece(createWhiteKnight());
        rank.addPiece(createWhiteRook());
        return rank;
    }

    private Rank getBlackPawns() {
        Rank rank = new Rank();
        for (int level = 0; level < BOARD_LENGTH; level++) {
            rank.addPiece(createBlackPawn());
        }
        return rank;
    }

    private Rank getWhitePawns() {
        Rank rank = new Rank();
        for (int level = 0; level < BOARD_LENGTH; level++) {
            rank.addPiece(createWhitePawn());
        }
        return rank;
    }

    public void initializeEmpty() {
        state.clear();
        for (int row = 0; row < BOARD_LENGTH; row++) {
            state.add(getBlankRank());
        }
    }

    public void changePiece(int idx1, int idx2, Piece piece) {
        state.get(idx1).setPiece(idx2, piece);
    }

    public Piece findByPosition(int x, int y) {
        return state.get(x).getPiece(y);
    }

    public static boolean isInBoardRange(int row, int col) {
        if (row >= BOARD_LENGTH || row < 0 || col >= BOARD_LENGTH || col < 0) {
            return false;
        }
        return true;
    }

}
