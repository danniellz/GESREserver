package cripto;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Clase para leer la clave privada
 *
 * @author Daniel Brizuela, Aritz Arrieta
 */
public class PrivateKeyReader {

    /**
     * LOGGER
     */
    private static final Logger LOG = Logger.getLogger(PrivateKeyReader.class.getName());
    private static final String rutaAbsoluta = new File("").getAbsolutePath();
    private static final ResourceBundle RB = ResourceBundle.getBundle("archivos.rutas");

    /**
     * lee la clave privada (igual a leer un fichero) solo que se utiliza
     * PKCS8EncodedKeySpec para descifrar la Key
     *
     * Javadoc PKCS8EncodedKeySpec:
     * https://docs.oracle.com/javase/7/docs/api/java/security/spec/PKCS8EncodedKeySpec.html
     *
     * @param filename Ruta de la Key
     * @return devuelve la Key
     * @throws Exception suelta una exception si algo sale mal
     */
    public static PrivateKey get() throws Exception {
        LOG.info("GESREserver/PrivateKeyReader: Leyendo Clave Privada...");
        System.out.println(rutaAbsoluta);
        File file = new File(RB.getString("PRIVATE_KEY"));
        FileInputStream fis = new FileInputStream(file);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int) file.length()];
        dis.readFully(keyBytes);
        dis.close();
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
}
