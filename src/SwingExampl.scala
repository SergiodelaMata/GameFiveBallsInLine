
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.Action
import java.awt.event.{ ActionEvent, ActionListener }
import javax.swing.{ JButton, _ }

import java.awt.Label;
import java.awt.MouseInfo;
import java.awt.Point;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import java.awt.Graphics;
import scala.concurrent.Await

import javax.swing.JLabel;
import java.util.Observable

object SwingExampl extends App {

  val textArea = new JTextArea
  textArea.setText("Hello, Swing world")
  val scrollPane = new JScrollPane(textArea)
  var temporalLabel = 0;

  val blancoCasilla = new ImageIcon("blanco.jpg");
  val imgRedimensionadaBlanca = new ImageIcon(blancoCasilla.getImage().getScaledInstance(46, 46, 1));
  //Set para imagen roja
  val imagenRoja = new ImageIcon("red.png");
  val imgRedimensionadaRoja = new ImageIcon(imagenRoja.getImage().getScaledInstance(46, 46, 1));
  //Set para imagen Yellow
  val imagenYellow = new ImageIcon("yellow.jpg");
  val imgRedimensionadaYellow = new ImageIcon(imagenYellow.getImage().getScaledInstance(46, 46, 1));
  //Set para imagen Green
  val imagenGreen = new ImageIcon("green.png");
  val imgRedimensionadaGreen = new ImageIcon(imagenGreen.getImage().getScaledInstance(46, 46, 1));
  //Set para imagen Blue
  val imagenBlue = new ImageIcon("azul.png");
  val imgRedimensionadaBlue = new ImageIcon(imagenBlue.getImage().getScaledInstance(46, 46, 1));
  //Set para imagen Gray
  val imagenGray = new ImageIcon("gray.png");
  val imgRedimensionadaGray = new ImageIcon(imagenGray.getImage().getScaledInstance(46, 46, 1));
  //Set para imagen Purple
  val imagenPurple = new ImageIcon("purple.png");
  val imgRedimensionadaPurple = new ImageIcon(imagenPurple.getImage().getScaledInstance(46, 46, 1));
  //Set para imagen Orange
  val imagenOrange = new ImageIcon("orange.png");
  val imgRedimensionadaOrange = new ImageIcon(imagenOrange.getImage().getScaledInstance(46, 46, 1));

 val imagenMenu = new ImageIcon("menu.jpg");
 val imgRedimensionadaMenu = new ImageIcon(imagenMenu.getImage().getScaledInstance(400, 400, 1));

  var presionado = false;
  def changeSituation(situation: Boolean): Boolean = {
    if (situation) false
    else true
  }

  def getImagen() = {
    jLabel1.setSize(500, 500);
    val imagen = new ImageIcon("tablero2_1.png");
    val imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), 1));
    jLabel1.setIcon(imgRedimensionada);
  }
  def getImagen2(jlabelactual: javax.swing.JLabel) = {
    jlabelactual.setSize(45, 45);
    jlabelactual.setIcon(imgRedimensionadaBlanca);
  }

  def getImagen3(jlabelactual: javax.swing.JLabel) = {
    jlabelactual.setSize(45, 45);
    val imagen = new ImageIcon("orange.png");
    val imgRedimensionadaOrange = new ImageIcon(imagen.getImage().getScaledInstance(jlabelactual.getWidth(), jlabelactual.getHeight(), 1));
    jlabelactual.setIcon(imgRedimensionadaOrange);
  }

  val jLabel1 = new javax.swing.JLabel();
  jLabel1.setMinimumSize(new java.awt.Dimension(50, 50));
  jLabel1.setPreferredSize(new java.awt.Dimension(45, 40));
  jLabel1.setLayout(null);
  getImagen();
  jLabel1.setBounds(0, 0, 660, 570); //CORDX,COORDY,SIZE,SIZE
  
  val jLabel2 = new javax.swing.JLabel();
  jLabel2.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel2.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel2.setBounds(29, 44, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel2.setLayout(null);
  getImagen2(jLabel2);
  
  val jLabel3 = new javax.swing.JLabel();
  jLabel3.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel3.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel3.setBounds(81, 44, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel3.setLayout(null);
  getImagen2(jLabel3);
  
  val jLabel4 = new javax.swing.JLabel();
  jLabel4.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel4.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel4.setBounds(133, 44, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel4.setLayout(null);
  getImagen2(jLabel4);
  
  val jLabel5 = new javax.swing.JLabel();
  jLabel5.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel5.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel5.setBounds(184, 44, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel5.setLayout(null);
  getImagen2(jLabel5);

  val jLabel6 = new javax.swing.JLabel();
  jLabel6.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel6.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel6.setBounds(237, 44, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel6.setLayout(null);
  getImagen2(jLabel6);

  val jLabel7 = new javax.swing.JLabel();
  jLabel7.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel7.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel7.setBounds(291, 44, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel7.setLayout(null);
  getImagen2(jLabel7);

  val jLabel8 = new javax.swing.JLabel();
  jLabel8.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel8.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel8.setBounds(342, 44, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel8.setLayout(null);
  getImagen2(jLabel8);

  val jLabel9 = new javax.swing.JLabel();
  jLabel9.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel9.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel9.setBounds(394, 44, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel9.setLayout(null);
  getImagen2(jLabel9);

  val jLabel10 = new javax.swing.JLabel();
  jLabel10.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel10.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel10.setBounds(447, 44, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel10.setLayout(null);
  getImagen2(jLabel10);

  val jLabel11 = new javax.swing.JLabel();
  jLabel11.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel11.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel11.setBounds(29, 96, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel11.setLayout(null);
  getImagen2(jLabel11);

  val jLabel12 = new javax.swing.JLabel();
  jLabel12.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel12.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel12.setBounds(81, 96, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel12.setLayout(null);
  getImagen2(jLabel12);

  val jLabel13 = new javax.swing.JLabel();
  jLabel13.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel13.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel13.setBounds(133, 96, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel13.setLayout(null);
  getImagen2(jLabel13);

  val jLabel14 = new javax.swing.JLabel();
  jLabel14.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel14.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel14.setBounds(184, 96, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel14.setLayout(null);
  getImagen2(jLabel14);

  val jLabel15 = new javax.swing.JLabel();
  jLabel15.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel15.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel15.setBounds(237, 96, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel15.setLayout(null);
  getImagen2(jLabel15);

  val jLabel16 = new javax.swing.JLabel();
  jLabel16.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel16.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel16.setBounds(291, 96, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel16.setLayout(null);
  getImagen2(jLabel16);

  val jLabel17 = new javax.swing.JLabel();
  jLabel17.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel17.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel17.setBounds(342, 96, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel17.setLayout(null);
  getImagen2(jLabel17);

  val jLabel18 = new javax.swing.JLabel();
  jLabel18.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel18.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel18.setBounds(394, 96, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel18.setLayout(null);
  getImagen2(jLabel18);

  val jLabel19 = new javax.swing.JLabel();
  jLabel19.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel19.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel19.setBounds(447, 96, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel19.setLayout(null);
  getImagen2(jLabel19);

  val jLabel20 = new javax.swing.JLabel();
  jLabel20.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel20.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel20.setBounds(29, 146, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel20.setLayout(null);
  getImagen2(jLabel20);

  val jLabel21 = new javax.swing.JLabel();
  jLabel21.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel21.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel21.setBounds(81, 146, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel21.setLayout(null);
  getImagen2(jLabel21);

  val jLabel22 = new javax.swing.JLabel();
  jLabel22.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel22.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel22.setBounds(133, 146, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel22.setLayout(null);
  getImagen2(jLabel22);

  val jLabel23 = new javax.swing.JLabel();
  jLabel23.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel23.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel23.setBounds(184, 146, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel23.setLayout(null);
  getImagen2(jLabel23);

  val jLabel24 = new javax.swing.JLabel();
  jLabel24.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel24.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel24.setBounds(237, 146, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel24.setLayout(null);
  getImagen2(jLabel24);

  val jLabel25 = new javax.swing.JLabel();
  jLabel25.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel25.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel25.setBounds(291, 146, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel25.setLayout(null);
  getImagen2(jLabel25);

  val jLabel26 = new javax.swing.JLabel();
  jLabel26.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel26.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel26.setBounds(342, 146, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel26.setLayout(null);
  getImagen2(jLabel26);

  val jLabel27 = new javax.swing.JLabel();
  jLabel27.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel27.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel27.setBounds(394, 146, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel27.setLayout(null);
  getImagen2(jLabel27);

  val jLabel28 = new javax.swing.JLabel();
  jLabel28.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel28.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel28.setBounds(447, 146, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel28.setLayout(null);
  getImagen2(jLabel28);

  val jLabel29 = new javax.swing.JLabel();
  jLabel29.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel29.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel29.setBounds(29, 200, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel29.setLayout(null);
  getImagen2(jLabel29);

  val jLabel30 = new javax.swing.JLabel();
  jLabel30.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel30.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel30.setBounds(81, 200, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel30.setLayout(null);
  getImagen2(jLabel30);

  val jLabel31 = new javax.swing.JLabel();
  jLabel31.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel31.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel31.setBounds(133, 200, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel31.setLayout(null);
  getImagen2(jLabel31);

  val jLabel32 = new javax.swing.JLabel();
  jLabel32.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel32.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel32.setBounds(184, 200, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel32.setLayout(null);
  getImagen2(jLabel32);

  val jLabel33 = new javax.swing.JLabel();
  jLabel33.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel33.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel33.setBounds(237, 200, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel33.setLayout(null);
  getImagen2(jLabel33);

  val jLabel34 = new javax.swing.JLabel();
  jLabel34.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel34.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel34.setBounds(291, 200, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel34.setLayout(null);
  getImagen2(jLabel34);

  val jLabel35 = new javax.swing.JLabel();
  jLabel35.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel35.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel35.setBounds(342, 200, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel35.setLayout(null);
  getImagen2(jLabel35);

  val jLabel36 = new javax.swing.JLabel();
  jLabel36.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel36.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel36.setBounds(394, 200, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel36.setLayout(null);
  getImagen2(jLabel36);

  val jLabel37 = new javax.swing.JLabel();
  jLabel37.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel37.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel37.setBounds(447, 200, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel37.setLayout(null);
  getImagen2(jLabel37);

  val jLabel38 = new javax.swing.JLabel();
  jLabel38.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel38.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel38.setBounds(29, 251, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel38.setLayout(null);
  getImagen2(jLabel38);

  val jLabel39 = new javax.swing.JLabel();
  jLabel39.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel39.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel39.setBounds(81, 251, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel39.setLayout(null);
  getImagen2(jLabel39);

  val jLabel40 = new javax.swing.JLabel();
  jLabel40.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel40.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel40.setBounds(133, 251, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel40.setLayout(null);
  getImagen2(jLabel40);

  val jLabel41 = new javax.swing.JLabel();
  jLabel41.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel41.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel41.setBounds(184, 251, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel41.setLayout(null);
  getImagen2(jLabel41);

  val jLabel42 = new javax.swing.JLabel();
  jLabel42.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel42.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel42.setBounds(237, 251, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel42.setLayout(null);
  getImagen2(jLabel42);

  val jLabel43 = new javax.swing.JLabel();
  jLabel43.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel43.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel43.setBounds(291, 251, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel43.setLayout(null);
  getImagen2(jLabel43);

  val jLabel44 = new javax.swing.JLabel();
  jLabel44.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel44.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel44.setBounds(342, 251, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel44.setLayout(null);
  getImagen2(jLabel44);

  val jLabel45 = new javax.swing.JLabel();
  jLabel45.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel45.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel45.setBounds(394, 251, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel45.setLayout(null);
  getImagen2(jLabel45);

  val jLabel46 = new javax.swing.JLabel();
  jLabel46.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel46.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel46.setBounds(447, 251, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel46.setLayout(null);
  getImagen2(jLabel46);

  val jLabel47 = new javax.swing.JLabel();
  jLabel47.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel47.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel47.setBounds(29, 304, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel47.setLayout(null);
  getImagen2(jLabel47);

  val jLabel48 = new javax.swing.JLabel();
  jLabel48.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel48.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel48.setBounds(81, 304, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel48.setLayout(null);
  getImagen2(jLabel48);

  val jLabel49 = new javax.swing.JLabel();
  jLabel49.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel49.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel49.setBounds(133, 304, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel49.setLayout(null);
  getImagen2(jLabel49);

  val jLabel50 = new javax.swing.JLabel();
  jLabel50.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel50.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel50.setBounds(184, 304, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel50.setLayout(null);
  getImagen2(jLabel50);

  val jLabel51 = new javax.swing.JLabel();
  jLabel51.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel51.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel51.setBounds(237, 304, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel51.setLayout(null);
  getImagen2(jLabel51);

  val jLabel52 = new javax.swing.JLabel();
  jLabel52.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel52.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel52.setBounds(291, 304, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel52.setLayout(null);
  getImagen2(jLabel52);

  val jLabel53 = new javax.swing.JLabel();
  jLabel53.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel53.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel53.setBounds(342, 304, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel53.setLayout(null);
  getImagen2(jLabel53);

  val jLabel54 = new javax.swing.JLabel();
  jLabel54.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel54.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel54.setBounds(394, 304, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel54.setLayout(null);
  getImagen2(jLabel54);

  val jLabel55 = new javax.swing.JLabel();
  jLabel55.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel55.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel55.setBounds(447, 304, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel55.setLayout(null);
  getImagen2(jLabel55);

  val jLabel56 = new javax.swing.JLabel();
  jLabel56.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel56.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel56.setBounds(29, 356, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel56.setLayout(null);
  getImagen2(jLabel56);

  val jLabel57 = new javax.swing.JLabel();
  jLabel57.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel57.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel57.setBounds(81, 356, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel57.setLayout(null);
  getImagen2(jLabel57);

  val jLabel58 = new javax.swing.JLabel();
  jLabel58.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel58.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel58.setBounds(133, 356, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel58.setLayout(null);
  getImagen2(jLabel58);

  val jLabel59 = new javax.swing.JLabel();
  jLabel59.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel59.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel59.setBounds(184, 356, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel59.setLayout(null);
  getImagen2(jLabel59);

  val jLabel60 = new javax.swing.JLabel();
  jLabel60.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel60.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel60.setBounds(237, 356, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel60.setLayout(null);
  getImagen2(jLabel60);

  val jLabel61 = new javax.swing.JLabel();
  jLabel61.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel61.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel61.setBounds(291, 356, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel61.setLayout(null);
  getImagen2(jLabel61);

  val jLabel62 = new javax.swing.JLabel();
  jLabel62.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel62.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel62.setBounds(342, 356, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel62.setLayout(null);
  getImagen2(jLabel62);

  val jLabel63 = new javax.swing.JLabel();
  jLabel63.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel63.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel63.setBounds(394, 356, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel63.setLayout(null);
  getImagen2(jLabel63);

  val jLabel64 = new javax.swing.JLabel();
  jLabel64.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel64.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel64.setBounds(447, 356, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel64.setLayout(null);
  getImagen2(jLabel64);

  val jLabel65 = new javax.swing.JLabel();
  jLabel65.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel65.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel65.setBounds(29, 408, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel65.setLayout(null);
  getImagen2(jLabel65);

  val jLabel66 = new javax.swing.JLabel();
  jLabel66.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel66.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel66.setBounds(81, 408, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel66.setLayout(null);
  getImagen2(jLabel66);

  val jLabel67 = new javax.swing.JLabel();
  jLabel67.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel67.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel67.setBounds(133, 408, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel67.setLayout(null);
  getImagen2(jLabel67);

  val jLabel68 = new javax.swing.JLabel();
  jLabel68.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel68.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel68.setBounds(184, 408, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel68.setLayout(null);
  getImagen2(jLabel68);

  val jLabel69 = new javax.swing.JLabel();
  jLabel69.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel69.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel69.setBounds(237, 408, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel69.setLayout(null);
  getImagen2(jLabel69);

  val jLabel70 = new javax.swing.JLabel();
  jLabel70.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel70.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel70.setBounds(291, 408, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel70.setLayout(null);
  getImagen2(jLabel70);

  val jLabel71 = new javax.swing.JLabel();
  jLabel71.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel71.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel71.setBounds(342, 408, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel71.setLayout(null);
  getImagen2(jLabel71);

  val jLabel72 = new javax.swing.JLabel();
  jLabel72.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel72.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel72.setBounds(394, 408, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel72.setLayout(null);
  getImagen2(jLabel72);

  val jLabel73 = new javax.swing.JLabel();
  jLabel73.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel73.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel73.setBounds(447, 408, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel73.setLayout(null);
  getImagen2(jLabel73);

  val jLabel74 = new javax.swing.JLabel();
  jLabel74.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel74.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel74.setBounds(29, 460, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel74.setLayout(null);
  getImagen2(jLabel74);

  val jLabel75 = new javax.swing.JLabel();
  jLabel75.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel75.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel75.setBounds(81, 460, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel75.setLayout(null);
  getImagen2(jLabel75);

  val jLabel76 = new javax.swing.JLabel();
  jLabel76.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel76.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel76.setBounds(133, 460, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel76.setLayout(null);
  getImagen2(jLabel76);

  val jLabel77 = new javax.swing.JLabel();
  jLabel77.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel77.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel77.setBounds(184, 460, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel77.setLayout(null);
  getImagen2(jLabel77);

  val jLabel78 = new javax.swing.JLabel();
  jLabel78.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel78.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel78.setBounds(237, 460, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel78.setLayout(null);
  getImagen2(jLabel78);

  val jLabel79 = new javax.swing.JLabel();
  jLabel79.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel79.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel79.setBounds(291, 460, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel79.setLayout(null);
  getImagen2(jLabel79);

  val jLabel80 = new javax.swing.JLabel();
  jLabel80.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel80.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel80.setBounds(342, 460, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel80.setLayout(null);
  getImagen2(jLabel80);

  val jLabel81 = new javax.swing.JLabel();
  jLabel81.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel81.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel81.setBounds(394, 460, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel81.setLayout(null);
  getImagen2(jLabel81);

  val jLabel82 = new javax.swing.JLabel();
  jLabel82.setMinimumSize(new java.awt.Dimension(46, 46));
  jLabel82.setPreferredSize(new java.awt.Dimension(46, 46));
  jLabel82.setBounds(447, 460, 45, 45); //CORDX,COORDY,SIZE,SIZE
  jLabel82.setLayout(null);
  getImagen2(jLabel82);

  val jButton1 = new javax.swing.JButton("counter");
  jButton1.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton1.setBounds(29, 44, 45, 45);
  jButton1.setOpaque(false);
  jButton1.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
     
      val i = 0;
     
      if (presionado == false) {
       
        presionar1(i)
      } else {
        presionar2(i)
      }
      print(jLabels(i))

    }
  })

  val jButton2 = new javax.swing.JButton("counter");
  jButton2.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton2.setBounds(81, 44, 45, 45);
  jButton2.setOpaque(false);
  jButton2.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 1; // i es siempre 1 menos que el jbutton
       println("Soy el 2");
      if (presionado == false) {
        presionar1(i)
        println("lo primero que quiero ver i/9 = "+ i/9);
        println("lo primero que quiero ver i%9 = "+ i%9);
      } else {
        
        presionar2(i)
      }

      print(jLabels(i))
    }
  })

  val jButton3 = new javax.swing.JButton("counter");
  jButton3.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton3.setBounds(133, 44, 45, 45);
  jButton3.setOpaque(false);
  jButton3.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 2; // i es siempre 1 menos que el jbutton
      println("Soy el 3");  
      if (presionado == false) {
        presionar1(i)
        println("lo primero que quiero ver i/9 = "+ i/9);
        println("lo primero que quiero ver i%9 = "+ i%9);
      } else {
        
        presionar2(i)
      }

      print(jLabels(i))
    }
  })

  val jButton4 = new javax.swing.JButton("counter");
  jButton4.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton4.setBounds(184, 44, 45, 45);
  jButton4.setOpaque(false);
  jButton4.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 3; // i es siempre 1 menos que el jbutton
     
      if (presionado == false) {
        presionar1(i)
        println("lo primero que quiero ver i/9 = "+ i/9);
        println("lo primero que quiero ver i%9 = "+ i%9);
      } else {
        
        presionar2(i)
      }

      print(jLabels(i))
    }
  })

  val jButton5 = new javax.swing.JButton("counter");
  jButton5.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton5.setBounds(237, 44, 45, 45);
  jButton5.setOpaque(false);
  jButton5.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 4; // i es siempre 1 menos que el jbutton
 
      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

      print(jLabels(i))
    }
  })

  val jButton6 = new javax.swing.JButton("counter");
  jButton6.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton6.setBounds(291, 44, 45, 45);
  jButton6.setOpaque(false);
  jButton6.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 5; // i es siempre 1 menos que el jbutton
 
      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

      print(jLabels(i))
    }
  })

  val jButton7 = new javax.swing.JButton("counter");
  jButton7.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton7.setBounds(342, 44, 45, 45);
  jButton7.setOpaque(false);
  jButton7.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 6; // i es siempre 1 menos que el jbutton
  println("Soy el 7"); 
      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }
      print(jLabels(i))

    }
  })

  val jButton8 = new javax.swing.JButton("counter");
  jButton8.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton8.setBounds(394, 44, 45, 45);
  jButton8.setOpaque(false);
  jButton8.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 7; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

      print(jLabels(i))
    }
  })

  val jButton9 = new javax.swing.JButton("counter");
  jButton9.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton9.setBounds(447, 44, 45, 45);
  jButton9.setOpaque(false);
  jButton9.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 8; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton10 = new javax.swing.JButton("counter");
  jButton10.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton10.setBounds(29, 96, 45, 45);
  jButton10.setOpaque(false);
  jButton10.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 9; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton11 = new javax.swing.JButton("counter");
  jButton11.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton11.setBounds(81, 96, 45, 45);
  jButton11.setOpaque(false);
  jButton11.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 10; // i es siempre 1 menos que el jbutton
      println("Soy el 11"); 
      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton12 = new javax.swing.JButton("counter");
  jButton12.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton12.setBounds(133, 96, 45, 45);
  jButton12.setOpaque(false);
  jButton12.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 11; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton13 = new javax.swing.JButton("counter");
  jButton13.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton13.setBounds(184, 96, 45, 45);
  jButton13.setOpaque(false);
  jButton13.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 12; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton14 = new javax.swing.JButton("counter");
  jButton14.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton14.setBounds(237, 96, 45, 45);
  jButton14.setOpaque(false);
  jButton14.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 13; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton15 = new javax.swing.JButton("counter");
  jButton15.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton15.setBounds(291, 96, 45, 45);
  jButton15.setOpaque(false);
  jButton15.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 14; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton16 = new javax.swing.JButton("counter");
  jButton16.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton16.setBounds(342, 96, 45, 45);
  jButton16.setOpaque(false);
  jButton16.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 15; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton17 = new javax.swing.JButton("counter");
  jButton17.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton17.setBounds(394, 96, 45, 45);
  jButton17.setOpaque(false);
  jButton17.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 16; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton18 = new javax.swing.JButton("counter");
  jButton18.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton18.setBounds(447, 96, 45, 45);
  jButton18.setOpaque(false);
  jButton18.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 17; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton19 = new javax.swing.JButton("counter");
  jButton19.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton19.setBounds(29, 146, 45, 45);
  jButton19.setOpaque(false);
  jButton19.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 18; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
          println("lo primero que quiero ver i/9 = "+ i/9);
        println("lo primero que quiero ver i%9 = "+ i%9);
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton20 = new javax.swing.JButton("counter");
  jButton20.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton20.setBounds(81, 146, 45, 45);
  jButton20.setOpaque(false);
  jButton20.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 19; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton21 = new javax.swing.JButton("counter");
  jButton21.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton21.setBounds(133, 146, 45, 45);
  jButton21.setOpaque(false);
  jButton21.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 20; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton22 = new javax.swing.JButton("counter");
  jButton22.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton22.setBounds(184, 146, 45, 45);
  jButton22.setOpaque(false);
  jButton22.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 21; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton23 = new javax.swing.JButton("counter");
  jButton23.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton23.setBounds(237, 146, 45, 45);
  jButton23.setOpaque(false);
  jButton23.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 22; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton24 = new javax.swing.JButton("counter");
  jButton24.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton24.setBounds(291, 146, 45, 45);
  jButton24.setOpaque(false);
  jButton24.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 23; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton25 = new javax.swing.JButton("counter");
  jButton25.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton25.setBounds(342, 146, 45, 45);
  jButton25.setOpaque(false);
  jButton25.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 24; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton26 = new javax.swing.JButton("counter");
  jButton26.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton26.setBounds(394, 146, 45, 45);
  jButton26.setOpaque(false);
  jButton26.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 25; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton27 = new javax.swing.JButton("counter");
  jButton27.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton27.setBounds(447, 146, 45, 45);
  jButton27.setOpaque(false);
  jButton27.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 26; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton28 = new javax.swing.JButton("counter");
  jButton28.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton28.setBounds(29, 200, 45, 45);
  jButton28.setOpaque(false);
  jButton28.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 27; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton29 = new javax.swing.JButton("counter");
  jButton29.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton29.setBounds(81, 200, 45, 45);
  jButton29.setOpaque(false);
  jButton29.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 28; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton30 = new javax.swing.JButton("counter");
  jButton30.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton30.setBounds(133, 200, 45, 45);
  jButton30.setOpaque(false);
  jButton30.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 29; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton31 = new javax.swing.JButton("counter");
  jButton31.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton31.setBounds(184, 200, 45, 45);
  jButton31.setOpaque(false);
  jButton31.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 30; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton32 = new javax.swing.JButton("counter");
  jButton32.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton32.setBounds(237, 200, 45, 45);
  jButton32.setOpaque(false);
  jButton32.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 31; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton33 = new javax.swing.JButton("counter");
  jButton33.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton33.setBounds(291, 200, 45, 45);
  jButton33.setOpaque(false);
  jButton33.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 32; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton34 = new javax.swing.JButton("counter");
  jButton34.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton34.setBounds(342, 200, 45, 45);
  jButton34.setOpaque(false);
  jButton34.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 33; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton35 = new javax.swing.JButton("counter");
  jButton35.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton35.setBounds(394, 200, 45, 45);
  jButton35.setOpaque(false);
  jButton35.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 34; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton36 = new javax.swing.JButton("counter");
  jButton36.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton36.setBounds(447, 200, 45, 45);
  jButton36.setOpaque(false);
  jButton36.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 35; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton37 = new javax.swing.JButton("counter");
  jButton37.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton37.setBounds(29, 251, 45, 45);
  jButton37.setOpaque(false);
  jButton37.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 36; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton38 = new javax.swing.JButton("counter");
  jButton38.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton38.setBounds(81, 251, 45, 45);
  jButton38.setOpaque(false);
  jButton38.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 37; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton39 = new javax.swing.JButton("counter");
  jButton39.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton39.setBounds(133, 251, 45, 45);
  jButton39.setOpaque(false);
  jButton39.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 38; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton40 = new javax.swing.JButton("counter");
  jButton40.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton40.setBounds(184, 251, 45, 45);
  jButton40.setOpaque(false);
  jButton40.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 39; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton41 = new javax.swing.JButton("counter");
  jButton41.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton41.setBounds(237, 251, 45, 45);
  jButton41.setOpaque(false);
  jButton41.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 40; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton42 = new javax.swing.JButton("counter");
  jButton42.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton42.setBounds(291, 251, 45, 45);
  jButton42.setOpaque(false);
  jButton42.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 41; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton43 = new javax.swing.JButton("counter");
  jButton43.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton43.setBounds(342, 251, 45, 45);
  jButton43.setOpaque(false);
  jButton43.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 42; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton44 = new javax.swing.JButton("counter");
  jButton44.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton44.setBounds(394, 251, 45, 45);
  jButton44.setOpaque(false);
  jButton44.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 43; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton45 = new javax.swing.JButton("counter");
  jButton45.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton45.setBounds(447, 251, 45, 45);
  jButton45.setOpaque(false);
  jButton45.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 44; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton46 = new javax.swing.JButton("counter");
  jButton46.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton46.setBounds(29, 304, 45, 45);
  jButton46.setOpaque(false);
  jButton46.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 45; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton47 = new javax.swing.JButton("counter");
  jButton47.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton47.setBounds(81, 304, 45, 45);
  jButton47.setOpaque(false);
  jButton47.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 46; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton48 = new javax.swing.JButton("counter");
  jButton48.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton48.setBounds(133, 304, 45, 45);
  jButton48.setOpaque(false);
  jButton48.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 47; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton49 = new javax.swing.JButton("counter");
  jButton49.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton49.setBounds(184, 304, 45, 45);
  jButton49.setOpaque(false);
  jButton49.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 48; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton50 = new javax.swing.JButton("counter");
  jButton50.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton50.setBounds(237, 304, 45, 45);
  jButton50.setOpaque(false);
  jButton50.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 49; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton51 = new javax.swing.JButton("counter");
  jButton51.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton51.setBounds(291, 304, 45, 45);
  jButton51.setOpaque(false);
  jButton51.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 50; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton52 = new javax.swing.JButton("counter");
  jButton52.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton52.setBounds(342, 304, 45, 45);
  jButton52.setOpaque(false);
  jButton52.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 51; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton53 = new javax.swing.JButton("counter");
  jButton53.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton53.setBounds(394, 304, 45, 45);
  jButton53.setOpaque(false);
  jButton53.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 52; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton54 = new javax.swing.JButton("counter");
  jButton54.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton54.setBounds(447, 304, 45, 45);
  jButton54.setOpaque(false);
  jButton54.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 53; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton55 = new javax.swing.JButton("counter");
  jButton55.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton55.setBounds(29, 356, 45, 45);
  jButton55.setOpaque(false);
  jButton55.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 54; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton56 = new javax.swing.JButton("counter");
  jButton56.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton56.setBounds(81, 356, 45, 45);
  jButton56.setOpaque(false);
  jButton56.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 55; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton57 = new javax.swing.JButton("counter");
  jButton57.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton57.setBounds(133, 356, 45, 45);
  jButton57.setOpaque(false);
  jButton57.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 56; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton58 = new javax.swing.JButton("counter");
  jButton58.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton58.setBounds(184, 356, 45, 45);
  jButton58.setOpaque(false);
  jButton58.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 57; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton59 = new javax.swing.JButton("counter");
  jButton59.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton59.setBounds(237, 356, 45, 45);
  jButton59.setOpaque(false);
  jButton59.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 58; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton60 = new javax.swing.JButton("counter");
  jButton60.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton60.setBounds(291, 356, 45, 45);
  jButton60.setOpaque(false);
  jButton60.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 59; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton61 = new javax.swing.JButton("counter");
  jButton61.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton61.setBounds(342, 356, 45, 45);
  jButton61.setOpaque(false);
  jButton61.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 60; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton62 = new javax.swing.JButton("counter");
  jButton62.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton62.setBounds(394, 356, 45, 45);
  jButton62.setOpaque(false);
  jButton62.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 61; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton63 = new javax.swing.JButton("counter");
  jButton63.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton63.setBounds(447, 356, 45, 45);
  jButton63.setOpaque(false);
  jButton63.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 62; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton64 = new javax.swing.JButton("counter");
  jButton64.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton64.setBounds(29, 408, 45, 45);
  jButton64.setOpaque(false);
  jButton64.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 63; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton65 = new javax.swing.JButton("counter");
  jButton65.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton65.setBounds(81, 408, 45, 45);
  jButton65.setOpaque(false);
  jButton65.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 64; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton66 = new javax.swing.JButton("counter");
  jButton66.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton66.setBounds(133, 408, 45, 45);
  jButton66.setOpaque(false);
  jButton66.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 65; // i es siempre 1 menos que el jbutton
      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }
    }
  })

  val jButton67 = new javax.swing.JButton("counter");
  jButton67.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton67.setBounds(184, 408, 45, 45);
  jButton67.setOpaque(false);
  jButton67.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 66; // i es siempre 1 menos que el jbutton
      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }
    }
  })

  val jButton68 = new javax.swing.JButton("counter");
  jButton68.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton68.setBounds(237, 408, 45, 45);
  jButton68.setOpaque(false);
  jButton68.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 67; // i es siempre 1 menos que el jbutton
      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }
    }
  })

  val jButton69 = new javax.swing.JButton("counter");
  jButton69.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton69.setBounds(291, 408, 45, 45);
  jButton69.setOpaque(false);
  jButton69.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 68; // i es siempre 1 menos que el jbutton
      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }
    }
  })

  val jButton70 = new javax.swing.JButton("counter");
  jButton70.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton70.setBounds(342, 408, 45, 45);
  jButton70.setOpaque(false);
  jButton70.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 69; // i es siempre 1 menos que el jbutton
      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }
    }
  })

  val jButton71 = new javax.swing.JButton("counter");
  jButton71.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton71.setBounds(394, 408, 45, 45);
  jButton71.setOpaque(false);
  jButton71.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 70; // i es siempre 1 menos que el jbutton
      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }
    }
  })

  val jButton72 = new javax.swing.JButton("counter");
  jButton72.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton72.setBounds(447, 408, 45, 45);
  jButton72.setOpaque(false);
  jButton72.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 71; // i es siempre 1 menos que el jbutton
      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }
    }
  })

  val jButton73 = new javax.swing.JButton("counter");
  jButton73.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton73.setBounds(29, 460, 45, 45);
  jButton73.setOpaque(false);
  jButton73.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 72; // i es siempre 1 menos que el jbutton
      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }
    }
  })

  val jButton74 = new javax.swing.JButton("counter");
  jButton74.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton74.setBounds(81, 460, 45, 45);
  jButton74.setOpaque(false);
  jButton74.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 73; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }
    }
  })

  val jButton75 = new javax.swing.JButton("counter");
  jButton75.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton75.setBounds(133, 460, 45, 45);
  jButton75.setOpaque(false);
  jButton75.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 74; // i es siempre 1 menos que el jbutton
      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }
    }
  })

  val jButton76 = new javax.swing.JButton("counter");
  jButton76.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton76.setBounds(184, 460, 45, 45);
  jButton76.setOpaque(false);
  jButton76.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 75; // i es siempre 1 menos que el jbutton
      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }
    }
  })

  val jButton77 = new javax.swing.JButton("counter");
  jButton77.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton77.setBounds(237, 460, 45, 45);
  jButton77.setOpaque(false);
  jButton77.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 76; // i es siempre 1 menos que el jbutton

      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }
    }
  })

  val jButton78 = new javax.swing.JButton("counter");
  jButton78.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton78.setBounds(291, 460, 45, 45);
  jButton78.setOpaque(false);
  jButton78.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 77; // i es siempre 1 menos que el jbutton
      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }
    }
  })

  val jButton79 = new javax.swing.JButton("counter");
  jButton79.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton79.setBounds(342, 460, 45, 45);
  jButton79.setOpaque(false);
  jButton79.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 78; // i es siempre 1 menos que el jbutton
      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }

    }
  })

  val jButton80 = new javax.swing.JButton("counter");
  jButton80.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton80.setBounds(394, 460, 45, 45);
  jButton80.setOpaque(false);
  jButton80.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 79; // i es siempre 1 menos que el jbutton
        println("Soy el 80"); 
      if (presionado == false) {
        presionar1(i)
      } else {
        
        presionar2(i)
      }

    }
  })

  val jButton81 = new javax.swing.JButton("counter");
  jButton81.setPreferredSize(new java.awt.Dimension(45, 40));
  jButton81.setBounds(447, 460, 45, 45);
  jButton81.setOpaque(false);
  jButton81.addActionListener(new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      val i = 80; // i es siempre 1 menos que el jbutton
    println("Soy el 81"); 
      if (presionado == false) {
        presionar1(i)
      } else {
        presionar2(i)
      }
    }
  })
  
  val jPanel2 = new javax.swing.JPanel
  jPanel2.setMinimumSize(new java.awt.Dimension(700, 700));
  jPanel2.setLayout(null);
  jPanel2.setBounds(0, 0, 610, 510);
  jPanel2.setOpaque(false);

  val jPanel1 = new javax.swing.JPanel
  jPanel1.setMinimumSize(new java.awt.Dimension(700, 700));
  jPanel1.setLayout(null);
  jPanel1.setBounds(0, 0, 610, 510);

  jPanel1.add(jPanel2);
  
  jPanel2.add(jLabel2);
  jPanel2.add(jLabel3);
  jPanel2.add(jLabel4);
  jPanel2.add(jLabel5);
  jPanel2.add(jLabel6);
  jPanel2.add(jLabel7);
  jPanel2.add(jLabel8);
  jPanel2.add(jLabel9);
  jPanel2.add(jLabel10);
  jPanel2.add(jLabel11);
  jPanel2.add(jLabel12);
  jPanel2.add(jLabel13);
  jPanel2.add(jLabel14);
  jPanel2.add(jLabel15);
  jPanel2.add(jLabel16);
  jPanel2.add(jLabel17);
  jPanel2.add(jLabel18);
  jPanel2.add(jLabel19);
  jPanel2.add(jLabel20);
  jPanel2.add(jLabel21);
  jPanel2.add(jLabel22);
  jPanel2.add(jLabel23);
  jPanel2.add(jLabel24);
  jPanel2.add(jLabel25);
  jPanel2.add(jLabel26);
  jPanel2.add(jLabel27);
  jPanel2.add(jLabel28);
  jPanel2.add(jLabel29);
  jPanel2.add(jLabel30);
  jPanel2.add(jLabel31);
  jPanel2.add(jLabel32);
  jPanel2.add(jLabel33);
  jPanel2.add(jLabel34);
  jPanel2.add(jLabel35);
  jPanel2.add(jLabel36);
  jPanel2.add(jLabel37);
  jPanel2.add(jLabel38);
  jPanel2.add(jLabel39);
  jPanel2.add(jLabel40);
  jPanel2.add(jLabel41);
  jPanel2.add(jLabel42);
  jPanel2.add(jLabel43);
  jPanel2.add(jLabel44);
  jPanel2.add(jLabel45);
  jPanel2.add(jLabel46);
  jPanel2.add(jLabel47);
  jPanel2.add(jLabel48);
  jPanel2.add(jLabel49);
  jPanel2.add(jLabel50);
  jPanel2.add(jLabel51);
  jPanel2.add(jLabel52);
  jPanel2.add(jLabel53);
  jPanel2.add(jLabel54);
  jPanel2.add(jLabel55);
  jPanel2.add(jLabel56);
  jPanel2.add(jLabel57);
  jPanel2.add(jLabel58);
  jPanel2.add(jLabel59);
  jPanel2.add(jLabel60);
  jPanel2.add(jLabel61);
  jPanel2.add(jLabel62);
  jPanel2.add(jLabel63);
  jPanel2.add(jLabel64);
  jPanel2.add(jLabel65);
  jPanel2.add(jLabel66);
  jPanel2.add(jLabel67);
  jPanel2.add(jLabel68);
  jPanel2.add(jLabel69);
  jPanel2.add(jLabel70);
  jPanel2.add(jLabel71);
  jPanel2.add(jLabel72);
  jPanel2.add(jLabel73);
  jPanel2.add(jLabel74);
  jPanel2.add(jLabel75);
  jPanel2.add(jLabel76);
  jPanel2.add(jLabel77);
  jPanel2.add(jLabel78);
  jPanel2.add(jLabel79);
  jPanel2.add(jLabel80);
  jPanel2.add(jLabel81);
  jPanel2.add(jLabel82);

  jPanel1.add(jButton1);
  jPanel1.add(jButton2);
  jPanel1.add(jButton3);
  jPanel1.add(jButton4);
  jPanel1.add(jButton5);
  jPanel1.add(jButton6);
  jPanel1.add(jButton7);
  jPanel1.add(jButton8);
  jPanel1.add(jButton9);
  jPanel1.add(jButton10);
  jPanel1.add(jButton11);
  jPanel1.add(jButton12);
  jPanel1.add(jButton13);
  jPanel1.add(jButton14);
  jPanel1.add(jButton15);
  jPanel1.add(jButton16);
  jPanel1.add(jButton17);
  jPanel1.add(jButton18);
  jPanel1.add(jButton19);
  jPanel1.add(jButton20);
  jPanel1.add(jButton21);
  jPanel1.add(jButton22);
  jPanel1.add(jButton23);
  jPanel1.add(jButton24);
  jPanel1.add(jButton25);
  jPanel1.add(jButton26);
  jPanel1.add(jButton27);
  jPanel1.add(jButton28);
  jPanel1.add(jButton29);
  jPanel1.add(jButton30);
  jPanel1.add(jButton31);
  jPanel1.add(jButton32);
  jPanel1.add(jButton33);
  jPanel1.add(jButton34);
  jPanel1.add(jButton35);
  jPanel1.add(jButton36);
  jPanel1.add(jButton37);
  jPanel1.add(jButton38);
  jPanel1.add(jButton39);
  jPanel1.add(jButton40);
  jPanel1.add(jButton41);
  jPanel1.add(jButton42);
  jPanel1.add(jButton43);
  jPanel1.add(jButton44);
  jPanel1.add(jButton45);
  jPanel1.add(jButton46);
  jPanel1.add(jButton47);
  jPanel1.add(jButton48);
  jPanel1.add(jButton49);
  jPanel1.add(jButton50);
  jPanel1.add(jButton51);
  jPanel1.add(jButton52);
  jPanel1.add(jButton53);
  jPanel1.add(jButton54);
  jPanel1.add(jButton55);
  jPanel1.add(jButton56);
  jPanel1.add(jButton57);
  jPanel1.add(jButton58);
  jPanel1.add(jButton59);
  jPanel1.add(jButton60);
  jPanel1.add(jButton61);
  jPanel1.add(jButton62);
  jPanel1.add(jButton63);
  jPanel1.add(jButton64);
  jPanel1.add(jButton65);
  jPanel1.add(jButton66);
  jPanel1.add(jButton67);
  jPanel1.add(jButton68);
  jPanel1.add(jButton69);
  jPanel1.add(jButton70);
  jPanel1.add(jButton71);
  jPanel1.add(jButton72);
  jPanel1.add(jButton73);
  jPanel1.add(jButton74);
  jPanel1.add(jButton75);
  jPanel1.add(jButton76);
  jPanel1.add(jButton77);
  jPanel1.add(jButton78);
  jPanel1.add(jButton79);
  jPanel1.add(jButton80);
  jPanel1.add(jButton81);
  jPanel1.add(jLabel1);
  val jLabels = List(jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel16, jLabel17, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22, jLabel23,
    jLabel24, jLabel25, jLabel26, jLabel27, jLabel28, jLabel29, jLabel30, jLabel31, jLabel32, jLabel33, jLabel34, jLabel35, jLabel36, jLabel37, jLabel38, jLabel39, jLabel40, jLabel41, jLabel42, jLabel43, jLabel44, jLabel45,
    jLabel46, jLabel47, jLabel48, jLabel49, jLabel50, jLabel51, jLabel52, jLabel53, jLabel54, jLabel55, jLabel56, jLabel57, jLabel58, jLabel59, jLabel60, jLabel61, jLabel62, jLabel63, jLabel64, jLabel65, jLabel66, jLabel67, jLabel68,
    jLabel69, jLabel70, jLabel71, jLabel72, jLabel73, jLabel74, jLabel75, jLabel76, jLabel77, jLabel78, jLabel79, jLabel80, jLabel81, jLabel82)
  def presionar1(i: Int) = {
    if (!imgRedimensionadaBlanca.toString().equals(getValueListForLabels(i, jLabels).getIcon().toString())) {
      temporalLabel = i 
      println(presionado)
      presionado = changeSituation(presionado)
      println(presionado)
    } else {
      println("Repita la jugada");
    }
  }

  def presionar2(i: Int) = {
    jLabels(i).setSize(46, 46);
    val temporalLabel2 = temporalLabel;
    temporalLabel = i;
    if( getValueListForLabels(i, jLabels).getIcon().toString().equals(imgRedimensionadaBlanca.toString()))
    {
    if(getValueListForLabels(i, jLabels).getIcon().toString().equals(imgRedimensionadaBlanca.toString()))
    {
    if (getValueListForLabels(temporalLabel2, jLabels).getIcon().toString().equals(imgRedimensionadaBlue.toString())) {

      getValueListForLabels(i, jLabels).setIcon(imgRedimensionadaBlue);
    }
    if (getValueListForLabels(temporalLabel2, jLabels).getIcon().toString().equals(imgRedimensionadaYellow.toString())) {

      getValueListForLabels(i, jLabels).setIcon(imgRedimensionadaYellow);
    }
    if (getValueListForLabels(temporalLabel2, jLabels).getIcon().toString().equals(imgRedimensionadaPurple.toString())) {
      
      getValueListForLabels(i, jLabels).setIcon(imgRedimensionadaPurple);
    }
    if (getValueListForLabels(temporalLabel2, jLabels).getIcon().toString().equals(imgRedimensionadaOrange.toString())) {

      getValueListForLabels(i, jLabels).setIcon(imgRedimensionadaOrange);
    }
    if (getValueListForLabels(temporalLabel2, jLabels).getIcon().toString().equals(imgRedimensionadaGreen.toString())) {

      getValueListForLabels(i, jLabels).setIcon(imgRedimensionadaGreen);
    }
    if (getValueListForLabels(temporalLabel2, jLabels).getIcon().toString().equals(imgRedimensionadaGray.toString())) {

      getValueListForLabels(i, jLabels).setIcon(imgRedimensionadaGray);
    }
    if (getValueListForLabels(temporalLabel2, jLabels).getIcon().toString().equals(imgRedimensionadaRoja.toString())) {
      getValueListForLabels(i, jLabels).setIcon(imgRedimensionadaRoja);
    }
    getValueListForLabels(temporalLabel2, jLabels).setIcon(imgRedimensionadaBlanca);
    presionado = changeSituation(presionado);
   }
    }
    else{
        println("Repita la jugada");
    }
  }
  //Devuelve el valor de una posición de una lista de strings
  def getValueListForLabels(pos: Int, lista: List[javax.swing.JLabel]): javax.swing.JLabel = {
    if (pos.!=(0)) getValueListForLabels(pos - 1, lista.tail)
    else lista.head
  }

  def setRandomImages() = {
   
    getImagenIndividualBlue(jLabels, random(0, 81));
    getImagenIndividualBlue(jLabels, random(0, 81));
    getImagenIndividualGreen(jLabels, random(0, 81));
    getImagenIndividualGray(jLabels, random(0, 81));
    getImagenIndividualOrange(jLabels, random(0, 81));
    getImagenIndividualYellow(jLabels, random(0, 81));
    getImagenIndividualRed(jLabels, random(0, 81));
    getImagenIndividualPurple(jLabels, random(0, 81));
  }

  def random(min: Int, max: Int): Int = {
    val random = scala.util.Random
    val randomAux = random.nextInt(max - min)
    val resultado = randomAux + min
    resultado
  }
  def getImagenIndividualBlue(lista: List[javax.swing.JLabel], i: Int) {
    
    getValueListForLabels(i, lista).setIcon(imgRedimensionadaBlue);
  }
  def getImagenIndividualGreen(lista: List[javax.swing.JLabel], i: Int) {
    getValueListForLabels(i, lista).setIcon(imgRedimensionadaGreen);
  }
  def getImagenIndividualGray(lista: List[javax.swing.JLabel], i: Int) {
    getValueListForLabels(i, lista).setIcon(imgRedimensionadaGray);
  }
  def getImagenIndividualOrange(lista: List[javax.swing.JLabel], i: Int) {
    getValueListForLabels(i, lista).setIcon(imgRedimensionadaOrange);
  }
  def getImagenIndividualYellow(lista: List[javax.swing.JLabel], i: Int) {
    getValueListForLabels(i, lista).setIcon(imgRedimensionadaYellow);
  }
  def getImagenIndividualRed(lista: List[javax.swing.JLabel], i: Int) {
    getValueListForLabels(i, lista).setIcon(imgRedimensionadaRoja);
  }
  def getImagenIndividualPurple(lista: List[javax.swing.JLabel], i: Int) {
    getValueListForLabels(i, lista).setIcon(imgRedimensionadaPurple);
  }
  def getValueList(pos: Int, lista: List[String]): String = {
    if(pos.!=(0)) getValueList(pos-1, lista.tail)
    else lista.head
  }
  
  def getValueListOfLists(posX: Int, posY: Int, matrix: List[List[String]]): String = {
    if(posX.!=(0)) getValueListOfLists(posX-1, posY, matrix.tail)
    else getValueList(posY, matrix.head)
  }
  
  //Realiza la actualización del frame del tablero
  def actualizarTablero(tablero:List[List[String]], pos:Int):List[List[String]]={
   val coordX = pos / 9
    val coordY = pos % 9
    
     if(pos<81)
    {

      if (getValueListOfLists(coordX, coordY, tablero).equals("A")) {
        getValueListForLabels(pos, jLabels).setIcon(imgRedimensionadaYellow);
      }
      if (getValueListOfLists(coordX, coordY, tablero).equals("N")) {
        getValueListForLabels(pos, jLabels).setIcon(imgRedimensionadaOrange);
      }
      if (getValueListOfLists(coordX, coordY, tablero).equals("R")) {
        getValueListForLabels(pos, jLabels).setIcon(imgRedimensionadaRoja);
      }
      if (getValueListOfLists(coordX, coordY, tablero).equals("V")) {
        getValueListForLabels(pos, jLabels).setIcon(imgRedimensionadaGreen);
      }

      if (getValueListOfLists(coordX, coordY, tablero).equals("M")) {
        getValueListForLabels(pos, jLabels).setIcon(imgRedimensionadaPurple);
      }
       if( getValueListOfLists(coordX ,coordY,tablero).equals("G")){
       getValueListForLabels(pos, jLabels).setIcon(imgRedimensionadaGray);
        }   
       
          if( getValueListOfLists(coordX ,coordY,tablero).equals("-")){
       getValueListForLabels(pos, jLabels).setIcon(imgRedimensionadaBlanca);
        }   

        actualizarTablero(tablero,pos+1)
    }
    else
    {
 
      tablero
    }
  }
  setRandomImages();
  
  def setCoordenadas():List[Int]={
    List(5,4);
}
  val frame = new JFrame("GAME")
  //Inicia el frame del juego
  def comenzar() ={
    frame.getContentPane.add(jPanel1, BorderLayout.CENTER)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setSize(new Dimension(600, 600))
    frame.setLocationRelativeTo(null)
    frame.setVisible(true)
    Game.main(args);
  }
  def getPresionadoState():Boolean={
    presionado;
  }
  def getTemporalLabel():Int={
    temporalLabel
  }
  def sendBoolean(valido:Boolean):Boolean={
    valido
  }
  //Cierra el frame
  def close(){
    frame.dispose()
  }
  
  def sendAnyNumber(i:Int):Int={
    i;
  }
  def changeStatePresionadoFromRemote()={
    changeSituation(presionado);
  }
  
  def recivirTablero(tablero:List[List[String]]):List[List[String]]={
    tablero:List[List[String]]
  }
comenzar();


}
