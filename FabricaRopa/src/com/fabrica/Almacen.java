package com.fabrica;
/**
 * Esta clase gestiona el stock de la fabrica-tienda.
 * Microempresa tiene solo 1 almacen.
 */


import java.util.ArrayList;

/**
 * @author Sergey
 * 
 */
public class Almacen
{
	private static ArrayList<Prenda> stock=new ArrayList<Prenda>();// lista de todas las prendas
	private static final int stockMin=8; // el umbral minimo del stock de una prenda

	/**
	 * 
	 * @param pr
	 *            - si la prenda a añadir ya existe en el stock solo se
	 *            actualiza la cantidad,si no existe la prenda se añada al
	 *            stock.
	 */

	public static void addPrenda(Prenda pr){
		boolean contents=false;
		if(stock.isEmpty()){
			stock.add(pr);
			contents=true;
		}else{
			for(Prenda p:stock){
				if(p.getNombre().equalsIgnoreCase(pr.getNombre())&&p.getColor().equalsIgnoreCase(pr.getColor())){
					p.setCantidad(p.getCantidad()+pr.getCantidad());
					contents=true;
					break;
				}
			}
		}
		if(!contents)
			stock.add(pr);
	}

	/**
	 * 
	 * @return stock
	 */

	public static ArrayList<Prenda> getStock(){
		return stock;
	}

	/**
	 * buscar una prenda por su nombre+color
	 * 
	 * @param nombre
	 * @param color
	 * @return Prenda
	 */

	public static Prenda getPrenda(String nombre,String color){
		Prenda pr=null;
		for(Prenda p:stock){
			if(p.getNombre().equalsIgnoreCase(nombre)&&p.getColor().equalsIgnoreCase(color))
				pr=p;
		}
		return pr;
	}

	/**
	 * si stock tras una compra esta por debajo del umbral minimo se envía una
	 * orden de fabricación para reponer el stock con cantidad =  cant. pedida.
	 * 
	 * @param pr
	 * @param cantidad
	 */

	public static void actualizarStock(Prenda pr,int cantidad){
		String str=null;
		for(Prenda p:stock){
			if(p.getNombre().equalsIgnoreCase(pr.getNombre())&&p.getColor().equalsIgnoreCase(pr.getColor())){
				if(p.getCantidad()>=cantidad){
					p.setCantidad(p.getCantidad()-cantidad);
					if(p.getCantidad()<=stockMin){
						System.out.println("Stock minimo.Enviando la orden de fabricacion.");
						addPrenda(new Prenda(pr.getNombre(),pr.getColor(),pr.getCantidad(),pr.getPrecio()));
					}
				}else
					str="En el stock queda solo "+p.getCantidad()+" unidades.";
				break;
			}
		}
		if(str!=null)
			System.out.println(str);
	}
}
