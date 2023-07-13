package softeer2nd.chess.game;

import softeer2nd.chess.Board;
import softeer2nd.chess.exception.NotUserTurn;
import softeer2nd.chess.pieces.piecetype.Piece;
import softeer2nd.chess.view.GameView;

import java.io.*;
import java.util.StringTokenizer;

import static softeer2nd.chess.pieces.piecetype.Piece.*;
import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;

public class ChessStarter {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    Board board = null;
    GameChess gameChess = null;
    GameView gameView = null;

    Color turn = WHITE;

    public void start() throws IOException {
        st = new StringTokenizer(br.readLine());
        board = new Board();
        gameChess = new GameChess(board);
        gameView = new GameView(board);
        String str = st.nextToken();

        if (str.equals("시작")) {
            gameView.print();
            while(true){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if (command.equals("move")) {
                    String from = st.nextToken();
                    String to = st.nextToken();
                    if((turn != gameChess.findPiece(from).getColor())){
                        throw new NotUserTurn("선택한 기물은 사용자의 기물이 아닙니다.");
                    }
                    gameChess.move(from, to);
                    gameView.print();
                } else if (command.equals("종료")) {
                    break;
                }
            }
        }

    }
}
