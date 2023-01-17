import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class Gigasecond(private val newDate: LocalDateTime) {
    constructor(newDate: LocalDate) : this(LocalDateTime.of(newDate, LocalTime.MIN))

    var date: LocalDateTime = newDate.plusSeconds(1000000000)
}
