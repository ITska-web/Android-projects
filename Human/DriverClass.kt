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