class Player {
    var name = "madrigal"
        get() = field.capitalize()
        private set(value) {
            field = value.trim() //trim刪除傳入值的前後空格
        }
    var healthPoints = 89
    var isBlessed = true
    private val isImmortal = false

    fun castFireball(numFireballs:Int =2)=
        println("一杯Fireball酒應運而生。(x$numFireballs)")
}