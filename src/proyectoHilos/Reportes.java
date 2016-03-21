package proyectoHilos;
import java.io.*;
import javax.swing.*;
@SuppressWarnings("deprecation")
public class Reportes implements Runnable{
	DataInputStream registro;
	JTextArea j=new JTextArea(25,20); JScrollPane p=new JScrollPane(j);
	String linea;

	public void run(){
		do{try{
			MainProyecto.ciclo[3]=true;
		MainProyecto.r.join(50);
		LeerEmpleados();
		MainProyecto.r.suspend();
	}catch(Exception e){}}while(MainProyecto.ciclo[3]);}

	public void LeerEmpleados(){try{
		registro=new DataInputStream(new FileInputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro.txt"));// LEE ARCHIVO
		j.setText(""); int estado=0,n=0,numT=0;
		while ((linea= registro.readLine())!=null){n++;
		if ((n-1)%6==0){numT=Integer.parseInt(linea.substring(0,linea.length()));}
		if((n-2)%6==0){estado=Integer.parseInt(linea.substring(7,8));}
		if (estado!=0){if((n-2)%6==0){j.append(numT+"\n");j.append(linea+"\n");}
						else{if(linea.length()>6)j.append(linea+"\n");}}
		System.out.println(linea);}registro.close();
		JOptionPane.showMessageDialog(null,p,"Registro de Empleados:",JOptionPane.PLAIN_MESSAGE);
		}catch(IOException e){
			JOptionPane.showMessageDialog(null,"No hay empleados registrados","Error",2);	}}
}
