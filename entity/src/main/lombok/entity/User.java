package entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author bbuallbest
 */
@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    private Long id;
    private String login;

    @Column(name = "AUTH_TOKEN")
    private String securityToken;

    @Column(name = "PASS_HASH")
    private String passwordHash;

    @Column(name = "PASS_SALT")
    private String passwordSalt;

}
