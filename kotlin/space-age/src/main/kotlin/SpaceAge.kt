import kotlin.math.roundToLong

class SpaceAge(private val seconds: Long) {
    private enum class Planet(val orbitalPeriod: Double) {
        EARTH(1.0),
        MERCURY(0.2408467),
        VENUS(0.61519726),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.79132);

        fun calcEarthYears(sec: Long): Double =
            (sec / (60 * 60 * 24 * 365.25 * orbitalPeriod))
                .times(100)
                .roundToLong()
                .div(100.0)
    }

    fun onEarth(): Double = Planet.EARTH.calcEarthYears(seconds)
    fun onMercury(): Double = Planet.MERCURY.calcEarthYears(seconds)
    fun onVenus(): Double = Planet.VENUS.calcEarthYears(seconds)
    fun onMars(): Double = Planet.MARS.calcEarthYears(seconds)
    fun onJupiter(): Double = Planet.JUPITER.calcEarthYears(seconds)
    fun onSaturn(): Double = Planet.SATURN.calcEarthYears(seconds)
    fun onUranus(): Double = Planet.URANUS.calcEarthYears(seconds)
    fun onNeptune(): Double = Planet.NEPTUNE.calcEarthYears(seconds)
}
