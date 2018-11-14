public class TokenPass {
    int[] board;
    int currentPlayer;
    public TokenPass(int playerCount){
        board = new int[playerCount];
        for(int i = 0;i<playerCount;i++){
            board[playerCount] = (int)(Math.random()*10) + 1;
        }
        currentPlayer = (int)(Math.random()*playerCount);
    }
    public void distributeTokens(){
        int nextPlayer = currentPlayer;
        int tokens = board[currentPlayer];
        board[currentPlayer] = 0;
        while(tokens > 0){
            nextPlayer = (nextPlayer + 1) % board.length;
            board[nextPlayer] ++;
            tokens --;
        }

    }
    public void nextPlayer(){
           currentPlayer++;
           if(currentPlayer == board.length){
               currentPlayer = 0;
           }

    }
    public String printBoard(){
        String result = "";
        for(int i = 0;i < board.length; i++){
            result += " Player " + i + ": " + board[i];
        }
        return result;
    }
    public int gameOver(){
        int winningPlayer = -1;
        for(int i = 0; i < board.length;i++){
            if(board[i] == 0){
                winningPlayer = i;
            }
        }
        return winningPlayer;
    }
}
