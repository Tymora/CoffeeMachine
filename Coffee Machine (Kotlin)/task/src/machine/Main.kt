package machine


fun main() {
    val coffeeMachine = CoffeeMachine()
    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        when (readln()) {
            "buy" -> coffeeMachine.buy()
            "fill" -> coffeeMachine.fill()
            "take" -> coffeeMachine.take()
            "remaining" -> coffeeMachine.status()
            "exit" -> break
        }
    }
}

class CoffeeMachine {

    var water = 400
    var milk = 540
    var beans = 120
    var cups = 9
    var money = 550

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when (readln()) {
            "1" -> {
                if (water < 250 || beans < 16 || cups == 0) {
                    println("I have enough resources, making you a coffee!")
                } else {
                    water-= 250
                    beans -= 16
                    cups -= 1
                    money += 4
                }
            }
            "2" -> {
                if (water < 350 || milk < 75 || beans < 20 || cups == 0) {
                    println("I have enough resources, making you a coffee!")
                } else {
                    water -= 350
                    milk -= 75
                    beans-= 20
                    cups -= 1
                    money += 7
                }
            }
            "3" -> {
                if (water < 200 || milk < 100 || beans < 12 || cups == 0) {
                    println("I have enough resources, making you a coffee!")
                } else {
                    water -= 200
                    milk -= 100
                    beans-= 12
                    cups -= 1
                    money += 6
                }
            }
            "back" -> return

        }
    }

    fun fill() {
        println("Write how many ml of water you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        beans += readln().toInt()
        println("Write how many disposable cups you want to add:")
        cups += readln().toInt()
    }

    fun take() {
        println("I gave you $$money")
        money = 0
    }


    fun status() {
        println(
            "The coffee machine has:\n" +
                    "$water ml of water\n" +
                    "$milk ml of milk\n" +
                    "$beans g of coffee beans\n" +
                    "$cups disposable cups\n" +
                    "$$money of money"
        )
    }
}

