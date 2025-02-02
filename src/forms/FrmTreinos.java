/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

/**
 *
 * @author gabri
 */
public class FrmTreinos extends javax.swing.JFrame {
    
    /**
     * Creates new form FrmTreinos
     */
    public FrmTreinos() {
        initComponents();
        jl_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/SamukaBombadoDefault.png")));
        loadWorkoutsData();
    }
    
    public void loadWorkoutData(String area) {
        DBController db = new DBController("fitpro.db");
        
        try {
            db.connect();
            ResultSet rset = db.getWorkout(area);
            DefaultTableModel table = new DefaultTableModel(new String[]{"Nome", "Intensidade", "Dificuldade"}, 0);
            
            while(rset.next()){
                table.addRow(new Object[]{rset.getString("name"), rset.getString("intensity"), rset.getString("difficult")});
            }
            
            jt_Workouts.setModel(table);
            
            db.disconnect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void loadWorkoutsData() {
        DBController db = new DBController("fitpro.db");
        
        try {
            db.connect();
            ResultSet rset = db.getWorkouts();
            DefaultTableModel table = new DefaultTableModel(new String[]{"Nome", "Intensidade", "Dificuldade"}, 0);
            
            while(rset.next()){
                table.addRow(new Object[]{rset.getString("name"), rset.getString("intensity"), rset.getString("difficult")});
            }
            
            jt_Workouts.setModel(table);
            
            db.disconnect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jp_Main = new javax.swing.JPanel();
        jsp_WorkoutsList = new javax.swing.JScrollPane();
        jt_Workouts = new javax.swing.JTable();
        jl_Image = new javax.swing.JLabel();
        jb_Return = new javax.swing.JButton();
        jp_Areas = new javax.swing.JPanel();
        jcb_Upper = new javax.swing.JCheckBox();
        jcb_Core = new javax.swing.JCheckBox();
        jcb_Lower = new javax.swing.JCheckBox();
        jb_AddWorkout = new javax.swing.JButton();
        jb_Refresh = new javax.swing.JButton();
        jb_Delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jt_Workouts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Intensidade", "Dificuldade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jsp_WorkoutsList.setViewportView(jt_Workouts);

        jb_Return.setText("Voltar");
        jb_Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ReturnActionPerformed(evt);
            }
        });

        jp_Areas.setBorder(javax.swing.BorderFactory.createTitledBorder("Área de Ativação"));

        buttonGroup1.add(jcb_Upper);
        jcb_Upper.setText("Superiores");
        jcb_Upper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_UpperActionPerformed(evt);
            }
        });

        buttonGroup1.add(jcb_Core);
        jcb_Core.setText("Core");
        jcb_Core.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_CoreActionPerformed(evt);
            }
        });

        buttonGroup1.add(jcb_Lower);
        jcb_Lower.setText("Inferiores");
        jcb_Lower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_LowerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_AreasLayout = new javax.swing.GroupLayout(jp_Areas);
        jp_Areas.setLayout(jp_AreasLayout);
        jp_AreasLayout.setHorizontalGroup(
            jp_AreasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_AreasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_AreasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcb_Upper)
                    .addComponent(jcb_Core)
                    .addComponent(jcb_Lower))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jp_AreasLayout.setVerticalGroup(
            jp_AreasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_AreasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcb_Upper)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcb_Core)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcb_Lower)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jb_AddWorkout.setText("Adicionar Exercício");
        jb_AddWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_AddWorkoutActionPerformed(evt);
            }
        });

        jb_Refresh.setText("Atualizar Tabela");
        jb_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_RefreshActionPerformed(evt);
            }
        });

        jb_Delete.setText("Excluir Exercício");
        jb_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_MainLayout = new javax.swing.GroupLayout(jp_Main);
        jp_Main.setLayout(jp_MainLayout);
        jp_MainLayout.setHorizontalGroup(
            jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_MainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsp_WorkoutsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_Areas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_MainLayout.createSequentialGroup()
                        .addComponent(jb_AddWorkout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_Delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_Refresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jb_Return)))
                .addGap(249, 249, 249))
        );
        jp_MainLayout.setVerticalGroup(
            jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_MainLayout.createSequentialGroup()
                        .addComponent(jsp_WorkoutsList, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_Areas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jl_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_AddWorkout)
                        .addComponent(jb_Delete)
                        .addComponent(jb_Refresh))
                    .addComponent(jb_Return))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_Main, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ReturnActionPerformed
        dispose();
    }//GEN-LAST:event_jb_ReturnActionPerformed

    private void jcb_UpperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_UpperActionPerformed
        jl_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/SamukaBombadoUpper.png")));
        loadWorkoutData("Upper");
    }//GEN-LAST:event_jcb_UpperActionPerformed

    private void jb_AddWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_AddWorkoutActionPerformed
        FrmAddExercicio ft = new FrmAddExercicio();
        ft.setVisible(true);
    }//GEN-LAST:event_jb_AddWorkoutActionPerformed

    private void jcb_CoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_CoreActionPerformed
        jl_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/SamukaBombadoCore.png")));
        loadWorkoutData("Core");
    }//GEN-LAST:event_jcb_CoreActionPerformed

    private void jcb_LowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_LowerActionPerformed
        jl_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/SamukaBombadoLower.png")));
        loadWorkoutData("Lower");
    }//GEN-LAST:event_jcb_LowerActionPerformed

    private void jb_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_RefreshActionPerformed
        if(jcb_Upper.isSelected()){
            loadWorkoutData("Upper");
        }
        if(jcb_Core.isSelected()){
            loadWorkoutData("Core");
        }
        if(jcb_Lower.isSelected()){
            loadWorkoutData("Lower");
        } else {
            loadWorkoutsData();
        }
    }//GEN-LAST:event_jb_RefreshActionPerformed

    private void jb_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_DeleteActionPerformed
        FrmDeleteExercicio ft = new FrmDeleteExercicio();
        ft.setVisible(true);
    }//GEN-LAST:event_jb_DeleteActionPerformed

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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTreinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTreinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTreinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTreinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTreinos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jb_AddWorkout;
    private javax.swing.JButton jb_Delete;
    private javax.swing.JButton jb_Refresh;
    private javax.swing.JButton jb_Return;
    private javax.swing.JCheckBox jcb_Core;
    private javax.swing.JCheckBox jcb_Lower;
    private javax.swing.JCheckBox jcb_Upper;
    private javax.swing.JLabel jl_Image;
    private javax.swing.JPanel jp_Areas;
    private javax.swing.JPanel jp_Main;
    private javax.swing.JScrollPane jsp_WorkoutsList;
    private javax.swing.JTable jt_Workouts;
    // End of variables declaration//GEN-END:variables
}
