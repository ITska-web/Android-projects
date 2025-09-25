import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.Duration.Companion.seconds

open class Human
{
    var name: String = ""
    var surname: String = ""
    var second_name: String = ""
    var group_number: Int = -1
    var x = 0
    var y = 0

    constructor(_name: String, _surname: String, _second: String, _gn: Int){
        name = _name
        surname = _surname
        second_name = _second
        group_number = _gn
        println("We created the Human object with name: $name")
    }

    open fun move()
    {
        val speedx = Random.nextInt(from = 1, until = 10)
        val speedy = Random.nextInt(from = 1, until = 10)
        x+=speedx
        y+=speedy
        println("$name человек прошел ($x, $y)")
    }

    fun moveTo(_toX: Int, _toY: Int)
    {
        x = _toX
        y = _toY
        println("Human is moved TO: $y  $x")
    }
}
class Driver(
    name: String,
    surname: String,
    secondName: String,
    groupNumber: Int,
    private val speedx: Int = 3,
    private val speedy: Int = 0
): Human(name, surname, secondName, groupNumber){
    override fun move(){
        x+=speedx
        y+=speedy
        println("$name водитель прошел ($x, $y)")
    }
}

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