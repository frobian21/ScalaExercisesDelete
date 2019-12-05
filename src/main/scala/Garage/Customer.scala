package Garage

class Customer(name: String) extends Person(name: String){
  override def toString() = s"Customer($name)"
}
