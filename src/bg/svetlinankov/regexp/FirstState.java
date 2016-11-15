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
class FirstState extends InternalState {

    public FirstState() {
        super(null);
    }

    @Override
    public IState advance(char c) {
        return nextState.advance(c);
    }
}
