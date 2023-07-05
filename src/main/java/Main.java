import Servise.ClientCrudService;
import Servise.HibernateUtil;
import Servise.PlanetCrudService;
import entity.Client;
import entity.Planet;
import org.flywaydb.core.Flyway;

import java.util.Optional;


public class Main {

    public static void main(String[] args) {
        final String url = "jdbc:h2:./mod10DMyHibernate;TRACE_LEVEL_FILE=3;TRACE_MAX_FILE_SIZE=10";
        final String user = "";
        final String password = "";

        Flyway flyway = Flyway.configure().dataSource(url, user, password).load();
        flyway.migrate();

        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        System.out.println(clientCrudService.get(2L));
        Client client = clientCrudService.get(4L).orElseThrow();
        client.setName("Update Name");
        clientCrudService.update(client);
        System.out.println(clientCrudService.get(4L));
        Client newClient = Client.builder().name("New client").build();
        clientCrudService.create(newClient);
        System.out.println(clientCrudService.get(11L));
        clientCrudService.delete(Client.builder().id(6L).build());
        System.out.println(clientCrudService.get(6L));

        System.out.println("Planet with ID 'CAL': " + planetCrudService.get("CAL"));
        Planet planet = planetCrudService.get("Wolf 1061c").orElseThrow();
        planet.setName("Updated Planet");
        Optional<Planet> planetOptional = planetCrudService.get("Wolf 1061c");
        if (planetOptional.isPresent()) {
            Planet object = planetOptional.get();
            planet.setName("UpdatedPlanet");
            planetCrudService.update(object);
            System.out.println("Planet with ID 'Wolf 1061c' after update: " + planetCrudService.get("Wolf 1061c"));
            planetCrudService.create(Planet.builder().id("Test").name("New_Planet").build());
            planetCrudService.delete(planetCrudService.get("PEG").orElseThrow());
            System.out.println("Planet with ID 'PEG' after delete: " + planetCrudService.get("PEG"));
        }

        System.out.println(planetCrudService.get("CAL"));

        HibernateUtil.getInstance().close();
    }
}

