package hilos;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;
public class Cronometro extends  JFrame implements Runnable{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Thread h=new Thread(new Cronometro());
		System.out.println("se instancio Cronometro");
		h.start();
		System.out.println("Termino Main");}

	JLabel j=new JLabel();
	int sec=-3,min=0,hor=0;

	Cronometro(){
		setSize(220,65);
		setLocationRelativeTo(null);
		setTitle("Cronometro");
		setVisible(true);
		getContentPane().setLayout(new FlowLayout());
		add(j);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}

		public void run() {

			for (int i=-3;i<219999999;i++){
				if(i==219999998)i=1;
				if (sec==60){sec=0;min++;}
				if (min==60){min=0;hor++;}
				if (hor==24) hor=0;
				j.setText(hor+":"+min+":"+sec);
				if(i<0)j.setForeground(Color.red);
				else j.setForeground(Color.blue);
				sec++;
				try{Thread.sleep(500);}catch(Exception e){}}
				System.out.println("Hilo1: YA ME CANSE ");			}


}
