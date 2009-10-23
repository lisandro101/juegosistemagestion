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
import juegosistemagestion.entidades.Colonia;
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
    private List<Colonia> colonias;
    private Mochila mochilaGlobal;

    public PantallaPrincipal() {
        initComponents();
        inicializar();
    }

    private void inicializar() {
        tModel = new MochilaTableModel(0);
        jXTResultado.setModel(tModel);
        mochilaGlobal = new Mochila();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpParametros = new javax.swing.JPanel();
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
        jpResultados = new org.jdesktop.swingx.JXPanel();
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
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        btGenerarObjetos = new javax.swing.JButton();
        jXPanel6 = new org.jdesktop.swingx.JXPanel();
        tfVolumenOcupadoUsuario = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfBeneficioObUsuario = new javax.swing.JTextField();
        jxPArchivos = new org.jdesktop.swingx.JXPanel();
        btCalcularFBruta = new javax.swing.JButton();
        btCalcHormiga = new javax.swing.JButton();
        btError = new javax.swing.JButton();
        btCargar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Juego");

        jpParametros.setBorder(javax.swing.BorderFactory.createTitledBorder("Parametros"));

        lbCapacidad.setText("Capacidad de la Mochila:");

        tfCapacidad.setText("100");

        jLabel1.setText("Cantidad de Objetos:");

        tfCantObjetos.setText("10");
        tfCantObjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCantObjetosActionPerformed(evt);
            }
        });

        lbBeneficio.setText("Beneficio Objetos:");

        tfBeneficioInferior.setText("2");

        tfBeneficioSuperior.setText("10");

        jLabel3.setText(" -");

        tfVolumenSuperior.setText("30");

        jLabel4.setText(" -");

        tfVolumenInferior.setText("10");

        lbVolumen.setText("Volumen Objetos:");

        javax.swing.GroupLayout jpParametrosLayout = new javax.swing.GroupLayout(jpParametros);
        jpParametros.setLayout(jpParametrosLayout);
        jpParametrosLayout.setHorizontalGroup(
            jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpParametrosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpParametrosLayout.createSequentialGroup()
                        .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCapacidad)
                            .addComponent(jLabel1)
                            .addComponent(lbBeneficio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfCapacidad)
                            .addComponent(tfCantObjetos)
                            .addComponent(tfVolumenInferior, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(tfBeneficioInferior, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpParametrosLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfVolumenSuperior))
                            .addGroup(jpParametrosLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfBeneficioSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lbVolumen))
                .addContainerGap(429, Short.MAX_VALUE))
        );
        jpParametrosLayout.setVerticalGroup(
            jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpParametrosLayout.createSequentialGroup()
                .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCapacidad)
                    .addComponent(tfCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCantObjetos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBeneficio)
                    .addComponent(tfBeneficioSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfBeneficioInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbVolumen)
                    .addComponent(jLabel4)
                    .addComponent(tfVolumenInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfVolumenSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpResultados.setBorder(javax.swing.BorderFactory.createTitledBorder("Objetos"));

        jXTResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Objeto", "Beneficio", "Volumen", "F.Bruta", "C.Hormiga", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTResultado.setColumnSelectionAllowed(true);
        jXTResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTResultadoMouseReleased(evt);
            }
        });
        jXTResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jXTResultadoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jXTResultado);
        jXTResultado.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Fuerza Bruta"));

        jLabel2.setText("Volumen Ocupado:");

        jLabel5.setText("Beneficio Obtenido:");

        tfVolumenOcupadoFBruta.setEditable(false);
        tfVolumenOcupadoFBruta.setText("0.0");

        tfBeneficioObFBruta.setEditable(false);
        tfBeneficioObFBruta.setText("0.0");
        tfBeneficioObFBruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBeneficioObFBrutaActionPerformed(evt);
            }
        });

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
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfVolumenOcupadoFBruta)
                    .addComponent(tfBeneficioObFBruta, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addContainerGap())
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Colonia de Homigas"));

        tfVolumenOcupadoCHormigas.setEditable(false);
        tfVolumenOcupadoCHormigas.setText("0.0");

        jLabel6.setText("Volumen Ocupado:");

        jLabel7.setText("Beneficio Obtenido:");

        tfBeneficioObCHormigas.setEditable(false);
        tfBeneficioObCHormigas.setText("0.0");

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
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfBeneficioObCHormigas)
                    .addComponent(tfVolumenOcupadoCHormigas, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btGenerarObjetos.setText("Generar Objetos");
        btGenerarObjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenerarObjetosActionPerformed(evt);
            }
        });
        jXPanel1.add(btGenerarObjetos);

        jXPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));

        tfVolumenOcupadoUsuario.setEditable(false);
        tfVolumenOcupadoUsuario.setText("0.0");

        jLabel12.setText("Volumen Ocupado:");

        jLabel13.setText("Beneficio Obtenido:");

        tfBeneficioObUsuario.setEditable(false);
        tfBeneficioObUsuario.setText("0.0");

        javax.swing.GroupLayout jXPanel6Layout = new javax.swing.GroupLayout(jXPanel6);
        jXPanel6.setLayout(jXPanel6Layout);
        jXPanel6Layout.setHorizontalGroup(
            jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfBeneficioObUsuario)
                    .addComponent(tfVolumenOcupadoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXPanel6Layout.setVerticalGroup(
            jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfVolumenOcupadoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jXPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfBeneficioObUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpResultadosLayout = new javax.swing.GroupLayout(jpResultados);
        jpResultados.setLayout(jpResultadosLayout);
        jpResultadosLayout.setHorizontalGroup(
            jpResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addGroup(jpResultadosLayout.createSequentialGroup()
                        .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpResultadosLayout.setVerticalGroup(
            jpResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpResultadosLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btCalcularFBruta.setText("Calcular F.Bruta");
        btCalcularFBruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularFBrutaActionPerformed(evt);
            }
        });
        jxPArchivos.add(btCalcularFBruta);

        btCalcHormiga.setText("Calcular C.Hormigas");
        btCalcHormiga.setActionCommand("btCalcHorm");
        btCalcHormiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcHormigaActionPerformed(evt);
            }
        });
        jxPArchivos.add(btCalcHormiga);

        btError.setText("Error");
        btError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btErrorActionPerformed(evt);
            }
        });
        jxPArchivos.add(btError);

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
                    .addComponent(jxPArchivos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addComponent(jpParametros, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpResultados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpParametros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jxPArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCalcularFBrutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularFBrutaActionPerformed

//        double capacidadMochila;
//        Mochila mochila;
//
////        if (!isCamposNumericosValidos(this)) {
////            JOptionPane.showMessageDialog(this,
////                    "Existen campos sin completar o invalidos");
////        } else {
//        if (!isIntervalosValidos()) {
//            JOptionPane.showMessageDialog(this, "Intervalos incorrectos");
//        } else {
//
//            capacidadMochila = Double.parseDouble(tfCapacidad.getText());
//
//            //aca hace el calculo (llamando a un metodo del paquete logica) y luego carga la tabla
//
//            //tModel.limpiarTableModel();
//            mochila = new Mochila();
//            mochila.setObjetos(tModel.getFilas());
//            mochila.setCapacidad(capacidadMochila);
//

        if (mochilaGlobal != null) {

            Mochila mochi=GestorMochila.getInstancia().calcularPorFuerzaBrutaBinaria(mochilaGlobal);
            
            tModel.limpiarTableModel();
            tModel.agregarFilas(mochi.getObjetos());

            tfVolumenOcupadoFBruta.setText(String.valueOf(mochi.getVolumenOcupadoFBruta()));
            tfBeneficioObFBruta.setText(String.valueOf(mochi.getBeneficioObtenidoFBruta()));

        }
           
            //Mochila mochi = GestorMochila.getInstancia().calcularPorFuerzaBruta(mochilaGlobal);



            //GestorMochila.getInstancia().calcularPorHormiga(mochilaGlobal);

//        }
//        }
}//GEN-LAST:event_btCalcularFBrutaActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        salir();
    }//GEN-LAST:event_btSalirActionPerformed

    private void btCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarActionPerformed
        
        MochilaTableModel mtb = (MochilaTableModel) jXTResultado.getModel();

        Mochila mochila = GestorPersistencia.getInstancia().cargarMochila();
        
        tfCapacidad.setText("" + mochila.getCapacidad());
        mtb.limpiarTableModel();
        mtb.agregarFilas(mochila.getObjetos());
        tfCantObjetos.setText("" + mochila.getObjetos().size());

        mochilaGlobal = mochila;

    }//GEN-LAST:event_btCargarActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed

        MochilaTableModel mtb = (MochilaTableModel) jXTResultado.getModel();
        double capacidad = Double.parseDouble(tfCapacidad.getText());

        GestorPersistencia.getInstancia().guardarMochila(capacidad,
                mtb.getFilas());

    }//GEN-LAST:event_btGuardarActionPerformed

    private void btErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btErrorActionPerformed
    PanelError panel = new PanelError();
    panel.setVisible(true);

}//GEN-LAST:event_btErrorActionPerformed

    private void btGenerarObjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGenerarObjetosActionPerformed
        double beneMin;
        double beneMax;
        double volMin;
        double volMax;
        int cantObj;

        if (!isCamposNumericosValidos(jpParametros)) {
            JOptionPane.showMessageDialog(this,
                    "Existen campos sin completar o invalidos");
        } else {
            if (!isIntervalosValidos()) {
                JOptionPane.showMessageDialog(this, "Intervalos incorrectos");
            } else {

                beneMin = Double.parseDouble(tfBeneficioInferior.getText());
                beneMax = Double.parseDouble(tfBeneficioSuperior.getText());
                volMin = Double.parseDouble(tfVolumenInferior.getText());
                volMax = Double.parseDouble(tfVolumenSuperior.getText());
                cantObj = Integer.parseInt(tfCantObjetos.getText());

                mochilaGlobal.setCapacidad(Double.parseDouble(tfCapacidad.getText()));
                mochilaGlobal.setObjetos(GestorMochila.getInstancia().generarObjetos(
                        beneMin,
                        beneMax, volMin, volMax, cantObj));

                tModel.limpiarTableModel();
                tModel.agregarFilas(mochilaGlobal.getObjetos());
            }
        }
    }//GEN-LAST:event_btGenerarObjetosActionPerformed

        private void tfBeneficioObFBrutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBeneficioObFBrutaActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_tfBeneficioObFBrutaActionPerformed

        private void tfCantObjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCantObjetosActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_tfCantObjetosActionPerformed

        private void jXTResultadoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTResultadoMouseReleased
            mochilaGlobal.setObjetos(tModel.getFilas());
            calcularEntradasUsuario(mochilaGlobal);
            
        }//GEN-LAST:event_jXTResultadoMouseReleased

        private void jXTResultadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXTResultadoKeyReleased
            mochilaGlobal.setObjetos(tModel.getFilas());
            calcularEntradasUsuario(mochilaGlobal);
        }//GEN-LAST:event_jXTResultadoKeyReleased

        private void btCalcHormigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcHormigaActionPerformed
    if(mochilaGlobal != null){
            Mochila mochi=GestorMochila.getInstancia(). calcularPorFuerzaBruta(mochilaGlobal);

            tModel.limpiarTableModel();
            tModel.agregarFilas(mochi.getObjetos());

            tfVolumenOcupadoCHormigas.setText(String.valueOf(mochi.getVolumenOcupadoCHormiga()));
            tfBeneficioObCHormigas.setText(String.valueOf(mochi.getBeneficioObtenidoCHormiga()));
    }
}//GEN-LAST:event_btCalcHormigaActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCalcHormiga;
    private javax.swing.JButton btCalcularFBruta;
    private javax.swing.JButton btCargar;
    private javax.swing.JButton btError;
    private javax.swing.JButton btGenerarObjetos;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXPanel jXPanel6;
    private org.jdesktop.swingx.JXTable jXTResultado;
    private javax.swing.JPanel jpParametros;
    private org.jdesktop.swingx.JXPanel jpResultados;
    private org.jdesktop.swingx.JXPanel jxPArchivos;
    private javax.swing.JLabel lbBeneficio;
    private javax.swing.JLabel lbCapacidad;
    private javax.swing.JLabel lbVolumen;
    private javax.swing.JTextField tfBeneficioInferior;
    private javax.swing.JTextField tfBeneficioObCHormigas;
    private javax.swing.JTextField tfBeneficioObFBruta;
    private javax.swing.JTextField tfBeneficioObUsuario;
    private javax.swing.JTextField tfBeneficioSuperior;
    private javax.swing.JTextField tfCantObjetos;
    private javax.swing.JTextField tfCapacidad;
    private javax.swing.JTextField tfVolumenInferior;
    private javax.swing.JTextField tfVolumenOcupadoCHormigas;
    private javax.swing.JTextField tfVolumenOcupadoFBruta;
    private javax.swing.JTextField tfVolumenOcupadoUsuario;
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
                        
                    resultado++;
                }
            } else if (componente instanceof Container) {
                if (!isCamposNumericosValidos((Container) componente)) {
                    resultado++;

                }
            }
        }
        if (resultado == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * El valor cero lo considero como valor positivo
     * @param numero
     * @return
     */
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
            if (!Character.isDigit(valor.charAt(i)) && valor.charAt(i) != '.') {
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

    private void calcularEntradasUsuario(Mochila mochi){
        
        if(!mochi.isVolumenOcupadoUsuarioCorrecto()){
            JOptionPane.showMessageDialog(this, "Los objetos elegidos superan la capacidad de la mochila");
        }

        tfBeneficioObUsuario.setText(String.valueOf(mochi.getBeneficioObtenidoUsuario()));
        tfVolumenOcupadoUsuario.setText(String.valueOf(mochi.getVolumenOcupadoUsuario()));
    }
}
