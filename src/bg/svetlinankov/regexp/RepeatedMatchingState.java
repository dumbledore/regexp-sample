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
public class RepeatedMatchingState extends InternalState {

    public RepeatedMatchingState(IGroup group) {
        super(group);
    }

    @Override
    public IState advance(char c) {
        if (c == FINISHING_CHARACTER || !matches(c) || nextState.matches(c)) {
            // Does not match, or next state matches
            return nextState.advance(c);
        }

        return this;
    }
}
