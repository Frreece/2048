/* 
*
*  A class representing the board in which the 2048
*  Game takes place. Keeps track of the board and
*  Receives the player's input to control the board.
*
*/

public class Main {

    public static void main(String[] args) {
        // Initializes the starting board.
        int[][] x = new int[4][4];

        Grid start = new Grid(x);

        String output = "";
        int moveCount = 0;
        // The board starts with two random numbers at random positions
        start.addRandom(start.getBoard());
        start.addRandom(start.getBoard());

        boolean fullBoard = false;
        

        if (start.tiles(start.getBoard()) == 0) {
            fullBoard = true;
        }

        //Variables to store if the game is over or not.
        boolean gameOn = true;
        boolean gameWon = false;
        boolean gameLost = false;

        output = start.toString(start.getBoard());
        System.out.print(output);

        PennDraw.setPenColor(PennDraw.BLACK);
        // While loop that keeps the game running until the game is won or lost. loop
        // Checks for if letter is pressed to do a corresponding move. Always Checks
        // for if the game is won.
        while (gameOn) {
            start.drawBoard(start.getBoard());
            int count = 0;
            if (PennDraw.hasNextKeyTyped()) {
                PennDraw.clear(PennDraw.WHITE);
                char letterPressed = PennDraw.nextKeyTyped();
                if (letterPressed == 'w') {
                    if (start.possibleUp(start.getBoard())) {
                        start.moveeUp(start.getBoard());
                        start.drawBoard(start.getBoard());
                        moveCount++;
                    }
                } else if (letterPressed == 'a') {
                    if (start.possibleLeft(start.getBoard())) {
                        start.moveeLeft(start.getBoard());
                        start.drawBoard(start.getBoard());
                        moveCount++;
                    }
                } else if (letterPressed == 's') {
                    if (start.possibleDown(start.getBoard())) {
                        start.moveeDown(start.getBoard());
                        start.drawBoard(start.getBoard());
                        moveCount++;
                    }
                } else if (letterPressed == 'd') {
                    if (start.possibleRight(start.getBoard())) {
                        start.moveeRight(start.getBoard());
                        start.drawBoard(start.getBoard());
                        moveCount++;
                    }
                }
                if (start.gameWon(start.getBoard())) {
                    gameWon = true;
                    System.out.print(gameWon);
                    gameOn = false;
                }
            }
            // checks if there are anymore moves, if so, it ends the game loop.
            if (start.gameLost(start.getBoard())) {
                gameLost = true;
                gameOn = false;
            }
            // Draws winning screen if the game has been won.
            if (gameWon) {
                PennDraw.clear(PennDraw.WHITE);
                PennDraw.setFontSize(64);
                PennDraw.text(.5, .5, "Game Won! in" + "\n" + moveCount);
            }
            // Draws the losing screen if the game has been lost.
            if (gameLost) {
                PennDraw.clear(PennDraw.WHITE);
                PennDraw.setFontSize(64);
                PennDraw.text(.5, .5, "Game Lost in" + "\n" + moveCount);
            }
        }
    }  
}