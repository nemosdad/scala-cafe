import org.scalatest._

/**
  * Created by venkatesh on 20/04/2017.
  */
class CafeTest extends FlatSpec with Matchers  {



  "A non Menu Item is added it " should " throw Exception" in {
    val cafe = new Cafe()

    cafe.putItemInBasket(new MenuItem("Coffee", 1, "drink", 0.50))
    cafe.getBasketTotal should not be 0
  }

}
