package com.Esport.Repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.Esport.Modele.Joueur;

public interface JoueurRepository {

    public List<Joueur> findAll();
    public Optional<Joueur> findById(Long id);
    public boolean create(Joueur joueur);
    public boolean update(Joueur joueur);
    public boolean delete(Long id);
}
