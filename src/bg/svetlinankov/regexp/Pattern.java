/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.svetlinankov.regexp;

/**
 *
 * @author Svetlin
 */
// matches a-z.*
public class Pattern {

    private final IState firstState;

    public Pattern(String pattern) {
        firstState = parse(pattern);
    }

    private static IState parse(String pattern) {
        final InternalState firstState = new FirstState();
        InternalState previousState = firstState;

        for (int i = 0; i < pattern.length(); i++) {
            char symbol = pattern.charAt(i);
            boolean isRepeated
                    = // we can peek
                    (i + 1 < pattern.length())
                    // the next char is *
                    && (pattern.charAt(i + 1) == '*');

            IGroup group = groupFromChar(symbol);
            InternalState state;
            if (isRepeated) {
                state = new RepeatedMatchingState(group);
                // account for *
                i++;
            } else {
                state = new SingleMatchingState(group);
            }

            previousState.setNextState(state);
            previousState = state;
        }

        // End it
        previousState.nextState = new MatchingState();

        return firstState;
    }

    private static IGroup groupFromChar(char c) {
        switch (c) {
            case '.':
                return new MatchAllGroup();
            case '*':
                throw new IllegalStateException("Did not expect repeater: *");
            default:
                // assume a-z
                return new SymbolGroup(c);
        }
    }

    public boolean matches(String s) {
        // Start from the first state
        IState state = firstState;

        int i = 0;
        for (i = 0; i < s.length()
                && state.getType() == IState.Type.INTERNAL; i++) {
            state = state.advance(s.charAt(i));
        }

        // Make sure we finish (get out of repetative state)
        state = state.advance(IGroup.FINISHING_CHARACTER);

        // Make sure we ended up at a Matching state only after
        // going through the whole haystack
        return (i >= s.length()) && (state.getType() == IState.Type.MATCHING);
    }

    public static boolean match(String haystack, String pattern) {
        return new Pattern(pattern).matches(haystack);
    }
}
