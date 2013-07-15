package com.fabrica;
/**
 * Tienda vende la ropa de almacen
 * tambien gestiona la caja.
 * Microempresa tiene solo 1 tienda.
 */



/**
 * @author Sergey
 * 
 */
public class Tienda
{
	private static double caja=0;

	/**
	 * si la prenda a comprar esta en el stock se actualiza este,
	 * tambien se actualiza la caja y se calcula el importe a
	 * devolver.
	 * 
	 * @param nombrePr
	 * @param color
	 * @param cantidad
	 * @param importePagado
	 */

	public static void vender(String nombrePr,String color,int cantidad,double importePagado){
		if(Almacen.getPrenda(nombrePr,color)==null)
			System.out.println("Producto no disponible");
		else{
			double devolver=0;
			Prenda pr=Almacen.getPrenda(nombrePr,color);
			if(pr.getPrecio()*(double)cantidad<=importePagado){
				if(pr.getCantidad()>=cantidad){
					Almacen.actualizarStock(pr,cantidad);
					caja+=pr.getPrecio()*cantidad;
					devolver=(pr.getPrecio()*cantidad<importePagado)?importePagado-pr.getPrecio()*cantidad:0;
					System.out.printf("Cambio a devolver: %.2f €\n",devolver);
				}else
					Almacen.actualizarStock(pr,cantidad);
			}else
				System.out.printf("Importe incorrecto. Precio es: %.2f € x %d = %.2f €. Importe recibido: %.2f €\n",
						pr.getPrecio(),cantidad,pr.getPrecio()*cantidad,importePagado);

		}
	}

	public static double getCaja(){
		return caja;
	}
}
