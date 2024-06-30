import java.util.Map;

public class Result {


    private static int divide(int dividend, int divisor) throws DivisioByZeroException {
        if (divisor == 0) throw new DivisioByZeroException("Division by zero impossible");
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend < divisor) return 0;
        int divisorSum = 0;
        long iterations = 0;
        while (true) {
            divisorSum += divisor;
            iterations++;
            if (divisorSum + divisor > dividend) {
                if (isNegative) iterations = -iterations;
                if (iterations < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else if (iterations > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                return (int) iterations;
            }

        }

    }

    public static void main(String[] args) {
        try {
            System.out.println(divide(100, -1));
            System.out.println(divide(7, -3));
            System.out.println(divide(-200, -2));
            System.out.println(divide(-500, 2));
            System.out.println(divide(-10, 3));
            System.out.println(divide(7, -3));


        } catch (DivisioByZeroException e) {
            System.out.println(e.getMessage());
        }

    }
}
