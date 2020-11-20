package cat;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.*;


public class GuiCat extends JFrame {
	
	public GuiCat (String question) {
		super("Cat");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		JLabel msgLabel = new JLabel("THE CAT HAS APPEARED");
		msgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		content.add(msgLabel);
		
		ImageIcon catP = new ImageIcon(getClass().getResource("normCat.jpg"));
		JLabel catPic = new JLabel(catP);
		
		content.add(catPic);
		
		JLabel qFram = new JLabel(question);
		qFram.setAlignmentX(Component.CENTER_ALIGNMENT);
		content.add(qFram);
		
		JTextField entry = new JTextField(5);
		content.add(entry);
		
		JButton ansB = new JButton("Your Answer?");
		ansB.setAlignmentX(Component.CENTER_ALIGNMENT);
		content.add(ansB);
		
		super.getContentPane().add(content);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GuiCat gui = new GuiCat("test");
				gui.pack();
				gui.setVisible(true);
			}
		});
	}
}