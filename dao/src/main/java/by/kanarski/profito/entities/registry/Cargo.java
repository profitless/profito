package by.kanarski.profito.entities.registry;

import by.kanarski.profito.entities.AbstractEntity;
import by.kanarski.profito.entities.catalog.LoadingType;
import by.kanarski.profito.entities.catalog.Pallete;
import by.kanarski.profito.entities.catalog.TrailerType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "template_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Cargo extends AbstractEntity {

    private static final long serialVersionUID = -8565197952652747193L;
    private Pallete pallete;
    private Double cargoPalleteQuantity;
    private Request request;
    private String cargoName;
    private Double cargoWeight;
    private Double cargoVolume;
    private TrailerType trailerType;
    private LoadingType loadingType;
    private String cargoFastener;
    private String cargoDangerClass;
    private String cargoInfo;

    @Builder
    public Cargo(Integer cargoId, Pallete pallete, Double cargoPalleteQuantity, Request request,
                 String cargoName, Double cargoWeight, Double cargoVolume, TrailerType trailerType,
                 LoadingType loadingType, String cargoFastener, String cargoDangerClass, String cargoInfo) {
        super(cargoId);
        this.pallete = pallete;
        this.cargoPalleteQuantity = cargoPalleteQuantity;
        this.request = request;
        this.cargoName = cargoName;
        this.cargoWeight = cargoWeight;
        this.cargoVolume = cargoVolume;
        this.trailerType = trailerType;
        this.loadingType = loadingType;
        this.cargoFastener = cargoFastener;
        this.cargoDangerClass = cargoDangerClass;
        this.cargoInfo = cargoInfo;
    }

    @ManyToOne
    @JoinColumn(
            name = "pallete_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_cargo_c_pallete_type1")
    )
    public Pallete getPallete() {
        return pallete;
    }

    @Column
    public Double getCargoPalleteQuantity() {
        return cargoPalleteQuantity;
    }

    @ManyToOne
    @JoinColumn(
            name = "request_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_cargo_r_request1")
    )
    public Request getRequest() {
        return request;
    }

    @Column(length = 200)
    public String getCargoName() {
        return cargoName;
    }

    @Column(nullable = false)
    public Double getCargoWeight() {
        return cargoWeight;
    }

    @Column(nullable = false)
    public Double getCargoVolume() {
        return cargoVolume;
    }

    @ManyToOne
    @JoinColumn(
            name = "trailer_type_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_cargo_c_trailer_type1")
    )
    public TrailerType getTrailerType() {
        return trailerType;
    }

    @ManyToOne
    @JoinColumn(
            name = "loading_type_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_cargo_c_loading_type1")
    )
    public LoadingType getLoadingType() {
        return loadingType;
    }

    @Column(length = 100)
    public String getCargoFastener() {
        return cargoFastener;
    }

    @Column(length = 20)
    public String getCargoDangerClass() {
        return cargoDangerClass;
    }

    @Column
    public String getCargoInfo() {
        return cargoInfo;
    }

    public enum Fields {pallete, cargoPalleteQuantity, request, cargoName, cargoWeight, cargoVolume, trailerType, loadingType, cargoFastener, cargoDangerClass, cargoInfo, serialVersionUID}
}
