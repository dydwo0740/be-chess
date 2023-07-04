package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Piece> store = new ArrayList<>();

    private char[][] location = new char[8][8];

    private List<Character> whitePawnsResult = new ArrayList<>();

    private List<Character> blackPawnsResult = new ArrayList<>();

    public List<Piece> getStore() {
        return store;
    }

    public void addPawn(Piece piece) {
        this.store.add(piece);
    }

    public Piece findPawn(int index) {
        return this.store.get(index);
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<whitePawnsResult.size();i++){
            sb.append(String.valueOf(whitePawnsResult.get(i)));
        }
        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<blackPawnsResult.size();i++){
            sb.append(String.valueOf(blackPawnsResult.get(i)));
        }
        return sb.toString();
    }

    public void initialize(){
        for(int i=0;i<8;i++){
            if(i == 1){
                Arrays.fill(location[i], 'P');
            } else if (i == 6) {
                Arrays.fill(location[i], 'p');
            }else {
                Arrays.fill(location[i], '.');
            }
        }

        //pawn 이외에 기물은 그냥 노가다로 삽입?
        char[] alpha = {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'};
        for(int i=0;i<8;i++){
            location[0][i] = alpha[i];
            location[7][i] = (char)(alpha[i] - 'A' + 'a');
        }



        for(int i=0;i<8;i++){
            whitePawnsResult.add('p');
            blackPawnsResult.add('P');
        }
        //모두 살아있습니다.
    }

    public void print(){
        StringBuilder sb = new StringBuilder();

        initialize();

        for(int i=0;i<8;i++){
            String str = "";
            for(int j=0;j<8;j++){
                str += String.valueOf(location[i][j]);
            }
            sb.append(StringUtils.appendNewLine(str));
        }


        System.out.println(sb.toString());

    }
}
