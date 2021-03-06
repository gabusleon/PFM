package pfm.entidades;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.Index;
import org.eclipse.persistence.annotations.Indexes;

/**
 * Entity implementation class for Entity: PedidoDetalle
 * 
 */
@Entity
@Table(name = "FACTURA_DETALLE")
@Indexes({
		@Index(name = "FK_FACTURA_DETALLE_PRODUCTO_ID", columnNames = { "PRODUCTO_ID" }),
		@Index(name = "FK_FACTURA_DETALLE_FACTURA_ID", columnNames = { "FACTURA_ID" }),
		@Index(name = "UK_FACTURA_DETALLE", columnNames = { "PRODUCTO_ID",
				"FACTURA_ID" }, unique = true) })
public class FacturaDetalle implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(nullable = false)
	private int cantidad;
	@Column(nullable = false)
	private double precio;
	@Column(nullable = false)
	private double subtotal;
	@Column(nullable = false)
	private double iva;
	@Column(nullable = false)
	private double descuento;
	@Column(nullable = false)
	private double total;
	@Column(nullable = false)
	private boolean eliminado;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Producto producto;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Factura factura;
	private static final long serialVersionUID = 1L;

	public FacturaDetalle() {

	}

	public FacturaDetalle(int id, int cantidad, double precio, double subtotal,
			double iva, double descuento, double total, boolean eliminado) {
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.subtotal = subtotal;
		this.iva = iva;
		this.descuento = descuento;
		this.total = total;
		this.eliminado = eliminado;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return this.iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getDescuento() {
		return this.descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean getEliminado() {
		return this.eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "FacturaDetalle [id=" + id + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", subtotal=" + subtotal + ", iva="
				+ iva + ", descuento=" + descuento + ", total=" + total
				+ ", eliminado=" + eliminado + ", producto=" + producto
				+ ", factura=" + factura + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		long temp;
		temp = Double.doubleToLongBits(descuento);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (eliminado ? 1231 : 1237);
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result + id;
		temp = Double.doubleToLongBits(iva);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((producto == null) ? 0 : producto.hashCode());
		temp = Double.doubleToLongBits(subtotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacturaDetalle other = (FacturaDetalle) obj;
		if (cantidad != other.cantidad)
			return false;
		if (Double.doubleToLongBits(descuento) != Double
				.doubleToLongBits(other.descuento))
			return false;
		if (eliminado != other.eliminado)
			return false;
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(iva) != Double.doubleToLongBits(other.iva))
			return false;
		if (Double.doubleToLongBits(precio) != Double
				.doubleToLongBits(other.precio))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (Double.doubleToLongBits(subtotal) != Double
				.doubleToLongBits(other.subtotal))
			return false;
		if (Double.doubleToLongBits(total) != Double
				.doubleToLongBits(other.total))
			return false;
		return true;
	}

}
