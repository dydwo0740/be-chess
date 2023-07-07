package softeer2nd.chess;

import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.piecetype.Piece;
import softeer2nd.chess.pieces.Rank;
import softeer2nd.chess.pieces.piecetype.PieceFactory;
import softeer2nd.chess.pieces.piecetype.enumutils.Type;
import softeer2nd.chess.view.GameView;

import java.util.*;

import static softeer2nd.chess.pieces.piecetype.Piece.*;
import static softeer2nd.chess.pieces.piecetype.PieceFactory.*;
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
        return gameChess.findByPiece(createWhitePawn());
    }
    public String getBlackPawnsResult() {
        return gameChess.findByPiece(createBlackPawn());
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
