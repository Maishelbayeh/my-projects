package P2P_Socket;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Mainclients {
	public static ArrayList<String> onLineUsers = new ArrayList<String>();
	public static String string="";
    public static void adduser(String IP,String Port,String username) {
    	onLineUsers.add(IP+","+Port+","+username);
    }
    public static String getuser() {
    	string="";
    	for(int i=0;i<onLineUsers.size();i++) {
    		string+=onLineUsers.get(i)+'\n';
    	}
    	
    	return string;
    }
   
		

	 public static void main(String[] args) {
	        client client1 = new client();
	        client1.setVisible(true);
	        client1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        client1.setSize(1200,700);
	       
	    	
	        client client2 = new client();
	        client2.setVisible(true);
	        client2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        client2.setSize(1200,700);
	    	
	        client client3 = new client();
	        client3.setVisible(true);
	        //client3.jTextArea1.setText("gt5gt5");
	        client3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        client3.setSize(1200,700);
	      
	     
            tcp_ser_client tcpServer=new tcp_ser_client();
            tcpServer.setVisible(true);
            tcpServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
	    }

}
