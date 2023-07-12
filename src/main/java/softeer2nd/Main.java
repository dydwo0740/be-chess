package softeer2nd;

import softeer2nd.chess.Board;
import softeer2nd.chess.exception.NotUserTurn;
import softeer2nd.chess.game.ChessStarter;
import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.view.GameView;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new ChessStarter().start();

    }
}