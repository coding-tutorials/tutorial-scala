object Problem01 {
  def myLast[A](list: List[A]): A = {
    list match {
      case x :: Nil => x
      case x :: xs => myLast(xs)
    }
  }
}
