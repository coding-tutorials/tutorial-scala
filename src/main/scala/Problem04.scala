object Problem04 {
  def myLength[A](list: List[A]): Int = {
    list match {
      case x :: Nil => 1
      case x :: xs => 1 + myLength(xs)
    }
  }
}
