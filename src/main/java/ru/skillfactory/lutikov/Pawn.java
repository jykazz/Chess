package ru.skillfactory.lutikov;

public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int fromLine, int fromColumn, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        int rowDiff = Math.abs(toLine - fromLine);
        int colDiff = Math.abs(toColumn - fromColumn);

        if (getColor().equals("White")) {
            if (rowDiff == 1 && colDiff == 0) {
                return true;
            } else if (rowDiff == 2 && colDiff == 0 && fromLine == 1) {
                return chessBoard.board[fromLine + 1][fromColumn] == null;
            }
        } else if (getColor().equals("Black")) {
            if (rowDiff == 1 && colDiff == 0) {
                return true;
            } else if (rowDiff == 2 && colDiff == 0 && fromLine == 6) {
                return chessBoard.board[fromLine - 1][fromColumn] == null;
            }
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}

