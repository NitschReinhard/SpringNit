package nit.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the p_person database table.
 * 
 */
@Entity
@Table(name="p_person")
@NamedQuery(name="PPerson.findAll", query="SELECT p FROM PPerson p")
public class PPerson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="p_id")
	private int pId;

	@Column(name="p_name")
	private String pName;

	//bi-directional many-to-one association to BBuch
	@OneToMany(mappedBy="PPerson")
	private List<BBuch> BBuches1;

	//bi-directional many-to-many association to BBuch
	@ManyToMany (fetch=FetchType.EAGER)
	@JoinTable(
		name="b_buch_has_p_person"
		, joinColumns={
			@JoinColumn(name="P_Person_p_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="B_Buch_b_id")
			}
		)
	private List<BBuch> BBuches2;

	public PPerson() {
	}

	public int getPId() {
		return this.pId;
	}

	public void setPId(int pId) {
		this.pId = pId;
	}

	public String getPName() {
		return this.pName;
	}

	public void setPName(String pName) {
		this.pName = pName;
	}

	public List<BBuch> getBBuches1() {
		return this.BBuches1;
	}

	public void setBBuches1(List<BBuch> BBuches1) {
		this.BBuches1 = BBuches1;
	}

	public BBuch addBBuches1(BBuch BBuches1) {
		getBBuches1().add(BBuches1);
		BBuches1.setPPerson(this);

		return BBuches1;
	}

	public BBuch removeBBuches1(BBuch BBuches1) {
		getBBuches1().remove(BBuches1);
		BBuches1.setPPerson(null);

		return BBuches1;
	}

	public List<BBuch> getBBuches2() {
		return this.BBuches2;
	}

	public void setBBuches2(List<BBuch> BBuches2) {
		this.BBuches2 = BBuches2;
	}

}