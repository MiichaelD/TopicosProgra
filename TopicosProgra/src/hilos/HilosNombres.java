package hilos;
public class HilosNombres {
	///minicarreras de los nombres, con clase Heredada
	public static void main(String[] args) {
	 new HilosThread("Duarte").start();// heredado
	 new Thread(new HilosThread("Peña")).start(); // heredado
	 new Thread(new HilosRunable(),"Michael").start();
	new Thread(new HilosRunable(),"Steve").start();
	 System.out.println("Termino el Hilo MAIN");
	}
}
	class HilosRunable implements Runnable{
	public void run(){
		for (int i=0;i<10;i++){
			System.out.println(i+" "+Thread.currentThread().getName());		}
	System.out.println("Termina el Hilo: "+Thread.currentThread().getName());}
}
	class HilosThread extends Thread{
		HilosThread (String cad){super(cad);}
		public void run (){
			for (int i=0;i<10;i++) System.out.println(i+" "+getName()+ "\tde CLASS:"+getClass());
		System.out.println("Termina el hilo "+getName());
		}
	}
