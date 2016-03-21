package hilos;

public class Game {
	public static void main(String args[]) {
		PingPong table = new PingPong();
		Thread alice = new Thread(new Player("bob", table));
		Thread bob = new Thread(new Player("alice", table));

		alice.setName("alice");
		bob.setName("bob");
		alice.start(); // alice starts playing
		alice.setPriority(10);
		bob.start(); // bob starts playing
		bob.setPriority(1);
		try {
			alice.join();
			bob.join();
			// Wait 5 seconds
			Thread.sleep(5000);
			table.hit("DONE"); // cause the players to quit their threads.
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}
}

class PingPong {
	// state variable identifying whose turn it is.
	private String whoseTurn = null, player = null;
	int espera = 250;

	public boolean hit(String opponent) {
		player = Thread.currentThread().getName();
		if (whoseTurn == null) {// inicializamos el turno
			whoseTurn = player;
			return true;
		}
		if (opponent.equals("DONE")) {
			System.exit(0);
		}

		if (player.equals(whoseTurn)) {// si es el turno del hilo que entro
			try {
				System.out.println("PING! (" + player + ")");
				whoseTurn = opponent;
				notifyAll();// termina su turno
			} catch (Exception e) {
			}

		} else {// si no es su turno espera
			try {
				long t1 = System.currentTimeMillis();
				// System.out.println("\t\t"+player+" esperando ...");
				wait(espera);// espera hasta
				if ((System.currentTimeMillis() - t1) > espera) {// si despeus de espera, sigue ocupado sale.
					System.out.println("****** TIMEOUT! " + player + " is waiting for " + whoseTurn + " to play.");
					return false;
				}
			} catch (Exception e) {
			}
		}
		return true; // keep playing.
	}
}

class Player implements Runnable {
	PingPong myTable; // Table where they play
	String myOpponent;

	public Player(String opponent, PingPong table) {
		myTable = table;
		myOpponent = opponent;
	}

	public void run() {
		while (myTable.hit(myOpponent))
			;
	}
}