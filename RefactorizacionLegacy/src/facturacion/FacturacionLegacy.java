package facturacion;

/**
 * Clase Legacy del sistema de facturación.
 * Optimizado
 */
public class FacturacionLegacy {

    // Constantes de negocio extraídas para eliminar los números
    private static final double DESCUENTO_VIP = 0.25;
    private static final double DESCUENTO_ESTANDAR = 0.15;
    private static final double DESCUENTO_CLIENTE_TIPO_2 = 0.05;

    // Identificadores semánticos para los tipos de cliente
    private static final int TIPO_CLIENTE_1 = 1;
    private static final int TIPO_CLIENTE_2 = 2;

    /**
     * Calcula el importe total aplicándole los descuentos correspondientes 
     * según el tipo de cliente y su condición de socio VIP.
     *
     * @param importeBase   El importe original de la transacción (debe ser mayor que 0).
     * @param tipoCliente   El código identificador del tipo de cliente (1, 2, etc.).
     * @param esSocioVip    Indica si el cliente cuenta con una suscripción VIP activa.
     * @return El importe final tras aplicar los descuentos, o 0 si el importe base no es válido.
     */
    public double calcularTotal(double importeBase, int tipoCliente, boolean esSocioVip) {
        
        // Cláusula de guarda: si el importe es inválido, salimos inmediatamente
        if (importeBase <= 0) {
            return 0;
        }

        // Caso: Cliente Tipo 1 (Aplica descuentos por fidelidad o VIP)
        if (tipoCliente == TIPO_CLIENTE_1) {
            if (esSocioVip) {
                return importeBase - (importeBase * DESCUENTO_VIP);
            }
            return importeBase - (importeBase * DESCUENTO_ESTANDAR);
        }

        // Caso: Cliente Tipo 2 (Aplica descuento fijo)
        if (tipoCliente == TIPO_CLIENTE_2) {
            return importeBase - (importeBase * DESCUENTO_CLIENTE_TIPO_2);
        }

        // Caso por defecto: No se aplican descuentos
        return importeBase;
    }
}