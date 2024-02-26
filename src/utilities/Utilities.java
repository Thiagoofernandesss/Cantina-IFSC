/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class Utilities {

    public static void ativa(boolean ativa, JPanel painel) {

        Component[] componentes = painel.getComponents();

        for (Component componente : componentes) {

            if (componente instanceof JButton) {
                if (((JButton) componente).getActionCommand() == "0") {
                    componente.setEnabled(ativa);
                } else {
                    componente.setEnabled(!ativa);
                }
            }

        }
    }
    
    

    public static void limpaComponentes(boolean ativa, JPanel painel) {
        Component[] componentes = painel.getComponents();
        for (Component componente : componentes) {

            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            } else if (componente instanceof JFormattedTextField) {
                ((JFormattedTextField) componente).setText("");
            } else if(componente instanceof JComboBox){
                ((JComboBox) componente).setSelectedIndex(-1);
            } else if (componente instanceof JTextArea){
                ((JTextArea)componente).setText("");
            } else if (componente instanceof JRadioButton){
                ((JRadioButton) componente).setSelected(ativa);
            } else if(componente instanceof JCheckBox){
                ((JCheckBox) componente).setSelected((false));
            }
            componente.setEnabled(ativa);
        }

    }
    
    public static java.sql.Date stringToDate(String data){
        
        java.sql.Date dataSQL = null;

        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = sdf.parse(data);
            
            dataSQL = new java.sql.Date(utilDate.getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return dataSQL;
        
    }
    
    
    public static boolean isDataEmpty(JTextField... campos){
        
        boolean verify = false;
        for (JTextField campo : campos) {
            
            if(campo.getText().equals("")||campo.getBackground().equals(new Color(248,199,197))){
              campo.setBackground(new Color(248,199,197));
              campo.setText("*Campo obrigatório*");
              verify=true;
            }
        }   
        return verify;
    }
    
    
    
    public static boolean isFormattedDataEmpty(JFormattedTextField... campos){
        
        boolean verify = false;
        for (JFormattedTextField campo : campos) {
            
            
            if(campo.getValue()==null||campo.getBackground().equals(new Color(248,199,197))){
              campo.setBackground(new Color(248,199,197));
              campo.setText("*Campo obrigatório*");
              verify=true;
            }
        }   
        return verify;
    }
public static void turnTextFieldRed(JTextField textField){
       if(textField.getText().trim().isEmpty()){
           Color corErro = new Color(248,199,197); 
           textField.setText("*Campo obrigatório*");
           textField.setBackground(corErro);
       }
       
       
    }
    public static void turnTextFieldGray(JTextField textField){
        Color corErro = new Color(255,255,255);
        if(textField.getText().equalsIgnoreCase("*Campo obrigatório*")){
                    textField.setText(null);

        }
        textField.setBackground(corErro);   
       
    }
    
    public static void turnCepTextFieldRed(JFormattedTextField textField){
        
        String maskString=textField.getText();
        
       if(textField.getValue()==null){
           Color corErro = new Color(248,199,197); 
           textField.setText("*Campo obrigatório*");
           textField.setBackground(corErro);
       }
       
    }
    public static void turnCepTextFieldGray(JFormattedTextField textField){
        
        
        Color corErro = new Color(255,255,255);
        if(textField.getText().equalsIgnoreCase("*Campo obrigatório*")){
            textField.setValue(null);
        }
        textField.setBackground(corErro);   
        
    }
    
    public static void turnCpfTextFieldRed(JFormattedTextField textField){
        String maskString=textField.getText();
        
       if(textField.getValue()==null){
           Color corErro = new Color(248,199,197); 
           textField.setText("*Campo obrigatório*");
           textField.setBackground(corErro);
       }
       
    }
    public static void turnDateTextFieldGray(JFormattedTextField textField){
       Color corErro = new Color(255,255,255); 
       if(textField.getText().equalsIgnoreCase("*Campo obrigatório*")){
                    textField.setValue(null);

        }
       textField.setBackground(corErro);
    }
    
    public static void turnPhoneTextFieldRed(JFormattedTextField textField){
       if(textField.getText().trim().isEmpty()){
           Color corErro = new Color(248,199,197); 
           textField.setText("*Campo obrigatório*");
           textField.setBackground(corErro);
       }
       
    }
    public static void turnPhoneTextFieldGray(JFormattedTextField textField){
       Color corErro = new Color(255,255,255);
       if(textField.getText().equalsIgnoreCase("*Campo obrigatório*")){
                    textField.setValue(null);

        }
       textField.setBackground(corErro);
    }
   
   
    
    public static boolean isNumeric(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    
}
