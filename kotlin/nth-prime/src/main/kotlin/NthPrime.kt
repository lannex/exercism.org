object Prime {
    fun nth(n: Int): Int {
        require(n > 0) { "There is no zeroth prime." }

        return generateSequence(2) { it + 1 }
            .filter(::isPrime)
            .take(n)
            .last()
    }

    /**
     * 1. divide the input in half.
     * 2. iterate over that value.
     * 3. if there are no zeros in the remainder, the input is a prime number.
     */
    private fun isPrime(n: Int): Boolean {
        // .all { n % it != 0 } == .none { n % it == 0 }
        return (2..n / 2).all { n % it != 0 }
    }
}
