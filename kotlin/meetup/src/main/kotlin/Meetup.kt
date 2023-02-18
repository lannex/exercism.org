import java.time.DayOfWeek
import java.time.LocalDate

class Meetup(private val month: Int, private val year: Int) {
    private val date: LocalDate = LocalDate.of(year, month, 1)

    fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate =
        generateSequence(date) { it.plusDays(1) }
            .take(date.lengthOfMonth())
            .filter { it.dayOfWeek == dayOfWeek }
            .let { days ->
                when (schedule) {
                    MeetupSchedule.LAST -> days.last()
                    MeetupSchedule.TEENTH -> days.first { it.dayOfMonth > 12 }
                    else -> days.elementAt(schedule.ordinal)
                }
            }
}
