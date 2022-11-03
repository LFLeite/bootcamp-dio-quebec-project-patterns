package subsystem.cep;

import dio.quebec.singleton.EagerSingleton;

public class CepApi {

    private static final CepApi instance = new CepApi();;
    private CepApi() { super(); }
    public static CepApi getInstance() { return instance; }

    public String findCity(String cep) {
        return "Sao Paulo";
    }

    public String findState(String cep) {
        return "SP";
    }
}
