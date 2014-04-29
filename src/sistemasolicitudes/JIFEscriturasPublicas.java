/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemasolicitudes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author digitacion-6
 */
public class JIFEscriturasPublicas extends javax.swing.JInternalFrame {
notarios2 nt2 = new notarios2();
    Object[][] datNot;
    int fila =-1;

    int cod,idsol, yearIntro, yearInicio, yearFinal;
    String tipEscr, otor, favor, lugar, year1, otros, not, mes,dia,num_solicitud,ver_solicitud,NumIdSol;
    conexion con = new conexion();
    private final ReportEscrituras jasper;
    /**
     * Creates new form JIFEscriturasPublicas
     */
    public JIFEscriturasPublicas() {
            initComponents();
        jasper= new ReportEscrituras();
       panel2.setColorPrimario(new Color(32,39,55, 90));
        panel1.setColorPrimario(new Color(32,39,55, 50));
        this.txtSolicitud.setEditable(false);
//        lblIdSol.setVisible(false);
//        lblCod.setVisible(false);
//        jLabel5.setVisible(false);
//        this.lblcodNot.setVisible(false);
//        this.txtCodNot.setVisible(false);
//        this.btnChangeDat.setVisible(false);
//        this.labelIdSol.setVisible(false);
        actualizar_Tabla();
       desactiva();
       sizeTabla();
        
        int solic=0,esc=0;
        try{
                con.conectar();
                ResultSet res=con.consulta("SELECT max(codSol) FROM solicitudes");
                res.next();
                solic=Integer.parseInt(res.getString(1));
                res=con.consulta("SELECT max(idSol) FROM escpublicas");
                res.next();
                esc=Integer.parseInt(res.getString(1));
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
        txtSolicitud.setText(String.valueOf(solic+1));
        this.lblIdSol.setText(String.valueOf(esc+1));
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(0,153,255,50));
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
    }
    public void actualizar_Tabla(){
            String[] nameColumn = {"Codigo","Notario", "Provincia","FechaInicio","FechaFinal"};
            String text = "%";
            datNot = nt2.getDatos(text);
            DefaultTableModel datos = new DefaultTableModel(datNot,nameColumn);
            Tabla.setModel(datos);
        }
        public void desactiva(){
            this.txtSolicitud.setText("");
            this.txtSolicitud.setEditable(false);
            this.txtNumDoc.setEditable(false);
            this.txtNom.setEditable(false);

        this.txtFavor.setEditable(false);
        this.txtNom.setEditable(false);
        this.txtNumDoc.setEditable(false);
        this.txtOtor.setEditable(false);
        this.txtOtros.setEditable(false);
        this.txtDia.setEditable(false);
        this.txtBuscaNotario.setEditable(false);
        this.cboxMes.setSelectedIndex(0);
        this.txtAño.setEditable(false);
        this.txtEscrPublic.setEditable(false);
        this.txtLugar.setEditable(false);
        this.txtNotario.setEditable(false);
            this.btnGuardar.setEnabled(false);
            this.btnImprimir.setEnabled(false);
            this.btnUsu.setEnabled(false);
        }
         public void activa(){
            //this.txtSolicitud.setText("");
           // this.txtSolicitud.setEditable(true);
            this.txtNumDoc.setEditable(true);
            this.txtNom.setEditable(true);

             this.txtFavor.setEditable(true);
        this.txtNom.setEditable(true);
        this.txtNumDoc.setEditable(true);
        this.txtOtor.setEditable(true);
        this.txtOtros.setEditable(true);
        this.txtDia.setEditable(true);
        this.txtBuscaNotario.setEditable(true);
        this.cboxMes.setSelectedIndex(0);
        this.txtAño.setEditable(true);
        this.txtEscrPublic.setEditable(true);
        this.txtLugar.setEditable(true);
        this.txtNotario.setEditable(true);
            this.btnGuardar.setEnabled(true);
            //this.btnImprimir.setEnabled(true);
            this.btnUsu.setEnabled(true);
        }
       public void sizeTabla(){
           Tabla.getColumnModel().getColumn(0).setMaxWidth(50);
           Tabla.getColumnModel().getColumn(1).setMaxWidth(500);
           Tabla.getColumnModel().getColumn(2).setMaxWidth(150);
           Tabla.getColumnModel().getColumn(3).setMaxWidth(80);
           Tabla.getColumnModel().getColumn(4).setMaxWidth(80);
       }
      public void limpiar(){
        txtFavor.setText("");
        txtNom.setText("");
        txtNumDoc.setText("");
        txtOtor.setText("");
        txtOtros.setText("");
        txtDia.setText("");
        txtBuscaNotario.setText("");
        cboxMes.setSelectedIndex(0);
        txtAño.setText("");
        txtEscrPublic.setText("");
        txtLugar.setText("");
        txtNotario.setText("");
        this.btnImprimir.setEnabled(false);
        desactiva();
      }
      public void activar_nuevo(){
          actualizar_Tabla();
          sizeTabla();

      }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        tabbedPaneHeader1 = new org.edisoncor.gui.tabbedPane.TabbedPaneHeader();
        panelReflect1 = new org.edisoncor.gui.panel.PanelReflect();
        btnVer = new org.edisoncor.gui.button.ButtonColoredAction();
        BtnRImprimir = new org.edisoncor.gui.button.ButtonColoredAction();
        jSeparator1 = new javax.swing.JSeparator();
        lblIdSol = new javax.swing.JLabel();
        labelIdSol = new javax.swing.JLabel();
        buttonColoredAction1 = new org.edisoncor.gui.button.ButtonColoredAction();
        jSeparator2 = new javax.swing.JSeparator();
        panelRoundTranslucido1 = new org.edisoncor.gui.panel.PanelRoundTranslucido();
        labelMetric18 = new org.edisoncor.gui.label.LabelMetric();
        tabbedPaneHeader2 = new org.edisoncor.gui.tabbedPane.TabbedPaneHeader();
        panelReflect3 = new org.edisoncor.gui.panel.PanelReflect();
        btnGuardar = new org.edisoncor.gui.button.ButtonColoredAction();
        btnChangeDat = new org.edisoncor.gui.button.ButtonColoredAction();
        btnImprimir = new org.edisoncor.gui.button.ButtonColoredAction();
        btnCancelar = new org.edisoncor.gui.button.ButtonColoredAction();
        jSeparator3 = new javax.swing.JSeparator();
        tabbedPaneHeader4 = new org.edisoncor.gui.tabbedPane.TabbedPaneHeader();
        panel1 = new org.edisoncor.gui.panel.Panel();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();
        txtNom = new javax.swing.JTextField();
        lblCod = new org.edisoncor.gui.label.LabelMetric();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        txtNumDoc = new javax.swing.JTextField();
        btnUsu = new org.edisoncor.gui.button.ButtonAction();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        txtSolicitud = new javax.swing.JTextField();
        txtCodNot = new javax.swing.JTextField();
        tabbedPaneHeader3 = new org.edisoncor.gui.tabbedPane.TabbedPaneHeader();
        panel2 = new org.edisoncor.gui.panel.Panel();
        labelMetric19 = new org.edisoncor.gui.label.LabelMetric();
        txtEscrPublic = new javax.swing.JTextField();
        labelMetric20 = new org.edisoncor.gui.label.LabelMetric();
        txtBuscaNotario = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        labelMetric22 = new org.edisoncor.gui.label.LabelMetric();
        txtNotario = new javax.swing.JTextField();
        labelMetric23 = new org.edisoncor.gui.label.LabelMetric();
        txtfecini = new javax.swing.JTextField();
        labelMetric24 = new org.edisoncor.gui.label.LabelMetric();
        txtfecfin = new javax.swing.JTextField();
        labelMetric25 = new org.edisoncor.gui.label.LabelMetric();
        txtLugar = new javax.swing.JTextField();
        labelMetric26 = new org.edisoncor.gui.label.LabelMetric();
        txtOtor = new javax.swing.JTextField();
        labelMetric27 = new org.edisoncor.gui.label.LabelMetric();
        txtFavor = new javax.swing.JTextField();
        labelMetric28 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric29 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric30 = new org.edisoncor.gui.label.LabelMetric();
        txtDia = new javax.swing.JTextField();
        cboxMes = new javax.swing.JComboBox();
        txtAño = new javax.swing.JTextField();
        labelMetric31 = new org.edisoncor.gui.label.LabelMetric();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtOtros = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 177, 178)));
        setClosable(true);
        setIconifiable(true);

        panelImage1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(176, 177, 178)));
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo6.png"))); // NOI18N

        tabbedPaneHeader1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnVer.setBackground(new java.awt.Color(0, 0, 0));
        btnVer.setText("Visualizar Escrituras");
        btnVer.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        BtnRImprimir.setBackground(new java.awt.Color(0, 0, 0));
        BtnRImprimir.setText("Re-Imprimir");
        BtnRImprimir.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        BtnRImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRImprimirActionPerformed(evt);
            }
        });

        jSeparator1.setOpaque(true);

        lblIdSol.setFont(new java.awt.Font("Ubuntu", 0, 1)); // NOI18N
        lblIdSol.setForeground(new java.awt.Color(255, 255, 255));
        lblIdSol.setText("lblIdSol");

        labelIdSol.setFont(new java.awt.Font("Ubuntu", 0, 1)); // NOI18N
        labelIdSol.setForeground(new java.awt.Color(255, 255, 255));
        labelIdSol.setText("labelIdSol");

        buttonColoredAction1.setBackground(new java.awt.Color(0, 172, 255));
        buttonColoredAction1.setText("Nuevo");
        buttonColoredAction1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        buttonColoredAction1.setMaximumSize(new java.awt.Dimension(175, 45));
        buttonColoredAction1.setMinimumSize(new java.awt.Dimension(175, 45));
        buttonColoredAction1.setPreferredSize(new java.awt.Dimension(175, 45));
        buttonColoredAction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColoredAction1ActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOpaque(true);

        javax.swing.GroupLayout panelReflect1Layout = new javax.swing.GroupLayout(panelReflect1);
        panelReflect1.setLayout(panelReflect1Layout);
        panelReflect1Layout.setHorizontalGroup(
            panelReflect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReflect1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReflect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonColoredAction1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnRImprimir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelReflect1Layout.createSequentialGroup()
                        .addComponent(lblIdSol, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelIdSol, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 88, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator2)
        );
        panelReflect1Layout.setVerticalGroup(
            panelReflect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReflect1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonColoredAction1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnRImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelReflect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdSol, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIdSol))
                .addContainerGap())
        );

        tabbedPaneHeader1.addTab("OTROS", panelReflect1);

        labelMetric18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMetric18.setText("ESCRITURAS PUBLICAS");
        labelMetric18.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        javax.swing.GroupLayout panelRoundTranslucido1Layout = new javax.swing.GroupLayout(panelRoundTranslucido1);
        panelRoundTranslucido1.setLayout(panelRoundTranslucido1Layout);
        panelRoundTranslucido1Layout.setHorizontalGroup(
            panelRoundTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundTranslucido1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMetric18, javax.swing.GroupLayout.DEFAULT_SIZE, 1151, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRoundTranslucido1Layout.setVerticalGroup(
            panelRoundTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundTranslucido1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelMetric18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedPaneHeader2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnGuardar.setBackground(new java.awt.Color(255, 0, 0));
        btnGuardar.setText("Guardar Datos");
        btnGuardar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnChangeDat.setBackground(new java.awt.Color(1, 1, 1));
        btnChangeDat.setText("Cambiar Datos");
        btnChangeDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeDatActionPerformed(evt);
            }
        });

        btnImprimir.setBackground(new java.awt.Color(255, 0, 0));
        btnImprimir.setText("Imprimir");
        btnImprimir.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(226, 218, 128));
        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setOpaque(true);

        javax.swing.GroupLayout panelReflect3Layout = new javax.swing.GroupLayout(panelReflect3);
        panelReflect3.setLayout(panelReflect3Layout);
        panelReflect3Layout.setHorizontalGroup(
            panelReflect3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReflect3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReflect3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChangeDat, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator3)
        );
        panelReflect3Layout.setVerticalGroup(
            panelReflect3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReflect3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnChangeDat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedPaneHeader2.addTab("OPCIONES", panelReflect3);

        tabbedPaneHeader4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 177, 178)));

        labelMetric3.setText("Nombre:");
        labelMetric3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N

        txtNom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNom.setMaximumSize(new java.awt.Dimension(512, 29));
        txtNom.setMinimumSize(new java.awt.Dimension(512, 29));
        txtNom.setPreferredSize(new java.awt.Dimension(512, 29));
        txtNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomKeyPressed(evt);
            }
        });

        lblCod.setForeground(new java.awt.Color(1, 1, 1));
        lblCod.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblCod.setMaximumSize(new java.awt.Dimension(59, 29));
        lblCod.setMinimumSize(new java.awt.Dimension(59, 29));
        lblCod.setPreferredSize(new java.awt.Dimension(59, 29));

        labelMetric1.setText("N° Documento:");
        labelMetric1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N

        txtNumDoc.setBackground(new java.awt.Color(1, 1, 1));
        txtNumDoc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNumDoc.setForeground(new java.awt.Color(254, 254, 254));
        txtNumDoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtNumDoc.setMaximumSize(new java.awt.Dimension(287, 29));
        txtNumDoc.setMinimumSize(new java.awt.Dimension(287, 29));
        txtNumDoc.setPreferredSize(new java.awt.Dimension(287, 29));
        txtNumDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumDocKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumDocKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumDocKeyTyped(evt);
            }
        });

        btnUsu.setBackground(new java.awt.Color(43, 222, 57));
        btnUsu.setForeground(new java.awt.Color(28, 209, 15));
        btnUsu.setText("Buscar Solicitante");
        btnUsu.setColorDeSombra(new java.awt.Color(1, 1, 1));
        btnUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuActionPerformed(evt);
            }
        });

        labelMetric2.setText("N° Solicitud:");
        labelMetric2.setDistanciaDeSombra(2);

        txtSolicitud.setBackground(new java.awt.Color(254, 254, 254));
        txtSolicitud.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtSolicitud.setForeground(new java.awt.Color(1, 1, 1));
        txtSolicitud.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtSolicitud.setPreferredSize(new java.awt.Dimension(29, 19));

        txtCodNot.setBackground(new java.awt.Color(1, 1, 1));
        txtCodNot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodNot.setForeground(new java.awt.Color(1, 1, 1));
        txtCodNot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCod, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(txtCodNot, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(txtNumDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNumDoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSolicitud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCodNot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabbedPaneHeader4.addTab("BUSQUEDA", panel1);

        tabbedPaneHeader3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 177, 178)));
        tabbedPaneHeader3.setMaximumSize(new java.awt.Dimension(879, 503));
        tabbedPaneHeader3.setMinimumSize(new java.awt.Dimension(879, 503));
        tabbedPaneHeader3.setPreferredSize(new java.awt.Dimension(879, 503));

        labelMetric19.setText("Escritura Publica:");
        labelMetric19.setDistanciaDeSombra(2);
        labelMetric19.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N

        txtEscrPublic.setFont(new java.awt.Font("AgencyFB", 1, 18)); // NOI18N
        txtEscrPublic.setText("COMPRA VENTA");
        txtEscrPublic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEscrPublicKeyPressed(evt);
            }
        });

        labelMetric20.setText("Notario:");
        labelMetric20.setDistanciaDeSombra(2);
        labelMetric20.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N

        txtBuscaNotario.setFont(new java.awt.Font("AgencyFB", 1, 18)); // NOI18N
        txtBuscaNotario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaNotarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaNotarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaNotarioKeyTyped(evt);
            }
        });

        Tabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Codigo", "Notario", "Provincia"
            }
        ));
        Tabla.setToolTipText("Lista de Notarios");
        Tabla.setMaximumSize(new java.awt.Dimension(858, 100));
        Tabla.setMinimumSize(new java.awt.Dimension(858, 100));
        Tabla.setPreferredSize(new java.awt.Dimension(858, 100));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tabla);

        labelMetric22.setText("Notario:");
        labelMetric22.setDistanciaDeSombra(2);
        labelMetric22.setFont(new java.awt.Font("Arial", 2, 15)); // NOI18N

        txtNotario.setFont(new java.awt.Font("AgencyFB", 1, 18)); // NOI18N

        labelMetric23.setText("Fech Ini:");
        labelMetric23.setToolTipText("");
        labelMetric23.setDistanciaDeSombra(2);
        labelMetric23.setFont(new java.awt.Font("Arial", 2, 15)); // NOI18N

        txtfecini.setFont(new java.awt.Font("AgencyFB", 1, 18)); // NOI18N
        txtfecini.setForeground(new java.awt.Color(1, 1, 1));
        txtfecini.setMaximumSize(new java.awt.Dimension(84, 29));
        txtfecini.setMinimumSize(new java.awt.Dimension(84, 29));
        txtfecini.setName(""); // NOI18N
        txtfecini.setPreferredSize(new java.awt.Dimension(84, 29));

        labelMetric24.setText("Fech Fin:");
        labelMetric24.setDistanciaDeSombra(2);
        labelMetric24.setFont(new java.awt.Font("Arial", 2, 15)); // NOI18N

        txtfecfin.setFont(new java.awt.Font("AgencyFB", 1, 18)); // NOI18N
        txtfecfin.setForeground(new java.awt.Color(1, 1, 1));
        txtfecfin.setMaximumSize(new java.awt.Dimension(84, 29));
        txtfecfin.setMinimumSize(new java.awt.Dimension(84, 29));
        txtfecfin.setName(""); // NOI18N
        txtfecfin.setPreferredSize(new java.awt.Dimension(84, 29));

        labelMetric25.setText("Lugar:");
        labelMetric25.setDistanciaDeSombra(2);
        labelMetric25.setFont(new java.awt.Font("Arial", 2, 15)); // NOI18N

        txtLugar.setFont(new java.awt.Font("AgencyFB", 1, 18)); // NOI18N

        labelMetric26.setText("Otorgante:");
        labelMetric26.setDistanciaDeSombra(2);
        labelMetric26.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        txtOtor.setFont(new java.awt.Font("AgencyFB", 1, 18)); // NOI18N
        txtOtor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtOtorKeyPressed(evt);
            }
        });

        labelMetric27.setText("Favorecido:");
        labelMetric27.setDistanciaDeSombra(2);
        labelMetric27.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        txtFavor.setFont(new java.awt.Font("AgencyFB", 1, 18)); // NOI18N
        txtFavor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFavorKeyPressed(evt);
            }
        });

        labelMetric28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMetric28.setText("Dia.");
        labelMetric28.setDistanciaDeSombra(2);
        labelMetric28.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N

        labelMetric29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMetric29.setText("Mes.");
        labelMetric29.setDistanciaDeSombra(2);
        labelMetric29.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N

        labelMetric30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMetric30.setText("Año.");
        labelMetric30.setDistanciaDeSombra(2);
        labelMetric30.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N

        txtDia.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtDia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDiaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiaKeyTyped(evt);
            }
        });

        cboxMes.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cboxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SETIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        cboxMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboxMesKeyPressed(evt);
            }
        });

        txtAño.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtAño.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAñoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAñoKeyTyped(evt);
            }
        });

        labelMetric31.setText("Fecha:");
        labelMetric31.setDistanciaDeSombra(2);
        labelMetric31.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtOtros.setColumns(20);
        txtOtros.setRows(5);
        txtOtros.setMaximumSize(new java.awt.Dimension(285, 85));
        txtOtros.setMinimumSize(new java.awt.Dimension(285, 85));
        txtOtros.setPreferredSize(new java.awt.Dimension(285, 85));
        jScrollPane4.setViewportView(txtOtros);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(labelMetric19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBuscaNotario)
                                    .addComponent(txtEscrPublic, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)))
                            .addComponent(labelMetric20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMetric27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(txtNotario)
                                .addGap(18, 18, 18)
                                .addComponent(labelMetric25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelMetric23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txtfecini, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelMetric24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(txtfecfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelMetric28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cboxMes, 0, 193, Short.MAX_VALUE)
                                            .addComponent(labelMetric29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtAño)
                                            .addComponent(labelMetric30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFavor, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                                        .addComponent(txtOtor)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEscrPublic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscaNotario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelMetric24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtfecfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelMetric22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNotario)
                        .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelMetric25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelMetric23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtfecini, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMetric26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtOtor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMetric27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFavor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMetric29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelMetric30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelMetric28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelMetric31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPaneHeader3.addTab(" ", panel2);

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tabbedPaneHeader4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(tabbedPaneHeader3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tabbedPaneHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tabbedPaneHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelRoundTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addComponent(tabbedPaneHeader4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabbedPaneHeader3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addComponent(tabbedPaneHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabbedPaneHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(panelImage1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        ver_solicitud = JOptionPane.showInputDialog("Ingrese Numero de Solicitud a visualizar");

        this.txtNumDoc.setEditable(true);
        this.btnUsu.setEnabled(true);
        this.txtFavor.setEditable(true);
        this.txtOtor.setEditable(true);
        this.txtOtros.setEditable(true);
        this.txtDia.setEditable(true);
        this.txtBuscaNotario.setEditable(true);
        this.cboxMes.setSelectedIndex(0);
        this.txtAño.setEditable(true);
        this.txtEscrPublic.setEditable(true);
        this.txtLugar.setEditable(true);
        this.txtNotario.setEditable(true);

        this.btnGuardar.setVisible(false);
        this.btnChangeDat.setVisible(true);
        try{
            con.conectar();
            ResultSet res = con.consulta("SELECT s.codSol,u.codUsu, CONCAT(u.nombre,' ',u.apePat,' ',u.apeMat)as usuario, u.codDis,u.numDoc, u.direccion,e.idSol,e.tipEsc,e.otorgante,e.favorecido, n.cod_not,CONCAT(n.nom_not,' ',n.pat_not,' ',n.mat_not) as notario, n.provincia, e.dia, e.mes, e.anio, e.obs FROM solicitudes AS s, usuarios AS u, escpublicas as e, notarios as n WHERE s.codUsu = u.codUsu  and s.idSol=e.idSol and e.codNot=n.cod_not and s.codSol = '"+ver_solicitud+"';");
            res.next();
            this.txtSolicitud.setText(res.getString("codSol"));
            this.txtNumDoc.setText(res.getString("numDoc"));
            this.lblCod.setText(res.getString("codUsu"));
            this.txtNom.setText(res.getString("usuario"));
            this.txtEscrPublic.setText(res.getString("tipEsc"));
            this.txtCodNot.setText(res.getString("cod_not"));
            this.txtNotario.setText(res.getString("notario"));

            this.txtOtor.setText(res.getString("otorgante"));
            this.txtFavor.setText(res.getString("favorecido"));
            this.txtDia.setText(res.getString("dia"));
            this.cboxMes.setSelectedItem(res.getString("mes"));
            this.txtAño.setText(res.getString("anio"));
            this.txtOtros.setText(res.getString("obs"));
            this.labelIdSol.setText(res.getString("idSol"));
            con.cierraConexion();
        }catch(Exception e){
            JOptionPane.showMessageDialog(txtCodNot, "Error Consultando. " + e);
        }
    }//GEN-LAST:event_btnVerActionPerformed

    private void BtnRImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRImprimirActionPerformed
       String solicitudD = JOptionPane.showInputDialog("Escriba el Numero de Solicitud");
        String num_sol = solicitudD;
        jasper.ejecutarReporte(num_sol);
    }//GEN-LAST:event_BtnRImprimirActionPerformed

    private void buttonColoredAction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColoredAction1ActionPerformed
       int solic=0,esc=0;
        try{
            con.conectar();
            ResultSet res=con.consulta("SELECT max(codSol) FROM solicitudes");
            res.next();
            solic=Integer.parseInt(res.getString(1));
            res=con.consulta("SELECT max(idSol) FROM escpublicas");
            res.next();
            esc=Integer.parseInt(res.getString(1));
            con.cierraConexion();
        }catch(SQLException e){
            System.out.println(e);
        }
        txtSolicitud.setText(String.valueOf(solic+1));
        lblIdSol.setText(String.valueOf(esc+1));
        txtFavor.setText("");
        txtNom.setText("");
        txtNumDoc.setText("");
        txtOtor.setText("");
        txtOtros.setText("");
        txtDia.setText("");
        txtBuscaNotario.setText("");
        cboxMes.setSelectedIndex(0);
        txtAño.setText("");
        txtEscrPublic.setText("COMPRA VENTA");
        txtLugar.setText("");
        txtNotario.setText("");
        txtNumDoc.requestFocus();
        activa();
    }//GEN-LAST:event_buttonColoredAction1ActionPerformed

    private void btnChangeDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeDatActionPerformed
             cod = Integer.parseInt(lblCod.getText());
        idsol =Integer.parseInt(lblIdSol.getText());
        // Recoje los datos
        NumIdSol = this.labelIdSol.getText();
        num_solicitud = this.txtSolicitud.getText();
        tipEscr = txtEscrPublic.getText().toUpperCase();
        not = txtCodNot.getText();
        otor = this.txtOtor.getText().toUpperCase();
        favor = txtFavor.getText().toUpperCase();
        dia = txtDia.getText().toUpperCase();
        mes = cboxMes.getSelectedItem().toString();

        year1 = this.txtAño.getText();
        otros = txtOtros.getText().toUpperCase();

        int rpta1 = JOptionPane.showConfirmDialog(txtCodNot,"¿Esta seguro de realizar estos cambios?","ARP Sistema",JOptionPane.YES_NO_OPTION);
        if(rpta1 == 0){
            try{
                con.conectar();
                con.actualizar("UPDATE escpublicas SET tipEsc = '"+tipEscr+"' , codNot = '"+not+"' , otorgante = '"+otor+"' , favorecido = '"+favor+"' , dia = '"+dia+"' , mes = '"+mes+"' , anio = '"+year1+"' , obs = '"+otros+"' WHERE idSol = '"+NumIdSol+"';");
                con.actualizar("UPDATE solicitudes SET codUsu = '"+cod+"', idSol = '"+NumIdSol+"' WHERE codSol = '"+num_solicitud+"';");
                JOptionPane.showMessageDialog(txtCodNot, "Datos Modificados Satisfactotiamente");
                //con.cierraConexion();
            }catch(Exception e){
                JOptionPane.showMessageDialog(txtCodNot, "Error Cambiando datos. " + e);
            }
        }
        this.btnChangeDat.setVisible(false);
        this.btnGuardar.setVisible(true);
        this.btnGuardar.setEnabled(false);
        this.btnImprimir.setEnabled(true);
    }//GEN-LAST:event_btnChangeDatActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       cod = Integer.parseInt(lblCod.getText());
        idsol =Integer.parseInt(lblIdSol.getText());
        int codTipSol=1;
        //
        num_solicitud = this.txtSolicitud.getText();
        tipEscr = this.txtEscrPublic.getText().toUpperCase();
        not = this.txtCodNot.getText();
        otor = this.txtOtor.getText().toUpperCase();
        favor = this.txtFavor.getText().toUpperCase();
        dia = this.txtDia.getText().toUpperCase();
        mes = this.cboxMes.getSelectedItem().toString();

        year1 = this.txtAño.getText();
        otros = this.txtOtros.getText().toUpperCase();

        yearInicio = Integer.parseInt(this.txtfecini.getText());
        yearFinal = Integer.parseInt(this.txtfecfin.getText());
        yearIntro = Integer.parseInt(this.txtAño.getText());


        if (yearIntro>=yearInicio && yearIntro <= yearFinal){

            try{
                int rpta = JOptionPane.showConfirmDialog(rootPane,"¿Estas Seguro de Guardar?","ARP Sistema",JOptionPane.YES_NO_OPTION);
                if(rpta == 0){
                    con.conectar();
                    con.insertar("INSERT INTO escpublicas(tipEsc,codNot,otorgante,favorecido,dia,mes,anio,obs) VALUES ('"+tipEscr+"','"+not+"','"+otor+"','"+favor+"','"+dia+"','"+mes+"','"+year1+"','"+otros+"');");
                    con.insertar("INSERT INTO solicitudes(codSol,codUsu,codTipSol,idSol) VALUES ('"+num_solicitud+"','"+cod+"','"+codTipSol+"','"+idsol+"');");
                    this.btnImprimir.setEnabled(true);
                    this.btnGuardar.setEnabled(false);
                }else{
                    JOptionPane.showMessageDialog(txtCodNot, "No se guardo nada");

                    limpiar();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Error Guardando" + e);
            }
        }else{
            JOptionPane.showMessageDialog(txtCodNot, "El Notario no ha trabajado en el año Indicado.\nRevise los Datos Por favor.");
            this.txtAño.setText("");
            this.txtAño.requestFocus();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
         String num_sol = this.txtSolicitud.getText();
        jasper.ejecutarReporte(num_sol);
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        desactiva();
        limpiar();
        this.btnChangeDat.setVisible(false);
        this.btnGuardar.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            //            txtContrPriv.requestFocus();
        }
    }//GEN-LAST:event_txtNomKeyPressed

    private void txtNumDocKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumDocKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            btnUsu.doClick();
        }
    }//GEN-LAST:event_txtNumDocKeyPressed

    private void txtNumDocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumDocKeyReleased
        if(txtNumDoc.getText().length()>7){
            btnUsu.doClick();
        }
    }//GEN-LAST:event_txtNumDocKeyReleased

    private void txtNumDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumDocKeyTyped
        int n = (int)evt.getKeyChar();
        if(n>=48 && n<=57 || n==13 || n==127){

        }else{
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_txtNumDocKeyTyped

    private void btnUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuActionPerformed
        int numero = txtNumDoc.getText().length();
        String dni2 ="";
        if (numero <8){
            JOptionPane.showMessageDialog(rootPane, "Numero de Digitos de DNI Menor que 8 Numeros");
            this.txtNumDoc.requestFocus();
        }else{
            int dni=Integer.parseInt(txtNumDoc.getText());
            try{
                con.conectar();
                ResultSet rs=con.consulta("SELECT CONCAT(nombre,' ',apePat,' ',apeMat) AS nombre, codUsu FROM usuarios WHERE numDoc="+dni+" LIMIT 0,1;");
                rs.next();
                txtNom.setText(rs.getString("nombre"));
                lblCod.setText(rs.getString("codUsu"));
            }catch(SQLException e){
                JOptionPane.showMessageDialog(rootPane, "Usuario no encontrado","Administrador de Sistema",JOptionPane.INFORMATION_MESSAGE);
                JFPrincipal.DNI = this.txtNumDoc.getText();
                JDNuevoUsuario p=new JDNuevoUsuario(null, true);
                p.setVisible(true);
            }
            //            txtEscrPublic.requestFocus();
        }
    }//GEN-LAST:event_btnUsuActionPerformed

    private void txtEscrPublicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEscrPublicKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            txtBuscaNotario.requestFocus();
        }
    }//GEN-LAST:event_txtEscrPublicKeyPressed

    private void txtBuscaNotarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaNotarioKeyPressed
        // TODO add your handling code here:
        actualizar_Tabla();
        sizeTabla();
        try{
            con.conectar();
        }catch(Exception e){
            JOptionPane.showMessageDialog(txtCodNot, e);
        }
    }//GEN-LAST:event_txtBuscaNotarioKeyPressed

    private void txtBuscaNotarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaNotarioKeyReleased
        // TODO add your handling code here:
        Tabla.getColumnModel().getColumn(0).setMaxWidth(40);
        Tabla.getColumnModel().getColumn(1).setMaxWidth(500);
        Tabla.getColumnModel().getColumn(2).setMaxWidth(150);
        Tabla.getColumnModel().getColumn(3).setMaxWidth(80);
        Tabla.getColumnModel().getColumn(4).setMaxWidth(80);
    }//GEN-LAST:event_txtBuscaNotarioKeyReleased

    private void txtBuscaNotarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaNotarioKeyTyped
        // TODO add your handling code here:
        notarios2 nt = new notarios2();
        String[] columNames ={"Codigo","Notario", "Provincia","FechaInicio","FechaFinal"};
        String valor = this.txtBuscaNotario.getText();
        datNot = nt.getDatos(valor);
        DefaultTableModel dat = new DefaultTableModel(datNot,columNames);
        Tabla.setModel(dat);
    }//GEN-LAST:event_txtBuscaNotarioKeyTyped

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        // TODO add your handling code here:
        fila = Tabla.rowAtPoint(evt.getPoint());
        if(fila > -1){
            String provincia = String.valueOf(Tabla.getValueAt(fila, 2));
            String nombre = String.valueOf(Tabla.getValueAt(fila, 1));
            String codigo = String.valueOf(Tabla.getValueAt(fila, 0));
            String fecini = String.valueOf(Tabla.getValueAt(fila, 3));
            String fecfin = String.valueOf(Tabla.getValueAt(fila, 4));
            txtNotario.setText(nombre);
            txtLugar.setText(provincia);
            txtCodNot.setText(codigo);
            txtfecini.setText(fecini);
            txtfecfin.setText(fecfin);
        }
        txtOtor.requestFocus();
        activa();
    }//GEN-LAST:event_TablaMouseClicked

    private void txtOtorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtorKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            txtFavor.requestFocus();
        }
    }//GEN-LAST:event_txtOtorKeyPressed

    private void txtFavorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFavorKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            txtDia.requestFocus();
        }
    }//GEN-LAST:event_txtFavorKeyPressed

    private void txtDiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaKeyPressed
        // TODO add your handling code here:
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            cboxMes.requestFocus();
        }
    }//GEN-LAST:event_txtDiaKeyPressed

    private void txtDiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaKeyTyped
        // TODO add your handling code here:
        int n = (int)evt.getKeyChar();
        if(n>=48 && n<=57 || n==13 || n==127){

        }else{
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_txtDiaKeyTyped

    private void cboxMesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboxMesKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            txtAño.requestFocus();
        }
    }//GEN-LAST:event_cboxMesKeyPressed

    private void txtAñoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAñoKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            txtOtros.requestFocus();
        }
    }//GEN-LAST:event_txtAñoKeyPressed

    private void txtAñoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAñoKeyTyped
        // TODO add your handling code here:
        int n = (int)evt.getKeyChar();
        if(n>=48 && n<=57 || n==13 || n==127){

        }else{
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_txtAñoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonColoredAction BtnRImprimir;
    private static javax.swing.JTable Tabla;
    private org.edisoncor.gui.button.ButtonColoredAction btnCancelar;
    private org.edisoncor.gui.button.ButtonColoredAction btnChangeDat;
    private org.edisoncor.gui.button.ButtonColoredAction btnGuardar;
    private org.edisoncor.gui.button.ButtonColoredAction btnImprimir;
    private org.edisoncor.gui.button.ButtonAction btnUsu;
    private org.edisoncor.gui.button.ButtonColoredAction btnVer;
    private org.edisoncor.gui.button.ButtonColoredAction buttonColoredAction1;
    private javax.swing.JComboBox cboxMes;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelIdSol;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.label.LabelMetric labelMetric18;
    private org.edisoncor.gui.label.LabelMetric labelMetric19;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.label.LabelMetric labelMetric20;
    private org.edisoncor.gui.label.LabelMetric labelMetric22;
    private org.edisoncor.gui.label.LabelMetric labelMetric23;
    private org.edisoncor.gui.label.LabelMetric labelMetric24;
    private org.edisoncor.gui.label.LabelMetric labelMetric25;
    private org.edisoncor.gui.label.LabelMetric labelMetric26;
    private org.edisoncor.gui.label.LabelMetric labelMetric27;
    private org.edisoncor.gui.label.LabelMetric labelMetric28;
    private org.edisoncor.gui.label.LabelMetric labelMetric29;
    private org.edisoncor.gui.label.LabelMetric labelMetric3;
    private org.edisoncor.gui.label.LabelMetric labelMetric30;
    private org.edisoncor.gui.label.LabelMetric labelMetric31;
    private org.edisoncor.gui.label.LabelMetric lblCod;
    private javax.swing.JLabel lblIdSol;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelReflect panelReflect1;
    private org.edisoncor.gui.panel.PanelReflect panelReflect3;
    private org.edisoncor.gui.panel.PanelRoundTranslucido panelRoundTranslucido1;
    private org.edisoncor.gui.tabbedPane.TabbedPaneHeader tabbedPaneHeader1;
    private org.edisoncor.gui.tabbedPane.TabbedPaneHeader tabbedPaneHeader2;
    private org.edisoncor.gui.tabbedPane.TabbedPaneHeader tabbedPaneHeader3;
    private org.edisoncor.gui.tabbedPane.TabbedPaneHeader tabbedPaneHeader4;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtBuscaNotario;
    private javax.swing.JTextField txtCodNot;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtEscrPublic;
    private javax.swing.JTextField txtFavor;
    private javax.swing.JTextField txtLugar;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtNotario;
    private javax.swing.JTextField txtNumDoc;
    private javax.swing.JTextField txtOtor;
    private javax.swing.JTextArea txtOtros;
    private javax.swing.JTextField txtSolicitud;
    private javax.swing.JTextField txtfecfin;
    private javax.swing.JTextField txtfecini;
    // End of variables declaration//GEN-END:variables
}
