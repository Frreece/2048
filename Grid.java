/* 
* A class that holds the entirety of the grid. The grid, or board, is a 4x4 integer 
* array that represents all numbers on the board.
*
*
*/
public class Grid {
    
    private int[][] board;

    public Grid(int[][] board) {
        this.board = new int[4][4];
        this.board = board;
    }
    // Getter method for the board.

    public int[][] getBoard() {

        return board;
    }
    // Erases the board.
    public int[][] clearBoard(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = 0;
            }
        }

        return board;
    }
    // Prints the board to check values.
    public int printBoard(int[][] board) {
        int x = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                x = board[i][j];
            }
        }

        return x;
    }
    // Method to add a random value to a random position on the board.
    public void addRandom(int[][] board) {
        int piece1Val = 0;

        int piece1Row = (int) (100 * Math.random() % 4);
        int piece1Col = (int) (100 * Math.random() % 4);

        if (Math.random() < .5) {
            piece1Val = 2;
        } else {
            piece1Val = 4;
        }
        if (board[piece1Row][piece1Col] == 0) {
            board[piece1Row][piece1Col] = piece1Val;
        } else {
            addRandom(board);
        }

    }
    // Gives a string representation of the board.
    public String toString(int[][] board) {
        String output = "";

        for (int i = 0; i < 4; i++) {
            output += "\n";
            for (int j = 0; j < 4; j++) {
                output += board[i][j];
            }
        }
        
        return output;
    }
    // Checks to see if it is possible to move upward.

    public boolean possibleUp(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i > 0 && (board[i][j] != 0 && (board[i][j] == board[i - 1][j] || 
                board[i - 1][j] == 0))) {
                    return true;
                }
            }
        }

        return false;
    }
    // Checks to see if it is possible to move downward.
    public boolean possibleDown(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i < 3 && (board[i][j] != 0 && (board[i][j] == board[i + 1][j] || 
                board[i + 1][j] == 0))) {
                    return true;
                }
            }
        }

        return false;
    }

    // Checks to see if it is possible to move to the left.
    public boolean possibleLeft(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j > 0 && (board[i][j] != 0 && (board[i][j] == board[i][j - 1] || 
                board[i][j - 1] == 0))) {
                    return true;
                }
            }
        }
        return false;
    }
    // Checks to see if it is possible to move to the right.
    public boolean possibleRight(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j < 3 && (board[i][j] != 0 && (board[i][j] == board[i][j + 1] || 
                board[i][j + 1] == 0))) {
                    return true;
                }
            }
        }

        return false;
    }

    // Moves pieces up by iterating forwards through the board to combine pieces. 
    // Simultaneously, it iterates backwards to move the pieces
    public int[][] moveeUp(int[][] board) {
        int tiles = 0;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int k = 3 - i;
                if (i < 3 && (board[i][j] == board[i + 1][j] || board[i][j] == 0)) {
                    board[i][j] += board[i + 1][j];
                    board[i + 1][j] = 0;
                } if (i > 0 && board[i][j] == board[i - 1][j]) {
                    board[i - 1][j] += board[i][j];
                    board[i][j] = 0;

                } if (k > 0 && board[k][j] != 0 && (board[k - 1][j] == 0 && 
                    board[k - 1][j] != board[k][j])) {
                    board[k - 1][j] = board[k][j];
                    board[k][j] = 0;
                } 
            }
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0) {
                    tiles++;
                }
            }
        }
        if (tiles != 0) {
            addRandom(board);
        }

        return board;
    }
    // Moves pieces up by iterating forwards through the board to combine pieces. 
    // Simultaneously, it iterates backwards to move the pieces
    public int[][] moveeLeft(int[][] board) {
        int tiles = 0;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int k = 3 - j;
                if (j < 3 && (board[i][j] == board[i][j + 1] || board[i][j] == 0)) {
                    board[i][j] += board[i][j + 1];
                    board[i][j + 1] = 0;
                } if (j > 0 && board[i][j] == board[i][j - 1]) {
                    board[i][j - 1] += board[i][j];
                    board[i][j] = 0;

                } if (k > 0 && board[i][k] != 0 && (board[i][k - 1] == 0)) {
                    board[i][k - 1] = board[i][k];
                    board[i][k] = 0;
                } 
            }
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0) {
                    tiles++;
                }
            }
        }
        if (tiles != 0) {
            addRandom(board);
        }

        return board;
    }
    // Moves pieces up by iterating forwards through the board to combine pieces. 
    // Simultaneously, it iterates backwards to move the pieces
    public int[][] moveeRight(int[][] board) {
        int tiles = 0;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j >= 0; j--) {
                int k = 3 - j;
                if (j > 0 && (board[i][j] == board[i][j - 1] || board[i][j] == 0)) {
                    board[i][j] += board[i][j - 1];
                    board[i][j - 1] = 0;
                } if (j < 3 && board[i][j] == board[i][j + 1]) {
                    board[i][j + 1] += board[i][j];
                    board[i][j] = 0;

                } if (k < 3 && board[i][k] != 0 && (board[i][k + 1] == 0)) {
                    board[i][k + 1] = board[i][k];
                    board[i][k] = 0;
                } 
            }
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0) {
                    tiles++;
                }
            }
        }
        if (tiles != 0) {
            addRandom(board);
        }

        return board;
    }
    // Moves pieces up by iterating forwards through the board to combine pieces. 
    // Simultaneously, it iterates backwards to move the pieces
    public int[][] moveeDown(int[][] board) {
        int tiles = 0;
        
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                int k = 3 - i;
                if (i > 0 && (board[i][j] == board[i - 1][j] || board[i][j] == 0)) {
                    board[i][j] += board[i - 1][j];
                    board[i - 1][j] = 0;
                } if (i < 3 && board[i][j] == board[i + 1][j]) {
                    board[i + 1][j] += board[i][j];
                    board[i][j] = 0;
                } if (k < 3 && board[k][j] != 0 && (board[k + 1][j] == 0 && 
                    board[k + 1][j] != board[k][j])) {
                    board[k + 1][j] = board[k][j];
                    board[k][j] = 0;
                } 
            }
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0) {
                    tiles++;
                }
            }
        }
        if (tiles != 0) {
            addRandom(board);
        }

        return board;
    }

    // method to draw the tiles. Uses helper method DrawBoard that finds at what 
    // position to place the tiles as well as the value of the respective tiles.
    public void drawTile(double xPos, double yPos, int value) {
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.setFontSize(64);

        PennDraw.text(xPos, yPos, Integer.toString(value));

    }
    // Method to draw the board. Iterates through the board to find every value and 
    // gives each of them a position.
    public void drawBoard(int[][] board) {
        double xPos = 0.125;
        double yPos = 0.875;
        for (int i = 0; i < 4; i++) {
            xPos = 0.17;

            if (i > 0) {
                yPos -= .25;
            }
        for (int j = 0; j < 4; j++) {
            if (board[i][j] != 0) {
                drawTile(xPos, yPos, board[i][j]);
            }
            xPos += .25;
            }
        }
    }
    // Counts the tiles in the board.
    public int tiles(int[][] board) {
        int freeTiles = 16;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    freeTiles--;
                }
            }
        }

        return freeTiles;
    }
    // Checks to see if the player has reached the target value, thus ending the game
    public boolean gameWon(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 2048) {
                    System.out.print("Game Won");
                    return true;
                }
            }
        }

        return false;
    }
    // Checks if there are possible moves left. If not, it returns false.
    public boolean gameLost(int[][] board) {
        return !possibleDown(board) && !possibleLeft(board) && !possibleRight(board) 
        && !possibleUp(board);
    }
}