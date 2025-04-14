/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author René Rodríguez Martínez
 */
public class Inicio extends javax.swing.JFrame {

   
    
    //lista con las rutas de todas las cartas
    private ArrayList<String> cartas ;
    //cantidad de cartas en la carpeta
    private final int CANTIDAD_DE_CARTAS=22; 
    //objeto random con el que vamos a randomizar sacar cartas aleatorias
    private Random random;
    //para saber si se ha revelado la carta antes para dar la vuelta a la carta
    private Boolean reverso;
    
    public Inicio() {
        initComponents();
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/tarot_cover_red.png")));
        jLabel2.setIcon(new ImageIcon(getClass().getResource("/img/tapete.png")));       
        cartas = new ArrayList<>();
        random=new Random();
        reverso=true;
        cargarCartas();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setName(""); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(230, 356));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));

        jLabel2.setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        mostrarCarta();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    
    //metodo que añade las rutas de las imagenes al arraylist
    private void cargarCartas() {
         for (int i = 1; i <= CANTIDAD_DE_CARTAS; i++) {
            cartas.add("/img-cartas/" + i + ".png");
        }
    }
    
   private void mostrarCarta() {
    String ruta;   
    if (reverso) {
        int i = random.nextInt(cartas.size());
        ruta = cartas.get(i);

        ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
        
        // 50% de probabilidad de mostrarla al revés
        if (random.nextBoolean()) {
            Image img = icon.getImage();
            BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bi.createGraphics();
            g2d.rotate(Math.toRadians(180), icon.getIconWidth() / 2.0, icon.getIconHeight() / 2.0);
            g2d.drawImage(img, 0, 0, null);
            g2d.dispose();
            icon = new ImageIcon(bi);
        }

        jLabel1.setIcon(icon);
        reverso = false;
    } else {
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/tarot_cover_red.png")));
        reverso = true;
    }
}

 
}
