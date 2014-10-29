
package scao.feedback;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "feedback_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FeedbackType.findAll", query = "SELECT f FROM FeedbackType f"),
    @NamedQuery(name = "FeedbackType.findById", query = "SELECT f FROM FeedbackType f WHERE f.id = :id"),
    @NamedQuery(name = "FeedbackType.findByName", query = "SELECT f FROM FeedbackType f WHERE f.name = :name")})
public class FeedbackType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId")
    private Collection<Input> inputCollection;

    public FeedbackType() {
    }

    public FeedbackType(Integer id) {
        this.id = id;
    }

    public FeedbackType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Input> getInputCollection() {
        return inputCollection;
    }

    public void setInputCollection(Collection<Input> inputCollection) {
        this.inputCollection = inputCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FeedbackType)) {
            return false;
        }
        FeedbackType other = (FeedbackType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "scao.feedback.FeedbackType[ id=" + id + " ]";
    }
    
}
