package GUIEventosManagement;

import itla.*;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Del_Upd extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private Object[] fila = {"Id", "Nombre", "Detalle", "Lugar", "Fecha", "Hora de inicio", "Hora de fin", "",""};
    private EventosManagement eventManager = new EventosManagement();
    private List<Evento> eventos;

    public Del_Upd() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelTable();
        showEvento();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEventos = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Eliminar/Modificar Eventos");

        tableEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tableEventos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEventosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEventos);

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(btnCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void clearTable(final JTable table) {
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt("", i, j);
            }
        }
    }

    public static void deleteAllRows(final DefaultTableModel model) {
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void tableEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEventosMouseClicked
        int column = tableEventos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tableEventos.getRowHeight();

        if (row < tableEventos.getRowCount() && row >= 0 && column < tableEventos.getColumnCount() && column >= 0) {
            Object value = tableEventos.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                if (boton.getName().equals("delete")) {
                    int id = (int) modelo.getValueAt(tableEventos.getSelectedRow(), 0);
                    int s = JOptionPane.showConfirmDialog(this, "¿Seguro?", "Si/no", JOptionPane.YES_NO_OPTION);
                    if (s == 0) {
                        eventManager.deleteEvento(id);
                        JOptionPane.showMessageDialog(this, "Evento eliminado");
                        setVisible(false);
                    }
                } else if(boton.getName().equals("update")){
                    int i = (int) modelo.getValueAt(tableEventos.getSelectedRow(), 0);
                    String n = (String) modelo.getValueAt(tableEventos.getSelectedRow(), 1);
                    String d = (String) modelo.getValueAt(tableEventos.getSelectedRow(), 2);
                    String l = (String) modelo.getValueAt(tableEventos.getSelectedRow(), 3);
                    
                    Date date = (Date) modelo.getValueAt(tableEventos.getSelectedRow(), 4);
                    Time hInicio = (Time) modelo.getValueAt(tableEventos.getSelectedRow(), 5);;
                    Time hFinal =  (Time) modelo.getValueAt(tableEventos.getSelectedRow(), 6);
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm"); 
                    
                    String f = dateFormat.format(date);  
                    String hI = timeFormat.format(hInicio);  
                    String hF = timeFormat.format(hFinal);  
                    
                    Modificar u = new Modificar(i,n,d,l,f,hI,hF);
                    setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_tableEventosMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    void modelTable() {
        modelo = new DefaultTableModel(null, this.fila) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                if (columnas == 8) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        modelo.setColumnIdentifiers(this.fila);
        tableEventos.setModel(modelo);
    }

    void showEvento() {
        tableEventos.setDefaultRenderer(Object.class, new Render());
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setName("delete");
        JButton btnModificar = new JButton("Modificar");
        btnModificar.setName("update");

        eventos = eventManager.searchEvento();
        for (Evento e : eventos) {
            fila[0] = e.getIdEvento();
            fila[1] = e.getNombre();
            fila[2] = e.getDetalle();
            fila[3] = e.getLugar();
            fila[4] = e.getFecha();
            fila[5] = e.getHoraInicio();
            fila[6] = e.getHoraFin();
            fila[7] = btnEliminar;
            fila[8]= btnModificar;
            modelo.addRow(fila);
        }
        tableEventos.setModel(modelo);
        tableEventos.setRowHeight(30);
    }

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
            java.util.logging.Logger.getLogger(Del_Upd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Del_Upd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Del_Upd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Del_Upd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Del_Upd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableEventos;
    // End of variables declaration//GEN-END:variables

}
