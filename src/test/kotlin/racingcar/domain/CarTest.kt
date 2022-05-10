package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.utils.RandomGenerator

class CarTest : DescribeSpec({
    describe("run 메서드") {
        context("랜덤 값이 4 이상일 때") {
            class TestRandom : RandomGenerator {
                override fun generateNumberWithin(range: IntRange): Int {
                    return (4..9).random()
                }
            }

            it("앞으로 이동한다.") {
                val car = Car(4, 0..9, TestRandom())

                car.position shouldBe 0

                car.run()

                car.position shouldBe 1
            }
        }

        context("랜덤 값이 3 이하일 때") {
            class TestRandom : RandomGenerator {
                override fun generateNumberWithin(range: IntRange): Int {
                    return (0..3).random()
                }
            }

            it("앞으로 이동하면 안된다.") {
                val car = Car(4, 0..9, TestRandom())

                car.position shouldBe 0

                car.run()

                car.position shouldBe 0
            }
        }
    }
})
