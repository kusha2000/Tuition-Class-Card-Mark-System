package card_mark_system;;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.mysql.jdbc.MysqlDataTruncation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
import javax.sound.sampled.*;
import javax.swing.JFrame;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.mysql.jdbc.MysqlDataTruncation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;
import javax.sound.sampled.*;

public class Menu extends javax.swing.JFrame implements Runnable, ThreadFactory {

    String a;
    String paidyear;
    String paidmonth;
    String paiddate;
    String paidtime;
    String classdate;
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
    
    
    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public Menu() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initWebcam();
        conn = databaseconnection.connection();
        date1();
        time();
        classdate();
    }
     public void date1(){
        String txtdate=new SimpleDateFormat("dd/MM/YYYY",Locale.ENGLISH).format(new Date());
        paidyear=new SimpleDateFormat("YYYY",Locale.ENGLISH).format(new Date());
        paidmonth=new SimpleDateFormat("MM",Locale.ENGLISH).format(new Date());
        paiddate=new SimpleDateFormat("dd/MM/YYYY",Locale.ENGLISH).format(new Date());
        classdate=new SimpleDateFormat("dd/MM/YYYY",Locale.ENGLISH).format(new Date());
        date.setText(txtdate);
        
    }
    public void time(){
        new Timer(0,new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
              java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
              String texte_date = sdf.format(new Date());
              paidtime = sdf.format(new Date());
              time.setText(texte_date);
            }
        }).start();
    }
    public void classdate(){
        try{
            stmt=conn.createStatement();
            
            String sql="INSERT INTO date(classDate) VALUES('"+classdate+"')";
            stmt.executeUpdate(sql);
            
        }catch(Exception e){
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtage = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtschool = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtstream = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txttel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtftel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtfemail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtdistrict = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        result_field = new javax.swing.JTextField();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtpaid = new javax.swing.JLabel();
        btnpaid = new javax.swing.JButton();
        btnexit1 = new javax.swing.JButton();
        testyear = new javax.swing.JLabel();
        testmonth = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(126, 167, 206));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 590, 10));

        jLabel1.setForeground(new java.awt.Color(105, 105, 105));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 590, 340));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)), "Show Student Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Full Name");

        txtname.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Age");

        txtage.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("School");

        txtschool.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stream");

        txtstream.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mobile Number");

        txttel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Your Email");

        txtemail.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Father's Mobile");

        txtftel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Father's Email");

        txtfemail.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("District");

        txtdistrict.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ID");

        txtid.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(153, 0, 153));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("NIC");

        result_field.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        result_field.setBorder(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(result_field, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel11)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(result_field)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtemail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtschool, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtstream, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(104, 104, 104))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfemail, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtftel, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(txtschool, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtstream, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtftel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfemail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(28, 28, 28))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 720, 760));

        time.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 210, 30));

        date.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 240, 30));

        jPanel5.setBackground(new java.awt.Color(255, 102, 0));

        txtpaid.setBackground(new java.awt.Color(255, 255, 255));
        txtpaid.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        txtpaid.setForeground(new java.awt.Color(51, 0, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(txtpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 320, 110));

        btnpaid.setBackground(new java.awt.Color(102, 255, 102));
        btnpaid.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnpaid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sign-check-icon.png"))); // NOI18N
        btnpaid.setText("Pay");
        btnpaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpaidActionPerformed(evt);
            }
        });
        jPanel1.add(btnpaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 530, 160, 70));

        btnexit1.setBackground(new java.awt.Color(255, 102, 102));
        btnexit1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnexit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel1.png"))); // NOI18N
        btnexit1.setText("Exit");
        btnexit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexit1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnexit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 710, 120, 60));
        jPanel1.add(testyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 160, 30));
        jPanel1.add(testmonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1580, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void btnexit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexit1ActionPerformed
        webcam.close();
        Main m=new Main();
        m.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnexit1ActionPerformed

    private void btnpaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpaidActionPerformed
         //to paid the fees
        /*String txtYear=(String) txtyear.getSelectedItem();
        String txtMonth=(String) txtmonth.getSelectedItem();
        String txtWeek=(String) txtweek.getSelectedItem();*/
        String NIC=result_field.getText();
        String paid="Paid";
        
        try{
            
            if(!NIC.isEmpty()){
                //JOptionPane.showMessageDialog(null,"Null");
                stmt=conn.createStatement();
                String sql="INSERT INTO paid(stdNIC,stdPaidYear,stdPaidMonth,stdPaidDate,stdPaidTime,stdPaid) VALUES('"+NIC+"','"+paidyear+"','"+paidmonth+"','"+paiddate+"','"+paidtime+"','"+paid+"')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Paid Sussfully");
            }
            
            
        }catch(Exception e){
                 //JOptionPane.showMessageDialog(null,e);
                JOptionPane.showMessageDialog(null,"You already paid to this month");
        }
         //To fill paid text area
               try{
                stmt=conn.createStatement();
                String sql="SELECT * FROM paid WHERE  stdNIC='"+NIC+"' ";
                rs=stmt.executeQuery(sql);
                if(rs.next()){
                    txtpaid.setText(rs.getString("stdPaid"));
                }
                }catch(Exception e){ 
                    JOptionPane.showMessageDialog(null,"Error");
                } 
    }//GEN-LAST:event_btnpaidActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexit1;
    private javax.swing.JButton btnpaid;
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField result_field;
    private javax.swing.JLabel testmonth;
    private javax.swing.JLabel testyear;
    private javax.swing.JLabel time;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtdistrict;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfemail;
    private javax.swing.JTextField txtftel;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JLabel txtpaid;
    private javax.swing.JTextField txtschool;
    private javax.swing.JTextField txtstream;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));

        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                
                
            }

            if (result != null) {
                a=result.getText();
                result_field.setText(result.getText());
                txtpaid.setText("");
                //To auto fill other columns of students details
               try{
                stmt=conn.createStatement();
            

                String sql="SELECT * FROM student WHERE  stdNIC='"+a+"' ";
                rs=stmt.executeQuery(sql);
                if(rs.next()){
                    txtid.setText(rs.getString("stdID"));
                    txtname.setText(rs.getString("stdName"));
                    txtage.setText(rs.getString("stdAge"));
                    txtschool.setText(rs.getString("stdSchool"));
                    txtstream.setText(rs.getString("stdStream"));
                    txttel.setText(rs.getString("stdTel"));
                    txtemail.setText(rs.getString("stdEmail"));
                    txtftel.setText(rs.getString("stdFTel"));
                    txtfemail.setText(rs.getString("stdFEmail"));
                    txtdistrict.setText(rs.getString("stdDistrict"));
                    
                

            }else{
                txtid.setText("");
                txtname.setText("");
                txtage.setText("");
                txtschool.setText("");
                txtstream.setText("");
                txttel.setText("");
                txtemail.setText("");
                txtftel.setText("");
                txtfemail.setText("");
                txtdistrict.setText("");
                result_field.setText("");
                playMusic("Other Files\\longbeep.wav");
                JOptionPane.showMessageDialog(null,"Please Scan Correct QR Code");
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        //To fill paid text area
               try{
                stmt=conn.createStatement();
                String sql="SELECT * FROM paid WHERE  ((stdNIC='"+a+"')&(stdPaidYear='"+paidyear+"')&(stdPaidMonth='"+paidmonth+"')) ";
                rs=stmt.executeQuery(sql);
                if(rs.next()){
                    txtpaid.setText(rs.getString("stdPaid"));
                }else{
                    txtpaid.setText("Not Paid");
                }
                }catch(Exception e){ 
                    
                    JOptionPane.showMessageDialog(null,"Error");
                } 
               //to scan the time
        String txtDate=date.getText();
        String txtTime=time.getText();
        String NIC=result_field.getText();
        try{
            
            if(!NIC.isEmpty()){
                stmt=conn.createStatement();  
                String sql="INSERT INTO time(stdNIC,stdDate,stdATime) VALUES('"+NIC+"','"+txtDate+"','"+txtTime+"')";
                stmt.executeUpdate(sql);
                playMusic("Other Files\\shortbeep.wav");
                TimeUnit.SECONDS.sleep(2);
            }
            
            
          
            
        }catch(MysqlDataTruncation e){
            
        }catch(Exception e){
            playMusic("Other Files\\longbeep.wav");
            JOptionPane.showMessageDialog(null,"You Enterd to the class before");
            
        }
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
    //To add a sound
//    public static void playMusic(String filepath){
//        InputStream music;
//        try{
//            music = new FileInputStream(new File(filepath));
//            AudioStream audios =new AudioStream(music);
//            AudioPlayer.player.start(audios);
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null,"Error");
//            
//        }
//    }
    public static void playMusic(String filepath) {
        try {
            // Load the audio file using the provided filepath
            //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Menu.class.getResource(filepath));
            File audioFile = new File(filepath);
            
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile); 
            
            // Play the audio
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            
            // Wait for the audio to finish playing
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}


