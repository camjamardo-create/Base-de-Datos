
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
            boton_registro.addActionListener(new ActionListener() { // Configuramos el botón de registro

                @Override
                public void actionPerformed(ActionEvent e) {

                    ventana.dispose(); // Cerramos la ventana actual

                    JFrame ventana_registro = new JFrame("Registrar usuario");
                    ventana_registro.setSize(600, 800);
                    ventana_registro.setLayout(null);

                    JLabel subtitulo_registro = new JLabel("Completá tus datos para registrarte:");
                    subtitulo_registro.setBounds(180, 30, 400, 50);
                    subtitulo_registro.setFont(new Font("Cambria", Font.PLAIN, 16));
                    ventana_registro.add(subtitulo_registro);
    
                    JLabel etiqueta_registro = new JLabel("DNI:");
                    etiqueta_registro.setBounds(100, 100, 200, 30);
                    etiqueta_registro.setFont(new Font("Cambria", Font.PLAIN, 16));
                    ventana_registro.add(etiqueta_registro);
    
                    JTextField campo_dni_registro = new JTextField();
                    campo_dni_registro.setBounds(250, 100, 200, 30);
                    ventana_registro.add(campo_dni_registro);
    
                    JLabel etiqueta_nombre = new JLabel("Nombre:");
                    etiqueta_nombre.setBounds(100, 150, 200, 30);
                    etiqueta_nombre.setFont(new Font("Cambria", Font.PLAIN, 16));
                    ventana_registro.add(etiqueta_nombre);
    
                    JTextField campo_nombre = new JTextField();
                    campo_nombre.setBounds(250, 150, 200, 30);
                    ventana_registro.add(campo_nombre);
    
                    JLabel etiqueta_apellido = new JLabel("Apellido:");
                    etiqueta_apellido.setBounds(100, 200, 200, 30);
                    etiqueta_apellido.setFont(new Font("Cambria", Font.PLAIN, 16));
                    ventana_registro.add(etiqueta_apellido);
    
                    JTextField campo_apellido = new JTextField();
                    campo_apellido.setBounds(250, 200, 200, 30);
                    ventana_registro.add(campo_apellido);
    
                    JLabel etiqueta_domicilio = new JLabel("Domicilio:");
                    etiqueta_domicilio.setBounds(100, 250, 200, 30);
                    etiqueta_domicilio.setFont(new Font("Cambria", Font.PLAIN, 16));
                    ventana_registro.add(etiqueta_domicilio);
    
                    JTextField campo_domicilio = new JTextField();
                    campo_domicilio.setBounds(250, 250, 200, 30);
                    ventana_registro.add(campo_domicilio);
    
                    JLabel etiqueta_telefono = new JLabel("Teléfono:");
                    etiqueta_telefono.setBounds(100, 300, 200, 30);
                    etiqueta_telefono.setFont(new Font("Cambria", Font.PLAIN, 16));
                    ventana_registro.add(etiqueta_telefono);
    
                    JTextField campo_telefono = new JTextField();
                    campo_telefono.setBounds(250, 300, 200, 30);
                    ventana_registro.add(campo_telefono);
    
                    JLabel etiqueta_obra_social = new JLabel("Obra Social:");
                    etiqueta_obra_social.setBounds(100,350,200,30);
                    etiqueta_obra_social.setFont(new Font("Cambria", Font.PLAIN, 16));
                    ventana_registro.add(etiqueta_obra_social);
    
                    JTextField campo_obra_social = new JTextField();
                    campo_obra_social.setBounds(250,350,200,30);
                    ventana_registro.add(campo_obra_social);
    
                    JLabel etiqueta_fecha_nac = new JLabel("Fecha de nacimiento");
                    etiqueta_fecha_nac.setBounds(100, 400, 200, 30);
                    etiqueta_fecha_nac.setFont(new Font("Cambria", Font.PLAIN, 16));
                    ventana_registro.add(etiqueta_fecha_nac);
    
                    SpinnerDateModel modelo_fecha = new SpinnerDateModel();
                    JSpinner campo_fecha_nac = new JSpinner(modelo_fecha);
                    campo_fecha_nac.setBounds(250, 400, 200, 30);
                    campo_fecha_nac.setEditor(new JSpinner.DateEditor(campo_fecha_nac, "dd/MM/yyyy"));
                    ventana_registro.add(campo_fecha_nac);
    
                    JLabel etiqueta_genero = new JLabel("Género:");
                    etiqueta_genero.setBounds(100,450,200,30);
                    etiqueta_genero.setFont(new Font("Cambria", Font.PLAIN, 16));
                    ventana_registro.add(etiqueta_genero);
    
                    JTextField campo_genero = new JTextField();
                    campo_genero.setBounds(250,450,200,30);
                    ventana_registro.add(campo_genero);
    
                    JLabel etiqueta_contraseña = new JLabel("Contraseña:");
                    etiqueta_contraseña.setBounds(100,500,200,30);
                    etiqueta_contraseña.setFont(new Font("Cambria", Font.PLAIN, 16));
                    ventana_registro.add(etiqueta_contraseña);
    
                    JTextField campo_contraseña = new JTextField();
                    campo_contraseña.setBounds(250,500,200,30);
                    ventana_registro.add(campo_contraseña);
    
                    JButton boton_registrar = new JButton("Registrar");
                    boton_registrar.setBounds(250, 550, 100, 30);
                    boton_registrar.setBackground(new Color(216, 191, 216));
                    ventana_registro.add(boton_registrar);
    
                    JTextArea area_aviso = new JTextArea();
                    area_aviso.setBounds(100, 590, 400, 30);
                    area_aviso.setEditable(false);
                    area_aviso.setBackground(new Color(238,238,238));
                    ventana_registro.add(area_aviso);

                
                // Acción al presionar el botón registrar
                    boton_registrar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String dnitexto = campo_dni_registro.getText().trim();
                            try {
                                if (dnitexto.isEmpty()) {
                                    JOptionPane.showMessageDialog(ventana_registro, "El DNI no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(ventana_registro, "El DNI debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
    
                            int dni = Integer.parseInt(dnitexto);
                            String nombre = campo_nombre.getText();
                            String apellido = campo_apellido.getText();
                            String domicilio = campo_domicilio.getText();
                            String telefono = campo_telefono.getText();
                            String obra_social = campo_obra_social.getText();
                            LocalDate fecha_nac = ((SpinnerDateModel) campo_fecha_nac.getModel()).getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            String genero = campo_genero.getText();
                            String contraseña = campo_contraseña.getText();
    
                            paciente nuevo_paciente = new paciente(0, dni, nombre, apellido, domicilio, telefono, obra_social, fecha_nac, genero, contraseña);
                            pacienteDAO pacienteDAO; //instanciacion del DAO
                    
    
                            // verificamos que no hayan campos vacios
                            if (nombre.isEmpty() || apellido.isEmpty() || domicilio.isEmpty() || telefono.isEmpty() || obra_social.isEmpty() || fecha_nac == null || genero.isEmpty()) {
                                JOptionPane.showMessageDialog(ventana_registro, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                area_aviso.setText("Registro exitoso. ¡Bienvenido, " + nombre + "!");
                            }
    
                            try {
                            pacienteDAO = new pacienteDAO();
                            pacienteDAO.insertarPaciente(nuevo_paciente);
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(ventana_registro, "Error al registrar el paciente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            ventana_registro.dispose(); // Cerramos la ventana de registro
                            ventana.setVisible(true); // Volvemos a mostrar la ventana principal
                        }
                    });
                    ventana_registro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ventana_registro.setVisible(true);
                }
            });

                ventana_inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventana_inicio.setVisible(true);
            }
         });

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }

