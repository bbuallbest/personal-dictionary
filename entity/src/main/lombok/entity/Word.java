package entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * @author bbuallbest
 */
@Data
@Builder
@Entity
@Table(name = "WORDS")
public class Word {

    @Id
    private Long id;
    private String source;
    private String translation;
    private String example;

    @OneToOne
    @JoinColumn(name = "VOCABULARY")
    private Vocabulary vocabulary;

}
