package P2P_Socket;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.DropMode;


public class client extends javax.swing.JFrame 
{
	    private javax.swing.JButton jButton1_login;
	    private javax.swing.JButton jButton2_logout;
	    private javax.swing.JButton jButton_send;
	    private javax.swing.JButton jButton_testButton;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel10;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JLabel jLabel7;
	    private javax.swing.JLabel jLabel8;
	    private javax.swing.JLabel jLabel9;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JScrollPane jScrollPane2;
	    private javax.swing.JScrollPane jScrollPane3;
	   public static  javax.swing.JTextArea jTextArea1;
	    private javax.swing.JTextPane jTextPaneArea;
	    private javax.swing.JTextArea jTextArea3;
	    private javax.swing.JTextField jTextField1_localIP;
	    private javax.swing.JTextField jTextField_local_port;
	    private javax.swing.JTextField jTextField_remotIP;
	    private javax.swing.JTextField jTextField_remot_port;
	    private javax.swing.JTextField jTextField_tcpIP;
	    private javax.swing.JTextField jTextField_tcp_port;
	    private javax.swing.JTextField jTextField_username;
	    private javax.swing.JComboBox<String> jCombobox;
	  	 private javax.swing.JTextField jTextField_status;
	  	 String data;
	  	 ArrayList<String> users = new ArrayList<String>();
	  	 DatagramSocket socket;
	  	 String name;// user name
	  	 String LIP;//local IP
	  	 String RName;//remote IP as name
	  	 InetAddress RIP;// remote IP as Address
	  	 int LPort;//local port
	  	 int RPort;//remote port
	  	 byte[]sendData; //send data
	  	 byte[]receivedData;//received data
	  	 DatagramPacket sendPacket;//send datagram
	  	 DatagramPacket receivedPacket;//received datagram
	  	 boolean connectionState=false;//flag to check the connection 
	  	 private JTextField textField;
	     boolean find = false;
	    // End of variables declaration                   
	

	public client() 
	{initComponents();
	name="";
	LIP="";
	RName="";
	LPort=0;
	RPort=0;
	receivedData=new byte[1024];
	receivedPacket=new DatagramPacket(receivedData,receivedData.length);//create space for received datagram
	jTextField_status.setEditable(false);
	jTextArea1.setEditable(false);
	jTextPaneArea.setEditable(false);
	}
        

        private void initComponents() 
        {

            jPanel1 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jTextField_username = new javax.swing.JTextField();
            jButton1_login = new javax.swing.JButton();
            jButton2_logout = new javax.swing.JButton();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jTextField_tcpIP = new javax.swing.JTextField();
            jTextField_tcp_port = new javax.swing.JTextField();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTextArea1 = new javax.swing.JTextArea();
            jTextArea1.setDropMode(DropMode.INSERT);
            jLabel4 = new javax.swing.JLabel();
            jScrollPane2 = new javax.swing.JScrollPane();
            jTextPaneArea = new javax.swing.JTextPane();
            jScrollPane3 = new javax.swing.JScrollPane();
            jTextArea3 = new javax.swing.JTextArea();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            jLabel7 = new javax.swing.JLabel();
            jLabel8 = new javax.swing.JLabel();
            jLabel9 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            jTextField1_localIP = new javax.swing.JTextField();
            jTextField_local_port = new javax.swing.JTextField();
            jTextField_remotIP = new javax.swing.JTextField();
            jTextField_remot_port = new javax.swing.JTextField();
            jButton_send = new javax.swing.JButton();
            jButton_testButton = new javax.swing.JButton();
            jTextField_status = new javax.swing.JTextField();
            JButton jButton3_sendtoall = new javax.swing.JButton();
         
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            jLabel1.setText("user name:");

            jTextField_username.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField_usernameActionPerformed(evt);
                }
            });

            jButton1_login.setText("Login");
            jButton1_login.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1_loginActionPerformed(evt);
                }
            });
            jButton3_sendtoall.setText("Send to all");
            jButton3_sendtoall.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                	jButton3_sendtoallActionPerformed(evt);
                }

				private void jButton3_sendtoallActionPerformed(ActionEvent evt) {
					
			        	
			        	Mainclients.adduser(jTextField1_localIP.getText(),jTextField_local_port.getText(), jTextField_username.getText());
			        	

			             }
					
				
            });
            jButton2_logout.setText("Log out");
            jButton2_logout.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2_logoutActionPerformed(evt);
                }
            });

            jLabel2.setText("TCP Server IP");

            jLabel3.setText("TCP Server Port");

            jTextField_tcpIP.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField_tcpIPActionPerformed(evt);
                }
            });

            jTextField_tcp_port.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField_tcp_portActionPerformed(evt);
                }
            });

            jTextArea1.setColumns(20);
            jTextArea1.setRows(5);
            jScrollPane1.setViewportView(jTextArea1);


            jLabel4.setText("Online users");

            jTextPaneArea.setSize(20, 40);
                        jScrollPane2.setViewportView(jTextPaneArea);

            jTextArea3.setColumns(20);
            jTextArea3.setForeground(new java.awt.Color(153, 153, 153));
            jTextArea3.setRows(5);
            jTextArea3.setText("enter text here");
            jScrollPane3.setViewportView(jTextArea3);
            jTextArea3.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    Area3FocusGained(evt);
                }
                public void focusLost(java.awt.event.FocusEvent evt) {
                    Area3FocusLost(evt);
                }
            });

            jLabel5.setText("status:");

            jLabel6.setText("Send To All");

            jLabel7.setText("Local IP");

            jLabel8.setText("Local Port");

            jLabel9.setText("Remote IP");

            jLabel10.setText("Remote Port");

            jTextField1_localIP.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField1_localIPActionPerformed(evt);
                }
            });

            jTextField_local_port.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField_local_portActionPerformed(evt);
                }
            });

            jTextField_remotIP.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField_remotIPActionPerformed(evt);
                }
            });

            jTextField_remot_port.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField_remot_portActionPerformed(evt);
                }
            });

            jButton_send.setText("Send");
            jButton_send.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_sendActionPerformed(evt);
                }
            });

            jButton_testButton.setText("test Button");
            jButton_testButton.setPreferredSize(new Dimension(100,60));
            jButton_testButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_testButtonActionPerformed(evt);
                }
            });
            jTextField_status.setBackground(Color.white);
            jTextField_status.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jTextField_local_portActionPerformed(evt);
                }
            });
            
            JButton btnNewButton = new JButton("Send to all");
            btnNewButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		 jButton_sendtoallActionPerformed(e);
            	}
            });
            
            JLabel jLabel1_1 = new JLabel();
            jLabel1_1.setText("Password");
            
            textField = new JTextField();
            
            JButton btnNewButton_1 = new JButton("refresh onlineuser");
            btnNewButton_1.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		 try {
            			 jButton_refreshActionPerformed(e);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            });

           
          
            
            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1Layout.setHorizontalGroup(
            	jPanel1Layout.createParallelGroup(Alignment.LEADING)
            		.addGroup(jPanel1Layout.createSequentialGroup()
            			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
            				.addGroup(jPanel1Layout.createSequentialGroup()
            					.addContainerGap()
            					.addComponent(jLabel5)
            					.addPreferredGap(ComponentPlacement.RELATED)
            					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
            						.addGroup(jPanel1Layout.createSequentialGroup()
            							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
            								.addGroup(jPanel1Layout.createSequentialGroup()
            									.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
            										.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 536, GroupLayout.PREFERRED_SIZE)
            										.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 536, GroupLayout.PREFERRED_SIZE))
            									.addGap(35))
            								.addGroup(jPanel1Layout.createSequentialGroup()
            									.addGap(34)
            									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
            									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            									.addComponent(jLabel1_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
            									.addPreferredGap(ComponentPlacement.RELATED)
            									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
            									.addGap(60)))
            							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
            								.addGroup(jPanel1Layout.createSequentialGroup()
            									.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
            										.addGroup(jPanel1Layout.createSequentialGroup()
            											.addComponent(jButton_send)
            											.addGap(32)
            											.addComponent(jButton_testButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            										.addGroup(jPanel1Layout.createSequentialGroup()
            											.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
            												.addComponent(jLabel7)
            												.addComponent(jLabel8)
            												.addComponent(jLabel9)
            												.addComponent(jLabel10))
            											.addGap(10)
            											.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
            												.addComponent(jTextField1_localIP)
            												.addComponent(jTextField_local_port)
            												.addComponent(jTextField_remotIP)
            												.addComponent(jTextField_remot_port, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
            										.addGroup(jPanel1Layout.createSequentialGroup()
            											.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
            												.addComponent(jLabel2)
            												.addComponent(jLabel3))
            											.addGap(21)
            											.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
            												.addComponent(jTextField_tcpIP)
            												.addComponent(jTextField_tcp_port, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))
            									.addPreferredGap(ComponentPlacement.RELATED))
            								.addGroup(jPanel1Layout.createSequentialGroup()
            									.addPreferredGap(ComponentPlacement.RELATED)
            									.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
            										.addGroup(jPanel1Layout.createSequentialGroup()
            											.addComponent(btnNewButton)
            											.addPreferredGap(ComponentPlacement.RELATED))
            										.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))))
            							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
            								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            								.addComponent(jLabel4)))
            						.addComponent(jTextField_status, GroupLayout.PREFERRED_SIZE, 522, GroupLayout.PREFERRED_SIZE)))
            				.addGroup(jPanel1Layout.createSequentialGroup()
            					.addGap(36)
            					.addComponent(jButton2_logout, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
            					.addGap(18)
            					.addComponent(jButton1_login, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
            					.addGap(18)
            					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
            					.addPreferredGap(ComponentPlacement.UNRELATED)
            					.addComponent(jTextField_username, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))
            			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
            	jPanel1Layout.createParallelGroup(Alignment.LEADING)
            		.addGroup(jPanel1Layout.createSequentialGroup()
            			.addGap(26)
            			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
            				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
            					.addComponent(jButton2_logout, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
            					.addComponent(jButton1_login, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
            					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
            					.addComponent(jTextField_username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
            					.addComponent(jLabel2)
            					.addComponent(jTextField_tcpIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            			.addPreferredGap(ComponentPlacement.RELATED)
            			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
            				.addGroup(jPanel1Layout.createSequentialGroup()
            					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
            						.addGroup(jPanel1Layout.createSequentialGroup()
            							.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
            								.addComponent(jLabel1_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
            								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            								.addComponent(jLabel3))
            							.addGap(31))
            						.addGroup(jPanel1Layout.createSequentialGroup()
            							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
            							.addGap(18)))
            					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
            						.addGroup(jPanel1Layout.createSequentialGroup()
            							.addComponent(jLabel6)
            							.addGap(18)
            							.addComponent(btnNewButton)
            							.addGap(71)
            							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
            								.addGroup(jPanel1Layout.createSequentialGroup()
            									.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
            										.addComponent(jLabel7)
            										.addComponent(jTextField1_localIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            									.addGap(22)
            									.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
            										.addComponent(jLabel8)
            										.addComponent(jTextField_local_port, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            									.addGap(24)
            									.addComponent(jLabel9))
            								.addComponent(jTextField_remotIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            							.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
            								.addComponent(jLabel10)
            								.addComponent(jTextField_remot_port, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
            					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
            						.addGroup(jPanel1Layout.createSequentialGroup()
            							.addPreferredGap(ComponentPlacement.RELATED)
            							.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
            						.addGroup(jPanel1Layout.createSequentialGroup()
            							.addGap(48)
            							.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
            								.addComponent(jButton_send, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
            								.addComponent(jButton_testButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
            					.addGap(18)
            					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
            						.addComponent(jLabel5)
            						.addComponent(jTextField_status, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
            				.addGroup(jPanel1Layout.createSequentialGroup()
            					.addGap(17)
            					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
            						.addComponent(jLabel4)
            						.addComponent(jTextField_tcp_port, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            					.addPreferredGap(ComponentPlacement.RELATED)
            					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)))
            			.addContainerGap(85, Short.MAX_VALUE))
            );
            jPanel1.setLayout(jPanel1Layout);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(884, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 509, Short.MAX_VALUE))
            );

            pack();
        
        }
			

        protected void jButton_refreshActionPerformed(ActionEvent e) throws IOException {
        	
			String d="";
		
			for( int i=0;i<Mainclients.onLineUsers.size();i++) {
	    		d+=Mainclients.onLineUsers.get(i)+'\n';
	    		System.out.println(d);
	    	}
		//	Mainclients.client1.jTextArea1.setText(getuser());
			
			 client.jTextArea1.setText(d);

	        } 

		protected void jButton_sendtoallActionPerformed(ActionEvent e) {
			 try {
		            if (!connectionState) {
		                JOptionPane.showMessageDialog(null, "The connection is closed, please open it with test button");
		            } else if (jTextField_username.getText().equals("")) {
		            	jTextField_username.setBorder(BorderFactory.createLineBorder(Color.red)); 
		            } else if (jTextArea3.getText().equals("") || jTextArea3.getText().equals("enter text here")) {
		            	jTextArea3.setBorder(BorderFactory.createLineBorder(Color.red));  
		            
		            }
		            else {
		            	jTextArea3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));  
		            	jTextField_username.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));  
		            	jTextField_remotIP.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); 
		                name = jTextField_username.getText();
		                RName = jTextField_remotIP.getText();
		               
		               
		                String msg = jTextArea3.getText();
		                jTextArea3.setText("");
		                StyledDocument Document = jTextPaneArea.getStyledDocument();// add a style to pane area
		                Style style = jTextPaneArea.addStyle("", null);
		                StyleConstants.setForeground(style, Color.RED);
		                StyleConstants.setBackground(style, Color.white);
		                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			             LocalDateTime now = LocalDateTime.now();
			             String mymsg = "ME: " + msg + " From " + LPort +"\t\t\t\t"+ dtf.format(now)+"\n";;//my�sending�message//my sending message
		                Document.insertString(Document.getLength(), mymsg, style);
		                msg = name + ": " + msg;
		                sendData = msg.getBytes();
		                for(int i=0;i<Mainclients.onLineUsers.size();i++) {
		                	String user=Mainclients.onLineUsers.get(i);
		                	String[] arrOfStr = user.split(",", 3);
		                	 RPort = (Integer.parseInt(arrOfStr[1]));			                
		                	 RIP =InetAddress.getByName(arrOfStr[0]);
		                	 if(jTextField_username.getText().equals(arrOfStr[2]) )
		                		 continue;
		                sendPacket = new DatagramPacket(sendData, sendData.length, RIP, RPort);// datagram that will be send
		                socket.send(sendPacket);
		                }//write out datagram to socket

		            }
		        } catch (UnknownHostException ex) {
		            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
		        } catch (IOException | BadLocationException ex) {
		            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
		        }
     }                                            

			
		


		


		private void jButton_sendActionPerformed(java.awt.event.ActionEvent evt) {  
			//check the connection before sending and make sure that all required field is filled
			 try {
		            if (!connectionState) {
		                JOptionPane.showMessageDialog(null, "The connection is closed, please open it with test button");
		            } //else if (jTextField_username.getText().equals("")) {
		            	//jTextField_username.setBorder(BorderFactory.createLineBorder(Color.red)); 
		            //}
		            else if (jTextArea3.getText().equals("") || jTextArea3.getText().equals("enter text here")) {
		            	jTextArea3.setBorder(BorderFactory.createLineBorder(Color.red));  
		            
		            }else if(jTextField_remotIP.getText().equals("")){
	                	jTextField_remotIP.setBorder(BorderFactory.createLineBorder(Color.red));
	                }
		            else {
		            	jTextArea3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));  
		            	jTextField_username.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));  
		            	jTextField_remotIP.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); 
		                name = jTextField_username.getText();
		                RName = jTextField_remotIP.getText();
		                RPort = Integer.parseInt(jTextField_remot_port.getText());
		                RIP = InetAddress.getByName(RName);//get IP address 
		               
		                String msg = jTextArea3.getText();
		                jTextArea3.setText("");
		                StyledDocument Document = jTextPaneArea.getStyledDocument();// add a style to pane area
		                Style style = jTextPaneArea.addStyle("", null);
		                StyleConstants.setForeground(style, Color.RED);
		                StyleConstants.setBackground(style, Color.white);
		                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			             LocalDateTime now = LocalDateTime.now();
			             String mymsg = "ME: " + msg + " From " + LPort +"\t\t\t\t"+ dtf.format(now)+"\n";;//my�sending�message//my sending message
		                Document.insertString(Document.getLength(), mymsg, style);
		                msg = name + ": " + msg;
		                sendData = msg.getBytes();
		                sendPacket = new DatagramPacket(sendData, sendData.length, RIP, RPort);// datagram that will be send
		                socket.send(sendPacket);//write out datagram to socket

		            }
		        } catch (UnknownHostException ex) {
		            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
		        } catch (IOException | BadLocationException ex) {
		            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
		        }
        }                                            

        private void jTextField_usernameActionPerformed(java.awt.event.ActionEvent evt) {                                                    
         
        }                                                   

        private void jButton1_loginActionPerformed(java.awt.event.ActionEvent evt) {                                               
        	try {
    		      File myObj = new File("Users");
    		      Scanner myReader = new Scanner(myObj);
    		      while (myReader.hasNextLine()) {
    		         data = myReader.nextLine();
    		         users.add(data);
    		      }
    		      myReader.close();
    		    } catch (FileNotFoundException e) {
    		      System.out.println("An error occurred.");
    		      e.printStackTrace();
    		    }
      		for(int i=0; i<users.size();i++) {
      			String get=users.get(i);
      			String con= jTextField_username.getText()+" "+textField.getText();
      			if(get.equals(con)) {
      	 		find = true;
      	 		}
      		}
      		if(find) {
      			        JOptionPane.showMessageDialog(null,"The username and the password are correct");
      	            	 Mainclients.getuser();
      	            	if(!( Mainclients.string.contains(jTextField_username.getText()) || Mainclients.string.contains(jTextField_local_port.getText()))){
      	            		 if (jTextField1_localIP.getText().equals("")) {
      	     	             	jTextField1_localIP.setBorder(BorderFactory.createLineBorder(Color.red));
      	     	             }
      	     	             else if(jTextField_local_port.getText().equals("")){
      	     	             	jTextField_local_port.setBorder(BorderFactory.createLineBorder(Color.red));
      	     	             }
      	     	             else {
      	     	        	
      	        	Mainclients.adduser(jTextField1_localIP.getText(),jTextField_local_port.getText(),jTextField_username.getText() );
      	            

      	             }
      		        }
      	            	else {
      	            		 JOptionPane.showMessageDialog(null,"The username or the port already exist");
      	            	}
      	            	
      		}
       		if(!find) {
       			JOptionPane.showMessageDialog(null,"The username and the password are not coorrect");
       			jTextField_username.setText("");
       			textField.setText("");
       		}
        	
        }                                              

        private void jButton2_logoutActionPerformed(java.awt.event.ActionEvent evt) {     
        	
            
              for(int i=0 ;i<Mainclients.onLineUsers.size();i++) {
            	  String user=Mainclients.onLineUsers.get(i);
              	String[] arrOfStr = user.split(",", 3);
              	// RPort = (Integer.parseInt(arrOfStr[2]));	
              if(jTextField_username.getText().equals(arrOfStr[2]) ){
            	  Mainclients.onLineUsers.remove(i);  
              }
              else
            	  continue;
              }
              jTextField_username.setText("");
              textField.setText("");
              jTextField_tcpIP.setText("");
              jTextField_tcp_port.setText("");
              jTextField1_localIP.setText("");
              jTextField_local_port.setText("");
              jTextPaneArea.setText("");
              jTextArea1.setText("");
              jTextField_remotIP.setText("");
              jTextField_remot_port.setText("");
              jTextField_status.setText("");
            
              JOptionPane.showMessageDialog(null,"you are logout ");
              }
     // events and args should be of type Array
       
        	
        private void jTextField_tcpIPActionPerformed(java.awt.event.ActionEvent evt) {                                                 
           
        }                                                

        private void jTextField_tcp_portActionPerformed(java.awt.event.ActionEvent evt) {                                                    
            
        }                                                   

        private void jTextField1_localIPActionPerformed(java.awt.event.ActionEvent evt) {                                                    
         
        }                                                   

        private void jTextField_local_portActionPerformed(java.awt.event.ActionEvent evt) {                                                      
      
        }                                                     

        private void jTextField_remotIPActionPerformed(java.awt.event.ActionEvent evt) {                                                   
           
        }                                                  

        private void jTextField_remot_portActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        
        }                                                     

        private void jButton_testButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        	 
         //check if the required field is filled
                if (jTextField1_localIP.getText().equals("")) {
                	jTextField1_localIP.setBorder(BorderFactory.createLineBorder(Color.red));
                }
                else if(jTextField_local_port.getText().equals("")){
                	jTextField_local_port.setBorder(BorderFactory.createLineBorder(Color.red));
                }
                
                            
                else {
                	connectionState = true;
                    
                	try {
                	   LIP = jTextField1_localIP.getText();
                	   LPort = Integer.parseInt(jTextField_local_port.getText());
                       socket = new DatagramSocket(LPort); //create socket for local port             
	                   receiveThread chating = new receiveThread(this);// start thread
	                   chating.start();
	                   JOptionPane.showMessageDialog(null, "You can start chating");
	                   jTextField1_localIP.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	                   jTextField_local_port.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));  
	                   jTextField_remotIP.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	                   jTextField_remot_port.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));  
                   }catch(Exception e) { JOptionPane.showMessageDialog(null, "Port number must be integer value");}}}
                    
                
            
         //add and remove placeholder    
        private void Area3FocusGained(java.awt.event.FocusEvent evt) {

            if (jTextArea3.getText().equals("enter text here")) {
            	jTextArea3.setText("");
            	jTextArea3.setForeground(Color.BLACK);
            }
        }

        private void Area3FocusLost(java.awt.event.FocusEvent evt) {
              if (jTextArea3.getText().isEmpty()) {
            	jTextArea3.setForeground(Color.GRAY);
            	jTextArea3.setText("enter text here");
            }
        }
        void receive() {
        	
            try {
                StyledDocument Document = jTextPaneArea.getStyledDocument();
                Style style = jTextPaneArea.addStyle("", null);
                socket.receive(receivedPacket);//receive datagram
                String msg = new String(receivedData, 0, receivedPacket.getLength());
                InetAddress senderAddress = receivedPacket.getAddress();//get the sender address 
                int senderPort = receivedPacket.getPort();//get the sender port
                StyleConstants.setForeground(style, Color.BLUE);
                StyleConstants.setBackground(style, Color.white);
	              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	              LocalDateTime now = LocalDateTime.now();
	              String mymsg = msg + " From " + senderPort +"\t\t\t\t"+ dtf.format(now)+"\n";
                Document.insertString(Document.getLength(), mymsg, style);
                String senderIP = senderAddress.getHostAddress();//get the sender IP

                jTextField_status.setText("Received From IP= " + senderIP + ", port= " + senderPort);//fill the sender information in status field
               } catch (IOException | BadLocationException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public static void user() {
        	
        	jTextArea1.setText(Mainclients.getuser());
        }
        private void jComboboxActionPerformed(java.awt.event.ActionEvent evt) {                                          
           
        }  
        
        
       
        public static void main(String args[]) 
        {
           
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
           
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                	
                    client Client=new client();
                    Client.setVisible(true);
                    Client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    Client.setSize(1200,700);

                }
            });
        }
}

	





















