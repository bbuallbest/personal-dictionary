package entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author bbuallbest
 */
@Data
@Entity
@Table(name = "VOCABULARIES")
public class Vocabulary {

    @Id
    private Long id;
    private String name;
    private String description;

    @OneToOne
    @JoinColumn(name = "OWNER")
    private User owner;

}
