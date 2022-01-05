package ch.bbcag.cardgames.common.cards;

import javafx.scene.image.Image;

public class Card {

    private int value;
    private Color color;
    private Face face;
    private Image image;
    private String imagePath;

    public Card(String imagePath) {
        this.imagePath = imagePath;
        setColor();
        setValue();
        setFace();
    }

    private void setColor() {
        char col = imagePath.charAt(1);
        switch (col) {
            case 'C' -> color = Color.CLUBS;
            case 'D' -> color = Color.DIAMONDS;
            case 'H' -> color = Color.HEARTS;
            case 'S' -> color = Color.SPADES;
            default -> throw new IllegalArgumentException("Wrong image path, is not in Format [Value][Color]");
        }
    }

    private void setValue() {
        char val = imagePath.charAt(0);
        switch (val) {
            case '1', '2', '3', '4', '5', '6', '7', '8', '9' -> value = Character.getNumericValue(val);
            case 'T', 'J', 'K', 'Q' -> value = 10;
            case 'A' -> value = 11;
        }
    }

    private void setFace() {
        char fac = imagePath.charAt(0);
        switch (fac) {
            case '1' -> face = Face.ONE;
            case '2' -> face = Face.TWO;
            case '3' -> face = Face.THREE;
            case '4' -> face = Face.FOUR;
            case '5' -> face = Face.FIVE;
            case '6' -> face = Face.SIX;
            case '7' -> face = Face.SEVEN;
            case '8' -> face = Face.EIGHT;
            case '9' -> face = Face.NINE;
            case 'T' -> face = Face.TEN;
            case 'J' -> face = Face.JACK;
            case 'Q' -> face = Face.QUEEN;
            case 'K' -> face = Face.KING;
        }
    }
}