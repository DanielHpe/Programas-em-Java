/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrames;

import static jFrames.ViewCursosFrame.centreWindow;
import java.awt.BorderLayout;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sool.*;

public class ViewCursosExtensionFrame extends javax.swing.JFrame {

    private int width = 620;
    private int height = 340;
    public String codigoExtensao = "";
    public boolean isEmpty;
    private Arquivo arquivo;
    private ArrayList<Extensao> listaExtensao = new ArrayList<>();
    
    public ViewCursosExtensionFrame() {
        this.arquivo = new Arquivo();
        initPanel();
        initComponents();
        centreWindow(this);
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) { 
                new SOOL().setVisible(true);
            }
        });
    }

    public void initPanel(){
        add(createMainPanel());
        setTitle("Lista de Cursos de Extensão");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(new JScrollPane(showCursos()), BorderLayout.CENTER);
        return panel;
    }

    public JList<String> showCursos(){
        
        DefaultListModel<String> model = new DefaultListModel<>();
        
        Extensao.listaExtensao = new Arquivo().readExtensao("extensao");
        
        if(Extensao.listaExtensao.isEmpty()){
            model.addElement("NENHUM CURSO ADICIONADO NO SISTEMA!");
        } else {
            for(int i = 0; i < listaExtensao.size(); i++){
                model.addElement(
                        "CÓDIGO: " + 
                               String.valueOf(Extensao.listaExtensao
                                       .get(i).getCodigo()).toUpperCase() + 
                        " - NOME: " + 
                                String.valueOf(Extensao.listaExtensao.get(i)
                                        .getNome()).toUpperCase() + 
                        " - TURNO: " +
                                String.valueOf(Extensao.listaExtensao.get(i)
                                        .getTurno()).toUpperCase() +
                        " - CARGA HORÁRIA: " + 
                                String.valueOf(Extensao.listaExtensao.get(i)
                                        .getCargaHoraria()).toUpperCase() +
                        " HORAS"
                );            
            }    
        }
        
        JList<String> list = new JList<String>(model); 
        
        list.setFont(new Font("Arial", Font.BOLD, 16));
        
        jListItemClickEvent(list);
               
        return list;
        
    }
    
    public void showExistsCodigo(boolean isEmpty, boolean exists){
        
        Object[] options = {"OK"};
        
        if(exists == false && isEmpty == false){
            JOptionPane.showOptionDialog(null,
            "Código do Curso de Extensão não existe no Sistema!",
            "Confirmação",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);    
        } else if(exists == false && isEmpty == true) {
            JOptionPane.showOptionDialog(null,
            "Ainda não existe Cursos de Extensão adicionadas ao Sistema!",
            "Confirmação",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);
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

        altGrad2 = new javax.swing.JButton();
        btnAltExtent = new javax.swing.JButton();
        verPeriodos = new javax.swing.JButton();

        altGrad2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        altGrad2.setForeground(new java.awt.Color(153, 0, 51));
        altGrad2.setText("Remover Graduação");
        altGrad2.setBorder(new javax.swing.border.MatteBorder(null));
        altGrad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altGrad2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAltExtent.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAltExtent.setForeground(new java.awt.Color(153, 0, 51));
        btnAltExtent.setText("Alterar Curso de Extensão");
        btnAltExtent.setBorder(new javax.swing.border.MatteBorder(null));
        btnAltExtent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltExtentActionPerformed(evt);
            }
        });

        verPeriodos.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        verPeriodos.setForeground(new java.awt.Color(153, 0, 51));
        verPeriodos.setText("Ver Períodos");
        verPeriodos.setBorder(new javax.swing.border.MatteBorder(null));
        verPeriodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPeriodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(verPeriodos, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addComponent(btnAltExtent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(290, Short.MAX_VALUE)
                .addComponent(btnAltExtent, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(verPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltExtentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltExtentActionPerformed
        
        boolean exists = false;
        boolean isEmpty = false;

        String codigo = JOptionPane.showInputDialog(null, 
                "Digite o código do Curso que deseja alterar!", 
                        "Alerta", JOptionPane.YES_NO_CANCEL_OPTION).toString().trim();
        
        if(Extensao.listaExtensao.isEmpty()){
            isEmpty = true;
        }
        
        for(Extensao e : Extensao.listaExtensao){
            if(e.getCodigo().equalsIgnoreCase(codigo)){
                UpdateExtensao updateExtensao = new UpdateExtensao();
                updateExtensao.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                updateExtensao.setVisible(true);
                updateExtensao.setExtensao(e);
                this.setVisible(false);
                exists = true;
                isEmpty = false;
                break;
            } 
        }
        
        showExistsCodigo(isEmpty, exists);
    }//GEN-LAST:event_btnAltExtentActionPerformed

    private void verPeriodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPeriodosActionPerformed
        
        for(Extensao e : Extensao.listaExtensao){
            if(e.getCodigo().equalsIgnoreCase(codigoExtensao)){
                ViewPeriodos viewPeriodos = new ViewPeriodos(e, false);
                viewPeriodos.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                viewPeriodos.setVisible(true);
                this.setVisible(false);
            } 
        }     
        
        showExistsCodigo(isEmpty, true);
    }//GEN-LAST:event_verPeriodosActionPerformed

    private void altGrad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altGrad2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_altGrad2ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewCursosExtensionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCursosExtensionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCursosExtensionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCursosExtensionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCursosExtensionFrame().setVisible(true);
            }
        });
    }
    
    private void jListItemClickEvent(JList dataList) {
        
        dataList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String value = dataList.getSelectedValue().toString();
                    if(value.contains("-")){
                        System.out.println("Valor: " + value);
                        codigoExtensao = value.
                                substring(value.indexOf(':') + 1, value.indexOf('-')).trim();    
                        System.out.println(codigoExtensao); 
                    } else {
                        codigoExtensao = "";
                        isEmpty = true;
                    }
                }
            }
        });  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton altGrad2;
    private javax.swing.JButton btnAltExtent;
    private javax.swing.JButton verPeriodos;
    // End of variables declaration//GEN-END:variables
}
