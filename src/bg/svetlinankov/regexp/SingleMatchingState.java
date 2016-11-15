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
class SingleMatchingState extends InternalState {

    public SingleMatchingState(IGroup group) {
        super(group);
    }

    @Override
    public IState advance(char c) {
        if (group.matches(c)) {
            return nextState;
        }

        return new NonMatchingState();
    }
}
