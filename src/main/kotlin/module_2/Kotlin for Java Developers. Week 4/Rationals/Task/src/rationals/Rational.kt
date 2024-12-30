package rationals

import java.math.BigInteger

class Rational private constructor(
    private val numerator: BigInteger,
    private val denominator: BigInteger
) : Comparable<Rational> {

    init {
        require(denominator != BigInteger.ZERO) { "Denominator cannot be zero" }
    }

    private val normalized: Pair<BigInteger, BigInteger> by lazy {
        val gcd = numerator.gcd(denominator)
        val sign = if (denominator < BigInteger.ZERO) BigInteger.valueOf(-1) else BigInteger.ONE
        Pair(numerator / gcd * sign, denominator.abs() / gcd)
    }

    val normalizedNumerator: BigInteger get() = normalized.first
    val normalizedDenominator: BigInteger get() = normalized.second

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Rational) return false
        return normalizedNumerator == other.normalizedNumerator &&
                normalizedDenominator == other.normalizedDenominator
    }

    override fun hashCode(): Int {
        return normalizedNumerator.hashCode() * 31 + normalizedDenominator.hashCode()
    }

    override fun toString(): String {
        return if (normalizedDenominator == BigInteger.ONE) {
            "$normalizedNumerator"
        } else {
            "$normalizedNumerator/$normalizedDenominator"
        }
    }

    operator fun plus(other: Rational): Rational {
        val newNumerator =
            normalizedNumerator * other.normalizedDenominator + other.normalizedNumerator * normalizedDenominator
        val newDenominator = normalizedDenominator * other.normalizedDenominator
        return Rational(newNumerator, newDenominator)
    }

    operator fun minus(other: Rational): Rational {
        val newNumerator =
            normalizedNumerator * other.normalizedDenominator - other.normalizedNumerator * normalizedDenominator
        val newDenominator = normalizedDenominator * other.normalizedDenominator
        return Rational(newNumerator, newDenominator)
    }

    operator fun times(other: Rational): Rational {
        val newNumerator = normalizedNumerator * other.normalizedNumerator
        val newDenominator = normalizedDenominator * other.normalizedDenominator
        return Rational(newNumerator, newDenominator)
    }

    operator fun div(other: Rational): Rational {
        val newNumerator = normalizedNumerator * other.normalizedDenominator
        val newDenominator = normalizedDenominator * other.normalizedNumerator
        return Rational(newNumerator, newDenominator)
    }

    operator fun unaryMinus(): Rational {
        return Rational(-normalizedNumerator, normalizedDenominator)
    }

    override fun compareTo(other: Rational): Int {
        return (normalizedNumerator * other.normalizedDenominator).compareTo(
            other.normalizedNumerator * normalizedDenominator
        )
    }

    operator fun contains(range: ClosedRange<Rational>): Boolean {
        return this >= range.start && this <= range.endInclusive
    }

    companion object {
        fun from(numerator: BigInteger, denominator: BigInteger): Rational {
            return Rational(numerator, denominator)
        }
    }
}

infix fun Int.divBy(denominator: Int): Rational {
    return Rational.from(this.toBigInteger(), denominator.toBigInteger())
}

infix fun Long.divBy(denominator: Long): Rational {
    return Rational.from(this.toBigInteger(), denominator.toBigInteger())
}

infix fun BigInteger.divBy(denominator: BigInteger): Rational {
    return Rational.from(this, denominator)
}

fun String.toRational(): Rational {
    val parts = this.split("/")
    return when (parts.size) {
        1 -> Rational.from(parts[0].toBigInteger(), BigInteger.ONE)
        2 -> Rational.from(parts[0].toBigInteger(), parts[1].toBigInteger())
        else -> throw IllegalArgumentException("Invalid rational number format")
    }
}


fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}