package softeer2nd;

import softeer2nd.chess.Board;
import softeer2nd.chess.exception.NotUserTurn;
import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.view.GameView;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Board board = new Board();
        GameChess gameChess = new GameChess(board);
        GameView gameView = new GameView(board);
        String str = st.nextToken();

        boolean turn = true;

        if (str.equals("시작")) {
            gameView.print();
            while(true){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if (command.equals("move")) {
                    String from = st.nextToken();
                    String to = st.nextToken();
                    if((turn && gameChess.findPiece(from).isWhite()) || (!turn && gameChess.findPiece(from).isBlack())){

                    }else{
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