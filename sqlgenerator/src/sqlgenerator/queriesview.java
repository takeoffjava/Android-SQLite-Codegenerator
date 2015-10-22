package sqlgenerator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class queriesview extends JFrame {

	private JPanel contentPane;
	JEditorPane dtrpnQuery;
	JEditorPane pojo;
	static queriesview frame;
	private static String OS = System.getProperty("os.name").toLowerCase();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new queriesview();
					new homeframe().centreWindow(frame);
					frame.setTitle("Code Viewer");
					Image icon = Toolkit.getDefaultToolkit().getImage("src/query3.png");
					frame.setIconImage(icon);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public queriesview() {
		setTitle("Code Viewer");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 819, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 128), null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 793, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Code Viewer");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(290, -12, 185, 50);
		panel.add(lblNewLabel);
		
		JButton btnCreateJavaFile = new JButton("create java file");
		btnCreateJavaFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createtext_File(dtrpnQuery.getText(),pojo.getText());
				
			}
		});
		btnCreateJavaFile.setForeground(new Color(220, 20, 60));
		btnCreateJavaFile.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnCreateJavaFile.setBounds(660, 28, 123, 23);
		panel.add(btnCreateJavaFile);
		
		JLabel lblNewLabel_1 = new JLabel("Java Code");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(100, 36, 88, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblJavaCode = new JLabel("Pojo");
		lblJavaCode.setForeground(Color.BLUE);
		lblJavaCode.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblJavaCode.setBounds(500, 36, 88, 14);
		panel.add(lblJavaCode);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 83, 793, 336);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 406, 325);
		panel_1.add(scrollPane);
		
		 dtrpnQuery = new JEditorPane();
		 scrollPane.setViewportView(dtrpnQuery);
		 dtrpnQuery.setToolTipText("Code Viewer");
		 dtrpnQuery.setForeground(Color.BLACK);
		 dtrpnQuery.setFont(new Font("SimSun", Font.PLAIN, 14));
		 dtrpnQuery.setEditable(false);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(406, 0, 387, 325);
		 panel_1.add(scrollPane_1);
		 
		 pojo = new JEditorPane();
		 pojo.setFont(new Font("SimSun", Font.PLAIN, 14));
		 scrollPane_1.setViewportView(pojo);
	}	
    public void createtext_File(String content,String pojo){
	String mainpath=System.getProperty("user.name");
	String path="",pojopath="";
	//folder create
	File theDir = new File("C:/Users/"+mainpath+"/Downloads/sqlgenerator");

	// if the directory does not exist, create it
	if (!theDir.exists()) {
	   
	    boolean result = false;

	    try{
	        theDir.mkdir();
	        result = true;
	    } 
	    catch(SecurityException se){
	    }        
	    if(result) {    
	    }
	}

	 if (isWindows()) {
		 path="C://Users/"+mainpath+"/Downloads/sqlgenerator/DBAccess.java";
		 pojopath="C://Users/"+mainpath+"/Downloads/sqlgenerator/pojo.java";
     } else if (isMac()) {
    	 path="C://sqlgenerator.java";
     } else if (isUnix()) {
    	 path="C://sqlgenerator.java";
     } else if (isLinux()) {
    	 path="/usr/sqlgenerator.java";
     } else {
        
         JOptionPane.showMessageDialog(frame,"Your OS is not support!!", "Error",JOptionPane.ERROR_MESSAGE);
     }
	File file = new File(path);
	try{
	if (!file.exists()) {
		file.createNewFile();
	}

	FileWriter fw = new FileWriter(file.getAbsoluteFile());
	BufferedWriter bw = new BufferedWriter(fw);
	bw.write(content);
	bw.close();
	
	File filepojo = new File(pojopath);
	try{
	if (!filepojo.exists()) {
		filepojo.createNewFile();
	}

	FileWriter fwp = new FileWriter(filepojo.getAbsoluteFile());
	BufferedWriter bwp = new BufferedWriter(fwp);
	bwp.write(pojo);
	bwp.close();

	JOptionPane.showMessageDialog(frame,"java file created in Downloads/sqlgenerator/..");

} catch (IOException e) {
	e.printStackTrace();
}
	}	
	catch (IOException e) {
		e.printStackTrace();
	}
}
public static boolean isWindows() {
    return (OS.indexOf("win") >= 0);
}

public static boolean isMac() {
    return (OS.indexOf("mac") >= 0);
}

public static boolean isUnix() {
    return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
}

public static boolean isSolaris() {
    return (OS.indexOf("sunos") >= 0);
}
public static boolean isLinux() {
    return (OS.indexOf("Linux") >= 0);
}
}

