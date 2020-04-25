import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;

/*
 * Unfortunately, I was not able to get this assignment completed on time.
 *
 * Known issues:
 *  - Upon initializing the TicTacToePlayer application, the paint method
 *    will not render my grid every time. With my limited knowledge of
 *    GUI programming, this problem seemed to be unfixable.
 *
 *
 *  - When it does render, another problem is the 'x' and '/' characters
 *    (I wasn't able to properly draw a 'o' character to the screen so I
 *    chose to use a '/' character instead) not showing up on the
 *    screen after the user clicking on a cell.
 *
 *
 *  - In the Server application, it launches two threads, where each thread
 *    is used to serve a player. For some reason though, one of the two
 *    launched threads suspends itself and never reaches my game loop. I
 *    found this out with the debugger.
 *    The debugger however, can be used to manually tell the thread to get
 *    out of its suspended mode.
 */

public class TicTacToePlayer extends JFrame {

	private static final long serialVersionUID = -7605073981668931853L;

	private Socket socket = null;
	private boolean isturn = false;
	private DataOutputStream toServer = null;
	private DataInputStream fromServer = null;

	public static final int PORT = 8000;


	public static Point p1 = new Point(80, 80);
	public static Point p2 = new Point(320, 320);

	public static final int ROWS = 3;
	public static final int COLS = 3;
	public static final int DISTANCEX = (p2.x - p1.x) / ROWS;
	public static final int DISTANCEY = (p2.y - p1.y) / COLS;

	public static Rectangle[][] grid = new Rectangle[ROWS][COLS];

	public static Point getPointFromCoords(Point p) {
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				if(grid[i][j].contains(p)) {
					return new Point(i, j);
				}
			}
		}
		return null;
	}

	public TicTacToePlayer() {
		setTitle("TicTacToe");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setFocusable(true);

		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				grid[i][j] = new Rectangle(p1.x + DISTANCEX * j, p1.y + DISTANCEY * i, DISTANCEX, DISTANCEY);
			}
		}

		setVisible(true);

	}

	public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        for(int i = 0; i < ROWS; i++) {
        	for(int j = 0; j < COLS; j++) {
        		g2.draw(grid[i][j]);
        		if(GameGod.game[i][j] == 'x') {
        			g2.draw(new Line2D.Float(grid[i][j].x, grid[i][j].y, grid[i][j].x + DISTANCEX, grid[i][j].y + DISTANCEY));
        			g2.draw(new Line2D.Float(grid[i][j].x, grid[i][j].y + DISTANCEY, grid[i][j].x + DISTANCEX, grid[i][j].y));
        		} else if(GameGod.game[i][j] == '/') {
        			g2.draw(new Line2D.Float(grid[i][j].x, grid[i][j].y + DISTANCEY, grid[i][j].x + DISTANCEX, grid[i][j].y));
        		}
        	}
        }
    }

	public void start() {
		boolean done = false;

		while(!done) {
			try {
				socket = new Socket("localhost", 8000);
				done = true;

				fromServer = new DataInputStream(socket.getInputStream());

				toServer = new DataOutputStream(socket.getOutputStream());

			} catch(IOException ex) {
				//System.err.println(ex);
			}
		}

		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				try {
					if(isturn) {
						System.out.println("Selected spot!");
						Point p = getPointFromCoords(e.getPoint());
						if(p != null) {
							toServer.writeInt(p.x);
							toServer.writeInt(p.y);
							if(fromServer.readBoolean())
								repaint();
						}
					}
				} catch(IOException ex) {

				}
			}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});

		while(socket == null);

		while(true) {
			// keep checking whether or not its this player's
			// turn.
			try {
				isturn = fromServer.readBoolean();
			} catch(IOException ex) {

			}
		}
	}

	public static void main(String[] args) {
		TicTacToePlayer game = new TicTacToePlayer();
		game.start();
		new Thread(()-> {
			while(true)
				game.repaint();
		});
	}

}
