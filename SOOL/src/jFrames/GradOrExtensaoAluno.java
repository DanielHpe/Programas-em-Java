/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrames;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import sool.*;

public class GradOrExtensaoAluno extends javax.swing.JFrame {

    Object[] options = {"OK"};
    boolean isGraduacao = false;
    
    public GradOrExtensaoAluno() {
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
    
    public void adicionarAluno(Ciclo ciclo, Curso curso, Disciplina disciplina, Turma turma){
        AlunoFrame alunoFrame = new AlunoFrame(ciclo, curso, disciplina, turma);
        alunoFrame.setVisible(true);
        alunoFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(false);
    }
    
    public void procurarTurmaGraduacao(Ciclo ciclo, Curso curso, Disciplina disciplina){
        boolean existsTurma = false;
        boolean vazio = false;
        String codigoTurma = JOptionPane.showInputDialog(null, 
                "Digite o código da Turma!", 
                        "Alerta", JOptionPane.YES_NO_CANCEL_OPTION).toString().trim();
        
        TurmaGraduacao.turmas = new Arquivo().readTurmaGrad("tg");
        
        if(TurmaGraduacao.turmas.isEmpty()){
            JOptionPane.showOptionDialog(null,
            "Sem turmas para essa disciplina!",
            "Confirmação",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);
            vazio = true;
        }
        
        for(TurmaGraduacao t : TurmaGraduacao.turmas){
            if(t.getDisciplina().getCodigo().equalsIgnoreCase(disciplina.getCodigo()) 
                    && t.getCiclo().getDescTema().equals(ciclo.getDescTema())
                    && t.getCurso().getCodigo().equals(curso.getCodigo()) && 
                    t.getCodSequencia() == Integer.parseInt(codigoTurma)){
                adicionarAluno(ciclo, curso, disciplina, t);
                existsTurma = true;
                break;
            }
        }
        
        if(existsTurma == false && vazio == false){
            JOptionPane.showOptionDialog(null,
                "Código da turma não existe!",
                "Confirmação",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        }
    }
    
    public void procurarTurmaExtensao(Ciclo ciclo, Curso curso, Disciplina disciplina){
        
        boolean existsTurma = false;
        boolean vazio = false;
        String codigoTurma = JOptionPane.showInputDialog(null, 
                "Digite o código da Turma!", 
                        "Alerta", JOptionPane.YES_NO_CANCEL_OPTION).toString().trim();
        
        TurmaExtensao.turmaExtensoes = new Arquivo().readTurmaExtensao("te");
        
        if(TurmaExtensao.turmaExtensoes.isEmpty()){
            JOptionPane.showOptionDialog(null,
            "Sem turmas para essa disciplina!",
            "Confirmação",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);
            vazio = true;
        }
        
        for(TurmaExtensao t : TurmaExtensao.turmaExtensoes){
            if(t.getD().getCodigo().equalsIgnoreCase(disciplina.getCodigo()) 
                    && t.getCl().getDescTema().equalsIgnoreCase(ciclo.getDescTema())
                    && t.getC().getCodigo().equalsIgnoreCase(curso.getCodigo()) && 
                    t.getCodSequencia() == Integer.parseInt(codigoTurma)){
                adicionarAluno(ciclo, curso, disciplina, t);
                existsTurma = true;
                break;
            }
        }
        
        if(existsTurma == false && vazio == false){
            JOptionPane.showOptionDialog(null,
                "Código da turma não existe!",
                "Confirmação",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        }
        
    }
    
    public void digitarTurma(Ciclo ciclo, Curso curso, Disciplina disciplina){
        
        if(isGraduacao){
            procurarTurmaGraduacao(ciclo, curso, disciplina);
        } else {
            procurarTurmaExtensao(ciclo, curso, disciplina);
        }
 
    }
    
    public void digitarDisciplina(Ciclo ciclo, Curso curso){
        
        boolean existsDisciplina = false;
        boolean vazio = false;
        String codigoDisciplina = JOptionPane.showInputDialog(null, 
                "Digite o código da Disciplina!", 
                        "Alerta", JOptionPane.YES_NO_CANCEL_OPTION).toString().trim();
        
        Disciplina.disciplinas = new Arquivo().readDisciplinas("d");
        
        if(Disciplina.disciplinas.isEmpty()){
            JOptionPane.showOptionDialog(null,
            "Sem disciplinas para esse período!",
            "Confirmação",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);
            vazio = true;
        }
        
        for(Disciplina d : Disciplina.disciplinas){
            if(d.getCiclo().getDescTema().equalsIgnoreCase(ciclo.getDescTema())
                    && d.getCurso().getCodigo().equalsIgnoreCase(curso.getCodigo()) && 
                     d.getCodigo().equalsIgnoreCase(codigoDisciplina)){
                 digitarTurma(ciclo, curso, d);
                 existsDisciplina = true;
                 break;
             }
        }
        
        if(existsDisciplina == false && vazio == false){
            JOptionPane.showOptionDialog(null,
                "Código da disciplina não existe!",
                "Confirmação",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        }
        
    }
    
    public void digitarPeriodo(Curso curso){
        
        boolean existsPeriodo = false;
        boolean vazio = false;
        String periodo = JOptionPane.showInputDialog(null, 
                "Digite o periodo!", 
                        "Alerta", JOptionPane.YES_NO_CANCEL_OPTION).toString().trim();
        
        Ciclo.listCiclos = new Arquivo().readPeriodo("periodo");
        
        if(Ciclo.listCiclos.isEmpty()){
            JOptionPane.showOptionDialog(null,
            "Sem períodos para essa graduação.!",
            "Confirmação",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);
            vazio = true;
        }
        
        for(Ciclo cl: Ciclo.listCiclos){
            if(cl.getCurso().getCodigo().equalsIgnoreCase(curso.getCodigo()) 
                    && cl.getDescTema().equalsIgnoreCase(periodo)){
                digitarDisciplina(cl, curso);
                existsPeriodo = true;
                break;
            } 
        }
        
        if(existsPeriodo == false && vazio == false){
            JOptionPane.showOptionDialog(null,
                "Período digitado não existe!",
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

        chooseTipo = new javax.swing.JLabel();
        btnExtensao = new javax.swing.JButton();
        btnGraduacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chooseTipo.setBackground(new java.awt.Color(102, 102, 0));
        chooseTipo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        chooseTipo.setForeground(new java.awt.Color(153, 51, 0));
        chooseTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chooseTipo.setText("Escolha um tipo");
        chooseTipo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 171, 134)));

        btnExtensao.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnExtensao.setForeground(new java.awt.Color(153, 0, 51));
        btnExtensao.setText("Extensão");
        btnExtensao.setBorder(new javax.swing.border.MatteBorder(null));
        btnExtensao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtensaoActionPerformed(evt);
            }
        });

        btnGraduacao.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnGraduacao.setForeground(new java.awt.Color(153, 0, 51));
        btnGraduacao.setText("Graduação");
        btnGraduacao.setBorder(new javax.swing.border.MatteBorder(null));
        btnGraduacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraduacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooseTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(btnExtensao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnGraduacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chooseTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnExtensao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(79, Short.MAX_VALUE)
                    .addComponent(btnGraduacao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(60, 60, 60)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExtensaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtensaoActionPerformed
        
        boolean existsExten = false;
        boolean vazio = false;
        
        String codigo = JOptionPane.showInputDialog(null, 
                "Digite o código do curso de Extensão!", 
                        "Alerta", JOptionPane.YES_NO_CANCEL_OPTION).toString().trim();
        
        Extensao.listaExtensao = new Arquivo().readExtensao("extensao");
        
        if(Extensao.listaExtensao.isEmpty()){
            JOptionPane.showOptionDialog(null,
            "Sem Curso de Extensão com esse código!",
            "Confirmação",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);
            vazio = true;
        }
        
        for(Extensao e : Extensao.listaExtensao){
            if(e.getCodigo().equalsIgnoreCase(codigo)){
                isGraduacao = false;
                digitarPeriodo(e);
                existsExten = true;
                vazio = false;
                break;
            } 
        }
        
        if(existsExten == false && vazio == false){
            JOptionPane.showOptionDialog(null,
                "Curso de Extensão digitado não existe!",
                "Confirmação",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        }       
    }//GEN-LAST:event_btnExtensaoActionPerformed

    private void btnGraduacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraduacaoActionPerformed
        
        boolean existsGrad = false;
        boolean vazio = false;

        String codigo = JOptionPane.showInputDialog(null,
            "Digite o código da graduação!",
            "Alerta", JOptionPane.YES_NO_CANCEL_OPTION).toString().trim();
        
        Graduacao.listaGraduacoes = new Arquivo().readGraduacao("graduacao");

        if(Graduacao.listaGraduacoes.isEmpty()){
            JOptionPane.showOptionDialog(null,
                "Sem graduação adicionadas!",
                "Confirmação",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
            vazio = true;
        }

        for(Graduacao g : Graduacao.listaGraduacoes){
            if(g.getCodigo().equalsIgnoreCase(codigo)){
                isGraduacao = true;
                digitarPeriodo(g);
                existsGrad = true;
                vazio = false;
                break;
            }
        }

        if(existsGrad == false && vazio == false){
            JOptionPane.showOptionDialog(null,
                "Graduação digitada não existe!",
                "Confirmação",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        }
    }//GEN-LAST:event_btnGraduacaoActionPerformed

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
            java.util.logging.Logger.getLogger(GradOrExtensaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradOrExtensaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradOrExtensaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradOrExtensaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradOrExtensaoAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExtensao;
    private javax.swing.JButton btnGraduacao;
    private javax.swing.JLabel chooseTipo;
    // End of variables declaration//GEN-END:variables
}
