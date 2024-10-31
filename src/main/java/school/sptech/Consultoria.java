package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
        this.desenvolvedores = new ArrayList<>();
    }
    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (vagas != null && desenvolvedores.size() < vagas && desenvolvedor != null) {
            desenvolvedores.add(desenvolvedor);
        }
    }


    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack() && desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios() {
        Double totalSalario = 0.0;
        for (Desenvolvedor dev : desenvolvedores) {
            totalSalario += dev.calcularSalario();
        }
        return totalSalario;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer contador = 0;
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev.getClass() == DesenvolvedorMobile.class) {
                contador++;
            }
        }
        return contador;
    }


    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> resultado = new ArrayList<>();
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev.calcularSalario() >= salario) {
                resultado.add(dev);
            }
        }
        return resultado;
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty()) {
            return null;
        }


        Desenvolvedor menorSalarioDev = desenvolvedores.get(0);
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev.calcularSalario() < menorSalarioDev.calcularSalario()) {
                menorSalarioDev = dev;
            }
        }
        return menorSalarioDev;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> resultado = new ArrayList<>();
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb webDev = (DesenvolvedorWeb) dev;
                if (tecnologia.equalsIgnoreCase(webDev.getFrontend()) ||
                        tecnologia.equalsIgnoreCase(webDev.getBackend()) ||
                        tecnologia.equalsIgnoreCase(webDev.getSgbd())) {
                    resultado.add(dev);
                }
            } else if (dev instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile mobileDev = (DesenvolvedorMobile) dev;
                if (tecnologia.equalsIgnoreCase(mobileDev.getPlataforma()) ||
                        tecnologia.equalsIgnoreCase(mobileDev.getLinguagem())) {
                    resultado.add(dev);
                }
            }
        }
        return resultado;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        Double totalSalario = 0.0;
        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb devWeb = (DesenvolvedorWeb) dev;
                if (tecnologia.equalsIgnoreCase(devWeb.getFrontend()) ||
                        tecnologia.equalsIgnoreCase(devWeb.getBackend()) ||
                        tecnologia.equalsIgnoreCase(devWeb.getSgbd())) {
                    totalSalario += devWeb.calcularSalario();
                }
            } else if (dev instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile devMobile = (DesenvolvedorMobile) dev;
                if (tecnologia.equalsIgnoreCase(devMobile.getPlataforma()) ||
                        tecnologia.equalsIgnoreCase(devMobile.getLinguagem())) {
                    totalSalario += devMobile.calcularSalario();
                }
            }
        }
        return totalSalario;
    }

}
