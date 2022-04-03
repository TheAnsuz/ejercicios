package me.ansuz.amrv.t8;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author marruiad
 */
public class TresEnRaya {

	public static final Scanner scan = new Scanner(System.in);

	private static enum Numbers {
		ONE(1, 'X', "uno"),
		TWO(2, 'O', "dos"),
		THREE(3, '#', "tres"),
		FOUR(4, '@', "cuatro"),
		FIVE(5, '€', "cinco"),
		SIX(6, '+', "seis"),
		SEVEN(7, '§', "siete"),
		EIGHT(8, '&', "ocho"),
		NINE(9, '▓', "nueve"),
		TEN(10, '█', "diez"),
		UNDEFINED(Integer.MIN_VALUE, '?', "ni puta idea"),

		;

		public static Numbers valueOf(int number) {
			for (Numbers num : Numbers.values()) {
				if (num.number == number)
					return num;
			}
			return Numbers.UNDEFINED;
		}

		@Override
		public String toString() {
			return this.string;
		}

		private final char representation;
		private final String string;
		private final int number;

		private Numbers(int number, char representation, String string) {
			this.number = number;
			this.representation = representation;
			this.string = string;
		}
	}

	public static void main(String[] args) {
		Window ventana = new Window(3);
		ventana.setVisible(true);
	}

	private static class XButton extends JButton {

		private static final long serialVersionUID = -661220121956424100L;
		private int owner = 0;

		public XButton(int width, int height) {
			super.setSize(width, height);
			super.setText(" ");
			super.setFocusable(false);
		}

		public int getOwner() {
			return owner;
		}

		public void setOwner(int owner) {
			this.owner = owner;
		}

	}

	private static class Window extends JFrame {

		private static final long serialVersionUID = 8498614614828999510L;
		private XButton[][] botones;
		private JLabel title;
		private JTextPane description;
		private final int dimension = 90;
		private final int margin = 5;
		private int state = 1; // 0 not started, 1 playing, 2 finished

		public Window(int size) {
			super.setTitle(size + " en raya");
			botones = new XButton[size][size];
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));
			super.setContentPane(panel);
			super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			super.setMinimumSize(new Dimension(dimension * size, dimension * size));
			super.setResizable(true);
			super.setLocationRelativeTo(null);
			end(Numbers.EIGHT);
			start(4);
		}

		private void start(int players) {
			this.clearComponents();
			int columns = 0;
			for (JButton[] boton : botones)
				columns = columns >= boton.length ? columns : boton.length;

			super.setLayout(new GridLayout(columns, botones.length, margin, margin));
			super.setSize(dimension * columns, dimension * botones.length);
		}

		private void end(Numbers winner) {
			this.clearComponents();
			super.setLayout(new BorderLayout(5, 5));
			this.title = new JLabel();
			this.title.setText("¡Fin de la partida!");
			this.title.setVerticalAlignment(JLabel.CENTER);
			this.title.setHorizontalAlignment(JLabel.CENTER);
			this.title.setFocusable(false);
			this.description = new JTextPane();
			this.description.setEditable(false);
			this.description.setText("Ha ganado el jugador " + winner.string + " (" + winner.representation + ")");
			SimpleAttributeSet attribs = new SimpleAttributeSet();
			StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
			this.description.setParagraphAttributes(attribs, true);

			super.add(this.title, BorderLayout.PAGE_START);
			super.add(this.description);
		}

		public void clearComponents() {
			for (Component c : super.getComponents())
				super.remove(c);
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));
			super.setContentPane(panel);
		}

		@SuppressWarnings("unused")
		public boolean checkWin(Numbers player) {
			return checkDiagonal(player.number) == player.number || checkHorizontal(0) == player.number
					|| checkVertical(0) == player.number;
		}

		private int checkHorizontal(int row) {
			int last = botones[row][0].getOwner();
			for (int x = 0; x < botones[row].length; x++) {
				if (botones[row][x].getOwner() != last)
					return 0;
			}
			return last;
		}

		private int checkVertical(int column) {
			int last = botones[0][column].getOwner();
			for (int y = 0; y < botones.length; y++) {
				if (botones[y][column].getOwner() != last)
					return 0;
			}
			return last;
		}

		private int checkDiagonal(int value) {
			for (int i = 0; i < botones.length; i++) {
				if (botones[i][i].getOwner() != value && botones[i][botones[i].length - 1].getOwner() != value)
					return 0;
			}
			return value;
		}

	}

}