/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrames;

import com.sun.xml.internal.ws.util.StringUtils;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.NumberFormatter;
import sool.*;

/**
 *
 * @author danih
 */
public class ExtensaoFrame extends javax.swing.JFrame {

    private Arquivo arquivo;
    
    public ExtensaoFrame() {
        this.arquivo = new Arquivo();
        initComponents();
        centreWindow(this);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) { 
                new SOOL().setVisible(true);
            }
        });
    }
    
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    
    public boolean checkIfCodigoAlreadyExists(String codigo){
        
        for(Graduacao g : arquivo.readGraduacao("graduacao")){
            if(g.getCodigo().equalsIgnoreCase(codigo)){
                return true;
            }
        }
        
        for(Extensao e: arquivo.readExtensao("extensao")){
            if(e.getCodigo().equalsIgnoreCase(codigo)){
                return true;
            }
        }
        
        return false;
        
    }
    
    public static boolean isNumeric(String str){
        for (char c : str.toCharArray()){
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    
    public int showConfirmDialog(String message, String title){
       
        Object[] options = {"OK"};
        int n = 0;
        
        n = JOptionPane.showOptionDialog(null,
            message, 
            title,
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]); 
        
        return n;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addGrad = new javax.swing.JButton();
        chooseTipo1 = new javax.swing.JLabel();
        textTurno = new javax.swing.JTextField();
        textCodigo = new javax.swing.JTextField();
        textCargaHoraria = new javax.swing.JTextField();
        textNome = new javax.swing.JTextField();
        addExtension = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        addGrad.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        addGrad.setForeground(new java.awt.Color(153, 0, 51));
        addGrad.setText("Adicionar Graduação");
        addGrad.setBorder(new javax.swing.border.MatteBorder(null));
        addGrad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGradActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chooseTipo1.setBackground(new java.awt.Color(102, 102, 0));
        chooseTipo1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        chooseTipo1.setForeground(new java.awt.Color(153, 51, 0));
        chooseTipo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chooseTipo1.setText("Adicione um novo curso de extensão");
        chooseTipo1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 171, 134)));

        textTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTurnoActionPerformed(evt);
            }
        });

        textCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigoActionPerformed(evt);
            }
        });

        textCargaHoraria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCargaHorariaActionPerformed(evt);
            }
        });

        textNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeActionPerformed(evt);
            }
        });

        addExtension.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        addExtension.setForeground(new java.awt.Color(153, 0, 51));
        addExtension.setText("Adicionar Extensão");
        addExtension.setBorder(new javax.swing.border.MatteBorder(null));
        addExtension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExtensionActionPerformed(evt);
            }
        });

        jLabel1.setText("Código:");

        jLabel2.setText("Turno:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Carga Horária:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chooseTipo1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textTurno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textCargaHoraria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(addExtension, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chooseTipo1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(addExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTurnoActionPerformed

    private void textCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigoActionPerformed

    private void textCargaHorariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCargaHorariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCargaHorariaActionPerformed

    private void textNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomeActionPerformed

    private void addGradActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGradActionPerformed

    }//GEN-LAST:event_addGradActionPerformed

    private void addExtensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExtensionActionPerformed

        String codigo = textCodigo.getText().toString().trim();
        String nome = textNome.getText().toString().trim();
        String turno = textTurno.getText().toString().trim();
        String cargaHoraria = textCargaHoraria.getText().toString().trim();

        if(!codigo.isEmpty() && !nome.isEmpty() 
                && !turno.isEmpty() && !cargaHoraria.isEmpty()){
            if(checkIfCodigoAlreadyExists(codigo)){
                if(showConfirmDialog("Insira um código que não exista no Sistema", "Alerta")
                            == JOptionPane.OK_OPTION){
                    new GraduacaoFrame();
                    textCodigo.setText("");    
                }
            } else {
                if(isNumeric(cargaHoraria)){
                    try {
                        new Extensao(codigo, nome, turno, Integer.parseInt(cargaHoraria));
                        arquivo.saveExtensao("extensao", Extensao.listaExtensao);
                        if(showConfirmDialog("Extensão adicionada com sucesso", "Alerta")
                                == JOptionPane.OK_OPTION){
                            new ExtensaoFrame();
                            textCodigo.setText("");
                            textNome.setText("");
                            textTurno.setText("");
                            textCargaHoraria.setText("");                      
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    if(showConfirmDialog("Insira um valor numérico em carga horária", "Alerta")
                        == JOptionPane.OK_OPTION){
                        new GraduacaoFrame();
                        textCargaHoraria.setText("");    
                    }      
                }
            }            
        } else {
            showConfirmDialog("Preencha os quatro campos", "Alerta");
        }
    }//GEN-LAST:event_addExtensionActionPerformed

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
            java.util.logging.Logger.getLogger(ExtensaoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExtensaoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExtensaoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExtensaoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExtensaoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addExtension;
    private javax.swing.JButton addGrad;
    private javax.swing.JLabel chooseTipo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField textCargaHoraria;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textTurno;
    // End of variables declaration//GEN-END:variables

    private void initMascaraCargaHoraria() {
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);
        textCargaHoraria = new JFormattedTextField(formatter); 
    }
}
