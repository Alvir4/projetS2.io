package Ratp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.TextField;
 import MainFrame;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;




	  
	  
public class Application {
	
		static JMenuBar mb,mb1;
	    
	    // JMenu
	    static JMenu mb_Line,mb_Info,submenu;
	  
	    // Menu items
	    static JMenuItem bus, metro, rer, E_T_A, i2, i3;
	    
	    static JLabel l;

	    
	    
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName()); // affichage du thead actuel
		
	    
	  
		
		EventQueue.invokeLater(new Runnable() {
			
			
			@Override
			public void run() {
				
				//System.out.println(Thread.currentThread().getName()); // affichage du thead actuel
				
				MainFrame mainframe = new MainFrame("RATP");
				mainframe.setResizable(true);
				mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainframe.pack();
				mainframe.setLocationRelativeTo(null);
				mainframe.getContentPane().setBackground(Color.LIGHT_GRAY);
				UIManager.put("MenuBar.background", Color.GRAY);
			   
				
			        // create a menubar
			     	mb = new JMenuBar();
			     	
			  
			        // create a menu
			        mb_Line = new JMenu("selection lignes");
			        mb_Info = new JMenu("info");
			        
			        // add menu to menu bar
			        mb.add(mb_Line);
			        mb_Line.addSeparator();
			        mb.add(mb_Info);
//			        mb_Info.addSeparator();
			        
			        
			        
			        // create menuitems
			        bus = new JMenuItem("bus");			        
			        metro = new JMenuItem("metro");
			        rer = new JMenuItem("rer");
			        E_T_A = new JMenuItem("E.T.A");
			        i2 = new JMenuItem("trafic");
			        i3 = new JMenuItem("trafic");
			        
			  
			        // add menu items to menu
			        mb_Line.add(bus);
			        mb_Line.add(metro);
			        mb_Line.add(rer);
			        mb_Info.add(E_T_A);
			        mb_Info.add(i2);
			        mb_Info.add(i3);
			        mb_Line.add(mb_Info);
			  
			       
			  
			        // add menubar to frame
			        mainframe.setJMenuBar(mb);
			        l = new JLabel("la requette vas nous donner :  "+MainFrame.forecast);
			        mainframe.add(l);
			        
			        // set the size of the frame
			        mainframe.setSize(500, 500);
			        mainframe.setVisible(true);
			        
			        
		
				
				}

		});
		
	}
	
}
