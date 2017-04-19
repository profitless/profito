package by.kanarski.gksolutions.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

//@Entity
//@GenericGenerator(
//        name = "increment",
//        strategy = "increment"
//)
//@DynamicUpdate
//@DynamicInsert
//@AllArgsConstructor
//@NoArgsConstructor
public class Language implements Serializable {

    private static final long serialVersionUID = 1105569357651281531L;
    private Long languageId;
    private String name;

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "increment"
    )
    @Column(
            unique = true,
            nullable = false
    )
    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    @Column(
            unique = true,
            nullable = false
    )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language language = (Language) o;

        if (!languageId.equals(language.languageId)) return false;
        return name.equals(language.name);

    }

    @Override
    public int hashCode() {
        int result = languageId.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
