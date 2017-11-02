/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOf21;

/**
 *
 * @author naree1878
 */
public class card {

    private String name;
    private int value;

    public card(int num) { //takes in the random number a turns it into the name and value of the card
        switch (num) {
            case (1):
                name = "Ace";
                value = 11;
                break;
            case (11):
                name = "Jack";
                value = 10;
                break;

            case (12):
                name = "Queen";
                value = 10;
                break;
            case (13):
                name = "King";
                value = 10;
                break;
            case (14):
                name = "null";
                value = 0;
                break;
            default:
                name = "" + num;
                value = num;
                break;
        }
    }

    /**
     * returns the name of the card object
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * returns the number value of the card object
     *
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * sets value of aces to be either 1 if the value is too high
     *
     * @param v
     */
    public void setValue(int v) {
        value = v;
    }
}
