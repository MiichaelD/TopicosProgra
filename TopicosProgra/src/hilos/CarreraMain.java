package hilos;
import javax.swing.*;
public class CarreraMain {
	static int cont=0;	static String[] pos=new String[4];
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		boolean band=false;
		Thread Tor=new Thread(new CarreraTor());  // implementa
		Thread Lie=new Thread(new CarreraLie()); //extiende
		CarreraCab Cab=new CarreraCab();		 //extiende
		Thread Ven=new Thread(new CarreraVen()); // implementa

		Tor.start();	Lie.start();		Cab.start();		Ven.start();

		do{if (cont==4){try{JOptionPane.showMessageDialog(null,"1ro.- "+pos[0]+
				"\n2do.- "+pos[1]+"\n3ro.- "+pos[2]+"\n4to.- "+pos[3],"TABLA DE POSICIONES",JOptionPane.PLAIN_MESSAGE);
				band=true;}		catch(Exception e){}}	}while(band!=true);
		Tor.stop(); Lie.stop(); Cab.stop(); Ven.stop(); }
		}

    class CarreraCab extends Thread{
	public void run(){
		System.out.println("Comienza CABALLO");
		for(int i=0;i<5;i++){
			try{Thread.sleep((int)(Math.random()*1600)); System.out.println("caballo");
			}catch(Exception e){}}

		CarreraMain.pos[CarreraMain.cont]="Caballo";
		CarreraMain.cont++;
		System.out.println("Termina el Caballo en: "+CarreraMain.cont);}}

    class CarreraLie extends Thread{
    	public void run(){
    		System.out.println("Comienza LIEBRE");
    		for(int i=0;i<5;i++){
    			try{Thread.sleep((int)(Math.random()*2000)); System.out.println("liebre");
    			}catch(Exception e){}}

    		CarreraMain.pos[CarreraMain.cont]="Liebre";
    		CarreraMain.cont+=1;
    		System.out.println("Termina la Liebre en: "+CarreraMain.cont);}}

    class CarreraVen implements Runnable{
    	@SuppressWarnings("deprecation")
    	public void run(){
    		System.out.println("Comienza VENADO");
    		for(int i=0;i<5;i++){
    			try{Thread.sleep((int)(Math.random()*1800)); System.out.println("Venado");
    			}catch(Exception e){}}

    		CarreraMain.pos[CarreraMain.cont]="Venado";
    		CarreraMain.cont++;
    		System.out.println("Termina el Venado en: "+CarreraMain.cont);}}

    class CarreraTor implements Runnable{
    	public void run(){
    		System.out.println("Comienza TORTUGA");
    		for(int i=0;i<5;i++){
    			if (i==2)continue;
    			try{Thread.sleep((int)(Math.random()*2200)); System.out.println("tortuga");
    			}catch(Exception e){}}

    		CarreraMain.pos[CarreraMain.cont]="Tortuga";
    		CarreraMain.cont+=1;
    		System.out.println("Termina la Tortuga en: "+CarreraMain.cont);}}