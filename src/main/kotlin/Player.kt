class Player {
    val name = "madrigal"
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }
    fun castFireball(numFireballs:Int =2)=
        println("一杯Fireball酒應運而生。(x$numFireballs)")
}