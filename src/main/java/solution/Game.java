package solution;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Game {
    public static final String END = "E";
    public static final String START = "S";
    public static final String DICE = "R";
    public static final int INIT_VALUE = -1;
    private int startCase;
    private int endCase;
    private List<String> gameCases;
    static Map<Integer, Integer> visitedCase;
    public static AtomicInteger minGame;

    public Game(List<String> gameSteps) {
        this.gameCases = gameSteps;
        startCase = findPosition (START);
        endCase = findPosition (END);
        visitedCase = new HashMap<Integer, Integer> ( );
        minGame = new AtomicInteger (-1);

    }

    public int getStartCase() {
        return startCase;
    }

    public List<String> getGameCases() {
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

    public boolean endGame(int caseElement) {
        return caseElement == endCase;
    }

    public boolean isGameOver(int caseElement, int gameNumber) {
        return overMinGame (gameNumber) ||
                notInRangeGame (caseElement) ||
                isAlreadyVisitTheCase (caseElement, gameNumber);

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
        if ( value == null || ((value != null) && (value > gameNumber)) ) {
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
