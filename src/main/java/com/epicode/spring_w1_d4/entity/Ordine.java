package com.epicode.spring_w1_d4.entity;

import com.epicode.spring_w1_d4.enums.StatoOrdineEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "ordini")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column (name = "stato_ordine")
    private StatoOrdineEnum statoOrdineEnum;

    @Column (name = "coperti_effettivi")
    private int copertiEffettivi;

    @Column (name = "ora_acquisizione")
    private LocalTime oraAcquisizione;

    @Column (name = "importo_totale")
    private Double importoTot;

    @OneToOne
    private Tavolo tavolo;

    @Value ("${application.costo_coperto}")
    double costoCoperto;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ordine_id")
    private List<Menu> elementi;

    public double calcolaImportoTotale() {
        double sommaElementi = elementi.stream().mapToDouble(Menu::getPrezzo).sum();
        sommaElementi = sommaElementi + (copertiEffettivi * costoCoperto);
        this.importoTot = sommaElementi;

        return sommaElementi;
    }

    public String stampa(){
        String prodotti = "";
        for (int i = 0; i < this.getElementi().size(); i++) {
            prodotti += this.getElementi().get(i).stampa();
        }
        String x = "numero ordine: " + this.id + " stato: " + this.statoOrdineEnum + " costoTot: " + this.importoTot + " prodotti: " + prodotti;
        return x;
    }

}