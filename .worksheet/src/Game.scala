object Game {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Welcome to the Scala worksheet");$skip(18); 
  println("HOLA");$skip(38); 
  val lista = List(1,2,3,4,5,6,7,8,9);System.out.println("""lista  : List[Int] = """ + $show(lista ));$skip(36); 
  val a = Array.ofDim[String](9, 9);System.out.println("""a  : Array[Array[String]] = """ + $show(a ));$skip(18); 
    a(0)(0) = "a";$skip(21); 
    println(a(0)(0))}
}
