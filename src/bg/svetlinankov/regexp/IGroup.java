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
interface IGroup {

    public static final char FINISHING_CHARACTER = Character.MIN_VALUE;

    boolean matches(char c);
}
