package prac;

import java.io.*;
import java.net.*;
import com.jscape.inet.ssh.*;
import com.jscape.inet.ssh.util.SshParameters;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.SwingUtilities;

class TopologyPanel extends JPanel{
    private FontMetrics fontMetrics;
    final static int minFontSize = 6;
    final static int maxCharHeight = 30;
    final static BasicStroke wideStroke = new BasicStroke(8.0f);
    public TopologyPanel()
    {
        super();
 //       this.setOpaque(true);
        this.setBackground(Color.white);
        this.setVisible(true);
        this.setLayout(new GridLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
    }
    public FontMetrics pickFont(Graphics2D g2,
                         String longString,
                         int xSpace) {
        boolean fontFits = false;
        Font font = g2.getFont();
        FontMetrics fontMetrics = g2.getFontMetrics();
        int size = font.getSize();
        String name = font.getName();
        int style = font.getStyle();

        while ( !fontFits ) {
            if ( (fontMetrics.getHeight() <= maxCharHeight)
                 && (fontMetrics.stringWidth(longString) <= xSpace) ) {
                fontFits = true;
            }
            else {
                if ( size <= minFontSize ) {
                    fontFits = true;
                }
                else {
                    g2.setFont(font = new Font(name,
                                               style,
                                               --size));
                    fontMetrics = g2.getFontMetrics();
                }
            }
        }

        return fontMetrics;
    }
/*   public void Paint(Node [] topologyNodes){
//        Graphics g;
//        super.paintComponent(g);
//         Graphics g = this.jPanel19.getGraphics();
//         this.jPanel19.paintComponents(g);
               Graphics2D g2 = (Graphics2D) g;
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         Color fg3D = Color.lightGray;
         Dimension d = this.getSize();
         int gridWidth = d.width / 6;
         int gridHeight = d.height / 2;
          fontMetrics = pickFont(g2, "Filled and Stroked GeneralPath",
                               gridWidth);
        try
        {
              BufferedReader ifile = 
              new BufferedReader(new FileReader("/root/Prac/resources/aodv_routes.txt")); 
                   try
                   {
                        String  line;
                        int k=0,temp;
                         while((line = ifile.readLine()) != null&& k==0)
                         {
                             String tokens[]=line.split(" ");
                             for(int i=0;i<topologyNodes.length;i++)
                             {
                                 if(tokens[0].compareTo(topologyNodes[i].getIpAddress())==0)
                                 {
                                    for(int j=0;j<topologyNodes.length;j++)
                                    {
                                        if(tokens[1].compareTo(topologyNodes[j].getIpAddress())==0)
                                        {
                                            g2.drawLine(topologyNodes[i].getX()+20, topologyNodes[i].getY()+20, topologyNodes[j].getX()+20, topologyNodes[j].getY()+20);
                                        }
                                    }
                                 }
                             }
         //                    i++;
                          }
                       
                     }
                    catch(IOException ioex)
                     {
                         //this.jTextArea1.append("IO exception"+ioex.getMessage());
                     }
              try{
              ifile.close();
              }
              catch(IOException ioex)
              {
                      //   this.jTextArea1.append("IO exception"+ioex.getMessage());
              }
        }
          catch(FileNotFoundException fnf)
          {
                     //   this.jTextArea1.append("Couldn't open " + fnf.getMessage());
          }
        for(int i=0;i<9;i++)
        {
            g2.drawImage(topologyNodes[i].getImage(),topologyNodes[i].getX(),topologyNodes[i].getY(),40,40,this);
            g2.drawString(topologyNodes[i].getIpAddress(),topologyNodes[i].getX(),topologyNodes[i].getY()+50);
        }
}*/
}
