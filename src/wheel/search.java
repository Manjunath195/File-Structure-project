/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheel;
import static wheel.Wheel.countno;
import static wheel.Wheel.recs;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abhi
 */
public class search extends javax.swing.JFrame {
    /**
     * Creates new form search
     */
    public search() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idsearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Event");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(580, 150, 240, 50);

        jLabel2.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jLabel2.setText("Enter the Event ID:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(570, 210, 170, 17);

        idsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idsearchActionPerformed(evt);
            }
        });
        getContentPane().add(idsearch);
        idsearch.setBounds(700, 210, 124, 22);

        jButton1.setFont(new java.awt.Font("Palatino Linotype", 3, 12)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(730, 260, 90, 24);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 0, 0);

        jButton2.setFont(new java.awt.Font("Palatino Linotype", 3, 12)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(590, 260, 80, 24);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(112, 147, 0, 0);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(650, 330, 122, 23);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wheel/p12.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1520, 1040);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cust_name,vehicle_name,dest,amount,no_days,id;
        String[] nodes=new String[100];
        btree b = new btree();
        int key=1,no,rkey;
        try{
        no=countno();
        System.out.println("No. of records: "+no+"\n");
        for(int i=0;i<=no;i++)
        recs[i]=new records();
         BufferedReader f3 = new BufferedReader(new FileReader("C:\\Users\\Manjunath\\Documents\\NetBeansProjects\\project\\det.txt"));
            for(int i=0;i<=no;i++)
            {
            String lineRead=f3.readLine();
            String [] st = lineRead.split("\\|");
            recs[i].id=st[0];
            recs[i].cust_name=st[1];
            recs[i].vehicle_name=st[2];
            recs[i].dest=st[3];
            recs[i].amount=st[4];
            //recs[i].no_days=st[5];
            rkey=Integer.valueOf(recs[i].id);
            b.insert(rkey);
            }
        f3.close();

            key=Integer.valueOf(idsearch.getText());
            b.search(key);
            f3=new BufferedReader(new FileReader("C:\\Users\\Manjunath\\Documents\\NetBeansProjects\\project\\det.txt"));
            for(int i=0;i<=no;i++)
            {
            String lineRead=f3.readLine();
            String [] t=lineRead.split("\\|");
            recs[i].id=t[0];
            recs[i].cust_name=t[1];
            recs[i].vehicle_name=t[2];
            recs[i].dest=t[3];
            recs[i].amount=t[4];
            //recs[i].no_days=t[5];
            rkey=Integer.valueOf(recs[i].id);

if(key==rkey)
{
new searchresult(key,recs[i].cust_name,recs[i].vehicle_name,recs[i].dest,recs[i].amount).setVisible(true);
this.setVisible(false);
}
else
    jLabel4.setText("Order not found!");
}
            
f3.close();
} catch (IOException ex) {
            Logger.getLogger(insert.class.getName()).log(Level.SEVERE, null, ex);
        }                         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //new home().setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void idsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idsearchActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        records recs[] = new records[100];
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idsearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
