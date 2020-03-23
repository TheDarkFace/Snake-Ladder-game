// -*- coding: utf-8 -*-
/**
 *	created on Saturday 26 October 2019 00:04:40
 *	@author Sk_Saddy
 */
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Watch extends Frame implements ActionListener {
	JFrame f;
	Button[] cell = new Button[110];
	int i, start = 90, move = 0;
	Watch() {
		f = new JFrame("Snake & Ladder GAME");
		int name = 0,update = 29;
		for(i = 0; i < 100; i++) {
			name = i/10;
			if(name%2 == 0)
				cell[i] = new Button(Integer.toString(100-i));
			else
				cell[i] = new Button(Integer.toString(100-update+i));
			if((i+1)%10 == 0 && name%2 != 0)			
				update+=40;
			cell[i].setBackground(Color.darkGray);
			cell[i].setForeground(Color.blue);
		}
		for(i = 100; i < 110; i++) {
			cell[i] = new Button();
			cell[i].setBackground(Color.blue);
			cell[i].setForeground(Color.white);
		}
		for(i = 0; i < 110; i++)
			f.add(cell[i]);
		cell[0].setBackground(Color.green);
		cell[0].setForeground(Color.black);
		cell[0].setLabel("FINISH");
		cell[90].setBackground(Color.black);
		cell[90].setLabel("START");
		cell[103].setLabel("ROLL");
		cell[101].setLabel("RESTART");
		cell[105].setLabel("0");
		// Creating Saap & Shiri
		saapShiri(cell);

		f.setLayout(new GridLayout(11,10));
		f.setSize(950,735);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Listen to buttons
		cell[101].addActionListener(this);
		cell[103].addActionListener(this);
	}
	public void saapShiri(Button[] cell) {
// ladder
		cell[16].setBackground(Color.lightGray);
		cell[26].setBackground(Color.lightGray);
		cell[36].setBackground(Color.lightGray);
		cell[46].setBackground(Color.lightGray);
		cell[56].setBackground(Color.lightGray);

		cell[2].setBackground(Color.lightGray);
		cell[12].setBackground(Color.lightGray);
		cell[22].setBackground(Color.lightGray);
		cell[32].setBackground(Color.lightGray);
		cell[42].setBackground(Color.lightGray);
		cell[52].setBackground(Color.lightGray);
		cell[62].setBackground(Color.lightGray);

		cell[78].setBackground(Color.lightGray);
		cell[88].setBackground(Color.lightGray);
		cell[98].setBackground(Color.lightGray);

		cell[8].setBackground(Color.lightGray);
		cell[18].setBackground(Color.lightGray);
		cell[28].setBackground(Color.lightGray);
		cell[38].setBackground(Color.lightGray);
// snake
		cell[6].setBackground(Color.red);
		cell[15].setBackground(Color.red);
		cell[24].setBackground(Color.red);
		cell[34].setBackground(Color.red);
		cell[43].setBackground(Color.red);

		cell[50].setBackground(Color.red);
		cell[61].setBackground(Color.red);
		cell[72].setBackground(Color.red);

		cell[55].setBackground(Color.red);
		cell[64].setBackground(Color.red);
		cell[75].setBackground(Color.red);
		cell[86].setBackground(Color.red);
		cell[95].setBackground(Color.red);

		cell[39].setBackground(Color.red);
		cell[49].setBackground(Color.red);
		cell[58].setBackground(Color.red);
		cell[67].setBackground(Color.red);
	}
	public void actionPerformed(ActionEvent e) {
		// Start
		if(e.getSource() == cell[103]) {
			Random ran = new Random();
			int dice = ran.nextInt(6)+1;
			cell[105].setLabel(Integer.toString(dice));
			if(dice == 1 && start == 90) {
				move = start + dice;
				cell[move].setVisible(false);
				start = move;
			}
			else if(start!=90) {
				cell[start].setVisible(true);
				int state = start/10;

				// Traversal
				if(move == 5 && dice > 5)
					move = 5;
				else if(move == 4 && dice > 4)
					move = 4;
				else if(move == 3 && dice > 3)
					move = 3;
				else if(move == 2 && dice > 2)
					move =  2;
				else if(move == 1 && dice > 1)
					move = 1;
				else {
					if(state%2 == 0) {
						if(move%10 == 5 && dice > 5) {
							move = start - 5;
							move -= 10;
							cell[move].setVisible(false);
						}
						else if(move%10 == 4 && dice > 4) {
							move = start - 4;
							switch(dice) {
								case 5: move -= 10;
										break;
								case 6: move -= 9;
										break;
							}
							cell[move].setVisible(false);
						}
						else if(move%10 == 3 && dice > 3) {
							move = start - 3;
							switch(dice) {
								case 4: move -= 10;
										break;
								case 5: move -= 9;
										break;
								case 6: move -= 8;
										break;
							}
							cell[move].setVisible(false);
						}
						else if(move%10 == 2 && dice > 2) {
							move = start - 2;
							switch(dice) {
								case 3: move -= 10;
										break;
								case 4: move -= 9;
										break;
								case 5: move -= 8;
										break;
								case 6: move -= 7;
										break;
							}
							cell[move].setVisible(false);
						}
						else if(move%10 == 1 && dice > 1) {
							move = start - 1;
							switch(dice) {
								case 2: move -= 10;
										break;
								case 3: move -= 9;
										break;
								case 4: move -= 8;
										break;
								case 5: move -= 7;
										break;
								case 6: move -= 6;
										break;
							}
							cell[move].setVisible(false);
						}
						else if(move%10 == 0) {
							move = start;
							switch(dice) {
								case 1: move -= 10;
										break;
								case 2: move -= 9;
										break;
								case 3: move -= 8;
										break;
								case 4: move -= 7;
										break;
								case 5: move -= 6;
										break;
								case 6: move -= 5;
										break;
							}
							cell[move].setVisible(false);
						}
						else{
							move = start - dice;
							cell[move].setVisible(false);
						}
					}
					else {
						if(move%10 == 4 && dice > 5) {
							move = start + 5;
							move -= 10;
							cell[move].setVisible(false);
						}
						else if(move%10 == 5 && dice > 4) {
							move = start + 4;
							switch(dice) {
								case 5: move -= 10;
										break;
								case 6: move -= 11;
										break;
							}
							cell[move].setVisible(false);
						}
						else if(move%10 == 6 && dice > 3) {
							move = start + 3;
							switch(dice) {
								case 4: move -= 10;
										break;
								case 5: move -= 11;
										break;
								case 6: move -= 12;
										break;
							}
							cell[move].setVisible(false);
						}
						else if(move%10 == 7 && dice > 2) {
							move = start + 2;
							switch(dice) {
								case 3: move -= 10;
										break;
								case 4: move -= 11;
										break;
								case 5: move -= 12;
										break;
								case 6: move -= 13;
										break;
							}
							cell[move].setVisible(false);
						}
						else if(move%10 == 8 && dice > 1) {
							move = start + 1;
							switch(dice) {
								case 2: move -= 10;
										break;
								case 3: move -= 11;
										break;
								case 4: move -= 12;
										break;
								case 5: move -= 13;
										break;
								case 6: move -= 14;
										break;
							}
							cell[move].setVisible(false);
						}
						else if(move%10 == 9) {
							move = start;
							switch(dice) {
								case 1: move -= 10;
										break;
								case 2: move -= 11;
										break;
								case 3: move -= 12;
										break;
								case 4: move -= 13;
										break;
								case 5: move -= 14;
										break;
								case 6: move -= 15;
										break;
							}
							cell[move].setVisible(false);
						}
						else{
							move = start + dice;
							cell[move].setVisible(false);
						}
					}
				}
				cell[move].setVisible(false);

				switch(move) {
		// ladder condition go-up
					case 98: cell[move].setVisible(true);
							move=78;
							cell[move].setVisible(false);
							break;
					case 62: cell[move].setVisible(true);
							move=2;
							cell[move].setVisible(false);
							break;
					case 38: cell[move].setVisible(true);
							move=8;
							cell[move].setVisible(false);
							break;
					case 56: cell[move].setVisible(true);
							move=16;
							cell[move].setVisible(false);
							break;
		// snake condition go-down
					case 50: cell[move].setVisible(true);
							move=72;
							cell[move].setVisible(false);
							break;
					case 6: cell[move].setVisible(true);
							move=43;
							cell[move].setVisible(false);
							break;
					case 55: cell[move].setVisible(true);
							move=95;
							cell[move].setVisible(false);
							break;
					case 39: cell[move].setVisible(true);
							move=67;
							cell[move].setVisible(false);
							break;
				}
				// game over
				if(move == 0)
					cell[103].setEnabled(false);
				start = move;
			}
		}
		// Reset
		if(e.getSource() == cell[101]) {
			cell[move].setVisible(true);
			cell[103].setEnabled(true);
			cell[105].setLabel("0");
			move = 0;
			start = 90;
		}
	}
}

class SnakeLadder {
	public static void main(String[] args) {
		new Watch();
	}
}