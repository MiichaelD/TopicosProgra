package animacion;// Fig. 19.2: AnimadorLogo.java
// Animación de una serie de imágenes.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnimadorLogo extends JPanel implements ActionListener {

   private static final long serialVersionUID = 1L;
   protected ImageIcon[] imagenes;     // arreglo de imágenes
   private int imagenesTotales = 10,i;     // número de imágenes
   private int imagenActual = 0;    	 // índice de imagen actual
   private int retrasoAnimacion = 41;    // retraso en milisegundos
   private int anchura;                  // anchura de la imagen
   private int altura;             	 	 // altura de la imagen
   private Timer temporizadorAnimacion;  // el objeto Timer controla la animación

   // inicializar objeto AnimadorLogo cargando las imágenes
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

   // iniciar o reiniciar la animación
   public void iniciarAnimacion(){
      if ( temporizadorAnimacion == null ) { imagenActual = 0;
         temporizadorAnimacion = new Timer( retrasoAnimacion, this );
         temporizadorAnimacion.start();      }
      else // continuar desde la última imagen mostrada
         if ( ! temporizadorAnimacion.isRunning() )
            temporizadorAnimacion.restart();
   }

   // detener el temporizador de la animación
   public void detenerAnimacion()
   {
      temporizadorAnimacion.stop();
   }

   // devolver el tamaño mínimo de la animación
   public Dimension getMinimumSize()
   {
      return getPreferredSize();
   }

   // devolver el tamaño preferido de la animación
   public Dimension getPreferredSize()
   {
      return new Dimension( anchura, altura );
   }

   // ejecutar la animación en un objeto JFrame
   public static void main( String args[] ){
      AnimadorLogo animacion = new AnimadorLogo(); // crear el objeto AnimadorLogo

      JFrame ventana = new JFrame( "Prueba del animador" ); // configurar ventana
      ventana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      ventana.setLocationRelativeTo(null);
      ventana.add(animacion);
      ventana.pack();  // hacer la ventana lo suficientemente grande para su GUI
      ventana.setVisible( true );   // mostrar la ventana
      animacion.iniciarAnimacion();  // comenzar la animación

   } // fin del método main

}