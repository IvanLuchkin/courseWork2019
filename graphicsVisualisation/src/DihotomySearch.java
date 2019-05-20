class DihotomySearch {
    private FunctionInterpreter f;
    DihotomySearch(FunctionInterpreter func) {
        f = func;
    }

    double findMin(double a, double b, double e) {
        double x;
        double sigma = e / 4;
        do {
            x = (a + b) / 2;
            double l = x - sigma;
            double r = x + sigma;
            if (f.alg(l) <= f.alg(r)) {
                b = r;
            } else if (f.alg(l) > f.alg(r)) {
                a = l;
            }

        } while (Math.abs(a - b) > e);
        return x;
    }

    double findMax(double a, double b, double e) {
        double x;
        double sigma = e / 4;
        do {
            x = (a + b) / 2;
            double l = x - sigma;
            double r = x + sigma;
            if (f.alg(l) >= f.alg(r)) {
                b = r;
            } else if (f.alg(l) < f.alg(r)) {
                a = l;
            }

        } while (Math.abs(a - b) > e);
        return x;
    }
}
