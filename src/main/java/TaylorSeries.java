import static java.lang.Math.*;

public class TaylorSeries {
    public double getArccosSeries(double x, double accuracy) {
        if (accuracy < 0 || x < -1 || x > 1) {
            throw new IllegalArgumentException();
        }

        double sum = PI / 2;
        double upperPart;
        double lowerPart;
        double step;
        for (int i = 0; ; i++) {
            upperPart = factorial(2 * i);
            lowerPart = pow(4, i) * pow(factorial(i), 2) * (2 * i + 1);
            if (x > -0.7 && x < 0.7) {
                step = (upperPart / lowerPart) * pow(x, 2 * i + 1);
            } else {
                step = (upperPart / lowerPart) * pow(sqrt(1 - x * x), 2 * i + 1);
            }
            sum -= step;
            if (abs(step) < accuracy) {
                break;
            }
        }
        if (x > -0.7 && x < 0.7) {
            return sum;
        } else {
            return (x < 0) ? PI / 2 + sum : PI / 2 - sum;
        }

    }

    private int factorial(int N) {
        return ((N == 0) ? 1 : N * factorial(N - 1));
    }
}
