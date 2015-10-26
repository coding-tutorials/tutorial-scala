import org.scalatest.FunSpec
import org.scalatest.ShouldMatchers

class Problem01Test extends FunSpec with ShouldMatchers{
  describe("Problem 1 Test") {
    it("should get last element from a list") {
      val list = List(1,2,3,4)
      val last = Problem01.myLast(list)

      last.should(be(4))
    }

    it("should get last but one element from a list") {
      val list = List(1,2,3,4)
      val lastButOne = Problem02.myLastButOne(list)

      lastButOne.should(be(3))
    }

    it("should get the k'th element in a list") {
      val list = List(1,2,3,4)
      val elementAt = Problem03.myElementAt(list, 1)

      elementAt.should(be(2))
    }

    it("should get the length of a list") {
      val list = List('a','b','c','d')
      val length = Problem04.myLength(list)

      length.should(be(4))
    }

    it("should reverse a list") {
      val list = List('a','b','c','d')
      val invertedList = Problem05.myReverse(list)

      invertedList.should(be(List('d','c','b','a')))
    }

    it("should check palindomres") {
      val palindromeList = List('a', 'b', 'b', 'a')
      val nonPalindromeList = List('a', 'b','c', 'a')


      Problem06.myIsPalindrome(palindromeList) should be(true)
      Problem06.myIsPalindrome(nonPalindromeList) should be(false)
    }

    it("should flatten a nested list") {
      val nestedList = List(List(1, 2), List(3, 4, 5), List(6))

      Problem07.myFlatten(nestedList) should be(List(1, 2, 3, 4, 5, 6))
    }
  }
}

