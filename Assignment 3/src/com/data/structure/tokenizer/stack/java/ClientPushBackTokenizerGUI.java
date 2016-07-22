package com.data.structure.tokenizer.stack.java;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * @author	Bekabil Tolassa
 * Date:	June 06, 2015
 * Class:	ICS 372
 * Program:	Assignment 3.
 * Purpose:	A ClientPushBackTokenizerGUI class is a client side application.
 * 			This class creates an object of PushbackTokenizer 
 * 			 that implements PushbackableTokenizer interface.
 * 			This GUI class displays a window to a client to create a Tokenizer,
 * 			  to display next token, to push back, to clear tokenizer, and to exit.
 * 			In order to use these functionalities client should press the buttons.
 * 			This class allows the user to read a token and push it back to the stream
 * 			 from which the token was read. 
 * 			Tokens are assumed to be separated by white space.
 * 			Any number of tokens may be pushed back. Information message may be
 * 			 displayed to inform user if there is no more tokens to push back and
 * 			 if there is no more tokens read or to display. 			
 */

public class ClientPushBackTokenizerGUI {

	private PushbackTokenizer pushbackTokenizer;
	private JFrame frmClientTokenizerManipulation;
	private JButton btnNextToken;
	private JButton btnPushBack;
	private JButton btnClearToken;
	private JTextField txtEnterTokens;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientPushBackTokenizerGUI window = new ClientPushBackTokenizerGUI();
					window.frmClientTokenizerManipulation.setLocation(600, 150);
					window.frmClientTokenizerManipulation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientPushBackTokenizerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClientTokenizerManipulation = new JFrame();
		frmClientTokenizerManipulation.setResizable(false);
		frmClientTokenizerManipulation.setBackground(Color.MAGENTA);
		frmClientTokenizerManipulation.setForeground(Color.BLUE);
		frmClientTokenizerManipulation.setFont(new Font("Courier New", Font.BOLD, 16));
		frmClientTokenizerManipulation.setTitle("Tokenizer Processing System");
		frmClientTokenizerManipulation.setBounds(100, 100, 659, 161);
		frmClientTokenizerManipulation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClientTokenizerManipulation.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("160px"),
				ColumnSpec.decode("5dlu"),
				ColumnSpec.decode("125px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("130px"),
				ColumnSpec.decode("left:max(30dlu;default)"),},
				new RowSpec[] {
				RowSpec.decode("5dlu"),
				RowSpec.decode("19px"),
				RowSpec.decode("25px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		//txtEnterTokens is created, default value will be displayed
		txtEnterTokens = new JTextField();
		txtEnterTokens.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtEnterTokens.setForeground(Color.RED);
		txtEnterTokens.setText("Java is pure object oriented language");
		frmClientTokenizerManipulation.getContentPane().add(txtEnterTokens, "1, 2, 7, 2, fill, fill");
		txtEnterTokens.setColumns(10);
		
		//buttons btnCreateTokens is created, registered, and its action is performed
		JButton btnCreateTokens = new JButton("Create Tokenizer");
		btnCreateTokens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pushbackTokenizer = new PushbackTokenizer(txtEnterTokens.getText());
				txtEnterTokens.setText("");
			}
		});
		btnCreateTokens.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmClientTokenizerManipulation.getContentPane().add(btnCreateTokens, "1, 5, left, top");
		//buttons btnNextToken is created, registered, and its action is performed
		btnNextToken = new JButton("Next Token");
		btnNextToken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pushbackTokenizer instanceof PushbackTokenizer) {
					txtEnterTokens.setText(txtEnterTokens.getText() + " " + pushbackTokenizer.nextToken());
				}
				else {
					JOptionPane.showMessageDialog(null, 
							"To request next token, you must create at least one token!", 
							"Next Token", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNextToken.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmClientTokenizerManipulation.getContentPane().add(btnNextToken, "3, 5, left, top");
		//buttons btnPushBack is created, registered, and its action is performed
		btnPushBack = new JButton("Push Back");
		btnPushBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pushbackTokenizer instanceof PushbackTokenizer) {
					pushbackTokenizer.pushback();
				}
				else {
					JOptionPane.showMessageDialog(null, 
							"To request a token to be pushed back, you must first create at least one token!", 
							"Push Back", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnPushBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmClientTokenizerManipulation.getContentPane().add(btnPushBack, "5, 5, left, top");
		//buttons btnClearToken is created, registered, and its action is performed
		btnClearToken = new JButton("Clear Tokens");
		btnClearToken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				//both stacks are empty and ready to store new tokens.
				if(pushbackTokenizer instanceof PushbackTokenizer) {
					txtEnterTokens.setText("You may type in and create your own tokenizer");
					((PushbackTokenizer) pushbackTokenizer).clearStackOftokens();
				}
				else {
					JOptionPane.showMessageDialog(null, 
							"To clear tokens, you must first create at least one token!", 
							"Clear Tokens", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnClearToken.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmClientTokenizerManipulation.getContentPane().add(btnClearToken, "6, 5, left, top");
		//buttons btnExit is created, registered, and its action is performed
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//stop execution
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmClientTokenizerManipulation.getContentPane().add(btnExit, "7, 5");
	}
	
}
