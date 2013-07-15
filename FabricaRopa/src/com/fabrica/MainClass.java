package com.fabrica;


/**
 * @author Sergey * 
 */
public class MainClass
{

	/**
	 * @param args
	 */
	public static void main(String[] args){	
		
		Almacen.addPrenda(new Prenda("Prenda 1","rojo",20,15.50));
		Almacen.addPrenda(new Prenda("Prenda 1","verde",20,15.15));
		Almacen.addPrenda(new Prenda("Prenda 2","azul",10,17.05));
		Almacen.addPrenda(new Prenda("Prenda 3","azul",51,12.60));
		Almacen.addPrenda(new Prenda("Prenda 3","amarillo",10,12.80));
		Almacen.addPrenda(new Prenda("Prenda 4","marron",17,17.90));
		Almacen.addPrenda(new Prenda("Prenda 4","negro",12,14.40));
		Almacen.addPrenda(new Prenda("Prenda 4","negro",12,14.40));

		/*
		 * CASO DE USO 1. Productos a comprar estan en el estock, importes
		 * recibidos son correctos(imp.recibido > cantidad pedido * precio
		 * prenda),el stock min no llega al umbral min.
		 * 
		 * USE CASE 1. Products to buy are in the stock, amounts received 
		 * are correct (amount received > order quantity * garment price),
		 * the stock does not reach the minimum threshold.
		 */
		System.out.println("CASO DE USO 1.\nSe recibe 16 € por 1 und de Prenda 1(rojo).");
		Tienda.vender("Prenda 1","rojo",1,16);
		System.out.println("Se recibe 500 € por 8 unds de Prenda 1(verde).");
		Tienda.vender("Prenda 1","verde",8,500);
		System.out.printf("Total en caja: %.2f €\n",Tienda.getCaja());
		/*
		 * CASO DE USO 2. Importe recibido no es suficiente para realizar la  compra.
		 * 
		 * USE CASE 2. Amount received is not enough to make the purchase
		 */
		System.out.println("\nCASO DE USO 2.\nSe recibe 160 € por 30 unds de Prenda 3(azul).");
		Tienda.vender("Prenda 3","azul",30,160);
		System.out.printf("Total en caja: %.2f €\n",Tienda.getCaja());
		/*
		 * CASO DE USO 3. Producto pedido no esta en el stock(no se fabrica).
		 * 
		 * USE CASE 3. Product requested is not in stock (no longer manufactured).
		 */
		System.out.println("\nCASO DE USO 3.\nSe recibe 50 € por 3 unds de Prenda 1(amarillo).");
		Tienda.vender("Prenda 1","amarillo",3,50);
		System.out.println("Se recibe 40 € por 2 unds de Prenda 8(azul).");
		Tienda.vender("Prenda 8","azul",2,40);
		System.out.printf("Total en caja: %.2f €\n",Tienda.getCaja());
		/*
		 * CASO DE USO 4. Cantidad pedida > cantidad en el stock.
		 * 
		 * USE CASE 4. Order Quantity > quantity in stock
		 */
		System.out.println("\nCASO DE USO 4.\nSe recibe 800 € por 20 unds de Prenda 4(marron).");
		Tienda.vender("Prenda 4","marron",20,800);
		System.out.printf("Total en caja: %.2f €\n",Tienda.getCaja());
		/*
		 * CASO DE USO 5. Tras realizar la compra el estock del producto llega al umbral min.,
		 *                se envía la orden de fabricación
		 * 
		 * USE CASE 5. After purchasing the stock of the product reaches the minimum threshold then 
		 *             the app send the production order
		 */
		System.out.println("\nCASO DE USO 5.\nSe recibe 400 € por 20 unds de Prenda 4(negro).");
		Tienda.vender("Prenda 4","negro",20,400);
		System.out.printf("Total en caja: %.2f €\n\n",Tienda.getCaja());
		System.out.println("Stock:");
		for(Prenda pr:Almacen.getStock())
			System.out.println(pr.getNombre()+"("+pr.getColor()+")-cant("+pr.getCantidad()+")");

	}

}
