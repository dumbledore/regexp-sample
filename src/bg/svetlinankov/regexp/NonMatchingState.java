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
class NonMatchingState extends FinalState {

    @Override
    public Type getType() {
        return Type.NON_MATCHING;
    }
}
