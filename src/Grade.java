package lib;

public enum Grade {
    A, B_PLUS, B, C_PLUS, C, D_PLUS, D, F, W, WF, I, NA;

    @Override
    public String toString() {
        switch (this) {
            case A:
                return "A";
            case B_PLUS:
                return "B+";
            case B:
                return "B";
            case C_PLUS:
                return "C+";
            case C:
                return "C";
            case D_PLUS:
                return "D+";
            case D:
                return "D";
            case F:
                return "F";
            case W:
                return "W";
            case WF:
                return "WF";
            case I:
                return "I";
            default:
                return "NA";
        }
    }
}
