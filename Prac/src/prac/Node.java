/*
 * Node.java
 *
 * Created on July 3, 2005, 3:17 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */


package prac;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author root
 */
public class Node {
    
    /** Creates a new instance of Node */
    private int x;
    private int y;
    private String IpAddress=new String();//IP addresses of the wireless interfaces
    private String controlIpAddress=new String();//IP address of the ethernet interface (eth 0)
    private Image img;
    private javax.swing.JTextArea jTextArea;//A node has a jTextArea to show the result of the shell scripts.
    private javax.swing.JScrollPane jScrollPane; //A Node has a Scroll Pane on which the text area sits
    private String nextHops;//IP addresses of the next hops (wireless interfaces
    private String output;//the output of shell commands for this node
    private boolean connected;
    public Node() {
       this.nextHops="\0";
        connected=false;
        this.jTextArea=new JTextArea();
        this.jTextArea.setBackground(Color.white);
        this.jTextArea.setForeground(Color.red);
        this.jTextArea.setEditable(false);
        this.jScrollPane=new JScrollPane();
        this.jScrollPane.setViewportView(this.jTextArea);
        img=Toolkit.getDefaultToolkit().getImage("/root/Prac/images/ulman_node.gif");
        connected=false;
    }
    public void setIpAddress(String IP)
    {
        this.IpAddress=IP;
    }
    public String getIpAddress(){
        return this.IpAddress;
    }
    public void setControlIpAddress(String IP)
    {
        this.controlIpAddress=IP;
    }
    public String getControlIpAddress(){
        return this.controlIpAddress;
    }
    public void setX(int X)
    {
        this.x=X;
    }
    public int getX(){
        return this.x;
    }
    public void setY(int Y)
    {
        this.y=Y;
    }
    public int getY()
    {
        return this.y;
    }
    public void setImage(Image pic)
    {
        img=pic;
    }
    public Image getImage(){
        return img;
    }
    public void setJTextArea(JTextArea jTextArea)
    {
        this.jTextArea=jTextArea;
    }
    public JTextArea getJTextArea()
    {
        return this.jTextArea;
    }
   public void setJScrollPane(JScrollPane jScrollPane)
    {
        this.jScrollPane=jScrollPane;
    }
    public JScrollPane getJScrollPane()
    {
        return this.jScrollPane;
    }
    public void setOutput(String str)
    {
        this.output+=str;
    }
    public String getOutPut(){
        return this.output;
    }
}
