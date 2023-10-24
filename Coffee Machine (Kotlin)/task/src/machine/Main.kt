package machine


fun main() {
    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        val coffeeMachine = CoffeeMachine()
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

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when (readln()) {
            "1" -> {
                if (Ingredients.Water.count < 250 || Ingredients.Beans.count < 16 || Ingredients.Cups.count == 0) {
                    println("I have enough resources, making you a coffee!")
                } else {
                    Ingredients.Water.count -= 250
                    Ingredients.Beans.count -= 16
                    Ingredients.Cups.count -= 1
                    Ingredients.Money.count += 4
                }
            }
            "2" -> {
                if (Ingredients.Water.count < 350 || Ingredients.Milk.count < 75 || Ingredients.Beans.count < 20 || Ingredients.Cups.count == 0) {
                    println("I have enough resources, making you a coffee!")
                } else {
                    Ingredients.Water.count -= 350
                    Ingredients.Milk.count -= 75
                    Ingredients.Beans.count -= 20
                    Ingredients.Cups.count -= 1
                    Ingredients.Money.count += 7
                }
            }
            "3" -> {
                if (Ingredients.Water.count < 200 || Ingredients.Milk.count < 100 || Ingredients.Beans.count < 12 || Ingredients.Cups.count == 0) {
                    println("I have enough resources, making you a coffee!")
                } else {
                    Ingredients.Water.count -= 200
                    Ingredients.Milk.count -= 100
                    Ingredients.Beans.count -= 12
                    Ingredients.Cups.count -= 1
                    Ingredients.Money.count += 6
                }
            }
            "back" -> return

        }
    }

    fun fill() {
        println("Write how many ml of water you want to add:")
        Ingredients.Water.count += readln().toInt()
        println("Write how many ml of milk you want to add:")
        Ingredients.Milk.count += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        Ingredients.Beans.count += readln().toInt()
        println("Write how many disposable cups you want to add:")
        Ingredients.Cups.count += readln().toInt()
    }

    fun take() {
        println("I gave you $${Ingredients.Money.count}")
        Ingredients.Money.count = 0
    }


    fun status() {
        println(
            "The coffee machine has:\n" +
                    "${Ingredients.Water.count} ml of water\n" +
                    "${Ingredients.Milk.count} ml of milk\n" +
                    "${Ingredients.Beans.count} g of coffee beans\n" +
                    "${Ingredients.Cups.count} disposable cups\n" +
                    "$${Ingredients.Money.count} of money"
        )
    }
}

enum class Ingredients(var count: Int) {
    Water(400),
    Milk(540),
    Beans(120),
    Cups(9),
    Money(550);

}
