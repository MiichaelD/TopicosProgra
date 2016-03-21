package proyectoHilos;
import java.io.*;
import javax.swing.*;
@SuppressWarnings("deprecation")
public class Nomina implements Runnable{

	JFrame f=new JFrame("Nomina");		JPanel p=new JPanel();
	JLabel l=new JLabel();
	JLabel ll=new JLabel();

	DataInputStream registro; int n=0,numT=0,op,dias=0; String linea,nombre;	float sueldo,sueldoST,sueldoT;

	public void run(){MainProyecto.ciclo[4]=true;
	checar();
		do{try{	Thread.sleep(50);op=Integer.parseInt(JOptionPane.showInputDialog("1)Mostrar Nomina Total\n2)Mostrar Paga Individual" +
					"\n3)Volver a Menu"));
			switch(op){
			case 1:if(numT!=0){MainProyecto.n.join(50); mostrar();}
					else JOptionPane.showMessageDialog(null,"No hay Empleados Registrados","ERROR",2); break;
			case 2:if(numT!=0)mostrarIndividual();
					else JOptionPane.showMessageDialog(null,"No hay Empleados Registrados","ERROR",2);break;
			case 3:MainProyecto.n.suspend();break;
			case 4:MainProyecto.ciclo[4]=false;
			default:JOptionPane.showMessageDialog(null,"Opcion Incorrecta","Error",JOptionPane.ERROR_MESSAGE);break;}
		}catch(Exception e){JOptionPane.showMessageDialog(null,"Solo Numeros","Error",JOptionPane.ERROR_MESSAGE);}
		}while(MainProyecto.ciclo[4]);}


	public void checar(){try{
		n=0;
		registro=new DataInputStream(new FileInputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro.txt"));
		while((linea=registro.readLine())!=null){n++;
		if((n-1)%6==0){numT=Integer.parseInt((linea.substring(0,linea.length())));}}
	}catch(Exception e){}}

	public void	mostrar(){try{
		f.setSize(380,150);		f.setLocation(500,340);		f.setVisible(true);

		f.add(p);	p.add(l);		p.add(ll);

		registro=new DataInputStream(new FileInputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro.txt"));
		sueldoST=0;sueldoT=0;
		while ((linea= registro.readLine())!=null){n++;
		if ((n-1)%6==0){numT=Integer.parseInt((linea.substring(0,linea.length())));}
		if((n-3)%6==0){nombre=linea.substring(7,linea.length());}
		if((n-5)%6==0){sueldo=Float.parseFloat(linea.substring(7,linea.length()));}
		if((n%6)==0){dias=Integer.parseInt(linea.substring(7,linea.length()));
					sueldoST=dias*sueldo; sueldoT+=sueldoST;
					f.setTitle("Nomina Empleado #"+numT);
					l.setText(nombre+" Sueldo: "+sueldo+" x "+dias+" dias =" +sueldoST);
					ll.setText("Nomina Acumulada a Pagar: "+sueldoT);Thread.sleep(1000);}}
		l.setText("Total a Pagar a Todos los Empleados");
		ll.setText("en "+dias+" Dias de trabajo: "+sueldoT);
		Thread.sleep(500);
		registro.close();System.out.println(sueldoT);
	}catch(Exception e){}}

	public void mostrarIndividual(){try{
		sueldoST=0;numT=0;n=0;	int c=0,nu=0;
		int nomina=Integer.parseInt(JOptionPane.showInputDialog("Trabajador Numero:"));
		int dias=0;
		registro=new DataInputStream(new FileInputStream("C:\\Users\\Skeleton\\Documents\\TEC\\3er Semestre\\Topicos\\ProyectoHilos\\registro.txt"));
		while ((linea= registro.readLine())!=null){n++;
		if ((n-1)%6==0){numT=Integer.parseInt((linea.substring(0,linea.length())));}
		if((n-5)%6==0){sueldo=Float.parseFloat(linea.substring(7,linea.length()));}
		if( n%6==0){dias=Integer.parseInt(linea.substring(7,linea.length()));}
		if(numT==nomina){c++;
			if (c==1)nu=numT;
			if (c==5){sueldoST=dias*sueldo;}
			if (c==3){nombre=linea.substring(7,linea.length());}	}
		}if(nomina>numT||nomina<1)JOptionPane.showMessageDialog(null,"Empleado no existente","ERROR",JOptionPane.ERROR_MESSAGE);
		else {JOptionPane.showMessageDialog(null,"Empleado: "+nombre+"\nNomina por "+dias+" dias: $"
				+sueldoST,"Nomina de Empleado #"+nu,JOptionPane.PLAIN_MESSAGE);}
		}catch(Exception e){}}

}

