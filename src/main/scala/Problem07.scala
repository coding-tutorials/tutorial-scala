object Problem07 {

  def myFlatten[A](nestedList: List[List[A]]): List[A] = {
    nestedList match {
      case List(x) => x
      case x :: xs => x ::: myFlatten(xs)
    }
  }

}
