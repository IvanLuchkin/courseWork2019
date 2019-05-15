public class EvenSearch {
    private FunctionInterpreter f;

    EvenSearch(FunctionInterpreter func) {
        f = func;
    }

    double findMin(double a, double b, double e) {
        double x = a;
        double xPrev = a;
        while (x <= b) {
            x += e;
            if (Math.abs(x) <= Math.abs(xPrev)) {
                xPrev += e;
            } else break;
        }
        return x;
    }

    double findMax(double a, double b, double e) {
        double x = a;
        double xPrev = a;
        while (x <= b) {
            x += e;
            if (Math.abs(x) >= Math.abs(xPrev)) {
                xPrev += e;
            } else break;
        }
        return x;
    }
}
