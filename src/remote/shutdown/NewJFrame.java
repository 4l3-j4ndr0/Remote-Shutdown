/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote.shutdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;
import org.jvnet.substance.watermark.SubstanceImageWatermark;
import static sun.rmi.transport.TransportConstants.Ping;

/**
 *
 * @author 4l3
 */
public class NewJFrame extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {

        //this.getContentPane().setBackground(Color.WHITE);
        JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo)

        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.EmeraldDuskSkin"); // Setencia que aplica el skin Creme de Substance
        SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceLimeGreenTheme");
        // SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceCrosshatchWatermark");
        // SubstanceLookAndFeel.setCurrentWatermark(new SubstanceImageWatermark("ESCRITORIO.jpg"));
        SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.6));//valor aproximado de la opacidad por default de imageWatermark
       setIconImage(new ImageIcon(getClass().getResource("/imagenes/apagado.png")).getImage());
        initComponents();
        this.boton_on.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.boton_off.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.Desarollador.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.setLocationRelativeTo(null);
        pcs();
// comandos_CMD("msg * /server:4l3 ya paso un minuto");
        h1 = new Thread(this);
        h1.start();
        boton_on.setEnabled(false);
        
    }
    String hora, minutos, segundos, ampm;

    Calendar calendario;

    Thread h1;
    
    private int Vertical_Y;
    private int Horizontal_X;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanelBeanInfo1 = new jcMousePanel.jcMousePanelBeanInfo();
        jPanel2 = new javax.swing.JPanel();
        clockFace1 = new org.edisoncor.gui.varios.ClockFace();
        boton_on = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista_off = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_pc = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boton_off = new javax.swing.JButton();
        refres_off = new javax.swing.JButton();
        refres_pc = new javax.swing.JButton();
        select_all = new javax.swing.JCheckBox();
        mantener_off = new javax.swing.JCheckBox();
        Desarollador = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        curvo = new org.edisoncor.gui.panel.PanelCurves();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        boton_on.setText("Revertir");
        boton_on.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_onActionPerformed(evt);
            }
        });

        lista_off.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lista_offMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lista_off);

        lista_pc.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lista_pc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lista_pc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lista_pcMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lista_pc);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pc_on.png"))); // NOI18N
        jLabel1.setText("Listado de PC en red encendidas");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pc_off.png"))); // NOI18N
        jLabel3.setText("Listado de PC en red apagadas");

        boton_off.setText("OFF");
        boton_off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_offActionPerformed(evt);
            }
        });

        refres_off.setText("Limpiar lista ");
        refres_off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refres_offActionPerformed(evt);
            }
        });

        refres_pc.setText("Refrescar lista");
        refres_pc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refres_pcActionPerformed(evt);
            }
        });

        select_all.setText("Seleccionar todos");
        select_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_allActionPerformed(evt);
            }
        });

        mantener_off.setText("Mantener el apagado");
        mantener_off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mantener_offActionPerformed(evt);
            }
        });

        Desarollador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/programador.png"))); // NOI18N
        Desarollador.setText("Desarrollador");
        Desarollador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesarolladorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(refres_pc)
                        .addGap(18, 18, 18)
                        .addComponent(select_all)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(refres_off)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mantener_off)))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(boton_off, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boton_on))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(18, 18, 18)
                                .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Desarollador)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Desarollador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton_on)
                            .addComponent(boton_off)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(refres_off)
                            .addComponent(refres_pc)
                            .addComponent(select_all)
                            .addComponent(mantener_off))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimizar.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/CERRAR.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Elephant", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("EMPRESA DE SERVICIOS TECNICOS INDUSTRIALES DE ARTEMISA");
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 750, 34));
        jPanel1.add(curvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 34));

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void lista_pcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lista_pcMouseClicked
        // TODO add your handling code here:

        for (MouseListener mouseListener : lista_pc.getMouseListeners()) {
            lista_pc.removeMouseListener(mouseListener);

        }

        lista_pc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = lista_pc.locationToIndex(e.getPoint());
                if (lista_pc.isSelectedIndex(index)) {
                    lista_pc.removeSelectionInterval(index, index);
                } else {
                    lista_pc.addSelectionInterval(index, index);
                }
                lista_pc.requestFocusInWindow();
            }
        });
    }//GEN-LAST:event_lista_pcMouseClicked

    private void boton_onActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_onActionPerformed
        // TODO add your handling code here:
        /*  on_off.setSelected(false);
        String res = String.join("\n", lista_pc.getSelectedValuesList());
        JOptionPane.showMessageDialog(this, res);
        lista_pc.clearSelection();*/
        //comandos_CMD("shutdown -s -t 1000");
       // comandos_CMD("shutdown -s -f -t 180 -m 4l3 -c 'Se apagará su PC dentro 5 min para cumplir con el plan de ahorro de energía establecido en la empresa, por favor guarde todo su progreso.'");
       if (lista_off.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar primero almenos una PC para apagar");
        } else {
           for(int i=0;i<lista_off.getSelectedValuesList().size();i++){
                        // pc=String.join("", lista_pc.getSelectedValuesList().get(i));
                       String pc=lista_off.getSelectedValuesList().get(i);
                        // String cmd="shutdown -s -f -t 300 -m "+pc+" -c \"Se apagará su PC dentro 5 min para cumplir con el plan de ahorro de energía establecido en la empresa, por favor guarde todo su progreso.\"";
           
                comandos_CMD("shutdown -a -m "+lista_off.getSelectedValuesList().get(i));
                }
            ArrayList<String> off = new ArrayList();
                for (int i = 0; i < lista_off.getSelectedValuesList().size(); i++) {
                        off.add(lista_off.getSelectedValuesList().get(i));
                }
            
            DefaultListModel listModel = new DefaultListModel();
            DefaultListModel listMode2;
            listMode2 = (DefaultListModel) lista_off.getModel();
                for(int i=0;i<listMode2.getSize();i++){
                    for(int j=0;j<lista_off.getSelectedValuesList().size();j++){
               if(listMode2.getElementAt(i).equals(lista_off.getSelectedValuesList().get(j)))
                listMode2.remove(i);
                }
            }
           // lista_pc.getSelectedIndex();
            lista_off.setModel(listMode2);
            
            for (int i = 0; i < off.size(); i++) {
                //Añadir cada elemento del ArrayList en el modelo de la lista
                listModel.add(i, off.get(i));
            }
          //  lista_pc.setModel(listModel);
//Asociar el modelo de lista al JList
            if (lista_pc.getModel().getSize()==0) {
                lista_pc.setModel(listModel);
            }else{
                ArrayList temp=new ArrayList();
                for(int i=0;i<lista_pc.getModel().getSize();i++){
                    temp.add(lista_pc.getModel().getElementAt(i));
                }
                for(int i=0;i<off.size();i++){
                    temp.add(off.get(i));
                }
                listModel.clear();
                for (int i = 0; i < temp.size(); i++) {
                //Añadir cada elemento del ArrayList en el modelo de la lista
                listModel.add(i, temp.get(i));
            }
                lista_pc.setModel(listModel);
            }
        }
    }//GEN-LAST:event_boton_onActionPerformed

    public void kita_espacio_seleccion(ArrayList off){
        for (int i = 0; i < lista_pc.getSelectedValuesList().size(); i++) {
                int cont = 0;
                for (int j = 0; j < lista_pc.getSelectedValuesList().get(i).length(); j++) {
                    if (lista_pc.getSelectedValuesList().get(i).charAt(j) == ' ' && cont == 0) {
                        off.add(lista_pc.getSelectedValuesList().get(i).substring(0, j));
                        cont = 1;
                    }
                }
            }
    }
    
    public void kita_espacio(ArrayList off){
        for (int i = 0; i <off.size(); i++) {
                int cont = 0;
                for (int j = 0; j < off.get(i).toString().length(); j++) {
                    if (off.get(i).toString().charAt(j) == ' ' && cont == 0) {
                        off.set(i,off.get(i).toString().substring(0, j));
                        cont = 1;
                    }
                }
            }
    }
    
    private void boton_offActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_offActionPerformed
        // TODO add your handling code here:
        boton_off_action();
        
    }//GEN-LAST:event_boton_offActionPerformed

    public void boton_off_action(){
        if (lista_pc.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar primero almenos una PC para apagar");
        } else {
             for(int i=0;i<lista_pc.getSelectedValuesList().size();i++){
                        // pc=String.join("", lista_pc.getSelectedValuesList().get(i));
                       String pc=lista_pc.getSelectedValuesList().get(i);
                        // String cmd="shutdown -s -f -t 300 -m "+pc+" -c \"Se apagará su PC dentro 5 min para cumplir con el plan de ahorro de energía establecido en la empresa, por favor guarde todo su progreso.\"";
           
                comandos_CMD("shutdown -s -f -t 300 -m "+lista_pc.getSelectedValuesList().get(i)+" -c \"Se apagará su PC dentro 5 min para cumplir con el plan de ahorro de energía establecido en la empresa, por favor guarde todo su progreso.\"");
                }
             
            ArrayList<String> off = new ArrayList();
                for (int i = 0; i < lista_pc.getSelectedValuesList().size(); i++) {
                        off.add(lista_pc.getSelectedValuesList().get(i));
                }
            
            DefaultListModel listModel = new DefaultListModel();
            DefaultListModel listMode2;
            listMode2 = (DefaultListModel) lista_pc.getModel();
                for(int i=0;i<listMode2.getSize();i++){
                    for(int j=0;j<lista_pc.getSelectedValuesList().size();j++){
               if(listMode2.getElementAt(i).equals(lista_pc.getSelectedValuesList().get(j)))
                listMode2.remove(i);
                }
            }
           // lista_pc.getSelectedIndex();
            lista_pc.setModel(listMode2);
            
            for (int i = 0; i < off.size(); i++) {
                //Añadir cada elemento del ArrayList en el modelo de la lista
                listModel.add(i, off.get(i));
            }
          //  lista_pc.setModel(listModel);
//Asociar el modelo de lista al JList
            if (lista_off.getModel().getSize()==0) {
                lista_off.setModel(listModel);
            }else{
                ArrayList temp=new ArrayList();
                for(int i=0;i<lista_off.getModel().getSize();i++){
                    temp.add(lista_off.getModel().getElementAt(i));
                }
                for(int i=0;i<off.size();i++){
                    temp.add(off.get(i));
                }
                listModel.clear();
                for (int i = 0; i < temp.size(); i++) {
                //Añadir cada elemento del ArrayList en el modelo de la lista
                listModel.add(i, temp.get(i));
            }
                lista_off.setModel(listModel);
            }
        }
        
    }
    
    private void lista_offMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lista_offMouseClicked
        // TODO add your handling code here:
        for (MouseListener mouseListener : lista_off.getMouseListeners()) {
            lista_off.removeMouseListener(mouseListener);

        }

        lista_off.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = lista_off.locationToIndex(e.getPoint());
                if (lista_off.isSelectedIndex(index)) {
                    lista_off.removeSelectionInterval(index, index);
                } else {
                    lista_off.addSelectionInterval(index, index);
                }
                lista_off.requestFocusInWindow();
            }
        });
    }//GEN-LAST:event_lista_offMouseClicked

    private void refres_offActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refres_offActionPerformed
        // TODO add your handling code here:
        if(lista_off.getModel().getSize()>0){
        DefaultListModel listModel = (DefaultListModel) lista_off.getModel();
listModel.removeAllElements();
    }else{
            JOptionPane.showMessageDialog(this,"La lista ya esta vacía");
        }
    }//GEN-LAST:event_refres_offActionPerformed

    private void refres_pcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refres_pcActionPerformed
        // TODO add your handling code here:
        pcs();
        JOptionPane.showMessageDialog(this,"Lista actualizada");
    }//GEN-LAST:event_refres_pcActionPerformed

    private void select_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_allActionPerformed
        // TODO add your handling code here:
        if(select_all.isSelected()){
            lista_pc.setSelectionInterval(0,lista_pc.getModel().getSize()-1);
        }else{
            lista_pc.clearSelection();
        }
    }//GEN-LAST:event_select_allActionPerformed

    private void mantener_offActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mantener_offActionPerformed
        // TODO add your handling code here:
            new Thread(new Runnable() {
    public void run() {
        try {
            while(mantener_off.isSelected()){
            for(int i=0;i<lista_off.getModel().getSize();i++){
                if(comandos_CMD_salida("ping "+lista_off.getModel().getElementAt(i))==true){
                comandos_CMD("shutdown -s -f -t 100 -m "+lista_off.getModel().getElementAt(i)+" -c \"Se apagará su PC dentro de 1 min para cumplir con el plan de ahorro de energía establecido en la empresa, por favor cumpla con lo establecido.\"");
                    }
            }
               Thread.sleep(30000);
            
        }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}).start();
    }//GEN-LAST:event_mantener_offActionPerformed

    private void DesarolladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesarolladorActionPerformed
        // TODO add your handling code here:
        desarrollador info=new desarrollador();
        info.show();
    }//GEN-LAST:event_DesarolladorActionPerformed

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // TODO add your handling code here:
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        // TODO add your handling code here:
        jLabel5.setBorder(null);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        jLabel4.setBorder(null);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.setState(NewJFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked
//#################### mover panel ################################################################
    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        // TODO add your handling code here:
        if (getX() == 0 && getY() == 0) {
        } else {
            setLocation(evt.getXOnScreen() - Horizontal_X, evt.getYOnScreen() - Vertical_Y);
            if (evt.getYOnScreen() == 0) {
               // Maximizar();
            }
        }
    }//GEN-LAST:event_jLabel2MouseDragged

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        Vertical_Y = evt.getY();
        Horizontal_X = evt.getX()+20;
    }//GEN-LAST:event_jLabel2MousePressed
//######################################################################################################
    public void esperar() {
        JOptionPane msg = new JOptionPane("Seleccione las PC que NO desea apagar ", JOptionPane.INFORMATION_MESSAGE);

        JDialog dlg = msg.createDialog("Información");
        dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dlg.setVisible(false);
            }
        }).start();
        dlg.setVisible(true);
    }

    public void pcs() {
        String salida = null;
        String comando = "net view";
        ArrayList al = new ArrayList();
        //Crear un objeto DefaultListModel
        DefaultListModel listModel = new DefaultListModel();
//Recorrer el contenido del ArrayList

        try {

            // Ejecucion Basica del Comando
            Process proceso = Runtime.getRuntime().exec("cmd /c" + comando);

            InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
            BufferedReader stdInput = new BufferedReader(entrada);

            //Si el comando tiene una salida la mostramos
            if ((salida = stdInput.readLine()) != null) {
                while ((salida = stdInput.readLine()) != null) {
                    al.add(salida);
                }
                al.remove(0);
                al.remove(0);
                al.remove(al.size() - 1);
                al.remove(al.size() - 1);
                String ass = null;
                for (int i = 0; i < al.size(); i++) {
                    ass = al.get(i).toString().substring(2, al.get(i).toString().length() - 1);
                    /*for (int j = 0; j < al.get(i).toString().length(); j++) {
                    ass = al.get(i).toString().substring(2,al.get(i).toString().length()-1 );
                }*/
                    al.set(i, ass);
                }
                kita_espacio(al);
                for (int i = 0; i < al.size(); i++) {
                    //Añadir cada elemento del ArrayList en el modelo de la lista
                    listModel.add(i, al.get(i));

                }
//Asociar el modelo de lista al JList
                lista_pc.setModel(listModel);
            } else {
                JOptionPane.showMessageDialog(this, "Revise:" + "\n" + "- su conexión a la red" + "\n" + "- su ordenador este vinculado a un dominio" + "\n" + " Si estos dos aspectos estan correctos, póngase en contacto con su administrador de red" + "\n" + "Devolución del comando 'net view':  " + stdInput.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void calcula() {

        Calendar calendario = new GregorianCalendar();

        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);

        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {

            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;

            hora = h > 9 ? "" + h : "0" + h;

        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }

        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);

        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);

    }

    public void comandos_CMD(String comand1) {
        String comando1 = comand1;
        try {
            // Ejecucion Basica del Comando
            Process proceso = Runtime.getRuntime().exec("cmd /c" + comando1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public boolean comandos_CMD_salida(String comand1) { 
        boolean encendida=false;
        String comando1 = comand1;
        String salida=null;
        ArrayList al=new ArrayList();
        try {
            // Ejecucion Basica del Comando
            Process proceso = Runtime.getRuntime().exec("cmd /c" + comando1);
            InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
            BufferedReader stdInput = new BufferedReader(entrada);

            //Si el comando tiene una salida la mostramos
            if ((salida = stdInput.readLine()) != null) {
                while ((salida = stdInput.readLine()) != null) {
                    al.add(salida);
                    
                } if(al.size()>1){
                encendida=true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encendida;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new NewJFrame().setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Desarollador;
    private javax.swing.JButton boton_off;
    private javax.swing.JButton boton_on;
    private org.edisoncor.gui.varios.ClockFace clockFace1;
    private org.edisoncor.gui.panel.PanelCurves curvo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private jcMousePanel.jcMousePanelBeanInfo jcMousePanelBeanInfo1;
    private javax.swing.JList<String> lista_off;
    private javax.swing.JList<String> lista_pc;
    private javax.swing.JCheckBox mantener_off;
    private javax.swing.JButton refres_off;
    private javax.swing.JButton refres_pc;
    private javax.swing.JCheckBox select_all;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        
        while (ct == h1) {
            if(lista_off.getModel().getSize()>0){
                boton_on.setEnabled(true);
                mantener_off.setEnabled(true);
            }else{
                boton_on.setEnabled(false);
                mantener_off.setEnabled(false);
            }
            if(lista_pc.getModel().getSize()>0){
                select_all.setEnabled(true);
            }else{
                select_all.setEnabled(false);
            }
            calcula();
            if (hora.equals("10") && minutos.equals("55") && segundos.equals("00")) {
                boton_off_action();
                try {

                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                }
            }
            if (hora.equals("01") && minutos.equals("00") && segundos.equals("00")) {
                mantener_off.setSelected(false);
                try {

                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                }
            }

        }
    }
}
