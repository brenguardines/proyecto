package com.example.calculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplicacion {
    private JPanel root;
    private JPanel Botonera;
    private JPanel Cabecera;
    private JButton btnReset;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton btnPunto;
    private JButton a8Button;
    private JButton a9Button;
    private JButton btnDivision;
    private JButton a5Button;
    private JButton a6Button;
    private JButton btnProducto;
    private JButton a2Button;
    private JButton a3Button;
    private JButton btnResta;
    private JButton a0Button;
    private JButton btnIgual;
    private JButton btnSuma;
    private JLabel lblDisplay;

    public Aplicacion() {
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblDisplay.setText("");
            }
        });
        ActionListener listenerDigitos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = lblDisplay.getText() + ((JButton)e.getSource()).getText();
                lblDisplay.setText(texto);
            }
        };
        a7Button.addActionListener(listenerDigitos);
        a4Button.addActionListener(listenerDigitos);
        a1Button.addActionListener(listenerDigitos);
        btnPunto.addActionListener(listenerDigitos);
        a8Button.addActionListener(listenerDigitos);
        a9Button.addActionListener(listenerDigitos);
        a5Button.addActionListener(listenerDigitos);
        a6Button.addActionListener(listenerDigitos);
        a2Button.addActionListener(listenerDigitos);
        a3Button.addActionListener(listenerDigitos);
        a0Button.addActionListener(listenerDigitos);

        ActionListener listenerOperaciones = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = calcular(lblDisplay.getText());
                lblDisplay.setText(resultado);

                if(e.getSource() != btnIgual) {
                    String texto = lblDisplay.getText() + ((JButton) e.getSource()).getText();
                    lblDisplay.setText(texto);
                }
            }
        };
        btnDivision.addActionListener(listenerOperaciones);
        btnProducto.addActionListener(listenerOperaciones);
        btnResta.addActionListener(listenerOperaciones);
        btnSuma.addActionListener(listenerOperaciones);
        btnIgual.addActionListener(listenerOperaciones);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicacion");
        frame.setContentPane(new Aplicacion().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public String calcular (String operacion){
        String resultado;
        String[] ops = operacion.split("[]\\+\\-X\\/]");
        if(ops.length == 1){
            resultado = ops[0];
        } else{
            float v1 = Float.parseFloat(ops[0]);
            float v2 = Float.parseFloat(ops[1]);
            float r;
            if(operacion.contains("+"))
                r = v1 + v2;
            else if (operacion.contains("-"))
                r = v1 - v2;
            else if (operacion.contains("X"))
                r = v1 * v2;
            else r = v1/ v2;
            resultado = String.valueOf(r);
        }
        return resultado;
    }
}
