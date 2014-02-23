package edu.ucsb.cs56.projects.games.simon_says;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimonMenu extends JFrame
{
    private Image background;
    private JPanel mp;
    private ActionListener al;
    private Box b;
    private final String MENU[] = {"New Game", "Choose Version", "Rules", "Exit"};
    
   
    public SimonMenu()
    {
        super("Simon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try
	    {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    }
        catch(Exception ex)
	    {
	    }
        mp = new JPanel();
        mp.setBackground(Color.BLACK);
        mp.setLayout(null);
             
        getContentPane().add(BorderLayout.CENTER, mp);
        for(int i = 0; i < MENU.length; i++)
	    {
		JButton jb = new JButton(MENU[i]);
		jb.setBackground(new Color(0xCC99FF));
		jb.setBorderPainted(false);
		jb.setOpaque(true);
		jb.addActionListener(new MenuListener());
		jb.setBounds(70, 50 + 32 * i, 150, 20);
		mp.add(jb);
	    }
        setSize(300, 300);
        setVisible(true);
    }
      
    public class MenuListener implements ActionListener{
	public void actionPerformed(ActionEvent ex) {
	    String cmd = ex.getActionCommand();
	    if(cmd.equals("New Game")){
		dispose();
		SimonFrame frame = new SimonFrame();
		frame.display();
	    }
	}
    }
    
    public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable(){

		public void run()
		{
		    new SimonMenu().setVisible(true);
		}

	    });
    
    }    
}
