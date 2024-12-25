fun main() {
    println("Задача 1: Кегли и шары")
    task1()

    println("\nЗадача 2: Семьи и подписки")
    task2()

    println("\nЗадача 3: Словарь с кубами чисел")
    task3()
}

fun task1() {
    println("Введите количество кеглей (N) и количество бросков (K) через пробел:")
    val input = readLine()?.split(" ") ?: return
    if (input.size != 2) {
        println("Ошибка: ожидается два числа (N и K)")
        return
    }

    val n = input[0].toIntOrNull() ?: run {
        println("Ошибка: N должно быть числом")
        return
    }
    val k = input[1].toIntOrNull() ?: run {
        println("Ошибка: K должно быть числом")
        return
    }

    val kegels = MutableList(n) { 'I' }

    for (i in 1..k) {
        println("Введите диапазон для броска $i (l r):")
        val line = readLine()?.split(" ") ?: return
        if (line.size != 2) {
            println("Ошибка: ожидается два числа (l и r)")
            return
        }

        val l = line[0].toIntOrNull() ?: run {
            println("Ошибка: l должно быть числом")
            return
        }
        val r = line[1].toIntOrNull() ?: run {
            println("Ошибка: r должно быть числом")
            return
        }

        for (j in l - 1 until r) {
            if (j in 0 until n) {
                kegels[j] = '.'
            }
        }
    }

    println("Результат:")
    println(kegels.joinToString(""))
}

fun task2() {
    val newspaperFamilies = (1..75).toSet()
    val magazineFamilies = (1..27).toSet()
    val bothFamilies = (1..13).toSet()

    val totalFamilies = (newspaperFamilies + magazineFamilies).union(bothFamilies)

    println("Всего семей в доме: ${totalFamilies.size}")
}

fun task3() {
    val cubesMap = (1..10).associateWith { it * it * it }

    println(cubesMap)
}