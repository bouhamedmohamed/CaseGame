package solution;

import java.io.BufferedReader;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {


    private static final int INIT_GAME = 0;

    public static int compute(BufferedReader br) {
        final List<String> gameSteps = br.lines ( ).collect (Collectors.toList ( ));
        CaseGame caseGame = new CaseGame (gameSteps);
        return calculateGame (caseGame, caseGame.getStartCase ( ), INIT_GAME);
    }


    private static int calculateGame(CaseGame caseGame, int startCaseElement, int gameIteration) {
        if ( caseGame.endGame (startCaseElement) )
            return caseGame.updateAndGetMinGame (gameIteration);
        if ( caseGame.isGameOver (startCaseElement, gameIteration) ) {
            return caseGame.gameOver ( );
        } else {
            if ( caseGame.isDiceCaseElement (startCaseElement) ) {
                calculateGame (caseGame, startCaseElement + 6, gameIteration + 1);
                calculateGame (caseGame, startCaseElement + 5, gameIteration + 1);
                calculateGame (caseGame, startCaseElement + 4, gameIteration + 1);
                calculateGame (caseGame, startCaseElement + 3, gameIteration + 1);
                calculateGame (caseGame, startCaseElement + 2, gameIteration + 1);
                calculateGame (caseGame, startCaseElement + 1, gameIteration + 1);
            } else
                calculateGame (caseGame, caseGame.updatePosition (startCaseElement), gameIteration + 1);
            return caseGame.gameOver ( );
        }
    }
}
