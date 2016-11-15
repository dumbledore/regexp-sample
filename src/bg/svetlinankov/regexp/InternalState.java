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
abstract class InternalState implements IState {

    protected final IGroup group;
    protected IState nextState;

    protected InternalState(IGroup group) {
        this.group = group;
    }

    @Override
    public boolean matches(char c) {
        return group.matches(c);
    }

    public void setNextState(IState state) {
        nextState = state;
    }

    @Override
    public Type getType() {
        return Type.INTERNAL;
    }
}
