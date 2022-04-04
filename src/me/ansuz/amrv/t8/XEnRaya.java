package me.ansuz.amrv.t8;

/**
 * Esta clase contiene toda la informacion requerida para el procesamiento de un
 * juego de X en raya
 */
public class XEnRaya {

	/**
	 * La dimension del campo, no puede cambiarse mientras se esta jugando
	 */
	private int grid;
	private int fichas[][];
	// Si en una partida esta el jugador 0 y jugador 1, hay 2 jugadores
	private int jugadores;
	private int turno;

	public XEnRaya(int grid, int players) {
		this.grid = grid;
		this.fichas = new int[grid][grid];
		this.jugadores = players;
	}

	public XEnRaya(int grid, int players, int startingPlayer) {
		this.grid = grid;
		this.fichas = new int[grid][grid];
		this.jugadores = players;
		this.setTurno(startingPlayer);
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int player) {
		if (player < 0 || player >= this.jugadores)
			throw new XEnRayaException("Player out of player's range 0-" + this.jugadores);
		this.turno = player;
	}

	public int siguienteTurno() {
		final int act = this.turno;
		turno++;
		if (turno >= this.jugadores)
			turno = 0;
		return act;
	}

	public void setFicha(int player, int row, int column) {
		if (player < 0 || player >= this.jugadores)
			throw new XEnRayaException("Player out of player's range 0-" + this.jugadores);
		if (row < 0 || row > fichas.length)
			throw new XEnRayaException("Row out of range");
		if (column < 0 || column > fichas[0].length)
			throw new XEnRayaException("Column out of range");

		this.fichas[row][column] = player;
	}

	public void setFicha(int row, int column) {
		if (row < 0 || row > fichas.length)
			throw new XEnRayaException("Row out of range");
		if (column < 0 || column > fichas[0].length)
			throw new XEnRayaException("Column out of range");

		this.fichas[row][column] = siguienteTurno();
	}

	public boolean checkWin(int player) {
		return checkHorizontal(player) || checkVertical(player) || checkDiagonal(player);
	}

	private boolean checkVertical(int player) {
		for (int x = 0; x < this.grid; x++) {
			int casillas = 0;
			for (int y = 0; y < this.grid; y++) {
				if (fichas[y][x] == player)
					casillas++;
			}
			if (casillas >= this.grid)
				return true;
		}
		return false;
	}

	private boolean checkHorizontal(int player) {
		for (int y = 0; y < this.grid; y++) {
			int casillas = 0;
			for (int x = 0; x < this.grid; x++) {
				if (fichas[y][x] == player)
					casillas++;
			}
			if (casillas >= this.grid)
				return true;
		}
		return false;
	}

	private boolean checkDiagonal(int player) {
		int casillasR = 0;
		int casillasL = 0;
		for (int p = 0; p < this.grid; p++) {
			if (fichas[p][p] == player)
				casillasL++;
			if (fichas[p][this.grid - 1 - p] == player)
				casillasR++;
		}
		return casillasL >= this.grid || casillasR >= this.grid;
	}
	
	public synchronized void reset(int grid, int players) {
		this.grid = grid;
		fichas = new int[grid][grid];
		this.jugadores = players;
	}

	static class XEnRayaException extends RuntimeException {

		private static final long serialVersionUID = -1689947821075061430L;

		public XEnRayaException() {
			super("Se ha producido un error");
		}

		public XEnRayaException(String message) {
			super(message);
		}

	}

}
