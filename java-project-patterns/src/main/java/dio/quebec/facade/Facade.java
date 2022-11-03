package dio.quebec.facade;

import subsystem.cep.CepApi;
import subsystem.crm.CrmService;

public class Facade {

    public void migrateClient(String name, String cep) {
        CepApi cepApi = CepApi.getInstance();
        CrmService.recordClient(name, cep, cepApi.findCity(cep), cepApi.findState(cep));
    }
}
