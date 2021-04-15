/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kitchenscreen2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heyrin
 */
public class Main extends javax.swing.JFrame {

    final String columnNames[];
    ObjectOutputStream out;

    public KitchenScreen(){
        initComponents();
        serverConnect();
        columnNames=new String[]{"order_group_no","prodname","quantity","ordermethod","orderdate","memberid"};

            
    }
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("새로고침");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("주문/출고 현황", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            // 새로고침 버튼 처리
            out.writeObject("ordersSelect");
            System.out.println("새로고침요청");
        } catch (IOException ex) {
            Logger.getLogger(KitchenScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        

 

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   

    private void serverConnect() {
        try {
            Properties prop=new Properties();
            prop.load(new FileReader("config.properties"));
            String ip=(String) prop.get("server.ip");
            String port=(String) prop.get("server.port");
            System.out.println(ip+":"+port);
            Socket s=new Socket(ip,Integer.parseInt(port));
            out=new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in=new ObjectInputStream(s.getInputStream());
            new Thread(()->{
                while(true){
                    try {
                        List<OrderVO> list=(List<OrderVO>) in.readObject();
                        System.out.println(list);
                        Object [][]data=new Object[list.size()][6];
                        int i=0;
                        for(OrderVO vo:list){
                            System.out.println(i);
                            data[i][0]=vo.getOrder_group_no();
                            System.out.println(data[i][0]);
                            data[i][1]=vo.getProdname();
                            data[i][2]=vo.getQuantity();
                            data[i][3]=vo.getOrdermethod();
                            data[i][4]=vo.getOrderdate();
                            data[i++][5]=vo.getMemberid();                           
                        }
                       // "order_group_no","prodname","quantity","ordermethod","orderdate","memberid"
                        jTable1.setModel(new DefaultTableModel(data, columnNames));
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
            System.out.println("서버 연결 완료");
        } catch (IOException ex) {
            Logger.getLogger(KitchenScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
