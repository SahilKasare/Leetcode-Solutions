class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            int count = 0;
            int divSum = 0;

            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    int d1 = i;
                    int d2 = num / i;

                    count++;
                    divSum += d1;

                    if (d1 != d2) {
                        count++;
                        divSum += d2;
                    }
                }
            }

            if (count == 4) {
                sum += divSum;
            }
        }
        return sum;
    }
}
