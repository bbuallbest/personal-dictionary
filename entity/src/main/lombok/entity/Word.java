package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author bbuallbest
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WORDS")
public class Word {

    @Id
    private Long id;
    private String source;
    private String translation;
    private String example;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VOCABULARY")
    private Vocabulary vocabulary;

}
