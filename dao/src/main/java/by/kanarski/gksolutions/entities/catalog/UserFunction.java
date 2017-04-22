package by.kanarski.gksolutions.entities.catalog;

import by.kanarski.gksolutions.entities.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "user_function_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserFunction extends AbstractEntity {

    private static final long serialVersionUID = -106098994226773605L;
    private String userFunctionName;

    @Builder
    public UserFunction(Integer userFunctionId, String userFunctionName) {
        super(userFunctionId);
        this.userFunctionName = userFunctionName;
    }

    @Column(nullable = false, length = 30)
    public String getUserFunctionName() {
        return userFunctionName;
    }

    public enum Fields {userFunctionName, serialVersionUID}
}
