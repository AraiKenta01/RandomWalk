package ComputerSimulation;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RandomWalkFrame extends JFrame implements ActionListener {
	private JTextField pField = new JTextField("0.5");
	private JTextField wField = new JTextField("100");
	private JButton simBtn = new JButton("simulate");
	private RandomWalkComponent rwc = new RandomWalkComponent();
	
	public RandomWalkFrame() {
		super("RandomWalk");
		Container cont = getContentPane();
		cont.setLayout(null);
		
		JLabel pLabel = new JLabel("Probability of +1 = ");
		pLabel.setLocation(100, 30);
		pLabel.setSize(130, 30);
		cont.add(pLabel);
		
		pField.setLocation(240, 30);
		pField.setSize(70, 30);
		cont.add(pField);
		
		JLabel wLabel = new JLabel("Number of trials = ");
		wLabel.setLocation(100, 90);
		wLabel.setSize(130, 30);
		cont.add(wLabel);
		
		wField.setLocation(240, 90);
		wField.setSize(70, 30);
		cont.add(wField);
		
		simBtn.setLocation(150, 150);
		simBtn.setSize(150, 80);
		cont.add(simBtn);
		simBtn.addActionListener(this);
		
		setSize(450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj == simBtn) {
			try {
				int trialNum = Integer.parseInt(wField.getText());
				double prob = Double.parseDouble(pField.getText());
				rwc.simulate(trialNum, prob);
			}
			catch(NumberFormatException nfe) {}
		}
		
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new RandomWalkFrame();
	}

}
