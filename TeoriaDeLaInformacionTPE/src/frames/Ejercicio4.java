/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;
import teoriadelainformaciontpe.BmpHelper;
import teoriadelainformaciontpe.BmpImage;
import teoriadelainformaciontpe.Encoder;
import teoriadelainformaciontpe.Huffman;

/**
 *
 * @author Diez, Lautaro
 */
public class Ejercicio4 extends javax.swing.JDialog {

    /**
     * Creates new form Ejercicio4  
     */
    public Ejercicio4(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Codificación de Huffman");
        setLocationRelativeTo(null);
        setVisible(true);
        File file = new File("Images/Will/Will(Original).bmp"); 
        BmpImage image =new BmpImage(BmpHelper.readBmpImage("Images/Will/Will(Original).bmp"), "Original");
        long originalSize = file.length();
        long compressedSize = new Encoder(image).getCompressedSize();
        
        Map<Integer, String> codification = new Huffman(image).doCodification();
        if (codification != null) {
            jTextArea1.setText("Símbolo : Codificación");
            for (Integer i : codification.keySet()) {
                jTextArea1.setText(jTextArea1.getText() + "\n" + i + " : " + codification.get(i));
            }
            jTextArea1.setText(jTextArea1.getText() + "\n\nPara este caso, la tasa de compresión fue " + originalSize + "/" + compressedSize + ": 1, casi 1,3:1");

        } else {
            jTextArea1.setText("No se pudo codificar la imagen");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}