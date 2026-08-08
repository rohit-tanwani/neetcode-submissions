class Solution {
    public boolean isValidSudoku(char[][] board) {
        return checkForRow(board) && checkForColumns(board) && checkForBox(board);
    }

    public boolean checkForRow(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            int[] nums = new int[9];
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] != '.' && nums[board[i][j] - '1'] != 0) {
                    return false;
                }
                else if(board[i][j] != '.') {
                    nums[board[i][j] - '1']++;
                }

            }
        }
        return true;
    }

    public boolean checkForColumns(char[][] board) {
        for(int i = 0; i < board.length; i++) {
             int[] nums = new int[9];
            for(int j = 0; j < board[i].length; j++) {
                if(board[j][i] != '.' && nums[board[j][i] - '1'] != 0) {
                    return false;
                }
                else if(board[j][i] != '.') {
                    nums[board[j][i] - '1']++;
                }
            }
        }
        return true;
    }

    public boolean checkForBox(char[][] board) {
        int boxSize = 3;
        for(int i = 0; i < board.length; i+=boxSize) {
            for(int j = 0; j < board[i].length; j+=boxSize) {
                int[] nums = new int[9];

                for(int k = 0; k < boxSize; k++) {
                    for(int l = 0; l < boxSize; l++) {
                        if(board[i+k][j+l] != '.' && nums[board[i+k][j+l] - '1'] != 0) {
                            return false;
                        }
                        else if(board[i+k][j+l] != '.') {
                            nums[board[i+k][j+l] - '1']++;
                        }
                    }
                }
            }
        }

        return true;
    }
}
