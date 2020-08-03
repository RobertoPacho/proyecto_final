/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista.medicina;

import ec.edu.ups.controladores.ControladorMedicina;
import ec.edu.ups.modelo.Medicina;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author rober
 */
public class VentanaCrearMedicina extends javax.swing.JInternalFrame {
    private ControladorMedicina controladorMedicina;
    private Locale localizacion;
    private static ResourceBundle mensajes;
    /**
     * Creates new form VentanaCrearMedicina
     */
    public VentanaCrearMedicina(ControladorMedicina controladorMedicina) {
        initComponents();
        this.controladorMedicina = controladorMedicina;
        txtCodigo.setText(String.valueOf(this.controladorMedicina.getCodigo()));
        
    }
   public static void cambiarIdioma(Locale localizacion) {
        mensajes = ResourceBundle.getBundle("ec.edu.ups.idiomas.mensajes", Locale.getDefault());
        lblMenuCrearP.setText(mensajes.getString("encabezado.crear.medicina"));
        lblcodigo.setText(mensajes.getString("codigo"));
        lblnombre.setText(mensajes.getString("nombre"));
        lblmarca.setText(mensajes.getString("marca"));
        lbldescripcion.setText(mensajes.getString("descripcion"));
        lblprecio.setText(mensajes.getString("precio"));
        lblguardar.setText(mensajes.getString("guardar"));
        lblcancelar.setText(mensajes.getString("cancelar"));
    }
     


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMenuCrearP = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblcodigo = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblprecio = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtnombre1 = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnguardar1 = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        lblguardar = new javax.swing.JLabel();
        lblcancelar = new javax.swing.JLabel();
        lblmarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lbldescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setMaximizable(true);

        lblMenuCrearP.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblMenuCrearP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuCrearP.setText("CREAR MEDICINA");
        lblMenuCrearP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setToolTipText("");

        lblcodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblcodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcodigo.setText("CÓDIGO");
        lblcodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblnombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblnombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombre.setText("NOMBRE");
        lblnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblprecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblprecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblprecio.setText("PRECIO");
        lblprecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setEnabled(false);

        txtnombre1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtnombre1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnguardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/guardar.png"))); // NOI18N
        btnguardar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnguardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar1ActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/cancelar.png"))); // NOI18N
        btncancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        lblguardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblguardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblguardar.setText("GUARDAR");
        lblguardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblcancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblcancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcancelar.setText("CANCELAR");
        lblcancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblmarca.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblmarca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblmarca.setText("MARCA");
        lblmarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtMarca.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtMarca.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbldescripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbldescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldescripcion.setText("DESCRIPCIÓN");
        lbldescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtDescripcion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescripcion.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnguardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbldescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lblMenuCrearP, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblMenuCrearP, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar1ActionPerformed
        // boton creacion de medicina
        Medicina crearMedicina = new Medicina();
        crearMedicina.setCodigo(Integer.parseInt(txtCodigo.getText()));
        crearMedicina.setNombre(txtnombre1.getText());
        crearMedicina.setMarca(txtMarca.getText());
        crearMedicina.setDescripcion(txtDescripcion.getText());
        crearMedicina.setPrecio(Double.parseDouble(txtPrecio.getText()));

        controladorMedicina.create(crearMedicina);
        JOptionPane.showMessageDialog(this, "MEDICINA CREADA");
        txtCodigo.setText(String.valueOf(this.controladorMedicina.getCodigo()));
        txtnombre1.setText("");
        txtMarca.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
    }//GEN-LAST:event_btnguardar1ActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // boton cancelar
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar1;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel lblMenuCrearP;
    public static javax.swing.JLabel lblcancelar;
    public static javax.swing.JLabel lblcodigo;
    public static javax.swing.JLabel lbldescripcion;
    public static javax.swing.JLabel lblguardar;
    public static javax.swing.JLabel lblmarca;
    public static javax.swing.JLabel lblnombre;
    public static javax.swing.JLabel lblprecio;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    public static javax.swing.JTextField txtMarca;
    public static javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtnombre1;
    // End of variables declaration//GEN-END:variables
}
