package view;

import javax.swing.JOptionPane;

public class View {

	/**
	 * It reads an integer from the user
	 * 
	 * @param message The message to be displayed in the dialog box.
	 * @return The method is returning the integer value of the string that is
	 *         entered by the user.
	 */
	public int readGraficInt(String message) {
		return Integer.parseInt(JOptionPane.showInputDialog(message));
	}

	/**
	 * It returns a string that the user types into a dialog box
	 * 
	 * @param message The message to be displayed in the dialog box.
	 * @return A string
	 */
	public String readGraficString(String message) {
		return JOptionPane.showInputDialog(message);
	}

	/**
	 * It reads a long number from the user
	 * 
	 * @param message The message to be displayed in the dialog box.
	 * @return The method is returning a long value.
	 */
	public long readGraficLong(String message) {
		return Long.parseLong(JOptionPane.showInputDialog(message));
	}

	/**
	 * It shows a message in a window
	 * 
	 * @param message The message to be displayed.
	 */
	public void showGraficMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/**
	 * It displays a message dialog box with the given message and an error icon
	 * 
	 * @param message The message to be displayed.
	 */
	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * It shows a dialog box with a message and a list of options to choose from
	 * 
	 * @param data The array of options to display in the dialog.
	 * @return The option that the user has selected.
	 */
	public int showOptionDialogMenu(String[] data) {
		int option = JOptionPane.showOptionDialog(null, "ELIGE UNA OPCION", "mensaje", 0, JOptionPane.QUESTION_MESSAGE,
				null, data, "YES");
		return option;
	}

	/**
	 * This function shows a list of options to the user and returns the option
	 * selected by the user
	 * 
	 * @param data    The array of data to be displayed in the list.
	 * @param message The message to be displayed in the dialog box.
	 * @return The selected option from the list.
	 */
	public String showListDialogParameters(String[] data, String message) {

		String getOption = (String) JOptionPane.showInputDialog(null, message,
				"Escoge un parametro", JOptionPane.QUESTION_MESSAGE, null, data, data[0]);
		return getOption;
	}

}