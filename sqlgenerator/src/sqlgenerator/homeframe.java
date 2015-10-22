package sqlgenerator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class homeframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JComboBox comboBox,comboBox_1;
	List<String> columnName=new ArrayList<String>();
	List<String> columnType=new ArrayList<String>();
	queriesview qv=new queriesview();
	static homeframe frame;
	private JTable table_1;
	StringBuffer varibles=new StringBuffer();
	StringBuffer getters=new StringBuffer();
	StringBuffer setters=new StringBuffer();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new homeframe();
					frame.setResizable(false);
					frame.setTitle("Query Generator");
					Image icon = Toolkit.getDefaultToolkit().getImage("src/query3.png");
					frame.setIconImage(icon);
					//frame.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("PATH/TO/YourImage.png")));
					centreWindow(frame);
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
	public homeframe() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 494);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 0), null, null, null), null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 625, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Query Generator");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(197, 11, 390, 42);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("Delete Row");
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 128), null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 86, 625, 301);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDatabaseName = new JLabel("Database Name");
		lblDatabaseName.setBounds(10, 21, 101, 14);
		lblDatabaseName.setFont(new Font("Georgia", Font.BOLD, 10));
		panel_1.add(lblDatabaseName);
		
		JLabel lblTableName = new JLabel("Table Name");
		lblTableName.setBounds(335, 21, 74, 14);
		lblTableName.setFont(new Font("Georgia", Font.BOLD, 10));
		panel_1.add(lblTableName);
		
		textField = new JTextField();
		textField.setForeground(new Color(30, 144, 255));
		textField.setBackground(new Color(255, 239, 213));
		textField.setBounds(121, 18, 184, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(30, 144, 255));
		textField_1.setBackground(new Color(255, 239, 213));
		textField_1.setBounds(419, 18, 196, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblColumnName = new JLabel("Column Name");
		lblColumnName.setBounds(10, 66, 88, 14);
		lblColumnName.setFont(new Font("Georgia", Font.BOLD, 10));
		panel_1.add(lblColumnName);
		
		JLabel lblColumnType = new JLabel("Column Type");
		lblColumnType.setBounds(333, 66, 88, 14);
		lblColumnType.setFont(new Font("Georgia", Font.BOLD, 10));
		panel_1.add(lblColumnType);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(30, 144, 255));
		textField_2.setBackground(new Color(255, 239, 213));
		textField_2.setBounds(121, 63, 184, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 235, 205));
		comboBox.setBounds(419, 63, 196, 20);
		comboBox.setForeground(Color.BLUE);
		comboBox.setFont(new Font("Comic Sans MS", Font.ITALIC, 10));
		
		comboBox.addItem("blob");
		comboBox.addItem("int primarykey");
		comboBox.addItem("text");
		panel_1.add(comboBox);
		
		JButton btnAddcolumn = new JButton("+");
		btnAddcolumn.setToolTipText("Add Column");
		btnAddcolumn.setBounds(10, 91, 52, 27);
		btnAddcolumn.setBackground(new Color(255, 239, 213));
		panel_1.add(btnAddcolumn);
		
		btnAddcolumn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				if(textField_2.getText().equals("")){
					JOptionPane.showMessageDialog(frame,"Column name should not be empty", "Error",JOptionPane.ERROR_MESSAGE);
					return ;
				}
				columnName.add(textField_2.getText());
				columnType.add((String)comboBox.getSelectedItem());
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				model.addRow(new Object[] {columnName.size(),textField_2.getText(),(String)comboBox.getSelectedItem()});
				textField_2.setText("");
			}
		});
		btnAddcolumn.setFont(new Font("Georgia", Font.BOLD, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 129, 605, 161);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFocusTraversalPolicyProvider(true);
		scrollPane_1.setFocusCycleRoot(true);
		scrollPane_1.setViewportBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		scrollPane_1.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 12));
		scrollPane_1.setBounds(0, 0, 605, 161);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setAutoCreateRowSorter(true);		
		table_1.setColumnSelectionAllowed(true);
		table_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table_1.setForeground(new Color(0, 0, 139));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S.No", "Column Name", "Column Type"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table_1.getSelectedRow();
				if(columnName.size()<=row+1){
					columnName.remove(columnName.size()-1);
					columnType.remove(columnName.size()-1);
				}else{
				columnName.remove(row);
				columnType.remove(row);
				}
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				model.removeRow(row);
				JOptionPane.showMessageDialog(frame,"Deleted Successfully...");
				
			}
		});
		btnX.setName("Delete Row");
		btnX.setToolTipText("Delete Column");
		btnX.setFont(new Font("Georgia", Font.BOLD, 12));
		btnX.setBackground(new Color(255, 239, 213));
		btnX.setBounds(72, 91, 52, 27);
		panel_1.add(btnX);
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 128), null, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 398, 625, 58);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		final JCheckBox chckbxCreate = new JCheckBox("Insert");
		chckbxCreate.setBackground(Color.WHITE);
		chckbxCreate.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 10));
		chckbxCreate.setBounds(6, 19, 63, 23);
		panel_2.add(chckbxCreate);
		
		final JCheckBox chckbxGetlist = new JCheckBox("Getlist");
		chckbxGetlist.setBackground(Color.WHITE);
		chckbxGetlist.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 10));
		chckbxGetlist.setBounds(71, 19, 63, 23);
		panel_2.add(chckbxGetlist);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBackground(new Color(255, 228, 196));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String databaseQuery,createQuery,override,tableQuery,fieldQuery="",insertcodeobj,insertbulk,createfieldsname;
				StringBuffer tableFields=new StringBuffer();
				StringBuffer tableFieldscolumns=new StringBuffer();
				StringBuffer alldata=new StringBuffer();
				String Database_Name=textField.getText().toUpperCase();
				String Table_Name=textField_1.getText().toUpperCase();
				String imports=" import android.content.ContentValues; \n import android.content.Context; \n import android.database.Cursor;\n"+
								" import android.database.sqlite.SQLiteDatabase; \n import android.database.sqlite.SQLiteOpenHelper; \n import java.util.ArrayList; \n import android.database.sqlite.SQLiteStatement;\n\n";
				//alldata.append(imports);
				if(textField.getText().equals("")){
					JOptionPane.showMessageDialog(frame,"Database Name should not be empty", "Error",JOptionPane.ERROR_MESSAGE);
					return ;
				}else{
					 databaseQuery="private static final int DATABASE_VERSION = 1;\nprivate static String DATABASE_"+Database_Name+"=\""+textField.getText()+"\";\n";
					 tableQuery="public static final String TABLE_"+Table_Name+" = \""+textField_1.getText()+"\";\n";
					 alldata.append(databaseQuery).append(tableQuery);
				}
				if(textField_1.getText().equals("")){
					JOptionPane.showMessageDialog(frame,"Table Name should not be empty", "Error",JOptionPane.ERROR_MESSAGE);
					return ;
				}else{
					
					for(int i=0;i<columnName.size();i++){
						if(columnType.get(i).toString().equals("int primarykey")){
							createfieldsname="INTEGER PRIMARY KEY AUTOINCREMENT ";
						}else{
							createfieldsname=columnType.get(i).toString().toUpperCase();
						}
						tableFields.append("\"+KEY_"+columnName.get(i).toUpperCase()+"+\" "+ createfieldsname+",");	
						tableFieldscolumns.append("KEY_"+columnName.get(i).toUpperCase()+",\n");
						fieldQuery="public static final String KEY_"+columnName.get(i).toUpperCase()+" = \""+columnName.get(i)+"\";\n";
						alldata.append(fieldQuery);
					}
					createQuery="public static final String CREATE_TABLE_"+Table_Name+"=\n\"CREATE TABLE\"+ TABLE_"+Table_Name+"+\n\""
							+ "("+tableFields.substring(0, tableFields.length()-1)+")\";\n"
									+ "\npublic static final String[] COLUMNS_"+Table_Name+" = {"+tableFieldscolumns+"};\n";
					override="public DBAccess (Context context) { \n"+
							  " super (context, DATABASE_"+Database_Name+", null, DATABASE_VERSION); \n"+
								" }\n @Override \n"+
								"       public void onCreate (SQLiteDatabase db) { \n"+
							" db.execSQL (CREATE_TABLE_"+Table_Name+");\n"+
								" }\n @Override \n"+
								"       public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) { \n"+
								" }\n";
					StringBuffer insertquery=new StringBuffer();
					StringBuffer insertqueryvalues=new StringBuffer();
					StringBuffer insertbindvalues=new StringBuffer();
					
					for(int indx=0;indx<columnName.size();indx++){
						insertquery.append("\"+KEY_"+columnName.get(indx).toUpperCase()+"+\",");
						insertqueryvalues.append("?,");
						insertbindvalues.append("			insertStatement.bindString("+(indx+1)+",objpojo.get"+columnName.get(indx)+"());\n");
					}
					insertcodeobj="public void insertObject (pojo objpojo){\n "
							+ "			SQLiteDatabase db = getWritableDatabase ();\n			String INSERT=\"insert into \"+TABLE_"+Table_Name+"+\"("+insertquery.substring(0,insertquery.length()-1)+")"
									+ " 			values ("+insertqueryvalues.subSequence(0, insertqueryvalues.length()-1)+")\";\n			SQLiteStatement insertStatement = db.compileStatement (INSERT);\n"
											+ "			"+insertbindvalues+"\n			insertStatement.executeInsert ();\n			insertStatement.clearBindings ();\n			db.close ();\n			close();\n}\n";
					insertbulk="public void insertList (ArrayList<pojo> pojolist){\n"
							+"			SQLiteDatabase db = getWritableDatabase ();\n			String INSERT=\"insert into \"+TABLE_"+Table_Name+"+\"("+insertquery.substring(0,insertquery.length()-1)+")"
									+ "			values ("+insertqueryvalues.subSequence(0, insertqueryvalues.length()-1)+")\";\n			SQLiteStatement insertStatement = db.compileStatement (INSERT);\n"
									+ "			for(pojo objpojo: pojolist) {\n"
									+ "			"+insertbindvalues+"\n			insertStatement.executeInsert ();\n			insertStatement.clearBindings ();\n}\n 			db.close ();\n 			close();\n}\n";
				}	
				alldata.append(override);
				createpojo(columnName,columnType);
				
				if(chckbxCreate.isSelected()){
					alldata.append("\n\n"+createQuery);
					alldata.append(insertcodeobj);
					alldata.append(insertbulk);
				}				
				
				if(chckbxGetlist.isSelected()){
					
					StringBuffer getquerysetter=new StringBuffer();
					String get_code="public pojo getDetails (String COLUMN_NAME, String COLUMN_VALUE) { \n"
							+ "				SQLiteDatabase db = this.getReadableDatabase ();\n 				Cursor cursor = db.query (TABLE_"+Table_Name+",// a. table\n 				COLUMNS_USERMASTER,// b. column names \n 				COLUMN_NAME+ \" = ?\",// c. selections\n"
									+ " 				new String[]{String.valueOf (COLUMN_VALUE)},// d. selections args \n 				null,// e. group by \n 				null,// f. having \n 				null,// g. order by \n 				null);// h. limit \n"
									+ "				if(cursor != null )\n 				cursor.moveToFirst ();\n				if(cursor.getCount ()>0) {\n 				pojo objpojo = new pojo();\n";
					int curser_count=1;
					for(int indx=0;indx<columnName.size();indx++){
						String columntype="";
						if(columnType.get(indx).toString().equals("int primarykey")){
							columntype="int";
						}else{
							columntype="String";
						}
						getquerysetter.append("					objpojo.set"+columnName.get(indx)+"(cursor.get"+columntype+"("+curser_count+"));\n");
						curser_count++;
					}
					String getlast_code="				return objpojo;\n }\n else \n return null; \n }\n";
					
					alldata.append(get_code);
					alldata.append(getquerysetter);
					alldata.append(getlast_code);
					
					String get_codelist="public ArrayList<pojo> getDetailsList(){ \n  			ArrayList<pojo> allDetails = new ArrayList<pojo> (); \n "
							+ "			SQLiteDatabase db = getReadableDatabase (); \n 			Cursor cursor = db.query (TABLE_"+Table_Name+", null, null, null, null, null, null); \n "
									+ " 			if(cursor != null && cursor.moveToFirst ()) { \n  			if(cursor.getCount () > 0) { \n 			do{ \n pojo objpojo = new pojo();\n ";
					String getlast_codelist="				   allDetails.add (objpojo); \n return objpojo;\n }\n			 while (cursor.moveToNext ());\n } \n } \n 			cursor.close (); \n "
							+ "			db.close (); \n 			return allDetails;\n";
					alldata.append(get_codelist);
					alldata.append(getquerysetter);
					alldata.append(getlast_codelist);
				}				
				qv.dtrpnQuery.setText(imports+"\npublic class DBAccess extends SQLiteOpenHelper {\n"+alldata.toString()+"}\n");
				qv.setVisible(true);
			}
		});
		btnCreate.setFont(new Font("Georgia", Font.BOLD, 15));
		btnCreate.setBounds(475, 11, 140, 36);
		panel_2.add(btnCreate);		
		
		/*comboBox_1 = new JComboBox();
		comboBox_1.setBounds(255, 20, 114, 20);
		comboBox_1.setBackground(new Color(255, 235, 205));
		comboBox_1.setForeground(Color.BLUE);
		comboBox_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 10));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "All" }));		
		panel_2.add(comboBox_1);	*/
		
		/*final JLabel lblGetKey = new JLabel("Get Key");
		lblGetKey.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 10));
		lblGetKey.setBounds(191, 23, 46, 14);
		panel_2.add(lblGetKey);
		comboBox_1.setVisible(false);
		lblGetKey.setVisible(false);*/
	
		/* ActionListener actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		        if(selected==false){
			    	    comboBox_1.setVisible(false);
			    		lblGetKey.setVisible(false);
			      }
		        for(int indx=0;indx<columnName.size();indx++)
		        {
					comboBox_1.addItem(columnName.get(indx).toString());
		        }
		        
		        	comboBox_1.setVisible(true);
		    		lblGetKey.setVisible(true);
		      }
		    };
		    chckbxGetlist.addActionListener(actionListener);*/
	}
	public static void centreWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}
	
public void createpojo(List<String> columnName,List<String> columnType){
	StringBuffer varibles=new StringBuffer();
	StringBuffer getters=new StringBuffer();
	StringBuffer setters=new StringBuffer();
	
	for(int indx=0;indx<columnName.size();indx++){
		String columntype="";
		if(columnType.get(indx).toString().equals("int primarykey")){
			columntype="int";
		}else{
			columntype="String";
		}
		varibles.append("private "+columntype+" "+columnName.get(indx)+";\n");
		getters.append("public "+columntype+" get"+columnName.get(indx)+"() {\n return "+columnName.get(indx)+";\n}\n");
		setters.append("public void set"+columnName.get(indx)+"("+columntype+" "+columnName.get(indx)+") {\n"
				+ "this."+columnName.get(indx)+" = "+columnName.get(indx)+";\n}\n");
	}
	qv.pojo.setText("public class pojo { \n"+varibles.toString()+getters.toString()+setters.toString()+"\n}");
}

}

