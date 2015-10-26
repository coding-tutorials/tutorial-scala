object Problem03 {
  def myElementAt[A](list: List[A], position: Int): A = {
    (position, list) match {
      case (0, x :: xs) => x
      case (_, x :: xs) => myElementAt(xs, position - 1)
    }
  }
}
