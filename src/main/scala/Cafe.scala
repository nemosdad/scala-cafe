import scala.collection.mutable

/**
  * Created by venkatesh on 20/04/2017.
  */
class Cafe {

  private var basket: mutable.MutableList[MenuItem] = new mutable.MutableList[MenuItem]


  def getAllItemsInBasket: Array[MenuItem] = {
    basket.toArray[MenuItem]
  }

  def putItemInBasket(item: MenuItem) {
      basket += item
  }


  def getBasketTotal: BigDecimal = {
    var total: BigDecimal = 0

    for(item <- basket) {
      total += item.cost

    }
    total
  }



}
