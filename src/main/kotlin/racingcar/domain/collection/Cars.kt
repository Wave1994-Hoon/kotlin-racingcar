package racingcar.domain.collection

import racingcar.domain.Car

class Cars(
    private val cars: List<Car>
) {
    fun run() {
        cars.forEach(Car::run)
    }

    fun getPosition(): List<Int> {
        return cars.map { it.position }
    }

    fun getCollection(): List<Car> {
        return cars
    }
}
