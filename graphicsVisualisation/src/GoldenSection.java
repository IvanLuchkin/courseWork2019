class GoldenSection {
    private CoordinatesCalculator f;
    public GoldenSection(CoordinatesCalculator func) {
        f = func;
    }

    final double PHI = (1 + Math.sqrt(5)) / 2;

    double findMin(double a, double b, double e) {
        double x1, x2;
        while (true){
            x1 = b - (b - a) / PHI;
            x2 = a + (b - a) / PHI;
            if (f.alg(x1) >= f.alg(x2))
                a = x1;
            else
                b = x2;
            if (Math.abs(b - a) < e)
                break;
        }
        return (a + b) / 2;
    }

    double findMax(double a, double b, double e) {
        double x1, x2;
        while (true){
            x1 = b - (b - a) / PHI;
            x2 = a + (b - a) / PHI;
            if (f.alg(x1) <= f.alg(x2))
                a = x1;
            else
                b = x2;
            if (Math.abs(b - a) < e)
                break;
        }
        return (a + b) / 2;
    }

}
