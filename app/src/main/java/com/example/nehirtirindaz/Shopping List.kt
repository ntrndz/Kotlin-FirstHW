package com.example.nehirtirindaz

open class Item(val name: String, val price: Double)

class Food(name: String, price: Double, val weight: Double) : Item(name, price)

class Cloth(name: String, price: Double, val type: String) : Item(name, price)

class ShoppingList {
    private val itemList = mutableListOf<Item>()

    fun addItem() {
        println("Add Item:")
        println("1) Food")
        println("2) Cloth")
        print("Choose item type: ")
        val itemType = readLine()?.toIntOrNull()

        if (itemType !in listOf(1, 2)) {
            println("Invalid item type!")
            return
        }

        print("Enter name: ")
        val name = readLine() ?: ""
        print("Enter price: ")
        val price = readLine()?.toDoubleOrNull() ?: 0.0

        when (itemType) {
            1 -> {
                print("Enter weight: ")
                val weight = readLine()?.toDoubleOrNull() ?: 0.0
                itemList.add(Food(name, price, weight))
            }
            2 -> {
                print("Enter type: ")
                val type = readLine() ?: ""
                itemList.add(Cloth(name, price, type))
            }
        }

        println("Item added successfully!")
    }

    // Ürünleri listeleme fonksiyonu
    fun displayItems() {
        println("Display Item:")
        if (itemList.isEmpty()) {
            println("No items to display.")
        } else {
            println("Items:")
            for ((index, item) in itemList.withIndex()) {
                println("${index + 1}) ${item.name}, Price: ${item.price}")
                when (item) {
                    is Food -> println("   Weight: ${item.weight}")
                    is Cloth -> println("   Type: ${item.type}")
                }
            }
        }
    }

    // Ürün silme fonksiyonu
    fun deleteItem() {
        println("Delete Item:")
        displayItems()
        print("Enter the index of the item to delete: ")
        val index = readLine()?.toIntOrNull()?.minus(1) ?: -1
        if (index in itemList.indices) {
            itemList.removeAt(index)
            println("Item deleted successfully!")
        } else {
            println("Invalid index!")
        }
    }
}

fun main() {
    val shoppingList = ShoppingList()

    var choice: Int
    do {
        println("\nShopping List App")
        println("1) Add Item")
        println("2) Display Item")
        println("3) Delete Item")
        println("4) Exit")
        print("Enter your choice: ")
        choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            1 -> shoppingList.addItem()
            2 -> shoppingList.displayItems()
            3 -> shoppingList.deleteItem()
            4 -> println("Exiting...")
            else -> println("Invalid choice! Please enter a number between 1 and 4.")
        }
    } while (choice != 4)
}
