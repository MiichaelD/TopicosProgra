package proyectoHilos;
import java.io.*;

import javax.swing.*;
public class Altas implements Runnable{
	Thread a=new Thread();	int op=0,n=0,numT=0,diasT;	double sueldoh;	String nombre,puesto,linea;
	DataInputStream registro;	DataOutputStream escritor;

	@SuppressWarnings("deprecation")
	public void run(){
		do{try{MainProyecto.a.join(50);
		LeerEmpleados(); MainProyecto.ciclo[0]=true;
		op=Integer.parseInt(JOptionPane.showInputDialog("1) Dar de Alta a Empleado.\n2) Volver Menu Principal.","Menu Altas"));
			switch(op){
			case 1:{Agregar();MainProyecto.ciclo[0]=true;break;}
			case 2:{MainProyecto.a.suspend();break;}
			case 3:MainProyecto.ciclo[0]=false;break;
			default:{JOptionPane.showMessageDialog(null,"Opcion Incorrecta!","Error",JOptionPane.ERROR_MESSAGE); }
			}

		}catch(Exception e){JOptionPane.showMessageDialog(null,"Solo Numeros!","Error",JOptionPane.ERROR_MESSAGE);}
		}while(MainProyecto.ciclo[0]);}

	public void Agregar(){try{
		numT++;
		nombre=JOptionPane.showInputDialog("Trabajador Numero: "+numT+"\nNombre:","Introducir Nombre");
		puesto=JOptionPane.showInputDialog("Trabajador Numero: "+numT+"\nNombre:"+nombre+"\nPuesto:","Introducir Puesto");
		sueldoh=Double.parseDouble(JOptionPane.showInputDialog("Trabajador Numero: "
				+numT+"\nNombre: "+nombre+"\nPuesto: "+puesto+"\nSueldo Diario:","Introducir Sueldo"));
		diasT=Integer.parseInt(JOptionPane.showInputDialog("Trabajador Numero: "
				+numT+"\nNombre: "+nombre+"\nPuesto: "+puesto+"\nSueldo Diario: "+sueldoh+"\nDias de Trabajo:","Introducir Dias de Trabajo"));
		escritor.writeBytes(""+numT);
		escritor.writeBytes("\nEstado:"+1);
		escritor.writeBytes("\nNombre:"+nombre);
		escritor.writeBytes("\nPuesto:"+puesto);
		escritor.writeBytes("\nSueldo:"+sueldoh);
		escritor.writeBytes("\nDias  :"+diasT+"\n");
		escritor.close();
		JOptionPane.showMessageDialog(null,"Numero Trabajador: "+numT+"\nNombre: "+nombre+"\nPuesto: "+puesto+
				"\nSueldo/Dia: "+sueldoh+"\nDias Trabajo: "+diasT,"Se AGREGO:",JOptionPane.PLAIN_MESSAGE);
		}catch(Exception e){JOptionPane.showMessageDialog(null,"Empleado no Agregado!","Error",JOptionPane.ERROR_MESSAGE);}}

	@SuppressWarnings("deprecation")
	public void LeerEmpleados(){try{
		escritor=new DataOutputStream(new FileOutputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro.txt",true));// CREA ARCHIVO
		registro=new DataInputStream(new FileInputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro.txt"));// LEE ARCHIVO
		n=0;numT=0;
		while ((linea= registro.readLine())!=null){n++;System.out.println(linea);
		if ((n-1)%6==0){numT=Integer.parseInt(linea);}}
		registro.close();
		}catch(IOException e){
			JOptionPane.showMessageDialog(null,"Error no se pudo Leer","Excepcion!",JOptionPane.PLAIN_MESSAGE);		}	}
}