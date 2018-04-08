package model;

import java.util.ArrayList;
import java.util.List;

public class Eletronico extends Produto {

    private List<Eletronico> similhares;

    public Eletronico(int id, int quantidade, int preco, Departamento departamento) {
        super(id, quantidade, preco, departamento);
        this.similhares = new ArrayList<>();
    }

    public List<Eletronico> getSimilhares() {
        return similhares;
    }

    public void addSimilihar(Eletronico similhar) {
        this.similhares.add(similhar);
    }

    public void removeSimilhar(Eletronico similhar) {
        this.similhares.remove(similhar);
    }
}
