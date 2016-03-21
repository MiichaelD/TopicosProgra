package animacion;// Fig. 19.2: AnimadorLogo.java
// Animaci�n de una serie de im�genes.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnimadorLogo extends JPanel implements ActionListener {

   private static final long serialVersionUID = 1L;
   protected ImageIcon[] imagenes;     // arreglo de im�genes
   private int imagenesTotales = 10,i;     // n�mero de im�genes
   private int imagenActual = 0;    	 // �ndice de imagen actual
   private int retrasoAnimacion = 41;    // retraso en milisegundos
   private int anchura;                  // anchura de la imagen
   private int altura;             	 	 // altura de la imagen
   private Timer temporizadorAnimacion;  // el objeto Timer controla la animaci�n

   // inicializar objeto AnimadorLogo cargando las im�genes
   public AnimadorLogo(){
      imagenes = new ImageIcon[ imagenesTotales ];
      for (int cuenta=0;cuenta<imagenes.length;cuenta++)
         imagenes[cuenta]=new ImageIcon(getClass().getResource("/animacion/"+"Dash_"+(cuenta+1)+".GIF"));
      anchura = imagenes[0].getIconWidth();
      altura = imagenes[0].getIconHeight(); }

   public void paint(Graphics g){ super.paintComponent( g );// mostrar imagen actual
   imagenes[ imagenActual ].paintIcon( this, g, 0, 0 );
   if ( temporizadorAnimacion.isRunning() ){ imagenActual = ( imagenActual + 1 ) % imagenesTotales;
   		System.out.println(i++);}}

   // responder al evento del objeto Timer
   public void actionPerformed( ActionEvent eventoAccion ){
      repaint();} // repintar el animador..Llamar paint();

   // iniciar o reiniciar la animaci�n
   public void iniciarAnimacion(){
      if ( temporizadorAnimacion == null ) { imagenActual = 0;
         temporizadorAnimacion = new Timer( retrasoAnimacion, this );
         temporizadorAnimacion.start();      }
      else // continuar desde la �ltima imagen mostrada
         if ( ! temporizadorAnimacion.isRunning() )
            temporizadorAnimacion.restart();
   }

   // detener el temporizador de la animaci�n
   public void detenerAnimacion()
   {
      temporizadorAnimacion.stop();
   }

   // devolver el tama�o m�nimo de la animaci�n
   public Dimension getMinimumSize()
   {
      return getPreferredSize();
   }

   // devolver el tama�o preferido de la animaci�n
   public Dimension getPreferredSize()
   {
      return new Dimension( anchura, altura );
   }

   // ejecutar la animaci�n en un objeto JFrame
   public static void main( String args[] ){
      AnimadorLogo animacion = new AnimadorLogo(); // crear el objeto AnimadorLogo

      JFrame ventana = new JFrame( "Prueba del animador" ); // configurar ventana
      ventana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      ventana.setLocationRelativeTo(null);
      ventana.add(animacion);
      ventana.pack();  // hacer la ventana lo suficientemente grande para su GUI
      ventana.setVisible( true );   // mostrar la ventana
      animacion.iniciarAnimacion();  // comenzar la animaci�n

   } // fin del m�todo main

}