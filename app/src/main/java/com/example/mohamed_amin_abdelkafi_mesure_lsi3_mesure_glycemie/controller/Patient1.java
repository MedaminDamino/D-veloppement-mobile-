package com.example.mohamed_amin_abdelkafi_mesure_lsi3_mesure_glycemie.controller;

public class Patient1 {
    //private static Controller instance = null;
    private static Patient1 patient;
    /*private Controller(){
    super();
    }
    public static final Controller getInstance(){
    if(Controller.instance == null)
    Controller.instance = new Controller();
    return Controller.instance;
    }*/
    public Patient1()
    {
        super();
    }

    public Patient1(int age, float valeurMesuree, boolean isFasting) {

    }

    //Flèche "Update" Controller --> Model
    public void createPatient(int age, float valeurMesuree, boolean isFasting){
        patient = new Patient1(age, valeurMesuree, isFasting);
    }
    //Flèche "Notify" Model --> Controller
    public String getReponse() {
        return patient.getReponse();
    }
}
