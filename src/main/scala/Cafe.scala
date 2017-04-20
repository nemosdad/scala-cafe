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
    var total: BigDecimal = 0.0

    for(item <- basket) {
      total += item.cost

    }
    total
  }

  def getBasketTotalWithServiceCharge: BigDecimal = {
    var isThereADrinks: Boolean = false
    var isThereFood: Boolean = false
    var isThereHotFood: Boolean = false
    for(item <- basket) {
      item.itemtype match {
          case "drink" => isThereADrinks = true
          case "food" => isThereFood = true
      }
      if (item.itemtype == "food" && item.temprature == 1)
        isThereHotFood = true

    }

    if((isThereADrinks == true) && (isThereFood == false) && (isThereHotFood == false) )
      getBasketTotal
    else if(isThereFood == true && (isThereHotFood == false)) {
      getBasketTotal.+(getBasketTotal.*(0.1))
    }
    else if (isThereHotFood == true)
      getBasketTotal.+(getBasketTotal.*(0.2))
    else
      getBasketTotal
  }



}
