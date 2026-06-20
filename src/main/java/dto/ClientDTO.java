package dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDTO {

    private Long id;

    private String name;

    private String email;

    private int age;
}