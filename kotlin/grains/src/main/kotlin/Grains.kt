import java.math.BigInteger

object Board {

    fun getGrainCountForSquare(number: Int): BigInteger {
        require(number in 1..64)
        return BigInteger.TWO.pow(number - 1)
    }

    fun getTotalGrainCount(): BigInteger {
        return (1..64)
            .map(::getGrainCountForSquare)
            .fold(BigInteger.ZERO) { acc, i -> acc + i }
    }
}
