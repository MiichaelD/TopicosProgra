package proyectoHilos;
import java.io.*;

import javax.swing.*;
@SuppressWarnings("deprecation")
public class Bajas implements Runnable{
	JTextArea j=new JTextArea(25,22);
	JScrollPane p=new JScrollPane(j);

	Thread a=new Thread();	int op=0,n=0,numT=0,eliminar=-1;	double sueldoh;	String linea;
	String[] cadenas=new String[100];
	DataInputStream registro,registro2;	DataOutputStream escritor,escritor2;

	public void run(){
		LeerEmpleados();
		do{try{MainProyecto.b.join(40);
		MainProyecto.ciclo[1]=true;
	op=Integer.parseInt(JOptionPane.showInputDialog("1) Dar de Baja a Empleado.\n2) Volver a Menu Principal.","Menu Bajas"));
	switch(op){
	case 1:if(numT!=0){LeerEmpleados();Eliminar();imprimirN();}
			else{Thread.sleep(50);JOptionPane.showMessageDialog(null,"No hay Empleados Registrados","Error",2);}break;
	case 2:{MainProyecto.b.suspend();break;}
	case 3:MainProyecto.ciclo[1]=false;break;
	default:JOptionPane.showMessageDialog(null,"Opcion Incorrecta!","Error",2);break;
	}
		}catch(Exception e){JOptionPane.showMessageDialog(null,"Solo Numeros!","Error",2);}
	}while(MainProyecto.ciclo[1]);}

	public void Eliminar(){try{
		boolean band=false; int c=0; int estado;
		registro=new DataInputStream(new FileInputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro.txt"));
		escritor2=new DataOutputStream(new FileOutputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro2.txt"));
		eliminar=Integer.parseInt(JOptionPane.showInputDialog("Numero de Empleado a Desactivar:\n\"0\" para Cancelar"));
			j.setText("");n=0; if(eliminar==0)band=true;
		while ((linea= registro.readLine())!=null){n++; if ((n-1)%6==0)
			{numT=Integer.parseInt((linea.substring(0,linea.length())));}
			if(numT!=eliminar){System.out.println(linea);
				if (n==1){j.append(""+linea); escritor2.writeBytes(linea);}
				else {j.append("\n"+linea);escritor2.writeBytes("\n"+linea);}}
			else {band=true;c++;
				if(c!=2){System.out.println(linea);
					if (n==1){j.append(""+linea); escritor2.writeBytes(linea);}
					else {j.append("\n"+linea);escritor2.writeBytes("\n"+linea);}}
				else{estado=Integer.parseInt(linea.substring(7,linea.length()));
					if(estado!=0){estado=0;}
					else{JOptionPane.showMessageDialog(null,"Empleado ya esta de Baja","ERROR",JOptionPane.ERROR_MESSAGE);}
						escritor2.writeBytes("\nEstado:"+estado);}}}
		escritor2.close();		registro.close();
		if(band==false)JOptionPane.showMessageDialog(null,"No existe empleado #"+eliminar,"ERROR",JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){JOptionPane.showMessageDialog(null,"NO se pudo eliminar","ERROR",JOptionPane.ERROR_MESSAGE);}}


	public void LeerEmpleados(){try{
		registro=new DataInputStream(new FileInputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro.txt"));// LEE ARCHIVO
		j.setText("");n=0;numT=0;
		while ((linea= registro.readLine())!=null){n++;if ((n-1)%6==0)
		{numT=Integer.parseInt((linea.substring(0,linea.length())));}
		System.out.println(linea);j.append(linea+"\n");}registro.close();
		}catch(IOException e){}	}

	public void imprimirN(){try{
		escritor=new DataOutputStream(new FileOutputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro.txt"));// CREA ARCHIVO
		registro2=new DataInputStream(new FileInputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro2.txt"));
		j.setText("");n=0;
		while ((linea= registro2.readLine())!=null){n++;
		System.out.println(linea);if (n==1){j.append(""+linea); escritor.writeBytes(linea+"\n");}
		else {j.append("\n"+linea);escritor.writeBytes(linea+"\n");}}}catch(Exception e){}}

	public void Leer(){
		JOptionPane.showMessageDialog(null,p,"Registro de Empleados:",JOptionPane.PLAIN_MESSAGE);}
}
