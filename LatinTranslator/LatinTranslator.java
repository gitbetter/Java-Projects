import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LatinTranslator extends JFrame
{
	private JPanel buttonPanel;
	private JPanel labelPanel;
	private JButton sinister;
    private JButton dexter;
	private JButton medium;	
	protected JLabel translation;
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 500;

	public LatinTranslator() {
		super("Latin Translator");

		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		
		buildLabelPanel();
		buildButtonPanel();
		
		add(buttonPanel, BorderLayout.CENTER);
		add(labelPanel, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}

	private void buildButtonPanel() {
		buttonPanel = new JPanel();

		sinister = new JButton("Sinister");
		dexter = new JButton("Dexter");
		medium = new JButton("Medium");

		sinister.addActionListener(new TransButtonListener());
		dexter.addActionListener(new TransButtonListener());
		medium.addActionListener(new TransButtonListener());

		buttonPanel.setBorder(BorderFactory.createTitledBorder("Latin"));

		buttonPanel.add(sinister);
		buttonPanel.add(dexter);
		buttonPanel.add(medium);
	}

	private void buildLabelPanel() {
		translation = new JLabel();

		labelPanel = new JPanel();

		labelPanel.setBorder(BorderFactory.createTitledBorder("Translation"));

		labelPanel.add(translation);
	}
	
	private class TransButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand() == "Sinister") {
				translation.setText("Left");
			} else if(e.getActionCommand() == "Dexter") {
				translation.setText("Right");
			} else if(e.getActionCommand() == "Medium") {
				translation.setText("Center");
			}
		}
	}

	public static void main(String[] args) {
		new LatinTranslator();
	}
}
