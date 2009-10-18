/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PantallaPrincipal.java
 *
 * Created on 13/10/2009, 23:31:46
 */
package juegosistemagestion.igu;

import java.awt.Component;
import java.awt.Container;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import juegosistemagestion.entidades.Mochila;
import juegosistemagestion.entidades.Objeto;
import juegosistemagestion.logica.GestorMochila;
import juegosistemagestion.logica.MochilaTableModel;
import juegosistemagestion.persistencia.GestorPersistencia;

/**
 *
 * @author stafoxter
 */
public class PantallaPrincipal extends javax.swing.JDialog {

    private MochilaTableModel tModel;
    private List<Objeto> objetos;

    public PantallaPrincipal() {
        initComponents();
        inicializar();
    }

    private void inicializar() {
        tModel = new MochilaTableModel(0);
        jXTResultado.setModel(tModel);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbCapacidad = new javax.swing.JLabel();
        tfCapacidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfCantObjetos = new javax.swing.JTextField();
        lbBeneficio = new javax.swing.JLabel();
        tfBeneficioInferior = new javax.swing.JTextField();
        tfBeneficioSuperior = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfVolumenSuperior = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfVolumenInferior = new javax.swing.JTextField();
        lbVolumen = new javax.swing.JLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTResultado = new org.jdesktop.swingx.JXTable();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfVolumenOcupadoFBruta = new javax.swing.JTextField();
        tfBeneficioObFBruta = new javax.swing.JTextField();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        tfVolumenOcupadoCHormigas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfBeneficioObCHormigas = new javax.swing.JTextField();
        jxPArchivos = new org.jdesktop.swingx.JXPanel();
        btCalcular = new javax.swing.JButton();
        btCargar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Juego");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parametros"));

        lbCapacidad.setText("Capacidad de la Mochila:");

        tfCapacidad.setText("100");

        jLabel1.setText("Cantidad de Objetos:");

        tfCantObjetos.setText("50");

        lbBeneficio.setText("Beneficio Objetos:");

        tfBeneficioInferior.setText("2");

        tfBeneficioSuperior.setText("10");

        jLabel3.setText(" -");

        tfVolumenSuperior.setText("15");

        jLabel4.setText(" -");

        tfVolumenInferior.setText("10");

        lbVolumen.setText("Volumen Objetos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCapacidad)
                            .addComponent(jLabel1)
                            .addComponent(lbBeneficio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfCapacidad)
                            .addComponent(tfCantObjetos)
                            .addComponent(tfVolumenInferior, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(tfBeneficioInferior, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfVolumenSuperior))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfBeneficioSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lbVolumen))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCapacidad)
                    .addComponent(tfCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCantObjetos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBeneficio)
                    .addComponent(tfBeneficioSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfBeneficioInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbVolumen)
                    .addComponent(jLabel4)
                    .addComponent(tfVolumenInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfVolumenSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));

        jXTResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Objeto", "Beneficio", "Volumen", "En Mochila"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jXTResultado);

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Fuerza Bruta"));

        jLabel2.setText("Volumen Ocupado:");

        jLabel5.setText("Beneficio Obtenido:");

        tfVolumenOcupadoFBruta.setEditable(false);
        tfVolumenOcupadoFBruta.setText("0");

        tfBeneficioObFBruta.setEditable(false);
        tfBeneficioObFBruta.setText("0");

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfVolumenOcupadoFBruta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(tfBeneficioObFBruta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfVolumenOcupadoFBruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfBeneficioObFBruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jXPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Colonia de Homigas"));

        tfVolumenOcupadoCHormigas.setEditable(false);
        tfVolumenOcupadoCHormigas.setText("0");

        jLabel6.setText("Volumen Ocupado:");

        jLabel7.setText("Beneficio Obtenido:");

        tfBeneficioObCHormigas.setEditable(false);
        tfBeneficioObCHormigas.setText("0");

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfVolumenOcupadoCHormigas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(tfBeneficioObCHormigas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfVolumenOcupadoCHormigas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfBeneficioObCHormigas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btCalcular.setText("Calcular");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularActionPerformed(evt);
            }
        });
        jxPArchivos.add(btCalcular);

        btCargar.setText("Cargar");
        btCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarActionPerformed(evt);
            }
        });
        jxPArchivos.add(btCargar);

        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });
        jxPArchivos.add(btGuardar);

        btSalir.setText("   Salir  ");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });
        jxPArchivos.add(btSalir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jxPArchivos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jxPArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularActionPerformed
        double beneMin;
        double beneMax;
        double volMin;
        double volMax;
        int cantObj;
        double capacidadMochila;
        Mochila mochila;

        if (!isCamposNumericosValidos(this)) {
            JOptionPane.showMessageDialog(this, "Existen campos sin completar o invalidos");
        } else {
            if (!isIntervalosValidos()) {
                JOptionPane.showMessageDialog(this, "Intervalos incorrectos");
            } else {

                beneMin = Double.parseDouble(tfBeneficioInferior.getText());
                beneMax = Double.parseDouble(tfBeneficioSuperior.getText());
                volMin = Double.parseDouble(tfVolumenInferior.getText());
                volMax = Double.parseDouble(tfVolumenSuperior.getText());
                cantObj = Integer.parseInt(tfCantObjetos.getText());
                capacidadMochila = Double.parseDouble(tfCapacidad.getText());

                //aca hace el calculo (llamando a un metodo del paquete logica) y luego carga la tabla

                limpiarTabla();
                objetos = GestorMochila.getInstancia().generarObjetos(beneMin, beneMax, volMin, volMax, cantObj);
                mochila = new Mochila();
                mochila.setObjetos(objetos);
                mochila.setCapacidad(capacidadMochila);


                //GestorMochila.getInstancia().inicializarMochila(mochila);
                GestorMochila.getInstancia().calcularPorFuerzaBruta(mochila);

                cargarTabla();


            }
        }
}//GEN-LAST:event_btCalcularActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        salir();
    }//GEN-LAST:event_btSalirActionPerformed

    private void btCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarActionPerformed
        MochilaTableModel mtb = (MochilaTableModel) jXTResultado.getModel();
        Mochila mochila = GestorPersistencia.getInstancia().cargarMochila();
        tfCapacidad.setText("" + mochila.getCapacidad());
//        mtb.limpiarTableModel();
        mtb.agregarFilas(mochila.getObjetos());
        tfCantObjetos.setText(new Integer(mochila.getObjetos().size()).toString());

    }//GEN-LAST:event_btCargarActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        MochilaTableModel mtb = (MochilaTableModel) jXTResultado.getModel();
        Double capacidad = new Double(tfCapacidad.getText());
        GestorPersistencia.getInstancia().guardarMochila(capacidad, mtb.getFilas());
    }//GEN-LAST:event_btGuardarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCalcular;
    private javax.swing.JButton btCargar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXTable jXTResultado;
    private org.jdesktop.swingx.JXPanel jxPArchivos;
    private javax.swing.JLabel lbBeneficio;
    private javax.swing.JLabel lbCapacidad;
    private javax.swing.JLabel lbVolumen;
    private javax.swing.JTextField tfBeneficioInferior;
    private javax.swing.JTextField tfBeneficioObCHormigas;
    private javax.swing.JTextField tfBeneficioObFBruta;
    private javax.swing.JTextField tfBeneficioSuperior;
    private javax.swing.JTextField tfCantObjetos;
    private javax.swing.JTextField tfCapacidad;
    private javax.swing.JTextField tfVolumenInferior;
    private javax.swing.JTextField tfVolumenOcupadoCHormigas;
    private javax.swing.JTextField tfVolumenOcupadoFBruta;
    private javax.swing.JTextField tfVolumenSuperior;
    // End of variables declaration//GEN-END:variables

    private void salir() {
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea salir?", "Salir",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private boolean isCamposNumericosValidos(Container contenedor) {
        int resultado = 0;

        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                if ((((JTextField) componente).getText().trim().length() == 0) ||
                        (!esNumeroPositivo(((JTextField) componente).getText()))) {

                    ++resultado;
                }
            } else if (componente instanceof Container) {
                if (!isCamposNumericosValidos((Container) componente)) {
                    ++resultado;

                }
            }
        }
        if (resultado == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean esPositivo(String numero) {
        double valor = Double.parseDouble(numero);
        if (valor < 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean esNumeroPositivo(String valor) {
        valor = valor.trim();
        boolean resul = true;

        for (int i = 0; i < valor.length(); i++) {
            if (!Character.isDigit(valor.charAt(i))) {
                resul = false;
            }
        }

        if (resul) {
            resul = esPositivo(valor);
        }
        return resul;
    }

    private boolean isIntervalosValidos() {
        boolean resul = true;
        if (Double.parseDouble(tfBeneficioInferior.getText()) >
                Double.parseDouble(tfBeneficioSuperior.getText())) {
            resul = false;
        }

        if (Double.parseDouble(tfVolumenInferior.getText()) >
                Double.parseDouble(tfVolumenSuperior.getText())) {
            resul = false;
        }

        return resul;
    }

    private void limpiarTabla() {
        tModel.limpiarTableModel();
        objetos = null;
    }

    private void cargarTabla() {
        if (objetos != null) {
            for (Objeto objeto : objetos) {
                tModel.agregarFila(objeto);
            }
        }
    }
}