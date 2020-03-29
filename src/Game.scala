import java.util.Random
import java.util.Calendar

//object Game extends App{
object Game{
  def main(args: Array[String]): Unit = {
    //println("Hola mundo")
    //val row = null :: null :: null :: null :: null :: null :: null :: null :: null :: Nil
    val row = List.fill(9)(null)
    //val tablero = row :: row :: row :: row :: row :: row :: row :: row :: row :: Nil
    val tablero = List.fill(9)(row)
    val colores = "A" :: "N" :: "R" :: "V" :: "M" :: "G" :: Nil //Colores de las bolas
    //println(getCambiosTablero(tablero, List.fill(9)(List.fill(9)("1")),0))
    //println(getValueListOfLists(1,1,tablero))
    //println(paintTablero(1,1,tablero, "R"))
    //println(paintTablero(4,4,tablero, "R"))
    /*println(colores(0))
    println(colores(1))
    println(colores(2))
    println(colores(3))
    println(colores(4))
    println(colores(5))
    println(random(0,9))*/
    val posInicial = pedirPosInicial(tablero)
    val posFinal = pedirPosFinal(tablero)
    //println(getValueListOfLists(1,1, tablero))
  }
  
  //Devuelve el valor de una posición de una lista de listas de strings
  def getValueListOfLists(posX: Int, posY: Int, tablero: List[List[String]]): String = {
    getValueList(posY, tablero(posX))
  }
  
  //Devuelve el valor de una posición de una lista de strings
  def getValueList(pos: Int, lista: List[String]): String = {
    lista(pos)
  }
  
  //Devuelve la fila con la que se está trabajando
  def getFila(posX: Int, tablero: List[List[String]]): List[String] = {
    tablero(posX)
  }
  
  //Obtención de un número random en un intervalo
  def random(min:Int, max:Int):Int = { 
    val now = Calendar.getInstance()
    val currentMinute = now.get(Calendar.SECOND)
    val random = new Random(currentMinute)
    val randomAux = random.nextInt(max - min)
    val resultado = randomAux + min
    resultado
  }

  //Saber si una casilla se encuentra o no vacía
  def comprobarIsEmptyPos(x: Int, y: Int, tablero: List[List[String]]):Boolean = {
    val result = tablero(x)(y).!=(null)
    if(result) false
    else true
  }
  
  //Pide las coordenadas de la posición inicial
  def pedirPosInicial(tablero: List[List[String]]):List[Int] = {
    println("Introduce la posión inicial en la coordenada X:")
    val posX = scala.io.StdIn.readInt()
    println("Introduce la posión inicial en la coordenada Y:")
    val posY = scala.io.StdIn.readInt()
    if(posX < 0 || posX > 8 || posY < 0 || posY > 8 || !comprobarIsEmptyPos(posX, posY, tablero))
    {
      println("Posición inválida. Introduzca una posición válida.")
      pedirPosInicial(tablero: List[List[String]])
    }
    else
    {
      List(posX, posY)
    }
  }
  
  //Pide las coordenadas de la posición final
  def pedirPosFinal(tablero: List[List[String]]):List[Int] = {
    println("Introduce la posión final en la coordenada X:")
    val posX = scala.io.StdIn.readInt()
    println("Introduce la posión final en la coordenada Y:")
    val posY = scala.io.StdIn.readInt()
    if(posX < 0 || posX > 8 || posY < 0 || posY > 8 || comprobarIsEmptyPos(posX, posY, tablero))
    {
      println("Posición inválida. Introduzca una posición válida.")
      pedirPosFinal(tablero: List[List[String]])
    }
    else
    {
      List(posX, posY)
    }
  }
  
  //Rellena el tablero con tantas bolas que se ha indicado en posiciones vacías
  def rellenarTablero(numBolas: Int, tablero: List[List[String]], colores : List[String]): List[List[String]] = {
    if(numBolas != 0) rellenarTablero(numBolas - 1, rellenarPosicionAleatorio(tablero, getValueList(random(0, colores.length), colores)), colores)
    else tablero
  }
  
  //Rellena una posición del tablero de forma aleatoria
  def rellenarPosicionAleatorio(tablero: List[List[String]], color : String): List[List[String]] = {
    val posX = random(0,9)
    val posY = random(0,9)
    if(comprobarIsEmptyPos(posX, posY, tablero)) paintTablero(posX, posY, tablero, color)
    else rellenarPosicionAleatorio(tablero, color)
  }
  
  //Pinta una posición de acuerdo a todo el tablero
  def paintTablero(posX: Int, posY: Int, tablero: List[List[String]], color : String): List[List[String]] = {
    if(posX.!=(0)) tablero.head :: paintTablero(posX - 1, posY, tablero.tail, color)
    else paintFila(posY, tablero.head, color) :: tablero.tail
  }
  
  //Pinta una posición de acuerdo a una fila del tablero
  def paintFila(posY: Int, lista: List[String], color : String): List[String] = {
    if(posY.!=(0)) lista.head :: paintFila(posY - 1, lista.tail, color)
    else color :: lista.tail
  }
  
  //Rellena una posición del tablero
  def rellenarPosicionNormal(posX: Int, posY: Int, tablero: List[List[String]], color : String): List[List[String]] = 
  {
  	paintTablero(posX,posY,tablero,color)
  }
  
  //Permite obtener el número de cambios en el tablero
  def getCambiosTablero(tablero1: List[List[String]], tablero2: List[List[String]], counter: Int): Int = {
    if(tablero1.isEmpty) counter
    else getCambiosTablero(tablero1.tail, tablero2, getCambiosFilaTablero(tablero1.head, tablero2.head, counter))
  }


  //Permite obtener el número de cambios en una fila del tablero
  def getCambiosFilaTablero(lista1: List[String], lista2: List[String], counter: Int): Int = {
    if(lista1.isEmpty) counter
    else getCambiosFilaTablero(lista1.tail, lista2.tail, setValorContador(lista1.head, lista2.head, counter))
  }
  
  //Permite ajustar el valor del contador si es necesario
  def setValorContador(value1: String, value2: String, counter: Int): Int = {
    if(!isEqual(value1, value2)) counter + 1
    else counter
  }
  
  //Compara dos elementos son iguales
  def isEqual(value1: String, value2: String): Boolean = {
    if(value1.!=(value2)) false
    else true
  }
}