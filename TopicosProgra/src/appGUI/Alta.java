package appGUI;
import java.awt.event.KeyEvent;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
@SuppressWarnings("deprecation")
public class Alta extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;

	int op=0,n=0;
	String codigo,articu,linea,fecha,tcarro,cantid,precio;
	DataInputStream registro=null;	DataOutputStream escritor=null;

    public Alta() {
        initComponents();
        LeerDatos();
    }

    public void Clear(){
    tfArticulo.setText("");
    ffPrecio.setText("");
    cbTipo.setEditable(false);
    Spiner.setValue(1);
    cbCodigo.setSelectedItem("Nuevo");}

    public void LeerDatos(){
        try{
            DefaultComboBoxModel modelCodigo= new DefaultComboBoxModel(new String[]{"Nuevo"});
                registro=new DataInputStream(new FileInputStream("Refaccionaria.txt"));
		n=0;
                cbCodigo.setModel(modelCodigo);
                while ((linea= registro.readLine())!=null){n++;System.out.println(linea);
		if ((n-1)%6==0){cbCodigo.addItem(linea);}
            }registro.close();
	}catch(IOException e){System.out.println("Excepcion en LeerDatos");}

    }

    public void BotonAgregar(){
        taImpresion.setText("");
            tfArticulo.setEditable(true);
            boolean in=false;

        int ca=Integer.parseInt(Spiner.getValue().toString());
        @SuppressWarnings("unused")
		double pr=-1;   String articus=null;
            articu = tfArticulo.getText().toString();
            cantid = Spiner.getValue().toString();
            tcarro = cbTipo.getSelectedItem().toString();
            precio = ffPrecio.getText();

            if(!(articu.equals(""))){articus=articu.substring(articu.length()-1,articu.length());
                                if(articus.equals("s")){articu=articu.substring(0,articu.length()-1);}}
        try{
           pr=Double.parseDouble(precio);
        }catch(NumberFormatException e){in=true;    taImpresion.append("Insertar Precio Correctamente\n");}

        if (ca<1){cantid="1";}

       if(articu.equals("")||precio==null||in){
           LeerDatos();
            if (articu.equals("")){taImpresion.append("Insertar Articulo Correctamente\n");}


             if(precio==null){taImpresion.append("Insertar Precio Unitario\n");}
       }

    else{
     boolean nuevo=true; String cod;

           GregorianCalendar dia=new GregorianCalendar(TimeZone.getTimeZone("America/Tijuana"));
           fecha = (dia.get(Calendar.DATE)) + "/" + (dia.get(Calendar.MONTH)+1) + "/" + (dia.get(Calendar.YEAR));

            if(tcarro.equals("General")){codigo = "000";}
            if(tcarro.equals("Chico"))  {codigo = "001";}
            if(tcarro.equals("Mediano")){codigo = "002";}
            if(tcarro.equals("Grande")) {codigo = "003";}
            codigo += articu;
      try{
                registro=new DataInputStream(new FileInputStream("Refaccionaria.txt"));
		n=0;
		while ((linea= registro.readLine())!=null){n++;
                if((n-1)%6==0){cod=""+linea;
                    if(cod.equals(codigo)){ nuevo=false;
                   }}
                }registro.close();
	}catch(IOException e){System.out.println("Excepcion en LeerDatos");}

     if(nuevo){ AgregarNuevo();}
        else Agregar();
     LeerDatos();Clear();

 }
    }

    public void AgregarNuevo(){try {
           escritor = new DataOutputStream(new FileOutputStream("\\Refaccionaria.txt", true));
            System.out.println("Codigo: " + codigo);
            escritor.writeBytes(codigo + "\n");
            System.out.println("artic.: " + articu);
            escritor.writeBytes(articu + "\n");
            System.out.println("Tipo Carro: " + tcarro);
            escritor.writeBytes(tcarro + "\n");
            System.out.println("Cantidad:   " + cantid);
            escritor.writeBytes(cantid + "\n");
            System.out.println("Precio: " + precio);
            escritor.writeBytes(precio + "\n");
            System.out.println("Entrada:    " + fecha);
            escritor.writeBytes(fecha + "\n");

            taImpresion.setText("");
            taImpresion.append("Refaccion AGREGADA\n\nCodigo:\t"+codigo+"\nArtic.:\t"+articu+"\nCarro:\t"+tcarro+"\n"
                    + "Cant.:\t"+cantid+"\nPrecio:\t"+precio+"\nFecha:\t"+fecha+"\n\n");

        } catch (IOException ex) { ex.printStackTrace(); System.out.println("Excepcion en Agregar");     }
}

    public void Agregar(){
        n=0;  String cod=null,pre=null;  int c=0,can=0,cant=Integer.parseInt(cantid);
       String[] lineas=new String[1000];

        try{
        registro=new DataInputStream(new FileInputStream("Refaccionaria.txt"));// LEE ARCHIVO
        while((linea=registro.readLine())!=null){n++; if(c==6)c=0;
         if((n-1)%6==0){cod=linea;}
         if(cod.equals(codigo)){c++;
                if(c==5){pre=linea;
                       if((pre.equals(precio)))pre="";
                        else pre="\nPrecio registrado:    "+pre; }
                if(c==4){can=Integer.parseInt(linea);
                    cant+=can;       lineas[n]=""+cant;}
                else lineas[n]=""+linea;}
        else lineas[n]=""+linea;
        }registro.close();


        escritor=new DataOutputStream(new FileOutputStream("Refaccionaria.txt"));
        for(int q=1;q<lineas.length;q++){
            if(lineas[q]!=null)
            escritor.writeBytes(lineas[q]+"\n");      }
            String im=("Refacciones Agregadas\n\nArtic.:\t"+articu+"\nAgregadas:\t"
                    +cantid+" unidade(s)"+"\nTotal:\t"+cant+pre);
        taImpresion.append(im);
           }catch(Exception e){System.err.println(e);}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FONDO = new JLabel();
        FONDO.setBounds(new Rectangle(-7, -4, 745, 525));
        FONDO.setText("jLabel1");
        FONDO.setIcon(new ImageIcon(getClass().getResource("/Images/(1).jpg")));
        Titulo = new javax.swing.JLabel();
        tfArticulo = new javax.swing.JTextField();
        cbCodigo = new javax.swing.JComboBox();
        codigoL = new javax.swing.JLabel();
        Spiner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        btCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taImpresion = new javax.swing.JTextArea();
        btAgregar = new javax.swing.JButton();
        ffPrecio = new javax.swing.JFormattedTextField();
        articuloL = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();
        setBackground(new java.awt.Color(70, 153, 224));
        setMinimumSize(new java.awt.Dimension(695, 517));
        setLayout(null);

        this.setSize(new Dimension(662, 481));
        Titulo.setFont(new java.awt.Font("Tahoma", 1, 24));
        Titulo.setForeground(new java.awt.Color(191, 191, 192));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Altas");
        add(Titulo);
        Titulo.setBounds(240, 10, 166, 42);

        tfArticulo.setFont(new java.awt.Font("Tahoma", 0, 14));
        tfArticulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfArticulo.setToolTipText("Articulo a Agregar");
        tfArticulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfArticuloFocusGained(evt);
            }
        });
        tfArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfArticuloKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfArticuloKeyReleased(evt);
            }
        });
        add(tfArticulo);
        tfArticulo.setBounds(280, 120, 300, 30);

        cbCodigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nuevo" }));
        cbCodigo.setToolTipText("Seleccionar Codigo");
        cbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoActionPerformed(evt);
            }
        });
        add(cbCodigo);
        cbCodigo.setBounds(280, 70, 300, 31);

        codigoL.setFont(new java.awt.Font("Tahoma", 1, 18));
        codigoL.setText("Codigo:");
        add(codigoL);
        codigoL.setBounds(160, 70, 110, 30);

        Spiner.setFont(new java.awt.Font("Tahoma", 0, 14));
        Spiner.setModel(new javax.swing.SpinnerNumberModel(Short.valueOf((short)1), Short.valueOf((short)1), Short.valueOf((short)500), Short.valueOf((short)1)));
        Spiner.setToolTipText("Cantidad a Agregar");

        add(Spiner);
        Spiner.setBounds(230, 190, 90, 26);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel4.setText("Precio Unitario:");
        add(jLabel4);
        jLabel4.setBounds(80, 320, 150, 27);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel5.setText("Cantidad:");
        add(jLabel5);
        jLabel5.setBounds(80, 190, 130, 27);
        add(jSeparator2);
        jSeparator2.setBounds(80, 160, 500, 10);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel6.setText("Tipo de Carro:");
        add(jLabel6);
        jLabel6.setBounds(80, 250, 139, 40);

        btCancel.setFont(new java.awt.Font("Tahoma", 1, 18));
        btCancel.setText("Limpiar");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        btCancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btCancelKeyPressed(evt);
            }
        });
        add(btCancel);
        btCancel.setBounds(350, 420, 130, 30);

        taImpresion.setColumns(20);
        taImpresion.setFont(new java.awt.Font("Verdana", 0, 13));
        taImpresion.setRows(5);
        taImpresion.setToolTipText("Impresion de Refacciones");
        taImpresion.setFocusable(false);
        taImpresion.setOpaque(true);
        taImpresion.setEditable(false);
        jScrollPane1.setViewportView(taImpresion);

        add(jScrollPane1);
        jScrollPane1.setBounds(350, 190, 230, 210);

        btAgregar.setFont(new java.awt.Font("Tahoma", 1, 18));
        btAgregar.setText("Aceptar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });
        btAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btAgregarKeyPressed(evt);
            }
        });
        add(btAgregar);
        btAgregar.setBounds(180, 420, 140, 30);

        ffPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00;(###0.00)"))));
        ffPrecio.setToolTipText("Insertar Precio Unitario");
       ffPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ffPrecioFocusGained(evt);
            }
        });
        ffPrecio.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                ffPrecioInputMethodTextChanged(evt);
            }
        });
        ffPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ffPrecioKeyPressed(evt);
            }
        });
        add(ffPrecio);
        ffPrecio.setBounds(230, 320, 90, 30);

        articuloL.setFont(new java.awt.Font("Tahoma", 1, 18));
        articuloL.setText("Articulo Nuevo:");
        articuloL.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(articuloL);
        articuloL.setBounds(90, 120, 160, 30);
        cbTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "General", "Chico", "Mediano", "Grande" }));
        cbTipo.setToolTipText("Seleccinonar Tipo de Carro");
        add(cbTipo);
        this.add(FONDO, null);
        cbTipo.setBounds(230, 260, 90, 30);

    }// </editor-fold>//GEN-END:initComponents



    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        Clear();
        taImpresion.setText("");
    }//GEN-LAST:event_btCancelActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
            BotonAgregar();
    }//GEN-LAST:event_btAgregarActionPerformed


    private void ffPrecioInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ffPrecioInputMethodTextChanged

    }//GEN-LAST:event_ffPrecioInputMethodTextChanged



    private void cbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoActionPerformed
        if (!(cbCodigo.getSelectedItem().toString().equals("Nuevo"))) {
            String codigo1=null,precio1=null;
            codigo = cbCodigo.getSelectedItem().toString();
            try{
                registro=new DataInputStream(new FileInputStream("Refaccionaria.txt"));// LEE ARCHIVO
                n=0;
                while ((linea= registro.readLine())!=null){n++;System.out.println(linea);
                if ((n-1)%6==0){codigo1=linea;}
                if((n-5)%6==0){precio1=linea;
                if(codigo1.equals(codigo)) ffPrecio.setText(precio1); }
                }
                registro.close();
            }catch(IOException e){System.out.println("Excepcion en LeerDatos");}


            articu=codigo.substring(3,codigo.length());
            tfArticulo.setText(articu);
            tfArticulo.setEditable(false);
            tfArticulo.setFocusable(false);
            cbTipo.enable();
            cbTipo.setSelectedIndex(Integer.parseInt(codigo.substring(2,3))-1);
            cbTipo.disable();
            ffPrecio.setEditable(false);
            ffPrecio.setFocusable(false);
        } else {cbTipo.setSelectedItem("Chico");cbTipo.enable();
        ffPrecio.setEditable(true);     ffPrecio.setFocusable(true);
        tfArticulo.setEditable(true);   tfArticulo.setFocusable(true);}
}//GEN-LAST:event_cbCodigoActionPerformed

    private void btAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btAgregarKeyPressed
    	 if(evt.getKeyCode()==10)
             BotonAgregar();
    	if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
 			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
                             "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
 			if(s==0)System.exit(0);}


    }//GEN-LAST:event_btAgregarKeyPressed


    private void tfArticuloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfArticuloKeyReleased
        if(tfArticulo.getText().toString().length()>25){
        tfArticulo.setText(tfArticulo.getText().toString().substring(0,25));}

    }//GEN-LAST:event_tfArticuloKeyReleased

    private void tfArticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfArticuloKeyPressed
     if(evt.getKeyCode()==10)
             BotonAgregar();
    if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
                         "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
			if(s==0)System.exit(0);}


    }//GEN-LAST:event_tfArticuloKeyPressed

    private void tfArticuloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfArticuloFocusGained
        tfArticulo.selectAll();

    }//GEN-LAST:event_tfArticuloFocusGained

    private void btCancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btCancelKeyPressed
         if(evt.getKeyCode()==10)
            {Clear();            taImpresion.setText("");}
        if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
 			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
                             "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
 			if(s==0)System.exit(0);}
    }//GEN-LAST:event_btCancelKeyPressed

    private void ffPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ffPrecioKeyPressed
         if(evt.getKeyCode()==10)
             BotonAgregar();
         if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Escape")){
 			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
                             "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
 			if(s==0)System.exit(0);}
    }//GEN-LAST:event_ffPrecioKeyPressed

    private void ffPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ffPrecioFocusGained
        String st=ffPrecio.getText();
         ffPrecio.setText(st);
         ffPrecio.selectAll();

    }//GEN-LAST:event_ffPrecioFocusGained


    private javax.swing.JSpinner Spiner;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel articuloL;
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btCancel;
    private javax.swing.JComboBox cbCodigo;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JLabel codigoL;
    private javax.swing.JFormattedTextField ffPrecio;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea taImpresion;
    private javax.swing.JTextField tfArticulo;
    // End of variables declaration

	private JLabel FONDO = null;

}  //  @jve:decl-index=0:visual-constraint="10,10"
