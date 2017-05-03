package edu.cibertec.android.pharmamedic.data;

import java.util.List;

/**
 * Created by Android on 26/11/2016.
 */

public interface PersonaDAO {
    public  long insertarPersona(Persona persona);
    public String searchHelper(String email);
    public List<Persona> listaPersona(Persona persona);
}
