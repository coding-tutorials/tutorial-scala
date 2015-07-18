import org.scalatest.{FunSpec, ShouldMatchers}

class FunctionsTests extends FunSpec with ShouldMatchers {
  describe("functions tests"){

    it("should use shortcut for lambda"){
      val someList = List.range(1, 10)
      val evens = someList.filter((i: Int) => i % 2 == 0)
      val evensUsingShortcut = someList.filter(_ % 2 == 0) //_ as parameter shortcut

      evens.should(equal(evensUsingShortcut))
    }

    it("should use shortcut when you have only one parameter"){
      val someList = List.range(1,5)
      val doubleNumber: Int => Int = _ * 2 //yeah, starting with shortcut on function declaration!

      val resultList = someList.foreach((i: Int) => doubleNumber(i))
      val resultListUsingShortcut = someList.foreach(i => doubleNumber(i))

      //...since both foreach lambda and doubleNumber function needs only a single parameter..
      val resultListUsingMoreShortcut = someList.foreach(doubleNumber(_))
      //or better!
      val resultListUsingMoreShortcutYet = someList.foreach(doubleNumber) //YEAH!

      resultListUsingShortcut.should(equal(resultList))
      resultListUsingMoreShortcut.should(equal(resultList))
      resultListUsingMoreShortcutYet.should(equal(resultList))
    }

    it("should use function as variable"){
      // val vs def for function declaration:
      // val will execute function once

      //declare a function the same way as an variable (with val instead def)
      val isNumberEven = (i: Int) => i % 2 == 0
      //function above is not explicit declaring return type, but you can in the following way
      val isNumberEvenWithExplicitReturnType: (Int) => Boolean = (i) => i % 2 == 0
      //sameFunctionAbove but with _ shortcut for the single parameter
      val isNumberEvenWithExplicitReturnTypeAndShortcut: (Int) => Boolean = _ % 2 == 0

      val someList = List.range(1, 5)
      val expectedIsEvenResult = List(false,true,false,true)

      someList.map(isNumberEven).should(equal(expectedIsEvenResult))
      someList.map(isNumberEvenWithExplicitReturnType).should(equal(expectedIsEvenResult))
      someList.map(isNumberEvenWithExplicitReturnTypeAndShortcut).should(equal(expectedIsEvenResult))
    }

    it("should use function as parameter"){
      val sumFunction: (Int, Int) => Int = _ + _
      val multiplyFunction: (Int, Int) => Int = _ * _

      def execSomeMathFunction(callback: (Int,Int)=>Int,a: Int, b: Int) = callback(a,b)

      val sumResult = execSomeMathFunction(sumFunction, 1, 3)
      val multiplyResult = execSomeMathFunction(multiplyFunction, 5, 3)

      sumResult.should(equal(4))
      multiplyResult.should(equal(15))
    }

    it("should create a partial function"){
      val completeMultiplyFunction = (a: Int, b: Int) => a * b
      val multiplyWith5 = (a:Int) => completeMultiplyFunction(a , 5)

      val completeFunctionResult = completeMultiplyFunction(2,5)
      val partialFunctionResult = multiplyWith5(2)

      partialFunctionResult.should(equal(completeFunctionResult))
    }

    it("should create a function that returns another function"){
      //saySomething actually returns just another function
      def saySomething(somethingToSay: String) = (someone: String) => {
        somethingToSay + " " + someone
      }

      val sayHelloTo = saySomething("Hello") //return another function with "Hello" as parameter
      val sayGoodmorningTo = saySomething("Good morning")

      val sayHelloResult = sayHelloTo("Marcus")
      val sayGoodmorningResult = sayGoodmorningTo("Rita")
      //this is the advantage of using a function that returns another
      //now I can use it again. Without this we should call the same function
      //with the repeated "Good morning".. now we can avoid this!
      val anotherSayGoodmorningResult = sayGoodmorningTo("Holly")

      sayHelloResult.should(be("Hello Marcus"))
      sayGoodmorningResult.should(be("Good morning Rita"))
      anotherSayGoodmorningResult.should(be("Good morning Holly"))
    }





  }
}
