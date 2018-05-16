/*
 * Teoria de la Informacion - 2018
 */
package frames;

import java.util.Collections;
import java.util.List;
import teoriadelainformaciontpe.BmpHelper;
import teoriadelainformaciontpe.BmpImage;

/**
 *
 * @author ileitao
 * @author ldiez
 */
public class Ejercicio1 extends javax.swing.JDialog {

    private List<BmpImage> images;
    private BmpImage original;
    
    /**
     * Creates new form Ejercicio1
     */
    public Ejercicio1(java.awt.Frame parent, boolean modal, List<BmpImage> images, BmpImage original) {
        super(parent, modal);
        initComponents();
        this.setTitle("Cáculo de Factor de Correlación");
        this.images = images;
        this.original = original;
        doExercise();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void doExercise() {
        // La comparacion con el factor de correlación se hace tono con tono
        // Entre la imagen original y la que estas comparando
        // La fórmula <ab>-<a><b> 
        // A es el tono del pixel de la imagen A y b el de la imagen B
        // Entre <> son medias y es la sumatoria de los píxeles de la imagen
        jTextArea1.setText("SIN ORDEN:");

        /*for (int i = 0; i < images.size(); i++) {
            System.out.println(images.get(i).getName());
        }*/
        // Imprimir sin orden, factor de correlación y nombre de la imagen 
        for (int i = 0; i < images.size(); i++) {
            images.get(i).setCorrelationFactor(BmpHelper.getCorrelationFactor(original, images.get(i)));
            jTextArea1.setText(jTextArea1.getText() + "\n " + images.get(i).getName() + " --  " +  images.get(i).getCorrelationFactor());
        }

        jTextArea1.setText(jTextArea1.getText() + "\n " + "---------------------------------------------");
        jTextArea1.setText(jTextArea1.getText() + "\n " + "CON ORDEN:");

        Collections.sort(images); // obtengo la lista ordenada
        // Imprimo ordenado el factor de correlación y el nombre de la imagen correspondiente
        for (int i = 0; i < images.size(); i++) {
            jTextArea1.setText(jTextArea1.getText() + "\n " + images.get(i).getName() + "  --  " + images.get(i).getCorrelationFactor() );
        }
        jScrollPane1.setVisible(true);
        jTextArea1.setVisible(true);
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

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}