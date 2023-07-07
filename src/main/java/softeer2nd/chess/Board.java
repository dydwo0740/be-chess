package softeer2nd.chess;

import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.piecetype.Piece;
import softeer2nd.chess.pieces.Rank;
import softeer2nd.chess.pieces.piecetype.enumutils.Type;
import softeer2nd.chess.view.GameView;

import java.util.*;

import static softeer2nd.chess.pieces.piecetype.Piece.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;


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
        return gameChess.findByPiece(createWhite(PAWN));
    }

    public String getBlackPawnsResult() {
        return gameChess.findByPiece(createBlack(PAWN));
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
