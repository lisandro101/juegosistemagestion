/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juegosistemagestion.entidades;

/**
 *
 * @author Seba
 */
public class Error {

    private double errorAbsoluto;
    private double errorRelativo;
    private double errorRelativoMenor;
    private double errorRelativoMayor;
    private double errorRelativoPromedio;
    private double s;
    private double intervaloDeConfianza;
    private double Sumatoria=0;

    /**
     * @return the errorAbsoluto
     */
    public Error(){};
    public double getErrorAbsoluto() {
        return errorAbsoluto;
    }

    /**
     * @param errorAbsoluto the errorAbsoluto to set
     */
    public void setErrorAbsoluto(double errorAbsoluto) {
        this.errorAbsoluto = errorAbsoluto;
    }

    /**
     * @return the errorRelativo
     */
    public double getErrorRelativo() {
        return errorRelativo;
    }

    /**
     * @param errorRelativo the errorRelativo to set
     */
    public void setErrorRelativo(double errorRelativo) {
        this.errorRelativo = errorRelativo;
    }

    /**
     * @return the errorRelativoMenor
     */
    public double getErrorRelativoMenor() {
        return errorRelativoMenor;
    }

    /**
     * @param errorRelativoMenor the errorRelativoMenor to set
     */
    public void setErrorRelativoMenor(double errorRelativoMenor) {
        this.errorRelativoMenor = errorRelativoMenor;
    }

    /**
     * @return the errorRelativoMayor
     */
    public double getErrorRelativoMayor() {
        return errorRelativoMayor;
    }

    /**
     * @param errorRelativoMayor the errorRelativoMayor to set
     */
    public void setErrorRelativoMayor(double errorRelativoMayor) {
        this.errorRelativoMayor = errorRelativoMayor;
    }

    /**
     * @return the errorRelativoPromedio
     */
    public double getErrorRelativoPromedio() {
        return errorRelativoPromedio;
    }

    /**
     * @param errorRelativoPromedio the errorRelativoPromedio to set
     */
    public void setErrorRelativoPromedio(double errorRelativoPromedio) {
        this.errorRelativoPromedio = errorRelativoPromedio;
    }

    /**
     * @return the s
     */
    public double getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(double s) {
        this.s = s;
    }

    /**
     * @return the intervaloDeConfianza
     */
    public double getIntervaloDeConfianza() {
        return intervaloDeConfianza;
    }

    /**
     * @param intervaloDeConfianza the intervaloDeConfianza to set
     */
    public void setIntervaloDeConfianza(double intervaloDeConfianza) {
        this.intervaloDeConfianza = intervaloDeConfianza;
    }
    public double ErrorAbsoluto(Mochila SolucionExacta, Mochila SolucionHeuristica)
    {
        //MEx: Mochila SolucionExacta:Es la mochila Problema, cuando se le aplica la Solucion Fuerza Bruta.
        //MHeu:Mochila SolucionHeuristica:Conj de Soluciones(cant de Colonias)Heuristica.
        double MEx=SolucionExacta.getBeneficioObtenidoUsuario();
        double MHeu= SolucionHeuristica.getBeneficioObtenidoUsuario();
        errorAbsoluto=Math.abs(MEx-MHeu);
         System.out.println("__El Error Absoluto es:__");
         System.out.println(errorAbsoluto);
         System.out.println("________\n");
        return errorAbsoluto;

    }
     public double ErrorRelativoMenor(Mochila SolucionExacta , Mochila SolucionHeuristica)
    {
       //tengo que buscar del conj de soluciones de Hormiga, buscar LA DE MENOR BENEFICION, Es decir
       //buscar la colonia que obtubo el menor benefico.
       //ARIEL, ESTOY AHY QUE COORDINARLO, VOS Y YO.
       //Busco ahora, si el valor actual de la solucion es Menor a la Guardada
         errorRelativoMenor=SolucionHeuristica.getBeneficioMenor();
       if(SolucionHeuristica.getBeneficioObtenidoUsuario()<SolucionHeuristica.getBeneficioMenor())
       {
       errorRelativoMenor=SolucionHeuristica.getBeneficioObtenidoUsuario();
       SolucionHeuristica.setBeneficioMenor(errorRelativoMenor);
       }
       double MEx=SolucionExacta.getBeneficioMenor();
       double MHeuMen= SolucionHeuristica.getBeneficioMenor();
       errorRelativoMenor=MEx-MHeuMen;
       System.out.println("__El Error Relativo Menor es:__");
       System.out.println(errorRelativoMenor);
       System.out.println("________\n");
         return errorRelativoMenor;

    }
      public double ErrorRelativoMayor(Mochila SolucionExacta ,Mochila SolucionHeuristica)
    {
       //tengo que buscar del conj de soluciones de Hormiga, buscar LA DE MAYOR BENEFICION, Es decir
       //buscar la colonia que obtubo el MAYOR benefico.
       //ARIEL, ESTOY AHY QUE COORDINARLO, VOS Y YO.

          errorRelativoMayor=SolucionHeuristica.getBeneficioMayor();
       if(SolucionHeuristica.getBeneficioObtenidoUsuario()>SolucionHeuristica.getBeneficioMayor())
       {
       errorRelativoMayor=SolucionHeuristica.getBeneficioObtenidoUsuario();
       SolucionHeuristica.setBeneficioMayor(errorRelativoMayor);
       }
       double MEx=SolucionExacta.getBeneficioMayor();
       double MHeuMay= SolucionHeuristica.getBeneficioMayor();
       errorRelativoMayor=MEx-MHeuMay;
       System.out.println("__El Error Relativo Mayor es:__");
       System.out.println(errorRelativoMayor);
       System.out.println("________\n");
         return errorRelativoMayor;

    }
     public double ErrorRelativoPromedio( Mochila SolucionHeuristica)
    {
       //Calcula el Error Promedio entre el Mejor Error Ralatico y el Menor.
         double ERMay=SolucionHeuristica.getBeneficioMayor();
         double ERMen=SolucionHeuristica.getBeneficioMenor();
         errorRelativoPromedio=((ERMay-ERMen)/2);
         System.out.println("__El Error Relativo Promedio es:__");
         System.out.println(errorRelativoPromedio);
         System.out.println("________\n");
         return errorRelativoPromedio;
    }
      public double S( Mochila SolucionHeuristica)
    {

       double ERP = this.ErrorRelativoPromedio(SolucionHeuristica);
       double M= SolucionHeuristica.getCapacidad();
       
       Sumatoria= (Math.pow(SolucionHeuristica.getBeneficioObtenidoUsuario()-ERP,2))+ Sumatoria;
       s=((1/M-1)*Sumatoria);
       System.out.println("__El Valor de S es :__");
       System.out.println(s);
       System.out.println("________\n");
         return s;

    }
     public double IntervaloDeConfiaza( Mochila SolucionHeuristica)
    {
 double IntConf;
 double M=SolucionHeuristica.getCapacidad();
 intervaloDeConfianza= errorRelativoPromedio +(1.96*(s/(Math.sqrt(M))));
       //dudas para implementar a coordinar con ARIEL.
         return intervaloDeConfianza;

    }
   








}
