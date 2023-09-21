package programmers_real.level2;

public class TicTacToe {
    public static void main(String[] args) {
        String[] board = {"OOO", "...", "XXX"};
        System.out.println(new TicTacToeSolution().solution(board));
    }
}

class TicTacToeSolution {
    public int solution(String[] board) {
        // 조건 1 : O,X 둘 다 승리하면 안됨. 반드시 한쪽만 승리한 형태여야 게임이 성립함
        // 조건 2 : O,X 의 수가 맞아야 함. 그리고 여기서 O가 선공이기 때문에, O가 하나 더 많거나, O, X의 수가 같아야 한다.

        // 3x3이면 그냥 다 확인해보는 것도 괜찮을듯
        int O = 0,X = 0;
        for(int i=0; i<3; i++) {
            // 가로 방향
            if(board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)) {
                if(board[i].charAt(0) == 'O') O++;
                else if(board[i].charAt(0) == 'X') X++;
            }
            // 세로방향
            if(board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)) {
                if(board[0].charAt(i) == 'O') O++;
                else if(board[0].charAt(i) == 'X') X++;
            }
        }
        // 대각선 방향은 따로 계산하겠다.
        if(board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
            if(board[0].charAt(0) == 'O')
                O++;
            else if(board[0].charAt(0) == 'X')
                X++;
        }
        if(board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)) {
            if(board[0].charAt(2) == 'O')
                O++;
            else if(board[0].charAt(2) == 'X')
                X++;
        }

        int OCount = 0, XCount = 0;
        for(int i=0; i< board.length; i++) {
            for(int k=0; k<board[i].length(); k++) {
                if(board[i].charAt(k) == 'O')
                    OCount++;
                else if (board[i].charAt(k) == 'X')
                    XCount++;
            }
        }

        if(OCount - XCount != 0 && OCount - XCount != 1)
            return 0;

        // O가 이겼다면 OCount와 XCount가 같을 수 없음
        if(O == 1 && OCount == XCount)
            return 0;
        // X가 이겼다면 반드시 OCount와 XCount가 같아야 함
        if(X == 1 && OCount != XCount)
            return 0;
        // 두명이 동시에 이길 수 없음
        if(O == 1 && X == 1)
            return 0;
        else
            return 1;
    }
}
