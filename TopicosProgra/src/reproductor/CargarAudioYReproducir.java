package reproductor;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CargarAudioYReproducir extends JApplet {
 	private static final long serialVersionUID = 1L;
 	private AudioClip sonido1, sonido2, sonidoActual;
   private JButton reproducirSonido, sonidoContinuo, detenerSonido;
   private JComboBox seleccionarSonido;

   public void init()   {
      Container contenedor = getContentPane();
      contenedor.setLayout( new FlowLayout());
      String[] opciones = {"Hi","Ren&Stimpy"};
      seleccionarSonido = new JComboBox(opciones);
      seleccionarSonido.addItemListener(
         new ItemListener() { public void itemStateChanged(ItemEvent e){ sonidoActual.stop();
               sonidoActual =  seleccionarSonido.getSelectedItem().toString().equals("Hi") ? sonido1 : sonido2;} });

      contenedor.add( seleccionarSonido );

      ButtonHandler manejador = new ButtonHandler();

      reproducirSonido = new JButton( "Reproducir" );
      reproducirSonido.addActionListener( manejador );
      contenedor.add( reproducirSonido );

      sonidoContinuo = new JButton( "Continuo" );
      sonidoContinuo.addActionListener( manejador );
      contenedor.add( sonidoContinuo );

      detenerSonido = new JButton( "Detener" );
      detenerSonido.addActionListener( manejador );
      contenedor.add( detenerSonido );

      sonido1 = getAudioClip( getDocumentBase(), "multimedia/hi.au" );
      sonido2 = getAudioClip( getDocumentBase(), "multimedia/Ren And Stimpy 1.aif" );
      sonidoActual = sonido1;   }


   public void stop() {
      sonidoActual.stop();}

   // clase interna privada para manejar eventos de botón
   private class ButtonHandler implements ActionListener {

      // procesar eventos de reproducir, sonido continuo y detener
      public void actionPerformed( ActionEvent eventoAccion )
      {
         if ( eventoAccion.getSource() == reproducirSonido )
            sonidoActual.play();

         else if ( eventoAccion.getSource() == sonidoContinuo )
            sonidoActual.loop();

         else if ( eventoAccion.getSource() == detenerSonido )
            sonidoActual.stop();
      }

   }
}