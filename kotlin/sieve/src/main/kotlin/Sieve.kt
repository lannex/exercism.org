object Sieve {
    fun primesUpTo(upperBound: Int): List<Int> =
        (2..upperBound).filter(::isPrime)

    private fun isPrime(n: Int): Boolean =
        (2..n / 2).none { n % it == 0 }
}

