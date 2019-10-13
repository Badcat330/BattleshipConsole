package battleship;

class EmptySea extends Ship{

    EmptySea() {
        length = 1;
    }

    @Override
    boolean isSunk(){
        return false;
    }

    @Override
    boolean shootAt(int row, int column){
        if(row < 0 || row > 9 || column < 0 || column > 9)
            throw new IndexOutOfBoundsException();
        hit[0] = true;
        return  false;
    }

    @Override
    public String toString(){
        if(hit[0])
            return "-";
        return ".";
    }

}
