/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrames;

import static jFrames.TurmasFrame.centreWindow;
import static jFrames.TurmasFrame.isNumeric;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sool.*;

public class TurmaExtensaoFrame extends javax.swing.JFrame {
    
    public Ciclo ciclo;
    public Curso curso;
    public Disciplina disciplina;
    private Arquivo arquivo;

    public TurmaExtensaoFrame(Ciclo cl, Curso c, Disciplina d) {
        this.arquivo = new Arquivo();
        initAtributes(cl, c, d);
        initComponents();
        centreWindow(this);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) { 
                new SOOL().setVisible(true);
            }
        });
    }
                
    public boolean checkIfCodigoAlreadyExists(String codigo){
        
        for(TurmaGraduacao tg : arquivo.readTurmaGrad("tg")){
            if(tg.getCodSequencia() == Integer.parseInt(codigo)){
                return true;
            }
        }
        
        for(TurmaExtensao te : arquivo.readTurmaExtensao("te")) {
            if(te.getCodSequencia() == Integer.parseInt(codigo)){
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
    
    public void initAtributes(Ciclo cl, Curso c, Disciplina d){
        this.ciclo = cl;
        this.curso = c;
        this.disciplina = d;    
    }
    
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
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

        chooseTipo1 = new javax.swing.JLabel();
        textCodTurma = new javax.swing.JTextField();
        textDataInicio = new javax.swing.JTextField();
        textDataFim = new javax.swing.JTextField();
        btnAdicionarTurma = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chooseTipo1.setBackground(new java.awt.Color(102, 102, 0));
        chooseTipo1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        chooseTipo1.setForeground(new java.awt.Color(153, 51, 0));
        chooseTipo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chooseTipo1.setText("Insira uma nova Tuma de Extensão");
        chooseTipo1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 171, 134)));

        textCodTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodTurmaActionPerformed(evt);
            }
        });

        textDataInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataInicioActionPerformed(evt);
            }
        });

        textDataFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataFimActionPerformed(evt);
            }
        });

        btnAdicionarTurma.setText("Adicionar Turma");
        btnAdicionarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarTurmaActionPerformed(evt);
            }
        });

        jLabel1.setText("Código Turma:");

        jLabel2.setText("Data Início:");

        jLabel3.setText("Data Fim:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCodTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooseTipo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdicionarTurma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chooseTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCodTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdicionarTurma, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textCodTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodTurmaActionPerformed

    private void textDataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataInicioActionPerformed

    private void textDataFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataFimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataFimActionPerformed

    private void btnAdicionarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarTurmaActionPerformed

        String codTurma = textCodTurma.getText().toString().trim();
        String dataInicio = textDataInicio.getText().toString().trim();
        String dataFim = textDataFim.getText().toString().trim();
        
        if(!codTurma.isEmpty() && !dataInicio.isEmpty()
                && !dataFim.isEmpty()){
            if(checkIfCodigoAlreadyExists(codTurma)){
                if(showConfirmDialog("Insira um código que não exista no Sistema", "Alerta")
                                == JOptionPane.OK_OPTION){
                    textCodTurma.setText("");    
                }    
            } else {
                if(isNumeric(codTurma)){
                    try {
                        new TurmaExtensao(Integer.parseInt(codTurma), dataInicio, dataFim,
                                ciclo, curso, disciplina);
                        arquivo.saveTurmaExtensao("te", TurmaExtensao.turmaExtensoes);
                        if(showConfirmDialog("Curso de Extensão adicionado com sucesso", "Alerta")
                                == JOptionPane.OK_OPTION){
                            textCodTurma.setText("");
                            textDataInicio.setText("");
                            textDataFim.setText("");  
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(TurmaExtensaoFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if(showConfirmDialog("Código deve ser numérico", "Alerta")
                        == JOptionPane.OK_OPTION){
                        textCodTurma.setText("");    
                        textDataFim.setText("");
                        textDataInicio.setText("");
                    }  
                }    
                
            }
        } else {
            showConfirmDialog("Preencha todos os campos!", "Alerta");
        }
        
    }//GEN-LAST:event_btnAdicionarTurmaActionPerformed

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
            java.util.logging.Logger.getLogger(TurmaExtensaoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TurmaExtensaoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TurmaExtensaoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TurmaExtensaoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarTurma;
    private javax.swing.JLabel chooseTipo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField textCodTurma;
    private javax.swing.JTextField textDataFim;
    private javax.swing.JTextField textDataInicio;
    // End of variables declaration//GEN-END:variables
}