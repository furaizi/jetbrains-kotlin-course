package module_3.assignment.taxi_park.src.taxipark

import kotlin.math.floor

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> = allDrivers.filter {
    driver -> trips.none{ trip -> trip.driver == driver}
}.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> = allPassengers.filter { passenger ->
    trips.count { trip -> passenger in trip.passengers } >= minTrips
}.toSet()


/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> = allPassengers.filter {
    passenger -> trips.filter { it.passengers.contains(passenger) }
        .count { trip -> trip.driver == driver } > 1
}.toSet()


/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> = allPassengers.filter {
    passenger -> val tripsWithThisPassenger = trips.filter { passenger in it.passengers }
                tripsWithThisPassenger
                        .count { it.discount != null } >
                tripsWithThisPassenger
                        .count { it.discount == null }
}.toSet()

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    return try {
        trips.map { it.duration }
            .groupBy {
                val start = it / 10 * 10
                val end = start + 9
                start..end
            }
            .maxBy { (_, group) -> group.size }
            ?.key
    } catch (e: NoSuchElementException) {
        null
    }
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    val oneFifth = floor(allDrivers.size * 0.2).toInt()

    val top20percent = allDrivers.associateWith { driver ->
        trips.filter { it.driver == driver }
            .sumOf { it.cost }
    }
        .entries
        .sortedByDescending { it.value }
        .take(oneFifth)

    val totalSum = trips.sumOf { it.cost }
    val top20PercentSum = top20percent.sumOf { it.value }

    return top20PercentSum / totalSum >= 0.8
}

