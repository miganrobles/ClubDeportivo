import java.util.ArrayList;
import java.util.Iterator;
/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    // Define any necessary fields here ...
    // Este atributo almacena los socios del club
    private ArrayList<Membership> socios;
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        socios = new ArrayList<Membership>();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        socios.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return socios.size();
    }

    /** 
     * Calcula el numero de socios que se dieron de alta en un mes determinado. 
     * El año no nos importa. En caso de que el parametro contenga un valor 
     * no valido se muestra por pantalla el error.
     * @param month El mes en el que estamos interesados
     * @return El numero de socios que se dieron de alta dicho mes
     */
    public int joineMonth (int month)
    {
        int numeroSocios = -1;
        if (month >= 1 && month <= 12) {
            numeroSocios = 0;
            for (Membership socio : socios) {
                if (socio.getMonth() == month) {
                    numeroSocios++;
                }
            }
        }
        else {
            System.out.println("El dato introducido para el mes no es válido [1-12]");
        }
        return numeroSocios;
    }

    /** 
     * Todos los socios que se han dado de alta un determinado mes de un determinado año se
     * dan de baja. En caso de que el parametro month contenga un valor no valido se muestra 
     * por pantalla el error.
     * @param month El mes en el que estamos interesados
     * @param year El año en el que estamos interesados
     * @return Una coleccion con los socios que se han dado de baja del club
     */
    public ArrayList<Membership> purge(int month, int year)
    {
        ArrayList<Membership> sociosDeBaja = null;
        if (month >= 1 && month <= 12) {
            sociosDeBaja = new ArrayList<>();
            Iterator<Membership> it = socios.iterator();
            while (it.hasNext()) {
                Membership socio = it.next();
                if (socio.getMonth() == month && socio.getYear() == year) {
                    sociosDeBaja.add(socio);
                    it.remove();
                }
            }
        }
        else {
            System.out.println("El dato introducido para el mes no es válido [1-12]");
        }
        return sociosDeBaja;
    }
}
