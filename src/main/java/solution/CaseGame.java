package solution;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class CaseGame {
    private static final String END = "E";
    private static final String START = "S";
    private static final String DICE = "R";
    private static final int INIT_VALUE = -1;
    private final int startCase;
    private final int endCase;
    private final List<String> gameCases;
    private static Map<Integer, Integer> visitedCase;
    private static AtomicInteger minGame;

    public CaseGame(List<String> gameSteps) {
        this.gameCases = gameSteps;
        startCase = findPosition (START);
        endCase = findPosition (END);
        visitedCase = new HashMap<> ( );
        minGame = new AtomicInteger (-1);

    }

    public int getStartCase() {
        return startCase;
    }

    private List<String> getGameCases() {
        return Collections.unmodifiableList (gameCases);
    }

    public int updatePosition(int caseElement) {
        final int newPosition = caseElement + Integer.parseInt (getGameCases ( ).get (caseElement));
        if ( notInRangeGame (newPosition) )
            return getStartCase ( );
        return newPosition;
    }

    public boolean isDiceCaseElement(int element) {
        final String gameCase = getGameCases ( ).get (element);
        return DICE.equals (gameCase) || START.equals (gameCase);
    }

    public int updateAndGetMinGame(int game) {
        if ( game < minGame.get ( ) || minGame.get ( ) == INIT_VALUE )
            minGame.set (game);
        return minGame.get ( );
    }

    public boolean finishGame(int caseElement) {
        return caseElement == endCase;
    }

    public boolean isGameOver(int caseElement, int gameNumber) {
        return overMinGame (gameNumber) ||
                notInRangeGame (caseElement) ||
                isAlreadyVisitTheCase (caseElement, gameNumber);

    }

    public int gameOver() {
        return minGame.get ( );
    }

    private boolean notInRangeGame(int caseElement) {
        return !(caseElement >= 0 && caseElement < getGameCases ( ).size ( ));
    }

    private int findPosition(String caseElementToFind) {
        int position = 0;
        for (String gameStep : getGameCases ( )) {
            if ( gameStep.equals (caseElementToFind) )
                return position;
            position++;
        }
        throw new IllegalArgumentException ( );
    }

    private boolean isAlreadyVisitTheCase(int caseElement, int gameNumber) {
        Integer value = visitedCase.get (caseElement);
        if ( value == null || value > gameNumber ) {
            visitedCase.put (caseElement, gameNumber);
            return false;
        }
        return true;
    }

    private boolean overMinGame(int game) {
        final int minGameValue = minGame.get ( );
        return game > minGameValue && minGameValue != INIT_VALUE;
    }
}
