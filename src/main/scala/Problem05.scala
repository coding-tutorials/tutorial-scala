object Problem05 {
  def myReverse[A](list: List[A]): List[A] = {
    list match {
      case x :: xs => myReverse(xs) ::: List(x)
      case Nil => Nil
    }
  }
}
