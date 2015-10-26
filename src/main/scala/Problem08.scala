object Problem08 {
  def myCompress[A](list: List[A]): List[A] = {
    list match {
      case x :: y :: xs => if (x == y) myCompress(List(x) ::: xs)
                           else        List(x) ::: myCompress(List(y) ::: xs)
      case x => x
    }
  }
}
