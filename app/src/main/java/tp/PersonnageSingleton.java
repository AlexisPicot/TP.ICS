package tp;

import org.springframework.stereotype.Component;

@Component
public class PersonnageSingleton
{
    private Personnage personnage;
    public Personnage getInstance(){
        if(personnage == null){
            personnage = new Personnage("Alexis");
        }
        return personnage;
    }
}
