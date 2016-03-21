package proyectoHilos;
import java.io.*;

import javax.swing.*;
@SuppressWarnings("deprecation")
public class Modificaciones implements Runnable{
	JTextArea j=new JTextArea(25,22);	JScrollPane p=new JScrollPane(j);
	int op=0,n=0,numT=0;	double sueldoh;	String linea;
	DataInputStream registro,registro2;	DataOutputStream escritor,escritor2;

	public void run(){
		LeerEmpleados();do{
			MainProyecto.ciclo[2]=true;
			try{MainProyecto.m.join(50);
	op=Integer.parseInt(JOptionPane.showInputDialog("1) Modificar Empleado.\n2) Volver Menu Principal.","Menu Modificaciones"));
	switch(op){
	case 1:{LeerEmpleados();if(numT!=0){Modificar();imprimirN();}
			else JOptionPane.showMessageDialog(null,"No hay Empleados Registrados","ERROR",2);break;}
	case 2:{MainProyecto.m.suspend();break;}
	case 3:MainProyecto.ciclo[2]=false;break;
	default:JOptionPane.showMessageDialog(null,"Opcion Incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);}

	}catch(Exception e){JOptionPane.showMessageDialog(null,"Solo Numeros!","Error",JOptionPane.ERROR_MESSAGE);}
	}while(MainProyecto.ciclo[2]);
		}

	public void Modificar(){try{
		registro=new DataInputStream(new FileInputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro.txt"));
		escritor2=new DataOutputStream(new FileOutputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro2.txt"));
		String[] info=new String[6];
		String modulo1=null,modulo=null,mod=null,datos; int modificar=-1,con=0;
		if(numT==0){JOptionPane.showMessageDialog(null,"No hay empleados");}

		else{modificar=Integer.parseInt(JOptionPane.showInputDialog("Numero de Empleado a Modificar:\n\"0\" para Cancelar"));
			j.setText("");n=0;
			while ((linea= registro.readLine())!=null){n++; if ((n-1)%6==0)
			{numT=Integer.parseInt((linea.substring(0,linea.length())));}
			if(numT!=modificar){System.out.println(linea);if (n==1){j.append(linea); escritor2.writeBytes(linea);}
														else {j.append("\n"+linea);escritor2.writeBytes("\n"+linea);}}
			else {if(n==1){info[con]=linea;System.out.println(info[con]);j.append(info[con]);escritor2.writeBytes(info[con]);con++; }
					else{ if (con==0){info[con]=linea;System.out.println(linea);j.append("\n"+linea);escritor2.writeBytes("\n"+info[con]);con++;}

						else{modulo=linea.substring(0,6); datos=linea.substring(7,linea.length());
							if (con==5){modulo1="Dias de trabajo";}
							else {modulo1=modulo;}
							if(con==1){mod="  (1=Activo,0=Inactivo)";}
								info[con]=JOptionPane.showInputDialog(modulo1+" actual: "+datos+"\nNuevo:"+mod,datos);
								System.out.println(modulo+":"+info[con]);j.append("\n"+modulo+":"+info[con]);
								escritor2.writeBytes("\n"+modulo+":"+info[con]); con++; mod="";
							}//else
						}//else

				}//else
			}//while
			registro.close();	 escritor2.close();
		}if(modificar>numT||modificar<0){JOptionPane.showMessageDialog(null,"Empleado no existente","ERROR",JOptionPane.ERROR_MESSAGE);}
		}catch(Exception e){JOptionPane.showMessageDialog(null,"NO se pudo Modificar","ERROR",JOptionPane.ERROR_MESSAGE);}
		}

	public void LeerEmpleados(){try{
		registro=new DataInputStream(new FileInputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro.txt"));// LEE ARCHIVO
		j.setText("");n=0;numT=0;
		while ((linea= registro.readLine())!=null){n++;if ((n-1)%6==0)
		{numT=Integer.parseInt((linea.substring(0,linea.length())));}
		System.out.println(linea);j.append(linea+"\n");}registro.close();
		}catch(IOException e){}
		}

	public void imprimirN(){try{
		escritor=new DataOutputStream(new FileOutputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro.txt"));// CREA ARCHIVO
		registro2=new DataInputStream(new FileInputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro2.txt"));
		j.setText("");n=0;
		while ((linea= registro2.readLine())!=null){n++;
		System.out.println(linea);if (n==1){j.append(""+linea); escritor.writeBytes(linea+"\n");}
								else {j.append("\n"+linea);escritor.writeBytes(linea+"\n");}}
		escritor.close();	registro2.close();
	}catch(Exception e){}
		}

	public void Leer(){
		JOptionPane.showMessageDialog(null,p,"Registro de Empleados:",JOptionPane.PLAIN_MESSAGE);}
}
