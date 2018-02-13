package mjs236_SpotifyKnockoff;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import java.awt.ScrollPane;


public class SpotifyGUI {

	private static JFrame frame;
	private JRadioButton rdbtnAlbums;
	private JRadioButton rdbtnSongs;
	private JRadioButton rdbtnArtists;
	private JTextField txtSearch;
	private JTable libraryTable;
	private DefaultTableModel musicData;
	private JButton btnSearch;
	private JLabel lblSelectView;
	private JPanel menuPanelBackgound;
	private final ButtonGroup rdbtnGroup = new ButtonGroup();
	private JLabel lblSearch;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpotifyGUI window = new SpotifyGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SpotifyGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Spotify Knockoff");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		
		lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearch.setBounds(10, 10, 90, 20);
		frame.getContentPane().add(lblSearch);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(190, 36, 85, 21);
		frame.getContentPane().add(btnSearch);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(10, 37, 170, 19);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		rdbtnAlbums = new JRadioButton("Albums");
		rdbtnGroup.add(rdbtnAlbums);
		rdbtnAlbums.setBackground(Color.LIGHT_GRAY);
		rdbtnAlbums.setBounds(27, 130, 103, 21);
		frame.getContentPane().add(rdbtnAlbums);
		rdbtnAlbums.setSelected(true);
		
		rdbtnSongs = new JRadioButton("Songs");
		rdbtnGroup.add(rdbtnSongs);
		rdbtnSongs.setBackground(Color.LIGHT_GRAY);
		rdbtnSongs.setBounds(27, 164, 103, 21);
		frame.getContentPane().add(rdbtnSongs);
		
		rdbtnArtists = new JRadioButton("Artists");
		rdbtnGroup.add(rdbtnArtists);
		rdbtnArtists.setBackground(Color.LIGHT_GRAY);
		rdbtnArtists.setBounds(27, 199, 103, 21);
		frame.getContentPane().add(rdbtnArtists);
		
		lblSelectView = new JLabel("Select View");
		lblSelectView.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectView.setBounds(27, 93, 90, 20);
		frame.getContentPane().add(lblSelectView);
		
		menuPanelBackgound = new JPanel();
		menuPanelBackgound.setBackground(Color.LIGHT_GRAY);
		menuPanelBackgound.setBounds(0, 0, 299, 801);
		frame.getContentPane().add(menuPanelBackgound);
		
		Spotify spotify = Spotify.getInstance();
		
		musicData = spotify.getAlbumData("");
		libraryTable = new JTable(musicData);
		libraryTable.setBounds(298, 0, 1238, 801);
		libraryTable.setFillsViewportHeight(true);
		libraryTable.setShowGrid(true);
		libraryTable.setGridColor(Color.BLACK);
		frame.getContentPane().add(libraryTable);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		rdbtnAlbums.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnAlbums.isSelected()){
					rdbtnSongs.setSelected(false);
					rdbtnArtists.setSelected(false);
					musicData = spotify.getAlbumData("");
					libraryTable.setModel(musicData);
				}
			}
		});
		
		rdbtnSongs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnSongs.isSelected()){
					rdbtnAlbums.setSelected(false);
					rdbtnArtists.setSelected(false);
					musicData = spotify.getSongData("");
					libraryTable.setModel(musicData);
				}
			}
		});
		
		rdbtnArtists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnArtists.isSelected()){
					rdbtnAlbums.setSelected(false);
					rdbtnSongs.setSelected(false);
					musicData = spotify.getArtistData("");
					libraryTable.setModel(musicData);
				}
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnAlbums.isSelected()){
					musicData = spotify.getAlbumData(txtSearch.getText());
					libraryTable.setModel(musicData);
				}
				else if(rdbtnSongs.isSelected()){
					musicData = spotify.getSongData(txtSearch.getText());
					libraryTable.setModel(musicData);
				}
				else if(rdbtnArtists.isSelected()){
					musicData = spotify.getArtistData(txtSearch.getText());
					libraryTable.setModel(musicData);
				}				
			}
		});
		
		
	}
	
	public static JFrame getFrame() {
		return frame;
	}
}