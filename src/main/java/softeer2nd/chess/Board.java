package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;
import softeer2nd.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Pawn> store = new ArrayList<>();

    private char[][] location = new char[8][8];

    private List<Character> whitePawnsResult = new ArrayList<>();

    private List<Character> blackPawnsResult = new ArrayList<>();

    public List<Pawn> getStore() {
        return store;
    }

    public void addPawn(Pawn pawn) {
        this.store.add(pawn);
    }

    public Pawn findPawn(int index) {
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
            for(int j=0;j<8;j++){
                sb.append(String.valueOf(location[i][j]));
            }
            sb.append(StringUtils.NEWLINE);
        }


        System.out.println(sb.toString());

    }
}
