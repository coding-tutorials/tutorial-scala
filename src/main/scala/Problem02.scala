object Problem02 {
  def myLastButOne[A](list: List[A]) : A = {
    list match {
      case x :: x2 :: Nil => x
      case x :: xs => myLastButOne(xs)
    }
  }
}
