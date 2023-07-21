import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate birthDay;
    private LocalDate deathDay;
    private Human spouse;
    private List<Human> children = new ArrayList<>();
    private List<Human> parents = new ArrayList<>();


    public Human(String name, LocalDate birthDay, LocalDate deathDay){
        this.name = name;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.spouse = null;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public Human(String name, LocalDate birthDay){
        this(name, birthDay, null);
    }

    public void marry(Human partner){
        if(this.spouse == null || partner.spouse == null) {
            this.spouse = partner;
            partner.spouse = this;
        }
    }

    public void addChild(Human child) {
        if(!children.contains(child)){
            children.add(child);
        }
    }

    public void addParent(Human parent) {
        if(!parents.contains(parent)){
            parents.add(parent);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" {");
        if(deathDay == null){
            sb.append("Дата рождения: ");
            sb.append(birthDay);
        }
        else {
            sb.append("Дата жизни: ");
            sb.append(birthDay);
            sb.append(" - ");
            sb.append(deathDay);
        }
        if(spouse != null){
            sb.append("; ");
            sb.append("Супруг(а): ");
            sb.append(spouse.name);
        }
        if(!parents.isEmpty()) {
            sb.append("; ");
            sb.append("Родители: ");
            for(int i=0; i<parents.size();){
                sb.append(parents.get(i).name);
                if(++i<parents.size()){
                    sb.append(", ");
                }
            }
        }
        if(!children.isEmpty()) {
            sb.append("; ");
            sb.append("Дети: ");
            for(int i=0; i<children.size();){
                sb.append(children.get(i).name);
                if(++i<children.size()){
                    sb.append(", ");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }
}