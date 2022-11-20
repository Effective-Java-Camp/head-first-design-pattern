import java.util.*
import kotlin.collections.ArrayList

abstract class MenuComponent {

    @Throws(UnsupportedOperationException::class)
    open fun add(menuComponent: MenuComponent) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    open fun remove(menuComponent: MenuComponent) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    open fun getChile(i: Int): MenuComponent {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    open fun print() {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    open fun isVegetarian(): Boolean {
        throw UnsupportedOperationException()
    }

    abstract val name: String
        // get() {
        //     throw UnsupportedOperationException()
        // }
    abstract val description: String
        // get() {
        //     throw UnsupportedOperationException()
        // }
}

class MenuItem(
    name: String, description: String, val vegetarian: Boolean, price: Double
) : MenuComponent() {

    override val name = name
    override val description = description


    override fun isVegetarian(): Boolean {
        return vegetarian
    }

    override fun print() {
        print("\n$name, $description")
        println("----------")
        if (isVegetarian()) println(">>>> vegiterian")
    }

    
}

 class Menu(name: String, description: String) : MenuComponent() {

    override val name = name
    override val description = description


    val menuComponents: ArrayList<MenuComponent> = ArrayList<MenuComponent>()


    override fun add(menuComponent: MenuComponent) {
        menuComponents.add(menuComponent)
    }

    override fun remove(menuComponent: MenuComponent) {
        menuComponents.remove(menuComponent)
    }

    override fun getChile(i: Int): MenuComponent {
        return menuComponents.get(i)
    }

    override fun print() {
        val iterator = menuComponents.iterator()
        while (iterator.hasNext()) {
            val menuComponent: MenuComponent = iterator.next()
            menuComponent.print()
        }
    }

    
}

class Waitress(
    val allMenues: MenuComponent
) {
    fun printMenu() {
        allMenues.print()
    }
}

// class MenueTest {

fun main() {
    val pancakeHouseMenue = Menu("팬케이크 하우스 메뉴", "아침 메뉴")
    val dinerMenu = Menu("객체마을 식당 메뉴", "점심 메뉴")
    val cafeMenu = Menu("카페 메뉴", "저녁 메뉴")
    val desertMenu = Menu("디저트 메뉴", "디저트를 즐겨보세요!")
    val allMenus = Menu("전체 메뉴", "전체 메뉴")

    allMenus.add(pancakeHouseMenue)
    allMenus.add(dinerMenu)
    allMenus.add(cafeMenu)
    allMenus.add(desertMenu)

    dinerMenu.add(MenuItem("파스타", "마리나라 소스 스파게티", false, 3.89))
    desertMenu.add(MenuItem("애플 파이", "바삭바삭", true, 1.59))

    val waitress: Waitress = Waitress(allMenus)
    waitress.printMenu()
}
// }