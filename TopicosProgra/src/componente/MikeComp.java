package componente;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
public class MikeComp {
	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="230,-8"
	private JPanel jContentPane1 = null;
	private JLabel jLabel = null;
	private JTextField jTextField = null;
	private JLabel jLabel1 = null;
	private JTextField jTextField1 = null;
	private JLabel jLabel2 = null;
	private JTextField jTextField2 = null;
	private JLabel jLabel3 = null;
	private JTextField jTextField3 = null;
	private JLabel jLabel4 = null;
	private JButton jButton = null;

	/**
	 * This method initializes jFrame
	 *
	 * @return javax.swing.JFrame
	 */
	@SuppressWarnings("unused")
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setSize(new Dimension(331, 256));
			jFrame.setTitle("Instituto Tecnologico de Mexicali");
			jFrame.setBackground(new Color(34, 186, 245));
			jFrame.setContentPane(getJContentPane1());
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane1
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane1() {
		if (jContentPane1 == null) {
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(58, 9, 176, 16));
			jLabel4.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
			jLabel4.setText("NOMBRE DE COMPAÑIA");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(15, 137, 38, 16));
			jLabel3.setText("Edad:");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(15, 106, 38, 16));
			jLabel2.setText("Sexo:");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(16, 78, 69, 16));
			jLabel1.setText("Nombre: ");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(12, 41, 132, 24));
			jLabel.setText("Numero de Empleado:");
			jContentPane1 = new JPanel();
			jContentPane1.setLayout(null);
			jContentPane1.setBackground(new Color(75, 179, 238));
			jContentPane1.add(jLabel, null);
			jContentPane1.add(getJTextField(), null);
			jContentPane1.add(jLabel1, null);
			jContentPane1.add(getJTextField1(), null);
			jContentPane1.add(jLabel2, null);
			jContentPane1.add(getJTextField2(), null);
			jContentPane1.add(jLabel3, null);
			jContentPane1.add(getJTextField3(), null);
			jContentPane1.add(jLabel4, null);
			jContentPane1.add(getJButton(), null);
		}
		return jContentPane1;
	}

	/**
	 * This method initializes jTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(147, 44, 154, 20));
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextField1
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(92, 75, 208, 20));
		}
		return jTextField1;
	}

	/**
	 * This method initializes jTextField2
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(90, 105, 211, 20));
		}
		return jTextField2;
	}

	/**
	 * This method initializes jTextField3
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new Rectangle(91, 135, 208, 20));
		}
		return jTextField3;
	}

	/**
	 * This method initializes jButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(86, 174, 101, 31));
			jButton.setText("ACEPTAR!");
		}
		return jButton;
	}

	//**public static void main(String[] args) {



//}
}
