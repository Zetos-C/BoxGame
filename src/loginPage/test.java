package loginPage;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
//import javax.swing.UIManager;
//import javax.swing.UIManager.LookAndFeelInfo;
//import javax.swing.UnsupportedLookAndFeelException;

import databaseConnect.*;

public class test {
	public static void main(String[] args) {
//		new LoginView();
//		DatabaseConnection.CheckConnect();
//		 try {
//			 String className = getLookAndFeelClassName("Nimbus");
//			 UIManager.setLookAndFeel(className); 
//	    } 
//	    catch (UnsupportedLookAndFeelException e) {
//	       System.err.println("Error look and feel");
//	    }
//	    catch (ClassNotFoundException e) {
//	       // handle exception
//	    	System.err.println("Error look and feel");
//	    }
//	    catch (InstantiationException e) {
//	       // handle exception
//	    	System.err.println("Error look and feel");
//	    }
//	    catch (IllegalAccessException e) {
//	       // handle exception
//	    	System.err.println("Error look and feel");
//	    }
		 SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	new LoginView();
	            	SwingWorker<Void, Void> worker = new SwingWorker<>() {
	    				@Override
	    				protected Void doInBackground() {
	    					DatabaseConnection.CheckConnect();
	    					return null;
	    				}

	    				@Override
	    				protected void done() {
	    				}
	    			};
	    			worker.execute();
	            }
	        });
	}
//	public static String getLookAndFeelClassName(String nameSnippet) {
//	    LookAndFeelInfo[] plafs = UIManager.getInstalledLookAndFeels();
//	    for (LookAndFeelInfo info : plafs) {
//	        if (info.getName().contains(nameSnippet)) {
//	            return info.getClassName();
//	        }
//	    }
//	    return null;
//	}
	
}