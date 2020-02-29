
// importing everything needed
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*

fun main() {

        // Creating all needed variables including LocalDate variables and DateTimeFormatter
        var anotherDate = ""
        var cycles=0
        var fullMoonStarter: LocalDate = LocalDate.of(2020, 2, 8)
        var year: Int = Calendar.getInstance().get(Calendar.YEAR)
        val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")

        // Get todays date
        var today = LocalDate.now()

        // Format todays date
        var formattedToday = today.format(formatter)
        println("Today's date is: $formattedToday")

        // Starting at 2/8/2020 add 29.5 days until date is past todays date
        while(today.isAfter(fullMoonStarter))
            fullMoonStarter = fullMoonStarter.plusDays(29.5.toLong())

        // Goes back to the most recent full moon and formats it
        var lastFullMoon = fullMoonStarter.minusDays(29.5.toLong())
        var formattedLastFullMoon = lastFullMoon.format(formatter)

        // Calculates the days since the last full moon to today's date
        var daysSinceFullMoon = lastFullMoon.until(today, ChronoUnit.DAYS)

        // Calculates the days until the next full moon to today's date
        var daysToFullMoon = today.until(fullMoonStarter, ChronoUnit.DAYS)
        var formattedNextFullMoon = fullMoonStarter.format(formatter)


        println("The last full moon was: $formattedLastFullMoon that was $daysSinceFullMoon days ago")
        println("The next full moon is: $formattedNextFullMoon that is in $daysToFullMoon days")

        // Ask user if they would like to check another date
        print("Would you like to check on any other date? Y or N: ")
        anotherDate = readLine()!!.toString()

        // If and while "YES" user can enter in their own date
        while (anotherDate.equals("Y")) {
            if (anotherDate.equals("Y")) {
                var fullMoonStarter: LocalDate = LocalDate.of(2020, 2, 8)
                var userMonth = 0
                var userDay = 0
                var userYear = 0
                print("Enter Month: ")
                userMonth = readLine()!!.toInt()
                print("Enter Day: ")
                userDay = readLine()!!.toInt()
                print("Enter Year: ")
                userYear = readLine()!!.toInt()
                var userDate: LocalDate = LocalDate.of(userYear, userMonth, userDay)

                while (userDate.isAfter(fullMoonStarter))
                    fullMoonStarter = fullMoonStarter.plusDays(29.5.toLong())

                lastFullMoon = fullMoonStarter.minusDays(29.5.toLong())
                formattedLastFullMoon = lastFullMoon.format(formatter)
                daysSinceFullMoon = lastFullMoon.until(userDate, ChronoUnit.DAYS)

                daysToFullMoon = userDate.until(fullMoonStarter, ChronoUnit.DAYS)
                formattedNextFullMoon = fullMoonStarter.format(formatter)

                println("The last full moon was: $formattedLastFullMoon that was $daysSinceFullMoon days ago")
                println("The next full moon is: $formattedNextFullMoon that is in $daysToFullMoon days")

                print("Would you like to check on any other date? Y or N: ")
                anotherDate = readLine()!!.toString()
            } else
                anotherDate = "N"
        }
}