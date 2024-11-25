package esercizio3;

import esercizio2.ConsumoCarburante;
import esercizio2.ValoreLitriNonValido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContoCorrente {
    private String titolare;
    private int nMovimenti;
    private final int maxMovimenti = 50;
    private double saldo;

    private final static Logger LOGGER = LoggerFactory.getLogger(ConsumoCarburante.class);

    public ContoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        this.nMovimenti = 0;
    }

    public void preleva(double x) {
        try{

            if (nMovimenti < maxMovimenti)
                saldo = saldo - x;
            else
                saldo = saldo - x - 0.50;
            verifiSaldo(saldo);
            nMovimenti++;
        }catch(BancaException e) {
            LOGGER.error(e.getMessage());
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public double restituisciSaldo() {
        return saldo;
    }

    public String getTitolare() {
        return titolare;
    }

    public int getnMovimenti() {
        return nMovimenti;
    }

    public int getMaxMovimenti() {
        return maxMovimenti;
    }


    private static void  verifiSaldo(double saldo){
        if(saldo <= 0){
            throw new BancaException("Conto in rosso");
        }
    }
}
