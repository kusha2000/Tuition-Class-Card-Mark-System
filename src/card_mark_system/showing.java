package card_mark_system;

import static card_mark_system.Menu.playMusic;
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
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.sound.sampled.*;
import javax.swing.JFrame;

public class showing extends javax.swing.JFrame implements Runnable, ThreadFactory {
       
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
    Statement stmt2=null;
    ResultSet rs2=null;
    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public showing() {
        
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initWebcam();
        conn = databaseconnection.connection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        result_field = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        stmonth = new javax.swing.JComboBox<>();
        stpaid = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jijij = new javax.swing.JLabel();
        stpaidtime = new javax.swing.JLabel();
        stpaiddate1 = new javax.swing.JLabel();
        paidsearch = new javax.swing.JButton();
        paidclear = new javax.swing.JButton();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        payBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtage = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtschool = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtstream = new javax.swing.JTextField();
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
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtnic = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        stdpart = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        stpaidtime1 = new javax.swing.JLabel();
        paidsearch1 = new javax.swing.JButton();
        paidclear1 = new javax.swing.JButton();
        btnexit1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(14, 21, 35));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        result_field.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        result_field.setBorder(null);
        result_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                result_fieldKeyPressed(evt);
            }
        });
        jPanel2.add(result_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 110, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 300));

        jPanel4.setBackground(new java.awt.Color(41, 128, 185));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)), "Paiment Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 24), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Year-->");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Month-->");

        stmonth.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stmonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        stpaid.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        stpaid.setForeground(new java.awt.Color(102, 0, 0));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Paid Time-->");

        jijij.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jijij.setForeground(new java.awt.Color(255, 255, 255));
        jijij.setText("Paid Date-->");

        stpaidtime.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        stpaidtime.setForeground(new java.awt.Color(0, 51, 51));

        stpaiddate1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        stpaiddate1.setForeground(new java.awt.Color(0, 51, 51));

        paidsearch.setBackground(new java.awt.Color(102, 153, 255));
        paidsearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        paidsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        paidsearch.setText("Search");
        paidsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidsearchActionPerformed(evt);
            }
        });

        paidclear.setBackground(new java.awt.Color(255, 102, 102));
        paidclear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        paidclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel1.png"))); // NOI18N
        paidclear.setText("Clear");
        paidclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidclearActionPerformed(evt);
            }
        });

        jYearChooser1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        payBtn.setBackground(new java.awt.Color(102, 255, 102));
        payBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        payBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sign-check-icon.png"))); // NOI18N
        payBtn.setText("pay");
        payBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paidsearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jijij)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(stpaidtime, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(payBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(stpaiddate1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(paidclear, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stpaiddate1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jijij, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(stpaidtime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(240, 240, 240))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(paidsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paidclear)
                .addGap(18, 18, 18)
                .addComponent(payBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 620, 210));

        jButton1.setBackground(new java.awt.Color(255, 255, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 120, 60));

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loading (2).png"))); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 120, 50));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)), "Show Student Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Full Name");

        txtname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Age");

        txtage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("School");

        txtschool.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stream");

        txtstream.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txttel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Your Email");

        txtemail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Father's Mobile");

        txtftel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Father's Email");

        txtfemail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("District");

        txtdistrict.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ID");

        txtid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 0, 0));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("NIC");

        txtnic.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtnic.setBorder(null);
        txtnic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnicKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnic, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel11)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtnic)
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Father's Mobile");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Mobile Number");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel7)
                            .addComponent(jLabel19))))
                .addGap(490, 490, 490))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtfemail, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtdistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtschool, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtstream, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(txtftel, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtschool, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtstream, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtftel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtfemail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtdistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 670, 740));

        jPanel5.setBackground(new java.awt.Color(41, 128, 185));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 102, 0)), "Participate Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 24), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Select Date-->");

        stdpart.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        stdpart.setForeground(new java.awt.Color(102, 0, 0));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Arrival Time-->");

        stpaidtime1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        stpaidtime1.setForeground(new java.awt.Color(0, 0, 51));

        paidsearch1.setBackground(new java.awt.Color(102, 153, 255));
        paidsearch1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        paidsearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        paidsearch1.setText("Search");
        paidsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidsearch1ActionPerformed(evt);
            }
        });

        paidclear1.setBackground(new java.awt.Color(255, 102, 102));
        paidclear1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        paidclear1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel1.png"))); // NOI18N
        paidclear1.setText("Clear");
        paidclear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidclear1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stpaidtime1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(stdpart, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(paidclear1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(paidsearch1)))
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paidsearch1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel18))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(stdpart, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paidclear1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stpaidtime1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 620, 200));

        btnexit1.setBackground(new java.awt.Color(255, 102, 102));
        btnexit1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnexit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel1.png"))); // NOI18N
        btnexit1.setText("Exit");
        btnexit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexit1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnexit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 120, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1640, 840));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            stmt=conn.createStatement();
            long stdNIC=Long.parseLong(txtnic.getText());

            String sql="SELECT * FROM student WHERE  stdNIC='"+stdNIC+"' ";
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
                JOptionPane.showMessageDialog(null,"Please enter correct NIC");
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
        txtnic.setText("");
        stdpart.setText("");
        stpaidtime1.setText("");
        stpaid.setText("");
        stpaiddate1.setText("");
        stpaidtime.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void paidsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidsearchActionPerformed
        try{
            stmt=conn.createStatement();

            int txtpaidyear=jYearChooser1.getYear();
            String stdNIC=txtnic.getText();
            String txtpaidmonth=(String) stmonth.getSelectedItem();

            String sql="SELECT * FROM paid WHERE  ((stdNIC='"+stdNIC+"')&(stdPaidYear='"+txtpaidyear+"')&(stdPaidMonth='"+txtpaidmonth+"')) ";
            rs=stmt.executeQuery(sql);
            if(rs.next()){
                stpaid.setText(rs.getString("stdPaid"));
                stpaiddate1.setText(rs.getString("stdPaidDate"));
                stpaidtime.setText(rs.getString("stdPaidTime"));
                

            }else{
                stpaid.setText("Not paid");
                stpaiddate1.setText("No");
                stpaidtime.setText("No");
                //JOptionPane.showMessageDialog(null,"Please enter correct Date");
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_paidsearchActionPerformed

    private void paidclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidclearActionPerformed
                stpaid.setText("");
                stpaiddate1.setText("");
                stpaidtime.setText("");
    }//GEN-LAST:event_paidclearActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void paidsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidsearch1ActionPerformed
try{
//            stmt=conn.createStatement();
//            stmt2=conn.createStatement();
//            long stdNIC=Long.parseLong(txtnic.getText());
//            
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            String startDateString = dateFormat.format(jDateChooser1.getDate());
//            
//            String sql="SELECT * FROM time WHERE  ((stdNIC='"+stdNIC+"')&(stdDate='"+startDateString+"')) ";
//            String sql2="SELECT * FROM date WHERE (classDate='"+startDateString+"')";
//            rs=stmt.executeQuery(sql);
//            rs2=stmt2.executeQuery(sql2);
//            if(rs.next()){
//                stdpart.setText("Participated");
//                stpaidtime1.setText(rs.getString("stdATime"));
//                
//
//            }
////            else if(rs2.next()){
////                stdpart.setText("No Class");
////                stpaidtime1.setText("No");
////                
////            }
//            else{
//                if(rs2.next()){
//                    stdpart.setText("No Class");
//                    stpaidtime1.setText("No");
//                }else{
//                    stdpart.setText("Not Participated");
//                    stpaidtime1.setText("No");
//                }
//                
//            }

long stdNIC = Long.parseLong(txtnic.getText());
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String startDateString = dateFormat.format(jDateChooser1.getDate()); 
    //JOptionPane.showMessageDialog(null,startDateString);
    
    // Create SQL queries
    String sqlCheckParticipation = "SELECT * FROM time WHERE stdNIC = " + stdNIC + " AND stdDate = '" + startDateString + "'";
    String sqlCheckClassDate = "SELECT * FROM date WHERE classDate = '" + startDateString + "'";
    
    // Execute queries
    boolean participated = false;
    boolean classScheduled = false;
    
    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sqlCheckParticipation)) {
        
        if (rs.next()) {
            // Student participated on the specified date
            participated = true;
            stdpart.setText("Participated");
            stpaidtime1.setText(rs.getString("stdATime"));
            rs.close();
        }
    }
    
    try (Statement stmt2 = conn.createStatement();
         ResultSet rs2 = stmt2.executeQuery(sqlCheckClassDate)) {
        
        if (rs2.next()) {
            // Class is scheduled on the specified date
            classScheduled = true;
            rs2.close();
        }
    }
    
    // Determine the status based on query results
    if (participated) {
        // Student participated on the specified date
        // Already set in the first query block
    } else if (classScheduled) {
        // Class is scheduled but student did not participate
        stdpart.setText("Not Participated");
        stpaidtime1.setText("No");
    } else {
        // No participation and no class scheduled
        stdpart.setText("No Class");
        stpaidtime1.setText("No");
    }
//
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"First Enter the NIC or Select the Date");
        }
    }//GEN-LAST:event_paidsearch1ActionPerformed

    private void paidclear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidclear1ActionPerformed
                stdpart.setText("");
                stpaidtime1.setText("");
    }//GEN-LAST:event_paidclear1ActionPerformed

    private void btnexit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexit1ActionPerformed
        webcam.close();
        Main m=new Main();
        m.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnexit1ActionPerformed

    private void txtnicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnicKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                try{
            stmt=conn.createStatement();
            long stdNIC=Long.parseLong(txtnic.getText());

            String sql="SELECT * FROM student WHERE  stdNIC='"+stdNIC+"' ";
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
                JOptionPane.showMessageDialog(null,"Please enter correct NIC");
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Please enter correct NIC");
        }
   }
    }//GEN-LAST:event_txtnicKeyPressed

    private void payBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtnActionPerformed
        // TODO add your handling code here:
        int txtpaidyear=jYearChooser1.getYear();
        String stdNIC=txtnic.getText();
        String txtpaidmonth=(String) stmonth.getSelectedItem();
        String paid="Paid";
        String paiddate=new SimpleDateFormat("dd/MM/YYYY",Locale.ENGLISH).format(new Date());
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
        String paidtime = sdf.format(new Date());
        
        try{
            
            if(!stdNIC.isEmpty()){
                //JOptionPane.showMessageDialog(null,"Null");
                stmt=conn.createStatement();
                String sql="INSERT INTO paid(stdNIC,stdPaidYear,stdPaidMonth,stdPaidDate,stdPaidTime,stdPaid) VALUES('"+stdNIC+"','"+txtpaidyear+"','"+txtpaidmonth+"','"+paiddate+"','"+paidtime+"','"+paid+"')";
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
            String sql="SELECT * FROM paid WHERE  ((stdNIC='"+stdNIC+"')&(stdPaidYear='"+txtpaidyear+"')&(stdPaidMonth='"+txtpaidmonth+"')) ";
            rs=stmt.executeQuery(sql);
            if(rs.next()){
                stpaid.setText(rs.getString("stdPaid"));
                stpaiddate1.setText(rs.getString("stdPaidDate"));
                stpaidtime.setText(rs.getString("stdPaidTime"));
                

            }else{
                stpaid.setText("Not paid");
                stpaiddate1.setText("No");
                stpaidtime.setText("No");
                //JOptionPane.showMessageDialog(null,"Please enter correct Date");
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_payBtnActionPerformed

    private void result_fieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_result_fieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_result_fieldKeyPressed

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
            new showing().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexit1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel jijij;
    private javax.swing.JButton paidclear;
    private javax.swing.JButton paidclear1;
    private javax.swing.JButton paidsearch;
    private javax.swing.JButton paidsearch1;
    private javax.swing.JButton payBtn;
    private javax.swing.JTextField result_field;
    private javax.swing.JLabel stdpart;
    private javax.swing.JComboBox<String> stmonth;
    private javax.swing.JLabel stpaid;
    private javax.swing.JLabel stpaiddate1;
    private javax.swing.JLabel stpaidtime;
    private javax.swing.JLabel stpaidtime1;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtdistrict;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfemail;
    private javax.swing.JTextField txtftel;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnic;
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
                //No result...
            }

            if (result != null) {
                
                result_field.setText(result.getText());
                txtnic.setText(result.getText());
                stpaidtime1.setText("");
                stdpart.setText("");
                stpaid.setText("");
                stpaiddate1.setText("");
                stpaidtime.setText("");
                try{
            stmt=conn.createStatement();
            long stdNIC=Long.parseLong(txtnic.getText());

            String sql="SELECT * FROM student WHERE  stdNIC='"+stdNIC+"' ";
            rs=stmt.executeQuery(sql);
            if(rs.next()){
                playMusic("Other Files\\shortbeep.wav");
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
                TimeUnit.SECONDS.sleep(2);

            }else{
                playMusic("Other Files\\longbeep.wav");
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
        txtnic.setText("");
        stdpart.setText("");
        stpaidtime1.setText("");
        stpaid.setText("");
        stpaiddate1.setText("");
        stpaidtime.setText("");
        
        JOptionPane.showMessageDialog(null,"Please enter correct NIC");
            }

        }catch(Exception e){
            
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
        txtnic.setText("");
        stdpart.setText("");
        stpaidtime1.setText("");
        stpaid.setText("");
        stpaiddate1.setText("");
        stpaidtime.setText("");
        JOptionPane.showMessageDialog(null,"Please enter correct NIC");
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
//        
//    }
    public static void playMusic(String filepath) {
        try {
            // Load the audio file using the provided filepath
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
