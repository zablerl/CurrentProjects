import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GridBagLayoutPractice 
{
	private static JLabel label = new JLabel("Press a button");
	public static void main(String[] args)
	{
		final JFrame frame = new JFrame();
		JPanel panel = new JPanel(new GridBagLayout());
		JButton button1 = new JButton(new Button1Action());
		JButton button2 = new JButton(new Button2Action());
		
		panel.add(button1, new GridBagConstraints(0, 0, 1, 1, 0.5, 0.5, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		panel.add(button2, new GridBagConstraints(1, 0, 1, 1, 0.5, 0.5, GridBagConstraints.FIRST_LINE_END, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		
		label.setOpaque(true);
		label.setLocation(1,1);
		label.setHorizontalAlignment(0);
		
		
		
		panel.add(label, new GridBagConstraints( 0, 1, 2, 1, 0.5, 0.5, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 ) );
		
		
		
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				frame.setVisible(true);
			}
		});
		
		
	}
	
	public static class Button1Action extends AbstractAction 
	{
		

		public Button1Action()
		{
			super();
			
			
			putValue(AbstractAction.NAME, "Button 1");
			
		}
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			label.setBackground(Color.CYAN);
			label.setText("Button 1 clicked!");
			
		}
	}
	
	public static class Button2Action extends AbstractAction 
	{

		public Button2Action()
		{
			super();
			
			putValue(AbstractAction.NAME, "Button 2");
			
		}
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			label.setBackground(Color.YELLOW);
			label.setText("Button 2 clicked!");
			
		}
	}
}
