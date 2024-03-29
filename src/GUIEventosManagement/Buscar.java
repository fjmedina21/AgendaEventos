package GUIEventosManagement;

import itla.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Buscar extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private EventosManagement em = new EventosManagement();
    private List<Evento> eventos;

    public Buscar() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    void modelTable() {
        modelo = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo.addColumn("Nombre");
        modelo.addColumn("Detalle");
        modelo.addColumn("Lugar");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora de inicio");
        modelo.addColumn("Hora de fin");
    }

    void searchEventoGUI() {
        modelTable();
        int opt = 0;

        if (buttonNombre.isSelected()) {
            opt = 1;
        }
        if (buttonFecha.isSelected()) {
            opt = 2;
        }
        if (buttonDetalle.isSelected()) {
            opt = 3;
        }

        switch (opt) {
            case 1:
                if (txtBuscar.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese un Nombre");
                } else {
                    eventos = em.searchEventoByNombre(txtBuscar.getText());
                    if (eventos.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "No se encontraron eventos con este nombre");
                    } else {
                        for (Evento e : eventos) {
                            Object[] fila = new Object[6];
                            fila[0] = e.getNombre();
                            fila[1] = e.getDetalle();
                            fila[2] = e.getLugar();
                            fila[3] = e.getFecha();
                            fila[4] = e.getHoraInicio();
                            fila[5] = e.getHoraFin();
                            modelo.addRow(fila);}
                        tableEventos.setModel(modelo);
                    }
                }
                break;
            case 2:
                if (txtBuscar.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese una Fecha");
                } else {
                    eventos = em.searchEventoByFecha(txtBuscar.getText());
                    if (eventos.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "No se encontraron eventos con esta fecha");
                    } else {
                        for (Evento e : eventos) {
                            Object[] fila = new Object[6];
                            fila[0] = e.getNombre();
                            fila[1] = e.getDetalle();
                            fila[2] = e.getFecha();
                            fila[3] = e.getLugar();
                            fila[4] = e.getHoraInicio();
                            fila[5] = e.getHoraFin();
                            modelo.addRow(fila);}
                        tableEventos.setModel(modelo);
                    }
                }
                break;
            case 3:
                if (txtBuscar.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese un texto");
                } else {
                    eventos = em.searchEventoByDetalle(txtBuscar.getText());
                    if (eventos.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "No se encontraron eventos con coincidencias");
                    } else {
                        for (Evento e : eventos) {
                            Object[] fila = new Object[6];
                            fila[0] = e.getNombre();
                            fila[1] = e.getDetalle();
                            fila[2] = e.getFecha();
                            fila[3] = e.getLugar();
                            fila[4] = e.getHoraInicio();
                            fila[5] = e.getHoraFin();
                            modelo.addRow(fila);}
                        tableEventos.setModel(modelo);
                    }
                }
                break;
            default:
                JOptionPane.showMessageDialog(this, "Seleccione un filtro");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupBuscar = new javax.swing.ButtonGroup();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        buttonNombre = new javax.swing.JRadioButton();
        buttonFecha = new javax.swing.JRadioButton();
        buttonDetalle = new javax.swing.JRadioButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEventos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Buscar Eventos");

        groupBuscar.add(buttonNombre);
        buttonNombre.setText("Nombre");

        groupBuscar.add(buttonFecha);
        buttonFecha.setText("Fecha");

        groupBuscar.add(buttonDetalle);
        buttonDetalle.setText("Detalle");

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        tableEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Ddetalle", "Lugar","Fecha","Hora Inicio", "Hora Fin"
            }
        ));
        jScrollPane1.setViewportView(tableEventos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonDetalle)
                .addGap(300, 300, 300))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonNombre)
                    .addComponent(buttonFecha)
                    .addComponent(buttonDetalle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        searchEventoGUI();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JRadioButton buttonDetalle;
    private javax.swing.JRadioButton buttonFecha;
    private javax.swing.JRadioButton buttonNombre;
    private javax.swing.ButtonGroup groupBuscar;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableEventos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
