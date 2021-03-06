package pfm.entidades;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Empresa
 * 
 */
@Entity
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name = "RAZON_SOCIAL", unique = true, nullable = false)
	private String razonSocial;
	@Column(nullable = false)
	private String ruc;
	private String direccion;
	private String telefono;
	@Column(nullable = false)
	private boolean eliminado;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private Set<Agencia> agencia;

	public Empresa() {

	}

	public Empresa(int id, String razonSocial, String ruc, String direccion,
			String telefono, boolean eliminado) {

		this.id = id;
		this.razonSocial = razonSocial;
		this.ruc = ruc;
		this.direccion = direccion;
		this.telefono = telefono;
		this.eliminado = eliminado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public Set<Agencia> getAgencia() {
		return agencia;
	}

	public void setAgencia(Set<Agencia> agencia) {
		this.agencia = agencia;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razonSocial=" + razonSocial + ", ruc="
				+ ruc + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", eliminado=" + eliminado + ", agencia=" + agencia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + (eliminado ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result
				+ ((razonSocial == null) ? 0 : razonSocial.hashCode());
		result = prime * result + ((ruc == null) ? 0 : ruc.hashCode());
		result = prime * result
				+ ((telefono == null) ? 0 : telefono.hashCode());
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
		Empresa other = (Empresa) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (eliminado != other.eliminado)
			return false;
		if (id != other.id)
			return false;
		if (razonSocial == null) {
			if (other.razonSocial != null)
				return false;
		} else if (!razonSocial.equals(other.razonSocial))
			return false;
		if (ruc == null) {
			if (other.ruc != null)
				return false;
		} else if (!ruc.equals(other.ruc))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

}
