/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrames;

import static jFrames.ExtensaoFrame.isNumeric;
import static jFrames.ViewCursosFrame.centreWindow;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sool.*;

/**
 *
 * @author danih
 */
public class DisciplinaFrame extends javax.swing.JFrame {

    private Ciclo ciclo;
    private Curso curso;
    private Arquivo arquivo;
    
    public DisciplinaFrame(Ciclo ciclo, Curso curso) {
        this.ciclo = ciclo;
        this.curso = curso;
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
        
        for(Disciplina d : Disciplina.disciplinas){
            if(d.getCodigo().equalsIgnoreCase(codigo)){
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

        textCodigo = new javax.swing.JTextField();
        textCodigo5 = new javax.swing.JTextField();
        chooseTipo1 = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        textCod = new javax.swing.JTextField();
        textCargaHoraria = new javax.swing.JTextField();
        textCreditos = new javax.swing.JTextField();
        textCreditosMin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonAdicionarDis = new javax.swing.JButton();

        textCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigoActionPerformed(evt);
            }
        });

        textCodigo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigo5ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chooseTipo1.setBackground(new java.awt.Color(102, 102, 0));
        chooseTipo1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        chooseTipo1.setForeground(new java.awt.Color(153, 51, 0));
        chooseTipo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chooseTipo1.setText("Insira uma nova Disciplina");
        chooseTipo1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 171, 134)));

        textNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeActionPerformed(evt);
            }
        });

        textCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodActionPerformed(evt);
            }
        });

        textCargaHoraria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCargaHorariaActionPerformed(evt);
            }
        });

        textCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCreditosActionPerformed(evt);
            }
        });

        textCreditosMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCreditosMinActionPerformed(evt);
            }
        });

        jLabel1.setText("Código:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Carga Horária:");

        jLabel4.setText("Quantidade Créditos:");

        jLabel5.setText("Mínmo Créditos:");

        buttonAdicionarDis.setText("Adicionar");
        buttonAdicionarDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarDisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chooseTipo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonAdicionarDis, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textCod, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textCreditosMin, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(chooseTipo1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCreditosMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(buttonAdicionarDis, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigoActionPerformed

    private void textNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomeActionPerformed

    private void textCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodActionPerformed

    private void textCargaHorariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCargaHorariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCargaHorariaActionPerformed

    private void textCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCreditosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCreditosActionPerformed

    private void textCodigo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigo5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigo5ActionPerformed

    private void textCreditosMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCreditosMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCreditosMinActionPerformed

    private void buttonAdicionarDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarDisActionPerformed
        
        String codigo = textCod.getText().toString().trim();
        String nome = textNome.getText().toString().trim();
        String cargaHoraria = textCargaHoraria.getText().toString().trim();
        String creditos = textCreditos.getText().toString().trim();
        String creditosMin = textCreditosMin.getText().toString().trim();
        
        if(!codigo.isEmpty() && !nome.isEmpty() 
                && !creditos.isEmpty() && !cargaHoraria.isEmpty() && !creditosMin.isEmpty()){
            if(checkIfCodigoAlreadyExists(codigo)){
                if(showConfirmDialog("Insira um código que não exista no Sistema", "Alerta")
                            == JOptionPane.OK_OPTION){
                    textCodigo.setText("");    
                }
            } else {
                if(isNumeric(cargaHoraria) || isNumeric(creditos) || isNumeric(creditosMin)){
                    try {
                        new Disciplina(codigo, nome, Integer.parseInt(cargaHoraria),
                                Integer.parseInt(creditos), Integer.parseInt(creditosMin),
                                ciclo, curso);
                        arquivo.saveDisciplina("d", Disciplina.disciplinas);
                        if(showConfirmDialog("Disciplina adicionada com sucesso", "Alerta")
                                == JOptionPane.OK_OPTION){
                            textCod.setText("");
                            textNome.setText("");
                            textCargaHoraria.setText("");
                            textCreditos.setText("");
                            textCreditosMin.setText("");                      
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(DisciplinaFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if(showConfirmDialog("Digite valores numéricos", "Alerta")
                        == JOptionPane.OK_OPTION){
                        textCargaHoraria.setText("");    
                    }      
                }
            }            
        } else {
            showConfirmDialog("Preencha os cinco campos", "Alerta");
        }
        
    }//GEN-LAST:event_buttonAdicionarDisActionPerformed

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
            java.util.logging.Logger.getLogger(DisciplinaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisciplinaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisciplinaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisciplinaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarDis;
    private javax.swing.JLabel chooseTipo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField textCargaHoraria;
    private javax.swing.JTextField textCod;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textCodigo5;
    private javax.swing.JTextField textCreditos;
    private javax.swing.JTextField textCreditosMin;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}
