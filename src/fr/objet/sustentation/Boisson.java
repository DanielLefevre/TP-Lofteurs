package fr.objet.sustentation;

public class Boisson {

    protected int valeurEnergetiqueLiq;
    

    public Boisson(int valeurEnergetiqueLiqIn) {
        this.setValeurEnergetiqueLiq(valeurEnergetiqueLiqIn);
    }

    public int getValeurEnergetiqueLiq() {
        return this.valeurEnergetiqueLiq;
    }

    public void setValeurEnergetiqueLiq(int valeurEnergetiqueLiqIn) {
        this.valeurEnergetiqueLiq = valeurEnergetiqueLiqIn;
    }
    
    public void boire(int liquideBu){
    	valeurEnergetiqueLiq = valeurEnergetiqueLiq - liquideBu;
    	
    }
    
}
