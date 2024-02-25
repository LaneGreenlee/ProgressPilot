package lib;

public enum Grade {
    A, B_PLUS, B, C_PLUS, C, D_PLUS, D, F, W, WF, I;

    @Override
    public String toString() {
        switch (this) {
            case B_PLUS:
                return "B+";
            case C_PLUS:
                return "C+";
            case D_PLUS:
                return "D+";
            default:
                return super.toString();
        }
    }
}
