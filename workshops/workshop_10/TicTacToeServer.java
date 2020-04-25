import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TicTacToeServer {


	private static ServerSocket serverSocket;

	public static final int PORT = 8000;


	public static void main(String[] args) {

		try {

			serverSocket = new ServerSocket(PORT);
			System.out.println("Server Started!");
			System.out.println("Listening on PORT: " + PORT);

			int i = 0;
			while (i < 2) {
				Socket socket = serverSocket.accept();
				i++;
				new Thread(new GameGod(socket)).start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		} catch(IOException ex) {
			System.err.println(ex);
		}
	}

}

class GameGod implements Runnable {

	public static final int ROWS = 3;
	public static final int COLS = 3;
	public static char[][] game = {
			{
				' ', ' ', ' '
			},
			{
				' ', ' ', ' '
			},
			{
				' ', ' ', ' '
			}
	};
	private static int players = 0;
	private static int playerturn = 1;
	private static boolean done = false;

	private Socket socket;
	private int playernum;

	public GameGod(Socket s) {
		socket = s;
	}

	// This function should work.
	public static boolean haswon(char match) {
		boolean won = true;

		for(int i = 0, j = 0; i < ROWS && j < COLS && won; i++, j++) {
			if(game[i][j] != match) {
				won = false;
			}
		}

		for(int i = ROWS - 1, j = 0; i >= 0 && j < COLS && won; i--, j++) {
			won = true;
			if(game[i][j] != match) {
				won = false;
			}
		}

		for(int i = 0; i < ROWS && !won; i++) {
			won = true;
			for(int j = 0; j < COLS && won; j++) {
				if(game[i][j] != match) {
					won = false;
				}
			}
		}

		for(int i = 0; i < COLS && !won; i++) {
			won = true;
			for(int j = 0; j < ROWS && won; j++) {
				if(game[j][i] != match) {
					won = false;
				}
			}
		}

		return won;
	}

	@Override
	public void run() {
		DataInputStream inputFromClient = null;
		DataOutputStream outputToClient = null;
		try {
			inputFromClient = new DataInputStream(socket.getInputStream());
			outputToClient = new DataOutputStream(socket.getOutputStream());

			playernum = players++;
			System.out.println("Player " + playernum + " has connected!");

			if(players < 2) {
				System.out.println("Waiting for other player");
				while(players < 2);
			}

		} catch (IOException e) {

		}

		System.out.println("Players: " + players);
		System.out.println("Start Game!!!!");

		// game loop!
		while(!done) {
			try {
				if(playernum == playerturn) {
					outputToClient.writeBoolean(true);
					System.out.println("Player " + playerturn + "'s turn");
					int r = 0;
					int c = 0;
					do {
						System.out.println("Select a box player " + playernum + "!");
						r = inputFromClient.readInt();
						c = inputFromClient.readInt();
						if(game[r][c] == 'x' || game[r][c] == '/')
							outputToClient.writeBoolean(false);
					} while(game[r][c] == 'x' || game[r][c] == '/');
					char ch = playernum == 0 ? 'x' : '/';
					game[r][c] = ch;
					outputToClient.writeBoolean(true);

					for(int i = 0; i < ROWS; i++) {
			        	for(int j = 0; j < COLS; j++) {
			        		System.out.print("|" + GameGod.game[i][j] + "|");
			        	}
			        	System.out.println();
			        }


					if(!haswon(ch)) {
						playerturn = playerturn == 0 ? 1 : 0;
					} else {
						System.out.println("Player " + playernum + " has won!");
						done = true;
					}

				} else {
					outputToClient.writeBoolean(false);
					System.out.println("Not your turn Player " + playernum + "!");
					while(playernum != playerturn);

				}
			} catch(IOException e) {

			}
		}
	}
}
