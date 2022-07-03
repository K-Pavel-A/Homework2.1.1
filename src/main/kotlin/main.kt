val cardType = "Vk Pay"
val amountPerMonth = 80000_00
val transferAmount = 12_00
const val masterMaestroComission = 0.006
const val visaMirComission = 0.0075

fun main(){
    printResult()
}

fun transfer(cardType: String, amountPerMonth: Int, transferAmount:Int): Int{
    val amount = when(cardType) {
        "Mastercard", "Maestro" -> {
            transferAmount - calculateComission(cardType, amountPerMonth, transferAmount)
        }
        "Visa","Мир" -> {
            if (transferAmount > 35_00) transferAmount - calculateComission(cardType, amountPerMonth, transferAmount) else 0
        }
        else -> {
            transferAmount
        }
    }
    return amount
}

fun calculateComission (cardType: String, amountPerMonth: Int, transferAmount: Int) : Int{
    val userComission = when(cardType){
        "Mastercard", "Maestro" -> {
            if (amountPerMonth < 75_000_00) 0 else (transferAmount * masterMaestroComission + 20_00).toInt()
        }
        "Visa","Мир" -> {
            if (transferAmount < 35_00) 35_00 else (transferAmount * visaMirComission).toInt()
        }
        else -> {
            0
        }
    }
    return userComission
}

fun printResult(){
    println("Комиссия составит: ${calculateComission(cardType, amountPerMonth, transferAmount)} коп.")
    println("Перевод составит: ${transfer(cardType, amountPerMonth, transferAmount)/100} руб. ${(transfer(cardType, amountPerMonth, transferAmount)%100)} коп.")
}