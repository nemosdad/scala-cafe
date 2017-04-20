import org.scalatest._

/**
  * Created by venkatesh on 20/04/2017.
  */
class CafeTest extends FlatSpec with Matchers  {



  "A non Menu Item is added the total " should " not be less than zero" in {
    val cafe = new Cafe()
    cafe.putItemInBasket(new MenuItem("Coffee", 1, "drink", 0.50))
    cafe.getBasketTotal should not be 0
  }

  "When multiple Menu items are added the total " should "not be less than zero" in {
    val cafe = new Cafe()
    cafe.putItemInBasket(new MenuItem("Coffee", 1, "drink", 1.00))
    cafe.putItemInBasket(new MenuItem("Cola", 0, "drink", 0.50))
    cafe.putItemInBasket(new MenuItem("Cheese Sandwich", 0, "food", 2.00))
    cafe.putItemInBasket(new MenuItem("Steak Sandwich", 0, "food", 4.50))

    cafe.getBasketTotal should not be 0

  }

  "When all items are drinks the total " should " not have any service charges" in {
    val cafe = new Cafe()
    cafe.putItemInBasket(new MenuItem("Coffee", 1, "drink", 1.00))
    cafe.putItemInBasket(new MenuItem("Cola", 0, "drink", 0.50))
    println("Total Drinks Only " + cafe.getBasketTotalWithServiceCharge)
    cafe.getBasketTotalWithServiceCharge should equal(1.50)

  }

  "When there is any food the total " should " have applied service charge of 10%" in {
    val cafe = new Cafe()
    cafe.putItemInBasket(new MenuItem("Cola", 0, "drink", 0.50))
    cafe.putItemInBasket(new MenuItem("Cheese Sandwich", 0, "food", 2.00))
    println("Total Any food included " + cafe.getBasketTotalWithServiceCharge)
    cafe.getBasketTotalWithServiceCharge should equal(2.75)

  }

  "When there is any hot food the total " should " have applied service charge of 20%" in {
    val cafe = new Cafe()
    cafe.putItemInBasket(new MenuItem("Cola", 0, "drink", 0.50))
    cafe.putItemInBasket(new MenuItem("Cheese Sandwich", 0, "food", 2.00))
    cafe.putItemInBasket(new MenuItem("Steak Sandwich", 1, "food", 4.50))
    println("Total Any hot food included " + cafe.getBasketTotalWithServiceCharge)
    cafe.getBasketTotalWithServiceCharge should equal(8.40)

  }


}
