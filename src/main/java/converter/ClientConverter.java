package converter;

import dto.ClientDTO;
import model.Client;

import java.time.LocalDate;

public class ClientConverter {

    public ClientDTO toDTO(Client client) {

        ClientDTO dto = new ClientDTO();

        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setEmail(client.getEmail());

        int age = LocalDate.now().getYear() - client.getBirthDate().getYear();

        dto.setAge(age);

        return dto;
    }
}
