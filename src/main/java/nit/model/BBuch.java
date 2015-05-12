package nit.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the b_buch database table.
 * 
 */
@Entity
@Table(name="b_buch")
@NamedQuery(name="BBuch.findAll", query="SELECT b FROM BBuch b")
public class BBuch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="b_id")
	private int bId;

	@Column(name="b_name")
	private String bName;

	//bi-directional many-to-one association to PPerson
	@ManyToOne
	@JoinColumn(name="b_p_autor")
	private PPerson PPerson;

	//bi-directional many-to-many association to PPerson
	@ManyToMany(mappedBy="BBuches2", fetch=FetchType.EAGER)
	private List<PPerson> PPersons;

	public BBuch() {
	}

	public int getBId() {
		return this.bId;
	}

	public void setBId(int bId) {
		this.bId = bId;
	}

	public String getBName() {
		return this.bName;
	}

	public void setBName(String bName) {
		this.bName = bName;
	}

	public PPerson getPPerson() {
		return this.PPerson;
	}

	public void setPPerson(PPerson PPerson) {
		this.PPerson = PPerson;
	}

	public List<PPerson> getPPersons() {
		return this.PPersons;
	}

	public void setPPersons(List<PPerson> PPersons) {
		this.PPersons = PPersons;
	}

}