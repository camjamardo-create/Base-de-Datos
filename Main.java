
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Gestor de turnos"); // Abrimos la ventana
        ventana.setSize(600, 500);  // Configuramos el tamaño
        ventana.setLayout(null); // Desactivamos el layout o acomodado por defecto

        JLabel etiqueta = new JLabel("¡Bienvenido al Gestor de Turnos Medicos!");
        etiqueta.setBounds(40, 10, 600, 100);
        etiqueta.setFont(new Font("Cambria", Font.BOLD, 26));
        ventana.add(etiqueta);

        JLabel etiqueta1 = new JLabel("Ingresá iniciando sesión o registrandote si es tu primera vez");
        etiqueta1.setFont(new Font("Cambria", Font.PLAIN, 16));
        etiqueta1.setBounds(85, 60, 450, 100);
        ventana.add(etiqueta1);

        JButton boton_inicio = new JButton("Iniciar sesion");
        boton_inicio.setBounds(210, 150, 150, 50);
        boton_inicio.setFont(new Font("Cambria", Font.BOLD, 18));
        boton_inicio.setBackground(new Color(255, 182, 193));
        ventana.add(boton_inicio);

        JButton boton_registro = new JButton("Registrarse");
        boton_registro.setBounds(210, 220, 150, 50);
        boton_registro.setFont(new Font("Cambria", Font.BOLD, 18));
        boton_registro.setBackground(new Color(216, 191, 216));
        ventana.add(boton_registro);

        JLabel etiqueta2 = new JLabel("Podrás agendar turnos o cancelarlos de forma rápida y sencilla");
        etiqueta2.setBounds(70, 270, 600, 100);
        etiqueta2.setFont(new Font("Cambria", Font.PLAIN, 16));
        ventana.add(etiqueta2);

        // Acción del botón iniciar sesión
        boton_inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();

                JFrame ventana_inicio = new JFrame("Iniciar Sesion");
                ventana_inicio.setSize(600, 500);
                ventana_inicio.setLayout(null);

                JLabel etiqueta_inicio = new JLabel("Ingresá tu DNI: ");
                etiqueta_inicio.setBounds(100, 100, 200, 30);
                etiqueta_inicio.setFont(new Font("Cambria", Font.PLAIN, 16));
                ventana_inicio.add(etiqueta_inicio);

                JTextField campo_dni = new JTextField();
                campo_dni.setBounds(270, 100, 200, 30);
                ventana_inicio.add(campo_dni);

                JLabel etiqueta_inicio1 = new JLabel("Ingresá tu contraseña: ");
                etiqueta_inicio1.setBounds(100, 140, 200, 30);
                etiqueta_inicio1.setFont(new Font("Cambria", Font.PLAIN, 16));
                ventana_inicio.add(etiqueta_inicio1);

                JTextField campo_contraseña = new JTextField();
                campo_contraseña.setBounds(270, 140, 200, 30);
                ventana_inicio.add(campo_contraseña);

                JButton boton_enviar = new JButton("Enviar");
                boton_enviar.setBounds(250, 300, 100, 30);
                boton_enviar.setBackground(new Color(216, 191, 216));
                ventana_inicio.add(boton_enviar);

                JTextArea cartel_info = new JTextArea();
                cartel_info.setEditable(false);
                cartel_info.setBounds(200, 200, 400, 20);
                cartel_info.setBackground(new Color(238, 238, 238)
);
                ventana_inicio.add(cartel_info);

                // Acción del botón enviar
                boton_enviar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String dni = campo_dni.getText();
                        String contraseña = campo_contraseña.getText();

                        if (!dni.isEmpty() || !contraseña.isEmpty()) {
                            medicoDAO medicoDAO = new medicoDAO(); // Luego cambiar por pacienteDAO si corresponde                                
                            List<medico> medicos = medicoDAO.obtenerMedicos();
                            boolean encontrado = false;

                            try {
                                int dniInt = Integer.parseInt(campo_dni.getText());
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(ventana_inicio, "El DNI debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }


                            for (medico med : medicos) {
                                if (med.getDni() == dniInt && med.getContraseña().equals(contraseña)) {
                                    encontrado = true;
                                    break;
                                }
                            }

                            if (encontrado == false) {
                                cartel_info.setText("DNI o contraseña incorrectos. Intente nuevamente.");
                            } else if(encontrado == true) {
                                cartel_info.setText("Inicio de sesión exitoso. ¡Bienvenido!");
                            }

                        } else {
                            cartel_info.setText("Por favor, complete todos los campos.");
                        }
                    }
                });

                ventana_inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventana_inicio.setVisible(true);
            }
         });

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }
