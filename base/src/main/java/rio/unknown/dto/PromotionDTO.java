package rio.unknown.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PromotionDTO implements Serializable {

    private static final long serialVersionUID = 1707675136575974513L;

    private boolean isValid;
}
