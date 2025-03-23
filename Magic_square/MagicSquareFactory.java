
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        // maximum possible number of values in sqare
        int maxNumberOfValues = square.getWidth() * square.getHeight();

        // current x and y coordinates to place '1' in the middle of the top row
        int currentX = (square.getWidth() - 1) / 2;
        int currentY = 0;
        //place initial '1'
        square.setValue(currentX, currentY,  1);

        // fill magic square with numbers until all square is filled
        for (int currentValue = 2; currentValue <= maxNumberOfValues; currentValue++) {
            // move one row up and one column right
            int tempX = moveRight(currentX, square);
            int tempY = moveUp(currentY, square);
            
            // if there's no value, then update current coordinates and place a current value there
            if (square.getValue(tempX, tempY) == 0) {
                currentX = tempX;
                currentY = tempY;
                square.setValue(currentX, currentY, currentValue);
            
            // if there's already some value there, then move one row down, update current coordinates and place current value there
            } else {
                currentY = moveDown(currentY, square);
                square.setValue(currentX, currentY, currentValue);
            }
        }

        return square;
    }

    // helper function to move one row up
    private int moveUp(int y, MagicSquare square) {
        if (y - 1 < 0) {
            return square.getHeight() - 1;
        } else {
            return y - 1;
        }
    }

    // helper function to move one column right
    private int moveRight(int x, MagicSquare square) {
        if (x + 1 >= square.getWidth()) {
            return 0;
        } else {
            return x + 1;
        }
    }

    // helper function to move on row down
    private int moveDown(int y, MagicSquare square) {
        if (y + 1 >= square.getHeight()) {
            return 0;
        } else {
            return y + 1;
        }
    }

}
