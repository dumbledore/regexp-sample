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
interface IState extends IGroup {

    enum Type {
        MATCHING,
        NON_MATCHING,
        INTERNAL,
    }

    IState advance(char c);

    Type getType();
}
