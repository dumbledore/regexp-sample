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
abstract class FinalState implements IState {

    @Override
    public IState advance(char c) {
        return this;
    }

    @Override
    public boolean matches(char c) {
        return false;
    }
}
