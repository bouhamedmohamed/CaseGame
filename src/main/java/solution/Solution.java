package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {


    public static int compute(BufferedReader br) throws IOException {
        final List<String> gameSteps = br.lines ( ).collect (Collectors.toList ( ));
        Game caseGame = new Game (gameSteps);
        return seek (caseGame, caseGame.getStartCase ( ), 0);
    }


    public static int seek(Game gameCase, int start_Case,
                           int game) {
        if ( gameCase.endGame (start_Case) )
            return gameCase.updateAndGetMinGame (game);
        if ( gameCase.isGameOver (start_Case, game) ) {
            return gameCase.updateAndGetMinGame (Game.minGame.get ( ));
        } else {

            if ( gameCase.isDiceCaseElement (start_Case) ) {
                seek (gameCase, start_Case + 6, game + 1);
                seek (gameCase, start_Case + 5, game + 1);
                seek (gameCase, start_Case + 4, game + 1);
                seek (gameCase, start_Case + 3, game + 1);
                seek (gameCase, start_Case + 2, game + 1);
                seek (gameCase, start_Case + 1, game + 1);
            } else
                seek (gameCase, gameCase.updatePosition (start_Case), game + 1);

            return gameCase.updateAndGetMinGame (Game.minGame.get ( ));
        }

    }


}
