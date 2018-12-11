/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sool.*;

/**
 *
 * @author danih
 */
public class ViewCursosFrame extends javax.swing.JFrame {

    private int width = 620;
    private int height = 340;
    public String codigoGraduacao = "";
    public boolean isEmpty;
    
    public ViewCursosFrame() {
        
        initPanel();
        initComponents();
        showCursos();
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
        setTitle("Lista de Graduações");
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
    
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    
    public JList<String> showCursos(){
        
        DefaultListModel<String> model = new DefaultListModel<>();

        Graduacao.listaGraduacoes = new Arquivo().readGraduacao("graduacao");           
        
        if(Graduacao.listaGraduacoes.isEmpty()){
            model.addElement("NENHUM CURSO ADICIONADO NO SISTEMA!");
        } else {
            for(int i = 0; i < Graduacao.listaGraduacoes.size(); i++){
                model.addElement(
                        "CÓDIGO: " + Graduacao.listaGraduacoes.get(i).getCodigo().toUpperCase() + 
                        " - NOME: " + Graduacao.listaGraduacoes.get(i).getNome().toUpperCase() + 
                        " - TURNO: " + Graduacao.listaGraduacoes.get(i).getTurno().toUpperCase()
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
            "Código da Graduação não existe no Sistema!",
            "Confirmação",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);    
        } else if(exists == false && isEmpty == true) {
            JOptionPane.showOptionDialog(null,
            "Ainda não existe Graduações adicionadas ao Sistema!",
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

        altGrad = new javax.swing.JButton();
        verPer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        altGrad.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        altGrad.setForeground(new java.awt.Color(153, 0, 51));
        altGrad.setText("Alterar Graduação");
        altGrad.setBorder(new javax.swing.border.MatteBorder(null));
        altGrad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altGradActionPerformed(evt);
            }
        });

        verPer.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        verPer.setForeground(new java.awt.Color(153, 0, 51));
        verPer.setText("Ver Períodos");
        verPer.setBorder(new javax.swing.border.MatteBorder(null));
        verPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(verPer, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addComponent(altGrad, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addComponent(altGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verPer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void altGradActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altGradActionPerformed
        boolean exists = false;
        boolean isEmpty = false;

        String codigo = JOptionPane.showInputDialog(null, 
                "Digite o código da graduação que deseja alterar!", 
                        "Excluir", JOptionPane.YES_NO_CANCEL_OPTION).toString().trim();
        
        if(Graduacao.listaGraduacoes.isEmpty()){
            isEmpty = true;
        }
        
        for(Graduacao g : Graduacao.listaGraduacoes){
            if(g.getCodigo().equalsIgnoreCase(codigo)){
                UpdateGraduacao updateGraduacao = new UpdateGraduacao();
                updateGraduacao.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                updateGraduacao.setVisible(true);
                updateGraduacao.setGraduacao(g);
                this.setVisible(false);
                exists = true;
                isEmpty = false;
                break;
            } 
        }
        
        showExistsCodigo(isEmpty, exists);
        
    }//GEN-LAST:event_altGradActionPerformed

    private void verPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPerActionPerformed
        for(Graduacao g : Graduacao.listaGraduacoes){
            if(g.getCodigo().equalsIgnoreCase(codigoGraduacao)){
                ViewPeriodos viewPeriodos = new ViewPeriodos(g, true);
                viewPeriodos.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                viewPeriodos.setVisible(true);
                this.setVisible(false);
            } 
        }     
        
        showExistsCodigo(isEmpty, true);
    }//GEN-LAST:event_verPerActionPerformed

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
            java.util.logging.Logger.getLogger(ViewCursosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCursosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCursosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCursosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCursosFrame().setVisible(true);
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
                        codigoGraduacao = value.
                                substring(value.indexOf(':') + 1, value.indexOf('-')).trim();    
                        System.out.println(codigoGraduacao); 
                    } else {
                        codigoGraduacao = "";
                        isEmpty = true;
                    }
                }
            }
        });  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton altGrad;
    private javax.swing.JButton verPer;
    // End of variables declaration//GEN-END:variables
}
