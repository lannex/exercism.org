object PrimeFactorCalculator {
    fun primeFactors(n: Int): List<Int> = primeFactors(n.toLong()).map(Long::toInt)

    fun primeFactors(n: Long): List<Long> = calcPrimeFactors(n, 2, emptyList())

    private tailrec fun calcPrimeFactors(
        number: Long,
        factor: Long,
        factors: List<Long>,
    ): List<Long> = when {
        number <= 1 -> emptyList()

        // In prime factorization, the largest prime factor is no more than the square root of the number.
        // 소인수분해에서 가장 큰 소인수는 해당 숫자의 제곱근을 넘지 않습니다.
        factor * factor > number -> factors + number

        number % factor == 0L -> calcPrimeFactors(number / factor, factor, factors + factor)

        else -> calcPrimeFactors(number, factor + 1, factors)
    }
}
