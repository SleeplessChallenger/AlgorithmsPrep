class Solution {
    /*
    * each `n` number from n * n is not prime

    1 2 3 4 5 6 7 8 9 10 11 12 13
    1 - not prime
    2 = prime
    3 = prime
    4 - 2 * 2
    5 = prime
    6 - 2 * 2 + 2 (each 2nd)
    7 = prime
    8 - 6 + 2 (each second)
    9 - 3 * 3 - each 3rd number from 3*3 is not prime
    */
    public int countPrimes(int n) {
        boolean[] primes = new boolean[Math.max(n,2)]; // default is false
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        // square of num is enough
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (primes[i] == false) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                primes[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            count += (primes[i] == false) ? 0 : 1;
        }

        return count;
    }

}
