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
class SymbolGroup implements IGroup {

    private final char symbol;

    public SymbolGroup(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean matches(char c) {
        return symbol == c;
    }
}
