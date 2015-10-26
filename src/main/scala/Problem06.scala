object Problem06 {
  def myIsPalindrome[A](list: List[A]) : Boolean = {
    list match {
      case Nil => true
      case x :: Nil => true
      case x :: xs => if (x == xs.last) myIsPalindrome(xs.init) else false
    }
  }
}
