import scala.util.Random

//object Game extends App{
object Game{
  def main(args: Array[String]): Unit = {
    val colors = "A" :: "N" :: "R" :: "V" :: "M" :: "G" :: Nil //colors de las bolas
    val matrix = fillMatrix(9,generateMatrix(9,9),colors)
    println("Tablero inicial:")
    showMatrix(matrix,0)
    println("Puntos de la partida: " + executeGame(matrix,0,colors,1))
  }
  
  
  //Devuelve los puntos finales de la partida y realiza la ejecución del juego
  def executeGame(matrix:List[List[String]], counter: Int, colors: List[String],step: Int): Int ={
    if(getListFreePositions(matrix,0).!=(0))
    {
      println("Tablero paso " + step + ":")
      showMatrix(matrix,0)
      val listPos = getListPos(matrix)
      val posInitial = listPos.head
      val posFinal = (listPos.tail).head
      val matrixChangePos = paintMatrix(posFinal.head, (posFinal.tail).head, paintMatrix(posInitial.head, (posInitial.tail).head, matrix, "-"), getValueListOfLists(posInitial.head,(posInitial.tail).head,matrix))
      val matrixRemoveLines = paintListPosMatrix(getChanges(posFinal, matrixChangePos),"-",matrixChangePos)
      //showMatrix(matrixChangePos,0)
      //showMatrix(matrixRemoveLines,0)
      executeGame(getMatrixNextStep(matrix, matrixRemoveLines,colors),addPoints(matrix, matrixRemoveLines, counter),colors, step+1)
    }
    else counter
  }
  //Obtiene la posición inicial y la posición final para una bola
  def getListPos(matrix:List[List[String]]): List[List[Int]]=
  {
    val posInicial = pedirPosInicial(matrix)
    val posFinal = pedirPosFinal(matrix)
    if(isPath(posInicial,posFinal,matrix,0)) List(posInicial,posFinal)
    else
    {
      println("Error. No hay camino entre las posiciones indicadas. Introduzca otras posiciones.")
      getListPos(matrix)
    }
  }
  //Genera una matriz de posiciones vacías
  def generateMatrix(numFilas: Int, numColumnas: Int): List[List[String]] ={
    if(numFilas.!=(0)) generateMatrix(numFilas-1,numColumnas):::List(generateRow(numColumnas))
    else Nil
  }
  //Genera una fila por posiciones vacías
  def generateRow(numElem: Int): List[String] ={
    if(numElem.!=(0)) generateRow(numElem-1):::List("-")
    else Nil
  }
  
  //Muestra una matriz por pantalla
  def showMatrix(matrix:List[List[String]], pos: Int):List[List[String]]={
    val coordX = pos / 9
    val coordY = pos % 9
    if(pos<81)
    {
      if(coordY.!=(0))
      {
        print(" " + getValueListOfLists(coordX,coordY,matrix))
        showMatrix(matrix,pos+1)
      }
      else
      {
        println()
        print(" " + getValueListOfLists(coordX,coordY,matrix))
        showMatrix(matrix,pos+1)
      }
    }
    else
    {
      println("")
      matrix
    }
  }
  //Devuelve el valor de una posición de una lista de listas de strings
  def getValueListOfLists(posX: Int, posY: Int, matrix: List[List[String]]): String = {
    //getValueList(posY, matrix(posX))
    if(posX.!=(0)) getValueListOfLists(posX-1, posY, matrix.tail)
    else getValueList(posY, matrix.head)
  }
  //Devuelve el valor de una posición de una lista de strings
  def getValueList(pos: Int, lista: List[String]): String = {
    //lista(pos)
    if(pos.!=(0)) getValueList(pos-1, lista.tail)
    else lista.head
    
  }
  //Devuelve la fila con la que se está trabajando
  def getRow(posX: Int, matrix: List[List[String]]): List[String] = {
    matrix(posX)
  }
  //Obtención de un número random en un intervalo
  def random(min:Int, max:Int):Int = { 
    val random = scala.util.Random
    val randomAux = random.nextInt(max - min)
    val resultado = randomAux + min
    resultado
  }
  //Verifica si una casilla se encuentra o no vacía
  def isEmptyPosListOfLists(x: Int, y: Int, matrix: List[List[String]]):Boolean = {
    if(getValueListOfLists(x,y,matrix).!=("-")) false
    else true
  }
  //Pide las coordenadas de la posición inicial
  def pedirPosInicial(matrix: List[List[String]]):List[Int] = {
    println("Posición Inicial:")
    println("Introduzca posiciones cuyos valores en cada coordenada esté entorno al 0 y el 8.")
    println("Introduce su coordenada X:")
    val posX = scala.io.StdIn.readInt()
    println("Introduce su coordenada Y:")
    val posY = scala.io.StdIn.readInt()
    if(posX < 0 || posX > 8 || posY < 0 || posY > 8 || isEmptyPosListOfLists(posX, posY, matrix))
    {
      println("Posición inválida. Introduzca una posición válida.")
      pedirPosInicial(matrix: List[List[String]])
    }
    else
    {
      List(posX, posY)
    }
  }
  //Pide las coordenadas de la posición final
  def pedirPosFinal(matrix: List[List[String]]):List[Int] = {
    println("Posición Final:")
    println("Introduzca posiciones cuyos valores en cada coordenada esté entorno al 0 y el 8.")
    println("Introduce su coordenada X:")
    val posX = scala.io.StdIn.readInt()
    println("Introduce su coordenada Y:")
    val posY = scala.io.StdIn.readInt()
    if(posX < 0 || posX > 8 || posY < 0 || posY > 8 || !isEmptyPosListOfLists(posX, posY, matrix))
    {
      println("Posición inválida. Introduzca una posición válida.")
      pedirPosFinal(matrix: List[List[String]])
    }
    else
    {
      List(posX, posY)
    }
  }
  //Verifica la existencia de un camino entre dos posiciones
  def isPath(posInitial: List[Int],posFinal: List[Int], matrix: List[List[String]],counter: Int): Boolean ={
    if(counter <150 &&((!(posInitial.head.!=(posFinal.head) && !(!(posInitial.tail).head.!=((posFinal.tail).head))))||(isFreePos(posInitial.head, (posInitial.tail).head, matrix) && isFreePos(posFinal.head, (posFinal.tail).head, matrix))))
    {
      if(!(posInitial.head.!=(posFinal.head) && !(!(posInitial.tail).head.!=((posFinal.tail).head))))
      {
        true
      }
      else
      {
        if(isPath(List(posInitial.head,(posInitial.tail).head-1), posFinal,matrix,counter+1)) true
        else
        {
          if(isPath(List(posInitial.head,(posInitial.tail).head+1), posFinal,matrix,counter+2)) true
          else
          {
            if(isPath(List(posInitial.head-1,(posInitial.tail).head), posFinal,matrix,counter+3)) true
            else
            {
              isPath(List(posInitial.head+1,(posInitial.tail).head), posFinal,matrix,counter+4)
            }
          }
        }
      }
    }
    else false
  }
  //Comprueba si una posición se encuentra libre por algún camino (derecha, izquierda, arriba o abajo)
  def isFreePos(coordX: Int, coordY: Int, matrix: List[List[String]]): Boolean={
    if((!isOutOfRangePos(coordX,coordY-1) && isEmptyPosUpDown(matrix, coordX,coordY-1))||(!isOutOfRangePos(coordX,coordY+1) && isEmptyPosUpDown(matrix, coordX,coordY+1))||(!isOutOfRangePos(coordX-1,coordY) && isEmptyPosRightLeft(matrix, coordX-1,coordY))||(!isOutOfRangePos(coordX+1,coordY) && isEmptyPosRightLeft(matrix, coordX+1,coordY))) true
    /*val posUp = !isOutOfRangePos(coordX,coordY-1) && isEmptyPosUpDown(matrix, coordX,coordY-1)
    val posDown = !isOutOfRangePos(coordX,coordY+1) && isEmptyPosUpDown(matrix, coordX,coordY+1)
    val posLeft = !isOutOfRangePos(coordX-1,coordY) && isEmptyPosRightLeft(matrix, coordX-1,coordY)
    val posRight = !isOutOfRangePos(coordX+1,coordY) && isEmptyPosRightLeft(matrix, coordX+1,coordY)
    if(posUp || posDown || posLeft || posRight) true*/
    else false
  }
  //Comprueba si una posición se encuentra fuera de rango
  def isOutOfRangePos(coordX: Int,coordY: Int):Boolean={
    if(coordX < 0 || coordX >= 9 || coordY < 0 || coordY >= 9) true
    else false
  }
  //Comprueba si la posición se encuentra vacía o fuera de rango por encima o por debajo de otra
  def isEmptyPosUpDown(matrix:List[List[String]],coordX:Int,coordY:Int):Boolean={
    if(coordY<9 && coordY>=0){
      if(isEmptyPosListOfLists(coordX,coordY,matrix)) true
      else false
    } 
    else true
  }//Comprueba si la posición se encuentra vacía o fuera de rango sabiendo que está por encima de otra
  /*def isEmptyPosUpDown(matrix:List[List[String]],coordX:Int,coordY:Int):Boolean={
    if(coordY>=0){
      if(isEmptyPosListOfLists(coordX,coordY,matrix)) true
      else false
    } 
    else true
  }*/
  //Comprueba si la posición se encuentra vacía o fuera de rango sabiendo que está a la derecha de otra
  def isEmptyPosRightLeft(matrix:List[List[String]],coordX:Int,coordY:Int):Boolean={
    if(coordX<9 && coordX>=0){
      if(isEmptyPosListOfLists(coordX,coordY,matrix)) true
      else false
    }
    else true    
  }
  //Comprueba si la posición se encuentra vacía o fuera de rango sabiendo que está a la izquierda de otra
  /*def isEmptyPosRightLeft(matrix:List[List[String]],coordX:Int,coordY:Int):Boolean={
    if(coordX>=0){
      if(isEmptyPosListOfLists(coordX,coordY,matrix)) true
      else false
    }
    else true    
  }*/
  //Rellena de forma aleatoria el tablero con un número de bolas pasado por parámetro
  def fillMatrix(numBolas: Int, matrix: List[List[String]], colors : List[String]): List[List[String]] = {
    if(numBolas != 0) fillMatrix(numBolas - 1, fillRandomPos(matrix, getValueList(random(0, colors.length), colors)), colors)
    else matrix
  }
  //Rellena una posición del tablero de forma aleatoria
  def fillRandomPos(matrix: List[List[String]], color : String): List[List[String]] = {
    val listPosEmpty = getListFreePositions(matrix, 0)
    val position = listPosEmpty(random(0, listPosEmpty.size))
    val posX = position.head
    val posY = (position.tail).head
    if(isEmptyPosListOfLists(posX, posY, matrix)) paintMatrix(posX, posY, matrix, color)
    else fillRandomPos(matrix, color)
  }
  //Pinta una lista de posiciones de un color
  def paintListPosMatrix(listPos: List[List[Int]], color: String, matrix: List[List[String]]): List[List[String]]={
    if(listPos.!=(List(Nil))&& listPos.!=(Nil))
    {
      paintListPosMatrix(listPos.tail, color, paintMatrix((listPos.head).head, ((listPos.head).tail).head, matrix, color))
    }
    else matrix
  }
  //Pinta una posición de acuerdo a todo el tablero
  def paintMatrix(posX: Int, posY: Int, matrix: List[List[String]], color : String): List[List[String]] = {
    if(posX.!=(0)) matrix.head :: paintMatrix(posX - 1, posY, matrix.tail, color)
    else paintRow(posY, matrix.head, color) :: matrix.tail
  }
  //Pinta una posición de acuerdo a una fila del tablero
  def paintRow(posY: Int, lista: List[String], color : String): List[String] = {
    if(posY.!=(0)) lista.head :: paintRow(posY - 1, lista.tail, color)
    else color :: lista.tail
  }
  //Rellena una posición del tablero
  def fillNormalPosition(posX: Int, posY: Int, matrix: List[List[String]], color : String): List[List[String]] = 
  {
  	paintMatrix(posX,posY,matrix,color)
  }
  //Permite obtener el número de cambios en el tablero
  def getMatrixChanges(matrix1: List[List[String]], matrix2: List[List[String]], position: Int, counter: Int): Int = {
    getListFreePositions(matrix2,0).length - getListFreePositions(matrix1,0).length
    /*val posX = position/9
    val posY = position%9
    if(position >= 81)
    {
      if(getValueListOfLists(posX,posY,matrix1).!=(getValueListOfLists(posX,posY,matrix2))) getMatrixChanges(matrix1,matrix2,position+1,counter)
      else getMatrixChanges(matrix1,matrix2,position+1,counter+1)
    }
    else counter
    */
    //if(isEmptyListOfLists(matrix1)) counter
    //else getMatrixChanges(matrix1.tail, matrix2, getChangexRowMatrix(matrix1.head, matrix2.head, counter))
  }
  
  
  //Permite obtener el número de cambios en una fila del tablero
  /*def getChangexRowMatrix(lista1: List[String], lista2: List[String], counter: Int): Int = {
    if(isEmptyList(lista1)) counter
    else getChangexRowMatrix(lista1.tail, lista2.tail, setValueCounter(lista1.head, lista2.head, counter))
  }*/
  //Permite ajustar el valor del contador si es necesario
  def setValueCounter(value1: String, value2: String, counter: Int): Int = {
    if(!isEqual(value1, value2)) counter + 1
    else counter
  }
  //Compara dos elementos son iguales
  def isEqual(value1: String, value2: String): Boolean = {
    if(value1.!=(value2)) false
    else true
  }
  //Verifica si una lista de listas está vacía
  /*def isEmptyListOfLists(matrix: List[List[String]]): Boolean ={
    if(matrix.length.!=(0)) false
    else true
  }
  //Verifica si una lista está vacía
  def isEmptyList(lista: List[String]): Boolean ={
    if(lista.length.!=(0)) false
    else true
  }*/
  //Devuelve el matrix que se va a utilizar para el siguiente paso del juego
  def getMatrixNextStep(initialMatrix: List[List[String]], finalMatrix: List[List[String]], colors: List[String]): List[List[String]] = {
    //println("Changes")
    //showMatrix(initialMatrix,0)
    //showMatrix(finalMatrix,0)
    //println(getMatrixChanges(initialMatrix, finalMatrix, 0, 0))
    if(getMatrixChanges(initialMatrix, finalMatrix, 0, 0) >= 5) finalMatrix
    else fillMatrix(3, finalMatrix, colors)
  }
  //Realiza la suma de puntos del nuevo paso
  def addPoints(initialMatrix:List[List[String]], finalMatrix:List[List[String]], puntos: Int):Int = {
    val bolasEliminadas=getMatrixChanges(initialMatrix,finalMatrix,0,0)
    if(bolasEliminadas >= 5) puntos + bolasEliminadas*75
  	else puntos
  }
  //Define si una posición se encuentra en una lista de posiciones
  def containPosition(listaposiciones: List[List[Int]], position: List[Int]): Boolean = {
    if(listaposiciones.!=(List(List())) && listaposiciones.!=(List()))
    {
      //Posición estudiada de la lista es distinta a la posición estudiada
      if((listaposiciones.head).head.!=(position.head) || ((listaposiciones.head).tail).head.!=((position.tail).head)) containPosition(listaposiciones.tail, position)
      //Posición estudiada de la lista es igual a la posición estudiada
      else true
    }
    else false
  }
  //Devuelve la lista de posiciones que se deben modificar
  def getChanges(position: List[Int], matriz: List[List[String]]): List[List[Int]] = {
    //val listaModificacionesFilaYColumna = List(position) ::: getChangesRow(position, matriz(position.head)) ::: getChangesColumn(position, matriz)
    val listaModificacionesFilaYColumna = introducePosition(getChangesRow(position, matriz(position.head)) ::: getChangesColumn(position, matriz), position)
    println(getListPosDiagonals(matriz, 0,listaModificacionesFilaYColumna))
    getListPosDiagonals(matriz, 0,listaModificacionesFilaYColumna)
  }
  //Introduce la posición actual si hay más posiciones en la lista de posiciones 
  def introducePosition(listPos: List[List[Int]], position: List[Int]): List[List[Int]]={
    if(listPos.length.!=(0)) List(position) ::: listPos
    else listPos
  }
  
  //Devuelve la lista de posiciones que han de modificarse de una fila en relación del número de bolas seguidas de un color
  def getChangesRow(position: List[Int], fila: List[String]): List[List[Int]] = {
    if(getBallsRow(position, fila) > 4)getBolasListaFila(position, fila)
    else Nil
  }
  //Devuelve el número de bolas seguidas de un mismo color a partir de una posición en una fila
  def getBallsRow(position: List[Int], fila: List[String]): Int = {
    (position.tail).head match { //Se compara el número de columna
      case 0 => 1 + getBallsRowIzqDer((position.tail).head + 1, fila, getValueList((position.tail).head, fila))
      case 8 => 1 + getBallsRowDerIzq((position.tail).head - 1, fila, getValueList((position.tail).head, fila))
      case _ => getBallsRowIzqDer((position.tail).head + 1, fila, getValueList((position.tail).head, fila)) + 1 + getBallsRowDerIzq((position.tail).head - 1, fila, getValueList((position.tail).head, fila))
    }
  }
  //Devuelve el número de bolas seguidas de un mismo color de izquierda a derecha en una fila
  def getBallsRowIzqDer(position: Int, fila: List[String], color: String): Int = {
    if(position < 9) //No supera el margen de la derecha
    {
      //Comprobar si tienen el mismo color
      if(getValueList(position, fila).!=(color)) 0
      else 1 + getBallsRowIzqDer(position + 1, fila, color)
    }
    else 0 //Fuera de rango
  }
  //Devuelve el número de bolas seguidas de un mismo color de derecha a izquierda en una fila
  def getBallsRowDerIzq(position: Int, fila: List[String], color: String): Int = {
    if(position >= 0) //No supera el margen de la izquierda
    {
      //Comprobar si tienen el mismo color
      if(getValueList(position, fila).!=(color)) 0
      else 1 + getBallsRowDerIzq(position - 1, fila, color)
    }
    else 0 //Fuera de rango
  }
  //Devuelve la lista de las posiciones de las bolas seguidas en una fila de un mismo color
  def getBolasListaFila(position: List[Int], fila: List[String]): List[List[Int]]={
    (position.tail).head match { //Se compara con respecto a la columna de la posición
      case 0 => getBolasListaFilaIzqDer(List(position.head,(position.tail).head + 1), fila, getValueList((position.tail).head, fila))
      case 8 => getBolasListaFilaDerIzq(List(position.head,(position.tail).head - 1), fila, getValueList((position.tail).head, fila))
      case _ => getBolasListaFilaIzqDer(List(position.head,(position.tail).head + 1), fila, getValueList((position.tail).head, fila)) ::: getBolasListaFilaDerIzq(List(position.head,(position.tail).head - 1), fila, getValueList((position.tail).head, fila))
    }
  }
  //Devuelve la lista de las posiciones de las bolas seguidas en una fila de un mismo color de izquierda a derecha
  def getBolasListaFilaIzqDer(position: List[Int], fila: List[String], color: String): List[List[Int]]={
    if((position.tail).head < 9)
    {
      if(getValueList((position.tail).head,fila).!=(color)) Nil
      else List(position) ::: getBolasListaFilaIzqDer(List(position.head,(position.tail).head + 1), fila, color)
    }
    else Nil
  }
  //Devuelve la lista de las posiciones de las bolas seguidas en una fila de un mismo color de derecha a izquierda
  def getBolasListaFilaDerIzq(position: List[Int], fila: List[String], color: String): List[List[Int]]={
    if((position.tail).head >= 0)
    {
      if(getValueList((position.tail).head,fila).!=(color)) Nil
      else List(position) ::: getBolasListaFilaDerIzq(List(position.head,(position.tail).head - 1), fila, color)
    }
    else Nil
  }
  //Devuelve la lista de posiciones que han de modificarse de una columna en relación del número de bolas seguidas de un color
  def getChangesColumn(position: List[Int], matriz: List[List[String]]): List[List[Int]] = {
    if(getBallsColumn(position, matriz) > 4)getBolasListaColumna(position, matriz)
    else Nil
  }
  //Devuelve el número de bolas seguidas de un mismo color a partir de una posición en una columna
  def getBallsColumn(position: List[Int], matriz: List[List[String]]): Int = {
    position.head match { //Se compara el número de Row
      case 0 => 1 + getBallsColUpDown(List(position.head + 1,(position.tail).head), matriz, getValueListOfLists(position.head, (position.tail).head, matriz))
      case 8 => 1 + getBallsColDownUp(List(position.head - 1,(position.tail).head), matriz, getValueListOfLists(position.head, (position.tail).head, matriz))
      case _ => getBallsColUpDown(List(position.head + 1,(position.tail).head), matriz, getValueListOfLists(position.head, (position.tail).head, matriz)) + 1 + getBallsColDownUp(List(position.head - 1,(position.tail).head), matriz, getValueListOfLists(position.head, (position.tail).head, matriz))
    }
  }
  //Devuelve el número de bolas seguidas de un mismo color de arriba a abajo en una columna
  def getBallsColUpDown(position: List[Int], matriz: List[List[String]], color: String): Int = {
    if(position.head < 9) //No supera el margen inferior
    {
      //Comprobar si tienen el mismo color
      if(getValueListOfLists(position.head, (position.tail).head, matriz).!=(color)) 0
      else 1 + getBallsColUpDown(List(position.head + 1,(position.tail).head), matriz, color)
    }
    else 0 //Fuera de rango
  }
  //Devuelve el número de bolas seguidas de un mismo color de abajo a arriba en una columna
  def getBallsColDownUp(position: List[Int], matriz: List[List[String]], color: String): Int = {
    if(position.head >= 0) //No supera el margen superior
    {
      //Comprobar si tienen el mismo color
      if(getValueListOfLists(position.head, (position.tail).head, matriz).!=(color)) 0
      else 1 + getBallsColDownUp(List(position.head - 1,(position.tail).head), matriz, color)
    }
    else 0 //Fuera de rango
  }
  //Devuelve la lista de las posiciones de las bolas seguidas en una columna de un mismo color
  def getBolasListaColumna(position: List[Int], matriz: List[List[String]]): List[List[Int]]={
    (position.tail).head match { //Se compara con respecto a la columna de la posición
      case 0 => getBallsListColUpDown(List(position.head + 1,(position.tail).head), matriz, getValueListOfLists(position.head, (position.tail).head, matriz))
      case 8 => getBallsListColDownUp(List(position.head - 1,(position.tail).head), matriz, getValueListOfLists(position.head, (position.tail).head, matriz))
      case _ => getBallsListColUpDown(List(position.head + 1,(position.tail).head), matriz, getValueListOfLists(position.head, (position.tail).head, matriz)) ::: getBallsListColDownUp(List(position.head - 1,(position.tail).head), matriz, getValueListOfLists(position.head, (position.tail).head, matriz))
    }
  }
  //Devuelve la lista de las posiciones de las bolas seguidas en una columna de un mismo color de arriba a abajo
  def getBallsListColUpDown(position: List[Int], matriz: List[List[String]], color: String): List[List[Int]]={
    if((position.tail).head < 9 && position.head < 9)
    {
      if(getValueListOfLists(position.head, (position.tail).head, matriz).!=(color)) Nil
      else List(position) ::: getBallsListColUpDown(List(position.head + 1,(position.tail).head), matriz, color)
    }
    else Nil
  }
  //Devuelve la lista de las posiciones de las bolas seguidas en una columna de un mismo color de abajo a arriba
  def getBallsListColDownUp(position: List[Int], matriz: List[List[String]], color: String): List[List[Int]]={
    if((position.tail).head >= 0 && position.head >= 0)
    {
      if(getValueListOfLists(position.head, (position.tail).head, matriz).!=(color)) Nil
      else List(position) ::: getBallsListColDownUp(List(position.head - 1,(position.tail).head), matriz, color)
    }
    else Nil
  }
  //Devuelve la lista de las posiciones de las bolas seguidas en cada una de las diagonales de todo el tablero
  def getListPosDiagonals(matrix:List[List[String]], position:Int, listPositions : List[List[Int]]):List[List[Int]]={
    //println("MIAU")
    val coordX = position / 9
    val coordY = position % 9
    //println("coordX " + coordX + " coordY " + coordY)
    if(position < 81){
      if(isEmptyPosListOfLists(coordX, coordY, matrix)) getListPosDiagonals(matrix,position+1, listPositions)
      else
      {
        val diagonalRight1 = introducePosition(getListPosDiagonalRight(matrix,coordX+1,coordY, getValueListOfLists(coordX,coordY,matrix),false),List(coordX,coordY))
        /*
         * 1 1 0
         * 0 1 1
         * 0 0 1
         * */
        //println("diagonalRight1")
        //println(diagonalRight1)
        val diagonalRight2 = introducePosition(getListPosDiagonalRight(matrix,coordX,coordY+1, getValueListOfLists(coordX,coordY,matrix),true),List(coordX,coordY))
        /*
         * 1 0 0
         * 1 1 0
         * 0 1 1
         * */
        //println("diagonalRight2")
        //println(diagonalRight2)
        val diagonalLeft1 = introducePosition(getListPosDiagonalLeft(matrix,coordX-1,coordY, getValueListOfLists(coordX,coordY,matrix),false),List(coordX,coordY))
        /*
         * 0 1 1
         * 1 1 0
         * 1 0 0
         * */
        //println("diagonalLeft1")
        //println(diagonalLeft1)
        val diagonalLeft2 = introducePosition(getListPosDiagonalLeft(matrix,coordX,coordY+1, getValueListOfLists(coordX,coordY,matrix),true),List(coordX,coordY))
        /*
         * 0 0 1
         * 0 1 1
         * 1 1 0
         * */
        //println("diagonalLeft2")
        //println(diagonalLeft2)
        val listPos = introduceDiagonal(diagonalLeft2,introduceDiagonal(diagonalLeft1,introduceDiagonal(diagonalRight2,introduceDiagonal(diagonalRight1, listPositions))))
        getListPosDiagonals(matrix, position+1, listPos)
      }  
    }
    else listPositions
  }
  //Devuelve la lista de posiciones que se encuentran en una de las diagonales que van a derechas
  def getListPosDiagonalRight(matrix:List[List[String]],x: Int, y: Int, color: String,situation: Boolean): List[List[Int]]={
    if(situation) //Posición estudiada es la que se encuentra hacia abajo
    {
      //Considera que la posición no está vacía y es del mismo color que el pasado por parámetro
      if(!isEmptyPosUpDown(matrix, x, y) && isEqual(getValueListOfLists(x,y,matrix), color))
      {
        getListPosDiagonalRight(matrix,x+1,y,color,changeSituation(situation)):::List(List(x,y))
      }
      else Nil
    }
    else //Posición estudiada es la que se encuentra hacia la derecha
    {
      //Considera que la posición no está vacía y es del mismo color que el pasado por parámetro
      if(!isEmptyPosRightLeft(matrix, x, y) && isEqual(getValueListOfLists(x,y,matrix), color))
      {
        getListPosDiagonalRight(matrix,x,y+1,color,changeSituation(situation)):::List(List(x,y))
      }
      else Nil
    }
  }
  //Devuelve la lista de posiciones que se encuentran en una de las diagonales que van a izquierdas
  def getListPosDiagonalLeft(matrix:List[List[String]],x: Int, y: Int, color: String,situation: Boolean): List[List[Int]]={
    if(situation) //Posición estudiada es la que se encuentra hacia abajo
    {
      //Considera que la posición no está vacía y es del mismo color que el pasado por parámetro
      if(!isEmptyPosUpDown(matrix, x, y) && isEqual(getValueListOfLists(x,y,matrix), color))
      {
        getListPosDiagonalLeft(matrix,x-1,y,color,changeSituation(situation)):::List(List(x,y))
      }
      else Nil
    }
    else //Posición estudiada es la que se encuentra hacia la izquierda
    {
      //Considera que la posición no está vacía y es del mismo color que el pasado por parámetro
      if(!isEmptyPosRightLeft(matrix, x, y) && isEqual(getValueListOfLists(x,y,matrix), color))
      {
        getListPosDiagonalLeft(matrix,x,y+1,color,changeSituation(situation)):::List(List(x,y))
      }
      else Nil
    }
  }
  //Invierte el estado de la situación
  def changeSituation(situation: Boolean): Boolean={
    if(situation) false
    else true
  }
  //Une dos listas posiciones sin valores repetidos
  def introduceDiagonal(l1: List[List[Int]], l2:List[List[Int]]): List[List[Int]]={
    //Une dos listas posiciones si el número de posiciones es mayor a 4
    if(l1.length > 4) introduceDiagonalAux(l1,l2)
    else l2
  }
  //Une dos listas posiciones sin valores repetidos
  def introduceDiagonalAux(l1: List[List[Int]], l2:List[List[Int]]): List[List[Int]]={
    //Comprueba si la primera lista está vacía
    if(l1.!=(List(Nil)) && l1.!=(Nil))
    {
      //Comprueba si un elemento se encuentra en una lista y en caso contrario, lo introduce
      if(!containPosition(l2,l1.head)) introduceDiagonalAux(l1.tail, l2 ::: List(l1.head))
      else introduceDiagonalAux(l1.tail, l2)
    }
    else l2
  }
  //Devuelve la lista de las posiciones vacías de la matriz
  def getListFreePositions(matrix: List[List[String]], position: Int): List[List[Int]] = {
    val posX = position/9
    val posY = position%9
    if(position >= 81) Nil
    else
    {
      if(isEmptyPosListOfLists(posX, posY, matrix)) List(List(posX, posY)) ::: getListFreePositions(matrix, position + 1)
      else getListFreePositions(matrix, position + 1)
    }
  }
}