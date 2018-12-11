/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrames;

import static jFrames.ViewPeriodos.centreWindow;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sool.*;

/**
 *
 * @author danih
 */
public class ViewTurmas extends javax.swing.JFrame {

    public Ciclo ciclo;
    public Curso curso;
    public Disciplina disciplina;
    private int width = 620;
    private int height = 340;
    public String codTurma = "";
    boolean isEmpty = false;
    boolean isGraduacao;
    
    public ViewTurmas(Ciclo ciclo, Curso curso,  Disciplina disciplina, boolean isGraduacao){
        this.ciclo = ciclo;
        this.curso = curso;
        this.disciplina = disciplina;
        this.isGraduacao = isGraduacao;
        initPanel();
        initComponents();
        showTurmas();
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
        setTitle("Lista de Turmas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(new JScrollPane(showTurmas()), BorderLayout.CENTER);
        return panel;
    }
    
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    
    public JList<String> showTurmas(){
        
        DefaultListModel<String> model = new DefaultListModel<>();
        
        System.out.println("Curso passado (Turma): " + curso.getNome());
        System.out.println("Ciclo passado: (Turma) " + ciclo.getDescTema());
        System.out.println("Disciplina passada: (Turma) " + disciplina.getNome());
        
        TurmaGraduacao.turmas = new Arquivo().readTurmaGrad("tg");
        TurmaExtensao.turmaExtensoes = new Arquivo().readTurmaExtensao("te");
        
        System.out.println("TAMANHO TURMA GRAD (TURMA): " + TurmaGraduacao.turmas.size());
        System.out.println("TAMANHO TURMA EXT (TURMA): " + TurmaExtensao.turmaExtensoes.size());
        System.out.println("É graduação? " + isGraduacao);
        
        if(TurmaGraduacao.turmas.isEmpty() && TurmaExtensao.turmaExtensoes.isEmpty()){
            model.addElement("NENHUMA TURMA PARA ESTA DISCIPLINA!");
        } else {
            if(isGraduacao){
                for(int i = 0; i < TurmaGraduacao.turmas.size(); i++){
                    if(TurmaGraduacao.turmas.get(i).getDisciplina()
                            .getCodigo().equalsIgnoreCase(disciplina.getCodigo())
                            && TurmaGraduacao.turmas.get(i).getCiclo()
                                    .getDescTema().equalsIgnoreCase(ciclo.getDescTema())
                            && TurmaGraduacao.turmas.get(i).getCurso()
                                    .getCodigo().equalsIgnoreCase(curso.getCodigo())){
                            model.addElement(
                                "CÓDIGO TURMA: " 
                                        + String.valueOf(TurmaGraduacao.turmas.get(i)
                                                .getCodSequencia()).toUpperCase()  +
                                 " | SEMESTRE: " + 
                                        String.valueOf(TurmaGraduacao.turmas
                                                .get(i).getSemestre()).toUpperCase() + 
                                    " | ANO: " +
                                        String.valueOf(TurmaGraduacao.turmas
                                                .get(i).getAno()).toUpperCase()
                            );     
                    }   
                } 
            } else {   
                for(int i = 0; i < TurmaExtensao.turmaExtensoes.size(); i++){
                    if(TurmaExtensao.turmaExtensoes.get(i)
                            .getD().getCodigo().equalsIgnoreCase(disciplina.getCodigo())
                        && TurmaExtensao.turmaExtensoes.get(i)
                                .getCl().getDescTema().equalsIgnoreCase(ciclo.getDescTema())
                        && TurmaExtensao.turmaExtensoes.get(i)
                                .getC().getCodigo().equalsIgnoreCase(curso.getCodigo())){
                        model.addElement(
                            "CÓDIGO TURMA: " 
                             + String.valueOf(TurmaExtensao.turmaExtensoes.get(i).
                                     getCodSequencia()).toUpperCase() +
                             " | DATA INÍCIO: " 
                                    + String.valueOf(TurmaExtensao.turmaExtensoes.get(i)
                                            .getDataInicio()).toUpperCase()  + 
                                " | DATA FIM: " 
                                    + String.valueOf(TurmaExtensao.turmaExtensoes.get(i)
                                            .getDataFim()).toUpperCase()
                        );     
                    }  
                }
            } 
        }
        
        JList<String> list = new JList<String>(model); 
        
        list.setFont(new Font("Arial", Font.BOLD, 16));
        
        jListItemClickEvent(list);
               
        return list;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewEstudantes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        viewEstudantes.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        viewEstudantes.setForeground(new java.awt.Color(153, 0, 51));
        viewEstudantes.setText("Ver Alunos");
        viewEstudantes.setBorder(new javax.swing.border.MatteBorder(null));
        viewEstudantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEstudantesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewEstudantes, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(289, Short.MAX_VALUE)
                .addComponent(viewEstudantes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void percorreGraduacao(){
        
        for(int i = 0; i < TurmaGraduacao.turmas.size(); i++){
            if(TurmaGraduacao.turmas.get(i).getDisciplina()
                    .getCodigo().equalsIgnoreCase(disciplina.getCodigo())
                    && TurmaGraduacao.turmas.get(i).getCiclo()
                            .getDescTema().equalsIgnoreCase(ciclo.getDescTema())
                    && TurmaGraduacao.turmas.get(i).getCurso()
                            .getCodigo().equals(curso.getCodigo())
                    && TurmaGraduacao.turmas.get(i).getCodSequencia() == Integer.parseInt(codTurma)){
                ViewAlunos viewAlunos = new ViewAlunos(
                        TurmaGraduacao.turmas.get(i).getCiclo(), 
                        TurmaGraduacao.turmas.get(i).getCurso(), 
                        TurmaGraduacao.turmas.get(i).getDisciplina(),
                        TurmaGraduacao.turmas.get(i));
                viewAlunos.setVisible(true);
                viewAlunos.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                this.setVisible(false);
                System.out.println("-------------------------------------");
                System.out.println("Nome do Curso: " + TurmaGraduacao.turmas.get(i).getCurso().getNome());
                System.out.println("Ciclo da Disciplina: " + 
                        TurmaGraduacao.turmas.get(i).getCiclo().getDescTema());
                System.out.println("Nome da Disciplina: " 
                        + TurmaGraduacao.turmas.get(i).getDisciplina().getNome());
                System.out.println("Turma da Disciplina: " + 
                        TurmaGraduacao.turmas.get(i).getCodSequencia());
                break;
            }
        }    
    }
    
    public void percorreExtensao(){
        for(int i = 0; i < TurmaExtensao.turmaExtensoes.size(); i++){
            if(TurmaExtensao.turmaExtensoes.get(i).getD().
                    getCodigo().equalsIgnoreCase(disciplina.getCodigo())
                    && TurmaExtensao.turmaExtensoes.get(i).getCl().
                            getDescTema().equalsIgnoreCase(ciclo.getDescTema())
                    && TurmaExtensao.turmaExtensoes.get(i).getC()
                            .getCodigo().equalsIgnoreCase(curso.getCodigo())
                    && TurmaExtensao.turmaExtensoes.get(i).getCodSequencia() 
                    == Integer.parseInt(codTurma)){
                ViewAlunos viewAlunos = new ViewAlunos(
                        TurmaExtensao.turmaExtensoes.get(i).getCl(), 
                        TurmaExtensao.turmaExtensoes.get(i).getC(), 
                        TurmaExtensao.turmaExtensoes.get(i).getD(),
                        TurmaExtensao.turmaExtensoes.get(i));
                viewAlunos.setVisible(true);
                viewAlunos.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                this.setVisible(false);
                System.out.println("-------------------------------------");
                System.out.println("Nome do Curso: " + 
                        TurmaExtensao.turmaExtensoes.get(i).getC().getNome());
                System.out.println("Ciclo da Disciplina: " + 
                        TurmaExtensao.turmaExtensoes.get(i).getCl().getDescTema());
                System.out.println("Nome da Disciplina: " 
                        + TurmaExtensao.turmaExtensoes.get(i).getD().getNome());
                System.out.println("Turma da Disciplina: " + 
                        TurmaExtensao.turmaExtensoes.get(i).getCodSequencia());
                break;
            }
        }    
    }
    
    private void viewEstudantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewEstudantesActionPerformed
        
        if(isGraduacao){
            
            percorreGraduacao();
            
        } else {
            
            percorreExtensao();
        }
    }//GEN-LAST:event_viewEstudantesActionPerformed

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
            java.util.logging.Logger.getLogger(ViewTurmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTurmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTurmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTurmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
    }
    
    private void jListItemClickEvent(JList dataList) {  
        dataList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String value = dataList.getSelectedValue().toString() + " ";
                if(value.contains(":")){
                    codTurma = value
                            .substring(value.indexOf(':') + 1, value.indexOf('|')).trim();    
                    System.out.println("Código da Turma: " + codTurma); 
                } else {
                    codTurma = "";
                    isEmpty = true;
                }
                
            }
        });   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton viewEstudantes;
    // End of variables declaration//GEN-END:variables
}
