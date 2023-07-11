package softeer2nd;

import softeer2nd.chess.Board;
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


        if (str.equals("시작")) {
            gameView.print();
            while(true){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if (command.equals("move")) {
                    String from = st.nextToken();
                    String to = st.nextToken();
                    gameChess.move(from, to);
                    gameView.print();
                } else if (command.equals("종료")) {
                    break;
                }
            }
        }


    }
}