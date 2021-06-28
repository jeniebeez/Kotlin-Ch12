/*習作3.6
最佳化玩家光環展示
*/

import java.lang.Math.pow
import java.lang.Math.random

fun main() {



    val player = Player()
    player.castFireball()

    val karma = (pow(random(),(110-healthPoints)/100.0)*20).toInt()//返回（random的（110-生命值/100）為幾次方(指數)的值）
    //Aura
    val auraColor = auraColor(karma)
    //Health Status
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    //Player Status
    printPlayerStatus(auraColor, isBlessed, player.name, healthStatus)
    //Drunk Status
    val numFireballs =(2..10).random()
    printDrunkStatus(numFireballs)
}

private fun printDrunkStatus(numFireballs: Int) {
    println("酒醉程度：${drunkStatus(numFireballs)}")
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("光環顏色：$auraColor" + "    走運嗎？${if (isBlessed) "是的" else "很背"}")
    println("$name $healthStatus")
}

private fun auraColor(
    karma: Int
): String =
    when (karma) {
        in (0..5) -> "紅色"
        in (6..10) -> "橘色"
        in (11..15) -> "紫色"
        in (16..20) -> "綠色"
        else -> "無光環"
    }

private fun formatHealthStatus(healthPoints: Int,
                               isBlessed: Boolean)=
    when (healthPoints) {
        100 -> "健康狀態極佳"
        in 90..99 -> "有一些小擦傷"
        in 75..89 -> if (isBlessed) {
            "雖有一些傷口，但恢復很快"
        } else {
            "有一些傷口"
        }
        in 15..74 -> "嚴重受傷"
        //顯示玩家狀態
        else -> "情況不妙"
    }

private fun drunkStatus(numFireballs:Int,
                         drunkness:Int=numFireballs* 5)=
    when (drunkness) {
        in 1..10 -> "微醺"
        in 11..20 -> "微醉"
        in 21..30 -> "醉了"
        in 31..40 -> "大醉"
        in 31..50 -> "爛醉如泥"
        else -> null
    }
