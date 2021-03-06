/*
 * NewJFrame.java
 *
 * Created on April 11, 2005, 4:55 PM
 */

package prac;

/**
 *
 * @author  Administrator
 */
import java.io.*;
import java.net.*;
import com.jscape.inet.ssh.*;
import com.jscape.inet.ssh.util.SshParameters;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;

public class NewJFrame extends javax.swing.JFrame implements SshListener {
    
    /** Creates new form NewJFrame */
    private boolean connected=false;
    private Ssh [] ssh={null, null};
    private String [] ulmanNodes=new String[2];//contains the IP addresses of the ULMAN Nodes
    private SwingWorker worker;
    private Ssh ssh1, ssh2;
        public NewJFrame() {

        initComponents();
        //Open The Nodes file
        try
        {
              BufferedReader ifile = 
              new BufferedReader(new FileReader("/root/Prac/src/ULMAN_Nodes.txt")); 
                   try
                   {
                        String  line;
                        int i=0;
                         while((line = ifile.readLine()) != null)
                         {
                             this.ulmanNodes[i]=line;
                             i++;
                          }
                     }
                     catch(IOException ioex)
                     {
                         this.jTextArea1.append("IO exception\n");
                     }
        }
          catch(FileNotFoundException fnf)
                {
                        this.jTextArea1.append("Couldn't open " + fnf.getMessage());
                }
        this.jTextField7.setText("");
        initFileChooser();
        
         
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */   
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">                          
    private void initComponents() {
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel17 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ULMAN Monitor");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setBorder(new javax.swing.border.EtchedBorder());
        jPanel7.setMinimumSize(new java.awt.Dimension(210, 100));
        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        jPanel13.setLayout(new java.awt.GridLayout(0, 1));

        jButton7.setText("Ping All Nodes");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel13.add(jButton7);

        jButton5.setText("Ssh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel13.add(jButton5);

        jButton6.setText("ULMAN Launch");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel13.add(jButton6);

        jPanel12.add(jPanel13);

        jPanel14.setLayout(new java.awt.GridLayout(0, 1));

        jLabel6.setText("Ping One Node");
        jPanel14.add(jLabel6);

        jTextField3.setText("Enter IP Address");
        jTextField3.setToolTipText("Enter IP Address to Ping One Node");
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });

        jPanel14.add(jTextField3);

        jButton10.setText("Ping Node");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jPanel14.add(jButton10);

        jPanel12.add(jPanel14);

        jPanel18.setLayout(new java.awt.GridLayout(0, 1));

        jPanel18.add(jTextField4);

        jPanel18.add(jTextField5);

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jPanel18.add(jTextField6);

        jPanel12.add(jPanel18);

        jPanel7.add(jPanel12);

        jPanel1.add(jPanel7, java.awt.BorderLayout.NORTH);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel5.setBorder(new javax.swing.border.EtchedBorder());
        jPanel5.setMinimumSize(new java.awt.Dimension(165, 75));
        jPanel5.setPreferredSize(new java.awt.Dimension(165, 75));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(new javax.swing.border.EtchedBorder());
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Protocol Manipulation Results");
        jPanel8.add(jLabel4, java.awt.BorderLayout.NORTH);

        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Serif", 0, 14));
        jTextArea1.setForeground(new java.awt.Color(255, 51, 51));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(8);
        jTextArea1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0)));
        jTextArea1.setDragEnabled(true);
        jScrollPane1.setViewportView(jTextArea1);

        jTabbedPane2.addTab("Node 1 Shell", jScrollPane1);

        jScrollPane2.setViewportView(jTextArea2);

        jTabbedPane2.addTab("Node2 Shell", jScrollPane2);

        jPanel8.add(jTabbedPane2, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel11.setLayout(new java.awt.GridLayout(0, 1));

        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Protocol Manipulation Options");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.add(jLabel2);
        jLabel2.getAccessibleContext().setAccessibleName("ULMAN Launch");

        jTextField8.setText("Enter Choice");
        jTextField8.setToolTipText("Enter Choices 1,2,3,");
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField8MouseClicked(evt);
            }
        });

        jPanel11.add(jTextField8);

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel11.add(jButton2);

        jButton3.setText("Stop Routing Protocols");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel11.add(jButton3);

        jButton4.setText("Remove Routing Protocols");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel11.add(jButton4);

        jPanel11.add(jButton11);

        jButton12.setText("jButton12");
        jPanel11.add(jButton12);

        jPanel5.add(jPanel11, java.awt.BorderLayout.WEST);

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setMinimumSize(new java.awt.Dimension(411, 100));
        jLabel5.setText("Enter path or Click Browse Button");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 20));

        jButton1.setIcon(new javax.swing.ImageIcon("E:\\Prac\\images\\Open16.gif"));
        jButton1.setText("Open Program");
        jButton1.setToolTipText("Open Program");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, 70));

        jLabel3.setText("Activate Network Analyzer And Other Test Scenarios");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel6.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 140, -1));

        jPanel1.add(jPanel6, java.awt.BorderLayout.SOUTH);

        jTabbedPane1.addTab("Communication And Control", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBorder(new javax.swing.border.EtchedBorder());
        jButton8.setText("jButton8");
        jPanel9.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 10, 100, -1));

        jPanel2.add(jPanel9, java.awt.BorderLayout.WEST);

        jPanel2.add(jPanel10, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Network Monitoring", jPanel2);

        jPanel3.setBorder(new javax.swing.border.MatteBorder(null));
        jTabbedPane1.addTab("Logging", jPanel3);

        jPanel4.setBorder(new javax.swing.border.MatteBorder(null));
        jTabbedPane1.addTab("Statistics And Analysis", jPanel4);

        jPanel15.setLayout(new java.awt.GridLayout(0, 1));

        jPanel16.setLayout(null);

        jLabel1.setText("Add ULMAN Node");
        jPanel16.add(jLabel1);
        jLabel1.setBounds(10, 10, 160, 15);

        jTextField1.setText("Enter IP Address");
        jTextField1.setToolTipText("Enter The IP Address of the ULMAN node to be added to the Network");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        jPanel16.add(jTextField1);
        jTextField1.setBounds(10, 60, 150, 19);

        jTextField2.setText("Enter Login");
        jTextField2.setToolTipText("Enter The Loging name of the ULMAN node to be added to the Network");
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });

        jPanel16.add(jTextField2);
        jTextField2.setBounds(170, 60, 120, 19);

        jButton9.setText("Enter");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });

        jPanel16.add(jButton9);
        jButton9.setBounds(476, 60, 90, 25);

        jPasswordField1.setText("Enter Password");
        jPasswordField1.setToolTipText("Enter The Password of the ULMAN node to be added to the Network");
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
        });

        jPanel16.add(jPasswordField1);
        jPasswordField1.setBounds(310, 60, 130, 19);

        jPanel15.add(jPanel16);

        jPanel15.add(jPanel17);

        jTabbedPane1.addTab("Network Management", jPanel15);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }
    // </editor-fold>                        

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {                                         
// TODO add your handling code here:
        this.jTextField8.setText("");
    }                                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
// TODO add your handling code here:
          OutputStream out;
        for(int i=0;i<2;i++)
        {
          String shell;
        try{
             if(!this.connected)
             {
                this.jTextArea1.append("Not Connected: \n");
              }
              else
              {
                out= this.ssh[i].getOutputStream();
               String command="/usr/local/bin/ulman_launch";
               try{
                    out.write(command.getBytes());
                 out.write("\r\n".getBytes());
             }
              catch(Exception ioe)
               {
                this.connected=false;
                }
             }
           }
       
     catch(Exception e)
        {
            e.printStackTrace();	
        }
        }
        
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
// TODO add your handling code here:
        try {
		if(ssh1!=null) {
                      ssh1.disconnect();	
		}
                if(ssh2!=null) {
                      ssh1.disconnect();	
		}
	} catch(Exception e) {
				
		}
              
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
// TODO add your handling code here:
        String shell;
        try{
             if(!this.connected)
             {
                this.jTextArea1.append("Not Connected: \n");
              }
              else
              {
                OutputStream out= ssh1.getOutputStream();
                OutputStream out2= ssh2.getOutputStream();
                String command=this.jTextField7.getText();
               try{
                    out.write(command.getBytes());
                 out.write("\r\n".getBytes());
                 out2.write(command.getBytes());
                 out2.write("\r\n".getBytes());
             }
              catch(Exception ioe)
               {
                this.connected=false;
                }
             }
           }
       
     catch(Exception e)
        {
            e.printStackTrace();	
        }
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
// TODO add your handling code here:
       this.connected = false;
        String hostname = null;
	String username = null;
	String password = null;
        String shell="", s;
       
        for(int i=0;i<2;i++)
        {
        // create new Ssh instance
        try {
        SshParameters params = new SshParameters(this.ulmanNodes[i],"root","r00t");//this.jTextField4.getText(), this.jTextField5.getText(), this.jTextField6.getText());
	this.ssh[i] = new Ssh(params);
        // register to capture events
	ssh[i].addSshListener(this);
        if(i==0)
        {
        this.jTextArea1.append("Connecting Please Wait................\n");
        // connect
        try{
	ssh[i].connect();
        }catch(SshException ex)
        {
            this.jTextArea1.append(ex.getMessage());
        }
 
        }
        else
        {
        this.jTextArea2.append("Connecting Please Wait................\n");
        try{
        ssh[i].connect();
        }
        catch(SshException ex)
        {
            this.jTextArea2.append(ex.getMessage());
        }
        }
	} catch (Exception e) {
			e.printStackTrace();			
	}
        }
        
    }                                        

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {                                            
// TODO add your handling code here:
    }                                           

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                          
// TODO add your handling code here:
        String s, out;
        out="";
         try {
                Process p = Runtime.getRuntime().exec("ping -c 4 " + this.jTextField3.getText());
                BufferedReader stdInput = new BufferedReader(new 
                InputStreamReader(p.getInputStream()));
                BufferedReader stdError = new BufferedReader(new 
                InputStreamReader(p.getErrorStream()));
                
          // read the output from the command
            
 //           System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                    out+=s;
                    out+="\n";
                this.jTextArea1.setText(out);
            }
            // read any errors from the attempted command

            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                out+=s;
                out+="\n";
                this.jTextArea1.setText(out);
            }
            
            //System.exit(0);
                 }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
  //          System.exit(-1);
        }
    }                                         

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {                                         
// TODO add your handling code here:
        this.jTextField3.setText("");
    }                                        

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {                                             
// TODO add your handling code here:
            this.jPasswordField1.setText("");
    }                                            

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {                                                
// TODO add your handling code here:
    }                                               

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {                                      
// TODO add your handling code here:
        
    }                                     

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                         
// TODO add your handling code here:
        
    }                                        

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {                                         
// TODO add your handling code here:
        this.jTextField2.setText("");
    }                                        

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {                                         
// TODO add your handling code here:
        this.jTextField1.setText("");
    }                                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
// TODO add your handling code here:
    }                                           

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
// TODO add your handling code here:
        BufferedReader in = null;
        for(int i=0;i<2; i++)//number of nodes
        {
           worker = new SwingWorker() {
                public Object construct() {
                    ;
                }
                public void finished() {
                    
                }
           };
       
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        OutputStream out;
        for(int i=0;i<2;i++)
        {
          String shell;
        try{
             if(!this.connected)
             {
                this.jTextArea1.append("Not Connected: \n");
              }
              else
              {
                out= this.ssh[i].getOutputStream();
               String command="2";
               try{
                    out.write(command.getBytes());
                 out.write("\r\n".getBytes());
             }
              catch(Exception ioe)
               {
                this.connected=false;
                }
             }
           }
       
     catch(Exception e)
        {
            e.printStackTrace();	
        }
        }
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        int retVal = jFileChooser1.showOpenDialog(NewJFrame.this);
         if (retVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.lang.String fileName = jFileChooser1.getSelectedFile().getAbsolutePath();
            //This is where a real application would open the file.
            try {
                Process p = Runtime.getRuntime().exec(fileName);
                BufferedReader stdInput = new BufferedReader(new 
                InputStreamReader(p.getInputStream()));
                BufferedReader stdError = new BufferedReader(new 
                InputStreamReader(p.getErrorStream()));

 /*         // read the output from the command
            
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
            // read any errors from the attempted command

            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
            
            System.exit(0);*/
                 }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
  //          System.exit(-1);
        }
//
  //          log.append("Opening: " + file.getName() + ".\n");
        } 
        else{
            log.append("Open command cancelled by user.\n" );
        }
        log.setCaretPosition(log.getDocument().getLength());
    }                                        
    private void initFileChooser()
    {
        log = new javax.swing.JTextArea(5,20);
        log.setMargin(new java.awt.Insets(5,5,5,5));
        log.setEditable(false);
        this.jFileChooser1 = new javax.swing.JFileChooser();
        this.jFileChooser1.setCurrentDirectory(new java.io.File("C:/dell"));
        
        
    }
    public void connected(SshConnectedEvent ev) {
                String shell=this.jTextArea1.getText();
                if(ev.getHost().compareTo(this.ulmanNodes[0])==0)
                {    
                this.jTextArea1.append("Connected: "+ev.getHost()+"\n");
                }
                else
                {
                     this.jTextArea2.append("Connected: "+ev.getHost()+"\n");
                }
                this.jButton6.setEnabled(true);
		this.connected = true;
	}

	/**
	 * Captures SshDataReceivedEvent
	 */
	public void dataReceived(SshDataReceivedEvent ev) {
       //         this.jTextArea1.append(ev.toString());
                Ssh ssh = (Ssh)ev.getSource();
                String hostname=ssh.getHostname();
                if(hostname.compareTo(this.ulmanNodes[0])==0)
        		this.jTextArea1.append(ev.getData());
                else
                        this.jTextArea2.append(ev.getData());
	}

	/**
	 * Captures SshDisconnectedEvent
	 */
	public void disconnected(SshDisconnectedEvent ev) {
       //         String shell=this.jTextArea1.getText();
         //       shell+="\nDisconnected why?: ";
                this.jTextArea1.append("Disconnected: "+ev.getHost()+"\n");
		connected = false;
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JTextArea log;
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration                   
    /**
	 * Captures SshConnectedEvent
	 */
	
}

