package pAssignment1Dhugald;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class CSGOGUI extends JFrame{

	private static ArrayList<Games>matches;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Date", "Team_One", "Team_Two", "Map", "ResultT1", "ResultT2", "Winner", "StartingCT", "CTRoundsT1", "TRoundsT2", "TRoundsT1", "CTRoundsT2", "EventID", "MatchID", "RankT1", "RankT2"
			}
		);
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JComboBox comboBox;
	private JList maps;
	private JTextField txtDate;
	private JTextField txtTeamOne;
	private JTextField txtTeamTwo;
	private JTextField txtEventid;
	private JTextField txtTRoundsWon;
	private JTextField txtCtRoundsWon;
	private JTextField txtTeamOneRank;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtTeamTwoRank;
	private JTextPane DateBox;
	private JFormattedTextField Team1Box;
	private JFormattedTextField Team2Box;
	private JFormattedTextField Team1CTRounds;
	private JFormattedTextField	Team1TRounds;
	private JFormattedTextField Team1Rank;
	private JFormattedTextField Team2Rank;
	private JFormattedTextField Team2CTRounds;
	private JFormattedTextField Team2TRounds;
	private JFormattedTextField MatchIDBox;
	private JFormattedTextField MapBox;
	private int listNum = 0;
	private JTextField txtMap;
	private JPanel panel_1;
	private JLabel mapImg;
	private ImageIcon image;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CSGOGUI frame = new CSGOGUI(matches);
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
	public CSGOGUI(ArrayList<Games>matches) {
		this.matches = matches;
		setTitle("Counter-Strike_Games");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1106, 829);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		tabbedPane.setBounds(20, 112, 1039, 678);
		contentPane.add(tabbedPane);
		

		JPanel panel = new JPanel();
		tabbedPane.addTab("Table", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 195, 1014, 419);
		scrollPane.setEnabled(false);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(tm);
		scrollPane.setViewportView(table);
		
		JButton ResetButton = new JButton("Reset Table");
		ResetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drawTable();
			}
		});
		ResetButton.setBounds(935, 615, 89, 35);
		panel.add(ResetButton);
		
		maps = new JList();
		maps.setBounds(10, 12, 198, 171);
		panel.add(maps);
		maps.setModel(new AbstractListModel() {
		    String[] values = new String[] {"Dust2", "Inferno", "Vertigo", "Nuke", "Overpass", "Mirage", "Train"};
		    public int getSize() {
		        return values.length;
		    }
		    public String getElementAt(int index) {
		        return values[index];
		    }
		});
		
		maps.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					mapsMouseClicked();
				}
			}
			
		});
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Default","Rank Team 1", "Rank Team 2", "CT Rounds T 1", "CT Rounds T 2", "T Rounds T 1", "T Rounds T2"}));
		comboBox.setBounds(218, 35, 150, 22);
		panel.add(comboBox);
		
		JFormattedTextField frmtdtxtfldSortBy = new JFormattedTextField();
		frmtdtxtfldSortBy.setText("Sort By:");
		frmtdtxtfldSortBy.setEditable(false);
		frmtdtxtfldSortBy.setBounds(218, 10, 150, 20);
		panel.add(frmtdtxtfldSortBy);
		
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("csgo.jpg"));
		getContentPane().add(lblNewLabel);
		lblNewLabel.setBounds(10, 11, 1039, 91);
		contentPane.add(lblNewLabel);
		SetMap(listNum);
		panel_1 = new JPanel();
		tabbedPane.addTab("Matches", null, panel_1, null);
		panel_1.setLayout(null);
		
		DateBox = new JTextPane();
		DateBox.setEditable(false);
		DateBox.setBounds(259, 151, 163, 20);
		panel_1.add(DateBox);
		
		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setText("Date");
		txtDate.setBounds(259, 131, 86, 20);
		panel_1.add(txtDate);
		txtDate.setColumns(10);
		
		Team1Box = new JFormattedTextField();
		Team1Box.setEditable(false);
		Team1Box.setBounds(260, 239, 136, 20);
		panel_1.add(Team1Box);
		
		txtTeamOne = new JTextField();
		txtTeamOne.setEditable(false);
		txtTeamOne.setText("Team One");
		txtTeamOne.setBounds(260, 218, 86, 20);
		panel_1.add(txtTeamOne);
		txtTeamOne.setColumns(10);
		
		Team2Box = new JFormattedTextField();
		Team2Box.setEditable(false);
		Team2Box.setBounds(537, 239, 136, 20);
		panel_1.add(Team2Box);
		
		txtTeamTwo = new JTextField();
		txtTeamTwo.setEditable(false);
		txtTeamTwo.setText("Team two");
		txtTeamTwo.setColumns(10);
		txtTeamTwo.setBounds(537, 218, 86, 20);
		panel_1.add(txtTeamTwo);
		
		txtEventid = new JTextField();
		txtEventid.setEditable(false);
		txtEventid.setText("MatchID");
		txtEventid.setBounds(792, 37, 157, 20);
		panel_1.add(txtEventid);
		txtEventid.setColumns(10);
		
		txtTRoundsWon = new JTextField();
		txtTRoundsWon.setText("T Rounds won");
		txtTRoundsWon.setEditable(false);
		txtTRoundsWon.setBounds(259, 270, 86, 20);
		panel_1.add(txtTRoundsWon);
		txtTRoundsWon.setColumns(10);
		
		Team1TRounds = new JFormattedTextField();
		Team1TRounds.setEditable(false);
		Team1TRounds.setBounds(259, 291, 137, 20);
		panel_1.add(Team1TRounds);
		
		txtCtRoundsWon = new JTextField();
		txtCtRoundsWon.setEditable(false);
		txtCtRoundsWon.setText("CT Rounds won");
		txtCtRoundsWon.setBounds(259, 322, 100, 20);
		panel_1.add(txtCtRoundsWon);
		txtCtRoundsWon.setColumns(10);
		
		Team1CTRounds = new JFormattedTextField();
		Team1CTRounds.setEditable(false);
		Team1CTRounds.setBounds(259, 345, 137, 20);
		panel_1.add(Team1CTRounds);
		
		txtTeamOneRank = new JTextField();
		txtTeamOneRank.setEditable(false);
		txtTeamOneRank.setText("Team One rank");
		txtTeamOneRank.setBounds(259, 376, 100, 20);
		panel_1.add(txtTeamOneRank);
		txtTeamOneRank.setColumns(10);
		
		Team1Rank = new JFormattedTextField();
		Team1Rank.setEditable(false);
		Team1Rank.setBounds(259, 400, 137, 20);
		panel_1.add(Team1Rank);
		
		textField = new JTextField();
		textField.setText("T Rounds won");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(536, 270, 86, 20);
		panel_1.add(textField);
		
		Team2Rank = new JFormattedTextField();
		Team2Rank.setEditable(false);
		Team2Rank.setBounds(536, 400, 137, 20);
		panel_1.add(Team2Rank);
		
		Team2TRounds = new JFormattedTextField();
		Team2TRounds.setEditable(false);
		Team2TRounds.setBounds(536, 291, 137, 20);
		panel_1.add(Team2TRounds);
		
		textField_1 = new JTextField();
		textField_1.setText("CT Rounds won");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(536, 322, 100, 20);
		panel_1.add(textField_1);
		
		Team2CTRounds = new JFormattedTextField();
		Team2CTRounds.setEditable(false);
		Team2CTRounds.setBounds(536, 345, 137, 20);
		panel_1.add(Team2CTRounds);
		
		txtTeamTwoRank = new JTextField();
		txtTeamTwoRank.setText("Team Two rank");
		txtTeamTwoRank.setEditable(false);
		txtTeamTwoRank.setColumns(10);
		txtTeamTwoRank.setBounds(536, 376, 100, 20);
		panel_1.add(txtTeamTwoRank);
		
		JButton NextData = new JButton("Next Game");
		NextData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listNum++;
				populateFields(listNum);
				SetMap(listNum);
				mapImg.setIcon(image);
			}
		});
		NextData.setBounds(537, 544, 136, 23);
		panel_1.add(NextData);
		
		JButton PrevData = new JButton("Previous Game");
		PrevData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listNum--;
				populateFields(listNum);
				SetMap(listNum);
				mapImg.setIcon(image);
			}
		});
		PrevData.setBounds(259, 544, 137, 23);
		panel_1.add(PrevData);
		
		MatchIDBox = new JFormattedTextField();
		MatchIDBox.setEditable(false);
		MatchIDBox.setBounds(792, 59, 157, 20);
		panel_1.add(MatchIDBox);
		
		txtMap = new JTextField();
		txtMap.setText("Map");
		txtMap.setEditable(false);
		txtMap.setBounds(792, 218, 86, 20);
		panel_1.add(txtMap);
		txtMap.setColumns(10);
		
		MapBox = new JFormattedTextField();
		MapBox.setEditable(false);
		MapBox.setBounds(792, 239, 136, 20);
		panel_1.add(MapBox);
		
		mapImg = new JLabel(new ImageIcon());
		mapImg.setBounds(792, 273, 199, 200);
		mapImg.setVisible(true);
		panel_1.add(mapImg);
		mapImg.setIcon(image);
		
		JButton btnNewButton = new JButton("First");
		btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					listNum = 0;
					populateFields(listNum);
					SetMap(listNum);
					mapImg.setIcon(image);
				}
		});
		btnNewButton.setBounds(140, 544, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnLast = new JButton("last");
	btnLast.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					listNum = 98;
					populateFields(listNum);
					SetMap(listNum);
					mapImg.setIcon(image);
				}
		});
		btnLast.setBounds(705, 544, 89, 23);
		panel_1.add(btnLast);
		

		drawTable();
		createTeamsGraph();
		populateFields(listNum);
		
		
		
	}


	public void SetMap(int listNum) {
		if(listNum > (0-1) && listNum < matches.size()) {
		if(matches.get(listNum).getMap().equals("Dust2")) {
			image = new ImageIcon("Dust2.jpg");
		}
		else if(matches.get(listNum).getMap().equals("Inferno")){
			image = new ImageIcon("Inferno.jpg");
		}
		else if(matches.get(listNum).getMap().equals("Vertigo")){
			image = new ImageIcon("Vertigo.jpg");
		}
		else if(matches.get(listNum).getMap().equals("Nuke")) {
			image = new ImageIcon("Nuke.jpg");
		}
		else if(matches.get(listNum).getMap().equals("Overpass")) {
			image = new ImageIcon("Overpass.jpg");
		}
		else if(matches.get(listNum).getMap().equals("Mirage")) {
			image = new ImageIcon("Mirage.jpg");
		}
		else if(matches.get(listNum).getMap().equals("Train")) {
			image = new ImageIcon("Train.jpg");
		}
		else {
			image = new ImageIcon("Dust2.jpg");
		}
		}
		
	}
	
	public void populateFields(int listNum) {
		
		if(listNum > (0-1) && listNum < matches.size()) {
		DateBox.setText(matches.get(listNum).getDate());
		Team1Box.setText(matches.get(listNum).getTeam1());
		Team2Box.setText(matches.get(listNum).getTeam2());
		Team2CTRounds.setText(matches.get(listNum).getCTRoundsT2());
		Team2TRounds.setText(matches.get(listNum).getTRoundsT2());
		Team1TRounds.setText(matches.get(listNum).getTRoundsT1());
		Team1CTRounds.setText(matches.get(listNum).getCTRoundsT1());
		Team1Rank.setText(matches.get(listNum).getRankT1());
		Team2Rank.setText(matches.get(listNum).getRankT2());
		MatchIDBox.setText(matches.get(listNum).getMatchID());
		MapBox.setText(matches.get(listNum).getMap());
		}
		else {
		    JOptionPane.showMessageDialog(contentPane, "Invalid move", "Warning",
		            JOptionPane.WARNING_MESSAGE);
		}


	}
	
	public void drawTable() 
	{
		tm.setRowCount(0);
		
		for(int i = 0; i < 99; i++) {
			Object[] object = new Object[16];
			object[0]=  matches.get(i).getDate();
			object[1]=  matches.get(i).getTeam1();
			object[2]=  matches.get(i).getTeam2();
			object[3]=  matches.get(i).getMap();
			object[4]=  matches.get(i).getResultT1();
			object[5]=  matches.get(i).getResultT2();
			object[6]=  matches.get(i).getWinner();
			object[7]=  matches.get(i).getStartingCT();
			object[8]=  matches.get(i).getCTRoundsT1();
			object[9]=  matches.get(i).getTRoundsT2();
			object[10]= matches.get(i).getTRoundsT1();
			object[11]= matches.get(i).getCTRoundsT2();
			object[12]= matches.get(i).getEventID();
			object[13]= matches.get(i).getMatchID();
			object[14]= matches.get(i).getRankT1();
			object[15]= matches.get(i).getRankT2();
			
			tm.addRow(object);
			
		}

		table.setAutoCreateRowSorter(true);
	}
	public void createTeamsGraph() {
		DefaultPieDataset data = new DefaultPieDataset();
		for(int i = 0; i < 99; i++) {
			data.setValue(matches.get(i).getMap(), i);
		}
		
		JFreeChart chart = ChartFactory.createPieChart("Maps Played", data, true, true, Locale.ENGLISH);
		ChartPanel mypanel = new ChartPanel(chart);
		mypanel.setVisible(true);
		

		tabbedPane.add("Graph", mypanel);
		
	}
	public void mapsMouseClicked() {
		tm.setRowCount(0);
	
		for(int i = 0; i < 99; i++) {
			Object[] object2 = new Object[16];
			object2[0]=  matches.get(i).getDate();
			object2[1]=  matches.get(i).getTeam1();
			object2[2]=  matches.get(i).getTeam2();
			object2[3]=  matches.get(i).getMap();
			object2[4]=  matches.get(i).getResultT1();
			object2[5]=  matches.get(i).getResultT2();
			object2[6]=  matches.get(i).getWinner();
			object2[7]=  matches.get(i).getStartingCT();
			object2[8]=  matches.get(i).getCTRoundsT1();
			object2[9]=  matches.get(i).getTRoundsT2();
			object2[10]= matches.get(i).getTRoundsT1();
			object2[11]= matches.get(i).getCTRoundsT2();
			object2[12]= matches.get(i).getEventID();
			object2[13]= matches.get(i).getMatchID();
			object2[14]= matches.get(i).getRankT1();
			object2[15]= matches.get(i).getRankT2();
			
			if(object2[3].equals(maps.getSelectedValue())) {
			tm.addRow(object2);
		}
			table.setAutoCreateRowSorter(true);
		}
	}
}
