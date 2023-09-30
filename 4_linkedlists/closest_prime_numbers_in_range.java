class Solution {
    /*
    * create sieve with `right` as border
    * traverse and put false in required places
    * put only primes in container
    * traverse over array with primes:
        - skip 0 index
        - select currIdx and currIdx - 1

    * left = 10, right = 19
    */
    public int[] closestPrimes(int left, int right) {
        if (right < 2) {
            return new int[] {-1,-1};
        }

        boolean[] primes = new boolean[right + 1]; // 19 + 1 as exclusive
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        // i = 2
        for (int i = 2; i <= Math.sqrt(right); i++) {
            if (primes[i] == false) {
                continue;
            }
            // 4; 4 + 2; 6 + 2
            // 9; 9 + 2
            for (int j = i * i; j <= right; j += i) {
                primes[j] = false;
            }
        }

        List<Integer> onlyPrimes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (primes[i] == true) {
                onlyPrimes.add(i);
            }
        }

        int[] res = new int[] {-1,-1};
        int min = Integer.MAX_VALUE;

        /* min diff + min values*/
        int idx = -1;
        for (int i = 0; i < onlyPrimes.size(); i++) {
            if (idx == -1) {
                idx = i;
            } else if (onlyPrimes.get(i) - onlyPrimes.get(idx) < min) {
                res[0] = onlyPrimes.get(idx);
                res[1] = onlyPrimes.get(i);
                min = res[1] - res[0];
            }
            idx = i;
        }

        return res;
    }
}