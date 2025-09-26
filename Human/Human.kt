import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.Duration.Companion.seconds

fun main(){
    val petya = Human("Petya", "Ivanov", "Darevich", 444)
    val humans = listOf(
        Human("Ivan", "Petrov", "Ivanovich", 101),
        Human("Anna", "Sidorova", "Petrovna", 102),
        Human("Sergey", "Kuznetsov", "Ivanovich", 103),
        Human("Elena", "Smirnova", "Alexandrovna", 104)
    )
    petya.move()
    for (n in 1..10){
        val newX = Random.nextInt(from = 1, until = 100)
        val newY = Random.nextInt(from = 1, until = 100)
        petya.moveTo(newX, newY)
    }
    println("${petya.x}")

    var counter: Int = 10
    val name: String = ""
    println(name)
    println("Hello World!")

    val driver = Driver("Artaa", "Ertine", "Adygzyewych", 1)
    val all = humans + driver
    val threads = all.map { person -> Thread{
        repeat(10){
            person.move()
            Thread.sleep(300)
        }
    } }
    threads.forEach { it.start() }
    threads.forEach { it.join() }
}