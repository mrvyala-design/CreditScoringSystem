package util;

import dao.ClientDAO;
import dao.impl.ClientDAOImpl;
import jakarta.persistence.EntityManager;
import model.Client;
import model.CreditHistory;
import model.Employment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataInitializer {

    private static final Random random = new Random();

    private final ClientDAO clientDao = new ClientDAOImpl();

    public void init() {

        EntityManager em = HibernateUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            List<Client> clients = new ArrayList<>();

            for (int i = 1; i <= 100; i++) {

                Client client = new Client();
                client.setName("Client_" + i);
                client.setEmail("client" + i + "@gmail.com");

                int age = 18 + random.nextInt(67);
                client.setBirthDate(LocalDate.now().minusYears(age));

                Employment employment = new Employment();
                employment.setSalary(1000 + random.nextDouble() * 7000);
                employment.setExperienceYears(random.nextInt(10));
                employment.setClient(client);

                List<Employment> jobs = new ArrayList<>();
                jobs.add(employment);
                client.setEmployments(jobs);

                CreditHistory history = new CreditHistory();
                history.setActiveLoans(random.nextInt(3));
                history.setOverdueCount(random.nextInt(3));
                history.setClient(client);

                client.setCreditHistory(history);

                clients.add(client);

                clientDao.save(em, client);
            }

            em.getTransaction().commit();

            System.out.println("Database initialized with clients: " + clients.size());

        } finally {
            em.close();
        }
    }
}
