package lee.atm.mybankingapp.mvc;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class TransactionAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount20;
    private double amount50;
    private double amount100;
    private double amount250;
    private double amount500;
    private double custom;

}
