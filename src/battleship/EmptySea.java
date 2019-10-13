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
        return  false;
    }

    @Override
    public String toString(){
        return ".";
    }

}
