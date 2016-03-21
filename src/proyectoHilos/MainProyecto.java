package proyectoHilos;
import javax.swing.*;
public class MainProyecto {

	static Thread a=new Thread(new Altas());
	static Thread b=new Thread(new Bajas());
	static Thread m=new Thread(new Modificaciones());
	static Thread r=new Thread(new Reportes());
	static Thread n=new Thread(new Nomina());
	static boolean[] ciclo=new boolean[5];

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		int op = 0;
		a.setPriority(10);		b.setPriority(6);		m.setPriority(8);		r.setPriority(8);
		n.setPriority(10);


		do{try{op=Integer.parseInt(JOptionPane.showInputDialog("\tMenu \n1) Altas \n2) Bajas" +
				"\n3) Modificaciones \n4) Reportes \n5) Nomina \n6) Salir","Eligir Opcion"));
		switch(op){
		case 1:if(a.isAlive()==false)a.start();
				else{a.resume();}break;

		case 2:if(b.isAlive()==false)b.start();
				else{b.resume();}break;

		case 3:if(m.isAlive()==false)m.start();
				else{m.resume();}break;

		case 4:if(r.isAlive()==false)r.start();
				else{r.resume();}break;

		case 5:if(n.isAlive()==false)n.start();
				else{n.resume();}break;

		case 6:System.exit(0);break;

		default:JOptionPane.showMessageDialog(null,"Opcion Incorrecta","Error",JOptionPane.ERROR_MESSAGE);}
		}catch(NumberFormatException e){JOptionPane.showMessageDialog(null,"Solo Numeros!","Error",JOptionPane.ERROR_MESSAGE);}
		catch(Exception e){}}while(op!=6);

	}}