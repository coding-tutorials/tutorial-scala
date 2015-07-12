package unit

import org.scalatest._

class ExampleTest extends FunSpec with ShouldMatchers {
  describe("some tests") {
    it("if/else return") {
      val isTrue = true
      val isFalseTrue = if (isTrue == false) true else false
      isFalseTrue.should(be(false))
    }
    
    it("nested loops") {
      class Song(val name: String)
      class Album(val name:String, val songs: List[Song])
      class Artist(val name: String, val albuns: List[Album])
      
      val albumOne = new Album("album one", List(new Song("music 1"), new Song("music 2")))
      val albumTwo = new Album("album two", List(new Song("music 3"), new Song("music 4")))
      val artist = new Artist("Michael Jackson",  List(albumOne, albumTwo))
      
      var nestedForSongs = 0
      for(a <- artist.albuns){
        for(s <- a.songs) {
          nestedForSongs += 1
        }
      }
      
      var bestNestedForSongs = 0
      for(a <- artist.albuns;s <- a.songs) {
        bestNestedForSongs +=1
      }
      
      var filteredForSongs = 0
      for {
        a <- artist.albuns
        s <- a.songs
        if s.name == "music 1"
      } filteredForSongs += 1
      
      nestedForSongs.should(be(4))
      bestNestedForSongs.should(be(4))
      filteredForSongs.should(be(1))
    }
  }
  
  it("yield") {
    val songs = List("Song 1", "Song 2", "Song 3")
    val yieldedSongs = for {
      s <- songs
      if(s == "Song 1" || s == "Song 2")
    } yield s
    
    yieldedSongs.size.should(be(2))
  }
  
  it("match") {
    val songs = List("Yellow", "Blue", "Red")
    val isBlue = songs(1) match {
      case "Blue" => true
      case _ => false
    }
    
    isBlue.should(be(true))
  }
  
  it("scala constructor") {
    class SomeClass(var someNumber: Int) {
      changeNumber() //yep, everything that executes in a class body is a constructor
      
      def changeNumber() {
        someNumber = 7
      }
      
      def returnNumber() {
        someNumber
      }
    }
    
    var someClass = new SomeClass(2)
    someClass.someNumber.should(be(7))
  }
  
  it("scala multiple constructors") {
    //primary constructor
    class Pizza(val crustSize: String, val sauce: String, val topping: String = "pepperoni") {
      
      //auxiliar constructor
      def this(sauce: String) {
        this("thick", sauce)
      }
      
      override def toString() = {
        s"Crust: ${crustSize}, Sauce: ${sauce}, Topping: ${topping}"
      }
    }
    
    var pizza = new Pizza("thin", "tomato")
    var pizzaWithDefaultCrust = new Pizza("tomato")
    
    pizza.toString.should(be("Crust: thin, Sauce: tomato, Topping: pepperoni"))
    pizzaWithDefaultCrust.toString.should(be("Crust: thick, Sauce: tomato, Topping: pepperoni"))
    
  }
  
  
}
