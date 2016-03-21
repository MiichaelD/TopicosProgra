package hilos;
class Share extends Thread{
	String msg[]={"This", "is", "a", "synchronized", "variable"};

	Share(String threadname){
		super(threadname);
	}
	public void run(){display();}

	public synchronized void display(){
		try{
			for(int i=0;i<=4;i++){
			System.out.println(getName()+msg[i]);
			}Thread.sleep(2000);
		}catch(Exception e){}
	}
}

public class Sync {
	public static void main(String[] args) 	{
		Share t1=new Share("Thread One: ");
		t1.start();
		Share t2=new Share("Thread Two: ");
		t2.start();
		Share t3=new Share("Thread Three: ");
		t3.start();
		try{
		t1.join();
		t3.join();
		t2.join();
		}catch(Exception e){}
}
}
