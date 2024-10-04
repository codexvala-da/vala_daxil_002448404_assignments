/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.DirectoryManager;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import model.Person;
import model.PersonDirectory;

/**
 *
 * @author apple
 */
public class DirectoryPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    PersonDirectory personDirectory;

    /**
     * Creates new form DirectoryPanel
     */
    public DirectoryPanel(JPanel usrPrcsCntnr, PersonDirectory drtcy) {
        initComponents();
        userProcessContainer = usrPrcsCntnr;
        personDirectory = drtcy;
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonDirectory = new javax.swing.JTable();
        lblHeading = new javax.swing.JLabel();
        txtViewDetails = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnDeleteAccount1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 204));

        tblPersonDirectory.setBackground(new java.awt.Color(0, 0, 0));
        tblPersonDirectory.setForeground(new java.awt.Color(255, 204, 0));
        tblPersonDirectory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "City (Home address)", "Zipcode (Home address)", "City (Work address)", "Zipcode (Work address)"
            }
        ));
        jScrollPane1.setViewportView(tblPersonDirectory);

        lblHeading.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblHeading.setText("Directory");

        txtViewDetails.setText("View Details");
        txtViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewDetailsActionPerformed(evt);
            }
        });

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnDeleteAccount1.setText("Delete account");
        btnDeleteAccount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAccount1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(lblHeading))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtViewDetails)))
                .addGap(337, 337, 337))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDeleteAccount1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblHeading))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtViewDetails)
                .addGap(34, 34, 34)
                .addComponent(btnDeleteAccount1)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewDetailsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPersonDirectory.getSelectedRow();
        
        if (selectedRow>=0){
            Person selectedAccount = (Person) tblPersonDirectory.getValueAt(selectedRow, 0);
            
            ViewPanel viewPanel = new ViewPanel(userProcessContainer,personDirectory,selectedAccount);
            
            JScrollPane scrollComponent;
            scrollComponent = new JScrollPane(viewPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );

            userProcessContainer.add("ViewAccountJPanel",scrollComponent);
        
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else{
            JOptionPane.showMessageDialog(this, "Please select an entry first", "No selection made", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_txtViewDetailsActionPerformed

    private void btnDeleteAccount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAccount1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPersonDirectory.getSelectedRow();
        
        if (selectedRow>=0){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?", "Warning", JOptionPane.WARNING_MESSAGE);
            Person selectedPerson = (Person) tblPersonDirectory.getValueAt(selectedRow, 0);
            personDirectory.deletePerson(selectedPerson);
            populateTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Please select an account first", "No selection made", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteAccount1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteAccount1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JTable tblPersonDirectory;
    private javax.swing.JButton txtViewDetails;
    // End of variables declaration//GEN-END:variables

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblPersonDirectory.getModel();
        model.setRowCount(0);
        for(Person p : personDirectory.getPeople()){
            Object[]row = new Object[6];
            
            row[0]=p;
            row[1]=p.getLastName();
            row[2]=p.getHomeAddress().getCity();
            row[3]=p.getHomeAddress().getZipcode();
            row[4]=p.getWorkAddress().getCity();
            row[5]=p.getWorkAddress().getZipcode();
            
            model.addRow(row);
        }
    }
}
