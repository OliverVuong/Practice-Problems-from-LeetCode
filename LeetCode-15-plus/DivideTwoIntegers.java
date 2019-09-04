public class DivideTwoIntegers{
    public static int divide(int dividend, int divisor) {
        int additionCounter = 0;
        int partialSum = 0;
        int absDivisor = (divisor > 0) ? divisor : -divisor;
        int absDividend = (dividend > 0) ? dividend : -dividend;
        int signModifier = (dividend < 0 ^ divisor < 0) ? -1 : 1;

        int[] divisorCount = new int[31];
        int[] countAmountMap = new int[31];

        divisorCount[0] = 1;
        countAmountMap[0] = absDivisor;

        int i = 0;

        //populate countToAmountMap
        while (i < 30 && countAmountMap[i] < absDividend){

            divisorCount[i+1] = divisorCount[i] + divisorCount[i];
            countAmountMap[i+1] = countAmountMap[i] + countAmountMap[i];
            i++;
        }

        while ( i >= 0) {
            if (partialSum + countAmountMap[i] <= absDividend ){
                partialSum += countAmountMap[i];
                additionCounter += divisorCount[i];
            } else {
                i--;
            }
        }

        return (signModifier == 1) ? additionCounter : -additionCounter;
    }

    public static int divide2(int dividend, int divisor) {
        int additionCounter = 0;
        int partialSum = 0;
        int absDivisor = (divisor > 0) ? divisor : -divisor;
        int absDividend = (dividend > 0) ? dividend : -dividend;
        int signModifier = (dividend < 0 ^ divisor < 0) ? -1 : 1;

        while (partialSum <= absDividend - absDivisor){
            partialSum += absDivisor;
            additionCounter++;
        }

        return signModifier * additionCounter;
    }

    public static void test(){
        System.out.println(divide(1,1));
    }
}