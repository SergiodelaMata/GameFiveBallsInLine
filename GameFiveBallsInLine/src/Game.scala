import java.util.Random
import java.util.Calendar

//object Game extends App{
object Game{
  def main(args: Array[String]): Unit = {
    println("Hola mundo")
    //val row = null :: null :: null :: null :: null :: null :: null :: null :: null :: Nil
    val row = List.fill(9)(null)
    //val tablero = row :: row :: row :: row :: row :: row :: row :: row :: row :: Nil
    val tablero = List.fill(9)(row)
    val colores = "A" :: "N" :: "R" :: "V" :: "M" :: "G" :: Nil //Colores de las bolas
    /*println(colores(0))
    println(colores(1))
    println(colores(2))
    println(colores(3))
    println(colores(4))
    println(colores(5))
    println(random(0,9))*/
    val posInicial = pedirPosInicial()
    val posFinal = pedirPosFinal()
    //println(getValueListOfLists(1,1, tablero))
  }
  
  //Devuelve el valor de una posición de una lista de listas de strings
  def getValueListOfLists(posX: Int, posY: Int, tablero: List[List[String]]): String = {
    if(posX == 0)
      getValueList(posY, tablero.head)
      getValueListOfLists(posX - 1, posY, tablero.tail)
  }
  
  //Devuelve el valor de una posición de una lista de strings
  def getValueList(pos: Int, lista: List[String]): String = {
    if(pos == 0)
      lista.head
      getValueList(pos-1, lista.tail)
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
  def pedirPosInicial():List[Int] = {
    println("Introduce la posión inicial en la coordenada X:")
    val posX = scala.io.StdIn.readInt()
    println("Introduce la posión inicial en la coordenada Y:")
    val posY = scala.io.StdIn.readInt()
    val listPos = List(posX, posY)
    listPos
  }
  
  //Pide las coordenadas de la posición final
  def pedirPosFinal():List[Int] = {
    println("Introduce la posión final en la coordenada X:")
    val posX = scala.io.StdIn.readInt()
    println("Introduce la posión final en la coordenada Y:")
    val posY = scala.io.StdIn.readInt()
    val listPos = List(posX, posY)
    listPos
  }
  
  //Rellena el tablero con tantas bolas que se ha indicado en posiciones vacías
  def rellenarTablero(numBolas: Int, tablero: List[List[String]], colores : List[String]): List[List[String]] = {
    if(numBolas != 0)
      rellenarTablero(numBolas - 1, rellenarPosicionAleatorio(tablero, getValueList(random(0, colores.length), colores)), colores)
      tablero
  }
  
  //Rellena una posición del tablero de forma aleatoria
  def rellenarPosicionAleatorio(tablero: List[List[String]], color : String): List[List[String]] = {
    val posX = random(0,9)
    val posY = random(0,9)
    if(comprobarIsEmptyPos(posX, posY, tablero))
      paintTablero(posX, posY, tablero, color)
      rellenarPosicionAleatorio(tablero, color)
  }
  
  //Pinta una posición de acuerdo a todo el tablero
  def paintTablero(posX: Int, posY: Int, tablero: List[List[String]], color : String): List[List[String]] = {
    if(posX == 0)
      paintFila(posY, tablero.head, color) ::: tablero.tail
      List(tablero.head) ::: paintTablero(posX - 1, posY, tablero.tail, color)
  }
  
  //Pinta una posición de acuerdo a una fila del tablero
  def paintFila(posY: Int, lista: List[String], color : String): List[String] = {
    if(posY == 0)
      List(color) ::: lista.tail
      List(lista.head) ::: paintFila(posY - 1, lista.tail, color)
  }
  
  //Rellena una posición del tablero
  def rellenarPosicionNormal(posX: Int, posY: Int, tablero: List[List[String]], color : String): List[List[String]] = 
  {
  	paintTablero(posX,posY,tablero,color)
  }
}